package com.booksystem.service;

import java.util.List;

import com.booksystem.entity.Port;

public interface PortService {
	//������Ϣ
    public boolean sendMessage(int id,String message);
    //������Ϣ
    public List<Port> findAll();
}
