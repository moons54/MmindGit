package model;

import java.util.Random;
import java.util.Scanner;

import javax.xml.ws.soap.AddressingFeature.Responses;

import strategie.choixMastermindIA;
public class Simul {


	private int taillecode;
	private CodeS secretCode;
	private choixMastermindIA strategie;


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
		for (int i = 1; i <6 ; i++) {
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
		System.out.println("code a saisir exemple 2345 puis ENTRER");
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
