/*

create sequence seq_dessert_d_idx

create table dessert
(
   d_idx          int,
   d_name        varchar(100)
)

alter table dessert
   add constraint pk_dessert_d_idx primary key(d_idx);



*/