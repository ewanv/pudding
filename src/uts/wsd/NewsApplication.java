package uts.wsd;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class NewsApplication {
	private Articles articles;
	private Authors authors;
	private String path;
	
	public void setArticlesFilePath(String path) throws JAXBException, IOException {
		this.path = path;
		//Unmarshalling
		JAXBContext articlesContext = JAXBContext.newInstance(Articles.class);
		Unmarshaller articlesUnmarshaller = articlesContext.createUnmarshaller();
		FileInputStream fin = new FileInputStream(path); // use the given file path
		articles = (Articles)articlesUnmarshaller.unmarshal(fin); // This loads the "users" object
		fin.close();
	}
	
	public void setAuthorsFilePath(String path) throws JAXBException, IOException {
		this.path = path;
		//Unmarshalling
		JAXBContext authorsContext = JAXBContext.newInstance(Articles.class);
		Unmarshaller authorsUnmarshaller = authorsContext.createUnmarshaller();
		FileInputStream fin = new FileInputStream(path); // use the given file path
		authors = (Authors)authorsUnmarshaller.unmarshal(fin); // This loads the "users" object
		fin.close();
	}

	/*
	 * For copy/pasting purposes id, title, publishedDate, authorId, fullText,
	 * categoryTag long id, String title, String publishedDate, long authorId,
	 * String fullText, String categoryTag
	 */

	public Articles getArticles() {
		return articles;
		
	}

	public void setArticles(Articles articles) throws JAXBException, FileNotFoundException {
		this.articles = articles;
		//Marshalling
		JAXBContext jc = JAXBContext.newInstance(Article.class);
		Marshaller m = jc.createMarshaller();
		m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		m.marshal(articles, new FileOutputStream("articles.xml"));
	}

	public Authors getAuthors() {
		return authors;
	}

	public void setAuthors(Authors authors) throws JAXBException, FileNotFoundException {
		this.authors = authors;
		//Marshalling
		JAXBContext jc = JAXBContext.newInstance(Authors.class);
		Marshaller m = jc.createMarshaller();
		m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		m.marshal(authors, new FileOutputStream("authors.xml"));
	}

}
