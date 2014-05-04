package uts.wsd;
import javax.xml.bind.annotation.*;

import java.util.ArrayList;

@XmlRootElement(name="articles")
@XmlAccessorType(XmlAccessorType.FIELD)
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
}
