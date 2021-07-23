/*

--일련번호 관리객체

create sequence seq_comment_tb_c_idx

--테이블생성
create table comment_tb
(
	c_idx	int,				--일련번호
	c_content varchar2(1000),	--내용
	c_ip	  varchar2(100),	--IP
	c_regdate date,				--작성일자
	b_idx	  int,				--기준글idx
	m_idx	  int,				--작성자idx
	m_name	  varchar2(100)		
)

--sample insert
insert into comment_tb values(seq_comment_tb_c_idx.nextVal, '내용' , 'IP', sysdate,b_idx,m_idx,m_name)

--기본키
alter table comment_tb
	add constraint pk_comment_tb_c_idx primary key(c_idx);
	
--외래키(포린키)
alter table comment_tb
	add constraint fk_comment_tb_b_idx foreign key(b_idx)

-제약조건 삭제
alter table comment_tb
  drop constraint fk_comment_tb_m_idx					

alter table comment_tb
  add constraint fk_comment_tb_m_idx foreign key(m_idx) 
                                     references member(m_idx)
                                     on delete cascade;

*/