package com.booksystem.dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.booksystem.dao.TypeDao;
import com.booksystem.entity.Type;
import com.booksystem.utils.JDBCUtils;

public class TypeDaoImpl implements TypeDao{
	private Connection con;
	private PreparedStatement sta;
	private ResultSet rs;
	@Override
	public boolean addType(Type type) {
		con=JDBCUtils.getConnection();
		boolean result=false;
		String sql="insert into booktype(book_typename,book_typedesc) values(?,?)";
		try {
			sta=con.prepareStatement(sql);
			sta.setString(1, type.getType_name());
			sta.setString(2, type.getType_desc());
			int num=sta.executeUpdate();
			if(num>0){
				result=true;
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
	public List<String> findAll() {
		List<String> lst=new ArrayList<String>();
	    con=JDBCUtils.getConnection();
	    String sql="select book_typename from booktype";
	    try {
			sta=con.prepareStatement(sql);
			rs=sta.executeQuery();
			while(rs.next()){
				lst.add(rs.getString(1));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JDBCUtils.close(con, sta, rs);
		    return lst;
		}
	}
	@Override
	public int getId(String content) {
		int result=-1;
		con=JDBCUtils.getConnection();
		String sql="select type_id from booktype where book_typename=?";
		try {
			sta=con.prepareStatement(sql);
			sta.setString(1, content);
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
	public List<Type> findAll2()  {
		List<Type> typelst=new ArrayList<Type>();
		Type t=null;
		con=JDBCUtils.getConnection();
		String sql="select * from booktype";
		try {
			sta=con.prepareStatement(sql);
			rs=sta.executeQuery();
			while(rs.next()){
				t=new Type();
				t.setId(rs.getInt(1));
				t.setType_name(rs.getString(2));
				t.setType_desc(rs.getString(3));
				typelst.add(t);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JDBCUtils.close(con, sta, rs);
		    return typelst;
		}
	}

}
