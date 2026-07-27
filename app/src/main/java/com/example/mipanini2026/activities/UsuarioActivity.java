package com.example.mipanini2026.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mipanini2026.R;
import com.example.mipanini2026.room.DatabaseExecutor;
import com.example.mipanini2026.room.database.PaniniDatabase;
import com.example.mipanini2026.room.entity.UsuarioEntity;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class UsuarioActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usuario);

        TextView txtNombre = findViewById(R.id.txtNombre);
        TextView txtUsuario = findViewById(R.id.txtUsuario);
        TextView txtEmail = findViewById(R.id.txtEmail);

        TextView txtConseguidas = findViewById(R.id.txtConseguidas);
        TextView txtFaltantes = findViewById(R.id.txtFaltantes);
        TextView txtPorcentaje = findViewById(R.id.txtPorcentaje);
        TextView txtMotivacion = findViewById(R.id.txtMotivacion);

        ProgressBar progreso = findViewById(R.id.progresoAlbum);

        Button btnCerrarSesion = findViewById(R.id.btnCerrarSesion);

        SharedPreferences prefs = getSharedPreferences("panini", MODE_PRIVATE);

        String emailLogueado = prefs.getString("email_logueado", "");

        txtNombre.setText("Usuario");
        txtUsuario.setText("@usuario");
        txtEmail.setText(emailLogueado);

        DatabaseExecutor.getExecutor().execute(() -> {

            UsuarioEntity usuario = PaniniDatabase
                    .getInstancia(getApplicationContext())
                    .usuarioDao()
                    .buscarPorEmail(emailLogueado);

            runOnUiThread(() -> {

                if (usuario != null) {
                    txtNombre.setText(usuario.getNombre());
                    txtUsuario.setText("@" + usuario.getUsuario());
                    txtEmail.setText(usuario.getEmail());
                }
            });
        });

        int conseguidas = 0;

        String[] claves = {

                "Argentina_Emiliano Martinez",
                "Argentina_Nahuel Molina",
                "Argentina_Cristian Romero",
                "Argentina_Nicolas Otamendi",
                "Argentina_Nicolas Tagliafico",
                "Argentina_Leonardo Balerdi",
                "Argentina_Enzo Fernández",
                "Argentina_Alexis Mac allister",
                "Argentina_Rodrigo De Paul",
                "Argentina_Exequiel Palacios",
                "Argentina_Leandro Paredes",
                "Argentina_Nicolas Paz",
                "Argentina_Franco Mastantuono",
                "Argentina_Nicolas Gonzalez",
                "Argentina_Lionel Messi",
                "Argentina_Lautaro Martinez",
                "Argentina_Julián Álvarez",
                "Argentina_Giuliano Simeone",

                "Brasil_Alisson becker",
                "Brasil_Bento",
                "Brasil_Marquinhos",
                "Brasil_Éder Militão",
                "Brasil_Gabriel Magalhães",
                "Brasil_Danilo",
                "Brasil_Wesley",
                "Brasil_Lucas Paquetá",
                "Brasil_Casemiro",
                "Brasil_Bruno Guimarães",
                "Brasil_Luiz Henrique",
                "Brasil_Vinicius Júnior",
                "Brasil_Rodrygo",
                "Brasil_João Pedro",
                "Brasil_Matheus Cunha",
                "Brasil_Gabriel Martinelli",
                "Brasil_Raphinha",
                "Brasil_Estêvão",

                "Francia_Mike Maignan",
                "Francia_Theo Hernandez",
                "Francia_William Saliba",
                "Francia_Jules Kounde",
                "Francia_Ibrahima Konate",
                "Francia_Dayot Upamecano",
                "Francia_Lucas Digne",
                "Francia_Aurélien Tchouaméni",
                "Francia_Eduardo Camavinga",
                "Francia_Manu Kone",
                "Francia_Adrien Rabiot",
                "Francia_Michael Olise",
                "Francia_Ousmane Dembele",
                "Francia_Bradley Barcola",
                "Francia_Désiré Doué",
                "Francia_Kingsley Coman",
                "Francia_Hugo Ekitike",
                "Francia_Kylian Mbappe",

                "España_Unai Simon",
                "España_Robin Le Normand",
                "España_Aymeric Laporte",
                "España_Dean Huijsen",
                "España_Pedro Porro",
                "España_Dani Carvajal",
                "España_Marc Cucurella",
                "España_Martín Zubimendi",
                "España_Rodri",
                "España_Pedri",
                "España_Fabian Ruiz",
                "España_Mikel Merino",
                "España_Lamine Yamal",
                "España_Dani Olmo",
                "España_Nico Williams",
                "España_Ferran Torres",
                "España_Álvaro Morata",
                "España_Mikel Oyarzabal",

                "Alemania_Marc-André ter Stegen",
                "Alemania_Jonathan Tah",
                "Alemania_David Raum",
                "Alemania_Nico Schlotterbeck",
                "Alemania_Antonio Rüdiger",
                "Alemania_Waldemar Anton",
                "Alemania_Ridle Baku",
                "Alemania_Maximilian Mittelstadt",
                "Alemania_Joshua Kimmich",
                "Alemania_Florian Wirtz",
                "Alemania_Felix Nmecha",
                "Alemania_Leon Goretzka",
                "Alemania_Jamal Musiala",
                "Alemania_Serge Gnabry",
                "Alemania_Kai Havertz",
                "Alemania_Leroy Sane",
                "Alemania_Karim Adeyemi",
                "Alemania_Nick Woltemade"
        };

        int totalFiguritas = claves.length;

        for (String clave : claves) {
            if (prefs.getBoolean(emailLogueado + "_" + clave, false)) {
                conseguidas++;
            }
        }

        int faltantes = totalFiguritas - conseguidas;

        int porcentaje = 0;

        if (totalFiguritas > 0) {
            porcentaje = (conseguidas * 100) / totalFiguritas;
        }

        txtConseguidas.setText(String.valueOf(conseguidas));
        txtFaltantes.setText(String.valueOf(faltantes));
        txtPorcentaje.setText("Álbum completado: " + porcentaje + "%");

        progreso.setProgress(porcentaje);

        String mensaje;

        if (porcentaje == 100) {

            mensaje = "🏆 ¡Felicitaciones! Completaste el álbum.";

        } else if (porcentaje >= 75) {

            mensaje = "🔥 Ya casi terminás el álbum.";

        } else if (porcentaje >= 50) {

            mensaje = "⚽ Vas muy bien, seguí así.";

        } else if (porcentaje >= 25) {

            mensaje = "📖 Tu colección está creciendo.";

        } else {

            mensaje = "🚀 Empezaste el camino hacia completar el álbum.";
        }

        txtMotivacion.setText(mensaje);

        btnCerrarSesion.setOnClickListener(v -> {

            prefs.edit()
                    .remove("email_logueado")
                    .apply();

            Intent intent =
                    new Intent(
                            UsuarioActivity.this,
                            LoginActivity.class
                    );

            startActivity(intent);
            finish();

        });

        BottomNavigationView nav = findViewById(R.id.bottomNavigation);

        nav.setSelectedItemId(R.id.nav_usuario);

        nav.setOnItemSelectedListener(item -> {

            if (item.getItemId() == R.id.nav_album) {

                startActivity(
                        new Intent(
                                UsuarioActivity.this,
                                MiPaniniActivity.class
                        )
                );

                return true;
            }

            if (item.getItemId() == R.id.nav_faltantes) {

                startActivity(
                        new Intent(
                                UsuarioActivity.this,
                                FaltantesActivity.class
                        )
                );

                return true;
            }

            return true;
        });
    }
}