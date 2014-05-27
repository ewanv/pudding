package uts.wsd;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

/**
 * News Application object which provides access to the Authors and Articles in the application
 * @author Chris Nguyen
 *
 */
public class NewsApplication {
	private Articles articles;
	private Authors authors;
	private String articlePath;
	private String authorPath;
	
	/**
	 * Set the filepath to the Articles XML file
	 * Will also unmarshall the Articles XML file 
	 * @param path
	 * @throws JAXBException
	 * @throws IOException
	 */
	public void setArticlesFilePath(String path) throws JAXBException, IOException {
		this.articlePath = path;
		//Unmarshalling
		JAXBContext articlesContext = JAXBContext.newInstance(Articles.class);
		Unmarshaller articlesUnmarshaller = articlesContext.createUnmarshaller();
		FileInputStream fin = new FileInputStream(path); // use the given file path
		articles = (Articles)articlesUnmarshaller.unmarshal(fin); // This loads the "users" object
		fin.close();
	}
	
	/**
	 * Set the filepath to the Authors XML file
	 * Will also unmarshall the Authors XML file
	 * @param path
	 * @throws JAXBException
	 * @throws IOException
	 */
	public void setAuthorsFilePath(String path) throws JAXBException, IOException {
		this.authorPath = path;
		//Unmarshalling
		JAXBContext authorsContext = JAXBContext.newInstance(Authors.class);
		Unmarshaller authorsUnmarshaller = authorsContext.createUnmarshaller();
		FileInputStream fin = new FileInputStream(path); // use the given file path
		authors = (Authors)authorsUnmarshaller.unmarshal(fin); // This loads the "users" object
		fin.close();
	}

	/**
	 * Get the Articles object
	 * @return
	 */
	public Articles getArticles() {
		return articles;	
	}

	/**
	 * Set the Articles object
	 * Will also marshall the new Articles object into XML
	 * @param articles
	 * @throws JAXBException
	 * @throws FileNotFoundException
	 */
	public void setArticles(Articles articles) throws JAXBException, FileNotFoundException {
		this.articles = articles;
		//Marshalling
		JAXBContext jc = JAXBContext.newInstance(Articles.class);
		Marshaller m = jc.createMarshaller();
		m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true); 
		m.marshal(articles, new FileOutputStream(articlePath));
	}

	/**
	 * Get the Authors object
	 * @return
	 */
	public Authors getAuthors() {
		return authors;
	}

	/**
	 * Set the Authors object
	 * Will also marshall the new Authors object into XML
	 * @param authors
	 * @throws JAXBException
	 * @throws FileNotFoundException
	 */
	public void setAuthors(Authors authors) throws JAXBException, FileNotFoundException {
		this.authors = authors;
		//Marshalling
		JAXBContext jc = JAXBContext.newInstance(Authors.class);
		Marshaller m = jc.createMarshaller();
		m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		m.marshal(authors, new FileOutputStream(authorPath));
	}

}
