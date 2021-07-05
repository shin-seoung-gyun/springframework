package org.zerock.mapper;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.BoardVO;

import lombok.extern.log4j.Log4j;

@Log4j
@RunWith(SpringJUnit4ClassRunner.class)//j유닛 사용할때 스프링을 사용하겠다.
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")//스프링 관련 설정 위치 지정
public class BoardMapperTests {
	
	@Autowired
	private BoardMapper mapper;
	
	@Test
	public void testGetList() {
		
//		List<BoardVO> list = mapper.getList();
//		for (BoardVO temp:list) {
//			log.info(temp);
//		}
		mapper.getList().forEach(board->log.info(board));
	}
	
	@Test
	public void testInsert() {
		BoardVO board = new BoardVO();
		board.setTitle("새로작성하는글");
		board.setContent("새로 작성하는 내용");
		board.setWriter("newbie");
		
		mapper.insert(board);
		log.info(board);
	}
	
	@Test
	public void testInsertSelectKey() {
		BoardVO board = new BoardVO();
		board.setTitle("새로작성하는글");
		board.setContent("새로 작성하는 내용");
		board.setWriter("newbie");
		
		mapper.insertSelectKey(board);
		
		log.info("bno의 값은 = "+board.getBno());
		
	}
	
	@Test
	public void testRead() {
		log.info(mapper.read(3L));
	}
	
	@Test
	public void testDelete() {
		log.info("지워진 글 개수"+mapper.delete(10L));
	}
	
	
	@Test
	public void testUpdate() {
		BoardVO board = new BoardVO();
		board.setBno(2L);
		board.setTitle("수정중");
		board.setContent("수정내용");
		
		log.info("수정된 글 개수"+mapper.update(board));
		
	}
	
	@Test
	public void testRanking() {
		log.info(mapper.ranking());
		
	}
	
		
}
