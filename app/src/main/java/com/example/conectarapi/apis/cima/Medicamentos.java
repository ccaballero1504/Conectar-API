package com.example.conectarapi.apis.cima;

public class Medicamentos {

    private String nregistro, nombre;
    boolean comerc;

    public Medicamentos(String nRegistro, String nombre, boolean comerc) {
        this.nregistro = nRegistro;
        this.nombre = nombre;
        this.comerc = comerc;
    }

    public String getnRegistro() {
        return nregistro;
    }
    public String getNombre() {
        return nombre;
    }
    public boolean isComerc() {
        return comerc;
    }
}