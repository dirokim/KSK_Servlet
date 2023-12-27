package com.summer.app.Countries;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.summer.app.util.DBConnector;

import oracle.jdbc.proxy.annotation.Pre;



public class CountryDAO {
	public int update(CountryDTO countryDTO) throws Exception {
		Connection con = DBConnector.getConnector();
		String sql="UPDATE COUNTRRIES SET COUNTRY_NAME=?,REGION_ID=? WHERE COUNTRY_ID=?  ";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, countryDTO.getCountry_name());
		ps.setInt(2, countryDTO.getRegion_id());
		ps.setInt(3, countryDTO.getCountry_id());
		int result = ps.executeUpdate();
		DBConnector.disConnect(ps, con);
		return result;
	}
	
	public int add (CountryDTO countryDTO) throws Exception {
		Connection con = DBConnector.getConnector();
		String sql="INSEART INTO COUNTRIES VALUES (?,?,?)";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, countryDTO.getCountry_id());
		ps.setString(2, countryDTO.getCountry_name());
		ps.setInt(3, countryDTO.getRegion_id());
		int result = ps.executeUpdate();
		
		DBConnector.disConnect(ps, con);
		
		return result;
		
		
	}
	
	
	
	public CountryDTO getDetail(CountryDTO countryDTO) throws Exception {
		Connection con = DBConnector.getConnector();
		String sql = "SELECT *FROM COUNTRIES WHERE COUNTRY_ID=?";
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setInt(1,countryDTO.getCountry_id()); //�씤�젥�뀡��鍮�
		ResultSet rs = st.executeQuery();
		
		CountryDTO resultDTO= null;
		
		if(rs.next()) {
			resultDTO = new CountryDTO();
			resultDTO.setCountry_id(rs.getInt("COUNTRY_ID"));
		
		}
		DBConnector.disConnect(rs, st, con);
			return resultDTO;
	}
	
	

	public ArrayList<CountryDTO> getList() throws Exception {
		
		Connection con = DBConnector.getConnector();
		String sql = "SELECT * FROM COUNTRIES";
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		ArrayList<CountryDTO> ar = new ArrayList<CountryDTO>();
		
		while(rs.next()) {
			CountryDTO countryDTO = new CountryDTO();
			countryDTO.setCountry_name(rs.getString("COUNTRY_NAME"));
			countryDTO.setCountry_id(rs.getInt("COUNTRY_ID"));
			countryDTO.setRegion_id(rs.getInt("REGION_ID"));
			ar.add(countryDTO);
		}
		DBConnector.disConnect(rs, ps, con);
	
		return ar;
	}



	
}
