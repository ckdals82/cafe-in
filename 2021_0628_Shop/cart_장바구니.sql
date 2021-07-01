/*

--��ٱ��� �Ϸù�ȣ
create sequence seq_cart_idx

--��ٱ��� ���̺�
create table cart
(
  c_idx  int,
  c_cnt  int  not null,
  p_idx  int,
  m_idx  int
)

--기본키
alter table cart
	add constraint pk_cart_c_idx primary key(c_idx);

--상품테이블(product)의 p_idx와 cart의 p_idx간의 외래키 설정
alter table cart
  add constraint fk_cart_p_idx foreign key(p_idx)
                               references product(p_idx);





--회원테이블(member)의 m_idx와 cart의 m_idx간의 외래키 설정
alter table cart
	add constraint fk_cart_m_idx foreign key(m_idx)
								 references member(m_idx);

select * from product
select * from member

insert into cart values(seq_cart_idx.nextVal,1,41,1);
insert into cart values(seq_cart_idx.nextVal,1,42,2);
insert into cart values(seq_cart_idx.nextVal,1,44,41);

select * from cart

commit

-- Join을 통해서 조회정보를 추출
create or replace view cart_view
as
	select
	   p.p_idx,c_idx, p_num,p_name,p_price,p_saleprice,
	   c_cnt, c_cnt* p_saleprice amount,c.m_idx
	from product p inner join  cart c on p.p_idx = c.p_idx  
		
		--inner join member m on m.m_idx=c.m_idx
		
select * from cart_view where m_idx=3 and p_idx=4

--장바구니 상품의 총계
select sum(amount) from cart_view where m_idx=2













*/