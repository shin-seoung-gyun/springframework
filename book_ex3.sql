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
--rownum(�������)�� �̿��ؼ� Ư�� �κ��� �̾ƾ� �Ѵ�.
--where ���ǹ��� rownum ������ Ư���ϰ� ���̺��� �����Ҷ� ���͸� �������� ����ȴ�.
--order by ���� ���� �������� ����ȴ�.

select rownum, bno from tbl_board order by title;

select rownum,bno from (select *from tbl_board order by title);

--rownum ��ġ�� �ָ��ؼ� ���� ���� ������.
select bno, title, writer from (select rownum rn,bno,title,writer from (select * from  tbl_board where ROWNUM<=20 order by bno desc)) where rn>10;















