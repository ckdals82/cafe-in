/*

create sequence seq_mood_m_idx

create table mood
(
	m_idx int,
	m_name	varchar2(100)
)

alter table mood 
	add constraint pk_mood_m_idx primary key(m_idx);

*/