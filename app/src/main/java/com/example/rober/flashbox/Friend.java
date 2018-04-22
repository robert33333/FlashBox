package com.example.rober.flashbox;

public class Friend {
    private int avatar;
    private String name;
    private String[] series;

    public Friend(int avatar, String name) {
        this.avatar = avatar;
        this.name = name;
    }

    public int getAvatar() {
        return avatar;
    }

    public String getName() {
        return name;
    }

    public String[] getSeries() {
        return series;
    }
}