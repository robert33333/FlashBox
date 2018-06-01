package com.example.rober.flashbox.date;

import java.io.Serializable;

public class Comanda implements Serializable {
    private final String optiune;
    private final Object obj;

    public Comanda(String optiune, Object obj) {
        this.optiune = optiune;
        this.obj = obj;
    }

    public String getOptiune() {
        return optiune;
    }

    public Object getObj() {
        return obj;
    }
}
