package com.summer.app.Employees;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.summer.app.util.DBConnector;

public class EmployeeDAO {
	
	
	public EmployeeDTO getDetail(EmployeeDTO employeeDTO) throws Exception {
		Connection con = DBConnector.getConnector();
		String sql = "SELECT * FROM EMPLOYEES WHERE EMPLOYEE_ID=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, employeeDTO.getEmployee_id());
		ResultSet rs = ps.executeQuery();
		EmployeeDTO resultDTO = null;
		if(rs.next()) {
			resultDTO = new EmployeeDTO();
			resultDTO.setEmployee_id(rs.getInt("EMPLOYEE_ID"));
			resultDTO.setDepartment_id(rs.getInt("DEPARTMENT_ID"));
			resultDTO.setLocation_id(rs.getInt("LOCATION_ID"));
			resultDTO.setCountry_id(rs.getInt("COUNTRY_ID"));
			resultDTO.setResion_id(rs.getInt("RESION_ID"));
			
		}
		DBConnector.disConnect(rs, ps, con);
		
		return resultDTO;
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
