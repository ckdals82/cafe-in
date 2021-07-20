/*

--일련번호
create sequence seq_cafe_c_idx

--테이블

create table cafe
(
	c_idx	  int,						
	c_name	  varchar2(100) not null, 	
	c_loc 	  varchar2(100) not null,		
	c_tel	  varchar2(100) not null,
	f_idx	  int,
	r_idx 	  int,
	r_star	  varchar2(100),
	c_parking int,
	c_alcohol int,
	c_meal    int,
	c_nokidz  int
)

alter table cafe
	add constraint pk_member_c_idx primary key(c_idx);





*/