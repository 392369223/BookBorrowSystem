package com.booksystem.entity;

import java.util.Date;

public class Report {
    private int reportid;
    private int userid;
    private int buserid;
    private String reason;
    private Date mytime;
	public int getReportid() {
		return reportid;
	}
	public void setReportid(int reportid) {
		this.reportid = reportid;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public int getBuserid() {
		return buserid;
	}
	public void setBuserid(int buserid) {
		this.buserid = buserid;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public Date getMytime() {
		return mytime;
	}
	public void setMytime(Date mytime) {
		this.mytime = mytime;
	}
	@Override
	public String toString() {
		return "Report [reportid=" + reportid + ", userid=" + userid + ", buserid=" + buserid + ", reason=" + reason
				+ ", mytime=" + mytime + "]";
	}
	
}
