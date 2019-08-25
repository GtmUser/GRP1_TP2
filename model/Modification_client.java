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
 * Cette classe servlet permet l'affichage et la modification des informations clients
 * 
 */


public class Modification_client extends HttpServlet {
	/**
	 * Utilisation de log4j
	 */
	private static Logger logger = Logger.getLogger(model.Modification_client.class);

	
	/**
	 * Cette m�thode permet l'affichage et la modification des informations clients
	 */
	public void doGet(HttpServletRequest rq, HttpServletResponse rs)
		throws ServletException, IOException  {
			logger.debug("Je suis dans la m�thode doGet");
			PrintWriter out = rs.getWriter();
			//Balise HTML et ajout du fichier css
			out.print("<html><head><link rel='stylesheet' href='gestion.css'/>");
			out.println("<div class='logo'><img src='images/logo.png' alt='logo' title='logo_Proxibanque'><span>ProxiBanque</span></div>");
					
			
			//Modification des informations d'un client.
				//R�cup�ration de l'ID du client
			String client = rq.getParameter("client");
				//R�cup�ration des nouvelles informations d'un client
			String[] val = rq.getParameterValues("info");
			String[] info = {"nom", "prenom", "adresse", "code_postal", "ville", "telephone", "email"};
				//Lors d'une requete pour la modification des informations d'un client, une mise � jour dans la base de donn�e est effectu�e.
			if (val != null){	
					for (int i=0; i<val.length; i++){
					if (val[i] != "" )	{		
						try{
							MySQL modifClient = new MySQL();
							String liste=null;
							liste=modifClient.updateCli("update clients set "+info[i]+"='"+val[i]+"' where id_client='"+client+"';");
							modifClient.deconnecte();
						}
						catch(Exception e){
							out.println("<h1>Veuillez v�rifier les param�tres de votre requete</h1>");
						}
					}
					else if (val[i] == null){
						//out.print("<h1>Une requ�te vide a �t� fournie</h1>");
						
					}
				}
			}
			else if (val == null){
				//out.print("<h1>Aucune requ�te fournie</h1>");
			}		
			
			

			
			//Titre de la page HTML
			out.print("<div class='titre'>Affichage des informations du client");
			out.print("</div>");
			// Affichage des informations du client
			out.print("<div class='fenetremodif'>");
			try{
				MySQL infoClient = new MySQL();
				String liste=null;
				liste=infoClient.selectEdCli("select id_client,nom,prenom,adresse,code_postal,ville,telephone,email from clients where id_client='"+client+"'");
				
				out.print(liste);
				out.print("</div>");	
				infoClient.deconnecte();
			}
			catch(Exception e){
					out.println("<h1>Veuillez v�rifier les param�tres de votre requete</h1>");
			}
			
			
			//Affichage du bouton pour retourner � la liste des clients
			out.print("<div class='accueil'><form method='post' name='retour' action='accueil'>");
			out.print("<input type='submit' name='boutonretour' id='id_boutonretour' title='accueil' value='Retour'></form></div>");
			
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