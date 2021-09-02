package com.booksystem.service;

import java.util.List;

import com.booksystem.entity.Comment;

public interface CommentService {
	//发表评论
    public boolean publish(Comment comment);
    //按照时间顺序查询所有相关图书的评论
    public List<Comment> findAll(int id);
}
