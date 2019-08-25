package model;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import org.apache.log4j.Logger;
import model.MySQL;


/**
 * 
 *  * @author Alex et David V-1.2
 *  
 * 	Cette classe servlet permet l'affichage de la liste des clients spécifique à un conseiller.
 * 
 */


public class Authentification extends HttpServlet {
	
	/**
	 * Utilisation de log4j
	 */
	private static Logger logger = Logger.getLogger(model.Authentification.class);
	
	
	
/**
 *   Méthode permettant d'afficher les nom et prénom du conseiller ainsi que sa liste de clients attribués 
 *   en utilisant son login lors de son authentification
 */
	public void doGet(HttpServletRequest rq, HttpServletResponse rs)
		throws ServletException, IOException  {
			logger.debug("Je suis dans la méthode doGet");
			PrintWriter out = rs.getWriter();
			//Balise HTML et ajout du fichier css
			out.print("<html><head><link rel='stylesheet' href='gestion.css'/>");
			//Affichage du logo de Proxibanque
			out.println("<div class='logo'><img src='images/logo.png' alt='logo' title='logo_Proxibanque'><span>ProxiBanque</span></div>");
			//Récupération du login du conseiller afin d'afficher uniquement les clients du conseiller connecté.
			String login = rq.getUserPrincipal().getName();
				
								
			// Affichage du nom du conseiller
			try{
				MySQL idconseiller = new MySQL();
				String nom=null;
				nom=idconseiller.selectCon("select prenom,nom from conseillers where id_conseiller='"+login+"'");
				out.print("<div class='titre'>Bienvenue ");
				out.println(nom);
				out.print("<br />Votre liste des clients :</div>");
				idconseiller.deconnecte();
			}
			catch(Exception e){
				out.println("<h1>Veuillez vérifier les paramètres de votre requete</h1>");
			}
			
			
			// Affichage de la liste des clients du conseiller
			out.print("<div class='fenetreauth'>");
			try{
				MySQL listeclients = new MySQL();
				String liste=null;
				liste=listeclients.selectCli("select id_client,nom,prenom from clients where conseiller='"+login+"'");
				out.print(liste);	
				listeclients.deconnecte();
				out.print("</div>");
			}
			catch(Exception e){
				out.println("<h1>Veuillez vérifier les paramètres de votre requete</h1>");
			}
			
			//fin de balise HTML
			out.print("</body></html>");
	}
	
	
	/**
	 *   Renvoi à la méthode doGet
	 */
	public void doPost(HttpServletRequest rq, HttpServletResponse rs)
	throws ServletException, IOException  {
		doGet(rq,rs);		
	}
	
	
	
}

