package shin.mit.sample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component
public class A {
//의존성을 주입하는 3가지 방법
//필드,메소드(세터),생성자
//	@Autowired
	private Sub sub;
//	@Autowired
//	public void setSub(Sub sub) {
//		this.sub = sub;
//	}
	//4.3부터는 @Autowired없이도 자동 주입됨.
//	@Autowired
	public A(Sub sub) {
		super();
		this.sub = sub;
	}
	
	
	
	@Override
	public String toString() {
		return "A [sub=" + sub + "]";
	}

	
	
}
