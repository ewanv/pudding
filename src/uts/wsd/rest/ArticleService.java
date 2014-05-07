package uts.wsd.rest;

import java.io.IOException;

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
			NewsApplication newsApp = (NewsApplication) application.getAttribute("newsApp");
			if (newsApp == null) {
				newsApp = new NewsApplication();
				newsApp.setArticlesFilePath(application.getRealPath("WEB-INF/articles.xml"));
				newsApp.setAuthorsFilePath(application.getRealPath("WEB-INF/authors.xml"));
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
			@QueryParam("endDate") String endDate) throws JAXBException, IOException {
		return getNewsApp().getArticles();
	}
}
