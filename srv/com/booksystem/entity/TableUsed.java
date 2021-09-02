package com.booksystem.entity;

import java.util.Date;

public class TableUsed{    
    private Date btime;
    private Date returntime;
    private int book_id;
    private String book_name;
    private String author;
    
    public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	//用表的合并获得想要的信息    
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
	public Date getBtime() {
		return btime;
	}
	public void setBtime(Date btime) {
		this.btime = btime;
	}
	public Date getReturntime() {
		return returntime;
	}
	public void setReturntime(Date returntime) {
		this.returntime = returntime;
	}
	@Override
	public String toString() {
		return "TableUsed [btime=" + btime + ", returntime=" + returntime + ", book_id=" + book_id + ", book_name="
				+ book_name + ", author=" + author + "]";
	}
      
}
