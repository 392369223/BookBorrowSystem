package com.booksystem.service;

import java.util.List;

import com.booksystem.entity.Report;

public interface ReportService {
	//ʵ�־ٱ��ķ���
	public boolean report(Report report);
	//��ѯ�ٱ���������Ϣ
	public List<Report> findAll();
}
