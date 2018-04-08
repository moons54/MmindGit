package strategie;

import model.CodeS;
import model.Reponse;

public interface choixMastermindIA {

	
	/**
	 * dans un premier temps on vide les resultat précédents
	 * 
	 */
	
	
	
	CodeS reset();
	
	
	/**
	 * renvoi la question suivant qui permet de dermint le nombre correct de solution
	 * 
	 * 
	 */
	
	
	CodeS Bonchoix(Reponse reponse);
}
