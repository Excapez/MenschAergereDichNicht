package com.company;

public class KISpieler extends Spieler{
    public KISpieler(Integer farbe, Integer nummer, String name)
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

        String out = this.getName() + " zieht ";

        // Kontrolle ob Zug in Ziel moeglich, wenn ja diesen machen
        for(int i = 0; i < 4; i++)
        {
            if(figurenZuege[i][Figur.IN_ZIEL] == 1)
            {
                System.out.println(out + "mit Figur " + i + " in Ziel");
                zugAuswahl[i][Figur.IN_ZIEL] = 1;
                return zugAuswahl;
            }
        }

        // Kontrolle ob Zug aus Haus möglich, wenn ja diesen machen
        for(int i = 0; i < 4; i++)
        {
            if(figurenZuege[i][Figur.AUS_HAUS] == 1)
            {
                System.out.println(out + "mit Figur " + i + " aus dem Haus");
                zugAuswahl[i][Figur.AUS_HAUS] = 1;
                return zugAuswahl;
            }
        }

        // Kontrolle ob Zug von Startposition weg möglich, wenn ja diesen machen
        for(int i = 0; i < 4; i++)
        {
            if(figurenZuege[i][Figur.NORMAL] == 1 && figuren.get(i).getPosition() == figuren.get(i).getStartposition())
            {
                System.out.println(out + "mit Figur " + i + " von Startposition");
                zugAuswahl[i][Figur.NORMAL] = 1;
                return zugAuswahl;
            }
        }

        // Kontrolle ob Zug innerhalb Ziel möglich, wenn ja diesen machen
        for(int i = 0; i < 4; i++)
        {
            if(figurenZuege[i][Figur.INNERHALB_ZIEL] == 1)
            {
                System.out.println(out + "mit Figur " + i + " innerhalb des Ziels");
                zugAuswahl[i][Figur.INNERHALB_ZIEL] = 1;
                return zugAuswahl;
            }
        }

        // Kontrolle ob normaler Zug möglich, wenn ja diesen machen
        for(int i = 0; i < 4; i++)
        {
            if(figurenZuege[i][Figur.NORMAL] == 1)
            {
                System.out.println(out + "mit Figur " + i + " auf dem Feld");
                zugAuswahl[i][Figur.NORMAL] = 1;
                return zugAuswahl;
            }
        }

        return null;
    }

    /**
     * Mögliche KI:
     * Wenn 6 gewürfelt immer Figur aus Haus raus
     * Sonst wenn Zug in Ziel möglich diesen durchführen
     * Sonst wenn schmeißen anderer Figur möglich dies durchführen
     * Sonst Figur am nähesten zum Ziel ziehen
     */
}
