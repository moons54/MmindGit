package model;


import java.util.Random;
import java.util.Scanner;

import javax.swing.plaf.synth.SynthSeparatorUI;

import model.CodeS;
import model.Reponse;
import strategie.choixMastermindIA;


public class Duel {

	private int taillecode;
	private CodeS secretCode;
	private CodeS secretCode1;
	private CodeS guess;

	private choixMastermindIA strategie;



	public Duel(int taillecode,choixMastermindIA strategie) {
		this.taillecode=taillecode;
		this.secretCode=createRandomCode(this.taillecode);
		this.secretCode1=SecretJoueur(this.taillecode);
		//this.guess=HypotheseJoueur(this.taillecode);
		this.strategie=strategie;

	}

	public Duel run() {


		System.out.println(" Code secret a faire deviner au joueur "+secretCode.toString());
		System.out.println("val de cde secret de LIA "+secretCode1);

		//Declaration hypothese du joueur
		//	CodeS guess=new CodeS();
		CodeS guess1=new CodeS();
		//
		guess1= this.strategie.reset();


		/** boucle pour les combinaison duel du joueur et IA*/
		for (int i = 1; i <6 ; i++) {
			System.out.println("----------------------------------------------");
			System.out.println("Tour Numéro "+i);
			//Hypothese du joueur Humain

			guess=this.HypotheseJoueur(taillecode);
			//reponse du joueur Humain
			Reponse reponse = guess.compare(this.secretCode);

			//Reponse ordi
			Reponse reponse1 = guess1.compare(this.secretCode1);



			if (reponse.blacks==this.taillecode) {
				System.out.println("vous avez Gagné en "+i+" coup");


				break;

			}
			else {
				System.out.println(reponse.toString());
				//System.out.println(guess.toString());
				//if (i==5) {
				//	System.out.println("Perdu !!");
			}
			if (reponse1.blacks==this.taillecode) {
				System.out.println(guess1);
				System.out.println("IA a gagne en "+i+" coup");

				//this.secretCode=createRandomCode(this.taillecode);
				guess1= this.strategie.reset();
				break;
			}else {
				guess1=this.strategie.Bonchoix(reponse1);
				System.out.println(guess1.toString());
				System.out.println(reponse1.toString());


				//System.out.println();
				guess1.get(this.taillecode-1);
				if (i==5) {
					System.out.println("Personne a trouvé");


				}



			}

			guess1.get(this.taillecode-1);
		}



		//}
		return null;
	}
	public Duel DuelPlusMoins() {


		System.out.println(" Code secret a faire deviner au joueur "+secretCode.toString());
		System.out.println("val de cde secret de LIA "+secretCode1);

		//Declaration hypothese du joueur
		//	CodeS guess=new CodeS();
		CodeS guess1=new CodeS();
		//
		guess1= this.strategie.reset();


		/** boucle pour les combinaison duel du joueur et IA*/
		for (int i = 1; i <6 ; i++) {
			System.out.println("----------------------------------------------");
			System.out.println("Tour Numéro "+i);
			//Hypothese du joueur Humain

			guess=this.HypotheseJoueur(taillecode);
			
		System.out.println(guess);	
			//reponse du joueur Humain
			Reponse reponse = guess.plusetmoins(this.secretCode);
System.out.println("______________");
System.out.println(guess1);
			//Reponse ordi
			Reponse reponse1 = guess1.plusetmoins(this.secretCode1);



			if (reponse.blacks==this.taillecode) {
				System.out.println("vous avez Gagné en "+i+" coup");
				break;

			}
			else {
			//	System.out.println(reponse.toString());
				
			}
			if (reponse1.blacks==this.taillecode) {
				System.out.println(guess1);
				System.out.println("IA a gagne en "+i+" coup");

				
				break;
			}else {
				
				for (int j = 0; j <4; j++) {
					if (guess1.get(j).i>secretCode.get(j).i) {
						guess1.get(j).i--;
					}
					else if (guess1.get(j).i<secretCode.get(j).i) {
						guess1.get(j).i++;
					}
					else if (guess1.get(j).i==secretCode.get(j).i) {

					}
				}
				System.out.println(guess1.toString());
				


				
			//	guess1.get(this.taillecode-1);
				if (i==5) {
					System.out.println("Personne a trouvé");


				}



		//	}

		//	guess1.get(this.taillecode-1);
		}



		}
		return null;
	}
	public static CodeS HypotheseJoueur(int length) {
		Scanner sc1= new Scanner(System.in);

		System.out.println("Combinaison : ");
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



	public static CodeS SecretJoueur(int length) {
		//Random rnd = new Random();
		System.out.println("code secret saisi :");
		Scanner ss = new Scanner(System.in);

		String val1 = ss.nextLine();

		T[] ts = new T[length];
		for (int i = 0; i < length; i++) {
			ts[i] = T.values()[Integer.parseInt(val1.substring(i, i+1))];

		}

		return new CodeS(ts);
	}
}
//}
