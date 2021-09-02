package com.booksystem.service;

import java.util.List;

import com.booksystem.entity.User;

public interface UserService {
	     //��½
		public User Login(String username,String pwd,int power);
		//ע��
		public User Register(String username,String pwd);
		//�޸�����
		public boolean UpdatePassword(int id,String passwd);
		//�����û�id��ѯ�û���Ϣ
		public User findUserById(int id);
		//�����û�id�����û�
		public boolean coldUserById(int id);
		//���������û�����Ϣ
		public List<User> findAll();
}
