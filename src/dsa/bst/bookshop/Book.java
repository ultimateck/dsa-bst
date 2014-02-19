package dsa.bst.bookshop;

public class Book {
	String title;
	String firstName;
	String surName;
	int isbn;
	String category;
	
	/* CONSTRUCTORS */
	public Book(){				// Default Constructor
		this.title = "";
		this.firstName = "";
		this.surName = "";
		this.isbn = 0;
		this.category = "";
	
	}
	
	public Book(String title, String author,String surname,int isbn){ // Parameterised Constructor
		this.title = title;
		this.firstName = author;
		this.surName = surname;
		this.isbn = isbn;
		this.category = "";
	}
	
	public Book(String title, String author,String surname,int isbn, String category){ // Parameterised Constructor
		this.title = title;
		this.firstName = author;
		this.surName = surname;
		this.isbn = isbn;
		this.category = category;
	}
	
	/* GETTERS */
	public String getTitle() {
		return title;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getSurName() {
		return surName;
	}

	public int getIsbn() {
		return isbn;
	}
	
	public String getCategory() {
		return category;
	}

	/* SETTERS */
	public void setTitle(String title) {
		this.title = title;
	}

	public void setFirstName(String authorName) {
		this.firstName = authorName;
	}

	public void setSurName(String surName) {
		this.surName = surName;
	}

	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}
	
	public void setCategory(String category) {
		this.category = category;
	}
	
	/* PUBLIC METHODS */
	public String authorName(){
		return firstName +  " " + surName ;
	}

	@Override
	public String toString() {
		return "Book [title=" + title + ", isbn=" + isbn + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((category == null) ? 0 : category.hashCode());
		result = prime * result
				+ ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + isbn;
		result = prime * result + ((surName == null) ? 0 : surName.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		if (category == null) {
			if (other.category != null)
				return false;
		} else if (!category.equals(other.category))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (isbn != other.isbn)
			return false;
		if (surName == null) {
			if (other.surName != null)
				return false;
		} else if (!surName.equals(other.surName))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}

	
	

}
