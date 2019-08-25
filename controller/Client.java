package controller;
import java.util.Date;

import org.apache.log4j.Logger;
/**
 * Classe regroupant les propriétés du client
 * 
 * @author David et Cyril version 1.0
 * @author David et Alex version 2.0 
 */

public class Client extends Personne{
	/**
	 * Utilisation de log4j
	 */
	private static Logger logger = Logger.getLogger(controller.Client.class);
	/**
	 * Compte courant ou epargne
	 */
	private String type_compte;
	/**
	 * Client entreprise ou particulier
	 */
	private boolean type_client;
	/**
	 * numéro d'identification du conseiller lié au client
	 */
	private Date date_ouv_courant;
	/**
	 * date d'ouverture du compte epargne
	 */
	private Date date_ouv_epargne;
	/**
	 * id du conseiller
	 */
	private int idConseiller;
	/**
	 * id du compte
	 */
	private int idCompte;
	/**
	 * taux de rémunération du compte epargne
	 */
	private float taux_remuneration;
	/**
	 * taux de découvert autorisé du compte courant
	 */
	private float autorisationDecouvert;
	/**
	 * id du client
	 */
	private int idClient;

	
	/**
	 * Constructeur vide
	 */
	public Client() {
		super();
		
	}


	/**
	 * Constructeur avec les paramètres
	 * @param type_compte type de compte
	 * @param type_client type de client
	 * @param date_ouv_courant date ouverture courant
	 * @param date_ouv_epargne date ouverture epargne
	 * @param idConseiller id Conseiller
	 * @param idCompte id Compte
	 * @param taux_remuneration taux de remuneration
	 * @param autorisationDecouvert autorisation de Decouvert
	 * @param idClient id Client
	 */
	public Client(String prenom, String nom, String adresse, int cp, String telephone, String ville, String email, String type_compte, boolean type_client, Date date_ouv_courant, Date date_ouv_epargne,
			int idConseiller, int idCompte, float taux_remuneration, float autorisationDecouvert, int idClient) {
		super(prenom, nom, adresse, cp, telephone, ville, email);
		this.type_compte = type_compte;
		this.type_client = type_client;
		this.date_ouv_courant = date_ouv_courant;
		this.date_ouv_epargne = date_ouv_epargne;
		this.idConseiller = idConseiller;
		this.idCompte = idCompte;
		this.taux_remuneration = taux_remuneration;
		this.autorisationDecouvert = autorisationDecouvert;
		this.idClient = idClient;
	}

	/**
	 * Methode pour créer un client
	 */
	public void creerClient(){
		logger.debug("Je suis dans la méthode creer client");
	}

	/**
	 * Methode pour supprimer un client
	 */
	public void supprimerClient(){
		
	}

	/**
	 * Methode pour modifier les informations d'un client
	 */
	public void modifierClient(){
		
	}

	/**
	 * Methode pour lire un client
	 */
	public void lireClient(){
		
	}
	
	/**
	 * @return the type_compte
	 */
	public String getType_compte() {
		return type_compte;
	}


	/**
	 * @param type_compte the type_compte to set
	 */
	public void setType_compte(String type_compte) {
		this.type_compte = type_compte;
	}

	/**
	 * @return the type_client
	 */
	public boolean isType_client() {
		return type_client;
	}

	/**
	 * @param type_client the type_client to set
	 */
	public void setType_client(boolean type_client) {
		this.type_client = type_client;
	}

	/**
	 * @return the date_ouv_courant
	 */
	public Date getDate_ouv_courant() {
		return date_ouv_courant;
	}

	/**
	 * @param date_ouv_courant the date_ouv_courant to set
	 */
	public void setDate_ouv_courant(Date date_ouv_courant) {
		this.date_ouv_courant = date_ouv_courant;
	}


	/**
	 * @return the date_ouv_epargne
	 */
	public Date getDate_ouv_epargne() {
		return date_ouv_epargne;
	}

	/**
	 * @param date_ouv_epargne the date_ouv_epargne to set
	 */
	public void setDate_ouv_epargne(Date date_ouv_epargne) {
		this.date_ouv_epargne = date_ouv_epargne;
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
	 * @return the taux_remuneration
	 */
	public float getTaux_remuneration() {
		return taux_remuneration;
	}


	/**
	 * @param taux_remuneration the taux_remuneration to set
	 */
	public void setTaux_remuneration(float taux_remuneration) {
		this.taux_remuneration = taux_remuneration;
	}


	/**
	 * @return the autorisationDecouvert
	 */
	public float getAutorisationDecouvert() {
		return autorisationDecouvert;
	}


	/**
	 * @param autorisationDecouvert the autorisationDecouvert to set
	 */
	public void setAutorisationDecouvert(float autorisationDecouvert) {
		this.autorisationDecouvert = autorisationDecouvert;
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


	

}
