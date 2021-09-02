package com.booksystem.test;

import com.booksystem.dao.BookShowDao;
import com.booksystem.dao.BorrowDao;
import com.booksystem.dao.Impl.BookShowDaoImpl;
import com.booksystem.dao.Impl.BorrowDaoImpl;
import com.booksystem.entity.BookShow;
import com.booksystem.entity.User;

public class TestBookShowDao {
	BookShowDao dao=new BookShowDaoImpl();
	@org.junit.Test
    public void test1(){
		User u=new User();
		u.setUser_id(1);
		u.setUser_name("admin");
		u.setPwd("1234");
		u.setUser_state(0);
		u.setUser_type(0);
		BookShow show=new BookShow();
		show.setAuthor("³Ѹ");
		show.setBook_name("�����");
		show.setBook_id(6);
		show.setBook_type("��װ");
		show.setPrice(20.1);
		show.setSex("��");
    	boolean result=dao.Borrow(u, show);
    	System.out.println(""+result);
    }
}
