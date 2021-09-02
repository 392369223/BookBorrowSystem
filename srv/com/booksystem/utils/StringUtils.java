package com.booksystem.utils;

import java.text.SimpleDateFormat;

import com.booksystem.entity.Comment;
import com.booksystem.entity.Port;

public class StringUtils {
    public static boolean isEmpty(String str){
    	if(str!=null&&(!str.equals(""))){
    		return false;
    	}else{
    		return true;
    	}
    }
    public static String parse(Port port){
    	SimpleDateFormat simple=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    	String result="";
    	result=result+"消息id: "+port.getPort_id()+"\n";
    	result=result+"管理员id:"+port.getPortsenderid()+"\n";
    	result=result+"发送时间:"+simple.format(port.getPort_time())+"\n";
    	result=result+"发送内容:"+port.getPort_content();
    	
    	return result;
    }
    public static String parseComment(Comment comment){
    	SimpleDateFormat simple=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    	String result="";
    	result=result+"用户id:"+comment.getCommentUserid()+"\n";
    	result=result+"评论时间:"+simple.format(comment.getCommentTime())+"\n";
    	result=result+"评论内容:"+comment.getCommentContent()+"\n";
		return result;
    }
}
