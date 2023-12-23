package com.summer.app.Jobs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.summer.app.util.DBConnector;

public class JobDAO {
	public void getDetail(JobDTO jobDTO) throws Exception {
		Connection con =  DBConnector.getConnector();
		String sql ="SELECT * FROM JOBS WHERE JOBS_ID = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, jobDTO.getJob_id());
		ResultSet rs = ps.executeQuery();
		
	}
	

	public ArrayList<JobDTO> getlist() throws Exception {
		
		Connection con = DBConnector.getConnector();
		String sql="SELECT * FROM JOBS";
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		ArrayList<JobDTO> ar = new ArrayList<JobDTO>();
		
		while(rs.next()) {
			JobDTO jobDTO = new JobDTO();
			jobDTO.setJob_id(rs.getString("JOB_ID"));
			jobDTO.setJob_title(rs.getString("JOB_TITLE"));
			jobDTO.setMin_salary(rs.getInt("MIN_SALARY"));
			jobDTO.setMax_salary(rs.getShort("MAX_SALARY"));
			ar.add(jobDTO);
		}
		
		DBConnector.disConnect(rs, ps, con);
		return ar;
		
		
	}

	
}
