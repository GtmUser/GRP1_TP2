package controller;
import org.apache.log4j.Logger;
/**
 * Classe regroupant les propri�t�s de l'employ�
 * 
 * @author David et Cyril version 1.0
 * @author David et Alex version 2.0 
 */

public class Employe extends Personne{
	/**
	 * Utilisation de log4j
	 */
	private static Logger logger = Logger.getLogger(controller.Employe.class);
	/**
	 * identifiant pour se connecter au syst�me informatique de Proxibanque
	 */
	private String user;
	/**
	 * mot de passe pour se connecter au syst�me informatique de Proxibanque
	 */
	private String password;
	
	/**
	 * Constructeur sans param�tre
	 */
	public Employe(){
		
	}
	
	/**
	 * Constructeur avec les param�tres
	 * @param user user
	 * @param password password
	 */
	public Employe(String prenom, String nom, String adresse, int cp, String telephone, String ville, String email,
			String user, String password) {
		super(prenom, nom, adresse, cp, telephone, ville, email);
		this.user = user;
		this.password = password;
	}

	
	/**
	 * M�thode pour autoriser la connexion
	 */
	public void autoriserConnexion(){
		logger.debug("Je suis dans la m�thode authentification");
		
	}
	
	/**
	 * @return the user
	 */
	public String getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(String user) {
		this.user = user;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	
	
}
