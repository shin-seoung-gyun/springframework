package shin.mit.sample;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.ToString;
import lombok.extern.log4j.Log4j;

@Log4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@ToString
public class TestA1 {
	
//	@Autowired
	private A a;
	
//	@Autowired
//	public void setA(A a) {
//		this.a = a;
//	}

	@Test
	public void Test1() {
		
		log.info(a);
	}


}
