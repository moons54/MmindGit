import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;
import java.util.logging.LogManager;


import com.sun.javafx.logging.Logger;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import IHM.Men_general;

public class Demarrage {

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
			
			logger.trace("fichier propriete lancé"); 

	        
	        

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

		new Men_general();

	}

}
