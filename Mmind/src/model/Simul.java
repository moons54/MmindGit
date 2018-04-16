package model;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Random;
import java.util.Scanner;

import javax.xml.ws.soap.AddressingFeature.Responses;

import strategie.choixMastermindIA;
public class Simul {

private int nbcoup;
	private int taillecode;
	private CodeS secretCode;
	private choixMastermindIA strategie;
	private CodeS guess;
	protected Properties prop = new Properties();
	
	public Simul(int taillecode,choixMastermindIA strategie) {
		this.taillecode=taillecode;
		//	this.secretCode=createRandomCode(this.taillecode);
		this.secretCode=SecretJoueur(this.taillecode);
		this.strategie=strategie;	
	}



	public Stat run() {
		InputStream input = null;
/**chargement du fichier confo.properties */
		
		try {
		input = new FileInputStream("config.properties");
		prop.load(input);
		taillecode = Integer.valueOf(prop.getProperty("taillecode"));
System.out.println(taillecode);
			nbcoup = Integer.valueOf(prop.getProperty("nbcoup"));
		//nbrUtilises = new int[Integer.valueOf(prop.getProperty("couleurs"))];
		
	} catch (IOException ex) {
		ex.printStackTrace();

	} finally {

		if (input != null) {
			try {
				input.close();

			} catch (IOException e) {
				e.printStackTrace();

			}
		}
	}

		Stat stat=new Stat();
		CodeS guess=new CodeS();

		guess= this.strategie.reset();
		System.out.println(" code secret "+secretCode.toString());
		System.out.println(guess.toString());
		for (int i = 1; i <nbcoup ; i++) {
			Reponse reponse = guess.compare(this.secretCode);


			if (reponse.blacks==this.taillecode) {
				System.out.println("L'ordinateur a Gagné en "+i+" coup");

				//this.secretCode=createRandomCode(this.taillecode);
				guess= this.strategie.reset();
				break;
			}else {


				guess= this.strategie.Bonchoix(reponse);
				System.out.println(reponse.toString()+" tour numéro "+(i));
				System.out.println();
				System.out.println(guess.toString());
				if (i==5) {
					System.out.println("Perdu !!");
				}

			}

			guess.get(this.taillecode-1);
		}


		return stat;

	}
	public void run2() {



		/**creation d'une combinaisaon secret*/
		guess=this.createRandomCode(taillecode);

		System.out.print("1ere valeur"+guess.toString());
		System.out.println("valeur code secret"+secretCode.toString());


		for (int i = 0; i <nbcoup ; i++) {
			guess.plusetmoins(this.secretCode);
			if (this.guess.equals(secretCode)) {
				System.out.println("bien");
			

			}
			else {
				/**
				System.out.print("valeur du guess avec this"+this.guess);
				System.out.println("valeur du guess "+guess);
				System.out.println("valeur du secret code "+secretCode);
				System.out.println("pas bien");
				*/
				for (int j = 4; j <0; j--) {
			
					
				//	if (this.guess.get(i)<this.secretCode.get(j).values()[j]) {
				//		System.out.println("voir la valeur"+guess.get(j));
				//	}
					if (guess.get(j).i>secretCode.get(j).i) {
						this.guess.get(j)
						;

					}
					if (guess.get(j).i==secretCode.get(j).i) {
						
					}

					
				}
			}


			/**




			System.out.println("valeur du code secret "+secretCode.toString());



			if (guess.equals(this.secretCode)) {

				System.out.println("vous avez Gagné en "+i+" coup");
				break;

			}
			else {
				for (int j = 0; j < guess.getLength(); j++) {
					if (guess.get(j).i<this.secretCode.get(j).i) {
						guess.get(j).i++;
					}
					if (guess.get(j).i>this.secretCode.get(j).i) {
						guess.get(j).i--;

					}
				}
			}


			System.out.println(guess.toString());

			//	

		}

			 */
			//guess.get(this.taillecode-1);
		}
		return ;
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
		System.out.println("combinaison a saisir exemple 2345 puis ENTRER");
		Scanner sj = new Scanner(System.in);

		String val1 = sj.nextLine();

		T[] ts = new T[length];
		for (int i = 0; i < length; i++) {
			ts[i] = T.values()[Integer.parseInt(val1.substring(i, i+1))];

		}
		return new CodeS(ts);
	}






	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Simul [taillecode=").append(taillecode).append(", secretCode=").append(secretCode).append("]");
		return builder.toString();
	}




}
