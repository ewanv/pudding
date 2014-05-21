package uts.wsd.rest;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletContext;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import javax.xml.bind.JAXBException;

import uts.wsd.*;

/**
 * This class provides the REST service functionality for searching articles
 * @author Michael Jacobson
 */
@Path("/articles")
public class ArticleService {
	
	/**
	 * Current application instance
	 */
	@Context
	private ServletContext application;

	/** 
	 * This method will retrieve the news application from the current application instance
	 * @return Current NewsApplication object to use to access data
	 * @throws JAXBException
	 * @throws IOException
	 */
	private NewsApplication getNewsApp() throws JAXBException, IOException {
		synchronized (application) {
			NewsApplication newsApp = (NewsApplication) application
					.getAttribute("newsApp");
			if (newsApp == null) {
				newsApp = new NewsApplication();
				newsApp.setArticlesFilePath(application
						.getRealPath("WEB-INF/articles.xml"));
				newsApp.setAuthorsFilePath(application
						.getRealPath("WEB-INF/authors.xml"));
				application.setAttribute("newsApp", newsApp);
			}
			return newsApp;
		}
	}

	/**
	 * This method will filter all articles in the news application and return those matching the criteria
	 * @param category
	 * @param startDate
	 * @param endDate
	 * @return XML containing the articles matching the specified criteria
	 * @throws JAXBException
	 * @throws IOException
	 */
	@Path("search")
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public Articles filterArticles(@QueryParam("category") String category,
			@QueryParam("startDate") String startDate,
			@QueryParam("endDate") String endDate) throws JAXBException,
			IOException {
		
		if (category == null && startDate == null && endDate == null) {
			// Return all articles if no parameters are given
			return getNewsApp().getArticles();
		}

		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		Date firstDate = null;
		Date lastDate = null;

		try {
			if (startDate != null) {
				// Parse startDate to create a date object
				firstDate = formatter.parse(startDate);
			}
		} catch (ParseException e) {
			// If the date cannot be parsed then set it to null
			firstDate = null;
			e.printStackTrace();
		}
		
		try {
			if (endDate != null) {
				// Parse endDate to create date object
				lastDate = formatter.parse(endDate);
			}
		} catch (ParseException e) {
			// If the date object cannot be parsed then set it to null
			lastDate = null;
			e.printStackTrace();
		}
		
		// Create a list of all articles matching the criteria
		Articles filteredArticles = new Articles();
		
		for (Article article : getNewsApp().getArticles().getArticles()) {
			if ((category == null || article.getCategoryTag().toUpperCase().equals(category.toUpperCase())) &&
					(firstDate == null || article.getPublishedDate().equals(firstDate) || article.getPublishedDate().after(firstDate)) &&
					(lastDate == null || article.getPublishedDate().equals(lastDate) || article.getPublishedDate().before(lastDate))) {
				filteredArticles.addArticle(article);
			}
		}

		return filteredArticles;
	}
}
