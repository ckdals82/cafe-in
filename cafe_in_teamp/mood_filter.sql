/*

create sequence seq_mood_filter_m_f_idx

drop table mood_filter

create table mood_filter
(
	m_f_idx		int	,
	m_idx		int,
	c_idx		int	
)


--프라이머리키 설정
alter table mood_filter
	add constraint pk_mood_filter_m_f_idx primary key(m_f_idx);
	
--외래키 설정	

alter table mood_filter 
	add constraint fk_mood_filter_m_idx foreign key(m_idx) references mood(m_idx);

alter table mood_filter 
	add constraint pk_mood_filter_c_idx foreign key(c_idx) references cafe(c_idx);	
			
select * from mood_filter








*/