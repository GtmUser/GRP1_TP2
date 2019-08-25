package controller;
import org.apache.log4j.Logger;
/**
 * Classe stardard de Personne qui regroupe les propriétés d'une personne
 * 
 * @author David et Cyril version 1.0
 * @author David et Alex version 2.0 
 */

public class Personne {
	/**
	 * Utilisation de log4j
	 */
	private static Logger logger = Logger.getLogger(controller.Personne.class);
	/**
	 * Prenom de la personne
	 */
	private String prenom;
	/**
	 * Nom de la personne
	 */
	private String nom;
	/**
	 * Adresse de la personne
	 */
	private String adresse; 
	/**
	 * Code postal de la personne
	 */
	private int cp;
	/**
	 * Numéro de téléphone de la personne
	 */
	private String telephone;
	/**
	 * ville de la personne
	 */
	private String ville;
	/**
	 * adresse email de la personne
	 */
	private String email;
	
	
	/**
	 * Constructeur vide (par defaut)
	 */
	public Personne(){
	
	}
	
	/**
	 * Constructeur avec les paramètres
	 * @param prenom prenom
	 * @param nom nom
	 * @param adresse adresse
	 * @param cp code postale
	 * @param telephone numéro de téléphone
	 * @param ville ville
	 * @param email email
	 */
	public Personne(String prenom, String nom, String adresse, int cp, String telephone, String ville, String email) {
		this.prenom = prenom;
		this.nom = nom;
		this.adresse = adresse;
		this.cp = cp;
		this.telephone = telephone;
		this.ville = ville;
		this.email = email;
	}


	/**
	 * Methode pour dormir
	 */
	public void dormir(){
	logger.debug("Je suis dans la méthode dormir");
	}
	
	/**
	 * Methode pour manger
	 */
	public void manger(){
		
	}
	
	/**
	 * Methode pour respirer
	 */
	public void respirer(){
		
	}
	/**
	 * @return the prenom
	 */
	public String getPrenom() {
		return prenom;
	}


	
	/**
	 * @param prenom the prenom to set
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}



	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}



	/**
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}



	/**
	 * @return the adresse
	 */
	public String getAdresse() {
		return adresse;
	}



	/**
	 * @param adresse the adresse to set
	 */
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}



	/**
	 * @return the cp
	 */
	public int getCp() {
		return cp;
	}



	/**
	 * @param cp the cp to set
	 */
	public void setCp(int cp) {
		this.cp = cp;
	}



	/**
	 * @return the telephone
	 */
	public String getTelephone() {
		return telephone;
	}



	/**
	 * @param telephone the telephone to set
	 */
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}



	/**
	 * @return the ville
	 */
	public String getVille() {
		return ville;
	}



	/**
	 * @param ville the ville to set
	 */
	public void setVille(String ville) {
		this.ville = ville;
	}



	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}



	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
	
}


