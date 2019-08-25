package controller;
import org.apache.log4j.Logger;
/**
 * Classe utilitaire regroupant les paramètres de gestion de patrimoine et d'investissement
 * 
 * @author David et Cyril version 1.0
 * @author David et Alex version 2.0 
 */

public class Investissement {
	/**
	 * Utilisation de log4j
	 */
	private static Logger logger = Logger.getLogger(controller.Investissement.class);
	/**
	 * Montant investit dans des placements non toxique
	 */
	private double montant_invest;
	/**
	 * id du compte
	 */
	private int idCompte;
	/**
	 * id du conseiller
	 */
	private int idConseiller;
	
	/**
	 * Constructeur sans paramètre
	 */
	public Investissement(){
		
	}
	/**
	 * Constructeur avec les paramètres
	 * @param montant_invest montant investit
	 * @param id_compte id du compte
	 * @param id_conseiller id du conseiller
	 */
	public Investissement(double montant_invest, int idCompte, int idConseiller) {
		this.montant_invest = montant_invest;
		this.idCompte = idCompte;
		this.idConseiller = idConseiller;
	}
	
	/**
	 * Méthode pour demander l'investissement. Flux provenant du conseiller vers la classe utilitaire investissement.
	 */
	public void demander_invest(){
		logger.debug("Je suis dans la méthode demander l'investissement");
	}
	
	/**
	 * Méthode pour confirmer que l'investissement a été réalisé sur le compte.
	 */
	public void confirmer_invest(){
		
	}
	/**
	 * @return the montant_invest
	 */
	public double getMontant_invest() {
		return montant_invest;
	}
	/**
	 * @param montant_invest the montant_invest to set
	 */
	public void setMontant_invest(double montant_invest) {
		this.montant_invest = montant_invest;
	}
	/**
	 * @return the id_compte
	 */
	public int getId_compte() {
		return idCompte;
	}
	/**
	 * @param id_compte the id_compte to set
	 */
	public void setId_compte(int idCompte) {
		this.idCompte = idCompte;
	}
	/**
	 * @return the id_conseiller
	 */
	public int getId_conseiller() {
		return idConseiller;
	}
	/**
	 * @param id_conseiller the id_conseiller to set
	 */
	public void setId_conseiller(int idConseiller) {
		this.idConseiller = idConseiller;
	}
	
	
}
