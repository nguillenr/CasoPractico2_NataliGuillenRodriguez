package com.nataliguillen.diccionario;
import java.io.Serializable;

public class Termino implements Serializable {

    // Atributos
    private String palabra;
    private String concepto;

    // Constructor vacío
    public Termino() {
    }

    // Constructor
    public Termino(String palabra, String concepto) {
        this.palabra = palabra;
        this.concepto = concepto;
    }

    // Getters y setters
    public String getPalabra() {
        return palabra;
    }

    public void setPalabra(String palabra) {
        this.palabra = palabra;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }
}
