/*

select * from sawon where (substr(to_char(sahire,'YYYY'),1,3) || '0') ='2000'
select * from sawon where (substr(to_char(sahire,'YYYY'),1,3) || '0') = '#{year10}'

select sahire, substr(to_char(sahire,'YYYY'),1,3) || '0' as year10 from sawon

--경우의수
--전체검색
select * from sawon

--부서별검색
select * from sawon where deptno=10

--직급별검색
select * from sawon where sajob='대리'

--성별검색
select * from sawon where sasex='남자'

--부서별 직급별
select from sawon where deptno= 10 and sajob='대리'

--부서별 성별
select from sawon where deptno=10 and sasex='남자'

--직급별 성별
select from sawon where sajob='대리' and sasex='남자'

--부서별 직급별 성별
select from sawon where deptno=10 and sajob='대리' and sasex='남자'

*/