/*

--일련번호관리객체
create sequence seq_visit_idx


--방명록 테이블

create table visit
(
	idx 	int,						--일련번호
	name	varchar2(100)  not null,		--작성자
	content varchar2(1000) not null,		--내용
	pwd		varchar2(100)  not null,		--비밀번호
	ip		varchar2(100)  not null,		--IP
	regdate date							--작성일자
		
)

--기본키
alter table visit
	add constraint pk_visit_ids primary key(idx);

--sample data
insert into visit values(seq_visit_idx.nextVal,'일길동','왔다 갑니다..','1234','192.168.7.14',sysdate);
insert into visit values(seq_visit_idx.nextVal,'이길동','1등 놓쳤네..','1234','192.168.7.10',sysdate);

--조회
select * from visit order by idx desc

--1건의 데이터만 조회
select * from visit where idx = 2

--삭제
delete from visit where idx=2

--수정
update visit set name='일길동',content='내가 1등이닷~~',pwd='1234',ip='192.168.7.14',sysdate
where idx=3

commit
*/