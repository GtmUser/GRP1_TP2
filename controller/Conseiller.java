package controller;
import org.apache.log4j.Logger;
/**
 * Classe regroupant les propriétés du conseiller
 * 
 * @author David et Cyril version 1.0
 * @author David et Alex version 2.0 
 */

public class Conseiller extends Employe{
	/**
	 * Utilisation de log4j
	 */
	private static Logger logger = Logger.getLogger(controller.Conseiller.class);
	/**
	 * Liste de clients d'un conseiller
	 */
	private String liste_client;
	/**
	 * Nombre de client pour un conseiller
	 */
	private String nbClient;
	/**
	 * Liste des clients fortunés
	 */
	private String liste_client_fortune;
	/**
	 * id conseiller
	 */
	private int idConseiller;
	/**
	 * String validation de la simulation du credit
	 */
	private String retourCredit;
	/**
	 * String retour de l'investissement
	 */
	private String retourInvestissement;
	/**

	/**
	 * String info concernant le client et son compte
	 */
	private String infoClient;
	/**
	 * String retour de la realisation du virement
	 */
	private String retourVirement;
		
	
	/**
	 * Constructeur sans parametere
	 */
	public Conseiller() {
		super();
	}


	/**
	 * Constructeur avec parametres
	 * @param prenom prenom
	 * @param nom nom
	 * @param adresse adresse
	 * @param cp code postal
	 * @param telephone numero de telephone
	 * @param ville ville
	 * @param email adresse email
	 * @param user user
	 * @param password passowrd
	 * @param liste_client liste des clients
	 * @param liste_client_fortune liste des clients fortunés
	 * @param idConseiller idConseiller
	 * @param retourCredit retourCredit
	 * @param retourInvestissement retourInvestissement
	 * @param infoClient infoClient
	 * @param retourVirement retourVirement
	 */
	public Conseiller(String prenom, String nom, String adresse, int cp, String telephone, String ville, String email,
			String user, String password, String liste_client, String nbClient, String liste_client_fortune, int idConseiller,
			String retourCredit, String retourInvestissement, String infoClient, String retourVirement) {
		super(prenom, nom, adresse, cp, telephone, ville, email, user, password);
		this.liste_client = liste_client;
		this.nbClient = nbClient;
		this.liste_client_fortune = liste_client_fortune;
		this.idConseiller = idConseiller;
		this.retourCredit = retourCredit;
		this.retourInvestissement = retourInvestissement;
		this.infoClient = infoClient;
		this.retourVirement = retourVirement;
		
	}

	/**
	 * Methode pour la confirmation du virement. FLux provenant de la classe utilitaire virement vers le conseiller.
	 */
	public String confirmerVirement(){
		logger.debug("Je suis dans la méthode confirmation virement");
		return retourVirement;
	}
	
	/**
	 * Methode pour afficher le taux de credit. Flux provenant de la classe utilitaire crédit vers le conseiller.
	 */
	public String afficherCredit(){
		return retourCredit;
		
	}
	
		
	
	/**
	 * Methode pour confirmer que l'investissement pour le client est bien possible. Flux provenant de la classe investissement vers le conseiller.
	 */
	public String afficherInvestissement(){
		return retourInvestissement;
		
	}
	
	/**
	 * Methode pour afficher modification du client
	 */
	public String afficherModifClient(){
		return infoClient;
		
	}
	
	/**
	 * Methode pour afficher la creation client
	 */
	public String afficherCreationClient(){
		return infoClient;
	}
	
	/**
	 * Methode pour afficher la suppression client
	 */
	public String afficherSupprClient(){
		return infoClient;
	}
	
	/**
	 * Methode pour afficher la creation du compte
	 */
	public String afficherCreationCompte(){
		return infoClient;
	}
	
	/**
	 * Methode pour afficher la suppression du compte
	 */
	public String afficherSupprCompte(){
		return infoClient;
	}
	
	/**
	 * Methode pour afficher la liste des clients
	 */
	public String afficherListeClient(){
		return liste_client;
	}
	
	/**
	 * Methode pour afficher la liste des clients fortunés
	 */
	public String afficherListeClientFortune(){
		return liste_client_fortune;
	}
	/**
	 * Methode pour afficher les informations du client
	 */
	public String afficherInfoClient(){
		return infoClient;
		
	}
	/**
	 * @return the liste_client
	 */
	public String getListe_client() {
		return liste_client;
	}


	/**
	 * @return the retourCredit
	 */
	public String getRetourCredit() {
		return retourCredit;
	}


	/**
	 * @param retourCredit the retourCredit to set
	 */
	public void setRetourCredit(String retourCredit) {
		this.retourCredit = retourCredit;
	}


	/**
	 * @return the retourInvestissement
	 */
	public String getRetourInvestissement() {
		return retourInvestissement;
	}


	/**
	 * @param retourInvestissement the retourInvestissement to set
	 */
	public void setRetourInvestissement(String retourInvestissement) {
		this.retourInvestissement = retourInvestissement;
	}


	/**
	 * @return the infoClient
	 */
	public String getInfoClient() {
		return infoClient;
	}


	/**
	 * @param infoClient the infoClient to set
	 */
	public void setInfoClient(String infoClient) {
		this.infoClient = infoClient;
	}


	/**
	 * @return the retourVirement
	 */
	public String getRetourVirement() {
		return retourVirement;
	}


	/**
	 * @param retourVirement the retourVirement to set
	 */
	public void setRetourVirement(String retourVirement) {
		this.retourVirement = retourVirement;
	}


	/**
	 * @param liste_client the liste_client to set
	 */
	public void setListe_client(String liste_client) {
		this.liste_client = liste_client;
	}


	/**
	 * @return the nbClient
	 */
	public String getNbClient() {
		return nbClient;
	}


	/**
	 * @param nbClient the nbClient to set
	 */
	public void setNbClient(String nbClient) {
		this.nbClient = nbClient;
	}


	/**
	 * @return the liste_client_fortune
	 */
	public String getListe_client_fortune() {
		return liste_client_fortune;
	}


	/**
	 * @param liste_client_fortune the liste_client_fortune to set
	 */
	public void setListe_client_fortune(String liste_client_fortune) {
		this.liste_client_fortune = liste_client_fortune;
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


	
	
}
	