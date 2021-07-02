package org.zerock.sample;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.Setter;
import lombok.extern.log4j.Log4j;


@RunWith(SpringJUnit4ClassRunner.class)//j유닛 사용할때 스프링을 사용하겠다.
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")//스프링 관련 설정 위치 지정
@Log4j
public class SampleTests {
	
	@Setter(onMethod_=@Autowired)//롬복에서 지원하는 세터
	private Restaurant restaurant;

	@Test
	public void testExist() {
		log.info("junit 테스트");
//		restaurant = new Restaurant();
//		if (restaurant == null) {
//			log.info("null이다");
//		} else {
//			log.info("null 아님");
//		}
		assertNotNull(restaurant);//테스트로 null이면 실패가 뜨게하는 junit 매서드
		log.info(restaurant.getChef());
	}
	@Test
	public void testpring() {
		log.info("에러남");
	}
}
