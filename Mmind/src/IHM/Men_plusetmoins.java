package IHM;

import java.io.IOException;
import java.util.Scanner;

import model.Duel;
import model.Erreur;
import model.IA;
import model.Jeupropriete;
import model.Joueur;
import model.Stat;

import strategie.Knuth2;
import strategie.Simple;

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

		

		int val = 0;
		do {
			Scanner sc = new Scanner(System.in);
			if(!sc.hasNextInt()) {
				Erreur.erreurChoix();
				continue;
				}
		
				
		
	val=sc.nextInt();

	
		Jeupropriete pro = new Jeupropriete();
		
		switch (val) {
		
		case 1:
			System.out.println("Merci de saisir le code Secret ");
			IA sim= new IA(pro.getTaillecode(),new Knuth2(pro.getTaillecode()),pro.getNbchiffre(),pro.getModedeveloppeur(),pro.getNbcoup());
			sim.plusmoinsIA();
			replay(val);
			break;
		case 2: 
			System.out.println("Mode challenger");
			Joueur jo=new Joueur(pro.getTaillecode(),pro.getNbchiffre(),pro.getModedeveloppeur(),pro.getNbcoup());
			jo.plusmoinsJoueur();
			replay(val);
			break;
		case 3:
			System.out.println("Mode DUEL "+"\n"
					+"____________________________"+"\n"
					+ "|  Joueur 1 : Humain       |"+"\n"
					+"____________________________"+"\n"
					+"|   Joueur 2 : Ordinateur  |"+"\n"
					+"____________________________"+"\n"
					+"Objectif : Trouver la combinaison secrete en premier");

			//	Duel du = new Duel(4,new Knuth2(4));
			Duel du1=new Duel(Jeupropriete.getTaillecode(),   new Simple(Jeupropriete.getTaillecode()),pro.getNbchiffre(),pro.getModedeveloppeur(),pro.getNbcoup());
			du1.DuelPlusMoins();
			replay(val);
		default:
			break;
		}
		
		}while (val != 1 && val != 2 && val != 3 );

	}

	public void replay(int val) throws IOException {
		Stat stat= new Stat();
		System.out.println("Souhaitez vous ?"
				+"\n"+"1____Rejouer une partie"
				+"\n"+"2____Changer de jeu"
				+"\n"+"3____Quitter l'application");

		int retourchoix=0;
		do {
			Scanner scc= new Scanner(System.in);
			if(!scc.hasNextInt()) {
				Erreur.erreurChoix();
				continue;
			}
			retourchoix=scc.nextInt();
			Jeupropriete pro=new Jeupropriete();

			switch (retourchoix) {
			case 1:
				new Men_mastermind();
				break;
			case 2:
				new Men_general();
			case 3:

				System.out.println("fin de partie");
				break;
			default:
				Erreur.erreurChoix();
				break;
			}

		}while(retourchoix !=1 && retourchoix !=2 && retourchoix !=3 );
	}
}

