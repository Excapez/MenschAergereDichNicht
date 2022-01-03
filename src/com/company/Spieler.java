package com.company;

import java.util.ArrayList;

public abstract class Spieler {
    ArrayList<Figur> figuren = new ArrayList<>();
    private String name;
    private Integer nummer;
    private Integer farbe; //position ist an farbe gekoppelt
    private Boolean spielerIstFertig;

    public Spieler(Integer farbe, Integer nummer, String name)
    {
        for(int i = 0; i < 4; i++)
        {
            figuren.add(new Figur(10*farbe));
        }
        this.farbe = farbe;
        this.nummer = nummer;
        this.name = name;
    }

    public Integer wuerfeln()
    {
        return 0;
    }

    public Integer getFarbe()
    {
        return farbe;
    }

    public ArrayList<Figur> getFiguren()
    {
        return figuren;
    }

    public abstract Figur auswaehlen();

    public void schmeißen(Figur figur)
    {

    }

}
