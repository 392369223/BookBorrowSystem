package com.booksystem.dao;

import com.booksystem.entity.TableUsed;

public interface LendDao {
    //实现归还图书的方法
	public boolean returnBook(TableUsed use);
}
