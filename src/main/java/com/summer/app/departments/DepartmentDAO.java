package com.summer.app.departments;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.summer.app.util.DBConnector;

public class DepartmentDAO {
	//getDetail, 부서번호로 부서정보 조회'
	
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
