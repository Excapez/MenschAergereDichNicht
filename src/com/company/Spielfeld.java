package com.company;

import java.util.ArrayList;

public class Spielfeld {
	// Spielfeld hat 11x11 Zellen
	// Jede Zelle ist 5x3 Zeichen:
	// 12345
	//1 ┌──┐
	//2 │ab│
	//3 └──┘
	// Spielfeld ist also 33 Spalten und 55 Zeilen.
		
	
	//Λ↑↓→←⌂▲Λs♥♦♣♠¡
	
	public static final String FIGURE = "▲";
	
	public static final String ANSI_RESET = "\u001B[0m";
	
	public static final String ANSI_BLU_C = "\u001B[34m";
	public static final String ANSI_YEL_C = "\u001B[33m";
	public static final String ANSI_GRN_C = "\u001B[32m";
	public static final String ANSI_RED_C = "\u001B[31m";
	
	public static final String ANSI_BLU_B = "\u001B[44m";
	public static final String ANSI_YEL_B = "\u001B[43m";
	public static final String ANSI_GRN_B = "\u001B[42m";
	public static final String ANSI_RED_B = "\u001B[41m";
	
	
	int[][] koordianten_speicher = new int[72][3]; // speichert die XY Koordianten aller 72 Spielfelder.
	/*
	┌──┐ ┌──┐.......... ┌──┐ ┌──┐ ┌──┐ ..........┌──┐ ┌──┐
	│00│ │01│.......... │02├─┤03│─┤04│ ..........│05│ │06│
	└──┘ └──┘.......... └┬─┘ └──┘ └─┬┘ ..........└──┘ └──┘
	┌──┐ ┌──┐.......... ┌┴─┐ ┌──┐ ┌─┴┐ ..........┌──┐ ┌──┐
	│07│ │08│.......... │09│ │10│ │11│ ..........│12│ │13│
	└──┘ └──┘.......... └┬─┘ └──┘ └─┬┘ ..........└──┘ └──┘
	................... ┌┴─┐ ┌──┐ ┌─┴┐ ...................
	................... │14│ │15│ │16│ ...................
	................... └┬─┘ └──┘ └─┬┘ ...................
	................... ┌┴─┐ ┌──┐ ┌─┴┐ ...................
	................... │17│ │18│ │19│ ...................
	................... └┬─┘ └──┘ └─┬┘ ...................
	┌──┐ ┌──┐ ┌──┐ ┌──┐ ┌┴─┐ ┌──┐ ┌─┴┐ ┌──┐ ┌──┐ ┌──┐ ┌──┐
	│20├─┤21├─┤22├─┤23├─┤24│ │25│ │26├─┤27├─┤28├─┤29├─┤30│
	└┬─┘ └──┘ └──┘ └──┘ └──┘ └──┘ └──┘ └──┘ └──┘ └──┘ └─┬┘
	┌┴─┐ ┌──┐ ┌──┐ ┌──┐ ┌──┐......┌──┐ ┌──┐ ┌──┐ ┌──┐ ┌─┴┐
	│31│ │32│ │33│ │34│ │35│......│36│ │37│ │38│ │39│ │40│
	└┬─┘ └──┘ └──┘ └──┘ └──┘......└──┘ └──┘ └──┘ └──┘ └─┬┘
	┌┴─┐ ┌──┐ ┌──┐ ┌──┐ ┌──┐ ┌──┐ ┌──┐ ┌──┐ ┌──┐ ┌──┐ ┌─┴┐
	│41├─┤42├─┤43├─┤44├─┤45│ │46│ │47├─┤48├─┤49├─┤50├─┤51│
	└──┘ └──┘ └──┘ └──┘ └┬─┘ └──┘ └─┬┘ └──┘ └──┘ └──┘ └──┘
	................... ┌┴─┐ ┌──┐ ┌─┴┐ ...................
	................... │52│ │53│ │54│ ...................
	................... └┬─┘ └──┘ └─┬┘ ...................
	................... ┌┴─┐ ┌──┐ ┌─┴┐ ...................
	................... │55│ │56│ │57│ ...................
	................... └┬─┘ └──┘ └─┬┘ ...................
	┌──┐ ┌──┐.......... ┌┴─┐ ┌──┐ ┌─┴┐ ..........┌──┐ ┌──┐
	│58│ │59│.......... │60│ │61│ │62│ ..........│63│ │64│
	└──┘ └──┘.......... └┬─┘ └──┘ └─┬┘ ..........└──┘ └──┘
	┌──┐ ┌──┐.......... ┌┴─┐ ┌──┐ ┌─┴┐ ..........┌──┐ ┌──┐
	│65│ │66│.......... │67├─┤68│─┤69│ ..........│70│ │71│
	└──┘ └──┘.......... └──┘ └──┘ └──┘ ..........└──┘ └──┘
	*/
	
	char[][] zeichen = new char[33][55]; // Hier werden die 33x55 Zeichen gespeichert.
	
	char[][] feld_zelle = { {' ','┌','─','─','┐'},
							{' ','│',' ',' ','│'},
							{' ','└','─','─','┘'}};

	Figur[] spielfeld = new Figur[40]; // Speichern der Figurposition

	ArrayList<Figur>[] startFiguren = (ArrayList<Figur>[]) new ArrayList[4]; // Array mit ArrayLists der Startfelder für Figuren (Dynamische ArrayList, da Position der Figur im Haus egal und Handhabung einfacher
	
	//Figur[][] startFiguren = {new Figur[4], new Figur[4], new Figur[4], new Figur[4]}; //Array mit Arrays der Startfiguren
	
	Figur[][] zielFiguren = {new Figur[4], new Figur[4], new Figur[4], new Figur[4]}; //Array mit Arrays der Zielfiguren

	public Spielfeld(){
		for(int i = 0; i < 4; i++)
		{
			startFiguren[i] = new ArrayList<>();
		}

		int i, j;
		// Kästchen in der oberen linken Ecke zeichnen.
		for(i=0; i<6; i++){
			for(j=0; j<6; j++){
				if(((i < 2 ) | (3 < i)) & ((j < 2 ) | (3 < j))){ // Wenn wir in einer feld_zelle sind...
					feld_zelle_zeichnen(i,j); // Male hier eine feld_zelle hin.
				}
				else if((3 < i) | (3 < j)){
					feld_zelle_zeichnen(i,j);
				}
				else{
					leere_zelle_zeichnen(i,j);
				}
			}
		}
		leere_zelle_zeichnen(5,5); // In der Mitte ist kein Feld.
		
		// Linien zwischen Kästchen zeichnen
		linie_zeichnen(4,0);
		
		linie_zeichnen(0,4);
		linie_zeichnen(1,4);
		linie_zeichnen(2,4);
		linie_zeichnen(3,4);
		
		// Da das Spielbrett symmetrisch ist wird nun die obere linke ecke gespiegelt.
		ver_flipper();
		hor_flipper();
		
		koordinatenFinder();
		
		int startfelder1[] = {0,1,7,8};
		
		zeichen[ koordianten_speicher[startfelder1[3]] [1]  ][ koordianten_speicher[startfelder1[3]] [2]  ] = 'X';
	}
	
	void koordinatenFinder() // Findet die Koordinaten aller 72 Spielfelder. 40 Normale + 16 Start + 16 Ziel.
	{
		
		int i, j;
		
		int counter = 0;
		
		for(i=0; i<33; i++){
			for(j=0; j<55; j++){
				
				if(zeichen[i][j] == '┌')
				{
					koordianten_speicher[counter][0] = counter;
					koordianten_speicher[counter][1] = 1+i;
					koordianten_speicher[counter][2] = 2+j;
					counter++;
					
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
				//startFiguren[i][spieler[i].getFarbe()] = figur;
			}
		}
	}

	// Spielfeld/Start/Ziel Arrays anhand aller Figuren aktualisieren
	void updateCompleteSpielfeld(Spieler[] spieler)
	{
		for(int i = 0; i < 4; i++)
		{
			for (Figur figur : spieler[i].getFiguren()) {
				switch(figur.getZustand())
				{
					case Figur.START:
						startFiguren[i].add(figur);
						//startFiguren[i][figur.getPosition()] = figur;
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
			//startFiguren[i] = null;
		}

		for(int i = 0; i < 4; i++)
			for(int j = 0; j < 4; j++)
			{
				zielFiguren[i][j] = null;
			}
	}
	
	void ver_flipper(){
		int x,y;
		for(y=0; y<=16; y++){
			for(x=1; x<=25; x++){
				switch (zeichen[y][x]) {
					case '┌':  zeichen[y][55-x] = '┐';
							break;
					case '└':  zeichen[y][55-x] = '┘';
							break;
					case '┐':  zeichen[y][55-x] = '┌';
							break;
					case '┘':  zeichen[y][55-x] = '└';
							break;
					case '├':  zeichen[y][55-x] = '┤';
							break;
					case '┤':  zeichen[y][55-x] = '├';
							break;
					default: zeichen[y][55-x] = zeichen[y][x];
							break;
				}
			}
		}
	}
	
	void hor_flipper(){
		int x,y;
		for(x=0; x<=54; x++){
			for(y=0; y<=16; y++){
				switch (zeichen[y][x]) {
					case '┌':  zeichen[32-y][x] = '└';
							break;
					case '└':  zeichen[32-y][x] = '┌';
							break;
					case '┐':  zeichen[32-y][x] = '┘';
							break;
					case '┘':  zeichen[32-y][x] = '┐';
							break;
					case '┬':  zeichen[32-y][x] = '┴';
							break;
					case '┴':  zeichen[32-y][x] = '┬';
							break;
					default: zeichen[32-y][x] = zeichen[y][x];
							break;
				}
			}
		}
		
	}
	
	void feld_zelle_zeichnen(int x, int y){
		int a,b;
		for(a=0; a<3; a++){
			for(b=0; b<5; b++){
				zeichen[a+x*3][b+y*5] = feld_zelle[a][b];
			}
		}
	}
	
	void leere_zelle_zeichnen(int x, int y){
		int a,b;
		for(a=0; a<3; a++){
			for(b=0; b<5; b++){
				zeichen[a+x*3][b+y*5] = ' ';
			}
		}
	}
	
	void linie_zeichnen(int x, int y){
		zeichen[1+y*3][4+x*5] = '├';
		zeichen[1+y*3][5+x*5] = '─';
		zeichen[1+y*3][6+x*5] = '┤';
		
		zeichen[2+x*3][2+y*5] = '┬';
		zeichen[3+x*3][2+y*5] = '┴';
	}
	
	void spielfeld_drucken(){
		int i, j;
		for(i=0; i<33; i++){
			for(j=0; j<55; j++){
				System.out.print(zeichen[i][j]);
			}
			System.out.println();
		}
	}
}
