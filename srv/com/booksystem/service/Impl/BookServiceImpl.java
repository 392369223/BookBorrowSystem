package com.booksystem.service.Impl;

import java.util.List;

import com.booksystem.dao.BookDao;
import com.booksystem.dao.Impl.BookDaoImpl;
import com.booksystem.entity.Book;
import com.booksystem.entity.BookShow;
import com.booksystem.entity.BookShow2;
import com.booksystem.service.BookService;

public class BookServiceImpl implements BookService{
    BookDao bookdao=new BookDaoImpl();
	@Override
	public List<BookShow> findBook(int page,int line) {
		return bookdao.findBook(page,line);
	}
	@Override
	public List<BookShow> findBookByLibName(String name, int page, int line) {
		return bookdao.findBookByLibName(name, page, line);
	}
	@Override
	public List<BookShow> findBookByAutName(String name, int page, int line) {
		return bookdao.findBookByAutName(name, page, line);
	}
	@Override
	public List<BookShow> findBookByAll(String name1, String name2, int page, int line) {
		return bookdao.findBookByAll(name1, name2, page, line);
	}
	@Override
	public int findBookCount() {
		return bookdao.findBookCount();
	}
	@Override
	public int findBookByLibName(String name) {
		return bookdao.findBookByLibName(name);
	}
	@Override
	public int findBookByAutName(String name) {
		return bookdao.findBookByAutName(name);
	}
	@Override
	public int findBookByAll(String name1, String name2) {
		return bookdao.findBookByAll(name1, name2);
	}
	@Override
	public BookShow findBook(int id) {
		return bookdao.findBook(id);
	}
	@Override
	public boolean addBook(Book book) {
		return bookdao.addBook(book);
	}
	@Override
	public String findBookById(int id) {
		// TODO Auto-generated method stub
		return bookdao.findBookById(id);
	}
	@Override
	public List<BookShow2> findAll() {
		return bookdao.findAll();
	}

}
