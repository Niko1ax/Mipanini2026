package com.example.mipanini2026.activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.example.mipanini2026.R;

public class MainActivity extends AppCompatActivity {

    private Button btnMiPanini;
    private Button btnFaltantes;
    private Button btnMiUsuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        btnMiPanini = findViewById(R.id.btnMiPanini);
        btnFaltantes = findViewById(R.id.btnFaltantes);
        btnMiUsuario = findViewById(R.id.btnMiUsuario);

        btnMiPanini.setOnClickListener(v ->
                startActivity(new Intent(this, MiPaniniActivity.class)));

        btnFaltantes.setOnClickListener(v ->
                startActivity(new Intent(this, FaltantesActivity.class)));

        btnMiUsuario.setOnClickListener(v ->
                startActivity(new Intent(this, UsuarioActivity.class)));
    }
}