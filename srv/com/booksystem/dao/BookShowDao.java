package com.booksystem.dao;

import com.booksystem.entity.BookShow;
import com.booksystem.entity.User;

public interface BookShowDao {
	//��ѯ������Ƿ񱻽���
	//����������ˣ���ô��ʧ����
	//���û�б����ģ���ô�ͽ���
	public boolean Borrow(User u,BookShow show);
}
