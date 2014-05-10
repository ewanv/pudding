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

@WebService
public class ArticlesSOAP {

	@Resource
	private WebServiceContext context;
	
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
	
	@WebMethod
	public void deleteArticle(long articleID) {
		try {
			Articles a = getNewsApp().getArticles();
			a.removeArticle(articleID);
			getNewsApp().setArticles(a);
		} catch (JAXBException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
