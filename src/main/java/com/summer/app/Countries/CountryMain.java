package com.summer.app.Countries;

public class CountryMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		CountryDAO countryDAO = new CountryDAO();
		try {
//			countryDAO.getList();
			CountryDTO countryDTO = new CountryDTO();
			countryDTO.setCountry_id(1);
			countryDTO = countryDAO.getDetail(countryDTO);
			
			if(countryDTO!=null) {
				System.out.println(countryDTO.getCountry_id());
		}else {
			System.out.println("그런 ID 가없습니다");
			System.out.println("이게맞나 싶다..");
		}
			} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
