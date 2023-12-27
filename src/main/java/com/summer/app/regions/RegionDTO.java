package com.summer.app.regions;

public class  RegionDTO {
	
	
	// 1. 모든 멤버 변수의 접근 지정자는 private;
	// 2. 모든 멤버 변수의 게터 getter setter 생성
	// 3. 생성자는 여러개 가능하지만 기본 생성자는 필수
	// 4. 멤버 변수의 이름과 Datatype은  DB의 Table의 컬럼명과 Datatype 일치 
	private Integer region_id;
	private String region_name;
	
	
	public Integer getRegion_id() {
		return region_id;
	}
	public void setRegion_id(Integer region_id) {
		this.region_id = region_id;
	}
	public String getRegion_name() {
		return region_name;
	}
	public void setRegion_name(String region_name) {
		this.region_name = region_name;
	}

	
	
	
	
}
