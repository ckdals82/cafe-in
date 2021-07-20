/*

--일련번호 관리객체
create sequence seq_board_b_idx

--테이블
create table board
(

b_idx			int,			--일련번호
b_subject		varchar2(500),	--제목
b_content		clob,			--내용
b_readhit		int,			--조회수
b_ip			varchar2(100),	--아이피
b_regdate		date,			--등록일자
b_use_yn		char(1),		--사용유무
m_idx			int,			--회원번호
m_name			varchar2(100),	--회원명

b_ref			int,			--참조글번호
b_step			int,			--그룹글의 수직적 위치
b_depth			int				--글의 깊이(답글의 정도)

)

--기본키 설정
alter table board
	add constraint pk_board_b_idx primary key(b_idx);
	
--외래키 설정
alter table board
	add constraint fk_board_m_idx foreign key(m_idx)
								  references member(m_idx)
								  
select * from member
								  								  
--sample data
--1.새글쓰기
  insert into board values(seq_board_b_idx.nextVal,'나 시라소니야',
  													'평양박치기',
  													0,
  													'127.0.0.1',
  													sysdate,
  													'y',
  													2,
  													'홍길동',
  													seq_board_b_idx.currVal,
  													0,
  													0);								  
--2.답글쓰기
	 insert into board values(seq_board_b_idx.nextVal,
	 												'나 황창민이야',
  													'개봉동불주먹',
  													0,
  													'127.0.0.1',
  													sysdate,
  													'y',
  													3,
  													'박길동',
  													1,
  													1,
  													1);	

	 insert into board values(seq_board_b_idx.nextVal,
	 												'나 황창민이야',
  													'개봉동불주먹',
  													0,
  													'127.0.0.1',
  													sysdate,
  													'y',
  													2,
  													'홍길동',
  													1,
  													2,
  													2);	
--1.삭제글
  insert into board values(seq_board_b_idx.nextVal,'나 시라소니야',
  													'평양박치기',
  													0,
  													'127.0.0.1',
  													sysdate,
  													'n',
  													2,
  													'박길동',
  													seq_board_b_idx.currVal,
  													1,
  													2);		  													 													
  													
	
select * from board

select * from board order by b_ref desc,b_step asc

commit
*/