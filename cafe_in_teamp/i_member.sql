/*
drop table i_member

--일련번호
create sequence seq_member_i_idx

--테이블

create table i_member
(
	i_idx	  		int                   	,		--일련번호
	i_name	  		varchar2(100) not null	,		--이름
	i_id	  		varchar2(100) not null	,		--아이디
	i_pwd	  		varchar2(100) not null	,		--비밀번호
	i_email	  		varchar2(100) 			,		--이메일
	i_zipcode 		varchar2(100)		    ,		--우편번호
	i_addr	    	varchar2(100)			,		--주소
	i_addr_detail	varchar2(100)		    ,		--상세주소
	i_birth			varchar2(100)			,		--가입일자
	i_tel			varchar2(100)			,		--마지막수정날짜
	i_grade	  		varchar2(100) default '일반'		--회원등급 : 일반 or 관리자
)


--프라이머리키 설정
alter table i_member 
	add constraint pk_i_member_i_idx primary key(i_idx);
	
--중복불가
alter table i_member
	add constraint unique_i_member_i_id unique(i_id);
	
	
	


*/