package uts.wsd;

import java.util.ArrayList;

public class Authors {
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
}
