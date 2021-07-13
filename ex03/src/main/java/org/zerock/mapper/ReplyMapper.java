package org.zerock.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.zerock.domain.Criteria;
import org.zerock.domain.ReplyVO;

public interface ReplyMapper {

	//crud 구현하기
	//create
	public int insert(ReplyVO vo) throws Exception;
	
	
	
	//read 리플읽기 -> 해당글의 리플을 다 읽어서
	public ReplyVO read(Long rno);
	
	
	
	//update
	public int update(ReplyVO vo);
	
	
	
	//delete
	public int delete(Long rno);
	
	//리플 전체 읽기
	
	public List<ReplyVO> getListWithPaging(@Param("cri") Criteria cri,
			@Param("bno") Long bno);//파라미터가 두개 이상을 보내려면 각각 파람 어노테이션 사용
	
	
}
