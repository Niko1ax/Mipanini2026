package com.example.mipanini2026.activities;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mipanini2026.R;
import android.database.sqlite.SQLiteConstraintException;

import com.example.mipanini2026.room.DatabaseExecutor;
import com.example.mipanini2026.room.database.PaniniDatabase;
import com.example.mipanini2026.room.entity.UsuarioEntity;


public class RegisterActivity extends AppCompatActivity {

    private EditText etNombre;
    private EditText etUsuario;
    private EditText etEmailRegistro;
    private EditText etPasswordRegistro;
    private EditText etConfirmarPassword;

    private Button btnCrearCuenta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        etNombre = findViewById(R.id.etNombre);
        etUsuario = findViewById(R.id.etUsuario);
        etEmailRegistro = findViewById(R.id.etEmailRegistro);
        etPasswordRegistro = findViewById(R.id.etPasswordRegistro);
        etConfirmarPassword = findViewById(R.id.etConfirmarPassword);

        btnCrearCuenta = findViewById(R.id.btnCrearCuenta);

        btnCrearCuenta.setOnClickListener(v -> validarRegistro());
    }

    private void validarRegistro() {

        String nombre = etNombre.getText().toString().trim();
        String usuario = etUsuario.getText().toString().trim();
        String email = etEmailRegistro.getText().toString().trim();
        String password = etPasswordRegistro.getText().toString().trim();
        String confirmar = etConfirmarPassword.getText().toString().trim();

        if (TextUtils.isEmpty(nombre)) {
            etNombre.setError("Ingrese su nombre");
            etNombre.requestFocus();
            return;
        }

        if (TextUtils.isEmpty(usuario)) {
            etUsuario.setError("Ingrese un usuario");
            etUsuario.requestFocus();
            return;
        }

        if (TextUtils.isEmpty(email)) {
            etEmailRegistro.setError("Ingrese un email");
            etEmailRegistro.requestFocus();
            return;
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            etEmailRegistro.setError("Email inválido");
            etEmailRegistro.requestFocus();
            return;
        }

        if (TextUtils.isEmpty(password)) {
            etPasswordRegistro.setError("Ingrese una contraseña");
            etPasswordRegistro.requestFocus();
            return;
        }

        if (password.length() < 6) {
            etPasswordRegistro.setError("Mínimo 6 caracteres");
            etPasswordRegistro.requestFocus();
            return;
        }

        if (!password.equals(confirmar)) {
            etConfirmarPassword.setError("Las contraseñas no coinciden");
            etConfirmarPassword.requestFocus();
            return;
        }

        UsuarioEntity nuevoUsuario = new UsuarioEntity(
                nombre,
                usuario,
                email,
                password
        );

        DatabaseExecutor.getExecutor().execute(() -> {

            try {

                PaniniDatabase database =
                        PaniniDatabase.getInstancia(getApplicationContext());

                database.usuarioDao().insertar(nuevoUsuario);

                runOnUiThread(() -> {

                    Toast.makeText(
                            RegisterActivity.this,
                            "Cuenta creada correctamente",
                            Toast.LENGTH_SHORT
                    ).show();

                    finish();
                });

            } catch (SQLiteConstraintException exception) {

                runOnUiThread(() -> Toast.makeText(
                        RegisterActivity.this,
                        "El email o usuario ya está registrado",
                        Toast.LENGTH_SHORT
                ).show());

            } catch (Exception exception) {

                runOnUiThread(() -> Toast.makeText(
                        RegisterActivity.this,
                        "No se pudo crear la cuenta",
                        Toast.LENGTH_SHORT
                ).show());
            }
        });

        finish();
    }
}