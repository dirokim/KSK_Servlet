package com.summer.app.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBConnector {
	//1. IP:PORT 
	//2. ID,PW 
	public void getConnector() {
		String user="user01";
		String password="user01";
		String url="jdbc:oracle:thin:@15.164.104.100:1521:xe";
		String driver = "oracle.jdbc.driver.OracleDriver";
		
		//1.드라이버를 메모리에 로딩  (객체 생성)오라클 드라이버에 객체생성
		try {
			Class.forName(driver);
			//2.DB 연결
			Connection con = DriverManager.getConnection(url, user, password);
			//3.Sql문 생성
			String sql="SELECT * FROM REGIONS";
			//4.SQL문 미리전송 
			PreparedStatement st = con.prepareStatement(sql); //미리전송
			//5.
			//6.최종 전송 및 결과 처리 
			ResultSet rs = st.executeQuery(); //최종적으로 쿼리문을 실행해라
			while(rs.next()) {
				//rs= 1.Europe
			int n =	rs.getInt(1);
			String name = rs.getString(2);
			System.out.println(n+":"+name);
			System.out.println("====================");
			}
			
			
			
			System.out.println(con);
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		
		
		
		
	}
}
