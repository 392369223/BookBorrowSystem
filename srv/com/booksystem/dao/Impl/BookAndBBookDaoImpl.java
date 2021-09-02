package com.booksystem.dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.booksystem.dao.BookAndBBookDao;
import com.booksystem.entity.TableUsed;
import com.booksystem.utils.JDBCUtils;

public class BookAndBBookDaoImpl implements BookAndBBookDao{
	private Connection con;
	private PreparedStatement sta;
	private ResultSet rs;
	@SuppressWarnings("finally")
	@Override
	public int selectAllRows(int id) {
		int result=0;
		String sql="select count(k2.bookid) from (select k1.bookid,book.book_name,book.author,k1.btime,k1.returntime from "
	+"(select * from borrow where userid=? and bid not in (select borrowid from lend)) as k1 "+
     "JOIN book ON k1.bookid=book.book_id) as k2";
		con=JDBCUtils.getConnection();
	    try {
			sta=con.prepareStatement(sql);
			sta.setInt(1, id);
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
	public List<TableUsed> findDataByPage(int id,int page, int line) {
		List<TableUsed> tableuses=new ArrayList<TableUsed>();
		TableUsed table=null;
		String sql="select k1.bookid,book.book_name,book.author,k1.btime,k1.returntime from "
				+"(select * from borrow where userid=? and bid not in (select borrowid from lend)) as k1 "+
			     "JOIN book ON k1.bookid=book.book_id limit ?,?";
		con=JDBCUtils.getConnection();
		try {
			sta=con.prepareStatement(sql);
			sta.setInt(1, id);
			sta.setInt(2, (page-1)*line);
			sta.setInt(3, line);
			rs=sta.executeQuery();
			while(rs.next()){
				table=new TableUsed();
				table.setBook_id(rs.getInt(1));
				table.setBook_name(rs.getString(2));
				table.setAuthor(rs.getString(3));
				table.setBtime(new Date(rs.getTimestamp(4).getTime()));
				table.setReturntime(new Date(rs.getTimestamp(5).getTime()));
				tableuses.add(table);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JDBCUtils.close(con, sta, rs);
		    return tableuses;
		}
	}
}
