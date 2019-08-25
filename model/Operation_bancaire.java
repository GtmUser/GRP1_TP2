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
 * 
 * Cette classe servlet permet l'affichage des formulaires permettant d'effectuer des operations de virements bancaires
 * 
 */


public class Operation_bancaire extends HttpServlet {
	
	/**
	 * Utilisation de log4j
	 */
	private static Logger logger = Logger.getLogger(model.Operation_bancaire.class);
	
	
	/**
	 * Cette méthode permet l'affichage des formulaires permettant d'effectuer des operations de virements bancaires
	 */

	public void doGet(HttpServletRequest rq, HttpServletResponse rs)
			throws ServletException, IOException  {
				logger.debug("Je suis dans la méthode doGet");
				PrintWriter out = rs.getWriter();
				//Balise HTML et ajout du fichier css
				out.print("<html><head><link rel='stylesheet' href='gestion.css'/>");
				//Affichage du logo ProxiBanque et de la fenetre d'opération
				out.println("<div class='logo'><img src='images/logo.png' alt='logo' title='logo_Proxibanque'><span>ProxiBanque</span></div>");
				//Titre de la page
				out.print("<div class='titre'>Virement");
				out.print("</div>");
				
				
				//Affichage de la fenêtre du virement
				out.print("<div class='fenetrevirement'>");
					//Récupération de l'ID du client				
					String client = rq.getParameter("client");
				//Debut du formulaire pour rentrer les informations du virement par le conseiller
				out.print("<form method='get' name='virement' action='vir'>");
				
				//Récupération des comptes du clients. Cela permet de récupérer les ID des comptes du client.
				try{
					MySQL opeClient = new MySQL();
					String listecompte=null;
					listecompte=opeClient.selectCmptope("select id_compte,type_compte from comptes where client='"+client+"'");
					opeClient.deconnecte();
					//Affichage du choix du compte à débiter. Le titre est dans un tableau dans un but esthetique.
					//out.print("<table><tr title='virement'><td>");
					out.print("<formulaire><br />Compte à débiter :</formulaire>");
					//out.print("</td></tr></table>");
					out.print(listecompte);
										
				}
				catch(Exception e){
						out.println("<h1>Veuillez vérifier les paramètres de votre requete</h1>");
				}
			
			//Affichage du formulaire pour récupérer l'ID du compte bénéficiaire
			out.print("<table><tr title='virement'><td><formulaire>ID du compte du beneficiaire :<br /></formulaire>");	
			out.print("<input type='text' name='beneficiaire' id='id_beneficiaire' value='1908011' required='required'>");
			out.print("</td></tr>");
			//Affichage du formulaire pour récupérer le montant du virement
			out.print("<tr title='virement'><td><formulaire>Montant :<br /></formulaire>");	
			out.print("<input type='text' name='somme' id='id_somme' placeholder='0' required='required'><br />");
			out.print("</td></tr>");
			//Affichage du bouton d'execution du virement. L'ID du client est envoyé dans le formulaire afin de pour voir exécuter plusieurs virement à la suite.					
			out.print("<tr title='virement'><td>");
			out.print("<input type='hidden' name='client' id='id_client' value='"+client+"'>");
			out.print("<input type='submit' name='execute' id='id_execute' value='Executer' required='required' title='executer'>");
			out.print("</form></td></tr></table></div>");	
			
				
			//Affichage du bouton pour retourner à la liste des clients
			out.print("<div class='accueil'><form method='post' name='retour' action='accueil'>");
			out.print("<input type='submit' name='boutonretour' id='id_boutonretour' title='accueil' value='Retour'></form></div>");
			
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