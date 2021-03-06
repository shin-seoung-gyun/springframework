package org.zerock.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;
import org.zerock.domain.RankVO;
import org.zerock.domain.TimeVO;
import org.zerock.mapper.BoardMapper;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Service
@Log4j
@AllArgsConstructor
public class BoardServiceImpl implements BoardService {
	
	private BoardMapper mapper;
	
	@Override//글등록
	public void register(BoardVO board) {
		log.info("등록....."+board);
		mapper.insertSelectKey(board);
		
	}

	@Override//글 읽기
	public BoardVO get(Long bno) {
		log.info("읽기....."+bno);
		return mapper.read(bno);
	}

	@Override//글 수정
	public boolean modify(BoardVO board) {
		log.info("수정....."+board);
		return mapper.update(board)==1;
		
	}

	@Override//글 삭제
	public boolean remove(Long bno) {
		log.info("삭제....."+bno);
		return mapper.delete(bno)==1;
	}

	@Override//글 목록
	public List<BoardVO> getList() {
		log.info("글목록 가져오기.....");
		return mapper.getList();
	}

	@Override
	public List<RankVO> ranking() {
		
		return mapper.ranking();
	}

	@Override//글 목록 페이지
	public List<BoardVO> getList(Criteria cri) {
		log.info("요청 페이지 정보"+cri);
		return mapper.getListWithPaging(cri);
	}

	@Override
	public Long getTotal(Criteria cri) {
		log.info("전체글 개수 요청");
		return mapper.getTotalCount(cri);
	}

	@Override
	public List<TimeVO> getTimeCnt() {
		log.info("시간대별 글 개수 요청");
		
		return mapper.getTimeCnt();
	}



}
