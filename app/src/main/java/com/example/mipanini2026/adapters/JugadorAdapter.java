package com.example.mipanini2026.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.mipanini2026.R;
import com.example.mipanini2026.models.Jugador;

import java.util.List;

public class JugadorAdapter extends ArrayAdapter<Jugador> {

    public JugadorAdapter(Context context, List<Jugador> jugadores) {
        super(context, 0, jugadores);
    }

    @NonNull
    @Override
    public View getView(int position,
                        @Nullable View convertView,
                        @NonNull ViewGroup parent) {

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext())
                    .inflate(R.layout.item_jugador, parent, false);
        }

        Jugador jugador = getItem(position);

        TextView txtJugador = convertView.findViewById(R.id.txtJugador);
        ImageView imgJugador = convertView.findViewById(R.id.imgJugador);

        if (jugador != null) {

            if (jugador.isConseguido()) {

                txtJugador.setText("✓ " + jugador.getNombre());

                convertView.setBackgroundColor(
                        0xFF666666
                );

            } else {

                txtJugador.setText(
                        jugador.getNombre()
                );

                convertView.setBackgroundColor(
                        0xFF14213D
                );
            }

            if (jugador.getImagen() != 0) {
                imgJugador.setImageResource(jugador.getImagen());
            } else {
                imgJugador.setImageResource(R.drawable.ic_launcher_foreground);
            }
        }

        return convertView;
    }
}