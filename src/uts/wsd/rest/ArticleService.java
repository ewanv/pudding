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

@Path("/articles")
public class ArticleService {
	@Context
	private ServletContext application;

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

	@Path("search")
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public Articles filterArticles(@QueryParam("category") String category,
			@QueryParam("startDate") String startDate,
			@QueryParam("endDate") String endDate) throws JAXBException,
			IOException {
		// Return all articles if no parameters are given
		if (category == null && startDate == null && endDate == null) {
			return getNewsApp().getArticles();
		}

		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		Date firstDate = null;
		Date lastDate = null;

		try {
			if (startDate != null) {
				firstDate = formatter.parse(startDate);
			}
		} catch (ParseException e) {
			firstDate = null;
			e.printStackTrace();
		}
		
		try {
			if (endDate != null) {
				lastDate = formatter.parse(endDate);
			}
		} catch (ParseException e) {
			lastDate = null;
			e.printStackTrace();
		}
		
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
