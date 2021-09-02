package com.booksystem.service.Impl;

import java.util.List;

import com.booksystem.dao.TypeDao;
import com.booksystem.dao.Impl.TypeDaoImpl;
import com.booksystem.entity.Type;
import com.booksystem.service.TypeService;

public class TypeServiceImpl implements TypeService{
	TypeDao typedao=new TypeDaoImpl();
	@Override
	public boolean addType(Type type) {
		return typedao.addType(type);
	}
	@Override
	public List<String> findAll() {
		return typedao.findAll();
	}
	@Override
	public int getId(String content) {
		return typedao.getId(content);
	}
	@Override
	public List<Type> findAll2() {
		return typedao.findAll2();
	}
    
}
