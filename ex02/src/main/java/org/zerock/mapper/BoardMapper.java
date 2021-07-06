package org.zerock.mapper;

import java.util.List;

import org.zerock.domain.BoardVO;
import org.zerock.domain.RankVO;


public interface BoardMapper {
	
//	@Select("select * from tbl_board where bno>0")
	public List<BoardVO> getList(); 
	
	
	//글 등록
	
	public void insert(BoardVO board);
	
	
	//글 등록후 글번호 알기
	
	public void insertSelectKey(BoardVO board);
	
	//글번호로 글읽기
	public BoardVO read(Long bno);
	
	//글 삭제
	public int delete(Long bno);
	
	//글수정
	public int update(BoardVO board);
	
	//글쓴수 랭킹
	public List<RankVO> ranking();
	
	
}
