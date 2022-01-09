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

		for(int i = 0; i < 4; i++) // Kontrolle ob überhaupt Zug moeglich
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

		System.out.print("Mit welcher Figur möchtest du ziehen? (");
		for(int i = 0; i < 4; i++)
		{
			if(figurenZugMoeglich[i] == 1)
			{
				System.out.print(" " + i);
			}
		}
		System.out.println(" )");
		figurAuswahl = Tastatur.liesZahl();

		while(figurAuswahl == 0 && figurenZugMoeglich[0] == 0 || figurAuswahl == 1 && figurenZugMoeglich[1] == 0
				|| figurAuswahl == 2 && figurenZugMoeglich[2] == 0 || figurAuswahl == 3 && figurenZugMoeglich[3] == 0
				|| figurAuswahl < 0 || figurAuswahl > 3)
		{
			System.out.println("Fehlerhafte Eingabe! Erneut eingeben:");
			figurAuswahl = Tastatur.liesZahl();
		}

		if(figurenZuege[figurAuswahl][Figur.AUS_HAUS] == 1)
		{
			figurZugTyp = 0;
		}
		else if(figurenZuege[figurAuswahl][Figur.IN_ZIEL] == 1)
		{
			figurZugTyp = 2;
		}
		else if(figurenZuege[figurAuswahl][Figur.INNERHALB_ZIEL] == 1)
		{
			figurZugTyp = 3;
		}
		else if(figurenZuege[figurAuswahl][Figur.NORMAL] == 1)
		{
			figurZugTyp = 1;
		}

		while(figurZugTyp == 0 && figurenZuege[figurAuswahl][Figur.AUS_HAUS] == 0 || figurZugTyp == 1 && figurenZuege[figurAuswahl][Figur.NORMAL] == 0
				|| figurZugTyp == 2 && figurenZuege[figurAuswahl][Figur.IN_ZIEL] == 0 || figurZugTyp == 3 && figurenZuege[figurAuswahl][Figur.INNERHALB_ZIEL] == 0
				|| figurZugTyp < 0 || figurZugTyp > 3)
		{
			System.out.println("Fehlerhafte Eingabe! Erneut eingeben:");
			figurZugTyp = Tastatur.liesZahl();
		}
		zugAuswahl[figurAuswahl][figurZugTyp] = 1;
		return zugAuswahl;
	}
}
