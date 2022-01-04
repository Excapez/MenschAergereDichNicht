package com.company;
import com.company.Spielfeld;

public class Main {

	public static void main(String[] args) {
		// write your code here
		com.company.Spielfeld spielfeld1 = new Spielfeld();
		MenschAergereDichNicht menschAergereDichNicht = new MenschAergereDichNicht();
		menschAergereDichNicht.spielInit();
		
		com.company.Gui gui = new Gui();
		
		spielfeld1.feldEintrag(gui.startfelder3[2]);
		
		spielfeld1.spielfeld_drucken();
	}
}
