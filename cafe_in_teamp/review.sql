/*

--일련번호
create sequence seq_review_r_idx

--테이블



create table review
(
   r_idx  int,
   r_title   varchar2(100),                 --리뷰제목
   r_content  varchar2(100) ,    			--리뷰내용
   r_star   int ,   						--별
   r_photo   varchar2(100) ,      			--사진
   c_idx   int        ,    					--카페일련번호
   i_idx    int           ,    				--가입일자
   i_id          varchar2(100) ,    		--마지막수정날짜
   m_regdate   date,
   r_count int
)


--기본키 설정
alter table review
	add constraint pk_review_r_idx primary key(r_idx);



--외래키
alter table review
	add constraint fk_review_c_idx foreign key(c_idx) references cafe(c_idx);


alter table review 
	add constraint fk_review_i_idx foreign key(i_idx) references i_member(i_idx);

select constraint_type,constraint_name 
from user_constraints
where table_name ='REVIEW'

select *from review

*/