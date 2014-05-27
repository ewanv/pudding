package uts.wsd;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.xml.bind.annotation.*;

/**
 *
 * Java bean for articles.
 * Used for data transfer.
 * @author Chris Nguyen
 *
 */
@XmlRootElement(name="article")
@XmlAccessorType(XmlAccessType.FIELD)
public class Article implements Serializable {
	
	/**
	 * Blank constructor as required for Java bean
	 */
	public Article()
	{
		
	}
	
	/**
	 * Overloaded constructor that will set all fields
	 * @param id
	 * @param title
	 * @param publishedDate
	 * @param authorId
	 * @param fullText
	 * @param categoryTag
	 * @param authorOnly
	 * @throws ParseException
	 */
	public Article(long id, String title, String publishedDate, long authorId, String fullText, String categoryTag, boolean authorOnly) throws ParseException
	{
		this.id = id;
		this.title = title;
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		this.publishedDate = formatter.parse(publishedDate);
		this.authorId = authorId;
		this.fullText = fullText;
		this.categoryTag = categoryTag;
		this.setAuthorOnly(authorOnly);
	}
	
	//============Properties=====================================
	
	private long id;
	
	private String title;
	
	@XmlElement(name = "publishedDate")
    @XmlSchemaType(name = "date")
	private Date publishedDate;
	
	private long authorId;
	
	private String fullText;
	
	private String categoryTag;
	
	private boolean authorOnly;
	
	
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
	
	public void setPublishedDate(String publishedDateString) throws ParseException {
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		this.publishedDate = formatter.parse(publishedDateString);
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
	
	public boolean isAuthorOnly() {
		return authorOnly;
	}

	public void setAuthorOnly(boolean authorOnly) {
		this.authorOnly = authorOnly;
	}

	//==========Other methods================================
	
	public String toString()
	{
		return this.title;
	}
	
	/**
	 * Validate this article to ensure it contains all required elements
	 * @return
	 */
	public boolean isValid() {
		if(title == null || title.equals("")) {
			return false;
		}
		if(fullText == null || fullText.equals("")) {
			return false;
		}
		if(categoryTag == null || categoryTag.equals("")) {
			return false;
		}
		return true;
	}
	
	
	/**
	 * Error messages for an Article
	 * @return
	 */
	public HashMap<String,String> errors() {
		HashMap<String,String> errors = new HashMap<String, String>();
		if(title == null || title.equals("")) {
			errors.put("title","Title cannot be blank.");
		}
		if(fullText == null || fullText.equals("")) {
			errors.put("fullText","Full Text cannot be blank.");
		}
		if(categoryTag == null || categoryTag.equals("")) {
			errors.put("categoryTag","Category cannot be blank.");
		}
		return errors;
	}
	
}
