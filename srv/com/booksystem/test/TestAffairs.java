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
		//�ر������ύ
		try {
			con.setAutoCommit(false);
			sta=con.prepareStatement(sql);
			sta.setInt(1,3);
			sta.setString(2, "����");
			sta.executeUpdate();
			point=con.setSavepoint();
			int i=1/0;
			sta=con.prepareStatement(sql2);
			sta.setInt(1,4);
			sta.setString(2, "Ӣ��");
			sta.executeUpdate();
			con.commit();
		} catch (Exception e) {
			try {
				//System.out.println("����ع�");
				if(point!=null){
					System.out.println("�����ύǰ");
				    con.rollback(point);
				    con.commit();
				    System.out.println("�����ύ��");
				}else{
					con.rollback();
				}
				//System.out.println("�������");
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
		//�ر������ύ
		try {
			con.setAutoCommit(false);
			sta=con.prepareStatement(sql);
			sta.setInt(1,5);
			sta.setString(2, "����");
			sta.executeUpdate();
			int i=1/0;
			sta=con.prepareStatement(sql2);
			sta.setInt(1,6);
			sta.setString(2, "Ӣ��");
			sta.executeUpdate();
			con.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
