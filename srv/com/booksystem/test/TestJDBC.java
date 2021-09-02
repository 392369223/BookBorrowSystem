package com.booksystem.test;

import java.sql.Connection;
import java.sql.Timestamp;
import java.util.Date;

import org.junit.Test;

import com.booksystem.dao.Impl.*;
import com.booksystem.utils.JDBCUtils;

public class TestJDBC {
	//@Test
	public void test(){
		Connection con=JDBCUtils.getConnection();
		if(con!=null){
			System.out.println("连接成功");
		}else{
			System.out.println("连接失败");
		}
	}
	//@Test
	public void DateTest(){
		Date date = new Date();
		Timestamp timeStamp = new Timestamp(date.getTime());
		System.out.println(timeStamp);
	}
	//@Test
	public void LoginTest(){
		UserDaoImpl userdao=new UserDaoImpl();
		System.out.println(userdao.Login("adminm", "123456",0));
	}
	@Test
	public void test2(){
		UserDaoImpl userdao=new UserDaoImpl();
		System.out.println(userdao.Register("daa", "123456"));
	}
}
