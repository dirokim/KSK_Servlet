package com.summer.app.Test;

import java.util.List;
import java.util.Map;

import com.summer.app.Employees.EmployeeDAO;
import com.summer.app.departments.DepartmentDAO;


public class AppMain {

	public static void main(String[] args) {

			EmployeeDAO dao = new EmployeeDAO();
		
			try {
				Map<String, Integer> map = dao.getSalary();
				System.out.println(map.get("sum"));
				System.out.println(map.get("count"));
				System.out.println(map);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	}

}
