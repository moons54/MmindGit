package model;

import model.Simul;
import java.util.Random;
import strategie.*;
import model.Stat;


public class Test1 {
	
	private static final int taillecode=4;
//private static final choixMastermindIA STRATEGIE1 = new Knuth2(taillecode);
	private static final choixMastermindIA STRATEGIE1 = new Simple(taillecode);
	
	
	


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		/**
		 * Insertion du nombre secret sur nombre de digit MAX 7 chiffres
		 */
		
	Simul simul;
	Simul simul1;
	Stat stat ;
	int progress =0;
	
	//simul = new Simul(taillecode,STRATEGIE);
simul1=new Simul(taillecode,STRATEGIE1);
//stat=simul.run();
stat=simul1.run();

	
	
	}
		
		
		
//	}


}