package IHM;

import java.io.IOException;
import java.util.Scanner;

import model.Duel;
import model.Jeupropriete;
import model.Joueur;
import model.Simul;
import model.Stat;
import model.Test1;
import strategie.Knuth2;

public class Men_plusetmoins {


	public Men_plusetmoins() throws IOException{
		System.out.println("\n"
				+"\n"+
				"                        +++                  //                      "+"\n"+
				"                        +++                 //                       "+"\n"+
				"                   +++++++++++++           //          +++++++++++++ "+"\n"+
				"                   +++++++++++++          //           +++++++++++++ "+"\n"+
				"                        +++              //                          "+"\n"+
				"                        +++             //                           "+"\n"+
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
		bouclechoix(val);
	}

	public void bouclechoix(int val) throws IOException {
		switch (val) {
		case 1:
			System.out.println("Merci de saisir le code Secret ");
			Simul sim= new Simul(4,new Knuth2(4));
			sim.plusmoinsIA();
			replay(val);
			break;
		case 2: 
			System.out.println("Mode challenger");
			Joueur jo=new Joueur(4);
			jo.plusmoinsJoueur();
			replay(val);
		case 3:
			System.out.println("Mode DUEL "+"\n"
					+"____________________________"+"\n"
					+ "|  Joueur 1 : Humain       |"+"\n"
					+"____________________________"+"\n"
					+"|   Joueur 2 : Ordinateur  |"+"\n"
					+"____________________________"+"\n"
					+"Objectif : Trouver la combinaison secrete en premier");

			//	Duel du = new Duel(4,new Knuth2(4));
			Duel du1=new Duel(4,Jeupropriete.getSTRATEGIE1());
			du1.DuelPlusMoins();
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

