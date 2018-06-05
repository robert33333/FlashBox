package com.example.rober.flashbox.date;

import java.io.Serializable;

public class DateUtilizator implements Serializable {
    private int idUtilizator;
    private String nume;
    private String parola;
    private String email;
    private String date;
    private String poza;

    public String getPoza() {
        return poza;
    }

    public void setPoza(String poza) {
        this.poza = poza;
    }

    public DateUtilizator(String s, String s1) {
        nume = s;
        parola = s1;
    }

    public int getIdUtilizator() {
        return idUtilizator;
    }

    public void setIdUtilizator(int idUtilizator) {
        this.idUtilizator = idUtilizator;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getParola() {
        return parola;
    }

    public void setParola(String parola) {
        this.parola = parola;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public DateUtilizator(String nume, String parola, String email, String poza) {
        this.nume = nume;
        this.parola = parola;
        this.email = email;
        this.poza = poza;
    }
}
