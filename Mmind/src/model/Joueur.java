package model;


import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;

import IHM.Men_general;
import model.CodeS;
import model.Reponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Joueur {

	private static final Logger logger = LogManager.getLogger(Joueur.class);
	private static int nbdecoup;
	private static int taillecode;
	private CodeS secretCode;
	private static CodeS guess;
	private int modedeveloppeur;
	private Jeupropriete pro=new Jeupropriete();
	private static  int nbdechiffre;

	public Joueur(int taillecode,int nbdechiffre,int modedeveloppeur,int nbdecoup) {
		this.taillecode=taillecode;
		this.secretCode=createRandomCode(taillecode,nbdechiffre);
		this.modedeveloppeur=modedeveloppeur;
		this.nbdechiffre=nbdechiffre;
		this.nbdecoup=nbdecoup;


	}
	/**methode de jeu pour Mastermind joueur : decodeur ordinateur : codeur humain*/

	public Joueur Mastermind() {

		if (logger.isDebugEnabled()) {
			logger.debug("entering Mastermind()");
		}
		if (pro.getModedeveloppeur()==1) {
			System.out.println("__________________________________");
			System.out.println("Nombre de coup:" + nbdecoup);
			System.out.println("__________________________________");
			System.out.println("Nombre de Chiffre :" + nbdechiffre);
			System.out.println("__________________________________");
			System.out.println("Nombre de Bouton :" + taillecode);
			System.out.println("__________________________________");
			System.out.println(" code secret "+secretCode.toString());
			System.out.println("__________________________________");
		}


		CodeS guess=new CodeS();


		for (int i = 1; i <nbdecoup; i++) {

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


		if (logger.isDebugEnabled()) {
			logger.debug("exiting Mastermind()");
			logger.debug("returning: " + null);
		}
		return null ;
	}

	public static CodeS HypotheseJoueur(int length) {
		Jeupropriete pro=new Jeupropriete();

		System.out.println("Combinaison : ");



		String val1=null;

		T[] ts = new T[length];
		/** creation d'une boucle permettant de restreindre la saisie clavier uniquement au combinaison definit par l'utilisateur
		 * 
		 */
		do {
			Scanner sc1= new Scanner(System.in);

			val1=sc1.nextLine();
			if (!val1.matches("[0-"+pro.getNbchiffre()+"]+") || val1.length() !=pro.getTaillecode()) {

				Erreur.erreurNbr();
			}
			else {
				for (int i = 0; i < length; i++) {
					ts[i] = T.values()[Integer.parseInt(val1.substring(i, i+1))];

				}


			}
		}	while (val1.length()!= pro.getTaillecode() || !val1.matches("[0-"+pro.getNbchiffre()+"]+"));

		return new CodeS(ts);
	}


	public static CodeS createRandomCode(int length,int nbdechiffre) {
		if (logger.isDebugEnabled()) {
			logger.debug("entering createRandomCode(int,int)");
			logger.debug("length: " + length);
			logger.debug("nbdechiffre: " + nbdechiffre);
		}
		Random rnd = new Random();
		T[] ts = new T[length];
		for (int i = 0; i < length; i++) {
			ts[i] = T.values()[rnd.nextInt(nbdechiffre)];

		}
		if (logger.isDebugEnabled()) {
			logger.debug("exiting createRandomCode()");
			logger.debug("returning: " + new CodeS(ts));
		}
		return new CodeS(ts);
	}



	/**
	 * Methode de jeu plus et moins joueur humain et ordinateur code
	 * un appel est fait pour la methode plusetmoins qui analyse la réponse
	 * @return
	 */
	public Joueur plusmoinsJoueur() {


		if (logger.isDebugEnabled()) {
			logger.debug("entering plusmoinsJoueur()");
		}
		if (pro.getModedeveloppeur()==1) {
			System.out.println("__________________________________");
			System.out.println("Nombre de coup:" + nbdecoup);
			System.out.println("__________________________________");
			System.out.println("Nombre de Chiffre :" + nbdechiffre);
			System.out.println("__________________________________");
			System.out.println("Nombre de Bouton :" + taillecode);
			System.out.println("__________________________________");
			System.out.println(" code secret "+secretCode.toString());
			System.out.println("__________________________________");
		}


		for (int i = 1; i <nbdecoup ; i++) {


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

		if (logger.isDebugEnabled()) {
			logger.debug("exiting plusmoinsJoueur()");
			logger.debug("returning: " + null);
		}
		return null ;
	}

}
