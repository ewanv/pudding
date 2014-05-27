package uts.wsd;
import javax.xml.bind.JAXBException;
import javax.xml.bind.annotation.*;

import java.io.*;
import java.util.ArrayList;
import java.util.Calendar;

/**
 * 
 * Java bean for collection of Articles. 
 * Handles the adding, removal and searching of articles.
 * @author Chris Nguyen
 */
@XmlRootElement(name="articles", namespace="http://www.uts.edu.au/31284/wsd-diary")
@XmlAccessorType(XmlAccessType.FIELD)
public class Articles implements Serializable {
	
	@XmlElement(name="article")
	private ArrayList<Article> articles = new ArrayList<Article>();

	/**
	 * Get a list of all Article beans
	 * @return
	 */
	public ArrayList<Article> getArticles() {
		return articles;
	}

	/**
	 * Set the list of Article beans
	 * @param articles
	 */
	public void setArticles(ArrayList<Article> articles) {
		this.articles = articles;
	}
	
	/**
	 * Find and return an Article by its ID
	 * @param id
	 * @return
	 */
	public Article findArticle(long id) {
		for(Article article: articles) {
			if(article.getId() == id) {
				return article;
			}
		}
		return null;
	}
	
	/**
	 * Get a list of all Article beans written by a particular Author
	 * @param author
	 * @return
	 */
	public ArrayList<Article> findArticlesWrittenByAuthor(Author author) {
		ArrayList<Article> articles = new ArrayList<Article>();
		for(Article article: this.articles) {
			if(article.getAuthorId() == author.getId()) {
				articles.add(article);
			}
		}
		return articles;
	}
	
	/**
	 * Find the highest ID of all Article beans
	 * @return
	 */
	private long highestId() {
		long highestId = 0;
		for(Article article: articles) {
			if(article.getId() > highestId) {
				highestId = article.getId();
			}
		}
		return highestId;
	}
	
	/**
	 * Add a new Article to the list of Articles
	 * @param article
	 * @throws JAXBException
	 * @throws FileNotFoundException
	 */
	public void addArticle(Article article) throws JAXBException, FileNotFoundException
	{
		article.setId(highestId() + 1);
		article.setPublishedDate(Calendar.getInstance().getTime());
		articles.add(article);
	}
	
	/**
	 * Remove an Article from the list of Articles identified by its ID
	 * @param id
	 */
	public void removeArticle(long id)
	{
		articles.remove(findArticle(id));
	}
	
	/**
	 * Remove an Article from the list of Articles identified by an Article object
	 * @param article
	 */
	public void removeArticle(Article article)
	{
		articles.remove(article);
	}
	
}
