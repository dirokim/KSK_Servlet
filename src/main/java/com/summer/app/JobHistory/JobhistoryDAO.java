package com.summer.app.JobHistory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.summer.app.util.DBConnector;

public class JobhistoryDAO {
	
	public int update(JobhistoryDTO jobhistoryDTO) throws Exception {
		Connection con = DBConnector.getConnector();
		String sql= "UPDATE JOB_HISTORY SET START_DATE=?,END_DATE=?,JOB_ID=?,DEPARTMENT_ID=? WHERE EMPLOYEE_ID=? ";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setDate(1, jobhistoryDTO.getStart_date());
		ps.setDate(2, jobhistoryDTO.getEnd_date());
		ps.setString(3,jobhistoryDTO.getJob_id());
		ps.setInt(4, jobhistoryDTO.getDepartment_id());
		ps.setInt(5, jobhistoryDTO.getEmployee_id());
		int result = ps.executeUpdate();
		DBConnector.disConnect(ps, con);
		return result;
		
	}
	public int add(JobhistoryDTO jobhistoryDTO) throws Exception {
		Connection con = DBConnector.getConnector();
		String sql = "INSERT INTO JOB_HISTORY VALUES (?,?,?,?,?)";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1,jobhistoryDTO.getEmployee_id() );
		ps.setDate(2, jobhistoryDTO.getStart_date());
		ps.setDate(3, jobhistoryDTO.getEnd_date());
		ps.setString(4,jobhistoryDTO.getJob_id());
		ps.setInt(5, jobhistoryDTO.getDepartment_id());
		int result = ps.executeUpdate();
		DBConnector.disConnect(ps, con);
		return result;
		
	
	}
	

	public JobhistoryDTO getDetail(JobhistoryDTO jobhistoryDTO) throws Exception {
		Connection con =  DBConnector.getConnector();
		String sql= "SELECT * FROM JOBHISTORY WHERE JOB_ID = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, jobhistoryDTO.getJob_id());
		ResultSet rs = ps.executeQuery();
		JobhistoryDTO resultDTO=null;
		if(rs.next()) {
			resultDTO.setJob_id(rs.getString("JOB_ID"));
			resultDTO.setEmployee_id(rs.getInt("EMPLOYEE_ID"));
			resultDTO.setStart_date(rs.getInt("START_DATE"));
			resultDTO.setDepartment_id(rs.getInt("DEPARTMENT_ID"));
			resultDTO.setEnd_date(rs.getInt("END_DATE"));
		}
		DBConnector.disConnect(rs, ps, con);
		return resultDTO;
	}
	
	public ArrayList<JobhistoryDTO> getList() throws Exception {
		Connection con = DBConnector.getConnector();
		String sql = "SELECT * FROM JOB_HISTORY";
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		ArrayList<JobhistoryDTO>ar = new ArrayList<JobhistoryDTO>();
		
		while(rs.next()) {
			JobhistoryDTO jobhistoryDTO = new JobhistoryDTO();
			jobhistoryDTO.setEmployee_id(rs.getInt("EMPLOYEE_ID"));
			jobhistoryDTO.setStart_date("SRART_DATE");
			jobhistoryDTO.setEnd_date(rs.getInt("END_DATE"));
			jobhistoryDTO.setJob_id(rs.getString("JOB_ID"));
			jobhistoryDTO.setDepartment_id(rs.getInt("DEPARTMENT_ID"));
			
			ar.add(jobhistoryDTO);
			}
		DBConnector.disConnect(rs, ps, con);
		return ar;
}
}