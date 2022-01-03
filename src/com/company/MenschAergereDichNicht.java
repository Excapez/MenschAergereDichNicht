package com.company;

import java.util.ArrayList;

public class MenschAergereDichNicht {
    private Spielfeld spielfeld;
    private Spieler[] spieler = new Spieler[4];
    private Integer spieleranzahl;
    private ArrayList<Integer> verfuegbareFarben = new ArrayList<>();

    public MenschAergereDichNicht()
    {

    }

    public void spielInit()
    {
        spieleranzahlErmitteln();

        verfuegbareFarben.clear();
        verfuegbareFarben.add(Figur.BLAU);
        verfuegbareFarben.add(Figur.GELB);
        verfuegbareFarben.add(Figur.ROT);
        verfuegbareFarben.add(Figur.GRUEN);

        for(int i = 0; i < spieleranzahl; i++)
        {
            Integer farbe = farbeAuswaehlen(i);
            spieler[i] = new MenschSpieler(farbe, i);
            verfuegbareFarben.remove(farbe);
        }
        for(int i = 3; i >= spieleranzahl; i--)
        {
            Integer farbe = verfuegbareFarben.get(0);
            spieler[i] = new KISpieler(farbe, i);
            verfuegbareFarben.remove(farbe);
        }
    }

    public Integer farbeAuswaehlen(Integer spielerNummer)
    {
        System.out.println("Farbe für Spieler " + (spielerNummer+1) + " auswählen!");
        System.out.println("Verfügbare Farben:");
        for (Integer farbe : verfuegbareFarben)
        {
            switch(farbe)
            {
                case Figur.BLAU:
                    System.out.println(1 + ": Blau");
                    break;
                case Figur.GELB:
                    System.out.println(2 + ": Gelb");
                    break;
                case Figur.ROT:
                    System.out.println(3 + ": Rot");
                    break;
                case Figur.GRUEN:
                    System.out.println(4 + ": Grün");
                    break;
                default:
                    break;
            }

        }
        System.out.println("Bitte Farbe auswählen");
        switch(Tastatur.liesZahl()-1)
        {
            case Figur.BLAU:
                System.out.println("Farbe von Spieler " + (spielerNummer+1) + " ist Blau");
                return Figur.BLAU;
            case Figur.GELB:
                System.out.println("Farbe von Spieler " + (spielerNummer+1) + " ist Gelb");
                return Figur.GELB;
            case Figur.ROT:
                System.out.println("Farbe von Spieler " + (spielerNummer+1) + " ist Rot");
                return Figur.ROT;
            case Figur.GRUEN:
                System.out.println("Farbe von Spieler " + (spielerNummer+1) + " ist Grün");
                return Figur.GRUEN;
            default:
                System.out.println("Ausgewählte Farbe existiert nicht, zufällige Farbe wird gewählt");
                return verfuegbareFarben.get(0);
        }
    }

    public void spieleranzahlErmitteln()
    {
        System.out.println("Bitte Spieleranzahl eingeben:");
        spieleranzahl = Tastatur.liesZahl();
        System.out.println(spieleranzahl + " Spieler festgelegt");
    }

    public void spielStarten()
    {

    }

    public void spielStoppen()
    {

    }
}
