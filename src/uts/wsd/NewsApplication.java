package uts.wsd;

public class NewsApplication {
	private Articles articles;
	private Authors authors;
	
	public NewsApplication()
	{
		articles = new Articles();
		authors = new Authors();;
	}
	
	/* For copy/pasting purposes
	 * id, title, publishedDate, authorId, fullText, categoryTag 
	 long id, String title, String publishedDate, long authorId, String fullText, String categoryTag*/
	
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
