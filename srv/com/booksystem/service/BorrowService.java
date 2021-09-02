package com.booksystem.service;

import java.util.List;

import com.booksystem.entity.Borrow;
import com.booksystem.entity.BorrowShow;
import com.booksystem.entity.HistoryBean;

public interface BorrowService {
	//查询lend表中是否还书
	//如果还书了，就返回false
	//如果没还书，还书，显示还书成功
	public boolean returnBook(Borrow borrow);
	//查看用户借阅过的图书，包括图书的状态
    public List<HistoryBean> findHistoryBean(int user_id);
  //根据图书id查找用户id和归还时间
  	public BorrowShow findUserById(int id);
}
