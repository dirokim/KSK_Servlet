package com.summer.app.Locations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.summer.app.util.DBConnector;

public class LocationDAO {
	
	public void update() throws Exception {
		Connection con = DBConnector.getConnector();
		String sql ="UPDATE LOCATIONS SET LOCATION_ID=? , COUNTRY_ID=?, STREET_ADDRESS=?,POSTAL_CODE=?,CITY=?,STATE_PROVINCE=?";
		
	}

	public int add(LocationDTO locationDTO) throws Exception {
		Connection con =  DBConnector.getConnector();
		String sql = "INSERT INTO LOCATIONS VALUES(?,?,?,?,?,?)";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, locationDTO.getLocation_id());
		ps.setInt(2, locationDTO.getCountry_id());
		ps.setString(3, locationDTO.getStreet_address());
		ps.setString(4, locationDTO.getPostal_code());
		ps.setString(5,	locationDTO.getCity());
		ps.setString(6, locationDTO.getState_province());
		int result = ps.executeUpdate();
		DBConnector.disConnect(ps, con);
		return result;
	}
	
	public LocationDTO getDetail(LocationDTO locationDTO) throws Exception {
		Connection con = DBConnector.getConnector();
		String sql ="SELECT * FROM LOCATIONS WHERE LOCATION_ID = ?"; //sql 인젝션 대비 
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, locationDTO.getLocation_id());
		ResultSet rs = ps.executeQuery();
		
		LocationDTO resultDTO = null;
		if(rs.next()) {
			resultDTO.setLocation_id(rs.getInt("LOCATION_ID"));
			resultDTO.setCountry_id(rs.getInt("COUNTRY_ID"));
			resultDTO.setStreet_address(rs.getString("STREET_ADDRESS"));
			resultDTO.setPostal_code(rs.getString("POSTAL_CODE"));
			resultDTO.setCity(rs.getString("CITY"));
			resultDTO.setState_province(rs.getString("STATE_PROVINCE"));
			
		}
		DBConnector.disConnect(rs, ps, con);
		return resultDTO;
		
	}
	
	
	public ArrayList<LocationDTO> getList() throws Exception {
		Connection con = DBConnector.getConnector();
		String sql = "SELECT * FROM LOCATIONS";
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		ArrayList<LocationDTO> ar = new ArrayList<LocationDTO>();
		
		while(rs.next()) {
			LocationDTO locationDTO = new LocationDTO();
			locationDTO.setLocation_id(rs.getInt("LOCATIONS_ID"));
			locationDTO.setCountry_id(rs.getInt("COUNTRY_ID"));
			locationDTO.setStreet_address(rs.getString("STREET_ADDRESS"));
			locationDTO.setPostal_code(rs.getString("POSTAL_CODE"));
			locationDTO.setCity(rs.getString("CITY"));
			locationDTO.setState_province("STATE_PROVINCE");
			ar.add(locationDTO);
		}
		DBConnector.disConnect(rs, ps, con);
		return ar;
	}
}
