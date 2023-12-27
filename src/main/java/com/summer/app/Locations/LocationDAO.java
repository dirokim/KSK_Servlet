package com.summer.app.Locations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.summer.app.util.DBConnector;

public class LocationDAO {

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
			resultDTO.setRegion_id(rs.getInt("REGION_ID"));
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
