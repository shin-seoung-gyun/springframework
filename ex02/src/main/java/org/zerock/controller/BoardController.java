package org.zerock.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.zerock.domain.BoardVO;
import org.zerock.service.BoardService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import oracle.jdbc.proxy.annotation.GetProxy;

@Controller
@Log4j
@RequestMapping("/board/*")
@AllArgsConstructor
public class BoardController {
	
	private BoardService service;
	
	@GetMapping("/list")
	public void list(Model model) {
		log.info("목록페이지요청");
		model.addAttribute("list",service.getList());
	}
	
	@PostMapping("/register")
	public String register(BoardVO board) {
		//글 등록 후 list페이지로 돌아감
		service.register(board);
		
		//처리결과 보내기 (나중에)
		
		return "redirect:/board/list";
		
	}
	
	@GetMapping("/get")
	public void get(Long bno, Model model) {
		log.info("상세글 보기 요청");
		model.addAttribute("board",service.get(bno));
			
	}
	
	
	
	@PostMapping("/modify")
	public String modify(BoardVO board) {
		log.info("수정 요청중");
		service.modify(board);
			
		return "redirect:/board/list";
	}
	
	
	@PostMapping("/remove")
	public String remove(Long bno) {
		log.info("삭제요청");
		service.remove(bno);
		return "redirect:/board/list";
	}
	
	@PostMapping("/rank")
	public String rank() {
		log.info("랭크 요청중");
		service.ranking();
			
		return "redirect:/board/list";
	}
		
	
	
	
	
	
	
	
	
	
	
	
	

}
