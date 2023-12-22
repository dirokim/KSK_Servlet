package com.summer.app.Test;

import java.util.List;

import com.summer.app.departments.DepartmentDAO;
import com.summer.app.regions.RegionDAO;
import com.summer.app.regions.RegionDTO;
import com.summer.app.util.DBConnector;
import com.summer.app.views.View;

public class AppMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			DepartmentDAO dao= new DepartmentDAO();
			RegionDAO regionDAO = new RegionDAO();
			View view = new View();
			
			try {
//				List<RegionDTO> ar = regionDAO.getList();
//				view.regionview(ar);
				
				RegionDTO regionDTO = new RegionDTO();
				regionDTO.setRegion_id(1);
				regionDTO = regionDAO.getDetail(regionDTO);
				
				if(regionDTO!=null) {
					System.out.println(regionDTO.getRegion_id());
					
				}else {
					System.out.println("없는 ID입니다");
				}
				
				
				
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				
			
		
	}

}
