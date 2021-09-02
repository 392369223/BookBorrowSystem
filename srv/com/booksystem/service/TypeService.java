package com.booksystem.service;

import java.util.List;

import com.booksystem.entity.Type;

public interface TypeService {
	//增加图书类型
	public boolean addType(Type type);
	//查找所有的信息
	public List<String> findAll();
	//根据选中的内容查找id
	public int getId(String content);
	//查找所有的类型
	public List<Type> findAll2();
}
