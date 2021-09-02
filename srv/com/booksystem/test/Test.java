package com.booksystem.test;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;

import com.booksystem.dao.BookDao;
import com.booksystem.dao.BookShowDao;
import com.booksystem.dao.BorrowDao;
import com.booksystem.dao.TypeDao;
import com.booksystem.dao.Impl.BookDaoImpl;
import com.booksystem.dao.Impl.BookShowDaoImpl;
import com.booksystem.dao.Impl.BorrowDaoImpl;
import com.booksystem.dao.Impl.TypeDaoImpl;
import com.booksystem.entity.Book;
import com.booksystem.entity.BookShow;
import com.booksystem.entity.Borrow;
import com.booksystem.entity.HistoryBean;
import com.booksystem.entity.User;

public class Test {
    public static void main(String[] args) {
		/*BookShowDao dao=new BookShowDaoImpl();
		User user=new User();
		user.setUser_id(1);
		BookShow book=new BookShow();
		book.setBook_id(6);
	    boolean result=dao.Borrow(user,book);
	    System.out.println("���Խ��:"+result);*/
    	/*BookDao bookdao=new BookDaoImpl();
    	System.out.println(bookdao.findBook(9));*/
    	/*BorrowDao borrowdao=new BorrowDaoImpl();
    	Borrow b=new Borrow();
    	b.setUserid(1);
    	b.setBookid(1);
        b.setBtime("2021-08-21 09:53:22");
        b.setReturntime("2021-08-30 09:53:26");
    	System.out.println(borrowdao.returnBook(b));*/
    	/*BorrowDao dao=new BorrowDaoImpl();
        List<HistoryBean> lst=dao.findHistoryBean(1);
        for(HistoryBean bean:lst){
        	System.out.println(bean);
        }*/
    	/*TypeDao dao=new TypeDaoImpl();
    	for(String s:dao.findAll()){
    		System.out.println(s);
    	}*/
    	/*TypeDao dao=new TypeDaoImpl();
    	int num=dao.getId("��װ");
    	System.out.println("num="+num);*/
    	BookDao dao=new BookDaoImpl();
    	Book book=new Book();
    	book.setBook_name("�����");
    	book.setAuthor("�޹���");
    	book.setSex("��");
    	book.setPrice(20.3);
    	book.setBook_typeid(3);
    	book.setBook_desc("����һ�����е���");
    	dao.addBook(book);
	}
}
