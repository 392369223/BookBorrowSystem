package com.booksystem.dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.booksystem.dao.PortDao;
import com.booksystem.entity.Port;
import com.booksystem.utils.JDBCUtils;

public class PortDaoImpl implements PortDao{
	private Connection con;
	private PreparedStatement sta;
	private ResultSet rs;
	@Override
	public boolean sendMessage(int id,String message) {
		boolean result=false;
		con=JDBCUtils.getConnection();
		String sql="insert into port(port_senderid,port_content,port_time) values(?,?,?)";
		try {
			sta=con.prepareStatement(sql);
			sta.setInt(1, id);
			sta.setString(2, message);
			Date d=new Date();
			Timestamp stamp=new Timestamp(d.getTime());
			sta.setTimestamp(3, stamp);
			int i=sta.executeUpdate();
			if(i!=0){
				result=true;
				return result;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JDBCUtils.close(con, sta, rs);
		    return result;
		}
	}
	@Override
	public List<Port> findAll() {
		List<Port> ports=new ArrayList<Port>();
		Port port=null;
		String sql="select * from port order by port_id desc";
		con=JDBCUtils.getConnection();
		try {
			sta=con.prepareStatement(sql);
			rs=sta.executeQuery();
			while(rs.next()){
				port=new Port();
				port.setPort_id(rs.getInt(1));
				port.setPortsenderid(rs.getInt(2));
				port.setPort_content(rs.getString(3));
				port.setPort_time(new Date(rs.getTimestamp(4).getTime()));
				ports.add(port);
		    }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JDBCUtils.close(con, sta, rs);
		    return ports;
		}
	}
}
