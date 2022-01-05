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
            figuren.add(new Figur(10*farbe, i, farbe));
        }
        this.farbe = farbe;
        this.nummer = nummer;
        this.name = name;
    }

    public String getFarbString()
    {
        switch(farbe)
        {
            case Figur.BLAU:
                return Gui.ANSI_BLU_C + "Blau" + Gui.ANSI_RESET;
            case Figur.GELB:
                return Gui.ANSI_YEL_C + "Gelb" + Gui.ANSI_RESET;
            case Figur.GRUEN:
                return Gui.ANSI_GRN_C + "Gruen" + Gui.ANSI_RESET;
            case Figur.ROT:
                return Gui.ANSI_RED_C + "Rot" + Gui.ANSI_RESET;
        }
        return "";
    }

    public Integer wuerfeln()
    {
        return 0;
    }

    public Integer getFarbe()
    {
        return farbe;
    }

    public String getName()
    {
        return name;
    }

    public ArrayList<Figur> getFiguren()
    {
        return figuren;
    }

    public abstract int[][] auswaehlen(int[] figurenZugMoeglich, int[][] figurenZuege);

    public void schmeißen(Figur figur)
    {

    }

}
