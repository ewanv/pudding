package uts.wsd;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.*;

import java.io.*;
import java.util.ArrayList;

@XmlRootElement(name="articles")
//@XmlAccessorType(XmlAccessorType.FIELD)
public class Articles {
	
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
	
	public void addArticle(Article article) throws JAXBException, FileNotFoundException
	{
		articles.add(article);
		//Store in xml
		JAXBContext jc = JAXBContext.newInstance(Article.class);
		Marshaller m = jc.createMarshaller();
		m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true); //make it pretty
		m.marshal(article, new FileOutputStream("articles.xml"));
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
