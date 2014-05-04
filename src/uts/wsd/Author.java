package uts.wsd;

import java.util.Date;

import javax.xml.bind.annotation.*;

@XmlRootElement(name="author")
public class Author {
	
	//========Properties===============
	
	@XmlElement(name="id")
	private long id;
	
	@XmlElement(name="dateOfBirth")
	private Date dateOfBirth;
	
	@XmlElement(name="bio")
	private String bio;
	
	@XmlElement(name="name")
	private String name;
	
	@XmlElement(name="username")
	private String username;
	
	@XmlElement(name="password")
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
}
