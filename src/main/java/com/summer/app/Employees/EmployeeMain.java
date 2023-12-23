package com.summer.app.Employees;

public class EmployeeMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		EmployeeDAO dao = new EmployeeDAO();
		EmployeeDTO dto = new EmployeeDTO();
		dto.setEmployee_id(1);
		
		try {
			dto = dao.getDetail(dto);
			if(dto!=null) {
				System.out.println(dto.getEmployee_id());
			}else {
				System.out.println("그런 아이디 없습니다.");
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
