/*

--일련번호
create sequence seq_member_m_idx

drop table member

--테이블
create table member
(
m_idx int,                   	--일련번호
m_name varchar2(100) not null, 	--이름
m_id   varchar2(100) not null,	--아이디(중복허용안함)
m_pwd  varchar2(100) not null,	--비밀번호
m_zipcode varchar2(100)      , 	--우편번호
m_addr    varchar2(100)      , 	--주소
m_ip      varchar2(100)      , 	--아이피
m_regdate date               , 	--가입일자
m_modifydate date            ,  --마지막수정날짜
m_grade   varchar2(100) default '일반' --회원등급 : 일반 or 관리자
)

--기본키
alter table member
 add constraint pk_member_m_idx primary key(m_idx);
 
--중복불가
alter table member
 add constraint unique_member_m_id unique(m_id);

--sample data
insert into member values(seq_member_m_idx.nextVal,'김관리','admin','1234',
							'12345','서울시 관악구 시흥대로 552',
							'192.168.7.14',
							sysdate,
							sysdate,
							'관리자'
							);

insert into member values(seq_member_m_idx.nextVal,'홍길동','hong','1234',
							'12345','서울시 관악구 시흥대로 552',
							'192.168.7.14',
							sysdate,
							sysdate,
							'일반'
							);
insert into member values(seq_member_m_idx.nextVal,'박길동','park','1234',
							'12345','서울시 관악구 시흥대로 552',
							'192.168.7.14',
							sysdate,
							sysdate,
							'일반'
							);
							
--JDBc insert 틀 							
insert into member values(seq_member_m_idx.nextVal,?,?,?,?,?,?,sysdate,sysdate,default)							

select * from member

commit

*/