package com.company; 
public class Spielfeld {
	// Spielfeld hat 11x11 Zellen
	// Jede Zelle ist 5x3 Zeichen:
	// 12345
	//1 ┌──┐
	//2 │ab│
	//3 └──┘
	// Spielfeld ist also 33 Spalten und 55 Zeilen.
	
	char[][] zeichen = new char[33][55]; // Hier werden die 33x55 Zeichen gespeichert.
	
	char[][] feld_zelle = { {' ','┌','─','─','┐'},
							{' ','│',' ',' ','│'},
							{' ','└','─','─','┘'}};
	
	public Spielfeld(){
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
