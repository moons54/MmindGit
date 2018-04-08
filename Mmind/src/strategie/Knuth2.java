package strategie;

import java.util.Iterator;

import model.CodeS;
import model.Reponse;

public class Knuth2 extends socleIA{

	public Knuth2(int taillecode) {
		super(taillecode);
	}

	@Override
	public CodeS Bonchoix(Reponse reponse) {
	this.removemauvaisecombinaison(this.lhypothese, this.dernieressai,
			reponse);
	this.dernieressai= lhypothese.get(0);
	int maxMinimum=0;
	for (CodeS code : this.allcodes) {
		int minimum=Integer.MAX_VALUE;
		for (Reponse a : this.ensReponse) {
			int removedCodesSize=getHypoteseCodes(
					this.lhypothese, code, a).size();
			minimum=Math.min(removedCodesSize, minimum);
		}
		if (minimum>maxMinimum) {
			maxMinimum=minimum;
			this.dernieressai=code;
		}
	}
	this.dernieressai.get(this.taillecode-1);
		return this.dernieressai;
	}
	
	
	
	
}
