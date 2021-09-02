package com.booksystem.dao;

import java.util.List;

import com.booksystem.entity.Port;

public interface PortDao {
    //发送信息
	public boolean sendMessage(int id,String message);
	//查询所有请求
	public List<Port> findAll();
}
