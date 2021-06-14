/*
	
	--일련번호 관리객체
	create sequence seq_sungtb_no
	
	
	
	--테이블생성
	create table sungtb
	(
		no   int,				--일련번호
	 	name varchar2(100) not null,		--이름
	 	kor  int default 0,		--국어	
		eng  int default 0,		--영어
		mat  int default 0		--수학
	)
	
	--기본키
	alter table sungtb
		add constraint pk_sungtb_no primary key(no);
	
	
	--체크제약
	alter table sungtb
		add constraint ck_sungtb_kor check(kor between 0 and 100);
	
	alter table sungtb
		add constraint ck_sungtb_eng check(eng between 0 and 100);
	
	alter table sungtb
		add constraint ck_sungtb_mat check(mat between 0 and 100);
		
	--sample data
	
	insert into sungtb values(seq_sungtb_no.nextVal , '일길동' , 88 ,99 ,77);	
	insert into sungtb values(seq_sungtb_no.nextVal , '이길동' , 99 ,99 ,99);
	insert into sungtb values(seq_sungtb_no.nextVal , '삼길동' , 88 ,88 ,77);	
	insert into sungtb values(seq_sungtb_no.nextVal , '사길동' , 100 ,100 ,100);
	insert into sungtb values(seq_sungtb_no.nextVal , '오길동' , 60 ,60 ,60);
	
	select * from sungtb
	
	--조회용 뷰 생성
	create or replace view sungtb_view
	as
	
	select
		no,name,kor,eng,mat,
		(kor+eng+mat) as tot,
		round((kor+eng+mat)/3,1) as avg,
		rank() over( order by (kor+eng+mat) desc) as rank
	from sungtb
	order by no
	
	--조회
	select* from sungtb_view
	
	--삭제
	delete from sungtb where no=8
	
	--수정
	update sungtb set name='일길동', kor=100,eng=100,mat=100 where no = 1 --where 절 생략하면 전체가 수정됨
	
	commit
	
	--SQL injection(주입)
	select* from sungtb_view where name = '박길동' or 1=1
	
	select * from sungtb_view where no = 22
	
*/