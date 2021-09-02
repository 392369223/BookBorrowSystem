package com.booksystem.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;

import org.junit.Test;

import com.booksystem.utils.JDBCUtils;

public class TestAffairs {
	private Connection con;
	private PreparedStatement sta;
	private ResultSet rs;
	//@Test
	public void test1(){
		con=JDBCUtils.getConnection();
		String sql="insert into test values(?,?)";
		String sql2="inser into test values(?,?)";
		Savepoint point=null;
		//关闭事务提交
		try {
			con.setAutoCommit(false);
			sta=con.prepareStatement(sql);
			sta.setInt(1,3);
			sta.setString(2, "中文");
			sta.executeUpdate();
			point=con.setSavepoint();
			int i=1/0;
			sta=con.prepareStatement(sql2);
			sta.setInt(1,4);
			sta.setString(2, "英文");
			sta.executeUpdate();
			con.commit();
		} catch (Exception e) {
			try {
				//System.out.println("事务回滚");
				if(point!=null){
					System.out.println("事务提交前");
				    con.rollback(point);
				    con.commit();
				    System.out.println("事务提交后");
				}else{
					con.rollback();
				}
				//System.out.println("事务完毕");
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
	}
	@Test
	public void test2(){
		con=JDBCUtils.getConnection();
		String sql="insert into test values(?,?)";
		String sql2="inser into test values(?,?)";
		Savepoint point=null;
		//关闭事务提交
		try {
			con.setAutoCommit(false);
			sta=con.prepareStatement(sql);
			sta.setInt(1,5);
			sta.setString(2, "中文");
			sta.executeUpdate();
			int i=1/0;
			sta=con.prepareStatement(sql2);
			sta.setInt(1,6);
			sta.setString(2, "英文");
			sta.executeUpdate();
			con.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
