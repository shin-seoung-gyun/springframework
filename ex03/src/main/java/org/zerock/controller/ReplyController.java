package org.zerock.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.zerock.domain.Criteria;
import org.zerock.domain.ReplyVO;
import org.zerock.service.ReplyService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@RestController
@Log4j
@RequestMapping("/replies")
@AllArgsConstructor
public class ReplyController {
	
	private ReplyService service;
	
	//등록
	@PostMapping(value="/new", consumes="application/json",
			produces= {MediaType.TEXT_PLAIN_VALUE})
	public ResponseEntity<String> create(@RequestBody ReplyVO vo){
		
		int insertCount;
		ResponseEntity<String> result = null;
		try {
			insertCount = service.register(vo);
			log.info("댓글 등록 개수:"+insertCount);
			if(insertCount==1) {
				result=new ResponseEntity<>("success",HttpStatus.OK);
			}else {
				result=new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		} catch (Exception e) {
			e.printStackTrace();
			result=new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return result;
	}
	
	//페이지
	// /replies/pages/:bno/:page  ex> /replies/pages/22/2 22번 페이지의 2번째 댓글 요청
	
	@GetMapping("/pages/{bno}/{page}")//xml과 json처리는 생략 가능
	public ResponseEntity<List<ReplyVO>> getList(@PathVariable("bno") Long bno,
												@PathVariable("page") int page	){
		Criteria cri = new Criteria(page,10);
		return new ResponseEntity<>(service.getList(cri, bno),HttpStatus.OK);
		
	}
	//조회(Get)
	//replies/:rno
	@GetMapping("/{rno}")
	public ReplyVO get(@PathVariable("rno") Long rno) {
		return service.get(rno);
	}
	
	//삭제(delete)
	//replies/:rno
	@DeleteMapping(value="/{rno}",produces= {MediaType.TEXT_PLAIN_VALUE})
	public ResponseEntity<String> remove(@PathVariable("rno") Long rno) {
		log.info("지우는컨트롤러");
		return service.remove(rno)==1 ? new ResponseEntity<>("success",HttpStatus.OK):
			new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
	
	//수정 (put or patch)
	//replies/:rno
	
	@RequestMapping(method = {RequestMethod.PUT,RequestMethod.PATCH},
			value="/{rno}", consumes="application/json",
			produces= {MediaType.TEXT_PLAIN_VALUE} )
	public ResponseEntity<String>  modify(@PathVariable("rno") Long rno,
			@RequestBody ReplyVO vo){
		vo.setRno(rno);
		
		
		return service.modify(vo)==1 ? new ResponseEntity<>("success",HttpStatus.OK):
			new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	
	
	
	
	
}
