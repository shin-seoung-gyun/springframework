package shin.mit.initblock;

import org.junit.Test;

import lombok.extern.log4j.Log4j;

@Log4j
public class ATest {

	@Test
	public void test1() {
		A a1 = new A(1);
		A a2 = new A();
		log.info(a1);
		log.info(a2);
	}
}
