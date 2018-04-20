package model;




import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * 
 * @author aurelienmimouni
 *Combinaison générant les codes utilisé dans mastermind
 *methode permettant d'evaluer le scode d'une combinaison
 *vers un autre code ( hypothese dans certain cas ou code secret)
 */



public class CodeS {

	private final T[] code;

	public CodeS(T... t) {
		this.code = t.clone();
	}

	
	
	@Override
	public boolean equals(Object other) {
		if (other instanceof CodeS) {
			CodeS that = (CodeS) other;
			if (this.code.length != that.code.length) {
				return false;
			}
			for (int i = 0; i < code.length; i++) {
				if (this.code[i] != that.code[i]) {
					return false;
				}
			}
			return true;
		}
		return false;
	}

	@Override
	public String toString() {
		String result = "";
		for (T t : code) {
			result += "|" + t.i + "|";
		}
		return result;
	}

	/**

	 * Methode retournant vrai si le bouton est dans le code
	 *          (appelé dans la methode compare )
	 */



	public boolean contains(T t) {
		for (T x : this.code) {
			if (x == t) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Avoir le nombre de pion bien placé 
	 * et de pion a repositionner
	 * 
	 */
	public Reponse compare(CodeS other) {
		int OK = 0;
		int NOK = 0;
		for (int i = 0; i < this.code.length; i++) {
			if (code[i] == other.code[i]) {
				OK++;
			} else if (this.contains(other.code[i])) {
				NOK++;
			}
		}
		return new Reponse(OK, NOK);
	}

	/**
	 * Methode ayant pour objectif l'analyse de la réponse pour le jeu plus et moins
	 * 
	 * @param other
	 * @return 
	 */
	public Reponse plusetmoins(CodeS other) {
		int OK=0;
		int NOK=0;
		for (int i = 0; i < this.code.length; i++) {
if (code[i].i < other.code[i].i) {
	System.out.print("+");
}
if (code[i].i > other.code[i].i) {
	System.out.print("-");
}
if (code[i].i ==other.code[i].i) {
	System.out.print("=");
	OK++;
}
		
		}
		return new Reponse(OK,NOK);
	}


	/**
	 * 
	 * Retourne ici la valeur du chiffre
	 * 
	 */

	public T get(int i) {
		return this.code[i];
	}




	/**
	 * 
	 * 
	 * Retourne le nombre de chiffre du code
	 */
	public int getLength() {
		return this.code.length;
	}

	/**

	 * Cration de l'ensemble des code de taille N
	 * 
	 * on utilise une methode recursive qui permet de reccuperer non pas le nombre mais son index via un linked list
	 * cette methode est bien plus rapide que d'acceder a l'element directement.
	 * 
	 * 
	 */
	public static List<CodeS> createAllCodes(int length) {
		final List<CodeS> result = new LinkedList<CodeS>();
		_createAllCodes(result, length, new T[length]);
		return result;
	}

	private static void _createAllCodes(List<CodeS> codes, int length, T[] ts) {
		if (length == 0 ) {
			codes.add(new CodeS(ts));
		} else {
			for (T t : T.values()) {
				if (t.i<5) {
					ts[length-1] = t;
				_createAllCodes(codes, length - 1, ts);
				}
				
			}
		}
	}


}

