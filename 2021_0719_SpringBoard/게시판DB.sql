/*

--일련번호 관리객체
create sequence  seq_board_b_idx


--테이블
create table board
(
   b_idx 			int,			--일련번호
   b_subject		varchar2(500),	--제목
   b_content		clob,			--내용
   b_readhit		int,			--조회수
   b_ip				varchar2(100),	--아이피
   b_regdate		date,			--등록일자
   b_use_yn			char(1),		--사용유무(y or n)
   m_idx			int,			--회원번호
   m_name			varchar2(100),	--회원명
   
   b_ref			int,			--참조글번호
   b_step			int,			--그룹글의 수직적 위치
   b_depth			int				--글의 깊이(답글의정도)
)

--기본키 설정
alter table board
  add constraint pk_board_b_idx primary key(b_idx);
  
--외래키 설정
alter table board
  add constraint fk_board_m_idx  foreign key(m_idx)
                                 references member(m_idx);

select * from member                                                                  
                                 
--sample data
--1.새글쓰기
  insert into  board values(seq_board_b_idx.nextVal,
                            '내가1등이다',
                            '이번에도 1등이네',
                            0,
                            '127.0.0.1',
                            sysdate,
                            'y',
                            2,
                            '홍길동',
                            seq_board_b_idx.currVal,
                            0,
                            0
                            );  
   
   --삭제글 등록                         
   insert into  board values(seq_board_b_idx.nextVal,
                            '내가10등이다',
                            '이번에도 10등이네',
                            0,
                            '127.0.0.1',
                            sysdate,
                            'n',
                            2,
                            '홍길동',
                            seq_board_b_idx.currVal,
                            0,
                            0
                            );                                                            
 --2.답글쓰기                                
   insert into  board values(seq_board_b_idx.nextVal,
                            '아쉽네 1등 놓쳤네',
                            '이번에도 2등이네',
                            0,
                            '127.0.0.1',
                            sysdate,
                            'y',
                            3,
                            '박길동',
                            1,
                            1,
                            1
                            );   
   
   insert into  board values(seq_board_b_idx.nextVal,
                            '다음에 잘하면 되지',
                            '다음에는 1등해!!',
                            0,
                            '127.0.0.1',
                            sysdate,
                            'y',
                            2,
                            '홍길동',
                            1,
                            2,
                            2
                            );   
  
  select * from board  order by b_ref desc,b_step asc 
  
  
  update board set b_use_yn = 'y'
  
  commit
  
  
  -- Paging처리를 위한 SQL문장
  select * from board  order by b_ref desc,b_step asc 
  
  
  select * from 
  (
	  select
	     rank() over(order by b_ref desc,b_step asc) as no,
	     b.*
	  from (select * from board) b
  )
  where no between 1  and  5
  
  
  
  select nvl(count(*),0) from board
  
  
  update board set b_use_yn = 'y'
  
  
  commit
  
  
  
  

*/