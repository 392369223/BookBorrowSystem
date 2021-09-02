package com.booksystem.dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.Date;

import com.booksystem.dao.BookShowDao;
import com.booksystem.entity.BookShow;
import com.booksystem.entity.User;
import com.booksystem.utils.JDBCUtils;

public class BookShowDaoImpl implements BookShowDao{
	private Connection con;
	private PreparedStatement sta;
	private ResultSet rs;
	@Override
	public boolean Borrow(User u, BookShow show) {
		con=JDBCUtils.getConnection();
		int state=0;
		try {
			con.setAutoCommit(false);
			String sql="select * from book where book_id=? and isFlag=?";
			sta=con.prepareStatement(sql);
			sta.setInt(1, show.getBook_id());
			sta.setInt(2, 0);
			rs=sta.executeQuery();
			if(rs.next()){
				state=1;
			}
			if(state==1){
				String sql2="update book set isFlag=1 where book_id=?";
				sta=con.prepareStatement(sql2);
				sta.setInt(1,show.getBook_id());
				int num=sta.executeUpdate();
				if(num>0){
					state=2;
				}
			}
			if(state==2){
				//成功借书后，向borrow中添加一条记录
				String sql3="insert into borrow(userid,bookid,btime,returntime) values(?,?,?,?)";
				Date d=new Date();
			    Timestamp time1=new Timestamp(d.getTime());
			    d.setMonth(d.getMonth()+1);
			    Timestamp time2=new Timestamp(d.getTime());
			    sta=con.prepareStatement(sql3);
			    sta.setInt(1, u.getUser_id());
			    sta.setInt(2, show.getBook_id());
			    sta.setTimestamp(3, time1);
			    sta.setTimestamp(4, time2);
			    int num=sta.executeUpdate();
			    if(num>0){
			    	state=3;
			    }
			}
			if(state==3){
			con.commit(); 
			}else{
				con.rollback();
			}
		} catch (Exception e) {
		    con.rollback();
			e.printStackTrace();
		}finally{
			JDBCUtils.close(con, sta,rs);
		    return state==3;
		}
	}
}
