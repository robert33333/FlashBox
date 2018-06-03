package com.example.rober.flashbox.date;

import java.io.Serializable;

public class EpisodFavorit implements Serializable {
    private int idEpisod;
    private int idUtilizator;
    private String numeSerial;
    private int nrSezon;
    private int nrEpisod;
    private String link;

    public EpisodFavorit() {}

    public EpisodFavorit(int idEpisod, int idUtilizator) {
        this.idEpisod = idEpisod;
        this.idUtilizator = idUtilizator;
    }

    public EpisodFavorit(int id, int idUtilizator, String numeSerial, int nrSezon, int nrEpisod, String link) {
        this.idEpisod = id;
        this.idUtilizator = idUtilizator;
        this.numeSerial = numeSerial;
        this.nrSezon = nrSezon;
        this.nrEpisod = nrEpisod;
        this.link = link;
    }

    public int getIdEpisod() {
        return idEpisod;
    }

    public void setIdEpisod(int id) {
        this.idEpisod = id;
    }

    public int getIdUtilizator() {
        return idUtilizator;
    }

    public void setIdUtilizator(int idUtilizator) {
        this.idUtilizator = idUtilizator;
    }

    public String getNumeSerial() {
        return numeSerial;
    }

    public void setNumeSerial(String numeSerial) {
        this.numeSerial = numeSerial;
    }

    public int getNrSezon() {
        return nrSezon;
    }

    public void setNrSezon(int nrSezon) {
        this.nrSezon = nrSezon;
    }

    public int getNrEpisod() {
        return nrEpisod;
    }

    public void setNrEpisod(int nrEpisod) {
        this.nrEpisod = nrEpisod;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
