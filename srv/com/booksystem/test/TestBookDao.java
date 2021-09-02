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
    	 book.setBook_name("¾øÃü¶¾Ê¦");
    	 book.setAuthor("Â³Ñ¸");
    	 book.setSex("ÄÐ");
    	 book.setPrice(31.4);
    	 book.setBook_desc("Ð´ÁËÔÚÏÖ´úµÄ¹ÊÊÂ");
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
    	 int num=dao.findBookByAll("¾øÃü","Â³");
    	 System.out.println("num="+num);
     }
     //@org.junit.Test
     public void testLib(){
    	 int num=dao.findBookByLibName("¾øÃü");
    	 System.out.println("num="+num);
     }
     //@org.junit.Test
     public void testAut(){
    	 int num=dao.findBookByAutName("Â³");
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
    	 List<BookShow> shows=dao.findBookByAll("¾ø", "Â³", 1, 3);
    	 for(int i=0;i<shows.size();i++){
    	     System.out.println(shows.get(i));
    	 }
     }
     //@org.junit.Test
     public void test3(){
    	 List<BookShow> shows=dao.findBookByAutName("Â³", 1, 3);
    	 for(int i=0;i<shows.size();i++){
    	     System.out.println(shows.get(i));
    	 }
     }
     //@org.junit.Test
     public void test4(){
    	 List<BookShow> shows=dao.findBookByLibName("¾øÃü", 1, 2);
    	 for(int i=0;i<shows.size();i++){
    	     System.out.println(shows.get(i));
    	 }
     }
     
}
