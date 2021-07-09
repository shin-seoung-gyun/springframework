package org.zerock.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.zerock.domain.SampleVO;

import lombok.extern.log4j.Log4j;

@RestController
@Log4j
@RequestMapping("/sample")
public class SampleController {
	
	@GetMapping(value="/getText",produces="text/plain; charset=UTF-8")
	public String getText() {
		log.info("MIME TYPE:" +MediaType.TEXT_PLAIN_VALUE);
		return "안녕하세요";
	}
	
	
	@GetMapping(value="/getSample", produces=
			{MediaType.APPLICATION_JSON_UTF8_VALUE, 
	   		 MediaType.APPLICATION_XML_VALUE})
	public SampleVO getSample() {
		return new SampleVO(112,"스타","로드");
	}
	
	@GetMapping(value="/getList")
	public List<SampleVO> getList(){
		List<SampleVO> list = new ArrayList<SampleVO>();
		for (int i = 1 ; i<=10;i++) {
			SampleVO vo = new SampleVO(i,i+"First",i+"Last");
			list.add(vo);
			
		}
		return list;
		
	}
	
}
