package com.summer.app.JobHistory;

public class JobhistoryMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		JobhistoryDTO jobhistoryDTO = new JobhistoryDTO();
		JobhistoryDAO jobhistoryDAO = new JobhistoryDAO();
		jobhistoryDTO.setJob_id("sumthing");
		try {
			jobhistoryDTO = jobhistoryDAO.getDetail(jobhistoryDTO);
			if(jobhistoryDTO!=null) {
				System.out.println(jobhistoryDTO.getJob_id());
				
			}else {
				System.out.println("그런 아이디 없습니다");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
