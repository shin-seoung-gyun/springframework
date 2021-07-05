package org.zerock.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.BoardVO;
import org.zerock.mapper.BoardMapperTests;

import lombok.extern.log4j.Log4j;

@Log4j
@RunWith(SpringJUnit4ClassRunner.class)//j유닛 사용할때 스프링을 사용하겠다.
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class BoardServiceTests {
	
	@Autowired
	private BoardService service;
	
	@Test
	public void testRegister() {
		BoardVO board = new BoardVO();
		board.setTitle("새로작성하는글1");
		board.setContent("새로 작성하는 내용1");
		board.setWriter("newbie1");
		service.register(board);
	}
	
	@Test
	public void testGet() {
		service.get(4L);
	}
	@Test
	public void testModify() {
		BoardVO board = new BoardVO();
		board.setBno(2L);
		board.setTitle("수정중1");
		board.setContent("수정내용2");
		service.modify(board);
	}
	
	@Test
	public void testGetList() {
		
		service.getList().forEach(board->log.info(board));
	}
	
	@Test
	public void testRemove() {
		
		service.remove(5L);
	}
	
	
	
	
	
	
	
}
