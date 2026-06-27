package com.example.mipanini2026.activities;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mipanini2026.R;
import com.example.mipanini2026.adapters.JugadorAdapter;
import com.example.mipanini2026.models.Jugador;

import java.util.ArrayList;

import android.widget.ImageButton;

public class JugadoresActivity extends AppCompatActivity {

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }

    private ArrayList<Jugador> jugadores;
    private SharedPreferences prefs;
    private int obtenerBanderaSeleccion(String seleccion) {
        if ("Argentina".equals(seleccion)) {
            return R.drawable.bandera_argentina;
        } else if ("Brasil".equals(seleccion)) {
            return R.drawable.bandera_brasil;
        } else if ("Francia".equals(seleccion)) {
            return R.drawable.bandera_francia;
        } else if ("España".equals(seleccion)) {
            return R.drawable.bandera_espana;
        } else if ("Alemania".equals(seleccion)) {
            return R.drawable.bandera_alemania;
        }

        return R.drawable.bandera_argentina;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jugadores);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        prefs = getSharedPreferences("panini", MODE_PRIVATE);

        String emailLogueado = prefs.getString("email_logueado", "");

        String seleccion = getIntent().getStringExtra("seleccion");

        TextView titulo = findViewById(R.id.txtTituloSeleccion);
        ImageView imgBanderaHeader = findViewById(R.id.imgBanderaHeader);

        titulo.setText(seleccion);
        imgBanderaHeader.setImageResource(obtenerBanderaSeleccion(seleccion));

        ListView listaJugadores =
                findViewById(R.id.listaJugadores);

        jugadores = new ArrayList<>();

        if ("Argentina".equals(seleccion)) {

            jugadores.add(new Jugador("Lionel Messi", R.drawable.lionel_messi));
            jugadores.add(new Jugador("Julián Álvarez", R.drawable.julian_alvarez));
            jugadores.add(new Jugador("Lautaro Martinez", R.drawable.lautaro_martinez));
            jugadores.add(new Jugador("Rodrigo De Paul", R.drawable.rodrigo_depaul));
            jugadores.add(new Jugador("Enzo Fernández", R.drawable.enzo_fernandez));
            jugadores.add(new Jugador("Emiliano Martinez", R.drawable.emiliano_martinez));
            jugadores.add(new Jugador("Leonardo Balerdi", R.drawable.leonardo_balerdi));
            jugadores.add(new Jugador("Cristian Romero", R.drawable.cristian_romero));
            jugadores.add(new Jugador("Alexis Mac allister", R.drawable.alexis_macallister));
            jugadores.add(new Jugador("Exequiel Palacios", R.drawable.exequiel_palacios));
            jugadores.add(new Jugador("Franco Mastantuono", R.drawable.franco_mastantuono));
            jugadores.add(new Jugador("Giuliano Simeone", R.drawable.giuliano_simeone));
            jugadores.add(new Jugador("Nahuel Molina", R.drawable.nahuel_molina));
            jugadores.add(new Jugador("Leandro Paredes", R.drawable.leandro_paredes));
            jugadores.add(new Jugador("Nicolas Gonzalez", R.drawable.nicolas_gonzalez));
            jugadores.add(new Jugador("Nicolas Otamendi", R.drawable.nicolas_otamendi));
            jugadores.add(new Jugador("Nicolas Paz", R.drawable.nicolas_paz));
            jugadores.add(new Jugador("Nicolas Tagliafico", R.drawable.nicolas_tagliafico));


        } else if ("Brasil".equals(seleccion)) {

            jugadores.add(new Jugador("Alisson becker", R.drawable.alisson_becker));
            jugadores.add(new Jugador("Bento", R.drawable.bento));
            jugadores.add(new Jugador("Marquinhos", R.drawable.marquinhos));
            jugadores.add(new Jugador("Éder Militão", R.drawable.eder_militao));
            jugadores.add(new Jugador("Gabriel Magalhães", R.drawable.gabriel_magalhaes));
            jugadores.add(new Jugador("Danilo", R.drawable.danilo));
            jugadores.add(new Jugador("Wesley", R.drawable.wesley));
            jugadores.add(new Jugador("Lucas Paquetá", R.drawable.lucas_paqueta));
            jugadores.add(new Jugador("Casemiro", R.drawable.casemiro));
            jugadores.add(new Jugador("Bruno Guimarães", R.drawable.bruno_guimaraes));
            jugadores.add(new Jugador("Luiz Henrique", R.drawable.luiz_henrique));
            jugadores.add(new Jugador("Vinicius Júnior", R.drawable.vinicius_junior));
            jugadores.add(new Jugador("Rodrygo", R.drawable.rodrygo));
            jugadores.add(new Jugador("João Pedro", R.drawable.joao_pedro));
            jugadores.add(new Jugador("Matheus Cunha", R.drawable.matheus_cunha));
            jugadores.add(new Jugador("Gabriel Martinelli", R.drawable.gabriel_martinelli));
            jugadores.add(new Jugador("Raphinha", R.drawable.raphinha));
            jugadores.add(new Jugador("Estêvão", R.drawable.estevao));

        } else if ("Francia".equals(seleccion)) {

            jugadores.add(new Jugador("Mike Maignan", R.drawable.mike_maignan));
            jugadores.add(new Jugador("Theo Hernandez", R.drawable.theo_hernandez));
            jugadores.add(new Jugador("William Saliba", R.drawable.william_saliba));
            jugadores.add(new Jugador("Jules Kounde", R.drawable.jules_kounde));
            jugadores.add(new Jugador("Ibrahima Konate", R.drawable.ibrahima_konate));
            jugadores.add(new Jugador("Dayot Upamecano", R.drawable.dayot_upamecano));
            jugadores.add(new Jugador("Lucas Digne", R.drawable.lucas_digne));
            jugadores.add(new Jugador("Aurélien Tchouaméni", R.drawable.aurelien_tchouameni));
            jugadores.add(new Jugador("Eduardo Camavinga", R.drawable.eduardo_camavinga));
            jugadores.add(new Jugador("Manu Kone", R.drawable.manu_kone));
            jugadores.add(new Jugador("Adrien Rabiot", R.drawable.adrien_rabiot));
            jugadores.add(new Jugador("Michael Olise", R.drawable.michael_olise));
            jugadores.add(new Jugador("Ousmane Dembele", R.drawable.ousmane_dembele));
            jugadores.add(new Jugador("Bradley Barcola", R.drawable.bradley_barcola));
            jugadores.add(new Jugador("Désiré Doué", R.drawable.desire_doue));
            jugadores.add(new Jugador("Kingsley Coman", R.drawable.kingsley_coman));
            jugadores.add(new Jugador("Hugo Ekitike", R.drawable.hugo_ekitike));
            jugadores.add(new Jugador("Kylian Mbappe", R.drawable.kylian_mbappe));

        } else if ("España".equals(seleccion)) {

            jugadores.add(new Jugador("Unai Simon", R.drawable.unai_simon));
            jugadores.add(new Jugador("Robin Le Normand", R.drawable.robin_le_normand));
            jugadores.add(new Jugador("Aymeric Laporte", R.drawable.aymeric_laporte));
            jugadores.add(new Jugador("Dean Huijsen", R.drawable.dean_huijsen));
            jugadores.add(new Jugador("Pedro Porro", R.drawable.pedro_porro));
            jugadores.add(new Jugador("Dani Carvajal", R.drawable.dani_carvajal));
            jugadores.add(new Jugador("Marc Cucurella", R.drawable.marc_cucurella));
            jugadores.add(new Jugador("Martín Zubimendi", R.drawable.martin_zubimendi));
            jugadores.add(new Jugador("Rodri", R.drawable.rodri));
            jugadores.add(new Jugador("Pedri", R.drawable.pedri));
            jugadores.add(new Jugador("Fabian Ruiz", R.drawable.fabian_ruiz));
            jugadores.add(new Jugador("Mikel Merino", R.drawable.mikel_merino));
            jugadores.add(new Jugador("Lamine Yamal", R.drawable.lamine_yamal));
            jugadores.add(new Jugador("Dani Olmo", R.drawable.dani_olmo));
            jugadores.add(new Jugador("Nico Williams", R.drawable.nico_williams));
            jugadores.add(new Jugador("Ferran Torres", R.drawable.ferran_torres));
            jugadores.add(new Jugador("Álvaro Morata", R.drawable.alvaro_morata));
            jugadores.add(new Jugador("Mikel Oyarzabal", R.drawable.mikel_oyarzabal));

        } else if ("Alemania".equals(seleccion)) {

            jugadores.add(new Jugador("Jamal Musiala", R.drawable.jamal_musiala));
            jugadores.add(new Jugador("Marc-André ter Stegen", R.drawable.marcandre_terstegen));
            jugadores.add(new Jugador("Jonathan Tah", R.drawable.jonathan_tah));
            jugadores.add(new Jugador("David Raum", R.drawable.david_raum));
            jugadores.add(new Jugador("Nico Schlotterbeck", R.drawable.nico_schlotterbech));
            jugadores.add(new Jugador("Antonio Rüdiger", R.drawable.antonio_rudiger));
            jugadores.add(new Jugador("Waldemar Anton", R.drawable.waldemar_anton));
            jugadores.add(new Jugador("Ridle Baku", R.drawable.ridle_baku));
            jugadores.add(new Jugador("Maximilian Mittelstadt", R.drawable.maximilian_mitterstadt));
            jugadores.add(new Jugador("Joshua Kimmich", R.drawable.joshua_kimmich));
            jugadores.add(new Jugador("Florian Wirtz", R.drawable.florian_wirtz));
            jugadores.add(new Jugador("Felix Nmecha", R.drawable.felix_nmecha));
            jugadores.add(new Jugador("Leon Goretzka", R.drawable.leon_goretzka));
            jugadores.add(new Jugador("Serge Gnabry", R.drawable.serge_gnabrv));
            jugadores.add(new Jugador("Kai Havertz", R.drawable.kai_havertz));
            jugadores.add(new Jugador("Leroy Sane", R.drawable.leroy_sane));
            jugadores.add(new Jugador("Karim Adeyemi", R.drawable.karim_adeyemi));
            jugadores.add(new Jugador("Nick Woltemade", R.drawable.nick_woltemade));
        }

        for (Jugador jugador : jugadores) {

            boolean conseguido =
                    prefs.getBoolean(
                            emailLogueado + "_" + seleccion + "_" + jugador.getNombre(),
                            false
                    );

            jugador.setConseguido(conseguido);
        }

        JugadorAdapter adapter =
                new JugadorAdapter(this, jugadores);

        listaJugadores.setAdapter(adapter);

        listaJugadores.setOnItemClickListener(
                (parent, view, position, id) -> {

                    Jugador jugador =
                            jugadores.get(position);

                    jugador.toggleConseguido();

                    prefs.edit()
                            .putBoolean(
                                    emailLogueado+ "_" + seleccion + "_" + jugador.getNombre(),
                                    jugador.isConseguido()
                            )
                            .apply();

                    adapter.notifyDataSetChanged();
                });
        ImageButton btnVolver =
                findViewById(R.id.btnVolver);

        btnVolver.setOnClickListener(v -> finish());
    }
}