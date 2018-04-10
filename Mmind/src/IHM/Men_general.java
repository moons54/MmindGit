package IHM;

import java.io.IOException;
import java.util.Scanner;

public class Men_general {


	/**
	 * Premier ecran IHM dans le cadre du Pattern MVC
	 * 
	 * definition des differnts modes de jeu 
	 * 1 mode alternatif mastermind
	 * 2 mode MASTERMIND
	 * 
	 */

	int espace=5;


	public Men_general() throws IOException{
		
		for (int i = 0; i < espace; i++) {
			System.out.println();
		}


		System.out.println("MODE DE JEU"+
				"\n"+"------------------------------------------------"+
				"\n"+"1  == MASTERMIND"+
				"\n"+"------------------------------------------------"+
				"\n"+"2  == MODE JEU ALTERNATIF LES PLUS ET LE MOINS"+
				"\n"+"------------------------------------------------");


		Scanner sc = new Scanner(System.in);
		System.out.println("Votre choix");
		int val = sc.nextInt();System.out.print("++");


		switch (val) {
		case 1:System.out.println("MASTERMIND  2018");

		for (int i = 0; i < espace; i++) {
			System.out.println();
		}
		new Men_mastermind();
		break;

		default:
			break;
		}



	}
	
}