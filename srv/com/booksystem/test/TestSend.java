package com.booksystem.test;

import org.junit.Test;

import com.booksystem.dao.PortDao;
import com.booksystem.dao.UserDao;
import com.booksystem.dao.Impl.PortDaoImpl;
import com.booksystem.dao.Impl.UserDaoImpl;

public class TestSend {
	//@Test
    public void testsend(){
    	PortDao portdao=new PortDaoImpl();
    	boolean result=portdao.sendMessage(1,"ฮาบÜบร");
    	System.out.println("result:"+result);
    }
    @Test
    public void testUpdate(){
    	UserDao userdao=new UserDaoImpl();
    	System.out.println(userdao.UpdatePassword(1, "abc"));
    }
}
