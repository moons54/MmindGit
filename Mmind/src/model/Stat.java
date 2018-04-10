package model;

import java.util.HashMap;
import java.util.Map;

public class Stat {

	private int partiecompte;
	private Map <Integer,Integer> gagnepartour;

	public Stat() {
		this.partiecompte=1;
		this.gagnepartour=new HashMap<Integer,Integer>();
	}




	public void count() {
		this.partiecompte++;
	}


	public void reset() {
		Integer ancien= this.gagnepartour.get(this.partiecompte);
		if (ancien==null) {
			ancien=0;
			this.gagnepartour.put(this.partiecompte, ancien+1);
			this.partiecompte=1;
		}
	}

	public Map<Integer,Integer> getGagnepartour(){
		return this.gagnepartour;
	}
}
