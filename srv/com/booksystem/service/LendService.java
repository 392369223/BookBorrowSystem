package com.booksystem.service;

import com.booksystem.entity.TableUsed;

public interface LendService {
	//实现归还图书的方法
	public boolean returnBook(TableUsed use);
}
