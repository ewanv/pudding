package uts.wsd.soap.client;

import java.rmi.RemoteException;
import java.util.Scanner;

import javax.xml.rpc.ServiceException;

/**
 * This class provides the interaction with the user for the SOAP service
 * @author Michael Jacobson
 *
 */
public class ArticlesClient {
	
	/**
	 * Communicates with the user through System.out to display commands and receive inputs
	 * @param args
	 * @throws ServiceException
	 * @throws RemoteException
	 */
	public static void main(String[] args) throws ServiceException, RemoteException {
		ArticlesSOAPServiceLocator locator = new ArticlesSOAPServiceLocator();
		ArticlesSOAP articles = locator.getArticlesSOAPPort();
		
		Scanner keyboard = new Scanner(System.in);
		
		// Loop through process until Exit command received
		while (true) {
			// Menu list
			System.out.println("Menu");
			System.out.println("1 - List all articles");
			System.out.println("2 - Delete an article");
			System.out.println("X - Exit");
			System.out.print("Enter a choice: ");
			
			String input = keyboard.next();
			System.out.println();
			
			if (input.equalsIgnoreCase("X")) {
				// Exit chosen by user, break from while loop
				break;
			}
			else if (input.equals("1")){
				// List articles chosen by user
				System.out.println("Listing all articles...");
				for (Article article : articles.fetchArticles()) {
					System.out.println(article.getId() + " - " + article.getTitle());
				}
			}
			else if (input.equals("2")) {
				// Delete article chosen by user
				// Prompt user for which article ID to delete
				System.out.print("Enter article ID to delete: ");
				long articleID = keyboard.nextLong();
				articles.deleteArticle(articleID);
				System.out.println("Deleted article " + articleID);
			}
			else {
				System.out.println("Invalid choice");
			}
			
			System.out.println();
		}
	}
}
