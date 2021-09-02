package com.booksystem.service;

import java.util.List;

import com.booksystem.entity.Port;

public interface PortService {
	//发送信息
    public boolean sendMessage(int id,String message);
    //接收消息
    public List<Port> findAll();
}
