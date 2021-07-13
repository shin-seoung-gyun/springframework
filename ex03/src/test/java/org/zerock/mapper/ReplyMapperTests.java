package org.zerock.mapper;

import java.util.stream.IntStream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.Criteria;
import org.zerock.domain.ReplyVO;

import lombok.extern.log4j.Log4j;

@Log4j
@RunWith(SpringJUnit4ClassRunner.class)//j유닛 사용할때 스프링을 사용하겠다.
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class ReplyMapperTests {

	@Autowired//필드주입 junit 생성자 주입 안됨
	private ReplyMapper mapper;
	
	@Test
	public void testMapper() {
		log.info(mapper);
	}
	
	@Test
	public void testInsert() throws Exception {
		
		ReplyVO vo = new ReplyVO();
		vo.setBno(1277970L);
		vo.setReply("댓글 junit을통한 테스트");
		vo.setReplyer("테스터훈");
		mapper.insert(vo);
	}
	
	@Test
	public void testInsert2() {
		Long[] bnoArr = {1277970L,1277969L,1277968l };
					//range(1,11)
		IntStream.rangeClosed(1, 10).forEach(i-> {
			ReplyVO vo = new ReplyVO();
			vo.setBno(bnoArr[i%3]);
			vo.setReply("댓글 junit을통한 테스트"+i);
			vo.setReplyer("테스터i");
			try {
				mapper.insert(vo);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		});
		
		//같은 코드
//		Long[] bnoArr = {1277970L,1277969L,1277968l };
//		for(int i = 1; i<=10; i++) {
//			ReplyVO vo = new ReplyVO();
//			vo.setBno(bnoArr[i%3]);
//			vo.setReply("댓글 junit을통한 테스트"+i);
//			vo.setReplyer("테스터i");
//			mapper.insert(vo);
//		}
		
	}
	
	@Test
	public void testRead() {
		log.info(mapper.read(2L));
	}
	
	@Test
	public void testUpdate() {
		ReplyVO vo = new ReplyVO();
		vo.setRno(3L);
		vo.setReply("업데이트 테스트2");
		
		log.info(mapper.update(vo));
	}
	
	@Test
	public void testDelete() {
		log.info(mapper.delete(3L));
		
	}
	
	@Test
	public void testGetListWithPaging() {
		Criteria cri = new Criteria();
		Long bno = 1277970L;
		log.info(mapper.getListWithPaging(cri, bno));
	}
	
	
}
