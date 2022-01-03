package com.company;

import java.util.ArrayList;

public class MenschAergereDichNicht {
    private Spielfeld spielfeld;
    private Spieler[] spieler = new Spieler[4];
    private Integer spieleranzahl;
    private ArrayList<Integer> verfuegbareFarben = new ArrayList<>();

    public MenschAergereDichNicht()
    {
        spielfeld = new Spielfeld();
    }

    public void spielInit()
    {
        spieleranzahlErmitteln();

        verfuegbareFarben.clear();
        verfuegbareFarben.add(Figur.BLAU);
        verfuegbareFarben.add(Figur.GELB);
        verfuegbareFarben.add(Figur.GRUEN);
        verfuegbareFarben.add(Figur.ROT);

        //Spielerfarben + namen festlegen
        for(int i = 0; i < spieleranzahl; i++)
        {
            String name = nameEingeben(i);
            Integer farbe = farbeAuswaehlen(i);
            spieler[farbe] = new MenschSpieler(farbe, i, name);
            verfuegbareFarben.remove(farbe);
        }

        //KI-Farben festlegen
        for(int i = 3; i >= spieleranzahl; i--)
        {
            Integer farbe = verfuegbareFarben.get(0);
            spieler[farbe] = new KISpieler(farbe, i, "KI " + i);
            verfuegbareFarben.remove(farbe);
        }

        // Spielerliste an Spielfeld übergeben
        spielfeld.initSpielfeld(spieler);
    }

    //Funktion zur Auswahl einer Farbe auf der Kommandozeile
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
                    System.out.println(4 + ": Rot");
                    break;
                case Figur.GRUEN:
                    System.out.println(3 + ": Grün");
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
                System.out.println("Ausgewählte Farbe existiert nicht, Farbe wird automatisch gewählt");
                return verfuegbareFarben.get(0);
        }
    }

    public String nameEingeben(Integer spielerNummer)
    {
        System.out.println("Name für Spieler " + (spielerNummer+1) + " eingeben!");
        String name = Tastatur.liesText();
        return name;
    }

    //Funktion zur Eingabe der Spieleranzahl
    public void spieleranzahlErmitteln()
    {
        System.out.println("Bitte Spieleranzahl eingeben:");
        spieleranzahl = Tastatur.liesZahl();
        System.out.println(spieleranzahl + " Spieler festgelegt");
    }

    public void spielStarten()
    {

    }

    public void spielen()
    {
        /**
         * bissl pseudocode:
         * spielfeld anzeigen
         * ersten spieler würfeln lassen
         * möglichkeiten für Züge durchgehen und anzeigen:
         *      Wenn 6 kann figur aus haus raus
         *      wenn keine figur auf feld und keine 6 kein zug möglich
         *      checken ob zug von figur in ziel möglich
         *      Für KI automatische Auswahl nötig
         * ziehen:
         *      Zustand und Position von Figur aktualisieren
         *      Checken ob andere Figur geschmissen wurde
         *          ->position und Zustand dieser Figur aktualisieren
         *
         *
         */
    }

    public void spielStoppen()
    {

    }
}
