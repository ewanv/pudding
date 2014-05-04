package uts.wsd;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class NewsApplication {
	private Articles articles;
	private Authors authors;

	public NewsApplication() throws FileNotFoundException, JAXBException {
		articles = new Articles();
		JAXBContext articlesContext = JAXBContext.newInstance(Articles.class);
		Unmarshaller articlesUnmarshaller = articlesContext.createUnmarshaller();
		articles = (Articles) articlesUnmarshaller.unmarshal(new FileInputStream("articles.xml"));
		
		authors = new Authors();
		JAXBContext authorsContext= JAXBContext.newInstance(Authors.class);
		Unmarshaller authorsUnmarshaller = authorsContext.createUnmarshaller();
		authors = (Authors) authorsUnmarshaller.unmarshal(new FileInputStream("authors.xml"));
	}
	
	public static void main(String[] args) throws FileNotFoundException, JAXBException
	{
	}

	/*
	 * For copy/pasting purposes id, title, publishedDate, authorId, fullText,
	 * categoryTag long id, String title, String publishedDate, long authorId,
	 * String fullText, String categoryTag
	 */

	public Articles getArticles() {
		return articles;
	}

	public void setArticles(Articles articles) {
		this.articles = articles;
	}

	public Authors getAuthors() {
		return authors;
	}

	public void setAuthors(Authors authors) {
		this.authors = authors;
	}

}
