package com.summer.app.Locations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.summer.app.util.DBConnector;

public class LocationDAO {

	
	
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
			locationDTO.setRegion_id(rs.getInt("REGION_ID"));
			ar.add(locationDTO);
			
		}
		DBConnector.disConnect(rs, ps, con);
		return ar;
	}
}