package uts.wsd;

import java.util.Date;

public class Article {
	private long id;
	private String title;
	private Date publishedDate;
	private long authorId;
	private String fullText;
	private String categoryTag;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Date getPublishedDate() {
		return publishedDate;
	}
	public void setPublishedDate(Date publishedDate) {
		this.publishedDate = publishedDate;
	}
	public long getAuthorId() {
		return authorId;
	}
	public void setAuthorId(long authorId) {
		this.authorId = authorId;
	}
	public String getFullText() {
		return fullText;
	}
	public void setFullText(String fullText) {
		this.fullText = fullText;
	}
	public String getCategoryTag() {
		return categoryTag;
	}
	public void setCategoryTag(String categoryTag) {
		this.categoryTag = categoryTag;
	}
}
