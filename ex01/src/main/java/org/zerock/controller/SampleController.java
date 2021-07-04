package org.zerock.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.request;

import java.text.SimpleDateFormat;
import java.util.zip.DataFormatException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.method.annotation.RequestParamMethodArgumentResolver;
import org.zerock.domain.NumDTO;
import org.zerock.domain.SampleDTO;
import org.zerock.domain.TodoDTO;

import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/sample/*")
@Log4j
public class SampleController {
	
	@RequestMapping("aaa")
	public void basic() {
		log.info("aaa기본...");
		
	}
	
	@RequestMapping("bbb")
	public void basic2() {
		log.info("bbb기본...");
		
	}
	
	@RequestMapping("ex01")
	public void ex01(SampleDTO dto) {
		log.info("전송값 자동수집결과"+dto);
	}
	
	@RequestMapping("test1")
	public void test1(SampleDTO dto) {
		log.info("전송값 자동수집결과"+dto);
	}
	
	@RequestMapping("test2")
	public String test2(SampleDTO dto) {
		log.info("전송값 자동수집결과"+dto);
		
		return "redirect:/sample/test3";
	}
	@RequestMapping("test3")
	public void test3(Model model) {
		SampleDTO obj = new SampleDTO();
		obj.setName("ABC");
		obj.setAge(20);
		model.addAttribute(obj);
		
	}
	//////////////////////////////////////
	@RequestMapping("quiz1")
	public void quiz1() {
		
	}
	
	
	@RequestMapping("answer1")
	public String answer1(NumDTO obj,Model model) {
		int sum = obj.result();
		model.addAttribute(sum);
		return "/sample/answer2";
	}
	///////////////////////////////////////////////////
	@GetMapping("quiz2")
	public String quiz2() {
		return "/sample/quiz3";
	}
	
	
	@GetMapping("answer3")
	public void answer3(NumDTO obj, Model model) {
		int a = obj.result2();
		model.addAttribute("sum2",a);
	}
	
///////////////////////////////////////////////////
	@GetMapping("quiz3")
	public String quiz3() {
		return "redirect:/sample/quiz4";
	}
	@GetMapping("quiz4")
	public String quiz4() {
		return "/sample/quiz5";
	}
	
	@GetMapping("answer4")
	public String answer4(NumDTO obj) {

		return "/sample/answer5";
	}
	//////////////////////////////////////////////////////////
	@GetMapping("ex03")
	public void ex03() {

	}
	
//	@InitBinder
//	public void initBinder(WebDataBinder binder) {
//		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//		binder.registerCustomEditor(java.util.Date.class,  new CustomDateEditor(dateFormat,false));
//	}
	
	
	
	
	
	@GetMapping("ex031")
	public void ex031(TodoDTO todo) {
		log.info(todo);
		
	}
	
	
	@RequestMapping("ex06")
	public @ResponseBody SampleDTO ex06() {
		SampleDTO obj = new SampleDTO();
		obj.setName("ABC");
		obj.setAge(20);
		
		return obj;
	}
	
}
