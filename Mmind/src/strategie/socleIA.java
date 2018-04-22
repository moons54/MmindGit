package strategie;

import java.util.ArrayList;
import java.util.List;

import model.CodeS;
import model.Reponse;
import model.IA;
import model.T;

public abstract class socleIA  implements choixMastermindIA{


	//taille du code secret
	protected final int taillecode;

	//Liste de tous les codes
	protected final List<CodeS> allcodes;

	//Liste de tous les réponses données
	protected final List<Reponse> ensReponse;

	//Liste des hypotheses
	protected final List<CodeS> lhypothese;

	//dernier essai effectué
	protected CodeS dernieressai;

	public socleIA(int taillecode){
		this.taillecode=taillecode;
		this.allcodes=CodeS.createAllCodes(this.taillecode);
		
		this.lhypothese=new ArrayList<CodeS>();
		this.ensReponse=Reponse.createAllAnswers(this.taillecode);
	}

	
	
	/**
	 * methotde reset initialise la liste d'hypothese et propose la premier combinaison
	 * 
	 * 
	 */
	public CodeS reset() {
		this.lhypothese.clear();
		this.lhypothese.addAll(this.allcodes);
		
		this.dernieressai=IA.createRandomCode(taillecode);
		this.dernieressai.get(this.taillecode-1);
	//	this.dernieressai.get(this.taillecode);
		return this.dernieressai;
		
	}

	/**
	 * Creation de methode commune a plusieurs algorithme de pour la resolution du mastermind
	 * 
	 * 1 Code gethypothese =>  
	 * principe : est consideré comme bonne hyposthese :
	 * 
	 * Si la derniere question et l'hypothese ont la meme reponse que
	 * la derniere question par rapport au code secret 
	 */

	protected List<CodeS> getHypoteseCodes(List<CodeS> codes,CodeS dernieressai,Reponse reponse ){
		List<CodeS> resultat = new ArrayList<CodeS>();
		for (CodeS codeS2 : codes) {
			if (dernieressai.compare(codeS2).equals(reponse)) {
				resultat.add(codeS2);
			}

		}
		return resultat;
	}



	/**
	 * Methode ayant pour objectif de supprimer les codes non conforme 
	 * 
	 * 1 code incompatible si :
	 *  la reponse de la derniere question 
	 *  et l'hypothese avec le code n'ont pas la reponse avec la
	 *  derniere question et le code secret.

	 */



	protected void removemauvaisecombinaison(List<CodeS> codes,CodeS dernieressai,Reponse reponse) {
		//creation d'une iteration afin de passer en revu l'ens des combinaison 
		for (int i = codes.size()-1; i >=0; i--) {
			if(!dernieressai.compare(codes.get(i)).equals(reponse)){
				codes.remove(i);
			}
		}
	}
	
}
