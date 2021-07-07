package org.zerock.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.zerock.mapper.BoardMapperTests;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
@RunWith(SpringJUnit4ClassRunner.class)//j유닛 사용할때 스프링을 사용하겠다.
@ContextConfiguration({"file:src/main/webapp/WEB-INF/spring/root-context.xml",
	"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"})//서버사용 테스트는 이걸로
@WebAppConfiguration
public class BoardControllerTests {
	
	@Autowired
	private WebApplicationContext ctx;
	
	private MockMvc mockMvc;
	
	@Before
	public void setup() {
		mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build();
	}
	
	@Test
	public void testList() throws Exception{
		log.info(mockMvc.perform(MockMvcRequestBuilders.get("/board/list"))
		.andReturn()
		.getModelAndView()
		.getModelMap());
	}
	
	@Test
	public void testRegister() throws Exception{
		log.info(mockMvc.perform(MockMvcRequestBuilders
				.post("/board/register")
				.param("title","컨트롤러 테스트")
				.param("content","test 내용")
				.param("writer","user00"))
				.andReturn()
				.getModelAndView()
				.getViewName());
	}
	
	
	@Test
	public void testGet() throws Exception {
		log.info(mockMvc.perform(MockMvcRequestBuilders
				.get("/board/get")
				.param("bno", "7"))
				.andReturn()
				.getModelAndView()
				.getModelMap());
	}
	
	@Test
	public void testModify() throws Exception{
		log.info(mockMvc.perform(MockMvcRequestBuilders
				.post("/board/modify")
				.param("title","컨트롤러 테스트12")
				.param("content","test 내용12")
				.param("bno","7"))
				.andReturn()
				.getModelAndView()
				.getViewName());
	}
	
	@Test
	public void testRemove() throws Exception{
		log.info(mockMvc.perform(MockMvcRequestBuilders
				.post("/board/remove")
				.param("bno","9"))
				.andReturn()
				.getModelAndView()
				.getViewName());
	}
	
	
	@Test
	public void testRankList() throws Exception{
		log.info(mockMvc.perform(MockMvcRequestBuilders.post("/board/rank"))
		.andReturn()
		.getModelAndView()
		.getModelMap());
	}
	
	
	@Test
	public void testListPage() throws Exception{
		log.info(mockMvc.perform(MockMvcRequestBuilders.get("/board/list").param("pageNum", "10").param("amount", "20"))
		.andReturn()
		.getModelAndView()
		.getModelMap());
	}
	
	
	
	
	
	
	
	
}
