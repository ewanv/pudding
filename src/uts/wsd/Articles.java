package uts.wsd;

import java.util.ArrayList;

public class Articles {
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
