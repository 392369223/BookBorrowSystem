package com.booksystem.dao;

import java.util.List;

import com.booksystem.entity.Report;

public interface ReportDao {
    //ʵ�־ٱ��ķ���
	public boolean report(Report report);
	//��ѯ�ٱ���������Ϣ
	public List<Report> findAll();
}
