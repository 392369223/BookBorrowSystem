package com.booksystem.service;

import java.util.List;

import com.booksystem.entity.Comment;

public interface CommentService {
	//��������
    public boolean publish(Comment comment);
    //����ʱ��˳���ѯ�������ͼ�������
    public List<Comment> findAll(int id);
}
