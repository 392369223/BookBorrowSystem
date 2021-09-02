package com.booksystem.dao;

import java.util.List;

import com.booksystem.entity.Book;
import com.booksystem.entity.BookShow;
import com.booksystem.entity.BookShow2;

public interface BookDao {
    //查询没有被订阅的图书
	public List<BookShow> findBook(int page,int line);
	//根据图书名称查询
	public List<BookShow> findBookByLibName(String name,int page,int line);
	//根据作者名称查询
	public List<BookShow> findBookByAutName(String name,int page,int line);
	//根据图书名称和作者名称查询
	public List<BookShow> findBookByAll(String name1,String name2,int page,int line);
	//查询没有条件的总行数
	public int findBookCount();
	//查询有图书名称的行数
	public int findBookByLibName(String name);
	//查询有作者名称的行数
	public int findBookByAutName(String name);
	//查询有图书和作者名称的行数
	public int findBookByAll(String name1,String name2);
	//--查询图书id对应的图书
	public BookShow findBook(int id);
	//--根据图书信息插入图书
	public boolean addBook(Book book);
	//查询
	public String findBookById(int id);
	//查找所有的图书
	public List<BookShow2> findAll();
}
