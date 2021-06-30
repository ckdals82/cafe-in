/*

--일련번호
create sequence seq_category_idx

--테이블
create table category
(
	category_idx int,
	category_code varchar2(100) not null,
	category_name varchar2(500) not null
	

)

--기본키
alter table category
	add constraint pk_category_idx primary key(category_idx);


--uniqe제약
alter table category 
	add constraint unique_category_code unique(category_code);	

--컴퓨터   : com001
--가전제품 : ele002
--스포츠용품 : sp003

insert into category values(seq_category_idx.nextVal,'com001','컴퓨터');		
insert into category values(seq_category_idx.nextVal,'ele002','가전제품');
insert into category values(seq_category_idx.nextVal,'sp003','스포츠');
insert into category values(seq_category_idx.nextVal,'book004','도서');

delete from category where category_code='book004'

commit

select * from category

*/