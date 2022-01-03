package com.company;

public class Figur {
    private Integer position;
    private Integer zustand;
    private Integer startposition;

    public static final int BLAU = 0;
    public static final int GELB = 1;
    public static final int GRUEN = 2;
    public static final int ROT = 3;

    public static final int START = 0;
    public static final int FELD = 1;
    public static final int ZIEL = 2;

    public Figur(Integer startposition)
    {
        this.startposition = startposition;
        position = 0;
        zustand = START;
    }

    public void setPosition(Integer pos)
    {

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
}
