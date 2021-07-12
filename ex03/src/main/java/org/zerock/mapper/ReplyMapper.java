package org.zerock.mapper;

import org.zerock.domain.ReplyVO;

public interface ReplyMapper {

	//crud 구현하기
	//create
	public int insert(ReplyVO vo);
	
	
	
	//read 리플읽기 -> 해당글의 리플을 다 읽어서
	public ReplyVO read(Long rno);
	
	
	
	//update
	public int update(ReplyVO vo);
	
	
	
	//delete
	public int delete(Long rno);
	
	
}
