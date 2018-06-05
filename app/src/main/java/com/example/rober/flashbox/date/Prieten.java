package com.example.rober.flashbox.date;

import java.io.Serializable;
import java.util.ArrayList;

public class Prieten implements Serializable{

    private int id_prieten;
    private String username;
    private String poza;
    private ArrayList<EpisodFavorit> efprieten;

    public String getPoza() {
        return poza;
    }

    public void setPoza(String poza) {
        this.poza = poza;
    }

    public int getId_prieten() {
        return id_prieten;
    }

    public void setId_prieten(int id_prieten) {
        this.id_prieten = id_prieten;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public ArrayList<EpisodFavorit> getEfprieten() {
        return efprieten;
    }

    public void setEfprieten(ArrayList<EpisodFavorit> efprieten) {
        this.efprieten = efprieten;
    }

    public Prieten() {
    }
}
