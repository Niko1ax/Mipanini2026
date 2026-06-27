package com.example.mipanini2026.services;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.mipanini2026.database.DatabaseHelper;

public class AuthService {

    private Context context;

    public AuthService(Context context) {
        this.context = context;
    }

    public boolean iniciarSesion(String email, String password) {

        DatabaseHelper helper = new DatabaseHelper(context);
        SQLiteDatabase db = helper.getReadableDatabase();

        Cursor cursor = db.rawQuery(
                "SELECT * FROM usuarios WHERE email = ? AND password = ?",
                new String[]{email, password}
        );

        boolean existe = cursor.moveToFirst();

        cursor.close();
        db.close();

        return existe;
    }
}

