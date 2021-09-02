package com.booksystem.test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import com.booksystem.dao.BookAndBBookDao;
import com.booksystem.dao.BookDao;
import com.booksystem.dao.Impl.BookAndBBookDaoImpl;
import com.booksystem.dao.Impl.BookDaoImpl;
import com.booksystem.entity.BookShow;
import com.booksystem.entity.TableUsed;

public class testdao1 {
	private BookDao dao=new BookDaoImpl();
	//@Test
    public void test1(){
    	BookAndBBookDao dao=new BookAndBBookDaoImpl();
    	List<TableUsed> lst=dao.findDataByPage(1, 1, 1);
    	for(TableUsed t:lst){
    		System.out.println(t);
    	}
    }
    //@Test
	public void test2(){
    	BookAndBBookDao dao=new BookAndBBookDaoImpl();
    	System.out.println(dao.selectAllRows(1));
	}
	//@Test
	public void test3(){
		Date d=new Date();
		SimpleDateFormat simple=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	    System.out.println(simple.format(d));
	}
	//@Test
	public void test4(){
		BookDao dao=new BookDaoImpl();
		List<BookShow> shows=dao.findBook(1, 3);
		for(BookShow show:shows){
			System.out.println(show);
		}
	}
	//@Test
	public void test5(){
		List<BookShow> shows=dao.findBookByLibName("水", 1,3);
		for(BookShow show:shows){
			System.out.println(show);
		}
	}
	//@Test
	public void test6(){
		List<BookShow> shows=dao.findBookByAutName("D", 1,3);
		for(BookShow show:shows){
			System.out.println(show);
		}
	}
	//@Test
	public void test7(){
		List<BookShow> shows=dao.findBookByAll("十", "罗", 1, 1);
		for(BookShow show:shows){
			System.out.println(show);
		}
	}
	//@Test
	public void test8(){
		int result=dao.findBookCount();
        System.out.println(result);
	}
	//@Test
	public void test9(){
		int result=dao.findBookByLibName("十");
		System.out.println(result);
	}
	//@Test
	public void test10(){
		int result=dao.findBookByAutName("罗");
		System.out.println(result);
	}
	@Test
	public void test11(){
		int result=dao.findBookByAll("十", "罗");
		System.out.println(result);
	}
}
