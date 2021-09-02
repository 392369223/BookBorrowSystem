package com.booksystem.entity;

public class Book {
 private int book_id;
 private String book_name;
 private String author;
 private String sex;
 private double price;
 private String book_desc;
 private int book_typeid;
 private int isFlag;
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
public String getBook_desc() {
	return book_desc;
}
public void setBook_desc(String book_desc) {
	this.book_desc = book_desc;
}
public int getBook_typeid() {
	return book_typeid;
}
public void setBook_typeid(int book_typeid) {
	this.book_typeid = book_typeid;
}
public int getIsFlag() {
	return isFlag;
}
public void setIsFlag(int isFlag) {
	this.isFlag = isFlag;
}
 
}
