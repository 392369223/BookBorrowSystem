package com.booksystem.service.Impl;

import com.booksystem.dao.LendDao;
import com.booksystem.dao.Impl.LendDaoImpl;
import com.booksystem.entity.TableUsed;
import com.booksystem.service.LendService;

public class LendServiceImpl implements LendService{
	private LendDao lenddao=new LendDaoImpl();
	@Override
	public boolean returnBook(TableUsed use) {
		return lenddao.returnBook(use);
	}

}
