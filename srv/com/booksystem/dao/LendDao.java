package com.booksystem.dao;

import com.booksystem.entity.TableUsed;

public interface LendDao {
    //ʵ�ֹ黹ͼ��ķ���
	public boolean returnBook(TableUsed use);
}
