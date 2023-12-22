package com.summer.app.JobHistory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.summer.app.util.DBConnector;

public class JobhistoryDAO {

	
	public ArrayList<JobhistoryDTO> getList() throws Exception {
		Connection con = DBConnector.getConnector();
		String sql = "SELECT * FROM JOB_HISTORY";
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		ArrayList<JobhistoryDTO>ar = new ArrayList<JobhistoryDTO>();
		
		while(rs.next()) {
			JobhistoryDTO jobhistoryDTO = new JobhistoryDTO();
			jobhistoryDTO.setEmployee_id(rs.getInt("EMPLOYEE_ID"));
			jobhistoryDTO.setStart_date(rs.getInt("START_DATE"));
			jobhistoryDTO.setEnd_date(rs.getInt("END_DATE"));
			jobhistoryDTO.setJob_id(rs.getString("JOB_ID"));
			jobhistoryDTO.setDepartment_id(rs.getInt("DEPARTMENT_ID"));
			
			ar.add(jobhistoryDTO);
			}
		DBConnector.disConnect(rs, ps, con);
		return ar;
}
}