package model;


import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;

import model.CodeS;
import model.Reponse;


public class Joueur {

	private int taillecode;
	private CodeS secretCode;
	private CodeS guess;



	public Joueur(int taillecode) {
		this.taillecode=taillecode;
		this.secretCode=createRandomCode(this.taillecode);
		this.guess=HypotheseJoueur(this.taillecode);

	}
	public Joueur run() {

		System.out.println(" code secret "+secretCode.toString());
		//System.out.println(guess.toString());
		CodeS guess=new CodeS();


		for (int i = 1; i <6 ; i++) {

			guess=this.HypotheseJoueur(taillecode);


			Reponse reponse = guess.compare(this.secretCode);


			if (reponse.blacks==this.taillecode) {
				System.out.println("vous avez Gagné en "+i+" coup");

				//this.secretCode=createRandomCode(this.taillecode);
				//	guess= this.strategie.reset();
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

		System.out.println("code a saisir exemple 2345 puis ENTRER");
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
}
