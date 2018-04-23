package IHM;

import java.io.IOException;

import java.util.Scanner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import model.Duel;
import model.Erreur;
import model.IA;
import model.Jeupropriete;
import model.Joueur;

import model.Stat;
import strategie.Knuth2;
import strategie.Simple;
import IHM.Men_general;



public class Men_mastermind {


	static final Logger logger = LogManager.getLogger();



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



		int val1=0;

		do {
			Scanner sc = new Scanner(System.in);


			if(!sc.hasNextInt()) {
				Erreur.erreurChoix();
				continue;
			}

			val1= sc.nextInt();

			Jeupropriete pro = new Jeupropriete();

			switch (val1) {
			case 1:
				System.out.println("Mode Defenseur");

				switch (pro.getIAchoix()) {
				case 1:
					System.out.println("STRATEGIE KNUTH");
					IA sim= new IA(Jeupropriete.getTaillecode(),   new Knuth2(Jeupropriete.getTaillecode()),pro.getNbchiffre(),pro.getModedeveloppeur(),pro.getNbcoup());
					sim.IAmastermind();
					break;
				case 2:
					System.out.println("STRATEGIE SIMPLE");
					IA sim2= new IA(Jeupropriete.getTaillecode(),   new Simple(Jeupropriete.getTaillecode()),pro.getNbchiffre(),pro.getModedeveloppeur(),pro.getNbcoup());
					sim2.IAmastermind();
					break;
				default:

					break;
				}

				replay(val1);
				break;
			case 2: 
				System.out.println("Mode challenger");
				Joueur jo=new Joueur(pro.getTaillecode(),pro.getNbchiffre(),pro.getModedeveloppeur(),pro.getNbcoup());
				jo.Mastermind();
				replay(val1);
				break;
			case 3:
				System.out.println("Mode DUEL");
				switch (pro.getIAchoix()) {
				case 1:
					System.out.println("STRATEGIE KNUTH");
					Duel du= new Duel(Jeupropriete.getTaillecode(),   new Knuth2(Jeupropriete.getTaillecode()),pro.getNbchiffre(),pro.getModedeveloppeur(),pro.getNbcoup());
					du.run();
					break;
				case 2:
					System.out.println("STRATEGIE SIMPLE");
					System.out.println("val chiffre"+pro.getNbchiffre());
					Duel du1= new Duel(Jeupropriete.getTaillecode(),   new Simple(Jeupropriete.getTaillecode()),pro.getNbchiffre(),pro.getModedeveloppeur(),pro.getNbcoup());
					du1.run();
					break;
				default:

					break;
				}


				replay(val1);
			default:
				break;

			}

		}while (val1 != 1 && val1 != 2 && val1 != 3 );

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
