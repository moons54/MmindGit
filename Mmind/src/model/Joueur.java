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
	private int coup[]=new int[taillecode];
	private int code[]=new int[taillecode];

	public Joueur(int taillecode) {
		this.taillecode=taillecode;
		this.secretCode=createRandomCode(this.taillecode);
		//	this.guess=HypotheseJoueur(this.taillecode);

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
	public Joueur run2() {

		System.out.println(" code secret "+secretCode.toString());

		for (int i = 1; i <6 ; i++) {

			try {
				guess=this.HypotheseJoueur(taillecode);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			System.out.println("valeur du guess"+guess.toString());

			guess.plusetmoins(this.secretCode);

			if (this.guess.equals(secretCode))  {

				System.out.println("vous avez Gagné en "+i+" coup");
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
	public Joueur run3() {

		Random rnd= new Random();
		System.out.println(" code secret "+secretCode.toString());
		/**initialisation du code secret*/
		Scanner sccode= new Scanner(System.in);
		int temp=sccode.nextInt();
		for (int i = 0; i < code.length; i++) {
			code[i]=temp;
			System.out.print(code[i]);
		}
		System.out.println();
		/**initialisation du premier coup*/
		int coup[]=new int[taillecode];
		for (int j = 0; j < coup.length; j++) {
			coup[j]=rnd.nextInt(8);
			System.out.print(coup[j]);
		}
		for (int i = 1; i <6 ; i++) {
			for (int j = 0; j < coup.length; j++) {
				System.out.print(coup[j]);
			}
			
			System.out.println();
if (coup.equals(code)) {
	System.out.println("fin");
}
else
	for (int l : coup) {
		
	//	this.coup.equals(obj)
			
		}
	}
	/**
		if (i==5) {
				System.out.println("Perdu !!");
			}
		}
*/
		
		return null ;
	}
}
