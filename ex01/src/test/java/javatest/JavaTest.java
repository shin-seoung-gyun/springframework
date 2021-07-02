package javatest;

import lombok.extern.log4j.Log4j;

@Log4j
public class JavaTest {
	int a;
	
	
	public void sum() {
		//1~10까지 더하기
		int sum =0;
		for (int i=1; i<=10; i++) {
			sum += i;
		}
		log.info(sum);
	}
}
