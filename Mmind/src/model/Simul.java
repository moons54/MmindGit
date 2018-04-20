package model;


import java.util.Properties;
import java.util.Random;
import java.util.Scanner;
import model.Jeupropriete;


import strategie.choixMastermindIA;

public class Simul{



	/** Creation de l'objet propriete dans lequel se trouve les propriete nombre de coup, nombre de bouton,
	 * strategie de l'algorithme
	 * mode developpeur
	 */

	Jeupropriete pro=new Jeupropriete();
	private CodeS secretCode;
	private choixMastermindIA strategie;
	private CodeS guess;
	//protected Properties prop = new Properties();

	private int taillecode=4;

	public Simul(int taillecode,choixMastermindIA strategie) {
		this.taillecode=taillecode;
		//	this.secretCode=createRandomCode(this.taillecode);
		this.secretCode=SecretJoueur(this.taillecode);
		this.strategie=strategie;	
	}

	public Stat run() {

		Stat stat=new Stat();
		CodeS guess=new CodeS();

		guess= this.strategie.reset();

		System.out.println(" code secret "+secretCode.toString());
		System.out.println(guess.toString());
		for (int i = 1; i <pro.getNbcoup() ; i++) {
			Reponse reponse = guess.compare(this.secretCode);


			if (reponse.blacks==this.taillecode) {
				System.out.println("_____________________________");
				System.out.println("L'ordinateur a Gagné en "+i+" coup");
				System.out.println("_____________________________");

				guess= this.strategie.reset();
				break;
			}else {


				guess= this.strategie.Bonchoix(reponse);
				System.out.println(reponse.toString()+" tour numéro "+(i));
				System.out.println();
				System.out.println(guess.toString());


			}
			if (i==pro.getNbcoup()) {
				System.out.println("Perdu !!");
			}
			guess.get(this.taillecode-1);
		}


		return stat;

	}


	/**methode pour lancer la simulation de code via L'IA*/

	public void plusmoinsIA() {


		/**creation d'une combinaisaon secret*/

		guess=this.createRandomCode(taillecode);

		System.out.println("code secret "+secretCode.toString());

		String val;
		String val1=secretCode.toString().replace("|", "");

		for (int i = 0; i < pro.getNbcoup(); i++) {

			Reponse reponse=guess.plusetmoins(secretCode);
			System.out.println("  pour la proposition suivante  "+this.guess);
			if (reponse.blacks==taillecode) {
				System.out.println("L'Ordinateur a gagné en "+(i+1)+" tour");
				break;
			} else {

			}
			//**boucle ayant pour objectif d'incrementer ou de decrementer selon la reponse final			
			for (int j = 0; j <taillecode; j++) {
				if (guess.get(j).i>secretCode.get(j).i) {
					guess.get(j).i--;
				}
				else if (guess.get(j).i<secretCode.get(j).i) {
					guess.get(j).i++;
				}
				else if (guess.get(j).i==secretCode.get(j).i) {

				}

			}


		}

		return ;
	}


	/**methode de nombre aléatoir */
	public static CodeS createRandomCode(int length) {
		Random rnd = new Random();
		T[] ts = new T[length];
		for (int i = 0; i < length; i++) {
			ts[i] = T.values()[rnd.nextInt(8)];

		}
		return new CodeS(ts);
	}
	/**methode proposant au joueur Humain de saisir un code*/
	public static CodeS SecretJoueur(int length) {
		System.out.println("combinaison a saisir sur "+" positions");
		Scanner sj = new Scanner(System.in);
		String val1 = sj.nextLine();
		T[] ts = new T[length];
		for (int i = 0; i < length; i++) {
			//if (ts.length<4) {
				ts[i] = T.values()[Integer.parseInt(val1.substring(i, i+1))];
			//}
			

		}
		return new CodeS(ts);
	}


	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Simul [taillecode=").append(pro.getTaillecode()).append(", secretCode=").append(secretCode).append("]");
		return builder.toString();
	}




}
