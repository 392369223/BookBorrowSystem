package com.booksystem.service.Impl;

import java.util.List;

import com.booksystem.dao.PortDao;
import com.booksystem.dao.Impl.PortDaoImpl;
import com.booksystem.entity.Port;
import com.booksystem.service.PortService;

public class PortServiceImpl implements PortService{
	PortDao portdao=new PortDaoImpl();
	@Override
	public boolean sendMessage(int id, String message) {
		return portdao.sendMessage(id, message);
	}
	@Override
	public List<Port> findAll() {
		// TODO Auto-generated method stub
		return portdao.findAll();
	} 
}
