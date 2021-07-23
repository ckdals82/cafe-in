/*

--�Ϸù�ȣ ������ü
create sequence  seq_board_b_idx


--���̺�
create table board
(
   b_idx 			int,			--�Ϸù�ȣ
   b_subject		varchar2(500),	--����
   b_content		clob,			--����
   b_readhit		int,			--��ȸ��
   b_ip				varchar2(100),	--������
   b_regdate		date,			--�������
   b_use_yn			char(1),		--�������(y or n)
   m_idx			int,			--ȸ����ȣ
   m_name			varchar2(100),	--ȸ����
   
   b_ref			int,			--�����۹�ȣ
   b_step			int,			--�׷���� ������ ��ġ
   b_depth			int				--���� ����(���������)
)

--�⺻Ű ����
alter table board
  add constraint pk_board_b_idx primary key(b_idx);
  
--�ܷ�Ű ����
alter table board
  add constraint fk_board_m_idx  foreign key(m_idx)
                                 references member(m_idx);

select * from member                                                                  
                                 
--sample data
--1.���۾���
  insert into  board values(seq_board_b_idx.nextVal,
                            '����1���̴�',
                            '�̹����� 1���̳�',
                            0,
                            '127.0.0.1',
                            sysdate,
                            'y',
                            2,
                            'ȫ�浿',
                            seq_board_b_idx.currVal,
                            0,
                            0
                            );  
   
   --������ ���                         
   insert into  board values(seq_board_b_idx.nextVal,
                            '����10���̴�',
                            '�̹����� 10���̳�',
                            0,
                            '127.0.0.1',
                            sysdate,
                            'n',
                            2,
                            'ȫ�浿',
                            seq_board_b_idx.currVal,
                            0,
                            0
                            );                                                            
 --2.��۾���                                
   insert into  board values(seq_board_b_idx.nextVal,
                            '�ƽ��� 1�� ���Ƴ�',
                            '�̹����� 2���̳�',
                            0,
                            '127.0.0.1',
                            sysdate,
                            'y',
                            3,
                            '�ڱ浿',
                            1,
                            1,
                            1
                            );   
   
   insert into  board values(seq_board_b_idx.nextVal,
                            '������ ���ϸ� ����',
                            '�������� 1����!!',
                            0,
                            '127.0.0.1',
                            sysdate,
                            'y',
                            2,
                            'ȫ�浿',
                            1,
                            2,
                            2
                            );   
  
  select * from board  order by b_ref desc,b_step asc 
  
  
  update board set b_use_yn = 'y'
  
  commit
  
  
  -- Pagingó���� ���� SQL����
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