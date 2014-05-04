package uts.wsd;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.bind.annotation.*;

@XmlRootElement(name="article")
//@XmlAccessorType(XmlAccessorType.FIELD)
public class Article {
	
	
	public Article()
	{
		
	}
	
	public Article(long id, String title, String publishedDate, long authorId, String fullText, String categoryTag) throws ParseException
	{
		this.id = id;
		this.title = title;
		this.publishedDate = new SimpleDateFormat("dd MM yyyy").parse(publishedDate);
		this.authorId = authorId;
		this.fullText = fullText;
		this.categoryTag = categoryTag;
	}
	
	//============Properties=====================================
	
	@XmlElement(name="id")
	private long id;
	
	@XmlElement(name="title")
	private String title;
	
	@XmlElement(name="publishedDate")
	private Date publishedDate;
	
	@XmlElement(name="authorId")
	private long authorId;
	
	@XmlElement(name="fullText")
	private String fullText;
	
	@XmlElement(name="categoryTag")
	private String categoryTag;
	
	
	//=========Getters and Setters================================
	
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
	
	//==========Other methods================================
	
	public String toString()
	{
		return this.title;
	}
	
}
