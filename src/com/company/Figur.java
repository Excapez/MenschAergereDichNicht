package com.company;

public class Figur {
    private Integer position;
    private Integer zustand;
    private Integer startposition;
    private Integer zielposition;
    private Integer nummer;
    private Integer farbe;

    public static final int BLAU = 0;
    public static final int GELB = 1;
    public static final int GRUEN = 2;
    public static final int ROT = 3;

    public static final int START = 0;
    public static final int FELD = 1;
    public static final int ZIEL = 2;

    public static final int AUS_HAUS = 0;
    public static final int NORMAL = 1;
    public static final int IN_ZIEL = 2;
    public static final int INNERHALB_ZIEL = 3;

    public Figur(Integer startposition, Integer nummer, Integer farbe)
    {
        this.startposition = startposition;
        this.nummer = nummer;
        this.farbe = farbe;
        zielposition = (startposition + 39) % 40;
        position = 0;
        zustand = START;
    }

    public void bewegen(Integer pos, Integer zus){
        position = pos;
        zustand = zus;
    }

    public void schmeißen()
    {

    }

    public Integer getPosition()
    {
        return position;
    }

    public Integer getZustand()
    {
        return zustand;
    }

    public Integer getStartposition()
    {
        return startposition;
    }

    public Integer getNummer()
    {
        return nummer;
    }

    public Integer getZielposition()
    {
        return zielposition;
    }

    public Integer getFarbe()
    {
        return farbe;
    }

    public void setPosition(Integer pos)
    {
        position = pos;
    }

    public void setZustand(Integer zus)
    {
        zustand = zus;
    }
}
