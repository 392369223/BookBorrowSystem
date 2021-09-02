package com.booksystem.dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.booksystem.dao.BorrowDao;
import com.booksystem.entity.BookShow;
import com.booksystem.entity.Borrow;
import com.booksystem.entity.BorrowShow;
import com.booksystem.entity.HistoryBean;
import com.booksystem.entity.Lender;
import com.booksystem.utils.JDBCUtils;

public class BorrowDaoImpl implements BorrowDao{
	private Connection con;
	private PreparedStatement sta;
	private ResultSet rs;
	@Override
	public boolean returnBook(Borrow borrow) {
		con=JDBCUtils.getConnection();
		int result=0;
		String sql="select * from "+
		"(select * from borrow where userid=? and bookid=? and btime=? and returntime=?) as k1 "+
		"join lend on k1.bid=lend.borrowid";
		try {
			con.setAutoCommit(false);
			sta=con.prepareStatement(sql);
			sta.setInt(1, borrow.getUserid());
			sta.setInt(2, borrow.getBookid());
			sta.setString(3, borrow.getBtime());
			sta.setString(4, borrow.getReturntime());
			rs=sta.executeQuery();
			if(rs.next()){
				result=0;
			}else{
				String sql2="select bid from borrow where userid=? and bookid=? and btime=? and returntime=?";
				sta=con.prepareStatement(sql2);
				sta.setInt(1, borrow.getUserid());
				sta.setInt(2, borrow.getBookid());
				sta.setString(3, borrow.getBtime());
				sta.setString(4, borrow.getReturntime());
				rs=sta.executeQuery();
				if(rs.next()){
					int num=rs.getInt(1);
					Lender lender=new Lender();
					lender.setBookid(borrow.getBookid());
					lender.setBorrowid(num);
					lender.setLtime(new Date());
					lender.setUserid(borrow.getUserid());
					String sql3="insert into lend(userid,bookid,ltime,borrowid) values(?,?,?,?)";
					sta=con.prepareStatement(sql3);
					sta.setInt(1, lender.getUserid());
					sta.setInt(2, lender.getBookid());
					sta.setTimestamp(3, new Timestamp(lender.getLtime().getTime()));
					sta.setInt(4,lender.getBorrowid());
					int u=sta.executeUpdate();
					if(u>0){
						String sql4="update book set isFlag=0 where book_id=?";
						sta=con.prepareStatement(sql4);
						sta.setInt(1, borrow.getBookid());
						int u2=sta.executeUpdate();
						if(u2>0){
							result=1;
						}
					}
				}
			}
			if(result==1){
				con.commit();
			}else{
				con.rollback();
			}
		} catch (Exception e) {
			con.rollback();
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JDBCUtils.close(con, sta, rs);
		    return result==1;
		}
	}
	@Override
	public List<HistoryBean> findHistoryBean(int user_id) {
		List<HistoryBean> historylist=new ArrayList<HistoryBean>();
		HistoryBean bean=null;
		con=JDBCUtils.getConnection();
		String sql="select k.bookid,k.btime,k.returntime,lid from "+
		"(select * from borrow where userid=?) as k left join lend on k.bid=lend.borrowid;";
		try {
			sta=con.prepareStatement(sql);
			sta.setInt(1, user_id);
			rs=sta.executeQuery();
			while(rs.next()){
				bean=new HistoryBean();
				bean.setBookid(rs.getInt(1));
				bean.setBtime(new Date(rs.getTimestamp(2).getTime()));
				bean.setRtime(new Date(rs.getTimestamp(3).getTime()));
				bean.setState(rs.getInt(4)==0?"δ�黹":"�ѹ黹");
				historylist.add(bean);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JDBCUtils.close(con,sta,rs);
		    return historylist;
		}
	}
	@Override
	public BorrowShow findUserById(int id) {
		BorrowShow show=null;
		con=JDBCUtils.getConnection();
		String sql="select * from borrow where bookid=? order by bid desc limit 1";
		try {
			sta=con.prepareStatement(sql);
			sta.setInt(1,id);
			rs=sta.executeQuery();
			if(rs.next()){
				SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				show=new BorrowShow();
				show.setBookid(id);
				show.setUserid(rs.getInt(2));
				show.setBtime(format.format(new Date(rs.getTimestamp(4).getTime())));
				show.setRtime(format.format(new Date(rs.getTimestamp(5).getTime())));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JDBCUtils.close(con, sta, rs);
		    return show;
		}
	}

}
