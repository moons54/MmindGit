package model;


	public abstract class Erreur {

		/*
		 * Méthode servant à afficher si une entrée clavier ne correspond pas à un choix
		 * 
		 * proposé 
		 * 
		 * 
		 * 
		 * 
		 */
		
		public static void erreurChoix() {
			System.out.println("\nVeuillez choisir parmi les propositions proposées.");
		}

		public static void erreurNbr() {
			Jeupropriete pro=new Jeupropriete();
			System.out.println("\nVeuillez entrer un nombre a "+pro.getTaillecode()+ " positions compris de 0 à " + pro.getNbchiffre() + ".");

		}

	}

