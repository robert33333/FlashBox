package com.example.rober.flashbox.date;


import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;

public class Serial implements Serializable {
    private int id;
    private String nume;
    private String descriere;
    private Date dataAparitie;
    private String link;
    private ArrayList<Sezon> listaSezoane;
    private String link_poza;

    public Serial() { }

    public Serial(int id, String nume, String descriere, Date dataAparitie, String link, ArrayList<Sezon> listaSezoane, String link_poza) {
        this.id = id;
        this.nume = nume;
        this.descriere = descriere;
        this.dataAparitie = dataAparitie;
        this.link = link;
        this.listaSezoane = listaSezoane;
        this.link_poza = link_poza;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Date getDataAparitie() {
        return dataAparitie;
    }

    public void setDataAparitie(Date dataAparitie) {
        this.dataAparitie = dataAparitie;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public ArrayList<Sezon> getListaSezoane() {
        return listaSezoane;
    }

    public void setListaSezoane(ArrayList<Sezon> listaSezoane) {
        this.listaSezoane = listaSezoane;
    }

    public String getLink_poza() {
        return link_poza;
    }

    public void setLink_poza(String link_poza) {
        this.link_poza = link_poza;
    }
}
