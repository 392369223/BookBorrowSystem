package com.booksystem.dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.booksystem.dao.ReportDao;
import com.booksystem.entity.Report;
import com.booksystem.utils.JDBCUtils;

public class ReportDaoImpl implements ReportDao{
	private Connection con;
	private PreparedStatement sta;
	private ResultSet rs;
	@Override
	public boolean report(Report report) {
		boolean result=false;
		con=JDBCUtils.getConnection();
		String sql="insert into report(userid,buserid,reason,mytime) values(?,?,?,?)";
		try {
			sta=con.prepareStatement(sql);
			sta.setInt(1,report.getUserid());
			sta.setInt(2, report.getBuserid());
			sta.setString(3, report.getReason());
			sta.setTimestamp(4, new Timestamp(report.getMytime().getTime()));
			int num=sta.executeUpdate();
			if(num>0){
				result=true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JDBCUtils.close(con, sta,null);
		    return result;
		}
	}
	@Override
	public List<Report> findAll() {
		List<Report> reports=new ArrayList<Report>();
		Report report=null;
		con=JDBCUtils.getConnection();
		String sql="select * from report order by mytime desc";
		try {
			sta=con.prepareStatement(sql);
			rs=sta.executeQuery();
			while(rs.next()){
				report=new Report();
				report.setReportid(rs.getInt(1));
				report.setUserid(rs.getInt(2));
				report.setBuserid(rs.getInt(3));
				report.setMytime(new Date(rs.getTimestamp(5).getTime()));
				report.setReason(rs.getString(4));
				reports.add(report);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JDBCUtils.close(con, sta,rs);
		    return reports;
		}
	}

}
