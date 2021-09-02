package com.booksystem.dao;

import java.util.List;

import com.booksystem.entity.Book;
import com.booksystem.entity.BookShow;
import com.booksystem.entity.BookShow2;

public interface BookDao {
    //��ѯû�б����ĵ�ͼ��
	public List<BookShow> findBook(int page,int line);
	//����ͼ�����Ʋ�ѯ
	public List<BookShow> findBookByLibName(String name,int page,int line);
	//�����������Ʋ�ѯ
	public List<BookShow> findBookByAutName(String name,int page,int line);
	//����ͼ�����ƺ��������Ʋ�ѯ
	public List<BookShow> findBookByAll(String name1,String name2,int page,int line);
	//��ѯû��������������
	public int findBookCount();
	//��ѯ��ͼ�����Ƶ�����
	public int findBookByLibName(String name);
	//��ѯ���������Ƶ�����
	public int findBookByAutName(String name);
	//��ѯ��ͼ����������Ƶ�����
	public int findBookByAll(String name1,String name2);
	//--��ѯͼ��id��Ӧ��ͼ��
	public BookShow findBook(int id);
	//--����ͼ����Ϣ����ͼ��
	public boolean addBook(Book book);
	//��ѯ
	public String findBookById(int id);
	//�������е�ͼ��
	public List<BookShow2> findAll();
}
