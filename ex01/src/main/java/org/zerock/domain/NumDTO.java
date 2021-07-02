package org.zerock.domain;

import lombok.Data;

@Data
public class NumDTO {
	private int num1;
	private int num2;
	private int num3;
	public int result() {
		return num1+num2+num3;
	}
	public int result2() {
		int result = 0;
		for (int i =num1; i<=num2;i++) {
			result += i;
		}
		
		return result;
	}
}
