package com.nataliguillen.diccionario;
import java.io.Serializable;
import java.util.ArrayList;

public class Diccionario implements Serializable {

    // Atributos
    private ArrayList<Termino> terminos;

    // Constructor vacio
    public Diccionario() {
        terminos = new ArrayList<>();
    }

    // Constructor
    public Diccionario(ArrayList<Termino> terminos) {
        this.terminos = terminos;
    }

    // Getters y setters
    public ArrayList<Termino> getTerminos() {
        return terminos;
    }

    public void setTerminos(ArrayList<Termino> terminos) {
        this.terminos = terminos;
    }
}
