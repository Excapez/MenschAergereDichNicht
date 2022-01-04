package com.company;

public class MenschSpieler extends Spieler{
    public MenschSpieler(Integer farbe, Integer nummer, String name)
    {
        super(farbe, nummer, name);
    }

    @Override
    public int[][] auswaehlen(int[] figurenZugMoeglich, int[][] figurenZuege) {

        Integer figurAuswahl = null;
        Integer figurZugTyp = null;
        int[][] zugAuswahl = new int[4][4];
        boolean zugMoeglich = false;

        // Kontrolle ob überhaupt Zug moeglich
        for(int i = 0; i < 4; i++)
        {
            if(figurenZugMoeglich[i] == 1)
            {
                zugMoeglich = true;
            }
        }
        if(!zugMoeglich) // Falls kein Zug moeglich
        {
            System.out.println("Kein Zug moeglich! Nächster Spieler...");
            return zugAuswahl;
        }

        System.out.println("Mit welcher Figur möchtest du ziehen?");
        for(int i = 0; i < 4; i++)
        {
            if(figurenZugMoeglich[i] == 1)
            {
                System.out.println(i + ": Figur " + i + " ziehen");
            }
        }
        figurAuswahl = Tastatur.liesZahl();

        if(figurenZuege[figurAuswahl][Figur.AUS_HAUS] == 1)
        {
            System.out.println(0 + ": Mit Figur aus dem Haus ziehen");
        }
        else if(figurenZuege[figurAuswahl][Figur.NORMAL] == 1)
        {
            System.out.println(1 + ": Mit Figur normal ziehen");
        }
        else if(figurenZuege[figurAuswahl][Figur.IN_ZIEL] == 1)
        {
            System.out.println(2 + ": Mit Figur in das Ziel ziehen");
        }
        else if(figurenZuege[figurAuswahl][Figur.INNERHALB_ZIEL] == 1)
        {
            System.out.println(3 + ": Mit Figur innerhalb Ziel ziehen");
        }
        figurZugTyp = Tastatur.liesZahl();
        zugAuswahl[figurAuswahl][figurZugTyp] = 1;
        return zugAuswahl;
    }
}
