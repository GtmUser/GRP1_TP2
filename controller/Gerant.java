package controller;
import org.apache.log4j.Logger;
/**
 * Classe regroupant les propri�tes du g�rant
 * 
 * @author David et Cyril version 1.0
 * @author David et Alex version 2.0 
 */

public class Gerant extends Employe{
	/**
	 * Utilisation de log4j
	 */
	private static Logger logger = Logger.getLogger(controller.Gerant.class);
	/**
	 * id du g�rant
	 */
	private int idGerant;
	/**
	 * String liste des transactions effectu�es
	 */
	private String listeTransaction;
	/**
	 * String retour de la realisation de l'audit
	 */
	private String retourAudit;
	

	
	/**
	 * Constructeur sans param�tre		
	 */
	public Gerant(){
		
	}
	

	/**
	 * Constructeur avec param�tres
	 * @param prenom prenom
	 * @param nom nom
	 * @param adresse adresse
	 * @param cp code postal
	 * @param telephone num�ro de t�l�phone
	 * @param ville ville
	 * @param email email
	 * @param user user
	 * @param password password
	 * @param listeTransaction listeTransaction
	 * @param retourAudit retourAudit
	 */
	public Gerant(String prenom, String nom, String adresse, int cp, String telephone, String ville, String email,
			String user, String password, int idGerant, String listeTransaction, String retourAudit) {
		super(prenom, nom, adresse, cp, telephone, ville, email, user, password);
		this.idGerant = idGerant;
		this.listeTransaction = listeTransaction;
		this.retourAudit = retourAudit;

		
	}


	/**
	 * @return the listeTransaction
	 */
	public String getListeTransaction() {
		return listeTransaction;
	}


	/**
	 * @param listeTransaction the listeTransaction to set
	 */
	public void setListeTransaction(String listeTransaction) {
		this.listeTransaction = listeTransaction;
	}


	/**
	 * Methode pour le gerant pour afficher le r�sultat de l'audit
	 */
	public String afficherAudit(){
		logger.debug("Je suis dans la m�thode afficher audit");
		return retourAudit;
	}
	
	/**
	 * Methode pour le g�rant pour afficher le rapport sur les transactions d'un client.
	 */
	public String afficherListeTransactions(){
		return listeTransaction;
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

	
	
	
}
