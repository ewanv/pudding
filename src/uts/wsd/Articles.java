package uts.wsd;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.*;

import java.io.*;
import java.util.ArrayList;

@XmlRootElement(name="articles", namespace="http://www.uts.edu.au/31284/wsd-diary")
@XmlAccessorType(XmlAccessType.FIELD)
public class Articles implements Serializable {
	
	@XmlElement(name="article")
	private ArrayList<Article> articles = new ArrayList<Article>();

	public ArrayList<Article> getArticles() {
		return articles;
	}

	public void setArticles(ArrayList<Article> articles) {
		this.articles = articles;
	}
	
	public Article findArticle(long id) {
		for(Article article: articles) {
			if(article.getId() == id) {
				return article;
			}
		}
		return null;
	}
	
	public ArrayList<Article> findArticlesWrittenByAuthor(Author author) {
		ArrayList<Article> articles = new ArrayList<Article>();
		for(Article article: this.articles) {
			if(article.getAuthorId() == author.getId()) {
				articles.add(article);
			}
		}
		return articles;
	}
	
	public void addArticle(Article article) throws JAXBException, FileNotFoundException
	{
		articles.add(article);
	}
	
	public void removeArticle(long id)
	{
		articles.remove(findArticle(id));
	}
	
	public void removeArticle(Article article)
	{
		articles.remove(article);
	}
	
	public void printArticles()
	{
		for (Article a : articles)
		{
			System.out.println(a);
		}
	}
	
	
}
