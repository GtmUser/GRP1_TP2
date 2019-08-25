package controller;

import java.util.Date;
import org.apache.log4j.Logger;
/**
 * Classe regroupant les propriétés d'un compte bancaire
 * 
 * @author David et Cyril version 1.0
 * @author David et Alex version 2.0 
 *
 */

public class Compte_bancaire {
	/**
	 * Utilisation de log4j
	 */
	private static Logger logger = Logger.getLogger(controller.Compte_bancaire.class);
	/**
	 * id compte
	 */
	private int idCompte;
	/**
	 * date ouverture du compte
	 */
	private Date date_ouverture;
	/**
	 * Resultat du calcul du solde à partir des opérations
	 */
	private double resultatCalculSolde;
	/**
	 * type d'opération
	 */
	private String type_operation;
	/**
	 * type de carte : pas de carte, electron ou premier
	 */
	private String type_carte;
	/**
	 * id du virement
	 */
	private int idVirement;
	/**
	 * id de l'audit
	 */
	private int idAudit;
	/**
	 * id du conseiller
	 */
	private int idConseiller;
	/**
	 * id du client
	 */
	private int idClient;
	/**
	 * String liste des transactions effectuées
	 */
	private String listeTransaction;
	/**
	 * String liste des clients fortunés
	 */
	private String listeClientFortune;

	
	/**
	 * constructeur par défaut sans parametre
	 */
	public Compte_bancaire(){
		
	}


	/**
	 * Constructeur avec les paramètres
	 * @param idCompte idCompte
	 * @param date_ouverture date d'ouverture
	 * @param resultatCalculSolde resultat du calcul du solde
	 * @param type_operation type d'operation
	 * @param type_carte type de carte
	 * @param idVirement idVirement
	 * @param idAudit idAudit
	 * @param idConseiller idConseiller
	 * @param idClient idClient
	 * @param listeTransaction listeTransaction
	 * @param listeClientFortune listeClientFortune
	 */
	public Compte_bancaire(int idCompte, Date date_ouverture, double resultatCalculSolde, String type_operation,
			String type_carte, int idVirement, int idAudit, int idConseiller, int idClient, String listeTransaction, String listeClientFortune) {
		this.idCompte = idCompte;
		this.date_ouverture = date_ouverture;
		this.resultatCalculSolde = resultatCalculSolde;
		this.type_operation = type_operation;
		this.type_carte = type_carte;
		this.idVirement = idVirement;
		this.idAudit = idAudit;
		this.idConseiller = idConseiller;
		this.idClient = idClient;
		this.listeTransaction = listeTransaction;
		this.listeClientFortune = listeClientFortune;
	}

	


	


	/**
	 * Methode pour choisir le type de carte bancaire : pas de carte, electron ou premier
	 */
	public String choisirCarte(){
		logger.debug("Je suis dans la méthode pour choisir une carte bancaire");
		return type_carte;
	}
	
	/**
	 * Methode pour analyser le crédit. Flux provenant de la classe utilitaire crédit vers le classe compte.
	 */
	public void analyserCredit(){
		
	}
	
	/**
	 * Methode pour consulter le compte
	 */
	public void consulterCompte(){
		
	}
	
	/**
	 * Methode pour analyser le solde du compte pour l'audit. Flux provenant de la classe utilitaire audit vers la classe compte bancaire.
	 */
	public void analyserAudit(){
		
	}
	
	/**
	 * Methode pour réaliser des investissements
	 */
	public void realiserInvestissement(){
				
	}
	
	/**
	 * Methode pour calculer le solde du compte à partir des opérations
	 */
	public double calculSolde(){
		return resultatCalculSolde;
		
	}
	
	
	/**
	 * Methode pour créer un compte
	 */
	public void creer_compte(){
		
	}
	
	/**
	 * Methode pour supprimer un compte
	 */
	public void supprimer_compte(){
		
	}
	
	/**
	 * Methode pour modifier les informations d'un compte
	 */
	public void modifier_compte(){
		
	}
	
	
	/**
	 * Methode pour supprimer une carte bancaire
	 */
	public void supprimerCarte(){
		
	}
	
	/**
	 * Methode pour realiser la liste des clients fortunés
	 */
	public String realiserListeClientFortune(){
		return listeClientFortune;
					
	}
	
	public String realiserListeTransaction() {
		
		return listeTransaction;
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
	 * @return the date_ouverture
	 */
	public Date getDate_ouverture() {
		return date_ouverture;
	}


	/**
	 * @param date_ouverture the date_ouverture to set
	 */
	public void setDate_ouverture(Date date_ouverture) {
		this.date_ouverture = date_ouverture;
	}


	/**
	 * @return the resultatCalculSolde
	 */
	public double getResultatCalculSolde() {
		return resultatCalculSolde;
	}


	/**
	 * @param resultatCalculSolde the resultatCalculSolde to set
	 */
	public void setResultatCalculSolde(double resultatCalculSolde) {
		this.resultatCalculSolde = resultatCalculSolde;
	}


	/**
	 * @return the type_operation
	 */
	public String getType_operation() {
		return type_operation;
	}


	/**
	 * @param type_operation the type_operation to set
	 */
	public void setType_operation(String type_operation) {
		this.type_operation = type_operation;
	}


	/**
	 * @return the type_carte
	 */
	public String getType_carte() {
		return type_carte;
	}


	/**
	 * @param type_carte the type_carte to set
	 */
	public void setType_carte(String type_carte) {
		this.type_carte = type_carte;
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
	 * @return the idClient
	 */
	public int getIdClient() {
		return idClient;
	}


	/**
	 * @param idClient the idClient to set
	 */
	public void setIdClient(int idClient) {
		this.idClient = idClient;
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
	 * @return the listeClientFortune
	 */
	public String getListeClientFortune() {
		return listeClientFortune;
	}


	/**
	 * @param listeClientFortune the listeClientFortune to set
	 */
	public void setListeClientFortune(String listeClientFortune) {
		this.listeClientFortune = listeClientFortune;
	}
	
	

}
