package shin.mit.sample;

import org.springframework.stereotype.Component;

@Component
public class Sub {
	private String str = "나는 의존성 객체 입니다.";

	@Override
	public String toString() {
		return "Sub [str=" + str + "]";
	}
}
