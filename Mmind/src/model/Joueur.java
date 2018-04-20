package model;


import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;

import IHM.Men_general;
import model.CodeS;
import model.Reponse;


public class Joueur {

	private int taillecode;
	private CodeS secretCode;
	private CodeS guess;
	private int chiffre;
	private Jeupropriete pro=new Jeupropriete();
	
	
	public Joueur(int taillecode) {
		this.taillecode=taillecode;
		this.secretCode=createRandomCode(this.taillecode);
		//	this.guess=HypotheseJoueur(this.taillecode);

	}
	/**methode de jeu pour Mastermind joueur : decodeur ordinateur : codeur humain*/

	public Joueur run() {

		System.out.println(" code secret "+secretCode.toString());
		
		CodeS guess=new CodeS();


		for (int i = 1; i <pro.getNbcoup() ; i++) {

			guess=this.HypotheseJoueur(taillecode);


			Reponse reponse = guess.compare(this.secretCode);


			if (reponse.blacks==this.taillecode) {
				System.out.println("vous avez Gagné en "+i+" coup");



				break;

			}else {

				System.out.println(reponse.toString()+" tour numéro "+(i));
				System.out.println();
				System.out.println(guess.toString());
				if (i==5) {
					System.out.println("Perdu !!");
				}
			}

			guess.get(this.taillecode-1);
		}


		return null ;
	}

	public static CodeS HypotheseJoueur(int length) {
		Scanner sc1= new Scanner(System.in);

		System.out.println("code a saisir exemple sur "+length+ " positions puis ENTRER");
		String val1 = sc1.nextLine();
		T[] ts = new T[length];
		for (int i = 0; i < length; i++) {
			ts[i] = T.values()[Integer.parseInt(val1.substring(i, i+1))];


		}

		return new CodeS(ts);
	}

	public static CodeS createRandomCode(int length) {
		Random rnd = new Random();
		T[] ts = new T[length];
		for (int i = 0; i < length; i++) {
			ts[i] = T.values()[rnd.nextInt(8)];

		}
		return new CodeS(ts);
	}



	/**
	 * Methode de jeu plus et moins joueur humain et ordinateur code
	 * un appel est fait pour la methode plusetmoins qui analyse la réponse
	 * @return
	 */
	public Joueur plusmoinsJoueur() {

		System.out.println(" code secret "+secretCode.toString());

		for (int i = 1; i <pro.getNbcoup() ; i++) {


			guess=this.HypotheseJoueur(taillecode);


			System.out.println("valeur du guess"+guess.toString());

			guess.plusetmoins(this.secretCode);

			if (this.guess.equals(secretCode))  {

				System.out.println("vous avez Gagné en "+(i+1)+" coup");
				break;

			}
			System.out.println(guess.toString());

			if (i==5) {
				System.out.println("Perdu !!");
			}
		}

		guess.get(this.taillecode-1);

		return null ;
	}

}
