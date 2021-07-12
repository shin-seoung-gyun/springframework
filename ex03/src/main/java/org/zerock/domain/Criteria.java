package org.zerock.domain;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString

public class Criteria {
	private int pageNum;
	private int amount;
	
	//검색조건 추가
	private String type; //검색 조건
	private String keyword;//키워드
	
	public Criteria() {
//		this.pageNum = 1;
//		this.amount = 10;
		this(1,10);
	}
	
	public Criteria(int pageNum,int amount) {
		this.pageNum=pageNum;
		this.amount = amount;
	}
	
	public String[] getTypeArr() {//검색 선택
		return type == null ? new String[] {} :type.split("");
		
	}
	
	
	
	
	
	
}
