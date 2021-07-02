package shin.mit.sample;

import org.springframework.stereotype.Component;

import lombok.Data;


@Component
@Data
public class Di {
	private String str = "나는 의존성 객체" ;
}
