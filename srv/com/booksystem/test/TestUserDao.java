package com.booksystem.test;

import com.booksystem.dao.UserDao;
import com.booksystem.dao.Impl.UserDaoImpl;
import com.booksystem.entity.User;

public class TestUserDao {
	private UserDao userdao=new UserDaoImpl();
	//@org.junit.Test
    public void testReg(){
    	User u=userdao.Register("admin", "123456");
    	System.out.println(u);
    }
    
    public void testLogin(){
        User u=userdao.Login("admin","123456",0);
        System.out.println(u);
    }
    //@org.junit.Test
    public void testUpdate(){
    	boolean b=userdao.UpdatePassword(1,"1234");
    	System.out.println(b);
    }
    //@org.junit.Test
    public void testUpdate2(){
    	boolean b=userdao.coldUserById(1);
    	System.out.println(b);
    }
    @org.junit.Test
    public void find(){
    	User u=userdao.findUserById(1);
    	System.out.println(u);
    }
}
