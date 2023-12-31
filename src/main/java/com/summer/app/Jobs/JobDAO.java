package com.summer.app.Jobs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.summer.app.util.DBConnector;

public class JobDAO {
	
	
	public int update(JobDTO jobDTO) throws Exception {
		Connection con = DBConnector.getConnector();
		String sql = "UPDATE JOBS SET JOB_TITLE=?,MAX_SALARY=?,MIN_SALARY=? WHERE JOB_ID=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1,jobDTO.getJob_title() );
		ps.setInt(2, jobDTO.getMax_salary());
		ps.setInt(3, jobDTO.getMin_salary());
		ps.setString(4, jobDTO.getJob_id());
		int result = ps.executeUpdate();
		DBConnector.disConnect(ps, con);
		return result;
	}
	
	
	public int add (JobDTO jobDTO) throws Exception {
		Connection con = DBConnector.getConnector();
		String sql = "INSERT INTO JOBS VALUE(?,?,?,?) ";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(0, jobDTO.getJob_id());
		ps.setString(0, jobDTO.getJob_title());
		ps.setInt(0, jobDTO.getMax_salary());
		ps.setInt(0, jobDTO.getMin_salary());
		int result = ps.executeUpdate();
		DBConnector.disConnect(ps, con);
		return result;
		
	}
	
	public JobDTO getDetail(JobDTO jobDTO) throws Exception {
		Connection con =  DBConnector.getConnector();
		String sql ="SELECT * FROM JOBS WHERE JOBS_ID = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, jobDTO.getJob_id());
		ResultSet rs = ps.executeQuery();
		JobDTO resultDTO = null;
		if(rs.next()) {
			resultDTO.setJob_id(rs.getString("JOB_ID"));
			resultDTO.setJob_title(rs.getString("JOB_TITLE"));
			resultDTO.setMax_salary(rs.getInt("MAX_SALARY"));
			resultDTO.setMin_salary(rs.getInt("MIN_SALARY"));
			
		}
		DBConnector.disConnect(rs, ps, con);
		return resultDTO;
		
	}
	

	public ArrayList<JobDTO> getList() throws Exception {
		
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
