package com.booksystem.service.Impl;

import java.util.List;

import com.booksystem.dao.UserDao;
import com.booksystem.dao.Impl.UserDaoImpl;
import com.booksystem.entity.User;
import com.booksystem.service.UserService;

public class UserServiceImpl implements UserService{
     UserDao userdao=new UserDaoImpl();
	@Override
	public User Login(String username, String pwd, int power) {
		return userdao.Login(username, pwd, power);
	}

	@Override
	public User Register(String username, String pwd) {
		return userdao.Register(username, pwd);
	}

	@Override
	public boolean UpdatePassword(int id, String passwd) {
		// TODO Auto-generated method stub
		return userdao.UpdatePassword(id, passwd);
	}

	@Override
	public User findUserById(int id) {
		return userdao.findUserById(id);
	}

	@Override
	public boolean coldUserById(int id) {
		return userdao.coldUserById(id);
	}

	@Override
	public List<User> findAll() {
		return userdao.findAll();
	}
}
