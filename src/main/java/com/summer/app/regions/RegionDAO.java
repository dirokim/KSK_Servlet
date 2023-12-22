package com.summer.app.regions;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.spi.DirStateFactory.Result;

import com.summer.app.util.DBConnector;

public class RegionDAO {
	
	
	public RegionDTO getDetail(RegionDTO regionDTO) throws Exception{
		Connection con = DBConnector.getConnector();
		String sql = "SELECT * FROM REGIONS WHERE REGION_ID=?";
		PreparedStatement st = con.prepareStatement(sql);
		st.setInt(1, regionDTO.getRegion_id());   //sql 인젝션 대비 
		ResultSet rs = st.executeQuery();
		RegionDTO resultDTO=null;
		
		if(rs.next()) {
			resultDTO = new RegionDTO();
			resultDTO.setRegion_id(rs.getInt("REGION_ID"));
			resultDTO.setRegion_name(rs.getString("REGION_NAME"));
		}
		
		return resultDTO;
		}
			
	
	
	
	

	public List<RegionDTO> getList() throws Exception {
			Connection con = DBConnector.getConnector();
			
			String sql="SELECT * FROM REGIONS";
			//4.SQL문 미리전송 
			PreparedStatement st = con.prepareStatement(sql); //미리전송
			//5.
			//6.최종 전송 및 결과 처리 
			ResultSet rs = st.executeQuery(); //최종적으로 쿼리문을 실행해라
			List<RegionDTO> ar =new ArrayList<RegionDTO>();
			while(rs.next()) {
				//rs= 1.Europe
			RegionDTO regionDTO = new RegionDTO();
			int n =	rs.getInt("REGION_ID");
			regionDTO.setRegion_id(n); 
			regionDTO.setRegion_name(sql); String name = rs.getString("REGION_NAME");
			ar.add(regionDTO);
			}
			
			System.out.println(con);
			
			DBConnector.disConnect(rs, st, con);
			return ar;
		
	}
}