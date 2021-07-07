insert into tbl_board (bno,content,title,writer)(select SEQ_BOARD.nextval, content, title, writer from tbl_board);

select max(bno) from tbl_board;

select *from tbl_board order by bno desc;
select *from tbl_board order by bno +1 desc;
commit;

select *from tbl_board where bno >0;
select *from tbl_board;

select * from tbl_board order by bno desc;

select /*+index_desc (tbl_board pk_board)*/* from tbl_board order by bno desc;

select /*+full (tbl_board)*/* from tbl_board order by bno desc; 

select * from tbl_board where bno > 0;

select /*+index_asc (tbl_board pk_board)*/* from tbl_board where bno > 0;


select rownum, bno,title from tbl_board where bno > 0 order by bno desc;

select /*+index_asc (tbl_board pk_board)*/ rownum, bno,title from tbl_board where bno > 0 order by bno desc;


select * from tbl_board where bno>0 and rownum<=10 order by bno desc;

select rownum rn, bno, title, content from tbl_board where rownum>10 and rownum<=20;

--mysql select * from tbl_board limit 10,10;
--rownum(가상순번)을 이용해서 특정 부분을 뽑아야 한다.
--where 조건문의 rownum 조건은 특이하게 테이블을 접근할때 필터링 조건으로 적용된다.
--order by 절은 가장 마지막에 실행된다.

select rownum, bno from tbl_board order by title;

select rownum,bno from (select *from tbl_board order by title);

--rownum 위치가 애매해서 생긴 쿼리 복잡함.
select bno, title, writer from (select rownum rn,bno,title,writer from (select * from  tbl_board where ROWNUM<=20 order by bno desc)) where rn>10;















