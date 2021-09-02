package com.booksystem.dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.booksystem.dao.LendDao;
import com.booksystem.entity.TableUsed;
import com.booksystem.utils.JDBCUtils;

public class LendDaoImpl implements LendDao{
	private Connection con;
	private PreparedStatement sta;
	private ResultSet rs;
	@Override
	public boolean returnBook(TableUsed use) {
		int result=0;
		con=JDBCUtils.getConnection();
		try {
			con.setAutoCommit(false);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String sql="update book set isFlag=0 where book_id=?";
		try {
			sta=con.prepareStatement(sql);
			sta.setInt(1,use.getBook_id());
			int num=sta.executeUpdate();
			if(num>0){
				result=1;
				String sql2="insert into lend ";
				sta=con.prepareStatement(sql2);
				int num2=sta.executeUpdate();
				if(num2>0){
					result=2;
				}
			}
			if(result==2){
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
		   return false;
		}
	}
}
