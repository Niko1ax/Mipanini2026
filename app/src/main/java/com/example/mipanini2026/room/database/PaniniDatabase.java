package com.example.mipanini2026.room.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.mipanini2026.room.dao.UsuarioDao;
import com.example.mipanini2026.room.entity.UsuarioEntity;

@Database(
        entities = {
                UsuarioEntity.class
        },
        version = 1,
        exportSchema = false
)
public abstract class PaniniDatabase extends RoomDatabase {

    private static final String DATABASE_NAME = "MiPaniniRoom.db";

    private static volatile PaniniDatabase instancia;

    public abstract UsuarioDao usuarioDao();

    public static PaniniDatabase getInstancia(Context context) {

        if (instancia == null) {

            synchronized (PaniniDatabase.class) {

                if (instancia == null) {

                    instancia = Room.databaseBuilder(
                                    context.getApplicationContext(),
                                    PaniniDatabase.class,
                                    DATABASE_NAME
                            )
                            .build();
                }
            }
        }

        return instancia;
    }
}