package com.booksystem.test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.booksystem.dao.ReportDao;
import com.booksystem.dao.Impl.ReportDaoImpl;
import com.booksystem.entity.Report;

public class TestReport {
	
    public static void main(String[] args) {
		ReportDao dao=new ReportDaoImpl();
		/*Report report=new Report();
		report.setUserid(2);
		report.setBuserid(1);
		report.setMytime(new Date());
		report.setReason("发表不良信息");
		boolean r=dao.report(report);
		System.out.println(r);*/
		List<Report> all = dao.findAll();
		SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		for(int i=0;i<all.size();i++){
			System.out.println(format.format(all.get(i).getMytime()));
		}
	}
}
