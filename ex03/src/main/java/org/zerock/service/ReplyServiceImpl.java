package org.zerock.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.zerock.domain.Criteria;
import org.zerock.domain.ReplyVO;
import org.zerock.mapper.ReplyMapper;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@AllArgsConstructor
@Log4j
@Service
public class ReplyServiceImpl implements ReplyService {
	
	private ReplyMapper mapper;
	
	
	@Override
	public int register(ReplyVO vo) throws Exception {
		log.info("댓글 등록 처리중"+vo);
		return mapper.insert(vo);
	}

	@Override
	public ReplyVO get(Long rno) {
		log.info("댓글 하나보기 처리중"+rno);
		return mapper.read(rno);
	}

	@Override
	public int modify(ReplyVO vo) {
		log.info("댓글 수정 처리중"+vo);
		return mapper.update(vo);
	}

	@Override
	public int remove(Long rno) {
		log.info("댓글 삭제 처리중"+rno);
		return mapper.delete(rno);
	}

	@Override
	public List<ReplyVO> getList(Criteria cri, Long bno) {
		log.info("댓글 전체보기 처리중"+ cri +"글번호:"+ bno);
		return mapper.getListWithPaging(cri, bno);
	}

}
