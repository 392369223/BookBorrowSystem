package com.booksystem.dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.booksystem.dao.CommentDao;
import com.booksystem.entity.Comment;
import com.booksystem.utils.JDBCUtils;

public class CommentDaoImpl implements CommentDao{
	private Connection con;
	private PreparedStatement sta;
	private ResultSet rs;
	@Override
	public boolean publish(Comment comment) {
		con=JDBCUtils.getConnection();
		boolean result=false;
		String sql="insert into comment(commentUserid,commentBookid,commentContent,commentTime) "+
		"values(?,?,?,?)";
		try {
			sta=con.prepareStatement(sql);
			sta.setInt(1, comment.getCommentUserid());
			sta.setInt(2, comment.getCommentBookid());
			sta.setString(3,comment.getCommentContent());
			sta.setTimestamp(4, new Timestamp(comment.getCommentTime().getTime()));
		    int num=sta.executeUpdate();
		    if(num>0){
		    	result=true;
		    }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JDBCUtils.close(con, sta, rs);
		    return result;
		}
	}
	@Override
	public List<Comment> findAll(int id) {
		List<Comment> results=new ArrayList<Comment>();
		Comment comment=null;
		con=JDBCUtils.getConnection();
		String sql="select * from comment where commentBookid=? order by commentTime desc";
		try {
			sta=con.prepareStatement(sql);
			sta.setInt(1,id);
			rs=sta.executeQuery();
			while(rs.next()){
				comment=new Comment();
				comment.setCommentId(rs.getInt(1));
				comment.setCommentUserid(rs.getInt(2));
				comment.setCommentBookid(rs.getInt(3));
				comment.setCommentContent(rs.getString(4));
				comment.setCommentTime(new Date(rs.getTimestamp(5).getTime()));
				results.add(comment);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JDBCUtils.close(con, sta, rs);
		    return results;
		}
	}

}
