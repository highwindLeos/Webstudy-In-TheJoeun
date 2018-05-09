-- 함수
-- 1 단일행 함수 - INPUT 1행 OUTPUT 1행
SELECT ENAME, TO_CHAR(HIGRDATE, 'YYYY') YEAR FROM EMP;
SELECT ENAME, REPLACE(ENAME, 'A', 'B') FROM EMP;

-- 2 그룹 함수
SELECT SUM(SAL) FROM EMP;
SELECT AVG(SAL) FROM EMP;

SELECT DEPTNO, SUM(SAL) 
FROM EMP 
GROUP BY DEPTNO;

SELECT * FROM DUAL; -- 숫자 관련 함수를 시험하는 특수한 테이블 DUAL
DESC DUAL;

SELECT * FROM DUMMY;

-- 1 숫자 관련 단잃행함수
SELECT -10, ABS(-10) FROM DUAL; -- 절대값 : 숫자 관련 함수를 시험하는 특수한 테이블 DUAL에서 숫자 함수를 테스트

SELECT EXP(2) FROM DUMMY; -- e의 2승.

SELECT POWER(2,10) FROM DUAL; -- 2의 10승

SELECT 34.5678, ROUND(34.5678) FROM DUAL; -- 소수점 반올림. 
SELECT 34.5678, ROUND(34.5678, 2) FROM DUAL; -- 소수점 2자리 반올림. 
SELECT 34.5678, ROUND(34.5678, -1) FROM DUAL; -- 일의 자리에서 반올림

SELECT ENAME, SAL, ROUND(SAL, -2) AS "SALROUND" FROM EMP; -- 십의 자리에서 반올림

SELECT 34.5678, FLOOR(34.5678) FROM DUAL; -- 소수점 이하 버리기.

SELECT 34.5678, TRUNC(34.5678) FROM DUAL; -- 소수점 이하 버리기.

SELECT 34.5678, TRUNC(34.5678, 2) FROM DUAL; -- 소수점 2자리 버리기.

SELECT 34.5678, TRUNC(34.5678, -1) FROM DUAL; -- 일의 자리 버리기. ()?

SELECT 34.5678, CEIL(34.5678) FROM DUAL; -- 소수점에서 올림.

SELECT MOD(5, 3) FROM DUAL; -- 5 / 3 의 나머지 반환.

-- 사번이 홀수인 직원만 사번 이름 급여 입사일을 출력.
SELECT ENAME, SAL, HIREDATE
FROM EMP
WHERE MOD(EMPNO, 2) = 1; -- 사번이 홀수인 사람.

-- 2 문자처리 관련 단일행 함수.
SELECT 'WELcome TO oracle', UPPER('WELcome TO oracle') FROM DUAL; -- 케이스를 대문자로 변환

SELECT 'WELcome TO oracle', LOWER('WELcome TO oracle') FROM DUAL; -- 케이스를 소문자로 변환

SELECT 'WELcome TO oracle', INITCAP('WELcome TO oracle') FROM DUAL; -- 첫글자만 대문자로 변환

-- 이름 (첫글자만 대문자) , JOB (소문자)
SELECT INITCAP(ENAME), LOWER(JOB) FROM EMP;

-- SMITHCLERK
SELECT ENAME || ' - ' || JOB FROM EMP;

--CONCAT()
SELECT CONCAT(ENAME,JOB) FROM EMP;
SELECT CONCAT(ENAME, CONCAT(' - ', JOB)) FROM EMP;

SELECT ENAME || '(' || SAL ||')' FROM EMP;
SELECT CONCAT(ENAME ,CONCAT('(' , CONCAT(SAL, ')'))) SHOW FROM EMP; -- 위의 문장과 일치하는 결과.

-- SUBSTR()
SELECT SUBSTR('wELCOME to Oracle', 4, 6) FROM DUAL; -- 4번째 글자부터 6글자 추출
SELECT SUBSTR('wELCOME to Oracle', 12, 10) FROM DUAL; -- 12번째 글자부터 10글자 추출

SELECT SUBSTR('010-9999-9999', -5, 4) FROM DUAL; -- 문자열 뒤에서 5번째부터 4글자 추출

-- EMP TABLE 에서 이름이 E 로 끝나는 직원의모든 필드를 출력
SELECT * FROM EMP WHERE ENAME LIKE '%E';
SELECT * FROM EMP WHERE SUBSTR(ENAME, -1, 1) = 'E'; -- 위의 문장과 같은 문장.

-- 입사년도가 83년도인 직원들의 모든 필드 출력.
SELECT * FROM EMP WHERE HIREDATE LIKE '83%';
SELECT * FROM EMP WHERE SUBSTR(HIREDATE, 1, 2) = '83'; 

-- 9월에 입사한 직우너들의 모든 필드를 출력하세요.
SELECT * FROM EMP WHERE HIREDATE LIKE '%-09-%';
SELECT * FROM EMP WHERE SUBSTR(HIREDATE, 4, 2) = '09';

-- SUBSTRB() : BYTE 단위로 출력 = SUBSTRB(str, 시작할위치,추출할갯수) : 문자를 잘라 추출 (한글은 2byte)
SELECT SUBSTR('ABCDEFG', 3, 2), SUBSTRB('ABCDEFG', 3, 2) FROM DUAL;
SELECT SUBSTR('데이터베이스', 4, 3), SUBSTRB('데이터베이스', 4, 3) FROM DUAL;
-- 함수에 B 가 적흰 함수의 특징 : BYTE 로 계산한 값들을 가져온다.

-- INSTR(string, str, n, k); = string 의 n번째 문자부터 k번째 오는 str 을 찾아서 몇번째인지 찾아서 반환.
SELECT INSTR('ABC ABC ABC', 'B' , 3, 2), INSTRB('ABC ABC ABC', 'B' , 3, 2) FROM DUAL;
SELECT INSTR('ABC ABC', 'B' , 3, 2), INSTRB('ABC ABC', 'B' , 3) FROM DUAL; 
SELECT INSTR('데이터베이스', '이', 3 ),INSTRB('데이터베이스', '이', 3 ) FROM DUAL;


-- LENGTH(string) 글자의 길이를 반환. string 의 글자수를 반환.
SELECT LENGTH('Oracle'), LENGTHB('Oracle') FROM DUAL;
SELECT LENGTH('오라클'), LENGTHB('오라클') FROM DUAL;

-- LPAD(필드, 자릿수, 문자), RPAD : 입력 받은 문자열과 기호를 정렬하여 특정 길이의 문자열로 반환한다
SELECT ENAME, LPAD(SAL, 10, '*') FROM EMP;
SELECT ENAME, RPAD(SAL, 10, '*') FROM EMP;

SELECT RPAD(SUBSTR(ENAME, 1, 1), LENGTH(ENAME), '*') "ENAME", LPAD(SAL, 8, '*') "SAL" FROM EMP;
-- 82년도 12월에 입사한 직원의 모든 필드를 출력
SELECT * FROM EMP WHERE SUBSTR(HIREDATE, 1, 5) = '82-12';

-- 사번 이름 JOB 메니저 이름의 문자열 수만큼 출력
-- 7369 SMITH CLEAK
-- 7369 ALLEN SALES
SELECT EMPNO, ENAME, SUBSTR(JOB, 1, LENGTH(ENAME))
FROM EMP;

-- REPLACE(필드, 찾을 문자, 변경할 문자)
SELECT REPLACE(ENAME, 'A', 'B') FROM EMP; -- 'A' 를 'B' 로 변경.
SELECT TRANSLATE(SAL, '0123456789', '영일이삼사오육칠팔구') FROM EMP;

-- TRIM() : 좌우의 여백을 잘라서 출력 가운데 띄어 쓰기는 제거 안함.
SELECT '    Oracle     ' FROM DUAL;
SELECT LTRIM('    Oracle     ') MSG FROM DUAL;
SELECT RTRIM('    Oracle     ') MSG FROM DUAL;
SELECT TRIM('    Oracle     ') MSG FROM DUAL;

SELECT TRIM('a' FROM 'aaaaORAaaCLEaaaa') FROM DUAL; --좌우의 a 를 모두삭제

-- 날짜 관련 단일행 함수. : SYSDATE키워드를 이해한다.
SELECT SYSDATE FROM DUAL;  -- 현제 서버시간을 출력한다.

SELECT ENAME, HIREDATE, TRUNC(MONTHS_BETWEEN(SYSDATE, HIREDATE)) "근무개월수" FROM EMP;

SELECT SYSDATE-1 "어제", SYSDATE "오늘", SYSDATE+1 "내일" FROM DUAL;  -- 현제 서버시간을 출력한다.

SELECT SYSDATE "대출일", SYSDATE+14 "반납예정일" FROM DUAL;  -- 현제 서버시간을 출력한다.

-- EMP 테이블로부터 입사한 날수 주수 달수
SELECT ENAME, HIREDATE, SYSDATE, 
    TRUNC(SYSDATE - HIREDATE) "날수", 
    TRUNC((SYSDATE - HIREDATE) / 7) "주수", 
    TRUNC(MONTHS_BETWEEN(SYSDATE, HIREDATE)) "달수"
FROM EMP;


-- SELECT ADD_MONTHS() : 월수를 더한다.
SELECT ADD_MONTHS(SYSDATE, 6) FROM DUAL; -- 현제시간에서 6개월을 더한 날을 출력.
SELECT ADD_MONTHS(SYSDATE, -6) FROM DUAL; -- 현제시간에서 6개월을 뺀날을 출력.

SELECT SYSDATE FROM DUAL;

-- SELECT NEXT_DAY()
SELECT NEXT_DAY(SYSDATE, '토요일') FROM DUAL; -- 특정날짜에서 최초로 도래하는 요일을 반환.
SELECT ENAME, NEXT_DAY(HIREDATE, '토요일' ) "첫휴일" FROM EMP;

-- 특정한 날짜 4월 25일 - 4월 1일 로 / 반올림(5월 1일) / 4월 30일
SELECT ENAME, HIREDATE, TRUNC(HIREDATE, 'MONTH') FROM EMP;
SELECT ENAME, HIREDATE, ROUND(HIREDATE, 'MONTH') FROM EMP;

SELECT ENAME, HIREDATE, LAST_DAY(HIREDATE) 월급날 FROM EMP; -- 마지막날을 출력

SELECT SYSDATE, TRUNC(SYSDATE, 'YEAR') FROM DUAL;  -- 년도에서 짜름. 1월 1일
SELECT SYSDATE, TRUNC(SYSDATE, 'MONTH') FROM DUAL;  -- 월에서 짜름. 이달 1일
SELECT SYSDATE, TRUNC(SYSDATE, 'DAY') FROM DUAL;  -- 일에서 짜름. 전일요일

SELECT SYSDATE, ROUND(SYSDATE, 'YEAR') FROM DUAL;  -- 년도에서 짜름.
SELECT SYSDATE, ROUND(SYSDATE, 'MONTH') FROM DUAL;  -- 월에서 짜름.
SELECT SYSDATE, ROUND(SYSDATE, 'DAY') FROM DUAL;  -- 월에서 짜름. 다음주일요일로 붙음.

-- 82년도에 입사한 직원들 모든 필드
SELECT * FROM EMP WHERE HIREDATE LIKE '82%'; -- 

-- EXTRACT() 어떤 부분만 추출해서 출력.
SELECT *  FROM EMP WHERE EXTRACT(YEAR FROM HIREDATE) = 1982; -- 1982 년에 입사한 직원출력.

SELECT *  FROM EMP WHERE EXTRACT(MONTH FROM HIREDATE) = 9; -- 9월 에 입사한 직원 출력.

SELECT ENAME, EXTRACT(DAY FROM HIREDATE) FROM EMP; -- 일만 추출.

-- 4 형 변환 함수

-- TO_CHAR(날짜 변수, 날짜 포맷) : DATE -> 문자 (VARCHAR) : NUMBER -> 문자
-- TO_DATE() : 문자 -> DATE (VARCHAR)
-- TO NUMBER() : 문자 -> NUMBER형 NUMBER형

--- TO_CHAR(날짜 변수, 날짜 포맷) : DATE -> 문자 (VARCHAR) : NUMBER -> 문자
-- YYYY년 MM월 DD 일 DAY DYDLF AM, PM (오전 오후) HH12 HH24 MI분 SS초
SELECT TO_CHAR(SYSDATE, 'YYYY"년" MM"월" DD"일" DAY AM HH12"시" MI"분" SS"초"') FROM DUAL; -- DATE -> 문자열
SELECT ENAME, HIREDATE, TO_CHAR(HIREDATE, 'YY-MM-DD HH24 : MI') FROM EMP;

-- 82년도에 입사한 직원들 모든필드.
SELECT * FROM EMP WHERE EXTRACT(YEAR FROM HIREDATE) = 1982;
SELECT * FROM EMP WHERE TO_CHAR(HIREDATE, 'YY') = '82';

-- TO_CHAR() NUMBER -> 문자열
-- 9 자릿수를 나타내고 자릿수가 맟지 않으면 출력 X
-- 0 자릿수를 나타내고 자릿수가 맞지 않아도 0이 출력
-- 천의 자릿수 구문용 ,
-- 소수점 구분용 .
-- L (지역 통화 기호)
-- $ 달러화 표시

SELECT ENAME, SAL, TO_CHAR(SAL, '$9,999,999') "달러", TO_CHAR(SAL, 'L9,999,999') "지역통화", TO_CHAR(SAL, '0,000.00') "소수점" 
FROM EMP;

-- TO_DATE(문자데이터, '날짜포멧') 문자 -> DATE형
SELECT TO_DATE('04-25-2018', 'MM-DD-YYYY') FROM DUAL;

-- 81년 2월 20일 부터 81년도 5월 20일 사이에 입사한 사람의 모든필드
SELECT * FROM EMP 
WHERE HIREDATE BETWEEN '81-02-20' AND '81-05-20';

SELECT * FROM EMP 
WHERE HIREDATE BETWEEN TO_DATE('1981-02-20', 'YYYY-MM-DD') AND TO_DATE('1981-05-20', 'YYYY-MM-DD');

-- 오늘이 새해부터 몇일 지났는지?
SELECT TRUNC(SYSDATE-TO_DATE('2018-01-01', 'YYYY-MM-DD')) DAY FROM DUAL;


-- TO NUMBER('문자데이터', 숫자포멧) : 문자 -> NUMBER형
-- 9 자릿수를 나타내고 자릿수가 맟지 않으면 출력 X
-- 0 자릿수를 나타내고 자릿수가 맞지 않아도 0이 출력
-- 천의 자릿수 구문용 ,
-- 소수점 구분용 .
-- L (지역 통화 기호)
-- $ 달러화 표시
SELECT TO_NUMBER('20,000', '99,999') FROM DUAL;

-- 5 NVL(NULL일수도 있는 데이터, NULL 값을 대체할 값) : NULL 관련 함수 특정한 문자나 숫자로 변환하기위한

-- 사번 이름 직속상사의 사번 (NULL -> 없음)
SELECT EMPNO, ENAME, NVL(TO_CHAR(MGR), 'CEO') FROM EMP;

-- 6 DECODE(표현식, 조건1, 결과1, 조건2, 결과2, 조건3, 결과3, 기본결과n ) 함수 
SELECT ENAME, DEPTNO, DECODE(DEPTNO, 10, 'ACCOUNTING',
                                    20, 'RESERACH',
                                    30, 'SALES',
                                    40, 'OPERATION', 'ETC') AS "DNAME" 
FROM EMP;

SELECT ENAME,DEPTNO,
    CASE WHEN DEPTNO = 10 THEN 'ACCOUNTING'
         WHEN DEPTNO = 20 THEN 'RESERACH'
         WHEN DEPTNO = 30 THEN 'SALES'
         WHEN DEPTNO = 40 THEN 'OPERATION'
         ELSE 'ETC'
    END AS "DNAME" FROM EMP;
--- 위 아래의 문장은 같은 문장.
SELECT ENAME, DEPTNO,
    CASE DEPTNO WHEN 10 THEN 'ACCOUNTING'
                WHEN 20 THEN 'RESERACH'
                WHEN 30 THEN 'SALES'
                WHEN 40 THEN 'OPERATION'
                ELSE 'ETC'
    END AS "DNAME" FROM EMP;
    
-- 직급이 ANALTST 면 10% 급여 인상, SALESMAN 이면 20% 급여인상 MANAGER 는 30% 인상
-- CLERK 면 40% 급여인상 그외 사원은 급여동결
-- 사번 이름 급여 JOB 인상될 급여.
SELECT EMPNO, ENAME, SAL, DECODE(JOB,'ANALTST', ROUND(SAL*1.1),
                                    'SALESMAN', ROUND(SAL*1.2),
                                    'MANAGER', ROUND(SAL*1.3),
                                    'CLERK', ROUND(SAL*1.4), SAL) AS "인상급여" 
                                FROM EMP;

SELECT EMPNO, ENAME, SAL,
    CASE JOB    WHEN 'ANALTST' THEN ROUND(SAL*1.1)
                WHEN 'SALESMAN' THEN ROUND(SAL*1.2)
                WHEN 'MANAGER' THEN ROUND(SAL*1.3)
                WHEN 'CLERK' THEN ROUND(SAL*1.4)
                ELSE SAL
    END AS "인상급여" FROM EMP;
    
-- 9 그외 : EMP TABLE 의 계층적 표현
--  LEVEL : 계층적 질의문에서 검색된 결과에 대한 계층별로 레벨 표시
--?	START WITH : 계층적인 출력 형식을 표현하기 위한 최상위 행
--?	CONNECT BY PRIOR : 계층 관계의 데이터를 지정하는 컬럼
SELECT LEVEL, LPAD(' ', LEVEL * 3) || ENAME, EMPNO, MGR 
FROM EMP
WHERE ENAME <> 'CLARK'
    START WITH MGR IS NULL
    CONNECT BY PRIOR EMPNO = MGR;
    
--------------------------------------------------------------------
-- 오늘의 예제
--------------------------------------------------------------------
--1 현재 날짜를 출력하고 열 레이블은 Current Date로 출력하는 SELECT 문장을 기술하시오.
SELECT SYSDATE "Current Date" FROM DUAL;

--2 EMP 테이블에서 현재 급여에 15%가 증가된 급여를 사원번호,이름,업무,급여,증가된 급여(New Salary),증가액(Increase)를 출력하는 SELECT 문장을 기술하시오.
SELECT EMPNO, ENAME, JOB, SAL, TRUNC(SAL*1.15, 2) "New Salary", TRUNC((SAL*1.15)-SAL, 2) "INCREASE"
FROM EMP;

--3 EMP 테이블에서 이름,입사일,입사일로부터 6개월 후 돌아오는 월요일 구하여 출력하는 SELECT 문장을 기술하시오.
SELECT ENAME, HIREDATE, NEXT_DAY(ADD_MONTHS(HIREDATE, 6), '월요일') "돌아온 월요일"
FROM EMP;

--4 EMP 테이블에서 이름,입사일, 입사일로부터 현재까지의 월수,급여, 입사일부터 현재까지의 급여의 총계를 출력하는 SELECT 문장을 기술하시오.
SELECT ENAME, HIREDATE,  TRUNC(MONTHS_BETWEEN(SYSDATE, HIREDATE)) "월수", SAL, TRUNC(MONTHS_BETWEEN(SYSDATE, HIREDATE)) * SAL "총급여"
FROM EMP;

--5 EMP 테이블에서 모든 사원의 이름과 급여(15자리로 출력 좌측의 빈 곳은 “*”로 대치)를 출력하는 SELECT 문장을 기술하시오.
SELECT ENAME, LPAD(SAL, 15, '*')
FROM EMP;

--6 EMP 테이블에서 모든 사원의 정보를 이름,업무,입사일,입사한 요일을 출력하는 SELECT 문장을 기술하시오.
SELECT ENAME, JOB,  HIREDATE, TO_CHAR(HIREDATE, 'DAY') "요일"
FROM EMP; 

--7 EMP 테이블에서 이름의 길이가 6자 이상인 사원의 정보를 이름,이름의 글자수,업무를 출력하는 SELECT 문장을 기술하시오.
SELECT ENAME,LENGTH(ENAME), JOB
FROM EMP
WHERE LENGTH(ENAME) >= 6;

--8 EMP 테이블에서 모든 사원의 정보를 이름, 업무, 급여, 보너스, 급여+보너스를 출력하는 SELECT 문장을 기술하시오
SELECT ENAME, JOB, SAL, COMM, SAL+NVL(COMM,'0')
FROM EMP;

--9 사원 테이블의 사원명에서 2번째 문자부터 3개의 문자를 추출하시오. 
SELECT SUBSTR(ENAME, 2, 3) FROM EMP;

------------------------------------------------------------------------------------------------

--10 사원 테이블에서 입사일이 12월인 사원의 사번, 사원명, 입사일을 검색하시오
SELECT EMPNO, ENAME, HIREDATE
FROM EMP
WHERE EXTRACT(MONTH FROM HIREDATE) = 12;

SELECT EMPNO, ENAME, HIREDATE
FROM EMP
WHERE TO_CHAR(HIREDATE, 'MM') = 12;

--11 다음과 같은 결과를 검색할 수 있는 SQL 문장을 작성하시오
--EMPNO		ENAME		급여
--7369		SMITH		*******800
--7499		ALLEN		******1600
--7521		WARD		******1250
SELECT EMPNO, ENAME, LPAD(SAL, 10, '*') "급여" FROM EMP;

--12 다음과 같은 결과를 검색할 수 있는 SQL 문장을 작성하시오
--EMPNO	 ENAME 	입사일
--7369	  SMITH		1980-12-17
SELECT EMPNO, ENAME, TO_CHAR(HIREDATE, 'YYYY-MM-DD') AS 입사일 FROM EMP;

--13 사원 테이블에서 급여에 따라 사번, 이름, 급여, 등급을 검색하는 SQL 문장을 작성 하시오. 
--(Hint : CASE 함수 사용) 급여가 0~1000 E / 1001~2000 D / 2001~3000 C / 3001~4000 B / 4001~5000 A
--(cf) 급여가- 0~999 E / 1000~1999 D / 2000~2999 C / 3000~3999 B / 4000이상 A
SELECT EMPNO, ENAME, SAL,
                    CASE WHEN SAL BETWEEN 0 AND 999 THEN 'E'
                         WHEN SAL BETWEEN 1000 AND 1999 THEN 'D'
                         WHEN SAL BETWEEN 2000 AND 2999 THEN 'C'
                         WHEN SAL BETWEEN 3000 AND 3999 THEN 'B'
                    ELSE 'A' END AS GRADE
FROM EMP
ORDER BY GRADE;

SELECT EMPNO, ENAME, SAL,
                    CASE WHEN SAL >= 0 AND SAL < 999 THEN 'E'
                         WHEN SAL >= 1000 AND SAL < 1999 THEN 'D'
                         WHEN SAL >= 2000 AND SAL < 2999 THEN 'C'
                         WHEN SAL >= 3000 AND SAL < 3999 THEN 'B'
                    ELSE 'A' END AS GRADE
FROM EMP
ORDER BY GRADE;

SELECT EMPNO, ENAME, SAL,
    CASE TRUNC((SAL-1) /1000) WHEN 0  THEN 'E'
                              WHEN 1  THEN 'D'
                              WHEN 2  THEN 'C'
                              WHEN 3  THEN 'B'
                    ELSE 'A' END AS GRADE
FROM EMP 
ORDER BY GRADE;
-- DECODE를 이용한 방식.
SELECT EMPNO, ENAME, SAL, DECODE(TRUNC((SAL-1) /1000),
                                                        0,   'E',
                                                        1,   'D',
                                                        2,   'C',
                                                        3,   'B',
                                                             'A') AS GRADE
FROM EMP
ORDER BY GRADE;

--14. 사원 테이블에서 부서 20 중 급여 앞에 $를 삽입하고3자리마다 ,를 출력
SELECT ENAME, JOB, TO_CHAR(SAL, '$999,999') "급여"
FROM EMP
WHERE DEPTNO = 20;
