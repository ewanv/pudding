package uts.wsd.soap;

import java.io.IOException;

import javax.annotation.Resource;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.servlet.ServletContext;
import javax.xml.bind.JAXBException;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;

import uts.wsd.Articles;
import uts.wsd.NewsApplication;

/**
 * This class is defines the functionality of the SOAP service
 * @author Michael Jacobson
 *
 */
@WebService
public class ArticlesSOAP {

	/**
	 * Current application context
	 */
	@Resource
	private WebServiceContext context;
	
	/**
	 * This method will retrieve the news application from the current application context
	 * @return Current NewsApplication object to use to access data
	 * @throws JAXBException
	 * @throws IOException
	 */
	private NewsApplication getNewsApp() throws JAXBException, IOException {
		ServletContext application = (ServletContext)context.getMessageContext().get(MessageContext.SERVLET_CONTEXT);
		
		synchronized (application) {
			NewsApplication newsApp = (NewsApplication) application
					.getAttribute("newsApp");
			if (newsApp == null) {
				newsApp = new NewsApplication();
				newsApp.setAuthorsFilePath(application
						.getRealPath("WEB-INF/authors.xml"));
				newsApp.setArticlesFilePath(application
						.getRealPath("WEB-INF/articles.xml"));
				application.setAttribute("newsApp", newsApp);
			}
			return newsApp;
		}
	}
	
	/**
	 * Retrieves a list of the current articles from the news application
	 * @return An articles object containing a list of all articles
	 */
	@WebMethod
	public Articles fetchArticles() {
		Articles articles = null;
		
		try {
			articles = getNewsApp().getArticles();
		} catch (JAXBException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return articles;
	}
	
	/** 
	 * Delete the article with the given ID from the news application
	 * @param articleID The ID of the article to delete
	 */
	@WebMethod
	public void deleteArticle(long articleID) {
		try {
			Articles a = getNewsApp().getArticles();
			a.removeArticle(articleID);
			getNewsApp().setArticles(a); // Set the articles in the news app to correctly marshall
		} catch (JAXBException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
