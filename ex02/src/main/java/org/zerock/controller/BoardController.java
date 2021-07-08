package org.zerock.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;
import org.zerock.domain.PageDTO;
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
	public void list(Model model, Criteria cri) {
		log.info("목록페이지요청");
		model.addAttribute("list",service.getList(cri));
		model.addAttribute("pageMaker",new PageDTO(cri,service.getTotal(cri)));
	}
	
	@PostMapping("/register")
	public String register(BoardVO board, RedirectAttributes rttr, Criteria cri) {
		//글 등록 후 list페이지로 돌아감
		service.register(board); 
		rttr.addFlashAttribute("result", board.getBno());
		rttr.addAttribute("pageNum",cri.getPageNum());
		rttr.addAttribute("amount",cri.getAmount());
		//처리결과 보내기 (나중에)
		
		return "redirect:/board/list?";
		
	}
	@GetMapping("/register")//등록페이지 열기
	public void register(Criteria cri, Model model) {
		model.addAttribute("cri",cri);
	}
		
	@GetMapping("/get")
	public void get(Long bno, Model model, Criteria cri) {
		log.info("상세글 보기 요청");
		model.addAttribute("board",service.get(bno));
		model.addAttribute("cri",cri);
			
	}
	
	@GetMapping("/modify")
	public void modify(Long bno, Model model,Criteria cri) {
		model.addAttribute("board",service.get(bno));
		model.addAttribute("cri",cri);
	}
	
	@PostMapping("/modify")
	public String modify(BoardVO board, RedirectAttributes rttr, Criteria cri) {
		log.info("수정 요청중");
		service.modify(board);
		log.info(cri);
		rttr.addFlashAttribute("result2", board.getBno());//모달창 데이터
		
		
		rttr.addAttribute("pageNum",cri.getPageNum());
		rttr.addAttribute("amount",cri.getAmount());
		rttr.addAttribute("type",cri.getType());
		rttr.addAttribute("keyword",cri.getKeyword());
		
		
		return "redirect:/board/list?";
	}
	
	
	@PostMapping("/remove")
	public String remove(Long bno, RedirectAttributes rttr, Criteria cri) {
		log.info("삭제요청");
		service.remove(bno);
		rttr.addFlashAttribute("result3", bno);//모달창
		
		
		rttr.addAttribute("pageNum",cri.getPageNum());
		rttr.addAttribute("amount",cri.getAmount());
		rttr.addAttribute("type",cri.getType());
		rttr.addAttribute("keyword",cri.getKeyword());
		return "redirect:/board/list?";
	}
	
	@GetMapping("/rank")
	public void rank(Model model) {
		log.info("랭크 요청중");
		model.addAttribute("ranking", service.ranking());
	}
		
	
	
	
	
	
	
	
	
	
	
	
	

}
