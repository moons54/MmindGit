package IHM;

import java.io.IOException;
import java.util.Properties;
import java.util.Scanner;

import model.Duel;
import model.Jeupropriete;
import model.Joueur;
import model.Simul;
import model.Test1;
import strategie.Knuth2;
import IHM.Men_general;
import model.Jeupropriete;

public class Men_mastermind {




	public Men_mastermind() throws IOException {
		
		
		System.out.println("\n"
				+"\n"+
				"                  MMMM    MMM       A       SSSSSS  TTTTTTT  EEEEEEE  RRRRR     MMMMM    MMM   I  NN   N   DDD  "+"\n"+
				"                  M   M  M  M      A A      S          T     E        R   R     M    M  M  M   I  N N  N   D  D"+"\n"+
				"                  M    M M  M     A   A     SSSSSS     T     EEEE     RRRR      M    M M   M   I  N  N N   D   D"+"\n"+
				"                  M     M   M    A  A  A         S     T     E        R   R     M     M    M   I  N   NN   D  D "+"\n"+
				"                  M         M   A       A   SSSSSS     T     EEEEEE   R    R    M          M   I  N    N   DDD"+"\n"+
				"\n"+

				"\n"+"-----------------------------------------------------------------------"+
				"\n"+"CHOIX 1 : MODE DEFENSEUR : Codeur : Joueur contre Décodeur : L'ordinateur"+
				"\n"+"-----------------------------------------------------------------------"+
				"\n"+"CHOIX 2 : MODE CHALLENGER: L'ordinateur contre le Décodeur : le joueur"+
				"\n"+"------------------------------------------------------------------------"+
				"\n"+"CHOIX 3 : MODE DUEL: Partie tour a tour pour trouver le code confidentiel"+
				"\n"+"------------------------------------------------------------------------"+
				"\n"+"Votre choix : ");

		Scanner sc = new Scanner(System.in);

		int val = sc.nextInt();
		bouclechoix(val);
	}
	public void bouclechoix(int val) throws IOException {
		switch (val) {
		case 1:
			System.out.println("Saisie du code Secret ");
			//Simul sim= new Simul(Jeupropriete.taillecode,  Jeupropriete.STRATEGIE1);
			Test1.main(null);
			replay(val);
			break;
		case 2: 
			System.out.println("Mode challenger");
			Joueur jo=new Joueur(Jeupropriete.taillecode);
			jo.run();
			replay(val);
		case 3:
			System.out.println("Merci de saisir le code confidentiel ");
			Duel du = new Duel(4,new Knuth2(4));
			du.run();
			replay(val);
		default:
			break;
		}

	}

	public void replay(int val) throws IOException {
		System.out.println("Souhaitez vous ?"
				+"\n"+"1____Rejouer une partie"
				+"\n"+"2____Changer de jeu"
				+"\n"+"3____Quitter l'application");

		Scanner scc= new Scanner(System.in);

		int retourchoix=scc.nextInt();
		switch (retourchoix) {
		case 1:
			bouclechoix(val);
			break;
		case 2:
			new Men_general();

		default:
			System.out.println("Fin de partie");
			break;
		}	

	}
}
