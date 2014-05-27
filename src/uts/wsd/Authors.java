package uts.wsd;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.*;

/**
 * 
 * Java bean for a collection of authors.
 * Handles the adding, removal and searching of authors.
 */

@XmlRootElement(name="authors", namespace="http://www.uts.edu.au/31284/wsd-diary")
@XmlAccessorType(XmlAccessType.FIELD)
public class Authors implements Serializable {
	
	@XmlElement(name="author")
	private ArrayList<Author> authors = new ArrayList<Author>();

	public ArrayList<Author> getAuthors() {
		return authors;
	}

	public void setAuthors(ArrayList<Author> authors) {
		this.authors = authors;
	}
	
	public Author login(String username, String password) {
		for(Author author: authors) {
			if(author.getUsername().equals(username) && author.getPassword().equals(password)) {
				return author;
			}
		}
		return null;
	}
	
	public Author findAuthor(String username) {
		for(Author author: authors) {
			if(author.getUsername().equals(username)) {
				return author;
			}
		}
		return null;
	}
	
	public Author findAuthor(long id) {
		for(Author author:authors) {
			if(author.getId() == id) {
				return author;
			}
		}
		return null;
	}
	
	private long highestId() {
		long highestId = 0;
		for(Author author: authors) {
			if(author.getId() > highestId) {
				highestId = author.getId();
			}
		}
		return highestId;
	}
	
	public void addAuthor(Author author) throws JAXBException, FileNotFoundException
	{
		author.setId(highestId() + 1);
		authors.add(author);
	}
	
	public void removeAuthor(Author author)
	{
		authors.remove(author);
	}
	
	public void removeAuthoer(String username)
	{
		authors.remove(findAuthor(username));
	}
}
