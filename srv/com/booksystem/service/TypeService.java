package com.booksystem.service;

import java.util.List;

import com.booksystem.entity.Type;

public interface TypeService {
	//����ͼ������
	public boolean addType(Type type);
	//�������е���Ϣ
	public List<String> findAll();
	//����ѡ�е����ݲ���id
	public int getId(String content);
	//�������е�����
	public List<Type> findAll2();
}
