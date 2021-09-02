package com.booksystem.test;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.booksystem.dao.BorrowDao;
import com.booksystem.dao.Impl.BorrowDaoImpl;
import com.booksystem.entity.Borrow;
import com.booksystem.entity.BorrowShow;
import com.booksystem.entity.HistoryBean;

public class TestBorrowDao {
	private BorrowDao dao=new BorrowDaoImpl();
	@org.junit.Test
    public void test(){
		/*Borrow borrow=new Borrow();
		borrow.setBookid(6);
		borrow.setUserid(1);
		borrow.setBtime("2021-08-27 19:14:03");
		borrow.setReturntime("2021-09-27 19:14:03");
	   	boolean b=dao.returnBook(borrow);
    	System.out.println(b);*/
		List<HistoryBean> lst=dao.findHistoryBean(1);
		/*for(int i=0;i<lst.size();i++){
			System.out.println(lst.get(i));
		}*/
		BorrowShow findUserById = dao.findUserById(6);
		System.out.println(findUserById);
		
    }
}
