package com.example.mipanini2026.room.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.mipanini2026.room.entity.UsuarioEntity;

@Dao
public interface UsuarioDao {

    @Insert(onConflict = OnConflictStrategy.ABORT)
    long insertar(UsuarioEntity usuario);

    @Query("SELECT * FROM usuarios WHERE email = :email LIMIT 1")
    UsuarioEntity buscarPorEmail(String email);

    @Query("SELECT * FROM usuarios WHERE usuario = :nombreUsuario LIMIT 1")
    UsuarioEntity buscarPorNombreUsuario(String nombreUsuario);

    @Query("SELECT * FROM usuarios WHERE email = :email AND password = :password LIMIT 1")
    UsuarioEntity iniciarSesion(String email, String password);

    @Query("SELECT * FROM usuarios WHERE id = :usuarioId LIMIT 1")
    UsuarioEntity buscarPorId(int usuarioId);

    @Query("SELECT COUNT(*) FROM usuarios WHERE email = :email")
    int contarPorEmail(String email);

    @Query("SELECT COUNT(*) FROM usuarios WHERE usuario = :nombreUsuario")
    int contarPorNombreUsuario(String nombreUsuario);
}