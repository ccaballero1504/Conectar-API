package com.example.conectarapi.apis.cima;

public class Medicamentos {

    private String nRegistro, nombre;
    boolean comerc;

    public Medicamentos(String nRegistro, String nombre, boolean comerc) {
        this.nRegistro = nRegistro;
        this.nombre = nombre;
        this.comerc = comerc;
    }

    public String getnRegistro() {
        return nRegistro;
    }
    public String getNombre() {
        return nombre;
    }
    public boolean isComerc() {
        return comerc;
    }
}