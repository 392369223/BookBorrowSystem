package com.booksystem.utils;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Iterator;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class JDBCUtils {
	   private static String url;
	    private static String user;
	    private static String passwd;
	    private static String driver;
	    @SuppressWarnings("finally")
		public static Connection getConnection() {
	        getSource();

	        Connection con = null;
	        try {
	            //加载驱动
	            Class.forName(driver);//反射
	        } catch (ClassNotFoundException e) {
	            e.printStackTrace();
	        }
	        try {
	            //System.out.println(url+"===="+user+"====="+passwd+"===="+driver);
	            con = DriverManager.getConnection(url,user,passwd);
	        } catch (SQLException throwables) {
	            throwables.printStackTrace();
	        }finally {
	            return con;
	        }
	    }
	    public static void close(Connection con, Statement sta, ResultSet s) {
	        if (con != null) {
	            try {
	                con.close();
	            } catch (SQLException throwables) {
	                throwables.printStackTrace();
	            }
	        }
	        try {
	            if (s != null) {
	                s.close();
	            }
	        } catch (SQLException throwables) {
	            throwables.printStackTrace();
	        }
	        if (sta != null) {
	            try {
	                sta.close();
	            } catch (SQLException throwables) {
	                throwables.printStackTrace();
	            }
	        }
	    }
	    public static void getSource(){
	        SAXReader sax=new SAXReader();
	        try {
	            Document document=sax.read(new File(JDBCUtils.class.getClassLoader().getResource("application.xml").getPath()));
	            //获取文档的根节点
	            Element rootElement = document.getRootElement();
	            //获取根节点下的所有子节点
	            Iterator i = rootElement.elementIterator();
	            //循环获取子节点
	            for (;i.hasNext();) {
	                //得到每一个子节点Element
	                Element element = (Element) i.next();
	                if(element.getName().equals("url")){
	                    url=element.getStringValue()+"?useUnicode=true&characterEncoding=utf-8";
	                }
	                if(element.getName().equals("username")){
	                    user=element.getStringValue();
	                }
	                if(element.getName().equals("password")){
	                    passwd=element.getStringValue();
	                }
	                if(element.getName().equals("driver")){
	                    driver=element.getStringValue();
	                }
	            }
	        } catch (DocumentException e) {
	            e.printStackTrace();
	        }
	    }

}
