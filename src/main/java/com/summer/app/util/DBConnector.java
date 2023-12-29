package com.summer.app.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBConnector {

	public static Connection getConnector() throws Exception {
		String user="user01";
		String password="user01";
		String url="jdbc:oracle:thin:@15.164.166.26:1521:xe";
		String driver = "oracle.jdbc.driver.OracleDriver";

			Class.forName(driver);

			Connection con = DriverManager.getConnection(url, user, password);

			return con;
			
		}
	public static void disConnect(ResultSet rs, PreparedStatement ps ,Connection con) throws Exception {
		rs.close();
		ps.close();
		con.close();
	}
	public static void disConnect(PreparedStatement ps,Connection con) throws Exception{
		ps.close();
		con.close();
	}
}
