package com.summer.app.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBConnector {
	//1. IP:PORT 
	//2. ID,PW 
	public static Connection getConnector() throws Exception {
		String user="user01";
		String password="user01";
		String url="jdbc:oracle:thin:@15.164.104.100:1521:xe";
		String driver = "oracle.jdbc.driver.OracleDriver";
		
		//1.드라이버를 메모리에 로딩  (객체 생성)오라클 드라이버에 객체생성
	
			Class.forName(driver);
			//2.DB 연결
			Connection con = DriverManager.getConnection(url, user, password);
			//3.Sql문 생성
			return con;
			
		}
	public static void disConnect(ResultSet rs, PreparedStatement ps ,Connection con) throws Exception {
		rs.close();
		ps.close();
		con.close();
	}
}
