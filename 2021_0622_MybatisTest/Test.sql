/*

select * from sawon where (substr(to_char(sahire,'YYYY'),1,3) || '0') ='2000'
select * from sawon where (substr(to_char(sahire,'YYYY'),1,3) || '0') = '#{year10}'

select sahire, substr(to_char(sahire,'YYYY'),1,3) || '0' as year10 from sawon
*/