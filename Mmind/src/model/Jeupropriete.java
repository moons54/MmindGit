package model;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import strategie.Knuth2;
import strategie.Simple;
import strategie.choixMastermindIA;




public class Jeupropriete {
	
private  static int taillecode=0;	
private  static int nbcoup;

private static int IAchoix;
protected Properties prop = new Properties();
	
	
	
public Jeupropriete() {	
	InputStream input = null;
/**chargement du fichier confo.properties */
		
		try {
		input = new FileInputStream("config.properties");
		prop.load(input);
		taillecode = Integer.valueOf(prop.getProperty("taillecode"));
		nbcoup = Integer.valueOf(prop.getProperty("nbcoup"));
			 IAchoix= Integer.valueOf(prop.getProperty("choixIA"));
			
			
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



public  static int getTaillecode() {
	return taillecode;
}



public static int getNbcoup() {
	return nbcoup;
}





public static int getIAchoix() {
	return IAchoix;
}
	
	
}
