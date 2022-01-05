package com.company;

import java.util.ArrayList;

public class Spielfeld {
	Gui gui = new Gui();
	
	Figur[] spielfeld = new Figur[40]; // Speichern der Figurposition

	ArrayList<Figur>[] startFiguren = (ArrayList<Figur>[]) new ArrayList[4]; // Array mit ArrayLists der Startfelder für Figuren (Dynamische ArrayList, da Position der Figur im Haus egal und Handhabung einfacher
	
	Figur[][] zielFiguren = {new Figur[4], new Figur[4], new Figur[4], new Figur[4]}; //Array mit Arrays der Zielfiguren
	
	public Spielfeld(){
		for(int i = 0; i < 4; i++)
		{
			startFiguren[i] = new ArrayList<>();
		}
	}
	
	// Spielfeld/Start/Ziel Arrays anhand aller Figuren aktualisieren
	void updateCompleteSpielfeld(Spieler[] spieler)
	{
		deleteSpielfeld();
		for(int i = 0; i < 4; i++)
		{
			for (Figur figur : spieler[i].getFiguren()) {
				switch(figur.getZustand())
				{
					case Figur.START:
						startFiguren[i].add(figur);
						break;
							
					case Figur.FELD:
						spielfeld[figur.getPosition()] = figur;
						break;
						
					case Figur.ZIEL:
						zielFiguren[i][figur.getPosition()] = figur;
				}
			}
		}
	}
	
	// Initialisieren des Spielfeldes (Startfiguren in passende ArrayLists packen)
	void initSpielfeld(Spieler[] spieler)
	{
		// Passende Figuren in startFiguren-ArrayListen speichern
		for(int i = 0; i < 4; i++)
		{
			for (Figur figur : spieler[i].getFiguren()) {
				startFiguren[spieler[i].getFarbe()].add(figur);
			}
		}
	}
	
	// Kompletten Spielfeldspeicher zurücksetzen
	void deleteSpielfeld()
	{
		for(int i = 0; i < 40; i++)
		{
			spielfeld[i] = null;
		}
		
		for(int i = 0; i < 4; i++)
		{
			startFiguren[i].clear();
		}
		
		for(int i = 0; i < 4; i++)
			for(int j = 0; j < 4; j++)
			{
				zielFiguren[i][j] = null;
			}
	}

	void spielfeldDrucken(Spieler[] spieler)
	{
		updateCompleteSpielfeld(spieler);
		updateGui();
		gui.spielfeld_drucken();
	}

	void updateGui()
	{
		gui.setSpielfeldWithArrays(spielfeld, startFiguren, zielFiguren);
	}
}