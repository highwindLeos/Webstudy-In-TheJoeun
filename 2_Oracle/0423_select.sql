-- 2 SELECT 문 : 데이터를 읽어오는 명령문.

--SELECT [DISTINCT] {*, column [Alias], ….}
--FROM 데이블명
--[WHERE condition]
--[ORDER BY {column, expression} [ASC|DESC]] ;

SELECT * FROM TAB; --Leos 계정이 소유한 테이블을 모두 보여준다.
SELECT * FROM EMP; -- EMP TABLE 의 모든 필드를 출력.
SELECT * FROM DEPT; -- DEPT TABLE : 부서번호(DEPTNO) 부서이동(DNAME) 부서위치(LOC).

DESC DEPT; -- TABLE 의 구조를 출력. SELECT 데이터를 출력. DESC 구조를 출력
DESC EMP; -- TABLE 의 구조를 출력. SELECT 데이터를 출력. DESC 구조를 출력

SELECT EMPNO,ENAME, SAL FROM EMP; -- EMP table 에서 사번 이름 급여 만 가져온다.

SELECT EMPNO AS "사번", ENAME AS "이름", SAL AS "급여", JOB AS "직무" FROM EMP; -- EMP table 에서 필드에 별명을 달아서 출력한다.
SELECT EMPNO "사번", ENAME "이름", SAL "급여", JOB "직무" FROM EMP; -- EMP table 에서 필드에 별명을 달아서 출력한다. (AS와 "" 생략가능) 
SELECT EMPNO 사번, ENAME 이름, SAL 급여, JOB 직무 FROM EMP; -- EMP table 에서 필드에 별명을 달아서 출력한다. (AS와 "" 생략가능) 

SELECT EMPNO, ENAME, SAL FROM EMP WHERE SAL = 3000; --월급이 3000인 사원의 사번 이름 급여를 출력.

SELECT EMPNO, ENAME, SAL FROM EMP WHERE SAL != 3000; --월급이 3000이 아닌 사원의 사번 이름 급여를 출력.
SELECT EMPNO, ENAME, SAL FROM EMP WHERE SAL <> 3000; --월급이 3000이 아닌 사원의 사번 이름 급여를 출력.
SELECT EMPNO, ENAME, SAL FROM EMP WHERE SAL ^= 3000; --월급이 3000이 아닌 사원의 사번 이름 급여를 출력. (세개의 연산자는 모두 같은 것)

SELECT * FROM EMP WHERE DEPTNO = 10; -- 10번 부서의 모든 직원의 모든 필드 출력.
SELECT * FROM EMP WHERE ENAME = 'FORD'; -- 이름이 FORD 인 사원의 모든 필드를 출력.

-- 4 산술 연산자. + - * / % : 산술연산시  NULL 이 있으면 결과도  NULL 
-- 결과에 NULL 이 안나오게 하려면 NVL() 함수를 사용

SELECT ENAME, SAL, SAL*12, COMM, SAL*12+COMM FROM EMP WHERE ENAME = 'FORD'; -- 이름이  FORD 인 사원의 이름 월글 연봉 상여급을 출력한다.
SELECT ENAME, SAL, SAL*12 AS "연봉", SAL*12+NVL(COMM, 0) AS "연봉+상여" FROM EMP WHERE ENAME = 'FORD'; -- 이름이  FORD 인 사원의 이름 월글 연봉 상여급을 출력한다.
-- NVL(var1, var2) var1 이 null 일 경우 var2 를 취하는 함수 같은 타입일때만 사용.
SELECT ENAME, SAL, NVL(COMM, '0'), NVL(JOB, '직무없음') FROM EMP; -- 

-- 5. 논리연산자 AND(&&), OR(||) 
SELECT EMPNO, ENAME, JOB, MGR, HIREDATE, SAL, NVL(COMM, 0) COMM, DEPTNO  
        FROM EMP WHERE DEPTNO = 10 AND JOB = 'MANAGER'; -- DEPTNO 10 이고 JOB 이 MANAGER 인 기술된 필드를 출력. (필드값에서 모든 조건이 참인경우 AND)
        
SELECT EMPNO, ENAME, JOB, MGR, HIREDATE, SAL, NVL(COMM, 0) COMM, DEPTNO  
        FROM EMP WHERE DEPTNO = 10 OR JOB = 'MANAGER'; --  DEPTNO 가 10 이거나 JOB 이 MANAGER 인 기술된 필드를 출력. (필드값에서 조건중 하나만 참이어도 출력 OR)
        
SELECT * FROM EMP WHERE NOT DEPTNO = 10; -- DEPTNO 가 10이 아닌 모든 필드를 출력. (NOT)

SELECT * FROM EMP WHERE SAL > 2000 AND SAL < 2999; -- 급여가 2000 ~ 2999 사이인 모든 필드를 출력.

ALTER SESSION set NLS_DATE_FORMAT = 'RR-MM-DD'; -- 날짜 필드의 포멧을 수정한다. (자주 쓰이지는 않으니 구글링이나  TOOL 의 기능을 이용한다.)

--  HIREDATE 가 '82-01-01' 이상이고 HIREDATE 보다 '83-01-01' 작은 필드를 모두 출력.
SELECT * FROM EMP WHERE HIREDATE >= '82-01-01' AND HIREDATE < '83-01-01'; 

-- 6. 연결 연산자 ( || ) PIPE : 필드나 문자열을 연결하는 연산자.
SELECT ENAME ||' 은 '|| JOB "사원 과 직무" FROM EMP; -- 하나의 필드로 합쳐서 출력

-- 아무개의 연봉은 얼마예요? 
SELECT ENAME || ' 의 연봉은 ' || (SAL*12+NVL(COMM, 0)) || ' 예요' AS "연봉자료" FROM EMP;

-- 7902는 CLARK 입니다.
SELECT EMPNO || ' 는 ' || ENAME || '입니다.' AS show FROM EMP;

-- 아무개 는 MENAGER (조건 : SAL 이 2000 이상 3000미만인 사람만 출력)
SELECT ENAME || ' 는 ' || JOB || '입니다.' AS show 
        FROM EMP 
        WHERE SAL >= 2000 AND SAL < 3000;
        
--  중복을 제거해서 출력 : DISTINCT 예약어.
SELECT JOB FROM EMP;
SELECT DISTINCT JOB FROM EMP;

SELECT  DEPTNO FROM EMP;
SELECT DISTINCT DEPTNO FROM EMP;

--------------------------------------------------------------------------------------------
-- EXAMPLE 예제
--------------------------------------------------------------------------------------------

--1.	emp 테이블의 구조 출력
DESC EMP;

--2.	emp 테이블의 모든 내용을 출력 
SELECT * From EMP;

--3.	이 계정에서 사용가능한 테이블 출력
SELECT * FROM TAB;

--4.	emp 테이블에서 사번, 이름, 급여, 업무, 입사일 출력
SELECT EMPNO, ENAME, SAL, JOB, HIREDATE FROM EMP;

--5.	emp 테이블에서 급여가 2000미만인 사람의 사번, 이름, 급여 출력
SELECT EMPNO, ENAME, SAL FROM EMP WHERE SAL < 2000;

--6.	emp 테이블에서 입사일이 81/02이후에 입사한 사람의 사번, 이름, 업무, 입사일 출력
SELECT EMPNO, ENAME, JOB, HIREDATE FROM EMP WHERE HIREDATE >= '82-02-01';

--7.	emp 테이블에서 업무가 SALESMAN인 사람들 모든 자료 출력
SELECT * FROM EMP WHERE JOB = 'SALESMAN'; 

--8.	emp 테이블에서 업무가 CLERK이 아닌 사람들 모든 자료 출력
SELECT * FROM EMP WHERE NOT JOB = 'CLERK';
SELECT * FROM EMP WHERE JOB != 'CLERK';
SELECT * FROM EMP WHERE JOB ^= 'CLERK';
SELECT * FROM EMP WHERE JOB <> 'CLERK';

--9.	emp 테이블에서 급여가 1500이상이고 3000이하인 사람의 사번, 이름, 급여 출력
SELECT EMPNO, ENAME, SAL FROM EMP WHERE SAL >= 1500 AND SAL <= 3000;

--10.	emp 테이블에서 부서코드가 10번이거나 30인 사람의 사번, 이름, 업무, 부서코드 출력
SELECT EMPNO, ENAME, JOB, DEPTNO FROM EMP WHERE DEPTNO = 10 OR DEPTNO = 30;

--11.	emp 테이블에서 업무가 SALESMAN이거나 급여가 3000이상인 사람의 사번, 이름, 업무, 부서코드 출력
SELECT EMPNO, ENAME, JOB, DEPTNO FROM EMP WHERE JOB = 'SALESMAN' OR SAL >= 3000;

--12.	emp 테이블에서 급여가 2500이상이고 업무가 MANAGER인 사람의 사번, 이름, 업무, 급여 출력
SELECT EMPNO, ENAME, JOB, DEPTNO FROM EMP WHERE SAL >= 2500 AND JOB = 'MANAGER';

--13.	emp 테이블의 “ename은 XXX 업무이고 연봉은 XX다” 스타일로 모두 출력
SELECT ENAME || ' 은 ' || JOB || ' 업무이고 연봉은 ' || (SAL*12+NVL(COMM,0)) AS "SHOWMSG" FROM EMP;

--------------------------------------------------------------------------------------------
-- SQL 연산자
--------------------------------------------------------------------------------------------
-- 8. BETWEEN a AND b / IN / LIKE (와일드카드와 동반) = 이 연산자들은 모두 NOT 으로 반대값을 가져올수 있다.
SELECT EMPNO, ENAME, SAL FROM EMP WHERE SAL >= 1500 AND SAL <= 3000;

SELECT  EMPNO, ENAME, SAL FROM EMP WHERE SAL BETWEEN 1500 AND 3000; 

-- IN (LIST) 연산자
SELECT * FROM EMP WHERE DEPTNO = 10 OR DEPTNO = 30;

SELECT * FROM EMP WHERE DEPTNO IN(10,30);

-- 사번이 7902 7788 7566 인 사람들의 모든 필드 정보를 출력하세요.
SELECT * FROM EMP WHERE EMPNO = 7902 OR EMPNO = 7788 OR EMPNO = 7566;

SELECT * FROM EMP WHERE EMPNO IN (7902, 7788, 7566);

-- LIKE 연산자 (% <한글자 이상 포함> _ <한글자> : 와일드 카드와 같이 쓴다.)
SELECT * FROM EMP WHERE ENAME LIKE 'M%'; --이름이 M으로 시작하는 직원.

SELECT * FROM EMP WHERE ENAME LIKE '%M%'; -- M을 한글자라도 포함되는 직원

SELECT * FROM EMP WHERE ENAME LIKE '_A%'; -- A앞에 반드시 한글자가 있는 필드.

-- 입사일이 82년인 사원의 모든 필드를 출력하세요.
SELECT * FROM EMP WHERE HIREDATE >= '82-01-01' AND HIREDATE <= '82-12-31';

SELECT * FROM EMP WHERE HIREDATE LIKE '82%';

-- 입사일이 1월인 사원의 모든 필드를 출력
SELECT * FROM EMP WHERE HIREDATE LIKE '__-01-__';

-- COMM 이 NULL 인 직원들의 모든 필드를 출력. (NULL 은 IS 연산자로 비교해야함.)
SELECT * FROM EMP WHERE COMM IS NULL;

-- COMM 이 NULL 아닌 직원들의 모든 필드를 출력. (NULL 은 IS 연산자로 비교해야함.)
SELECT * FROM EMP WHERE COMM IS NOT NULL;

---------------------------------------------------------
--BETWEEN a AND b <-> NOT BETWEEN a AND b
--IN(LIST) a AND b <-> NOT IN(LIST) 
--LIKE '와일드카드동반' <-> NOT LIKE '와일드카드동반'
-- IS NULL <-> IS NOT NULL
---------------------------------------------------------

-- JOB 에 '%'들어가는 직원의 모든 필드 출력
SELECT * FROM EMP WHERE JOB LIKE '%\%%' ESCAPE '\'; -- ESCAPE \ 이 기호뒤에 있는 문자를 이스케이프한다.
-- JOB 에 'A'들어가는 직원의 모든 필드 출력
SELECT * FROM EMP WHERE JOB LIKE '%A%';

--9 정렬 출력 (오름 차순 / 내림 차순)
SELECT * FROM EMP ORDER BY SAL; -- SAL 오름차순 (기본값 ASC)
SELECT * FROM EMP ORDER BY SAL DESC; -- SAL 내림차순

SELECT * FROM EMP ORDER BY ENAME; -- 이름을 오름차순 (A ~ , ㄱ ~ )  
SELECT * FROM EMP ORDER BY ENAME DESC;  -- 이름을 내림차순 (A ~ , ㄱ ~ )

SELECT * FROM EMP ORDER BY HIREDATE; -- 이름을 오름차순 (A ~ , ㄱ ~ )  
SELECT * FROM EMP ORDER BY HIREDATE DESC;  -- 이름을 내림차순 (A ~ , ㄱ ~ )

-- 연봉이 큰순서대로 올수 있지만 같을경우 다른 조건의 차순으로 정렬 할 수 있다
-- ORDER BY 필드1 DESC, 필드2 ASC ... 이런식의 다중 조건의 차순이 정해 질수 있다.
SELECT * FROM EMP ORDER BY SAL DESC, EMPNO;

-- 이름, 월급*14 {단, 월급 *14 가 높은 순서대로}

SELECT ENAME name, SAL*14 salary, DEPTNO dno 
FROM EMP 
WHERE DEPNO = 20 -- WHERE 절에는 별명이 올수 없다. 
ORDER BY salary; --별명 (ALIAS) 과 수식과 필드명이 모두 올 수 있다.

-- SQL 의 수행순서
-- SELECT ENAME name, SAL*14 salary, DEPTNO dno --3번
-- FROM EMP  -- 1번
-- WHERE DEPNO = 20 -- 2번
-- ORDER BY salary; -- 4번 ... 
-- 의 순서가 있다. 

-- 연봉(SAL*12+COMM) 이 2000 이상의 사원의 이름 연봉을 출력하되 연봉의 순서로 정렬한다.
SELECT ENAME, SAL*12+NVL(COMM,0) AS 연봉 
FROM EMP 
WHERE SAL*12+NVL(COMM,0) >= 15000
ORDER BY 연봉 DESC;

--1.	EMP 테이블에서 sal이 3000이상인 사원의 empno, ename, job, sal을 출력
SELECT EMPNO, ENAME, JOB, SAL 
FROM EMP
WHERE SAL >= 3000;

--2.	EMP 테이블에서 empno가 7788인 사원의 ename과 deptno를 출력
SELECT ENAME, DEPTNO 
FROM EMP
WHERE EMPNO = '7788';

--3.	연봉이 24000이상인 사번, 이름, 급여 출력 (급여순정렬)
SELECT EMPNO, ENAME, SAL
FROM EMP
WHERE (SAL*12+NVL(COMM,0)) >= 24000
ORDER BY SAL;

--4.	EMP 테이블에서 hiredate가 1981년 2월 20과 1981년 5월 1일 사이에 입사한 사원의 ename,job,hiredate을 출력하는 SELECT 문장을 작성 (단 hiredate 순으로 출력)
SELECT ENAME, JOB, HIREDATE
FROM EMP 
WHERE HIREDATE BETWEEN '81-02-20' AND '81-05-01'
ORDER BY HIREDATE;

--5.	EMP 테이블에서 deptno가 10,20인 사원의 모든 정보를 출력 (단 ename순으로 정렬)
SELECT *
FROM EMP
WHERE DEPTNO IN (10, 20)
ORDER BY ENAME;

--6.	EMP 테이블에서 sal이 1500이상이고 deptno가 10,30인 사원의 ename과 sal를 출력(단 HEADING을 employee과 Monthly Salary로 출력)
SELECT ENAME "employee", SAL "Monthly Salary"
FROM EMP
WHERE SAL >= 1500 AND DEPTNO IN (10,30)
ORDER BY SAL;

--7.	EMP 테이블에서 hiredate가 1982년인 사원의 모든 정보를 출력
SELECT *
FROM EMP
WHERE HIREDATE LIKE '1982%';

--8.	이름의 첫자가 C부터  P로 시작하는 사람의 이름, 급여 이름순 정렬
SELECT ENAME, SAL
FROM EMP
WHERE ENAME BETWEEN 'C' AND 'P' AND ENAME != 'Q'
ORDER BY ENAME, ENAME;

SELECT ENAME, SAL
FROM EMP
WHERE ENAME BETWEEN 'C%' AND 'P%' AND ENAME != 'Q'
ORDER BY ENAME;

--9.	EMP 테이블에서 comm이 sal보다 10%가 많은 모든 사원에 대하여 이름, 급여, 상여금을 출력하는 SELECT 문을 작성
SELECT ENAME, SAL, COMM
FROM EMP
WHERE COMM >= SAL*1.1;

--10.	EMP 테이블에서 job이 CLERK이거나 ANALYST이고 sal이 1000,3000,5000이 아닌 모든 사원의 정보를 출력
SELECT *
FROM EMP
WHERE JOB IN ('CLERK','ANALYST') AND SAL NOT IN (1000, 3000, 5000);  

--11.	EMP 테이블에서 ename에 L이 두 자가 있고 deptno가 30이거나 또는 mgr이 7782인 사원의 모든 정보를 출력하는 SELECT 문을 작성하여라.
SELECT *
FROM EMP
WHERE ENAME LIKE '%L%L%' AND (DEPTNO = 30 OR EMPNO = '7782');

--12.	사원 테이블에서 입사일이 81년도인 직원의 사번,사원명, 입사일, 업무, 급여를 출력
SELECT EMPNO, ENAME, HIREDATE, JOB, SAL
FROM EMP
WHERE HIREDATE LIKE '81%';

--13.	사원 테이블에서 입사일이 81년이고 업무가 'SALESMAN'이 아닌 직원의 사번, 사원명, 입사일, 업무, 급여를 검색하시오.
SELECT EMPNO, ENAME, HIREDATE, JOB, SAL
FROM EMP
WHERE HIREDATE LIKE '81%' AND JOB != 'SALESMAN';

SELECT EMPNO, ENAME, HIREDATE, JOB, SAL
FROM EMP
WHERE HIREDATE BETWEEN '81-01-01' AND '81-12-31' AND JOB != 'SALESMAN';

--14.	사원 테이블의 사번, 사원명, 입사일, 업무, 급여를 급여가 높은 순으로 정렬하고, 급여가 같으면 입사일이 빠른 사원으로 정렬하시오.
SELECT EMPNO, ENAME, HIREDATE, JOB, SAL
FROM EMP
ORDER BY SAL DESC, HIREDATE ASC;

--15.	사원 테이블에서 사원명의 세 번째 알파벳이 'N'인 사원의 사번, 사원명을 검색하시오
SELECT EMPNO, ENAME
FROM EMP
WHERE ENAME LIKE '__N%';

--16.	사원 테이블에서연봉(SAL*12)이 35000 이상인 사번, 사원명, 연봉을 검색 하시오.
SELECT EMPNO, ENAME, SAL*12 AS SALYEAR
FROM EMP
WHERE SAL*12 >= 35000;
