package com.example.conectarapi.apis.cima;

import java.util.List;

public class RespuestaCIMA {
    // El nombre de esta variable debe coincidir con la llave del JSON (ej: "resultados")
    private List<Medicamentos> resultados;

    public List<Medicamentos> getResultados() {
        return resultados;
    }
}