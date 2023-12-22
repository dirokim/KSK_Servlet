package com.summer.app.departments;

import java.util.ArrayList;
import java.util.List;

import com.summer.app.views.View;

public class DepartmentMain {

	public static void main(String[] args) {
		DepartmentDAO dao = new DepartmentDAO();
		DepartmentDTO departmentDTO = new DepartmentDTO();
		View view = new View();
		try {
			ArrayList<DepartmentDTO>ar= dao.getList();
			view.departmentview(ar);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
