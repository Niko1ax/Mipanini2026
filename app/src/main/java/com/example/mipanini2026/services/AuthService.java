package com.example.mipanini2026.services;

import android.content.Context;

import com.example.mipanini2026.room.database.PaniniDatabase;
import com.example.mipanini2026.room.entity.UsuarioEntity;

public class AuthService {

    private final Context context;

    public AuthService(Context context) {
        this.context = context;
    }

    public UsuarioEntity iniciarSesion(String email, String password) {

        return PaniniDatabase
                .getInstancia(context)
                .usuarioDao()
                .iniciarSesion(email, password);
    }

}