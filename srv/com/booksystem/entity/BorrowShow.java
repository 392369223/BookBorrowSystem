package com.booksystem.entity;

public class BorrowShow {
    private int userid;
    private int bookid;
    private String btime;
    private String rtime;
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public int getBookid() {
		return bookid;
	}
	public void setBookid(int bookid) {
		this.bookid = bookid;
	}
	public String getBtime() {
		return btime;
	}
	public void setBtime(String btime) {
		this.btime = btime;
	}
	public String getRtime() {
		return rtime;
	}
	public void setRtime(String rtime) {
		this.rtime = rtime;
	}
	@Override
	public String toString() {
		return "BorrowShow [userid=" + userid + ", bookid=" + bookid + ", btime=" + btime + ", rtime=" + rtime + "]";
	}
    
}
