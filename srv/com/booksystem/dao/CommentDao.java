package com.booksystem.dao;

import java.util.List;

import com.booksystem.entity.Comment;

public interface CommentDao {
	//��������
	public boolean publish(Comment comment);
	//����ʱ��˳���ѯ�������ͼ�������
    public List<Comment> findAll(int id);
 
}
