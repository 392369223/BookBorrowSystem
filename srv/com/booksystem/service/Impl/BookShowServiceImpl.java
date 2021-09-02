package com.booksystem.service.Impl;

import com.booksystem.dao.BookShowDao;
import com.booksystem.dao.Impl.BookShowDaoImpl;
import com.booksystem.entity.BookShow;
import com.booksystem.entity.User;
import com.booksystem.service.BookShowService;

public class BookShowServiceImpl implements BookShowService{
	private BookShowDao bookshowdao=new BookShowDaoImpl();
	@Override
	public boolean Borrow(User u, BookShow show) {
		return bookshowdao.Borrow(u, show);
	}

}
