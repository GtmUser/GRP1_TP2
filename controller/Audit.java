package controller;

import java.util.Date;
import org.apache.log4j.Logger;
/**
 * Classe utilitaire regroupant les param�tres de l'audit
 * 
 * @author David et Cyril version 1.0
 * @author David et Alex version 2.0 
 */

public class Audit {
	private static Logger logger = Logger.getLogger(controller.Audit.class);
	/**
	 * id du g�rant
	 */
	private int idGerant;
	/**
	 * id de l'audit
	 */
	private int idAudit;
	/**
	 * Date de l'audit
	 */
	private Date dateAudit;
	/**
	 * R�sultat de l'audit
	 */
	private String resultatAudit;
	
	/**
	 * Constructeur sans param�tre
	 */
	public Audit(){
		
	}

	/**
	 * Constructeur avec les param�tres
	 * @param idGerant idGerant
	 * @param idAudit idAudit
	 * @param dateAudit dateAudit
	 * @param resultatAudit resultatAudit
	 */
	public Audit(int idGerant, int idAudit, Date dateAudit, String resultatAudit) {
		this.idGerant = idGerant;
		this.idAudit = idAudit;
		this.dateAudit = dateAudit;
		this.resultatAudit = resultatAudit;
	}
	
	/**
	 * Methode pour la demande d'audit. Flux provenant de la classe G�rant vers le classe utilitaire audit.
	 */
	public void demanderAudit(){
	logger.debug("Je suis dans la m�thode demande audit");
	}

	/**
	 * M�thode pour r�aliser l'audit. Flux provenant de compte vers la classe utilitaire audit. 
	 * @return
	 */
	public String traiterAudit(){
		
		
		return resultatAudit;
	}
	/**
	 * @return the idGerant
	 */
	public int getIdGerant() {
		return idGerant;
	}

	/**
	 * @param idGerant the idGerant to set
	 */
	public void setIdGerant(int idGerant) {
		this.idGerant = idGerant;
	}

	/**
	 * @return the idAudit
	 */
	public int getIdAudit() {
		return idAudit;
	}

	/**
	 * @param idAudit the idAudit to set
	 */
	public void setIdAudit(int idAudit) {
		this.idAudit = idAudit;
	}

	/**
	 * @return the dateAudit
	 */
	public Date getDateAudit() {
		return dateAudit;
	}

	/**
	 * @param dateAudit the dateAudit to set
	 */
	public void setDateAudit(Date dateAudit) {
		this.dateAudit = dateAudit;
	}

}
