/*
drop table i_member

--�Ϸù�ȣ
create sequence seq_member_i_idx

--���̺�

create table i_member
(
	i_idx	  		int                   	,		--�Ϸù�ȣ
	i_name	  		varchar2(100) not null	,		--�̸�
	i_id	  		varchar2(100) not null	,		--���̵�
	i_pwd	  		varchar2(100) not null	,		--��й�ȣ
	i_email	  		varchar2(100) 			,		--�̸���
	i_zipcode 		varchar2(100)		    ,		--�����ȣ
	i_addr	    	varchar2(100)			,		--�ּ�
	i_addr_detail	varchar2(100)		    ,		--���ּ�
	i_birth			varchar2(100)			,		--��������
	i_tel			varchar2(100)			,		--������������¥
	i_grade	  		varchar2(100) default '�Ϲ�'		--ȸ����� : �Ϲ� or ������
)


--�����̸Ӹ�Ű ����
alter table i_member 
	add constraint pk_i_member_i_idx primary key(i_idx);
	
--�ߺ��Ұ�
alter table i_member
	add constraint unique_i_member_i_id unique(i_id);
	
	
	


*/