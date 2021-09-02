package com.booksystem.test;

import java.util.Date;
import java.util.List;

import com.booksystem.dao.CommentDao;
import com.booksystem.dao.Impl.CommentDaoImpl;
import com.booksystem.entity.Comment;

public class TestCommentDao {
	private CommentDao dao=new CommentDaoImpl();
	//@org.junit.Test
    public void test(){
		Comment comment=new Comment();
		comment.setCommentBookid(2);
		comment.setCommentContent("这本书价格太高。。。");
		comment.setCommentTime(new Date());
		comment.setCommentUserid(1);
    	boolean b=dao.publish(comment);
    	System.out.println(b);
    }
    @org.junit.Test
	public void test2(){
		List<Comment> l=dao.findAll(2);
		for(int i=0;i<l.size();i++){
			System.out.println(l.get(i));
		}
	}
}
