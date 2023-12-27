package com.summer.app.Employees;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.summer.app.util.DBConnector;

public class EmployeeDAO {
	
	public int update(EmployeeDTO employeeDTO) throws Exception{
		Connection con = DBConnector.getConnector();
		String sql="UPDATE EMPLOYEES SET EMPLOYEE_ID=?,FIRST_NAME=?,LAST_NAME=?,EMAIL=?,PHONE_NUMBER=?,HIRE_DATE,JOB_ID,SALARY=?,JOB_ID=?,SALARY=?,COMMISSION_PCT,MANAGER_ID=? WHERE DEPARTMENT_ID=?";
	}
	
	
	//사원 추가
	public int add(EmployeeDTO employeeDTO) throws Exception{
		Connection con = DBConnector.getConnector();
		String sql="INSERT INTO EMPLOYEES"+
		" VALUES(?,?,?,?,?,?,?,?,?,?,?)";
	
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, employeeDTO.getEmployee_id());
		ps.setString(2,employeeDTO.getFirst_name());
		ps.setString(3, employeeDTO.getLast_name());
		ps.setString(4, employeeDTO.getEmail());
		ps.setString(5, employeeDTO.getPhone_number());
		ps.setDate(6,employeeDTO.getHire_date());
		ps.setString(7, employeeDTO.getJob_id());
		ps.setInt(8, employeeDTO.getSalary());
		ps.setInt(9, employeeDTO.getCommission_pct());
		ps.setInt(10,employeeDTO.getManager_id());
		ps.setInt(11, employeeDTO.getDepartment_id());
		
		
		int result = ps.executeUpdate();
		DBConnector.disConnect(ps, con);
		
		return result;
	
	}
	
	//사원의 급여의 합계를 가지고 오자 
	public Map<String, Integer> getSalary()throws Exception {
		Map<String, Integer> map = new HashMap<String, Integer>();
		Connection con = DBConnector.getConnector();
		String sql = "SELECT SUM(SALARY) AS S,COUNT(EMPLOYEE_ID) AS E FROM EMPLOYEES";
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		rs.next();
		int sum = rs.getInt("S");
		int count = rs.getInt("E"); 
		map.put("count", count);
		map.put("sum", sum);
		
		DBConnector.disConnect(rs, ps, con);
		return map;
	}
	
	public EmployeeDTO getDetail(EmployeeDTO employeeDTO) throws Exception {
		Connection con = DBConnector.getConnector();
		String sql = "SELECT * FROM EMPLOYEES WHERE EMPLOYEE_ID=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, employeeDTO.getEmployee_id());
		ResultSet rs = ps.executeQuery();
		EmployeeDTO resultDTO = null;
		if(rs.next()) {
//			resultDTO = new EmployeeDTO();
//			resultDTO.setEmployee_id(rs.getInt("EMPLOYEE_ID"));
//			resultDTO.setDepartment_id(rs.getInt("DEPARTMENT_ID"));
//			resultDTO.setLocation_id(rs.getInt("LOCATION_ID"));
//			resultDTO.setCountry_id(rs.getInt("COUNTRY_ID"));
//			resultDTO.setResion_id(rs.getInt("RESION_ID"));
			employeeDTO.setEmployee_id(rs.getShort("FIRST_NAME"));
		}else {
			employeeDTO=null;
			
		}
		
		DBConnector.disConnect(rs, ps, con);
		
		return employeeDTO;
		
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
