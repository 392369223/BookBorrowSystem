package com.booksystem.service.Impl;

import java.util.List;

import com.booksystem.dao.BookAndBBookDao;
import com.booksystem.dao.Impl.BookAndBBookDaoImpl;
import com.booksystem.entity.TableUsed;
import com.booksystem.service.BookAndBBookService;

public class BookAndBBookServiceImpl implements BookAndBBookService{
    BookAndBBookDao bookandbbookdao=new BookAndBBookDaoImpl();
	@Override
	public int selectAllRows(int id) {
		return bookandbbookdao.selectAllRows(id);
	}

	@Override
	public List<TableUsed> findDataByPage(int id, int page, int line) {
		return bookandbbookdao.findDataByPage(id, page, line);
	}

}
