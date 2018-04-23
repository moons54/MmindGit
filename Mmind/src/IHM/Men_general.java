package IHM;

import java.io.IOException;
import java.util.Scanner;

import model.Erreur;


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
		
		/**chargement du fichier confo.properties */
		
		
		
		for (int i = 0; i < espace; i++) {
			System.out.println();
		}


		System.out.println("MODE DE JEU"+
				"\n"+"------------------------------------------------"+
				"\n"+"1  == MASTERMIND"+
				"\n"+"------------------------------------------------"+
				"\n"+"2  == MODE JEU ALTERNATIF LES PLUS ET LE MOINS"+
				"\n"+"------------------------------------------------"+
				"\n"+"3  == Quitter"+
				"\n"+"------------------------------------------------");
		
		int val=0;
		do {

		Scanner sc = new Scanner(System.in);
		System.out.println("Votre choix");
		
		
		if(!sc.hasNextInt()) {
			Erreur.erreurChoix();
			continue;
		}
	 val = sc.nextInt();
		switch (val) {
		
		
		case 1:System.out.println("MASTERMIND  2018");
		for (int i = 0; i < espace; i++) {
			System.out.println();
		}
		new Men_mastermind();
		break;
		case 2:System.out.println("chargement +/-");
		for (int i = 0; i < espace; i++) {
			System.out.println();
		}
		new Men_plusetmoins();
		
		case 3:
			System.out.println("Merci d'avoir joué. fin de partie");
			break;
		
		
		
		default:
			Erreur.erreurChoix();
			break;
		}


	}while (val != 1 && val != 2 && val != 3 );
	}
}
