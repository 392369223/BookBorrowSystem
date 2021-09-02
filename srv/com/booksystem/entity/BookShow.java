package com.booksystem.entity;

public class BookShow {
	 private int book_id;
	 private String book_name;
	 private String author;
	 private String sex;
	 private double price;
	 private String book_type;
	public int getBook_id() {
		return book_id;
	}
	public void setBook_id(int book_id) {
		this.book_id = book_id;
	}
	public String getBook_name() {
		return book_name;
	}
	public void setBook_name(String book_name) {
		this.book_name = book_name;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getBook_type() {
		return book_type;
	}
	public void setBook_type(String book_type) {
		this.book_type = book_type;
	}
	@Override
	public String toString() {
		return "BookShow [book_id=" + book_id + ", book_name=" + book_name + ", author=" + author + ", sex=" + sex
				+ ", price=" + price + ", book_type=" + book_type + "]";
	}
	 
}
