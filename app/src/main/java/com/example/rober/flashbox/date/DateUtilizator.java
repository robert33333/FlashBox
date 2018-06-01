package com.example.rober.flashbox.date;

import java.io.Serializable;
import java.sql.Date;

public class DateUtilizator implements Serializable {
    private int idUtilizator;
    private String nume;
    private String parola;
    private String email;
    private Date date;

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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public DateUtilizator(String nume, String parola, String email) {
        this.nume = nume;
        this.parola = parola;
        this.email = email;
    }
}
