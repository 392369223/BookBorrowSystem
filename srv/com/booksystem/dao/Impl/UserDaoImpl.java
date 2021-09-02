package com.booksystem.dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.booksystem.dao.UserDao;
import com.booksystem.entity.User;
import com.booksystem.utils.JDBCUtils;

public class UserDaoImpl implements UserDao{
	private Connection con;
	private PreparedStatement sta;
	private ResultSet rs;
    public UserDaoImpl() {
		super();
	}

	//��½
    @SuppressWarnings("finally")
	public User Login(String username,String pwd,int power){
    	//����prepareStatement
    	User u=null;
    	con = JDBCUtils.getConnection();
    	String sql="select * from user where user_name=? and user_pwd=? and user_type=?";
    	try {
			sta=con.prepareStatement(sql);
			sta.setString(1, username);
			sta.setString(2, pwd);
			sta.setInt(3, power);
		    rs=sta.executeQuery();
		    if(!rs.next()){
		    	//��ʾû������û�
		    	return u;
		    }else{
		    	//��װ�û�
		    	//�����û�
		    	//����û������ᣬ��id����Ϊ-1,Ȼ�󷵻ظ���һ��
		    	u=new User();
		    	u.setUser_id(rs.getInt(1));
		    	u.setUser_name(rs.getString(2));
		    	u.setPwd(rs.getString(3));
		    	u.setUser_type(rs.getInt(4));
		    	u.setUser_state(rs.getInt(5));
		    	if(u.getUser_state()==1){
		    		u.setUser_id(-1);
		    		return u;
		    	}else{
		    		return u;
		    	}
		    }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			
			JDBCUtils.close(con, sta,rs);
			return u;
		}
    }
	//ע��

	@SuppressWarnings("finally")
	@Override
	public User Register(String username, String pwd) {
		con=JDBCUtils.getConnection();
		User u=null;
		String sql1="select * from user where user_name=?";
		String sql2="insert into user(user_name,user_pwd,user_type,user_state) values(?,?,?,?)";
		try {
			sta=con.prepareStatement(sql1);
			sta.setString(1, username);
		    rs=sta.executeQuery();
		    if(rs.next()){
			JDBCUtils.close(null,sta,rs);
			u=new User();
			u.setUser_id(-1);
			return u;
		    }else{
		      sta=con.prepareStatement(sql2);
		      sta.setString(1,username);
		      sta.setString(2, pwd);
		      sta.setInt(3, 0);
		      sta.setInt(4, 0);
		      boolean execute = sta.executeUpdate()==0?false:true;
		      JDBCUtils.close(null, sta, null);
		      if(execute){
		    	  sta=con.prepareStatement(sql1);
		    	  sta.setString(1,username);
		    	  rs=sta.executeQuery();
		    	  if(rs.next()){
		    		  u=new User();
		    		  u.setUser_id(rs.getInt(1));
		    		  u.setUser_name(rs.getString(2));
		    		  u.setPwd(rs.getString(3));
		    		  u.setUser_state(0);
		    		  u.setUser_type(0);
		    		  return u;
		    	  }
		      }else{
		    	  return u;
		      }
		    }
			//��ѯ�Ƿ��и��û�������У���id����Ϊ-1���أ�
			//���򣬲����û������²�ѯ�û�����
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
		//�ر���Դ
		JDBCUtils.close(con, sta, rs);
		return u;
		}
	}

	@Override
	public boolean UpdatePassword(int id, String passwd) {
		boolean result=false;
		con=JDBCUtils.getConnection();
		String sql="update user set user_pwd=? where user_id=?";
		try {
			sta=con.prepareStatement(sql);
			sta.setString(1,passwd);
			sta.setInt(2,id);
			int i=sta.executeUpdate();
			if(i!=0){
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
	public User findUserById(int id) {
		User u=null;
		con=JDBCUtils.getConnection();
		String sql="select * from user where user_id=?";
		try {
			sta=con.prepareStatement(sql);
			sta.setInt(1,id);
			rs=sta.executeQuery();
			if(rs.next()){
				u=new User();
				u.setUser_id(id);
				u.setUser_name(rs.getString(2));
				u.setUser_state(rs.getInt(5));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JDBCUtils.close(con,sta,rs);
			return u;
		}
	}
	
	@Override
	public boolean coldUserById(int id) {
		boolean result=false;
		con=JDBCUtils.getConnection();
		String sql="update user set user_state=1 where user_id=?";
		try {
			sta=con.prepareStatement(sql);
			sta.setInt(1,id);
			int num=sta.executeUpdate();
			if(num>0){
				result=true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JDBCUtils.close(con, sta, null);
		    return result;
		}
	}

	@Override
	public List<User> findAll() {
		List<User> users=new ArrayList<User>();
		User u=null;
		con=JDBCUtils.getConnection();
		String sql="select * from user";
		try {
			sta=con.prepareStatement(sql);
			rs=sta.executeQuery();
			while(rs.next()){
				u=new User();
				u.setUser_id(rs.getInt(1));
				u.setUser_name(rs.getString(2));
				u.setUser_type(rs.getInt(4));
				u.setUser_state(rs.getInt(5));
				users.add(u);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JDBCUtils.close(con, sta, rs);
		    return users;
		}
	}	
}
