package com.example.conectarapi.apis.cima;

import java.util.List;

public class Medicamentos {

    private String nregistro, nombre;
    private boolean comerc;
    private List<Foto> fotos;

    public Medicamentos(String nRegistro, String nombre, boolean comerc, List<Foto> fotos) {
        this.nregistro = nRegistro;
        this.nombre = nombre;
        this.comerc = comerc;
        this.fotos = fotos;
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
    public List<Foto> getFotos() {
        return fotos;
    }
}