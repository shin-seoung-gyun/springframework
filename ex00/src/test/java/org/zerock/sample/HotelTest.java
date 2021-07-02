package org.zerock.sample;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
@RunWith(SpringJUnit4ClassRunner.class)//j유닛 사용할때 스프링을 사용하겠다.
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")//스프링 관련 설정 위치 지정
public class HotelTest {
	
	@Setter(onMethod_ = @Autowired)
	private SampleHotel hotel;
	
	@Test
	public void testExist() {
		assertNotNull(hotel);
		log.info(hotel.getChef());
		
		
		
		
	}
	
	
}
