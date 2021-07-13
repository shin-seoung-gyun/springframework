package org.zerock.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.zerock.domain.Criteria;
import org.zerock.domain.ReplyVO;
@Service
public interface ReplyService {

	//등록
	public int register(ReplyVO vo) throws Exception;
	//댓글 가져오기(수정 위해서)
	public ReplyVO get(Long rno);
	//수정
	public int modify(ReplyVO vo);
	//삭제
	public int remove (Long rno);
	//해당 댓글 모두 가져오기
	public List<ReplyVO> getList(Criteria cri, Long bno);
	
	
	
	
	
}
