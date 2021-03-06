package com.company;

import java.util.ArrayList;

public class Gui {
	// Spielfeld hat 11x11 Zellen
	// Jede Zelle ist 5x3 Zeichen:
	// 12345
	//1 ┌──┐
	//2 │ab│
	//3 └──┘
	// Spielfeld ist also 33 Spalten und 55 Zeilen.
	
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
	
	int[][] koordinaten_speicher = new int[72][2];
	
	String[][] zeichen = new String[33][55]; // Hier werden die 33x55 Zeichen gespeichert.
	
	String[][] feld_zelle = {{" ","┌","─","─","┐"},
							 {" ","│"," "," ","│"},
							 {" ","└","─","─","┘"}};
	
	int startfelder1[] = { 0, 1, 7, 8};
	int startfelder2[] = { 5, 6,12,13};
	//!! 3 und 4 getauscht, da im Kreis
	int startfelder4[] = {58,59,65,66};
	int startfelder3[] = {63,64,70,71};
	int startfelderAll[][] = {startfelder1, startfelder2, startfelder3, startfelder4};
	
	int zielfelder1[] = {32,33,34,35};
	int zielfelder2[] = {10,15,18,25};
	int zielfelder3[] = {39,38,37,36};
	int zielfelder4[] = {61,56,53,46};
	int zielfelderAll[][] = {zielfelder1, zielfelder2, zielfelder3, zielfelder4};
	
	int lauffelder[] = {20, 21, 22, 23, 24, 17, 14,  9,  2,  3,  // Ecke Spieler 1
						 4, 11, 16, 19, 26, 27, 28, 29, 30, 40,  // Ecke Spieler 2
						51, 50, 49, 48, 47, 54, 57, 62, 69, 68,  // Ecke Spieler 3
						67, 60, 55, 52, 45, 44, 43, 42, 41, 31}; // Ecke Spieler 4 
	
	public Gui(){
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

		for(i=0; i<4; i++){
			feld_zelle_einfaerben(koordinaten_speicher[zielfelder1[i]][0]-1, koordinaten_speicher[zielfelder1[i]][1]-2, ANSI_BLU_C);
			feld_zelle_einfaerben(koordinaten_speicher[zielfelder2[i]][0]-1, koordinaten_speicher[zielfelder2[i]][1]-2, ANSI_YEL_C);
			feld_zelle_einfaerben(koordinaten_speicher[zielfelder3[i]][0]-1, koordinaten_speicher[zielfelder3[i]][1]-2, ANSI_GRN_C);
			feld_zelle_einfaerben(koordinaten_speicher[zielfelder4[i]][0]-1, koordinaten_speicher[zielfelder4[i]][1]-2, ANSI_RED_C);
		}
		feld_zelle_einfaerben(koordinaten_speicher[20][0]-1, koordinaten_speicher[20][1]-2, ANSI_BLU_C);
		feld_zelle_einfaerben(koordinaten_speicher[04][0]-1, koordinaten_speicher[04][1]-2, ANSI_YEL_C);
		feld_zelle_einfaerben(koordinaten_speicher[51][0]-1, koordinaten_speicher[51][1]-2, ANSI_GRN_C);
		feld_zelle_einfaerben(koordinaten_speicher[67][0]-1, koordinaten_speicher[67][1]-2, ANSI_RED_C);

		zeichen[koordinaten_speicher[20][0]-2][koordinaten_speicher[20][1]] = "→";
		zeichen[koordinaten_speicher[04][0]][koordinaten_speicher[04][1]+2] = "↓";
		zeichen[koordinaten_speicher[51][0]+2][koordinaten_speicher[51][1]-1] = "←";
		zeichen[koordinaten_speicher[67][0]][koordinaten_speicher[67][1]-3] = "↑";
	}

	void setSpielfeldWithArrays(Figur[] spielfeld, ArrayList<Figur>[] startFiguren, Figur[][] zielFiguren)
	{
		for(int i = 0; i < 40; i++) // über Spielfeld iterieren
		{
			if(spielfeld[i] == null)
			{
				feldEintrag(lauffelder[i], " ", 5);
			}
			else
			{
				feldEintrag(lauffelder[i], spielfeld[i].getFarbe().toString(), spielfeld[i].getNummer());
			}
		}

		// Startfelder in Ausgabe löschen
		for(int j = 0; j < 4; j++)
		{
			for(int i = 0; i < 4; i++)
			{
				feldEintrag(startfelderAll[j][i], " ", 5);
			}
		}

		// Startfiguren eintragen
		int n = 0;
		int m = 0;
		for(ArrayList<Figur> arrList : startFiguren)
		{
			for(Figur figur : arrList)
			{
				feldEintrag(startfelderAll[n][m], startFiguren[n].get(m).getFarbe().toString(), startFiguren[n].get(m).getNummer());
				m++;
			}
			m = 0;
			n++;
		}

		for(int j = 0; j < 4; j++) // über Startfelder iterieren
		{
			for(int i = 0; i < 4; i++)
			{
				if(zielFiguren[j][i] == null)
				{
					feldEintrag(zielfelderAll[j][i], " ", 5);
				}
				else
				{
					feldEintrag(zielfelderAll[j][i], zielFiguren[j][i].getFarbe().toString(), zielFiguren[j][i].getNummer());
				}
			}
		}
	}
	
	void koordinatenFinder() // Findet die Koordinaten aller 72 Spielfelder. 40 Normale + 16 Start + 16 Ziel.
	{
		int i, j;
		
		int counter = 0;
		
		for(i=0; i<33; i++){
			for(j=0; j<55; j++){
				
				if(zeichen[i][j] == "┌")
				{
					koordinaten_speicher[counter][0] = 1+i;
					koordinaten_speicher[counter][1] = 2+j;
					counter++;
				}
			}
		}
	}
	
	void feldEintrag(int feldnummer, String character, int nummer) // Findet die Koordinaten aller 72 Spielfelder. 40 Normale + 16 Start + 16 Ziel.
	{
		if(character == " ")
		{
			zeichen[koordinaten_speicher[feldnummer][0]] [koordinaten_speicher[feldnummer][1]-1] = character;
			zeichen[koordinaten_speicher[feldnummer][0]] [koordinaten_speicher[feldnummer][1]] = character;
		}
		else
		{
			String FARBCODE;
			switch (character) {
				case "0":  FARBCODE = ANSI_BLU_C;
						break;
				case "1":  FARBCODE = ANSI_YEL_C;
						break;
				case "2":  FARBCODE = ANSI_GRN_C;
						break;
				case "3":  FARBCODE = ANSI_RED_C;
						break;
				default: FARBCODE = ANSI_RED_B;
						break;
			}
		zeichen[koordinaten_speicher[feldnummer][0]] [koordinaten_speicher[feldnummer][1]-1] = FARBCODE+nummer+ANSI_RESET;
		zeichen[koordinaten_speicher[feldnummer][0]] [koordinaten_speicher[feldnummer][1]] = FARBCODE+FIGURE+ANSI_RESET;
		}
		
	}
	
	void ver_flipper(){
		int x,y;
		for(y=0; y<=16; y++){
			for(x=1; x<=26; x++){
				switch (zeichen[y][x]) {
					case "┌":  zeichen[y][55-x] = "┐";
							break;
					case "└":  zeichen[y][55-x] = "┘";
							break;
					case "┐":  zeichen[y][55-x] = "┌";
							break;
					case "┘":  zeichen[y][55-x] = "└";
							break;
					case "├":  zeichen[y][55-x] = "┤";
							break;
					case "┤":  zeichen[y][55-x] = "├";
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
					case "┌":  zeichen[32-y][x] = "└";
							break;
					case "└":  zeichen[32-y][x] = "┌";
							break;
					case "┐":  zeichen[32-y][x] = "┘";
							break;
					case "┘":  zeichen[32-y][x] = "┐";
							break;
					case "┬":  zeichen[32-y][x] = "┴";
							break;
					case "┴":  zeichen[32-y][x] = "┬";
							break;
					default: zeichen[32-y][x] = zeichen[y][x];
							break;
				}
			}
		}
		
	}
	
	void feld_zelle_einfaerben(int x, int y, String farbe){
		int a,b;
		for(a=0; a<3; a++){
			for(b=0; b<4; b++){
				zeichen[a+x][b+y] = farbe+zeichen[a+x][b+y]+ANSI_RESET;
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
				zeichen[a+x*3][b+y*5] = " ";
			}
		}
	}
	
	void linie_zeichnen(int x, int y){
		zeichen[1+y*3][4+x*5] = "├";
		zeichen[1+y*3][5+x*5] = "─";
		zeichen[1+y*3][6+x*5] = "┤";
		
		zeichen[2+x*3][2+y*5] = "┬";
		zeichen[3+x*3][2+y*5] = "┴";
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
