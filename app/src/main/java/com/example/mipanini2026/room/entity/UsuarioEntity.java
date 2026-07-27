package com.example.mipanini2026.room.entity;

import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(
        tableName = "usuarios",
        indices = {
                @Index(value = {"email"}, unique = true),
                @Index(value = {"usuario"}, unique = true)
        }
)
public class UsuarioEntity {

    @PrimaryKey(autoGenerate = true)
    private int id;

    private String nombre;
    private String usuario;
    private String email;
    private String password;

    public UsuarioEntity(
            String nombre,
            String usuario,
            String email,
            String password
    ) {
        this.nombre = nombre;
        this.usuario = usuario;
        this.email = email;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}