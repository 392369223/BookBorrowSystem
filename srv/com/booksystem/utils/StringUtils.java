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
    	result=result+"��Ϣid: "+port.getPort_id()+"\n";
    	result=result+"����Աid:"+port.getPortsenderid()+"\n";
    	result=result+"����ʱ��:"+simple.format(port.getPort_time())+"\n";
    	result=result+"��������:"+port.getPort_content();
    	
    	return result;
    }
    public static String parseComment(Comment comment){
    	SimpleDateFormat simple=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    	String result="";
    	result=result+"�û�id:"+comment.getCommentUserid()+"\n";
    	result=result+"����ʱ��:"+simple.format(comment.getCommentTime())+"\n";
    	result=result+"��������:"+comment.getCommentContent()+"\n";
		return result;
    }
}
