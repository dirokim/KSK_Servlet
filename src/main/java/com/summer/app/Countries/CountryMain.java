package com.summer.app.Countries;

public class CountryMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		CountryDAO countryDAO = new CountryDAO();
		try {
			countryDAO.getList();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
