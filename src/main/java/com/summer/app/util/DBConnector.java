package com.summer.app.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBConnector {
	//1. IP:PORT 
	//2. ID,PW 
	//�뒪�뀒�떛 �꽑�뼵�빐�꽌  �깮�왂媛��뒫 !!
	public static Connection getConnector() throws Exception {
		String user="user01";
		String password="user01";
		String url="jdbc:oracle:thin:@15.164.104.100:1521:xe";
		String driver = "oracle.jdbc.driver.OracleDriver";
		
		//1.�뱶�씪�씠踰꾨�� 硫붾え由ъ뿉 濡쒕뵫  (媛앹껜 �깮�꽦)�삤�씪�겢 �뱶�씪�씠踰꾩뿉 媛앹껜�깮�꽦
			Class.forName(driver);
			//2.DB �뿰寃�
			Connection con = DriverManager.getConnection(url, user, password);
			//3.Sql臾� �깮�꽦
			return con;
			
		}
	public static void disConnect(ResultSet rs, PreparedStatement ps ,Connection con) throws Exception {
		rs.close();
		ps.close();
		con.close();
	}
}
