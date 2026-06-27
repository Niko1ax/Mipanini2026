package com.example.mipanini2026.models;

public class Seleccion {

    private String nombre;
    private String bandera;

    public Seleccion(String nombre, String bandera) {
        this.nombre = nombre;
        this.bandera = bandera;
    }

    public String getNombre() {
        return nombre;
    }

    public String getBandera() {
        return bandera;
    }
}