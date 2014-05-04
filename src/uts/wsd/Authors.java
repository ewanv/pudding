package uts.wsd;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.*;

@XmlRootElement(name="authors")
public class Authors {
	
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
	
	public void addAuthor(Author author) throws JAXBException, FileNotFoundException
	{
		authors.add(author);
		JAXBContext jc = JAXBContext.newInstance(Authors.class);
		Marshaller m = jc.createMarshaller();
		m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		m.marshal(author, new FileOutputStream("authors.xml"));
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
