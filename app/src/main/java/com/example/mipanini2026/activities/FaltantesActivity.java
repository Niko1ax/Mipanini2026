package com.example.mipanini2026.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mipanini2026.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class FaltantesActivity extends AppCompatActivity {

    private ArrayList<String> faltantes;
    private String emailLogueado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faltantes);

        ListView listaFaltantes = findViewById(R.id.listaFaltantes);

        SharedPreferences prefs = getSharedPreferences("panini", MODE_PRIVATE);

        emailLogueado = prefs.getString("email_logueado", "");

        faltantes = new ArrayList<>();

        agregarSeleccionArgentina(prefs);
        agregarSeleccionBrasil(prefs);
        agregarSeleccionFrancia(prefs);
        agregarSeleccionEspana(prefs);
        agregarSeleccionAlemania(prefs);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                R.layout.item_faltante,
                R.id.txtFaltante,
                faltantes
        );

        listaFaltantes.setAdapter(adapter);

        BottomNavigationView nav = findViewById(R.id.bottomNavigation);

        nav.setSelectedItemId(R.id.nav_faltantes);

        nav.setOnItemSelectedListener(item -> {

            if (item.getItemId() == R.id.nav_album) {
                startActivity(new Intent(FaltantesActivity.this, MiPaniniActivity.class));
                return true;
            }

            if (item.getItemId() == R.id.nav_usuario) {
                startActivity(new Intent(FaltantesActivity.this, UsuarioActivity.class));
                return true;
            }

            return true;
        });
    }

    private void agregarSeleccionArgentina(SharedPreferences prefs) {

        ArrayList<String> jugadores = new ArrayList<>();

        verificarJugador(prefs, jugadores, "Argentina", "Lionel Messi");
        verificarJugador(prefs, jugadores, "Argentina", "Julián Álvarez");
        verificarJugador(prefs, jugadores, "Argentina", "Lautaro Martinez");
        verificarJugador(prefs, jugadores, "Argentina", "Rodrigo De Paul");
        verificarJugador(prefs, jugadores, "Argentina", "Enzo Fernández");
        verificarJugador(prefs, jugadores, "Argentina", "Emiliano Martinez");
        verificarJugador(prefs, jugadores, "Argentina", "Leonardo Balerdi");
        verificarJugador(prefs, jugadores, "Argentina", "Cristian Romero");
        verificarJugador(prefs, jugadores, "Argentina", "Alexis Mac allister");
        verificarJugador(prefs, jugadores, "Argentina", "Exequiel Palacios");
        verificarJugador(prefs, jugadores, "Argentina", "Franco Mastantuono");
        verificarJugador(prefs, jugadores, "Argentina", "Giuliano Simeone");
        verificarJugador(prefs, jugadores, "Argentina", "Nahuel Molina");
        verificarJugador(prefs, jugadores, "Argentina", "Leandro Paredes");
        verificarJugador(prefs, jugadores, "Argentina", "Nicolas Gonzalez");
        verificarJugador(prefs, jugadores, "Argentina", "Nicolas Otamendi");
        verificarJugador(prefs, jugadores, "Argentina", "Nicolas Paz");
        verificarJugador(prefs, jugadores, "Argentina", "Nicolas Tagliafico");

        agregarGrupo("🇦🇷 ARGENTINA", jugadores);
    }

    private void agregarSeleccionBrasil(SharedPreferences prefs) {

        ArrayList<String> jugadores = new ArrayList<>();

        verificarJugador(prefs, jugadores, "Brasil", "Alisson becker");
        verificarJugador(prefs, jugadores, "Brasil", "Bento");
        verificarJugador(prefs, jugadores, "Brasil", "Marquinhos");
        verificarJugador(prefs, jugadores, "Brasil", "Éder Militão");
        verificarJugador(prefs, jugadores, "Brasil", "Gabriel Magalhães");
        verificarJugador(prefs, jugadores, "Brasil", "Danilo");
        verificarJugador(prefs, jugadores, "Brasil", "Wesley");
        verificarJugador(prefs, jugadores, "Brasil", "Lucas Paquetá");
        verificarJugador(prefs, jugadores, "Brasil", "Casemiro");
        verificarJugador(prefs, jugadores, "Brasil", "Bruno Guimarães");
        verificarJugador(prefs, jugadores, "Brasil", "Luiz Henrique");
        verificarJugador(prefs, jugadores, "Brasil", "Vinicius Júnior");
        verificarJugador(prefs, jugadores, "Brasil", "Rodrygo");
        verificarJugador(prefs, jugadores, "Brasil", "João Pedro");
        verificarJugador(prefs, jugadores, "Brasil", "Matheus Cunha");
        verificarJugador(prefs, jugadores, "Brasil", "Gabriel Martinelli");
        verificarJugador(prefs, jugadores, "Brasil", "Raphinha");
        verificarJugador(prefs, jugadores, "Brasil", "Estêvão");

        agregarGrupo("🇧🇷 BRASIL", jugadores);
    }

    private void agregarSeleccionFrancia(SharedPreferences prefs) {

        ArrayList<String> jugadores = new ArrayList<>();

        verificarJugador(prefs, jugadores, "Francia", "Mike Maignan");
        verificarJugador(prefs, jugadores, "Francia", "Theo Hernandez");
        verificarJugador(prefs, jugadores, "Francia", "William Saliba");
        verificarJugador(prefs, jugadores, "Francia", "Jules Kounde");
        verificarJugador(prefs, jugadores, "Francia", "Ibrahima Konate");
        verificarJugador(prefs, jugadores, "Francia", "Dayot Upamecano");
        verificarJugador(prefs, jugadores, "Francia", "Lucas Digne");
        verificarJugador(prefs, jugadores, "Francia", "Aurélien Tchouaméni");
        verificarJugador(prefs, jugadores, "Francia", "Eduardo Camavinga");
        verificarJugador(prefs, jugadores, "Francia", "Manu Kone");
        verificarJugador(prefs, jugadores, "Francia", "Adrien Rabiot");
        verificarJugador(prefs, jugadores, "Francia", "Michael Olise");
        verificarJugador(prefs, jugadores, "Francia", "Ousmane Dembele");
        verificarJugador(prefs, jugadores, "Francia", "Bradley Barcola");
        verificarJugador(prefs, jugadores, "Francia", "Désiré Doué");
        verificarJugador(prefs, jugadores, "Francia", "Kingsley Coman");
        verificarJugador(prefs, jugadores, "Francia", "Hugo Ekitike");
        verificarJugador(prefs, jugadores, "Francia", "Kylian Mbappe");

        agregarGrupo("🇫🇷 FRANCIA", jugadores);
    }

    private void agregarSeleccionEspana(SharedPreferences prefs) {

        ArrayList<String> jugadores = new ArrayList<>();

        verificarJugador(prefs, jugadores, "España", "Unai Simon");
        verificarJugador(prefs, jugadores, "España", "Robin Le Normand");
        verificarJugador(prefs, jugadores, "España", "Aymeric Laporte");
        verificarJugador(prefs, jugadores, "España", "Dean Huijsen");
        verificarJugador(prefs, jugadores, "España", "Pedro Porro");
        verificarJugador(prefs, jugadores, "España", "Dani Carvajal");
        verificarJugador(prefs, jugadores, "España", "Marc Cucurella");
        verificarJugador(prefs, jugadores, "España", "Martín Zubimendi");
        verificarJugador(prefs, jugadores, "España", "Rodri");
        verificarJugador(prefs, jugadores, "España", "Pedri");
        verificarJugador(prefs, jugadores, "España", "Fabian Ruiz");
        verificarJugador(prefs, jugadores, "España", "Mikel Merino");
        verificarJugador(prefs, jugadores, "España", "Lamine Yamal");
        verificarJugador(prefs, jugadores, "España", "Dani Olmo");
        verificarJugador(prefs, jugadores, "España", "Nico Williams");
        verificarJugador(prefs, jugadores, "España", "Ferran Torres");
        verificarJugador(prefs, jugadores, "España", "Álvaro Morata");
        verificarJugador(prefs, jugadores, "España", "Mikel Oyarzabal");

        agregarGrupo("🇪🇸 ESPAÑA", jugadores);
    }

    private void agregarSeleccionAlemania(SharedPreferences prefs) {

        ArrayList<String> jugadores = new ArrayList<>();

        verificarJugador(prefs, jugadores, "Alemania", "Jamal Musiala");
        verificarJugador(prefs, jugadores, "Alemania", "Marc-André ter Stegen");
        verificarJugador(prefs, jugadores, "Alemania", "Jonathan Tah");
        verificarJugador(prefs, jugadores, "Alemania", "David Raum");
        verificarJugador(prefs, jugadores, "Alemania", "Nico Schlotterbeck");
        verificarJugador(prefs, jugadores, "Alemania", "Antonio Rüdiger");
        verificarJugador(prefs, jugadores, "Alemania", "Waldemar Anton");
        verificarJugador(prefs, jugadores, "Alemania", "Ridle Baku");
        verificarJugador(prefs, jugadores, "Alemania", "Maximilian Mittelstadt");
        verificarJugador(prefs, jugadores, "Alemania", "Joshua Kimmich");
        verificarJugador(prefs, jugadores, "Alemania", "Florian Wirtz");
        verificarJugador(prefs, jugadores, "Alemania", "Felix Nmecha");
        verificarJugador(prefs, jugadores, "Alemania", "Leon Goretzka");
        verificarJugador(prefs, jugadores, "Alemania", "Serge Gnabry");
        verificarJugador(prefs, jugadores, "Alemania", "Kai Havertz");
        verificarJugador(prefs, jugadores, "Alemania", "Leroy Sane");
        verificarJugador(prefs, jugadores, "Alemania", "Karim Adeyemi");
        verificarJugador(prefs, jugadores, "Alemania", "Nick Woltemade");

        agregarGrupo("🇩🇪 ALEMANIA", jugadores);
    }

    private void verificarJugador(
            SharedPreferences prefs,
            ArrayList<String> jugadores,
            String seleccion,
            String jugador
    ) {

        boolean conseguido = prefs.getBoolean(
                emailLogueado + "_" + seleccion + "_" + jugador,
                false
        );

        if (!conseguido) {
            jugadores.add("   • " + jugador);
        }
    }

    private void agregarGrupo(String titulo, ArrayList<String> jugadores) {

        if (jugadores.size() > 0) {
            faltantes.add("");
            faltantes.add(titulo);
            faltantes.addAll(jugadores);
        }
    }
}