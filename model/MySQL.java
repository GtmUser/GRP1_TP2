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
 * Classe de gestion de l'acces � une base MySQL
 * 
 */



public class MySQL {
	
	/**
	 * Driver pour se connecter a MySQL
	 */
	private Connection con = null;
	/**
	 * Pour initialiser les requetes dans la base de donn�es
	 */
	private Statement stmt = null;
	/**
	 * Contient les donn�es r�cup�r�es dans la base de donn�es
	 */
	private ResultSet rs = null;
	/**
	 *Pour traiter la chaine retourn�e par l'ordre SQL
	 */
	private ResultSetMetaData rsmd = null;
	/**
	 * propriete pour verifier la connexion � la base de donn�es
	 */
	private boolean resultat = false;
	
	/**
	 * Utilisation de log4j
	 */
	private static Logger logger = Logger.getLogger(model.MySQL.class);
	
	/**
	 * Constructeur sans param�tre de la classe MySQL
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
	 * Constructeur avec param�tres de la classe MySQL
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
	 *  M�thode pour mettre � jour les informations d'un client dans la base de donn�es
	 */
	public String updateCli(String ordre) {
		logger.debug("Je suis dans la m�thode updateCli");
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
				retour="Probl�me lors de la mise � jour des informations du client";
			}	
		return retour;
	}
	
	
	/**
	 * Methode de selection dans la BDD MySQL pour rechercher la liste des clients associ�s au conseiller depuis son login
	 */
	public String selectCli(String ordre)  {
		String retour = null;
		try {
			rs = stmt.executeQuery(ordre);
			if ( rs != null){
				// traitement de la chaine retourn�e par l'ordre SQL
				rsmd = rs.getMetaData();
				retour="<br><table>";
				retour += "<tr>";
				for (int a=1;a<= rsmd.getColumnCount();a++){
					retour += "<th>"+rsmd.getColumnLabel(a)+"</th>";
				}
				retour += "</tr>";
				while (rs.next()){ 
					// pour chacune des lignes retourn�es par la requete
					retour += "<tr>";
					for (int a=1;a<= rsmd.getColumnCount();a++){
						retour += "<td>"+rs.getString(a)+"</td>";
					}
					//R�cup�ration de l'ID du client pour l'envoyer dans les diff�rentes servlets.
					String id_client = rs.getString(1);
					//Affichage du bouton pour acc�der � la page pour �diter les informations d'un client
					retour += "<td><form method='POST' name='majClient' action='majc'>"
							+ "<input type='hidden' name='client' id='id_client' value='"+id_client+"'>"
							+ "<input type='submit' name='information' id='id_information' title='bouton' value='Edition'>"
							+ "</form></td>";
					//Affichage du bouton pour acc�der � la liste des comptes d'un client
					retour += "<td><form method='POST' name='listCompte' action='cmpt'>"
							+ "<input type='hidden' name='client' id='id_client' value='"+id_client+"'>"
							+ "<input type='submit' name='compte' id='id_compte' title='bouton' value='Liste des comptes'>"
							+ "</form></td>";
					//Affichage du bouton pour r�aliser des virements
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
			retour="Probl�me lors de la s�lection de la liste des clients.";
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
				// traitement de la chaine retourn�e par l'ordre SQL
				rsmd = rs.getMetaData();
				retour="<br><table>";
				retour += "<tr>";
				for (int a=1;a<= rsmd.getColumnCount();a++){
					retour += "<th>"+rsmd.getColumnLabel(a)+"</th>";
				}
				retour += "</tr>";
				while (rs.next()){ 
					// pour chacune des lignes retourn�es par la requete
					retour += "<tr>";
					for (int a=1;a<= rsmd.getColumnCount();a++){
						retour += "<td>"+rs.getString(a)+"</td>";
					}
					//R�cup�ration de l'ID du client pour l'envoyer dans la servlet modification client
					String id_client = rs.getString(1);
					retour += "</tr>";
					
					//affichage des formulaires d'�dition
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
			retour="Probl�me lors de la s�lection des informaitons d'un client";
		}
		return retour;
	}

		
	
	
	/**
	 * 
	 * Methode de selection dans la BDD MySQL pour rechercher la liste compl�te des comptes d'un client
	 */
	public String selectCmpt(String ordre) {
					String retour = null;
					try {
						rs = stmt.executeQuery(ordre);
						if ( rs != null){
							// traitement de la chaine retourn�e par l'ordre SQL
							rsmd = rs.getMetaData();
							retour="<br><table>";
							retour += "<tr>";
							
							for (int a=1;a<= rsmd.getColumnCount();a++){
								retour += "<th>"+rsmd.getColumnLabel(a)+"</th>";
							}
							retour += "</tr>";
							
							while (rs.next()){ 
								// pour chacune des lignes retourn�es par la requete
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
						retour="Probl�me lors de la s�lection des comptes d'un client";
					}
					return retour;
				}
	
	/**
	 * 
	 * Methode de selection dans la BDD MySQL pour chercher les comptes d'un client afin de faire une op�ration
	 */
	public String selectCmptope(String ordre)  {
		String retour = null;
		try {
			rs = stmt.executeQuery(ordre);
			if ( rs != null){
				// traitement de la chaine retourn�e par l'ordre SQL
				rsmd = rs.getMetaData();
				retour="<br><table>";
				retour += "<tr title='virement'>";
				
				for (int a=1;a<= rsmd.getColumnCount();a++){
					retour += "<th title='virement'>"+rsmd.getColumnLabel(a)+"</th>";
				}
				retour += "<th>S�lection :</th></tr>";
				
				while (rs.next()){ 
					// pour chacune des lignes retourn�es par la requete
					retour += "<tr title='virement'>";
					for (int a=1;a<= rsmd.getColumnCount();a++){
						retour += "<td>"+rs.getString(a)+"</td>";
					}
					//R�cup�ration de l'ID du compte s�l�ctionn� avec le bouton radio pour la servlet Operation_bancaire
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
			retour="Probl�me lors de la s�lection des comptes d'un client afin de faire une op�ration";
		}
		return retour;
	}

	
	/**
	 * 
	 * Methode pour inserer dans la table operation_bancaires les donn�es du virement
	 */
	public String insert(String ordre) throws SQLException {
		stmt.executeUpdate(ordre);
		return "";
	}
	
	/**
	 * 
	 * Methode de s�lection dans la base de donn�es de la table operation_bancaires
	 */
	public String selectvir(String ordre)  {
		String retour = null;
		try {
			rs = stmt.executeQuery(ordre);
			if ( rs != null){
				// traitement de la chaine retourn�e par l'ordre SQL
				rsmd = rs.getMetaData();
				retour="<br><table>";
				retour += "<tr>";
				for (int a=1;a<= rsmd.getColumnCount();a++){
					retour += "<th>"+rsmd.getColumnLabel(a)+"</th>";
				}
				retour += "</tr>";
				while (rs.next()){ 
					// pour chacune des lignes retourn�es par la requete
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
			retour="Probl�me lors de la s�lection de donn�es dans la table operation_bancaire";
		}
		return retour;
	}
	
	
	/**
	 * 
	 * M�thode non utilis�e. Permet de confirmer l'acc�s � la base de donn�es
	 * 
	 */
	public boolean isResultat() {
		return resultat;
	}
	
	
}
