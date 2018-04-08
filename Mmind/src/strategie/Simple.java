package strategie;

import model.CodeS;
import model.Reponse;

public class Simple extends socleIA {

	public Simple(int taillecode) {
		super(taillecode);
		
	}

	@Override
	public CodeS Bonchoix(Reponse reponse) {
		this.removemauvaisecombinaison(this.lhypothese, this.dernieressai, reponse);
this.dernieressai=this.lhypothese.get(0);
this.dernieressai.get(this.taillecode-1);
		return this.dernieressai;
	}
	
	
	
	
	
	@Override
	public CodeS reset() {
		this.lhypothese.clear();
this.lhypothese.addAll(this.allcodes);

this.dernieressai=this.lhypothese.get(0);
this.dernieressai.get(this.taillecode-1);
		
		
		
		return dernieressai;
		
	}
	

}
