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
 * Cette classe servlet permet l'affichage de la confirmation d'un virement compte � compte
 * 
 */


public class Confirmation_virement extends HttpServlet {
	/**
	 * Utilisation de log4j
	 */
	private static Logger logger = Logger.getLogger(model.Confirmation_virement.class);

	
	/**
	 * Cette m�thode permet l'affichage de la confirmation d'un virement compte � compte
	*/
	public void doGet(HttpServletRequest rq, HttpServletResponse rs)
			throws ServletException, IOException  {
				logger.debug("Je suis dans la m�thode doGet");
				PrintWriter out = rs.getWriter();
				//Balise HTML et ajout du fichier css
				out.print("<html><head><link rel='stylesheet' href='gestion.css'/>");
				//Affichage du logo ProxiBanque
				out.println("<div class='logo'><img src='images/logo.png' alt='logo' title='logo_Proxibanque'><span>ProxiBanque</span></div>");
	
				//R�cup�ration des donn�es n�cessaires au virement				
				String login = rq.getUserPrincipal().getName();	
				String id_compte_emet = rq.getParameter("selectcmpt");
				String id_compte_benef = rq.getParameter("beneficiaire");
				String somme = rq.getParameter("somme");
	

				//Insert dans la table operation_bancaires des informations du virement
				try{
					MySQL operationbancaire = new MySQL();
					//Virement de l'emetteur
					String virementemet=null;
					//Virement du b�n�ficiaire
					String virementbenef=null;
					//Commandes SQL pour r�aliser les INSERT
					virementemet=operationbancaire.insert("INSERT INTO operation_bancaires (type_operation,montant_operation,compte,conseiller) VALUES ('virement sortant','-"+somme+"','"+id_compte_emet+"','"+login+"');");
					virementbenef=operationbancaire.insert("INSERT INTO operation_bancaires (type_operation,montant_operation,compte,conseiller) VALUES ('virement entrant','"+somme+"','"+id_compte_benef+"','"+login+"');");
					operationbancaire.deconnecte();
					
				}
				catch(Exception e){
					out.println("<h1>Veuillez v�rifier les param�tres de votre requete</h1>");
				}
				
				
				//Affichage du r�sultat du virement
				try{
					MySQL affichageoperation = new MySQL();
					String affichage_vir=null;
					affichage_vir=affichageoperation.selectvir("SELECT * FROM operation_bancaires ORDER BY id_operation_bancaire DESC LIMIT 2;");
					//Affichage du titre de la page
					out.print("<div class='titre'>Virement effectu�");
					out.print("</div>");
					//Affichage du tableau r�capitulatif du virement
					out.print("<div class='fenetreconfirvir'>");
					out.print(affichage_vir);
					out.print("</div>");
					affichageoperation.deconnecte();
					
				}
				catch(Exception e){
					out.println("<h1>Veuillez v�rifier les param�tres de votre requete</h1>");
				}
				
				//Affichage du bouton pour retourner � la liste des clients
				out.print("<div class='accueil'><form method='post' name='retour' action='accueil'>");
				out.print("<input type='submit' name='boutonretour' id='id_boutonretour' title='accueil' value='Retour'></form></div>");
				out.print("</body></html>");
				
				//Affichage du bouton pour faire un autre virement
				out.print("<div class='autrevirement'><form method='post' name='autrevir' action='ope'>");
					//R�cup�ration de l'ID du client
				String id_client = rq.getParameter("client");
				out.print("<input type='hidden' name='client' id='id_client' value='"+id_client+"'>");
				out.print("<input type='submit' name='boutonautvir' id='id_boutonautvir' title='boutonautvir' value='Autre virement'>");
				out.print("</form></div>");
				
				//fin de balise HTML
				out.print("</body></html>");
				
	}
	
	
	/**
	 *   Renvoi � la m�thode doGet
	 */
		public void doPost(HttpServletRequest rq, HttpServletResponse rs)
				throws ServletException, IOException  {
					doGet(rq,rs);		
				}
				
				

			
	}
