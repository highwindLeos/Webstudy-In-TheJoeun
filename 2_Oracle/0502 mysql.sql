create user leos identified by 'stonker26';

grant all on *.* to leos identified by 'stonker26';

revoke all on *.* from leos;

drop user leos;

show databases; -- 데이터 베이스의 리스트를 출력한다.

use sample; -- 해당 데이터 베이스를 사용한다.
show tables; -- 사용중인 데이터베이스의 테이블을 본다.

create database leosdatabase;
use leosdatabase;

show tables;

drop table if exists major;
create table major (
	major_code int primary key auto_increment, -- 주키에 자동증가.
    major_name varchar(30)
);

insert into major (major_name) values ('컴퓨터 공학');
insert into major (major_name) values ('경영학과');
insert into major (major_name) values ('디자인학과');

select * from major;

drop table if exists student;
create table student(
	hakbun varchar(5) primary key,
    name varchar(20) not null,
    score int,
    major_code int, 
    foreign key(major_code) references major(major_code) 
); -- 포린키지정

insert into student values ('a01', '홍', 100, 1);
insert into student values ('b01', '박', 99, 2);
insert into student values ('c01', '김', 98, 3);

select hakbun, name, score, m.major_name 
from student s, major m
where s.major_code = m.major_code;


--- JAVA 시간과 JSP 시간에 쓸 테이블 2개 생성, 데이터 생성.
drop table if exists division;
create table division(
	dno int not null primary key, -- 부서번호
    dname varchar(20), 			  -- 부서 이름
    phone varchar(20),			  -- 부서 연락처
    position varchar(20)		  -- 부서 위치
);

show tables;

insert into division values (10, 'finance', '02-777-7777', '종로');
insert into division values (20, 'reserch', '02-555-7777', '은평');
insert into division values (30, 'sales', '02-666-7777', '강남');
insert into division values (40, 'marketing', '02-333-7777', '과천');

select * from division;
commit;

drop table if exists personal;
create table personal(
	pno int not null primary key,
    pname varchar(10) not null,
    job varchar(15) not null,
    manager int,
    startdate date,
    pay int,
    bonus int,
    dno int,
    foreign key(dno) references division(dno)
);

show tables;

load data local infile 'c:/personal.txt' replace
into table personal; -- txt 파일을 personal tabel 에 입력한다.

select * from personal;
commit;

-- 1. 사번, 이름, 급여를 출력
select pno, pname, pay from personal; 

-- 2. 급여가 2000~5000 사이
select pno, pname, dno
from personal
where pay between 2000 and 5000; 

-- 3. 부서코드가 10또는 20인 사원의 사번, 이름, 부서코드
select pno, pname, dno
from personal
where dno in (10, 20);

select pno, pname, dno
from personal
where dno = 10 or dno = 20;

-- 4. 보너스가 null인 사원의 사번, 이름, 급여 급여 큰 순정렬
select pno, pname, pay
from personal
where bonus is null
order by pay desc;

-- 5. 사번, 이름, 부서코드, 급여 부서코드 순 오름차순 정열 같으면 급여 큰 순
select pno, pname, dno, pay
from personal
order by dno, pay desc;

-- 6. 사번, 이름, 부서명
select pno, p.pname, dname
from personal p, division d
where p.dno = d.dno;

-- 6-1 사번 이름 부서명 (사원이 없는 부서명도 출력.)
select ifnull(pno, '없음') pno, ifnull(p.pname,'없음') pname, dname
from personal p right outer join division d
on p.dno = d.dno; 

-- 7. 사번, 이름, 관리자명
select w.pno, w.pname, m.pname
from personal w, personal m
where w.manager = m.pno;

-- 7-1 사번 이름 상사의 이름 (상사가 없는 사람도 출력)
select w.pno, w.pname, ifnull(m.pname, '상사없음')
from personal w left outer join personal m
on w.manager = m.pno;

-- 8. 이름이 s로 시작하는 사원 이름
select pname
from personal
where pname like 's%';

-- 9. 사번, 이름, 급여, 부서명, 관리자명
select w.pno, w.pname, w.pay, dname, m.pname
from personal w, personal m, division d
where w.manager = m.pno and p.dno = d.dno;

-- 10. 부서코드, 급여합계, 최대급여
select dno, sum(pay), max(pay)
from personal p
group by dno;

-- 11. 부서명, 급여평균, 인원수
select d.dname, round(avg(pay)), count(*)
from personal p, division d
where p.dno = d.dno
group by dname;

-- 12. 부서코드, 급여합계, 인원수 인원수가 4명 이상인 부서만 출력
select p.dno, sum(pay), count(*)
from personal p, division d
where p.dno = d.dno
group by dno
having count(*) >= 4; 

-- 13. 사번, 이름, 급여 회사에서 제일 급여를 많이 받는 사람
select pno, pname, pay
from personal
where pay = (select max(pay) from personal);

-- 14. 회사 평균보다 급여를 많이 받는 사람 이름, 급여
select avg(pay) from personal;

select pname, pay
from personal
where pay >= (select avg(pay) from personal);

-- 15. 14번에 부서명을 추가하고 부서명순 정열 같으면 급여 큰순
select pname, pay, dname
from personal p, division d
where p.dno = d.dno and pay > (select avg(pay) from personal)
order by dname, pay desc;

select pname, pay, dname
from personal p, division d
where p.dno = d.dno && pay > (select avg(pay) from personal)
order by dname, pay desc;
 
-- 16. 자기부서평균보다 급여를 많이 받는 사람 이름, 급여
select pname, pay
from personal p
where pay > (select avg(pay) from personal where dno = p.dno);

select pname, pay
from personal p, (select dno, avg(pay) avgsal from personal group by dno) s
where p.dno = s.dno and pay > avgsal;

-- 16-1 자기부서 평균보다 급여를 많이 받는 사람의 이름 급여 그사람의 부서평균
select dno, avg(pay) avgsal from personal group by dno;

select pname, pay, s.avgsal
from personal p, (select dno, avg(pay) avgsal from personal group by dno) s
where p.dno = s.dno and pay > avgsal;
-- 17. 입사가 가장 빠른 사람의 이름, 급여, 부서명
select pname, pay, dname 
from personal p, division d
where p.dno = d.dno and startdate = (select min(startdate) from personal);

select pname, pay, dname 
from personal p, division d
where p.dno = d.dno && startdate = (select min(startdate) from personal);

-- 오라클과 아주 다른 단일행 함수 및 예약어.
select concat(pname, concat('(', concat(job, ')'))) from personal; -- oracle 식alter

select concat(pname, '(', job, ')') from personal; -- mysql 식 concat

select round(56.789, 1); -- from 절이 없어도 값이 계산되면 출력해준다.

select reverse('hello'); -- 문자열을 뒤집는다.

select pname, year(startdate) 입사년, month(startdate) 입사월,
		monthname(startdate) 월이름, dayname(startdate) 요일, 
        day(startdate) 일, dayofyear(startdate) 올해몇째날, startdate
from personal;

select sysdate(); -- 현재의 날짜와 시간.
select now(); -- 현제시간.

-- 형변환 함수
select date_format(now(), '%y년 %m월 %e일');
-- %Y : 2018 %y : 18 %m : 05 %d : 03 %e: 3

select format(56.789, 0); 
select format(56.789, -1);
select format(56.789, 1);  

select pname, if(pay>300 , '높다', '낮다'), ifnull(bonus, 0) 
from personal;

-- 1페이지에는 0부터 5개 2페이지는 5부터 5개
select pname, pay 
from personal 
order by pay limit 0, 30;

-- 숫자가 하나오는 경우 : 0부터 가져오는 갯수가 된다.
select pname, pay 
from personal 
order by pay limit 5;

SELECT * FROM DIVISION WHERE DNO = 10;
SELECT * FROM PERSONAL WHERE DNO = 10;