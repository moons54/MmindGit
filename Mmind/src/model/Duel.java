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
	private Jeupropriete pro=new Jeupropriete();
private static  int nbdechiffre;
private  boolean modedeveloppeur;
	private choixMastermindIA strategie;
	private int nbdecoup;


	public Duel(int taillecode,choixMastermindIA strategie,int nbdechiffre,boolean modedeveloppeur,int nbdecoup) {
		this.taillecode=taillecode;
		
		this.secretCode=createRandomCode(this.taillecode,this.nbdechiffre);
		this.secretCode1=SecretJoueur(this.taillecode);
		this.nbdechiffre=nbdechiffre;
		this.nbdecoup=nbdecoup;
		//this.guess=HypotheseJoueur(this.taillecode);
		this.strategie=strategie;

	}

	/** nous retrouvons ici deux methodes pour la simulation du jeu en mode tour par tour 
	 * 
	 * @return
	 */

	public Duel run() {

		if (modedeveloppeur=true) {
			System.out.println("_____________________________________________");
			System.out.println("Nombre de coup:" + nbdecoup);
			System.out.println("_____________________________________________");
			System.out.println("Nombre de Chiffre :" + nbdechiffre);
			System.out.println("_____________________________________________");
			System.out.println("Nombre de Bouton :" + taillecode);
			System.out.println("_____________________________________________");
			System.out.println(" code secret generé par joueur 1"+secretCode1.toString());
			System.out.println("_____________________________________________");
			System.out.println(" code secret generé par joueur 2"+secretCode.toString());
			System.out.println("_____________________________________________");
		}
			//Declaration hypothese du joueur
		CodeS guess1=new CodeS();
		guess1= this.strategie.reset();


		/** boucle pour les combinaison duel du joueur et IA*/
		for (int i = 1; i < nbdecoup; i++) {
			System.out.println("----------------------------------------------");
			System.out.println("Tour Numéro "+i);



			//Hypothese du joueur Humain
			guess=this.HypotheseJoueur(taillecode);



			//reponse du joueur Humain
			Reponse reponse = guess.compare(this.secretCode);

			//Reponse ordi
			Reponse reponse1 = guess1.compare(this.secretCode1);


			//condition controlant dans un premier temps el joueur1 : humain
			//si reponse juste alors fin de la partie
			if (reponse.blacks==this.taillecode) {
				System.out.println("vous avez Gagné en "+(i+1)+" coup");
				break;
			}
			else {
				System.out.println(reponse.toString());
			}
			//condition controlant dans un seconde temps la reponse du joueur 2 : ordinateur
			//si reponse juste alors fin de partie
			if (reponse1.blacks==this.taillecode) {
				System.out.println(guess1);
				System.out.println("L'IA a gagné en "+(i+1)+" coup");
				guess1= this.strategie.reset();
				break;
			}else {
				//methode d'iA va utliser methode bonchoix qui va comparer les autres proposition par rapport au score 
				//emis des hypotheses ( voir methode bonchoix pour plus de précision)
				guess1=this.strategie.Bonchoix(reponse1);
				System.out.println(guess1.toString());
				System.out.println(reponse1.toString());
				//System.out.println();
				guess1.get(this.taillecode-1);
				if (i==pro.getNbcoup()) {
					System.out.println("Pas de Gagnant sur cette Partie");
				}
			}

			guess1.get(this.taillecode-1);
		}



		//}
		return null;
	}
	public Duel DuelPlusMoins() {

		if (modedeveloppeur=true) {
			System.out.println("_____________________________________________");
			System.out.println("Nombre de coup:" + nbdecoup);
			System.out.println("_____________________________________________");
			System.out.println("Nombre de Chiffre :" + nbdechiffre);
			System.out.println("_____________________________________________");
			System.out.println("Nombre de Bouton :" + taillecode);
			System.out.println("_____________________________________________");
			System.out.println(" code secret generé par joueur 1"+secretCode1.toString());
			System.out.println("_____________________________________________");
			System.out.println(" code secret generé par joueur 2"+secretCode.toString());
			System.out.println("_____________________________________________");
		}
		
		
		//Declaration hypothese du joueur
		CodeS guess1=new CodeS();
		guess1= this.createRandomCode(taillecode,nbdechiffre);


		/** boucle pour les combinaison duel du joueur et IA*/
		for (int i = 1; i <pro.getNbcoup() ; i++) {
			System.out.println("----------------------------------------------");
			System.out.println("Tour Numéro "+(i));

			//Hypothese du joueur Humain
			guess=this.HypotheseJoueur(taillecode);

			//reponse du joueur 1 Humain
			System.out.println("Joueur I");
			System.out.println(guess);
			System.out.println("Reponse : ");
			Reponse reponse = guess.plusetmoins(this.secretCode);
			System.out.println();
			System.out.println("___________________");
			System.out.println("Joueur II");
			

			//Reponse du joueur 2 Ordinateur
			System.out.println(guess1);
			System.out.println("Reponse : ");
			Reponse reponse1 = guess1.plusetmoins(this.secretCode1);
			System.out.println();

			//condition verifiant la reponse du joueur 1 : humain si celle ci est juste alors fin de partie
			if (reponse.blacks==this.pro.getTaillecode()) {
				System.out.println("vous avez Gagné en "+i+" coup");
				break;

			}
			else {

			}
			//condition verifiant la reponse du joueur 2 : Ordinateur si celle ci est juste alors fin de partie
			if (reponse1.blacks==this.pro.getTaillecode()) {
				System.out.println(guess1);
				System.out.println("Joueur II : l'ordinateur gagne en "+i+" coup");
				break;
			}
			else {

				//condition de controle visant a vérifier si la valeur du code secret est sup ou inf 
				//selon le cas on incremente ou reduit de 1 la position du bouton dans la combinaison finale. 
				for (int j = 0; j <4; j++) {
					if (guess1.get(j).i<secretCode.get(j).i) {
						guess1.get(j).i++;
					}
					else if (guess1.get(j).i>secretCode.get(j).i) {
						guess1.get(j).i--;
					}
					else if (guess1.get(j).i==secretCode.get(j).i) {

					}
				}


				if (i==pro.getNbcoup()) {
					System.out.println("Personne a trouvé la combinaison");
				}
			}

		}

		return null;
	}

	//methode utilisée pour creer une hypothese de combinaison saisie par le joueur.
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
	//methode utilisée pour creer une combinaison aléatoire.
	public static CodeS createRandomCode(int length,int nbdechiffre) {
		Random rnd = new Random();
		T[] ts = new T[length];
		for (int i = 0; i < length; i++) {
			
				ts[i] = T.values()[rnd.nextInt(nbdechiffre)];
	
		}
		return new CodeS(ts);
	}


	//methode utilisée pour creer un code secret 
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

