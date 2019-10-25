package com.arcaya.labactivity1025;

public class AndroidVersions {

    private int logo;
    private String name, date;

    public AndroidVersions(int logo, String name, String date) {
        this.logo = logo;
        this.name = name;
        this.date = date;
    }

    public int getLogo() {
        return logo;
    }

    public String getName() {
        return name;
    }

    public String getDate() {
        return date;
    }
}
