package uts.wsd.soap.client;

import java.rmi.RemoteException;
import java.util.Scanner;

import javax.xml.rpc.ServiceException;

public class ArticlesClient {
	
	public static void main(String[] args) throws ServiceException, RemoteException {
		ArticlesSOAPServiceLocator locator = new ArticlesSOAPServiceLocator();
		ArticlesSOAP articles = locator.getArticlesSOAPPort();
		
		Scanner keyboard = new Scanner(System.in);
		
		while (true) {
			System.out.println("1 - List all articles");
			System.out.println("2 - Delete an article");
			System.out.println("X - Exit");
			System.out.print("Enter a choice: ");
			
			String input = keyboard.next();
			
			if (input.equalsIgnoreCase("X")) {
				break;
			}
			else if (input.equals("1")){
				for (Article article : articles.fetchArticles()) {
					System.out.println(article.getId() + " - " + article.getTitle());
				}
			}
			else if (input.equals("2")) {
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
