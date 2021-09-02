package com.booksystem.entity;

import java.util.Date;

public class Comment {
    private int commentId;
    private int commentUserid;
    private int commentBookid;
    private String commentContent;
    private Date commentTime;
	public int getCommentId() {
		return commentId;
	}
	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}
	public int getCommentUserid() {
		return commentUserid;
	}
	public void setCommentUserid(int commentUserid) {
		this.commentUserid = commentUserid;
	}
	public int getCommentBookid() {
		return commentBookid;
	}
	public void setCommentBookid(int commentBookid) {
		this.commentBookid = commentBookid;
	}
	public String getCommentContent() {
		return commentContent;
	}
	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}
	public Date getCommentTime() {
		return commentTime;
	}
	public void setCommentTime(Date commentTime) {
		this.commentTime = commentTime;
	}
	@Override
	public String toString() {
		return "Comment [commentId=" + commentId + ", commentUserid=" + commentUserid + ", commentBookid="
				+ commentBookid + ", commentContent=" + commentContent + ", commentTime=" + commentTime + "]";
	}
    
}
