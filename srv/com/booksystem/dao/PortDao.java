package com.booksystem.dao;

import java.util.List;

import com.booksystem.entity.Port;

public interface PortDao {
    //������Ϣ
	public boolean sendMessage(int id,String message);
	//��ѯ��������
	public List<Port> findAll();
}
