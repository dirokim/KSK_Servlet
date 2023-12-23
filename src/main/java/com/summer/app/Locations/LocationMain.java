package com.summer.app.Locations;

public class LocationMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		LocationDTO locationDTO = new LocationDTO();
		LocationDAO locationDAO = new LocationDAO();
		
		try {
			locationDTO.setLocation_id(1);
			locationDTO = locationDAO.getDetail(locationDTO);
			if(locationDTO!=null) {
				System.out.println(locationDTO.getLocation_id());
				
			}else {
				System.out.println("그런 아이디 없습니다 ");
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
