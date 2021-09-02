package com.booksystem.entity;

import java.util.Date;

public class HistoryBean {
    private int bookid;
    private Date btime;
    private Date rtime;
    private String state;
	public int getBookid() {
		return bookid;
	}
	public void setBookid(int bookid) {
		this.bookid = bookid;
	}
	public Date getBtime() {
		return btime;
	}
	public void setBtime(Date btime) {
		this.btime = btime;
	}
	public Date getRtime() {
		return rtime;
	}
	public void setRtime(Date rtime) {
		this.rtime = rtime;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	@Override
	public String toString() {
		return "HistoryBean [bookid=" + bookid + ", btime=" + btime + ", rtime=" + rtime + ", state=" + state + "]";
	}
	
}
