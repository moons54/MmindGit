package model;

import model.Simul;
import java.util.Random;
import strategie.*;
import model.Stat;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;

public class Test1 {

	private static final int taillecode=4;
	private static final choixMastermindIA STRATEGIE1 = new Knuth2(taillecode);
	//	private static final choixMastermindIA STRATEGIE1 = new Simple(taillecode);

	public static void main(String[] args) {
		// TODO Auto-generated method stub


		/**
		 * Insertion du nombre secret sur nombre de digit MAX 7 chiffres
		 */

		Simul simul;
		Simul simul1;
		Stat stat ;
		
		/**
		Properties prop = new Properties();
		InputStream input = null;

		OutputStream output = null;

		
		try {
			output = new FileOutputStream("config.properties");

			prop.setProperty("taillecode", "4");
			prop.setProperty("nbchiffre", "9");
			prop.setProperty("modedeveloppeur", "oui");
			prop.setProperty("choixIA", "Knuth2");

			
			
			prop.store(output, null);
			
			*/
	//		input = new FileInputStream("config.properties");
//prop.load(input);
//System.out.println(prop.getProperty("taillecode"));
			//simul = new Simul(taillecode,STRATEGIE);
			simul1=new Simul(taillecode,STRATEGIE1);
			//stat=simul.run();
			stat=simul1.run();
			
			
		}
			/*
			 catch (IOException io) {
					io.printStackTrace();
				} finally {
					if (output != null) {
						try {
							output.close();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}

				}



	}

*/



}