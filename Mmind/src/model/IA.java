package model;


import java.util.Random;
import java.util.Scanner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import strategie.choixMastermindIA;


public class IA{



	/** Creation de l'objet propriete dans lequel se trouve les propriete nombre de coup, nombre de bouton,
	 */
	static final Logger logger = LogManager.getLogger();



	Jeupropriete pro=new Jeupropriete();
	private CodeS secretCode;
	private choixMastermindIA strategie;
	private CodeS guess;
	private int taillecode=4;
	private int nbdecoup;
	private boolean modedeveloppeur;
	private static int nbdechiffre;

	/**declaration de la metodeIA permettant le choix du mode de strategie*/

	public IA(int taillecode,choixMastermindIA strategie,int nbdechiffre,boolean modedeveloppeur,int nbdecoup) {
		this.taillecode=taillecode;
		this.secretCode=SecretJoueur(this.taillecode);
		this.nbdechiffre=nbdechiffre;
		this.strategie=strategie;
		this.nbdecoup=nbdecoup;
	}

	public Stat IAmastermind() {



		logger.info("lancement du jeu : Defenseur mastermind");
		if (modedeveloppeur=true) {
			logger.info("mode developpeur activé");
logger.debug("nb de coup "+ nbdecoup+ "  "+"nombre de chiffre "+ nbdechiffre+ " nombre de bouton "+taillecode + " code secret "+ secretCode);
			System.out.println("_____________________________________________");
			System.out.println("Nombre de coup:" + nbdecoup);
			System.out.println("_____________________________________________");
			System.out.println("Nombre de Chiffre :" + nbdechiffre);
			System.out.println("_____________________________________________");
			System.out.println("Nombre de Bouton :" + taillecode);
			System.out.println("_____________________________________________");
			System.out.println(" code secret generé par joueur 2"+secretCode.toString());
			System.out.println("_____________________________________________");
		}

		Stat stat=new Stat();
		CodeS guess=new CodeS();
		guess= this.strategie.reset();

		System.out.println(guess.toString());
		for (int i = 1; i <nbdecoup ; i++) {

			Reponse reponse = guess.compare(this.secretCode);

			if (reponse.blacks==this.taillecode) {
				logger.info("partie gagné par l'ordinateur  "+guess);
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
			if (i==nbdecoup) {
				System.out.println("l'ordinateur a Perdu !!");
				logger.info("l'ordinateur n'a pas gagné");
			}
			guess.get(this.taillecode-1);
		}


		return stat;

	}


	/**methode pour lancer la simulation de code via L'IA*/

	public void plusmoinsIA() {

		logger.info("lancement du jeu : challenger plusmoinsIA");
		/**creation d'une combinaisaon secrete*/

		guess=this.createRandomCode(taillecode);
		if (modedeveloppeur=true) {
			logger.info("mode developpeur activé");
			logger.debug("nb de coup "+ nbdecoup+ "  "+"nombre de chiffre "+ nbdechiffre+ " nombre de bouton "+taillecode + " code secret "+ secretCode);

			System.out.println("_____________________________________________");
			System.out.println("Nombre de coup:" + nbdecoup);
			System.out.println("_____________________________________________");
			System.out.println("Nombre de Chiffre :" + nbdechiffre);
			System.out.println("_____________________________________________");
			System.out.println("Nombre de Bouton :" + taillecode);
			System.out.println("_____________________________________________");
			System.out.println(" code secret generé par joueur 2"+secretCode.toString());
			System.out.println("_____________________________________________");
		}


		for (int i = 0; i < nbdecoup; i++) {

			Reponse reponse=guess.plusetmoins(secretCode);
			System.out.println("  pour la proposition suivante  "+this.guess);
			if (reponse.blacks==taillecode) {
				System.out.println("L'Ordinateur a gagné en "+(i+1)+" tour");
				logger.info("partie gagné par l'ordinateur  "+guess);
				break;
			} else {

			}

			/**boucle ayant pour objectif d'incrementer ou de decrementer selon la reponse final*/	
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


	/**methode de nombre aléatoire */
	public static CodeS createRandomCode(int length) {
		Random rnd = new Random();
		T[] ts = new T[length];
		for (int i = 0; i < length; i++) {
			ts[i] = T.values()[rnd.nextInt(nbdechiffre)];

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
