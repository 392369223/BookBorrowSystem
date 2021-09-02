package com.booksystem.test;

import java.util.List;

import com.booksystem.dao.TypeDao;
import com.booksystem.dao.Impl.TypeDaoImpl;
import com.booksystem.entity.Type;

public class TestTypeDao {
	private TypeDao dao=new TypeDaoImpl();
	//@org.junit.Test
    public void testAdd(){
    	Type mytype=new Type();
    	mytype.setType_name("�ִ�");
    	mytype.setType_desc("��Ҫд�����ִ�����Ĺ���");
    	dao.addType(mytype);
    }
    //@org.junit.Test
    public void testFind(){
    	List<String> types=dao.findAll();
    	for(int i=0;i<types.size();i++){
    		System.out.println(types.get(i));
    	}
    }
    //@org.junit.Test
    public void test(){
    	int num=dao.getId("�ִ�");
    	System.out.println(num);
    }
}
