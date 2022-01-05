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
        //spielfeld.spielfeldDrucken(spieler);
        spielen();
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
        return Tastatur.liesText();
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
        while(true) {
            for (int n = 0; n < 4; n++) {
                if(spieler[n].getClass() == MenschSpieler.class)
                {
                    spielfeld.spielfeldDrucken(spieler);
                }
                System.out.println("Spieler " + spieler[n].getName() + " mit Farbe " + " ist dran!");
                int wurf = Wuerfel.wuerfeln();
                System.out.println(wurf + " gewürfelt!");
                int[] figurenZugMoeglich = new int[4];
                int[][] figurenZuege = {new int[4], new int[4], new int[4], new int[4]}; //speichert mögliche Züge [x][0] = aus Haus, [x][1] = normal ziehen, [x][2] = in Ziel ziehen, [x][3] = innerhalb Ziel ziehen
                // Alle Möglichkeiten für alle Figuren überprüfen
                for (Figur figur : spieler[n].getFiguren()) {
                    // Kontrolle ob Figur aus Haus raus
                    if (wurf == 6 && figur.getZustand() == Figur.START) {
                        boolean figurAufStart = false;
                        for (Figur figur2 : spieler[n].getFiguren()) {
                            if (figur2.getZustand() == Figur.FELD && figur2.getPosition() == figur2.getStartposition()) {
                                figurAufStart = true;
                                break;
                            }
                        }
                        if (!figurAufStart) {
                            figurenZugMoeglich[figur.getNummer()] = 1;
                            figurenZuege[figur.getNummer()][Figur.AUS_HAUS] = 1;
                        }
                    }

                    // Kontrolle ob normaler Zug möglich
                    if (figur.getZustand() == Figur.FELD) {
                        Integer zielFeld = (figur.getPosition() + wurf) % 40;
                        boolean figurAufZielfeld = false;
                        for (Figur figur2 : spieler[n].getFiguren()) {
                            if (figur2.getPosition() == zielFeld) {
                                figurAufZielfeld = true;
                            }
                        }
                        if (!figurAufZielfeld) {
                            figurenZugMoeglich[figur.getNummer()] = 1;
                            figurenZuege[figur.getNummer()][Figur.NORMAL] = 1;
                        }
                    }

                    // Kontrolle ob Zug in Ziel möglich
                    if (figur.getZustand() == Figur.FELD) {
                        Integer zielFeld = (figur.getPosition() + wurf) % 40;
                        boolean figurAufZielfeld = false;
                        if (zielFeld >= figur.getStartposition() && zielFeld < (figur.getStartposition() + 4)) {
                            // Zug in Ziel möglich, Figuren in Ziel kontrollieren
                            Integer posInZiel = figur.getPosition() + wurf - figur.getZielposition() - 1; // -1 da Zielfelder beginnend bei 0
                            for (Figur figur2 : spieler[n].getFiguren()) {
                                if (figur2.getZustand() == Figur.ZIEL && figur2.getPosition() == posInZiel) {
                                    figurAufZielfeld = true;
                                }
                            }
                            if (!figurAufZielfeld) {
                                figurenZugMoeglich[figur.getNummer()] = 1;
                                figurenZuege[figur.getNummer()][Figur.IN_ZIEL] = 1;
                            }
                        }
                    }

                    // Kontrolle ob Zug innerhalb Ziel möglich
                    if (figur.getZustand() == Figur.ZIEL) {
                        Integer zielFeld = figur.getPosition() + wurf;
                        if (zielFeld < 3) {
                            boolean figurAufZielfeld = false;
                            for (Figur figur2 : spieler[n].getFiguren()) {
                                if (figur2.getZustand() == Figur.ZIEL && figur2.getPosition() == zielFeld) {
                                    figurAufZielfeld = true;
                                }
                            }
                            if (!figurAufZielfeld) {
                                figurenZugMoeglich[figur.getNummer()] = 1;
                                figurenZuege[figur.getNummer()][Figur.INNERHALB_ZIEL] = 1;
                            }
                        }
                    }
                }

                int[][] zugAuswahl = spieler[n].auswaehlen(figurenZugMoeglich, figurenZuege);
                boolean zugMoeglich = false;
                for (int i = 0; i < 4; i++) {
                    if (zugAuswahl[i][Figur.AUS_HAUS] == 1) {
                        Integer startPosition = spieler[n].getFiguren().get(i).getStartposition();
                        spieler[n].getFiguren().get(i).setZustand(Figur.FELD);
                        spieler[n].getFiguren().get(i).setPosition(startPosition);
                        zugMoeglich = true;
                    } else if (zugAuswahl[i][Figur.NORMAL] == 1) {
                        Integer zielPosition = (spieler[n].getFiguren().get(i).getPosition() + wurf) % 40;
                        spieler[n].getFiguren().get(i).setPosition(zielPosition);
                        if (spielfeld.spielfeld[zielPosition] != null) {
                            spielfeld.spielfeld[zielPosition].setZustand(Figur.START);
                            spielfeld.spielfeld[zielPosition].setPosition(0);
                        }
                        zugMoeglich = true;
                    } else if (zugAuswahl[i][Figur.IN_ZIEL] == 1) {
                        Integer zielPosition = spieler[n].getFiguren().get(i).getPosition() + wurf - spieler[n].getFiguren().get(i).getZielposition() - 1;
                        spieler[n].getFiguren().get(i).setZustand(Figur.ZIEL);
                        spieler[n].getFiguren().get(i).setPosition(zielPosition);
                        zugMoeglich = true;
                    } else if (zugAuswahl[i][Figur.INNERHALB_ZIEL] == 1) {
                        Integer zielPosition = spieler[n].getFiguren().get(i).getPosition() + wurf;
                        spieler[n].getFiguren().get(i).setPosition(zielPosition);
                        zugMoeglich = true;
                    }
                }
                if(spieler[n].getClass() == KISpieler.class || !zugMoeglich)
                {
                    Tastatur.waitForEnter();
                }
            }
        }
    }

    public void spielStoppen()
    {

    }
}
