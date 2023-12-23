package com.summer.app.Employees;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.summer.app.util.DBConnector;

public class EmployeeDAO {
	
	
	public void getDetail() throws Exception {
		Connection con = DBConnector.getConnector();
		String sql = "SELECT * FROM EMPLOYEES WHERE EMPLOYEE_ID=?";
		
	}
	
	
	public ArrayList<EmployeeDTO> getList() throws Exception {
		Connection con = DBConnector.getConnector();
		
		String sql = "SELECT * FROM  EMPLOYEES";
		
		PreparedStatement ps = con.prepareStatement(sql);
		
		ResultSet rs = ps.executeQuery();
		
		ArrayList<EmployeeDTO> ar = new ArrayList<EmployeeDTO>();
		
		while(rs.next()) {
			EmployeeDTO employeeDTO = new EmployeeDTO();
			employeeDTO.setLocation_id(rs.getInt("LOCATION_ID"));
			employeeDTO.setCountry_id(rs.getInt("COUNTRY_ID"));
			employeeDTO.setResion_id(rs.getInt("REGION_ID"));
			employeeDTO.setDepartment_id(rs.getInt("DEPARTMENT_ID"));
			employeeDTO.setEmployee_id(rs.getInt("EMPLOYEE_id"));
			
			ar.add(employeeDTO);
			}
		DBConnector.disConnect(rs, ps, con);
		return ar;
		
		
		
	}
	
}
