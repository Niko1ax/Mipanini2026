package com.example.mipanini2026.models;

public class Jugador {

    private String nombre;
    private int imagen;
    private boolean conseguido;

    public Jugador(String nombre) {
        this.nombre = nombre;
        this.imagen = 0;
        this.conseguido = false;
    }
    public Jugador(String nombre, int imagen) {
        this.nombre = nombre;
        this.conseguido = false;
        this.imagen = imagen;
    }

    public String getNombre() {
        return nombre;
    }
    public int getImagen() {
        return imagen;
    }

    public boolean isConseguido() {
        return conseguido;
    }

    public void setConseguido(boolean conseguido) {
        this.conseguido = conseguido;
    }

    public void toggleConseguido() {
        conseguido = !conseguido;
    }
}