package com.booksystem.service.Impl;

import java.util.List;

import com.booksystem.dao.BorrowDao;
import com.booksystem.dao.Impl.BorrowDaoImpl;
import com.booksystem.entity.Borrow;
import com.booksystem.entity.BorrowShow;
import com.booksystem.entity.HistoryBean;
import com.booksystem.service.BorrowService;

public class BorrowServiceImpl implements BorrowService{
	private BorrowDao borrowdao=new BorrowDaoImpl();
	@Override
	public boolean returnBook(Borrow borrow) {
		return borrowdao.returnBook(borrow);
	}
	@Override
	public List<HistoryBean> findHistoryBean(int user_id) {
		return borrowdao.findHistoryBean(user_id);
	}
	@Override
	public BorrowShow findUserById(int id) {
		return borrowdao.findUserById(id);
	}

}
