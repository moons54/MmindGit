import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import IHM.Men_general;

public class Demarrage {

	
	
	//declaration du looger l'ensemble des evt d'information sont enregitré dans fichier all.log 
	static final Logger logger = LogManager.getLogger();

	public static void main(String[] args) throws IOException {

		/**
		 * 
		 * 
		 * 
		 * lien avec le fichier config.properties
		 * voir README.MD pour connaitre les parametres de jeu
		 * 
		 * 
		 * 
		 * 
		 */


		Properties prop = new Properties();

		
		InputStream input = null;

		OutputStream output = null;

		try {
			input = new FileInputStream("config.properties");

			/*
			 * On charge le fichier.
			 */
			prop.load(input);






		} catch (IOException ex) {

		} finally {

			if (output != null) {

				try {

					output.close();

				} catch (IOException e) {

					e.printStackTrace();

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

		}
		logger.info("fichier propriete lancé"); 
		
		
		//lancement du menu général situa dans IHM
		new Men_general();

	}

}
