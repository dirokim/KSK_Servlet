package com.summer.app.Jobs;

public class JobMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JobDTO jobDTO = new JobDTO();
		JobDAO jobDAO = new JobDAO();
		
		try {
			jobDTO.setJob_id("이게맞나");
			jobDTO = jobDAO.getDetail(jobDTO);
			if(jobDTO!=null) {
				System.out.println(jobDTO.getJob_id());
			}else {
				System.out.println("그런 아이디 없습니다");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}
