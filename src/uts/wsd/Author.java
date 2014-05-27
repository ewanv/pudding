package uts.wsd;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;

import javax.xml.bind.annotation.*;

/**
 * 
 * Java bean for authors.
 * Used for data transfer.
 */

@XmlRootElement(name="author")
@XmlAccessorType(XmlAccessType.FIELD)
public class Author implements Serializable {
	
	//========Properties===============
	
	private long id;
	
	private Date dateOfBirth;
	
	private String bio;
	
	private String name;
	
	private String username;
	
	private String password;
	
	//=======Getters and Setters=========
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getBio() {
		return bio;
	}
	public void setBio(String bio) {
		this.bio = bio;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	//=========Other methods============

	public boolean isValid() {
		if(name == null || name.equals("")) {
			return false;
		}
		if(bio == null || bio.equals("")) {
			return false;
		}
		if(dateOfBirth == null) {
			return false;
		}
		if(username == null || username.equals("")) {
			return false;
		}
		if(password== null || password.equals("")) {
			return false;
		}
		return true;
	}
	
	//Error messages
	public HashMap<String,String> errors() {
		HashMap<String,String> errors = new HashMap<String, String>();
		if(name == null || name.equals("")) {
			errors.put("name","Name cannot be blank.");
		}
		if(bio == null || bio.equals("")) {
			errors.put("bio","Biography cannot be blank.");
		}
		if(dateOfBirth== null) {
			errors.put("dateOfBirth","Date of Birth cannot be blank.");
		}
		if(username== null || username.equals("")) {
			errors.put("username","Username cannot be blank.");
		}
		if(password == null) {
			errors.put("password","Password cannot be blank.");
		}
		return errors;
	}
}
