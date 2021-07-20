/*

--�Ϸù�ȣ
create sequence seq_review_r_idx

--���̺�



create table review
(
   r_idx  int,
   r_title   varchar2(100),                 --��������
   r_content  varchar2(100) ,    			--���䳻��
   r_star   int ,   						--��
   r_photo   varchar2(100) ,      			--����
   c_idx   int        ,    					--ī���Ϸù�ȣ
   i_idx    int           ,    				--��������
   i_id          varchar2(100) ,    		--������������¥
   m_regdate   date,
   r_count int
)


--�⺻Ű ����
alter table review
	add constraint pk_review_r_idx primary key(r_idx);



--�ܷ�Ű
alter table review
	add constraint fk_review_c_idx foreign key(c_idx) references cafe(c_idx);


alter table review 
	add constraint fk_review_i_idx foreign key(i_idx) references i_member(i_idx);

select constraint_type,constraint_name 
from user_constraints
where table_name ='REVIEW'

select *from review

*/