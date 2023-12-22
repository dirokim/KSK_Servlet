package com.summer.app.views;

import java.util.List;

import com.summer.app.departments.DepartmentDTO;
import com.summer.app.regions.RegionDTO;

public class View {
	
	public void regionview(List<RegionDTO> ar) {
		//Regions 를 출력
		//아이디 이름 
		for(RegionDTO regionDTO:ar) {
			System.out.println(regionDTO.getRegion_id()+":"+regionDTO.getRegion_name());
			System.out.println("===============================");
		}
		
	}
	public void departmentview(List<DepartmentDTO> ar) {
		for(DepartmentDTO departmentDTO:ar) {
			System.out.println(departmentDTO.getDepartment_name()+":"+departmentDTO.getDepartment_id()+departmentDTO.getLocation_id()+departmentDTO.getManager_id());
		}
	}
}
