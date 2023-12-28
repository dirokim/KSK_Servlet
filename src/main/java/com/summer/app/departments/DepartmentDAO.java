package com.summer.app.departments;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.summer.app.Employees.EmployeeDTO;
import com.summer.app.util.DBConnector;

import oracle.jdbc.proxy.annotation.Pre;

public class DepartmentDAO {
	//getDetail, 부서번호로 부서정보 조회'
	
	
	public void test() {
		String sql = "SELECT D.* ,E.FIRST_NAME"
				+ " FROM DEPARTMENTS D"
				+ " INNER JOIN EMPLOYEES E "
				+ " ON D.DEPARTMENT_ID = E.DEPARTMENT_ID"
				+ " WHERE D.DEPARTMENT_ID = 20";
		ResultSet rs = null;
		while(rs.next()) {
			DepartmentDTO departmentDTO = new DepartmentDTO();
			EmployeeDTO employeeDTO = new EmployeeDTO();
			
		}
	}
	
	
	
	
	public int update(DepartmentDTO departmentDTO) throws Exception {
		Connection con =  DBConnector.getConnector();
		String sql="UPDATE DEPARTMENTS SET DEPARTMENT_NAME =? ,MANAGER_ID =?,LOCATION_ID = ? WHERE DEPARTMENT_ID =?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, departmentDTO.getDepartment_name());
		ps.setInt(2, departmentDTO.getManager_id());
		ps.setInt(3, departmentDTO.getLocation_id());
		ps.setInt(4, departmentDTO.getDepartment_id());
		int result = ps.executeUpdate();
		DBConnector.disConnect(ps, con);
		return result;
		}
	
	public int add(DepartmentDTO departmentDTO)throws Exception{
		Connection con = DBConnector.getConnector();
		String sql = "INSERT DEPARTMENTS VALUES(?,?,NULL,?)";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, departmentDTO.getDepartment_id());
		ps.setString(2,departmentDTO.getDepartment_name() );
		ps.setInt(3, departmentDTO.getManager_id());
		ps.setInt(4,departmentDTO.getLocation_id());
		
		int result = ps.executeUpdate();
		DBConnector.disConnect(ps, con);
		return result;
		
	}
	
	public DepartmentDTO getDetail(DepartmentDTO departmentDTO) throws Exception {
		Connection con = DBConnector.getConnector();
		String sql="SELECT * FROM DEPARTMENTS WHERE DEPARTMENT_ID =?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, departmentDTO.getDepartment_id());
		ResultSet rs = ps.executeQuery();
		DepartmentDTO resultDTO = null;
		if(rs.next()) {
			resultDTO = new DepartmentDTO();
			resultDTO.setDepartment_id(rs.getInt("DEPARTMENT_ID"));
			resultDTO.setDepartment_name(rs.getString("DEPARTMENT_NAME"));
			resultDTO.setLocation_id(rs.getInt("LOCATION_ID"));
			resultDTO.setManager_id(rs.getInt("MANAGER_ID"));
			
			
		}
		DBConnector.disConnect(rs, ps, con);
		return resultDTO;
	}
	
	
	
	public ArrayList<DepartmentDTO> getList() throws Exception {
	
	Connection con =DBConnector.getConnector();
			String sql="SELECT * FROM DEPARTMENTS";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery(sql);
			ArrayList<DepartmentDTO> ar = new ArrayList<DepartmentDTO>();
			
			while(rs.next()) {
				DepartmentDTO dto = new DepartmentDTO();
				dto.setDepartment_id(rs.getInt("DEPARTMENT_ID"));
				dto.setDepartment_name(rs.getString("DEPARTMENT_NAME"));
				dto.setLocation_id(rs.getInt("LOCATION_ID"));
				dto.setManager_id(rs.getInt("MANAGER_ID"));
				ar.add(dto);
			}
			DBConnector.disConnect(rs, ps, con);
			return ar;
	}
	

	
	
	
	
}
