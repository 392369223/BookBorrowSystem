package com.booksystem.dao;

import java.util.List;

import com.booksystem.entity.Report;

public interface ReportDao {
    //实现举报的方法
	public boolean report(Report report);
	//查询举报的所有信息
	public List<Report> findAll();
}
