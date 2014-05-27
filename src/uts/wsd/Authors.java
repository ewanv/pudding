package uts.wsd;

import java.io.FileNotFoundException;
import java.io.Serializable;
import java.util.ArrayList;

import javax.xml.bind.JAXBException;
import javax.xml.bind.annotation.*;

/**
 * 
 * Java bean for a collection of authors.
 * Handles the adding, removal and searching of authors.
 * @author Chris Nguyen
 */
@XmlRootElement(name="authors", namespace="http://www.uts.edu.au/31284/wsd-diary")
@XmlAccessorType(XmlAccessType.FIELD)
public class Authors implements Serializable {
	
	@XmlElement(name="author")
	private ArrayList<Author> authors = new ArrayList<Author>();

	/**
	 * Get a list of all Author beans
	 * @return
	 */
	public ArrayList<Author> getAuthors() {
		return authors;
	}

	/**
	 * Set the list of all Author beans
	 * @param authors
	 */
	public void setAuthors(ArrayList<Author> authors) {
		this.authors = authors;
	}
	
	/**
	 * Login function to check username and password combination
	 * @param username
	 * @param password
	 * @return
	 */
	public Author login(String username, String password) {
		for(Author author: authors) {
			if(author.getUsername().equals(username) && author.getPassword().equals(password)) {
				return author;
			}
		}
		return null;
	}
	
	/**
	 * Find an Author by username
	 * @param username
	 * @return
	 */
	public Author findAuthor(String username) {
		for(Author author: authors) {
			if(author.getUsername().equals(username)) {
				return author;
			}
		}
		return null;
	}
	
	/**
	 * Find an Author by ID
	 * @param id
	 * @return
	 */
	public Author findAuthor(long id) {
		for(Author author:authors) {
			if(author.getId() == id) {
				return author;
			}
		}
		return null;
	}
	
	/**
	 * Get the highest ID of all Author beans
	 * @return
	 */
	private long highestId() {
		long highestId = 0;
		for(Author author: authors) {
			if(author.getId() > highestId) {
				highestId = author.getId();
			}
		}
		return highestId;
	}
	
	/**
	 * Add an Author to the list
	 * @param author
	 * @throws JAXBException
	 * @throws FileNotFoundException
	 */
	public void addAuthor(Author author) throws JAXBException, FileNotFoundException
	{
		author.setId(highestId() + 1);
		authors.add(author);
	}
	
	/**
	 * Remove an Author from the list identified by an Author bean
	 * @param author
	 */
	public void removeAuthor(Author author)
	{
		authors.remove(author);
	}
	
	/**
	 * Remove an Author from the list identified by username
	 * @param username
	 */
	public void removeAuthoer(String username)
	{
		authors.remove(findAuthor(username));
	}
}
