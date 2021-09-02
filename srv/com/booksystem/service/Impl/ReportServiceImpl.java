package com.booksystem.service.Impl;

import java.util.List;

import com.booksystem.dao.ReportDao;
import com.booksystem.dao.Impl.ReportDaoImpl;
import com.booksystem.entity.Report;
import com.booksystem.service.ReportService;

public class ReportServiceImpl implements ReportService{
    ReportDao dao=new ReportDaoImpl();
	@Override
	public boolean report(Report report) {
		return dao.report(report);
	}
	@Override
	public List<Report> findAll() {
		return dao.findAll();
	}
    
}
