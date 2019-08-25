package controller;
import org.apache.log4j.Logger;
/**
 * Classe utilitaire regroupant les paramètres d'une simulation de crédit
 * 
 * @author David et Cyril version 1.0
 * @author David et Alex version 2.0 
 */

public class UtilitaireCredit {
	/**
	 * Utilisation de log4j
	 */
	private static Logger logger = Logger.getLogger(controller.UtilitaireCredit.class);
	/**
	 * Montant du crédit
	 */
	private double montantCredit;
	/**
	 * Durée du crédit
	 */
	private float duree;
	/**
	 * Type de crédit : consommation ou immobilier
	 */
	private boolean type_credit;
	/**
	 * Taux de crédit issu de la simulation
	 */
	private float taux;
	/**
	 * id du conseiller
	 */
	private int idConseiller;
	/**
	 * id du compte
	 */
	private int idCompte;
	
	/**
	 * Constructeur sans paramètre
	 */
	public UtilitaireCredit(){
		
	}

	/**
	 * Constructeur avec les paramètres
	 * @param montantCredit montant du crédit
	 * @param duree durée du crédit
	 * @param type_credit type de crédit : consommation ou immobilier
	 * @param taux taux du crédit
	 */
	public UtilitaireCredit(double montantCredit, float duree, boolean type_credit, float taux, int idConseiller, int idCompte) {
		this.montantCredit = montantCredit;
		this.duree = duree;
		this.type_credit = type_credit;
		this.taux = taux;
		this.idConseiller = idConseiller;
		this.idCompte = idCompte;
	}
	
	/**
	 * Méthode pour la simulation du crédit. Demande de simulation d'un crédit venant du conseiller vers la classe utilitaire crédit.
	 * 
	 */
	public void simulerCredit(){
		logger.debug("Je suis dans la méthode simulation du crédit");
	}
	/**
	 * Méthode pour cacluler le taux du crédit. Flux provenant de la classe compte vers le classe crédit.
	 * @return taux
	 */
	public float calculerTaux(){
		
		return taux;
	}

	/**
	 * @return the montantCredit
	 */
	public double getMontantCredit() {
		return montantCredit;
	}

	/**
	 * @param montantCredit the montantCredit to set
	 */
	public void setMontantCredit(double montantCredit) {
		this.montantCredit = montantCredit;
	}

	/**
	 * @return the duree
	 */
	public float getDuree() {
		return duree;
	}

	/**
	 * @param duree the duree to set
	 */
	public void setDuree(float duree) {
		this.duree = duree;
	}

	/**
	 * @return the type_credit
	 */
	public boolean isType_credit() {
		return type_credit;
	}

	/**
	 * @param type_credit the type_credit to set
	 */
	public void setType_credit(boolean type_credit) {
		this.type_credit = type_credit;
	}

	/**
	 * @return the taux
	 */
	public float getTaux() {
		return taux;
	}

	/**
	 * @param taux the taux to set
	 */
	public void setTaux(float taux) {
		this.taux = taux;
	}

	/**
	 * @return the idConseiller
	 */
	public int getIdConseiller() {
		return idConseiller;
	}

	/**
	 * @param idConseiller the idConseiller to set
	 */
	public void setIdConseiller(int idConseiller) {
		this.idConseiller = idConseiller;
	}

	/**
	 * @return the idCompte
	 */
	public int getIdCompte() {
		return idCompte;
	}

	/**
	 * @param idCompte the idCompte to set
	 */
	public void setIdCompte(int idCompte) {
		this.idCompte = idCompte;
	}

	
	
}
