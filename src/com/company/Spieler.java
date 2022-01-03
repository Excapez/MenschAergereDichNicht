package com.company;

public abstract class Spieler {
    private Figur figur1;
    private Figur figur2;
    private Figur figur3;
    private Figur figur4;
    private String name;
    private Integer nummer;
    private Integer farbe; //position ist an farbe gekoppelt
    private Boolean spielerIstFertig;

    public Spieler(Integer farbe, Integer nummer)
    {
        figur1 = new Figur(10*nummer);
        figur2 = new Figur(10*nummer);
        figur3 = new Figur(10*nummer);
        figur4 = new Figur(10*nummer);
        this.farbe = farbe;
        this.nummer = nummer;
    }

    public Integer wuerfeln()
    {
        return 0;
    }

    public abstract Figur auswaehlen();

    public void schmeißen(Figur figur)
    {

    }

}
