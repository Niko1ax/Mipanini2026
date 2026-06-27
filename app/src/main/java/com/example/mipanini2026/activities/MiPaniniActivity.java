package com.example.mipanini2026.activities;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mipanini2026.R;
import com.example.mipanini2026.adapters.SeleccionAdapter;
import com.example.mipanini2026.models.Seleccion;

import java.util.ArrayList;

import android.content.Intent;
import android.widget.AdapterView;

import android.content.Intent;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MiPaniniActivity extends AppCompatActivity {

    private ListView listaSelecciones;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mi_panini);

        listaSelecciones =
                findViewById(R.id.listaSelecciones);

        ArrayList<Seleccion> selecciones =
                new ArrayList<>();

        selecciones.add(
                new Seleccion("Argentina", "🇦🇷"));

        selecciones.add(
                new Seleccion("Brasil", "🇧🇷"));

        selecciones.add(
                new Seleccion("Francia", "🇫🇷"));

        selecciones.add(
                new Seleccion("España", "🇪🇸"));

        selecciones.add(
                new Seleccion("Alemania", "🇩🇪"));

        SeleccionAdapter adapter =
                new SeleccionAdapter(
                        this,
                        selecciones
                );

        listaSelecciones.setAdapter(adapter);
        listaSelecciones.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent,
                                            android.view.View view,
                                            int position,
                                            long id) {

                        Seleccion seleccion =
                                selecciones.get(position);

                        Intent intent =
                                new Intent(
                                        MiPaniniActivity.this,
                                        JugadoresActivity.class
                                );

                        intent.putExtra(
                                "seleccion",
                                seleccion.getNombre()
                        );

                        startActivity(intent);
                    }
                });

        BottomNavigationView nav =
                findViewById(R.id.bottomNavigation);

        nav.setSelectedItemId(R.id.nav_album);

        nav.setOnItemSelectedListener(item -> {

            if (item.getItemId() == R.id.nav_faltantes) {

                startActivity(
                        new Intent(
                                MiPaniniActivity.this,
                                FaltantesActivity.class
                        )
                );

                return true;
            }

            if (item.getItemId() == R.id.nav_usuario) {

                startActivity(
                        new Intent(
                                MiPaniniActivity.this,
                                UsuarioActivity.class
                        )
                );

                return true;
            }

            return true;
        });
    }
}