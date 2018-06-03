package com.example.rober.flashbox.date;

import java.io.Serializable;

public class Episod implements Serializable{
    private int id;
    private int numar;
    private String nume;
    private String descriere;

    public Episod(int id, int numar, String nume, String descriere) {
        this.id = id;
        this.numar = numar;
        this.nume = nume;
        this.descriere = descriere;
    }

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public int getNumar() {
        return numar;
    }

    public void setNumar(int numar) {
        this.numar = numar;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getDescriere() {
        return descriere;
    }

    public void setDescriere(String descriere) {
        this.descriere = descriere;
    }

    public Episod() {
    }
}
