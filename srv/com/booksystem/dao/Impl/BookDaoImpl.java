package com.booksystem.dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.booksystem.dao.BookDao;
import com.booksystem.entity.Book;
import com.booksystem.entity.BookShow;
import com.booksystem.entity.BookShow2;
import com.booksystem.utils.JDBCUtils;

public class BookDaoImpl implements BookDao{
	private Connection con;
	private PreparedStatement sta;
	private ResultSet rs;
	@Override
	public List<BookShow> findBook(int page,int line) {
		List<BookShow> bookshows=new ArrayList<BookShow>();
		BookShow show=null;
		con=JDBCUtils.getConnection();
		String sql="select k1.book_id,k1.book_name,k1.author,k1.sex,k1.price,booktype.book_typename "+
        "from (select book_id,book_name,author,sex,price,book_typeid from book where isFlag=0 ) as k1 "+
         "join booktype on k1.book_typeid=booktype.type_id limit ?,?";
		try {
			sta=con.prepareStatement(sql);
			sta.setInt(1, (page-1)*line);
			sta.setInt(2, line);
			rs=sta.executeQuery();
			while(rs.next()){
				show=new BookShow();
				show.setBook_id(rs.getInt(1));
				show.setBook_name(rs.getString(2));
				show.setAuthor(rs.getString(3));
				show.setPrice(rs.getDouble(5));
				show.setSex(rs.getString(4));
				show.setBook_type(rs.getString(6));
				bookshows.add(show);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JDBCUtils.close(con, sta, rs);
		    return bookshows;
		}
	}
	@Override
	public List<BookShow> findBookByLibName(String name, int page, int line) {
		List<BookShow> bookshows=new ArrayList<BookShow>();
		String myname1=name+"%";
		String myname2="%"+name;
		String myname3="%"+name+"%";
		String myname4=name;
		BookShow show=null;
		con=JDBCUtils.getConnection();
		String sql="select k1.book_id,k1.book_name,k1.author,k1.sex,k1.price,booktype.book_typename "+
		        "from (select book_id,book_name,author,sex,price,book_typeid from book where isFlag=0 and"+
				" (book_name like ? or book_name like ? or book_name like ? or book_name like ?)) as k1 "+
		         "join booktype on k1.book_typeid=booktype.type_id limit ?,?";
		try {
			sta=con.prepareStatement(sql);
		    sta.setString(1, myname1);
		    sta.setString(2, myname2);
		    sta.setString(3, myname3);
		    sta.setString(4, myname4);
		    sta.setInt(5, (page-1)*line);
		    sta.setInt(6, line);
		    rs=sta.executeQuery();
		    while(rs.next()){
		    	show=new BookShow();
				show.setBook_id(rs.getInt(1));
				show.setBook_name(rs.getString(2));
				show.setAuthor(rs.getString(3));
				show.setPrice(rs.getDouble(5));
				show.setSex(rs.getString(4));
				show.setBook_type(rs.getString(6));
				bookshows.add(show);
		    }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JDBCUtils.close(con, sta, rs);
		    return bookshows;
		}
	}
	@Override
	public List<BookShow> findBookByAutName(String name, int page, int line) {
		List<BookShow> bookshows=new ArrayList<BookShow>();
		BookShow show=null;
		String myname1=name+"%";
		String myname2="%"+name;
		String myname3="%"+name+"%";
		String myname4=name;
		con=JDBCUtils.getConnection();
		String sql="select k1.book_id,k1.book_name,k1.author,k1.sex,k1.price,booktype.book_typename "+
		        "from (select book_id,book_name,author,sex,price,book_typeid from book where isFlag=0 and "+
				"(author like ? or author like ? or author like ? or author like ?)) as k1 "+
		         "join booktype on k1.book_typeid=booktype.type_id limit ?,?";
		try {
			sta=con.prepareStatement(sql);
		    sta.setString(1,myname1);
		    sta.setString(2, myname2);
		    sta.setString(3, myname3);
		    sta.setString(4, myname4);
		    sta.setInt(5, (page-1)*line);
		    sta.setInt(6, line);
		    rs=sta.executeQuery();
		    while(rs.next()){
		    	show=new BookShow();
				show.setBook_id(rs.getInt(1));
				show.setBook_name(rs.getString(2));
				show.setAuthor(rs.getString(3));
				show.setPrice(rs.getDouble(5));
				show.setSex(rs.getString(4));
				show.setBook_type(rs.getString(6));
				bookshows.add(show);
		    }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JDBCUtils.close(con, sta, rs);
		    return bookshows;
		}
	}
	@Override
	public List<BookShow> findBookByAll(String name1, String name2, int page, int line) {
		String myname1=name1+"%";
	    String myname2="%"+name1;
	    String myname3="%"+name1+"%";
	    String myname4=name1;
	    String myname5=name2+"%";
	    String myname6="%"+name2;
	    String myname7="%"+name2+"%";
	    String myname8=name2;
		List<BookShow> bookshows=new ArrayList<BookShow>();
		BookShow show=null;
		con=JDBCUtils.getConnection();
		String sql="select k1.book_id,k1.book_name,k1.author,k1.sex,k1.price,booktype.book_typename "+
		        "from (select book_id,book_name,author,sex,price,book_typeid from book where isFlag=0 and "+
				"(author like ? or author like ? or author like ? or author like ?) and "+
		        "(book_name like ? or book_name like ? or book_name like ? or book_name like ?)) as k1 "+
		         "join booktype on k1.book_typeid=booktype.type_id limit ?,?";
		try {
			sta=con.prepareStatement(sql);
			sta.setString(1, myname5);
			sta.setString(2, myname6);
			sta.setString(3, myname7);
			sta.setString(4, myname8);
			sta.setString(5, myname1);
			sta.setString(6, myname2);
			sta.setString(7, myname3);
			sta.setString(8, myname4);
			sta.setInt(9, (page-1)*line);
			sta.setInt(10, line);
			rs=sta.executeQuery();
			while(rs.next()){
		    	show=new BookShow();
				show.setBook_id(rs.getInt(1));
				show.setBook_name(rs.getString(2));
				show.setAuthor(rs.getString(3));
				show.setPrice(rs.getDouble(5));
				show.setSex(rs.getString(4));
				show.setBook_type(rs.getString(6));
				bookshows.add(show);
		    }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JDBCUtils.close(con, sta, rs);
		    return bookshows;
		}
	}
	@Override
	public int findBookCount() {
		int result=0;
		con=JDBCUtils.getConnection();
		String sql="select count(k2.book_id) from (select k1.book_id,k1.book_name,k1.author,k1.sex,k1.price,booktype.book_typename "+
		        "from (select book_id,book_name,author,sex,price,book_typeid from book where isFlag=0 ) as k1 "+
		         "join booktype on k1.book_typeid=booktype.type_id) as k2";
		try {
			sta=con.prepareStatement(sql);
			rs=sta.executeQuery();
			if(rs.next()){
				result=rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JDBCUtils.close(con, sta, rs);
		    return result;
		}
	}
	@Override
	public int findBookByLibName(String name) {
		int result=0;
		con=JDBCUtils.getConnection();
		String sql="select count(k2.book_id) from (select k1.book_id,k1.book_name,k1.author,k1.sex,k1.price,booktype.book_typename "+
		        "from (select book_id,book_name,author,sex,price,book_typeid from book where isFlag=0 and"+
				" (book_name like ? or book_name like ? or book_name like ? or book_name like ?)) as k1 "+
		         "join booktype on k1.book_typeid=booktype.type_id) as k2";
		try {
			sta=con.prepareStatement(sql);
			sta.setString(1, name);
			sta.setString(2, name+"%");
			sta.setString(3, "%"+name);
			sta.setString(4, "%"+name+"%");
			rs=sta.executeQuery();
			if(rs.next()){
				result=rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JDBCUtils.close(con, sta, rs);
		    return result;
		}
	}
	@Override
	public int findBookByAutName(String name) {
		int result=0;
		con=JDBCUtils.getConnection();
		String sql="select count(k2.book_id) from (select k1.book_id,k1.book_name,k1.author,k1.sex,k1.price,booktype.book_typename "+
		        "from (select book_id,book_name,author,sex,price,book_typeid from book where isFlag=0 and "+
				"(author like ? or author like ? or author like ? or author like ?)) as k1 "+
		         "join booktype on k1.book_typeid=booktype.type_id) as k2;";
		try {
			sta=con.prepareStatement(sql);
			sta.setString(1,name);
			sta.setString(2, "%"+name);
			sta.setString(3, name+"%");
			sta.setString(4, "%"+name+"%");
			rs=sta.executeQuery();
			if(rs.next()){
				result=rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JDBCUtils.close(con, sta, rs);
		    return result;
		}
	}
	@Override
	public int findBookByAll(String name1, String name2) {
		int result=0;
		con=JDBCUtils.getConnection();
		String sql="select count(k2.book_id) from (select k1.book_id,k1.book_name,k1.author,k1.sex,k1.price,booktype.book_typename "+
		        "from (select book_id,book_name,author,sex,price,book_typeid from book where isFlag=0 and "+
				"(author like ? or author like ? or author like ? or author like ?) "
		        +"and (book_name like ? or book_name like ? or book_name like ? or book_name like ?)) as k1 "+
		         "join booktype on k1.book_typeid=booktype.type_id) as k2;";
		try {
			sta=con.prepareStatement(sql);
			sta.setString(1, name2);
			sta.setString(2, "%"+name2);
			sta.setString(3, "%"+name2+"%");
			sta.setString(4, name2+"%");
			sta.setString(5, name1);
			sta.setString(6, name1+"%");
			sta.setString(7, "%"+name1+"%");
			sta.setString(8, "%"+name1);
			rs=sta.executeQuery();
			if(rs.next()){
				result=rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JDBCUtils.close(con, sta, rs);
		    return result;
		}
	}
	@Override
	public BookShow findBook(int id) {
		BookShow bookshow=null;
		con=JDBCUtils.getConnection();
		String sql="select k.book_id,k.book_name,k.author,k.sex,k.price,booktype.book_typename "+
		"from (select * from book where book_id=? and isFlag=0) as k join booktype on booktype.type_id=k.book_typeid;";
		try {
			sta=con.prepareStatement(sql);
			sta.setInt(1, id);
			rs=sta.executeQuery();
			if(rs.next()){
				bookshow=new BookShow();
				bookshow.setBook_id(rs.getInt(1));
				bookshow.setBook_name(rs.getString(2));
				bookshow.setAuthor(rs.getString(3));
				bookshow.setSex(rs.getString(4));
				bookshow.setPrice(rs.getDouble(5));
				bookshow.setBook_type(rs.getString(6));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JDBCUtils.close(con, sta, rs);
			return bookshow;
		}
	}
	@Override
	public boolean addBook(Book book) {
		boolean result=false;
		con=JDBCUtils.getConnection();
		String sql="insert into book(book_name,author,sex,price,book_desc,book_typeid,isFlag) "+
		"values(?,?,?,?,?,?,0)";
		try {
			sta=con.prepareStatement(sql);
			sta.setString(1, book.getBook_name());
			sta.setString(2, book.getAuthor());
			sta.setString(3, book.getSex());
			sta.setDouble(4, book.getPrice());
			sta.setString(5,book.getBook_desc());
			sta.setInt(6, book.getBook_typeid());
			int num=sta.executeUpdate();
			if(num>0){
				result=true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated cach block
			e.printStackTrace();
		}finally{
			JDBCUtils.close(con,sta,rs);
		    return result;
		}
	}
	@Override
	public String findBookById(int id) {
		String book="";
		con=JDBCUtils.getConnection();
		String sql="select * from book where book_id=?";
		try {
			sta=con.prepareStatement(sql);
			sta.setInt(1, id);
			rs=sta.executeQuery();
			if(rs.next()){
				book=rs.getString(2);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JDBCUtils.close(con, sta, rs);
		    return book;
		}
	}
	@Override
	public List<BookShow2> findAll() {
		List<BookShow2> books=new ArrayList<BookShow2>();
		BookShow2 book=null;
		String sql="select * from book,booktype where book.book_typeid=booktype.type_id";
		con=JDBCUtils.getConnection();
		try {
			sta=con.prepareStatement(sql);
			rs=sta.executeQuery();
			while(rs.next()){
				book=new BookShow2();
				book.setBook_id(rs.getInt("book_id"));
				book.setBook_name(rs.getString("book_name"));
				book.setAuthor(rs.getString("author"));
				book.setSex(rs.getString("sex"));
				book.setPrice(rs.getDouble("price"));
				book.setBook_type(rs.getString("book_typename"));
				book.setIsFlag(rs.getInt("isFlag"));
				books.add(book);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JDBCUtils.close(con, sta, rs);
		    return books;
		}
	}
	
}
