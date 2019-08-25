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
 * Cette classe servlet permet l'affichage des comptes bancaires d'un client
 * 
 */


	public class Compte_bancaire extends HttpServlet {
	
	/**
	 * Utilisation de log4j
	 */
	private static Logger logger = Logger.getLogger(model.Compte_bancaire.class);
	
	
	/**
	 *  Méthode permettant d'afficher les comptes d'unclient
	 */
	public void doGet(HttpServletRequest rq, HttpServletResponse rs)
			throws ServletException, IOException  {
				logger.debug("Je suis dans la méthode doGet");
				PrintWriter out = rs.getWriter();
				//Balise HTML et ajout du fichier css
				out.print("<link rel='stylesheet' href='gestion.css'/>");
				//Affichage du logo de Proxibanque
				out.println("<div class='logo'><img src='images/logo.png' alt='logo' title='logo_Proxibanque'><span>ProxiBanque</span></div>");

				//Affichage du titre sur la page HTML
				out.print("<div class='titre'>Liste des comptes du client");
				out.print("</div>");
				
				
				//Récupération d'ID du client sélectionné
				String client = rq.getParameter("client");
			
				// Affichage des infos des comptes du client
				out.print("<div class='fenetrecompte'>");
				try{
					MySQL infoCompte = new MySQL();
					String liste=null;
					liste=infoCompte.selectCmpt("select id_compte,type_compte,date_ouverture,autorisation_decouvert,taux_remuneration,type_carte from comptes where client='"+client+"'");
					out.print(liste);
					out.print("</div>");	
					infoCompte.deconnecte();
				}
				catch(Exception e){
					out.println("<h1>Veuillez vérifier les paramètres de votre requete</h1>");
				}
					
				//Affichage du bouton pour retourner à la liste des clients
				out.print("<div class='accueil'><form method='post' name='retour' action='accueil'>");
				out.print("<input type='submit' name='boutonretour' id='id_boutonretour' title='accueil' value='Retour' ></form></div>");
				
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