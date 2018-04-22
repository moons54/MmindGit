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
	private CodeS guess;
	private Boolean modedeveloppeur;
	private Jeupropriete pro=new Jeupropriete();
	private static  int nbdechiffre;
	
	public Joueur(int taillecode,int nbdechiffre,boolean modedeveloppeur,int nbdecoup) {
		this.taillecode=taillecode;
		this.secretCode=createRandomCode(taillecode,nbdechiffre);
		this.modedeveloppeur=modedeveloppeur;
		this.nbdechiffre=nbdechiffre;
		this.nbdecoup=nbdecoup;
		//	this.guess=HypotheseJoueur(this.taillecode);

	}
	/**methode de jeu pour Mastermind joueur : decodeur ordinateur : codeur humain*/

	public Joueur Mastermind() {

		if (logger.isDebugEnabled()) {
			logger.debug("entering Mastermind()");
		}
		if (modedeveloppeur=true) {
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

			guess=this.HypotheseJoueur(taillecode,nbdechiffre);


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

	public static CodeS HypotheseJoueur(int length,int nbdechiffre) {
		if (logger.isDebugEnabled()) {
			logger.debug("entering HypotheseJoueur(int,int)");
			logger.debug("length: " + length);
			logger.debug("nbdechiffre: " + nbdechiffre);
		}
		Scanner sc1= new Scanner(System.in);

		System.out.println("code a saisir exemple sur "+length+ " positions puis ENTRER");
		String val1 = sc1.nextLine();
		T[] ts = new T[length];
		for (int i = 0; i < length; i++) {
		//	if (ts[i].ordinal()<nbdechiffre-1) {
				ts[i] = T.values()[Integer.parseInt(val1.substring(i, i+1))];
		//	}
	
		}

		if (logger.isDebugEnabled()) {
			logger.debug("exiting HypotheseJoueur()");
			logger.debug("returning: " + new CodeS(ts));
		}
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
		if (modedeveloppeur=true) {
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


			guess=this.HypotheseJoueur(taillecode,nbdechiffre);


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
