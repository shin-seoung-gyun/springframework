package org.zerock.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.zerock.domain.NumVO;
import org.zerock.domain.Quiz5;
import org.zerock.domain.SampleVO;
import org.zerock.domain.Ticket;

import lombok.extern.log4j.Log4j;

@RestController
@Log4j
@RequestMapping("/sample")
public class SampleController {

	@GetMapping(value = "/getText", produces = "text/plain; charset=UTF-8")
	public String getText() {
		log.info("MIME TYPE:" + MediaType.TEXT_PLAIN_VALUE);
		return "안녕하세요";
	}

	@GetMapping(value = "/getSample", produces = { MediaType.APPLICATION_JSON_UTF8_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public SampleVO getSample() {
		return new SampleVO(112, "스타", "로드");
	}

	@GetMapping(value = "/getList") // 자동 xml,json변환 라이브러리는 꼭 있어야함.
	public List<SampleVO> getList() {
		List<SampleVO> list = new ArrayList<SampleVO>();
		for (int i = 1; i <= 10; i++) {
			SampleVO vo = new SampleVO(i, i + "First", i + "Last");
			list.add(vo);
		}
		return list;

	}

	// check?height=156&weight=50
	@GetMapping(value = "/check", params = { "height", "weight" }) // 상태코드 바꾸기.
	public ResponseEntity<SampleVO> check(Double height, Double weight) {
		SampleVO vo = new SampleVO(0, "" + height, "" + weight);// 문자열+숫자 = 문자열

		ResponseEntity<SampleVO> result = null;

		if (height < 150) {
			result = ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(vo);
		} else {
			result = ResponseEntity.status(HttpStatus.OK).body(vo);
		}

		return result;
	}

	// product/bags/1234
	@GetMapping("/product/{cat}/{pid}")
	public String[] getPath(@PathVariable("cat") String cat, @PathVariable("pid") Integer pid) {
		String[] temp = new String[] { "category:" + cat, "productId:" + pid };
		return temp;
	}

	@PostMapping("/ticket")
	public Ticket convert(@RequestBody Ticket ticket) {
		log.info("json수집된 결과" + ticket);
		return ticket;
	}

	@GetMapping("/allsum/{num1}/{num2}")
	public ResponseEntity<String> allsum(@PathVariable("num1") int num1, @PathVariable("num2") int num2) {

		ResponseEntity<String> result = null;
		try {
			int sum = 0;
			for (int i = num1; i <= num2; i++) {
				sum += i;
			}
			if (num1 < num2) {
				result = new ResponseEntity<>(Integer.toString(sum), HttpStatus.OK);
			} else {
				result = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		} catch (Exception e) {
			e.printStackTrace();
			result = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return result;
	}

	@GetMapping("/sum/{num1}/{num2}/{num3}")
	public NumVO sum(@PathVariable("num1") int num1, @PathVariable("num2") int num2,
			@PathVariable("num3") int num3) {
		
//		ResponseEntity<String> result = null;
//		int cnt = 0;
//		int[] intAry = { num1, num2, num3 };
//		for (int i = 0; i < intAry.length; i++) {
//			int num = intAry[i];
//			if (num == 2) {
//				cnt++;
//				continue;
//			}
//			for (int j = 2; j < num; j++) {
//				if (num % j == 0) {
//					break;
//				} else {
//					if (j == num/2 + 1) {
//						cnt++;
//						break;
//					}
//				}
//			}
//		}
//		result = new ResponseEntity<>(Integer.toString(cnt), 
//				HttpStatus.INTERNAL_SERVER_ERROR);
		NumVO vo = new NumVO(num1, num2, num3);
		return vo;
		
	}
	
//	@GetMapping("/quiz5/{no}")
//	public Quiz5 quiz5() {
//		Quiz5 vo = new Quiz5();
//		
//		return vo;
//	}
	
	@PostMapping(value="/quiz6",produces = "text/plain; charset=UTF-8")
	public String quiz6(@RequestBody Quiz5 vo) {
		log.info(vo);
		return "ok";
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
