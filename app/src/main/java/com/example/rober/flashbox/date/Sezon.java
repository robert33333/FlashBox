package com.example.rober.flashbox.date;

import java.io.Serializable;
import java.util.ArrayList;

public class Sezon implements Serializable {
    private int id;
    private int numar;
    private ArrayList<Episod> listaEpisoade;

    public Sezon() {}

    public Sezon(int id, int numar, ArrayList<Episod> listaEpisoade) {
        this.id = id;
        this.numar = numar;
        this.listaEpisoade = listaEpisoade;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumar() {
        return numar;
    }

    public void setNumar(int numar) {
        this.numar = numar;
    }

    public ArrayList<Episod> getListaEpisoade() {
        return listaEpisoade;
    }

    public void setListaEpisoade(ArrayList<Episod> listaEpisoade) {
        this.listaEpisoade = listaEpisoade;
    }
}
