/*

create sequence seq_dessert_filter_d_f_idx

create table dessert_filter
(
   d_f_idx int,
   d_idx   int,
   c_idx   int
)


alter table dessert_filter
   add constraint pk_dessert_filter_d_f_idx primary key(d_f_idx);
   
alter table dessert_filter
   add constraint fk_dessert_filter_d_f_idx foreign key(d_idx) references dessert(d_idx);
   
alter table dessert_filter
   add constraint fk_dessert_filter_d_c_idx foreign key(c_idx) references cafe(c_idx);


*/