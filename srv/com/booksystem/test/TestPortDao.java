package com.booksystem.test;

import java.util.List;

import com.booksystem.dao.PortDao;
import com.booksystem.dao.Impl.PortDaoImpl;
import com.booksystem.entity.Port;

public class TestPortDao {
	private PortDao portdao=new PortDaoImpl();
	//@org.junit.Test
    public void test1(){
    	boolean r=portdao.sendMessage(1,"�����1���û����͵���Ϣ");
    	System.out.println(r);
    }
    @org.junit.Test
    public void test2(){
    	List<Port> ports=portdao.findAll();
    	for(int i=0;i<ports.size();i++){
    		System.out.println(ports.get(i));
    	}
    }
}
