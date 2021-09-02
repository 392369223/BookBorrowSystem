package com.booksystem.test;

import java.util.List;

import com.booksystem.dao.BookDao;
import com.booksystem.dao.Impl.BookDaoImpl;
import com.booksystem.entity.Book;
import com.booksystem.entity.BookShow;

public class TestBookDao {
	 private BookDao dao=new BookDaoImpl();
	 //@org.junit.Test
     public void testAddbook(){
    	 Book book=new Book();
    	 book.setBook_name("������ʦ");
    	 book.setAuthor("³Ѹ");
    	 book.setSex("��");
    	 book.setPrice(31.4);
    	 book.setBook_desc("д�����ִ��Ĺ���");
    	 book.setBook_typeid(4);
    	 dao.addBook(book);
     }
     //@org.junit.Test
     public void testFindbook(){
    	 BookShow bookshow=dao.findBook(4);
    	 System.out.println(bookshow);
     }
     //@org.junit.Test
     public void testLibAndAut(){
    	 int num=dao.findBookByAll("����","³");
    	 System.out.println("num="+num);
     }
     //@org.junit.Test
     public void testLib(){
    	 int num=dao.findBookByLibName("����");
    	 System.out.println("num="+num);
     }
     //@org.junit.Test
     public void testAut(){
    	 int num=dao.findBookByAutName("³");
    	 System.out.println("num="+num);
     }
     //@org.junit.Test
     public void testCount(){
    	 int num=dao.findBookCount();
    	 System.out.println("num="+num);
     }
     //@org.junit.Test
     public void test(){
    	 List<BookShow> shows=dao.findBook(3, 2);
    	 for(int i=0;i<shows.size();i++){
    	     System.out.println(shows.get(i));
    	 }
     }
    //@org.junit.Test
     public void test2(){
    	 List<BookShow> shows=dao.findBookByAll("��", "³", 1, 3);
    	 for(int i=0;i<shows.size();i++){
    	     System.out.println(shows.get(i));
    	 }
     }
     //@org.junit.Test
     public void test3(){
    	 List<BookShow> shows=dao.findBookByAutName("³", 1, 3);
    	 for(int i=0;i<shows.size();i++){
    	     System.out.println(shows.get(i));
    	 }
     }
     //@org.junit.Test
     public void test4(){
    	 List<BookShow> shows=dao.findBookByLibName("����", 1, 2);
    	 for(int i=0;i<shows.size();i++){
    	     System.out.println(shows.get(i));
    	 }
     }
     
}
