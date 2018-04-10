package IHM;

import java.util.Scanner;

import model.Duel;
import model.Joueur;
import model.Test1;
import strategie.Knuth2;

public class Men_mastermind {




	public Men_mastermind() {
		System.out.println("\n"
				+"\n"+
				"                  MMMM    MMM       A       SSSSSS  TTTTTTT  EEEEEEE  RRRRR     MMMMM    MMM   I  NN   N   DDD  "+"\n"+
				"                  M   M  M  M      A A      S          T     E        R   R     M    M  M  M   I  N N  N   D  D"+"\n"+
				"                  M    M M  M     A   A     SSSSSS     T     EEEE     RRRR      M    M M   M   I  N  N N   D   D"+"\n"+
				"                  M     M   M    A  A  A         S     T     E        R   R     M     M    M   I  N   NN   D  D "+"\n"+
				"                  M         M   A       A   SSSSSS     T     EEEEEE   R    R    M          M   I  N    N   DDD"+"\n"+
				"\n"+

				"\n"+"-----------------------------------------------------------------------"+
				"\n"+"CHOIX 1 MODE DEFENSEUR : Codeur : Joueur contre Décodeur : L'ordinateur"+
				"\n"+"-----------------------------------------------------------------------"+
				"\n"+"CHOIX 2 : MODE CHALLENGER: L'ordinateur contre le Décodeur : le joueur"+
				"\n"+"------------------------------------------------------------------------"+
				"\n"+"CHOIX 3 : MODE DUEL: Partie tour a tour pour trouver le code confidentiel"+
				"\n"+"------------------------------------------------------------------------"+
				"\n"+"Votre choix : ");

		Scanner sc = new Scanner(System.in);

		int val = sc.nextInt();


		switch (val) {
		case 1:
			System.out.println("Merci de saisir le code confidentiel ");
			Test1.main(null);;


			break;
		case 2: 
			System.out.println("Mode challenger");
			Joueur jo=new Joueur(4);
			jo.run();

		case 3:
			System.out.println("Merci de saisir le code confidentiel ");
			Duel du = new Duel(4,new Knuth2(4));
du.run();

		default:
			break;
		}
	}
}
