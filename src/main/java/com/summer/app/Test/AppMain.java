package com.summer.app.Test;

import java.sql.Date;
import java.util.List;
import java.util.Map;

import com.summer.app.Employees.EmployeeDAO;
import com.summer.app.Employees.EmployeeDTO;
import com.summer.app.departments.DepartmentDAO;


public class AppMain {

	public static void main(String[] args) {

			EmployeeDAO dao = new EmployeeDAO();
			
			try {
			EmployeeDTO employeeDTO = new EmployeeDTO();
			employeeDTO.setEmployee_id(Integer.parseInt("207"));
			employeeDTO.setFirst_name(null);
			
			
			
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	}

}
