package com.booksystem.service;

import java.util.List;

import com.booksystem.entity.User;

public interface UserService {
	     //登陆
		public User Login(String username,String pwd,int power);
		//注册
		public User Register(String username,String pwd);
		//修改密码
		public boolean UpdatePassword(int id,String passwd);
		//根据用户id查询用户信息
		public User findUserById(int id);
		//根据用户id冻结用户
		public boolean coldUserById(int id);
		//查找所有用户的信息
		public List<User> findAll();
}
