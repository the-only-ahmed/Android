package com.example.projecttestsqlite;

public class Subject {

	private int		id;
	private String	pseudo;
	private String	title;
	private	String	content;
	private String	tags;
	
	public int		getID() {return this.id;}
	public String	getPseudo() {return this.pseudo;}
	public String	getTitle() {return this.title;}
	public String	getContent() {return this.content;}
	public String	getTags() {return this.tags;}
	
	public void	setID(int id) {this.id = id;}
	public void setPseudo(String pseudo) {this.pseudo = pseudo;}
	public void setTitle(String title) {this.title = title;}
	public void setContent(String content) {this.content = content;}
	public void	setTags(String tags) {this.tags = tags;}
	
	public Subject() {}
	
	public Subject(String pseudo, String title, String content, String tags)
	{
		this.pseudo = pseudo;
		this.title = title;
		this.content = content;
		this.tags = tags;
		id++;
	}
	
	public String toString()
	{
		return "ID : " + id + "\npseudo : " + pseudo + "\nTitle : " + title + "\n" + content;
	}
}
