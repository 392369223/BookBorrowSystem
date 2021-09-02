package com.booksystem.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.booksystem.dao.CommentDao;
import com.booksystem.dao.Impl.CommentDaoImpl;
import com.booksystem.entity.Comment;

public class CommentTest {

	public static void main(String[] args) {
		CommentDao dao=new CommentDaoImpl();
		/*Comment comment=new Comment();
		comment.setCommentUserid(1);
	    comment.setCommentBookid(7);
	    comment.setCommentContent("水浒传还行");
	    SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	    Date d=null;
	    try {
			d=format.parse("2000-08-26 17:10:22");
			//System.out.println(d);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    comment.setCommentTime(d);
		System.out.println(dao.publish(comment));*/
		List<Comment> alls=dao.findAll(7);
		for(int i=0;i<alls.size();i++){
			System.out.println(alls.get(i));
		}		
	}

}
