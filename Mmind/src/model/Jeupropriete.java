package model;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import strategie.Knuth2;
import strategie.Simple;
import strategie.choixMastermindIA;




public class Jeupropriete {
	
public static int taillecode;	
public static int nbcoup;
public static  choixMastermindIA STRATEGIE1=new Knuth2(taillecode);

protected Properties prop = new Properties();
	
	
	
public Jeupropriete() {	
	InputStream input = null;
/**chargement du fichier confo.properties */
		
		try {
		input = new FileInputStream("config.properties");
		prop.load(input);
		taillecode = Integer.valueOf(prop.getProperty("taillecode"));

			nbcoup = Integer.valueOf(prop.getProperty("nbcoup"));
			int IAchoix= Integer.valueOf(prop.getProperty("choixIA"));
			switch (IAchoix) {
			case 1:
				STRATEGIE1 =new Knuth2(taillecode);
				break;
			case 2:
				System.out.println("la");
				STRATEGIE1=new Simple(taillecode);
				
			default:
				break;
			}
			
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
}



public static int getTaillecode() {
	return taillecode;
}



public static int getNbcoup() {
	return nbcoup;
}



public static choixMastermindIA getSTRATEGIE1() {
	return STRATEGIE1;
}
	
	
}
