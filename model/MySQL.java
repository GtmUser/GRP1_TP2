package model;


import java.sql.*;
import org.apache.log4j.Logger;

/**
 * 
 * @author Alex et Soizic V-1.0
 * @author Alex et Lena V-1.1
 * @author Alex et David V-1.2
 * 
 * 
 * Classe de gestion de l'acces à une base MySQL
 * 
 */



public class MySQL {
	
	/**
	 * Driver pour se connecter a MySQL
	 */
	private Connection con = null;
	/**
	 * Pour initialiser les requetes dans la base de données
	 */
	private Statement stmt = null;
	/**
	 * Contient les données récupérées dans la base de données
	 */
	private ResultSet rs = null;
	/**
	 *Pour traiter la chaine retournée par l'ordre SQL
	 */
	private ResultSetMetaData rsmd = null;
	/**
	 * propriete pour verifier la connexion à la base de données
	 */
	private boolean resultat = false;
	
	/**
	 * Utilisation de log4j
	 */
	private static Logger logger = Logger.getLogger(model.MySQL.class);
	
	/**
	 * Constructeur sans paramètre de la classe MySQL
	 */
	public MySQL()  {
		this.resultat=true;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://192.168.1.98/pro_grp1","aud1","password");
			stmt = con.createStatement();
		}
		catch (Exception e){
			this.resultat=false;
		}
	}
	
	
	/**
	 * Constructeur avec paramètres de la classe MySQL
	 */
	public MySQL(String adresse,String base,String user,String passwd) {
		this.resultat=true;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://"+adresse+"/"+base,user,passwd);
			stmt = con.createStatement();
		}
		catch (Exception e){
			this.resultat=false;
		}		
	}
	
	
	/**
	 * Methode de deconnexion de la BDD MySQL
	 */
	public void deconnecte() {
		if (con != null){
			try {
				con.close();
			} 
			catch (SQLException e){
			}
		}
	}
	
	
	/**
	 *  Méthode pour mettre à jour les informations d'un client dans la base de données
	 */
	public String updateCli(String ordre) {
		logger.debug("Je suis dans la méthode updateCli");
		try {
			this.stmt.executeUpdate(ordre);
			
		} 
		catch (SQLException e) {}
		return "";
	}
	
	
	/**
	 * Methode de selection dans la BDD MySQL pour rechercher le nom et le prenom du conseiller depuis son login
	 */
	public String selectCon(String ordre)  {
		String retour = null;
		try {
			rs = stmt.executeQuery(ordre);
			rs.next();	
			retour = rs.getString("Prenom")+" ";
			retour += rs.getString("nom");
		}
			catch (Exception e){
				retour="Problème lors de la mise à jour des informations du client";
			}	
		return retour;
	}
	
	
	/**
	 * Methode de selection dans la BDD MySQL pour rechercher la liste des clients associés au conseiller depuis son login
	 */
	public String selectCli(String ordre)  {
		String retour = null;
		try {
			rs = stmt.executeQuery(ordre);
			if ( rs != null){
				// traitement de la chaine retournée par l'ordre SQL
				rsmd = rs.getMetaData();
				retour="<br><table>";
				retour += "<tr>";
				for (int a=1;a<= rsmd.getColumnCount();a++){
					retour += "<th>"+rsmd.getColumnLabel(a)+"</th>";
				}
				retour += "</tr>";
				while (rs.next()){ 
					// pour chacune des lignes retournées par la requete
					retour += "<tr>";
					for (int a=1;a<= rsmd.getColumnCount();a++){
						retour += "<td>"+rs.getString(a)+"</td>";
					}
					//Récupération de l'ID du client pour l'envoyer dans les différentes servlets.
					String id_client = rs.getString(1);
					//Affichage du bouton pour accèder à la page pour éditer les informations d'un client
					retour += "<td><form method='POST' name='majClient' action='majc'>"
							+ "<input type='hidden' name='client' id='id_client' value='"+id_client+"'>"
							+ "<input type='submit' name='information' id='id_information' title='bouton' value='Edition'>"
							+ "</form></td>";
					//Affichage du bouton pour accèder à la liste des comptes d'un client
					retour += "<td><form method='POST' name='listCompte' action='cmpt'>"
							+ "<input type='hidden' name='client' id='id_client' value='"+id_client+"'>"
							+ "<input type='submit' name='compte' id='id_compte' title='bouton' value='Liste des comptes'>"
							+ "</form></td>";
					//Affichage du bouton pour réaliser des virements
					retour += "<td><form method='POST' name='operation' action='ope'>"
							+ "<input type='hidden' name='client' id='id_client' value='"+id_client+"'>"
							+ "<input type='submit' name='virement' id='id_virement' title='bouton' value='Operation Bancaire'>"
							+ "</form></td>";
					retour += "</tr>";
				}
				retour += "</table>";
			}
			else {
				retour = "";
			}
		}
		catch (Exception e){
			retour="Problème lors de la sélection de la liste des clients.";
		}
		return retour;
	}

	
	/**
	 * Methode de selection dans la BDD MySQL pour rechercher un client avec toutes ses infos
	 */
	public String selectEdCli(String ordre)  {
		String retour = null;
		try {
			rs = stmt.executeQuery(ordre);
			if ( rs != null){
				// traitement de la chaine retournée par l'ordre SQL
				rsmd = rs.getMetaData();
				retour="<br><table>";
				retour += "<tr>";
				for (int a=1;a<= rsmd.getColumnCount();a++){
					retour += "<th>"+rsmd.getColumnLabel(a)+"</th>";
				}
				retour += "</tr>";
				while (rs.next()){ 
					// pour chacune des lignes retournées par la requete
					retour += "<tr>";
					for (int a=1;a<= rsmd.getColumnCount();a++){
						retour += "<td>"+rs.getString(a)+"</td>";
					}
					//Récupération de l'ID du client pour l'envoyer dans la servlet modification client
					String id_client = rs.getString(1);
					retour += "</tr>";
					
					//affichage des formulaires d'édition
					retour += "<tr><form method='POST' name='edition' action='majc'>"; 
					retour += "<td>Editer :</td> <input type='hidden' name='client' id='id_client' value='"+id_client+"'>" 
							+ "<td><input type='text' name='info' id='id_nom'></td>"
							+ "<td><input type='text' name='info' id='id_prenom'></td>"
							+ "<td><input type='text' name='info' id='id_adresse'></td>"
							+ "<td><input type='text' name='info' id='id_code_postal'></td>"
							+ "<td><input type='text' name='info' id='id_ville'></td>"
							+ "<td><input type='text' name='info' id='id_telephone'></td>"
							+ "<td><input type='text' name='info' id='id_email'></td>";
							//+ "<td></td>"; 
					retour += "<td><input type='submit' name='edit' title='bouton' id='id_edit' value='Valider'>";
					retour += "</td></form></tr>";
				}
				retour += "</table>";
			}
			else {
				retour = "";
			}
		}
		catch (Exception e){
			retour="Problème lors de la sélection des informaitons d'un client";
		}
		return retour;
	}

		
	
	
	/**
	 * 
	 * Methode de selection dans la BDD MySQL pour rechercher la liste complète des comptes d'un client
	 */
	public String selectCmpt(String ordre) {
					String retour = null;
					try {
						rs = stmt.executeQuery(ordre);
						if ( rs != null){
							// traitement de la chaine retournée par l'ordre SQL
							rsmd = rs.getMetaData();
							retour="<br><table>";
							retour += "<tr>";
							
							for (int a=1;a<= rsmd.getColumnCount();a++){
								retour += "<th>"+rsmd.getColumnLabel(a)+"</th>";
							}
							retour += "</tr>";
							
							while (rs.next()){ 
								// pour chacune des lignes retournées par la requete
								retour += "<tr>";
								for (int a=1;a<= rsmd.getColumnCount();a++){
									retour += "<td>"+rs.getString(a)+"</td>";
								}
								retour += "</tr>";
							}
							retour += "</table>";
						}
						else {
							retour = "";
						}
					}
					catch (Exception e){
						retour="Problème lors de la sélection des comptes d'un client";
					}
					return retour;
				}
	
	/**
	 * 
	 * Methode de selection dans la BDD MySQL pour chercher les comptes d'un client afin de faire une opération
	 */
	public String selectCmptope(String ordre)  {
		String retour = null;
		try {
			rs = stmt.executeQuery(ordre);
			if ( rs != null){
				// traitement de la chaine retournée par l'ordre SQL
				rsmd = rs.getMetaData();
				retour="<br><table>";
				retour += "<tr title='virement'>";
				
				for (int a=1;a<= rsmd.getColumnCount();a++){
					retour += "<th title='virement'>"+rsmd.getColumnLabel(a)+"</th>";
				}
				retour += "<th>Sélection :</th></tr>";
				
				while (rs.next()){ 
					// pour chacune des lignes retournées par la requete
					retour += "<tr title='virement'>";
					for (int a=1;a<= rsmd.getColumnCount();a++){
						retour += "<td>"+rs.getString(a)+"</td>";
					}
					//Récupération de l'ID du compte séléctionné avec le bouton radio pour la servlet Operation_bancaire
					String id_compte = rs.getString("id_compte");
					retour +="<td title='radio'><label class='container'><input type='radio' name='selectcmpt' required='required' id='id_selectcmpt' value='"+id_compte+"' checked='checked'><span class='checkmark'></span></label>";
					retour += "</tr>";
				}
				retour += "</table>";
			}
			else {
				retour = "";
			}
		}
		catch (Exception e){
			retour="Problème lors de la sélection des comptes d'un client afin de faire une opération";
		}
		return retour;
	}

	
	/**
	 * 
	 * Methode pour inserer dans la table operation_bancaires les données du virement
	 */
	public String insert(String ordre) throws SQLException {
		stmt.executeUpdate(ordre);
		return "";
	}
	
	/**
	 * 
	 * Methode de sélection dans la base de données de la table operation_bancaires
	 */
	public String selectvir(String ordre)  {
		String retour = null;
		try {
			rs = stmt.executeQuery(ordre);
			if ( rs != null){
				// traitement de la chaine retournée par l'ordre SQL
				rsmd = rs.getMetaData();
				retour="<br><table>";
				retour += "<tr>";
				for (int a=1;a<= rsmd.getColumnCount();a++){
					retour += "<th>"+rsmd.getColumnLabel(a)+"</th>";
				}
				retour += "</tr>";
				while (rs.next()){ 
					// pour chacune des lignes retournées par la requete
					retour += "<tr>";
					for (int a=1;a<= rsmd.getColumnCount();a++){
						retour += "<td>"+rs.getString(a)+"</td>";
					}

				}
				retour += "</table>";
			}
			else {
				retour = "";
			}
		}
		catch (Exception e){
			retour="Problème lors de la sélection de données dans la table operation_bancaire";
		}
		return retour;
	}
	
	
	/**
	 * 
	 * Méthode non utilisée. Permet de confirmer l'accès à la base de données
	 * 
	 */
	public boolean isResultat() {
		return resultat;
	}
	
	
}
