package com.example.mipanini2026.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.mipanini2026.R;
import com.example.mipanini2026.models.Seleccion;

import java.util.List;

public class SeleccionAdapter extends ArrayAdapter<Seleccion> {

    public SeleccionAdapter(Context context, List<Seleccion> selecciones) {
        super(context, 0, selecciones);
    }

    @NonNull
    @Override
    public View getView(int position,
                        @Nullable View convertView,
                        @NonNull ViewGroup parent) {

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext())
                    .inflate(R.layout.item_seleccion, parent, false);
        }

        Seleccion seleccion = getItem(position);

        TextView txtSeleccion =
                convertView.findViewById(R.id.txtSeleccion);

        txtSeleccion.setText(
                seleccion.getBandera() + " " +
                        seleccion.getNombre()
        );

        return convertView;
    }
}