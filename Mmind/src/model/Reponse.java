package model;

import java.util.ArrayList;
import java.util.List;

/**
 * reponse au choix de la combinaison passé 
 * black = bien placé
 * white : a repositionne.
 */
public class Reponse {

	/** nombre correct de bouton bien placé*/
	public final int blacks;
	/** Number of correct buttons à repositionner */
	public final int whites;

	public Reponse(int blacks, int whites) {
		this.blacks = blacks;
		this.whites = whites;
	}

	@Override
	public boolean equals(Object other) {
		boolean result = false;
		if (other instanceof Reponse) {
			Reponse that = (Reponse) other;
			result = (this.blacks == that.blacks && this.whites == that.whites);
		}
		return result;
	}
	
	@Override
	public String toString() {
		return "Bien Placé:" + this.blacks + " A repositionner:" + this.whites;
	}

	/**
	 * LIst des toutes les reponses qui ont été donnée
	 * 
	
	 */
	public static List<Reponse> createAllAnswers(int length) {
		List<Reponse> result = new ArrayList<Reponse>();
		for (int blacks = 0; blacks < length; blacks++) {
			for (int whites = 0; whites < length; whites++) {
				int sum = whites + blacks;
				if (sum <= length && !(blacks == length - 1 && whites == 1)) {
					result.add(new Reponse(blacks, whites));
				}
			}
		}
		return result;
	}

}
