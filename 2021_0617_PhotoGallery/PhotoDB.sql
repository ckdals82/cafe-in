/*

--일련번호 객체를 사용하지 않는다.
drop table photo

--테이블 생성
create table photo
(
p_idx        int,			--일련번호
p_title      varchar2(100), --제목
p_content	 varchar2(100), --내용
p_filename   varchar2(100), --화일명
p_ip         varchar2(100), --아이피
p_regdate    date,          --등록일자
p_modifydate date,           --수정일자
m_idx        int            --업로드한 회원번호



)
--기본키
alter table photo
 add constraint pk_photo_p_idx primary key(p_idx);

--외래키
alter table photo
 add constraint fk_photo_m_idx foreign key(m_idx)
 								references member(m_idx)
 								on delete cascade;
cf) on delete cascade : member table에서 m_idx회원이 삭제되면
						참조하는 photo table의 데이터도 같이 삭제 
	
	on update cascade:	부모키가수정되면 참조되는 값도 같이수정
	
	--sample data
	insert into photo values((select nvl(max(p_idx),0)+1 from photo),
							'1번째 사진',
							'처음 올려보는 사진입니다',
							'a.jpg',
							'192.168.7.14',
							sysdate,
							sysdate,
							1);
	insert into photo values((select nvl(max(p_idx),0)+1 from photo),
							'2번째 사진',
							'두번째 올리는 사진입니다',
							'b.jpg',
							'192.168.7.14',
							sysdate,
							sysdate,
							2);
	--jdbc명령						
	insert into photo values((select nvl(max(p_idx),0)+1 from photo),?,?,?,?,sysdate,sysdate,?)
							
	select * from member
	
	(select nvl(max(p_idx),0)+1 from photo) --inline view
	select m_idx from member
	
	select * from photo order by p_idx desc
	
	commit
	
	
*/