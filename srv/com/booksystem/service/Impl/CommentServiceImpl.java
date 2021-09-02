package com.booksystem.service.Impl;

import java.util.List;

import com.booksystem.dao.CommentDao;
import com.booksystem.dao.Impl.CommentDaoImpl;
import com.booksystem.entity.Comment;
import com.booksystem.service.CommentService;

public class CommentServiceImpl implements CommentService{
    private CommentDao commentdao=new CommentDaoImpl();
	@Override
	public boolean publish(Comment comment) {
		return commentdao.publish(comment);
	}
	@Override
	public List<Comment> findAll(int id) {
		return commentdao.findAll(id);
	}
    
}
