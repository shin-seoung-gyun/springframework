package org.zerock.domain;

import java.util.Date;

import lombok.Data;

@Data
public class ReplyVO {

	private Long rno;//리플순번
	private Long bno;//해당 게시글
	
	private String reply; //리플 내용
	private String replyer;//리플 작성자
	private Date replyDate;//리플 작성일
	private Date updateDate;//리플 수정일
	
	
}
