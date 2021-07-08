package org.zerock.service;

import java.util.List;

import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;
import org.zerock.domain.RankVO;


public interface BoardService {

	//1.글등록
	public void register(BoardVO board);
	//2.글 읽기
	public BoardVO get(Long bno);
	//3.글 수정
	public boolean modify(BoardVO board);
	//4.글 삭제
	public boolean remove(Long bno);
	//5.목록 읽기
	public List<BoardVO> getList();
	//5-1.목록 읽기
	public List<BoardVO> getList(Criteria cri);
	
	//6.랭킹
	public List<RankVO> ranking();
	//7.전체글 개수
	public Long getTotal(Criteria cri);
	
	
}
