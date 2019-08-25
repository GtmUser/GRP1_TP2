package controller;

import java.util.Date;
import org.apache.log4j.Logger;
/**
 * Classe utilitaire qui regroupe les paramètres du virement
 * 
 * @author David et Cyril version 1.0
 * @author David et Alex version 2.0 
 */

public class Virement {
	/**
	 * Utilisation de log4j
	 */
	private static Logger logger = Logger.getLogger(controller.Virement.class);
	/**
	 * id du conseiller 
	 */
	private int idConseiller;
	/**
	 * id du compte
	 */
	private int idCompte;
	/**
	 * id du virement
	 */
	private int idVirement;
	/**
	 * date du virement
	 */
	private Date dateVirement;
	/**
	 * Montant du virement
	 */
	private double montantVirement;
	
	
	/**
	 * Constructeur sans paramètre
	 */
	public Virement(){
		
	}
	
	/**
	 * Constructeur avec paramètres
	 * @param idConseiller id du conseiller
	 * @param idCompte id du compte
	 * @param idVirement id du virement
	 * @param dateVirement date du virement
	 * @param montantVirement montant du virement
	 */
	public Virement(int idConseiller, int idCompte, int idVirement, Date dateVirement, double montantVirement) {
		this.idConseiller = idConseiller;
		this.idCompte = idCompte;
		this.idVirement = idVirement;
		this.dateVirement = dateVirement;
		this.montantVirement = montantVirement;
	}
	
	/**
	 * Méthode pour la demande de virement. Flux provenant de la classe conseiller vers la classe utilitaire virement.
	 */
	public void demandeVirement (){
		logger.debug("Je suis dans la méthode demande virement");

	}
	
	/**
	 * Methode pour valider si le solde sur le compte est suffisant pour effectuer un virement. Flux provenant de la classe compte vers la classe utilitaire virement.
	 */
	public void ValiderSoldeVirement(){
		
	}
	
	/**
	 * Méthode pour la validation du virement. Flux provenant de la classe compte vers la classe utilitaire virement.
	 */
	public void validerVirement(){
		
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

	/**
	 * @return the idVirement
	 */
	public int getIdVirement() {
		return idVirement;
	}

	/**
	 * @param idVirement the idVirement to set
	 */
	public void setIdVirement(int idVirement) {
		this.idVirement = idVirement;
	}

	/**
	 * @return the dateVirement
	 */
	public Date getDateVirement() {
		return dateVirement;
	}

	/**
	 * @param dateVirement the dateVirement to set
	 */
	public void setDateVirement(Date dateVirement) {
		this.dateVirement = dateVirement;
	}

	/**
	 * @return the montantVirement
	 */
	public double getMontantVirement() {
		return montantVirement;
	}

	/**
	 * @param montantVirement the montantVirement to set
	 */
	public void setMontantVirement(double montantVirement) {
		this.montantVirement = montantVirement;
	}
	
	

}
