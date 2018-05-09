--1. 그룹 함수. --

SELECT SUM(SAL) FROM EMP; -- 합계 함수
SELECT AVG(SAL) FROM EMP; -- 평귱함수
SELECT COUNT(SAL) FROM EMP; -- 데이터의 갯수

SELECT ROUND(SUM(SAL) / COUNT(SAL)), ROUND(AVG(SAL)) FROM EMP; -- 반올림

SELECT COMM FROM EMP;
SELECT SUM(COMM) FROM EMP; --그룹함수는 더하는 중간에 NULL 이 있어도 제외하고 계산되어 나오게된다.
SELECT AVG(COMM), COUNT(COMM), SUM(COMM) / FROM EMP;

-- SUM  AVG STDDEV VARIANCE 은 데이터타입이 NUMBER만 가능. 

SELECT COUNT(SAL), COUNT(COMM), COUNT(*) FROM EMP;

SELECT MAX(SAL), MIN(SAL) FROM EMP; 
SELECT MAX(ENAME), MIN(ENAME) FROM EMP; -- VARCHR 형이라면 아스키코드의 높은것 낮은것을 가져온다.
SELECT MAX(HIREDATE) "최후입사일", MIN(HIREDATE) "최초입사일" FROM EMP; -- 최후 입사일 최초 입사일

SELECT SAL, MAX(SAL) FROM EMP; -- GROUP BY 절 없이는 같은 필드에 그룹함수를 쓸수 없다.
SELECT COUNT(DISTINCT JOB) FROM EMP; -- 중복되지 않는 JOB 수

SELECT ROUND(AVG(SAL)), ROUND(STDDEV(SAL)) FROM EMP; -- STDDEV() 표준편차

SELECT ROUND(STDDEV(sal)) 표준편차,
    ROUND(STDDEV(SAL) * STDDEV(SAL)) 분산,
    ROUND(VARIANCE(SAL)) 분산 FROM EMP;

-- 가장 최근에 입사한 사원과 가장 최초에 입사한 사원의 입사일과 근무일을 출력.
SELECT MAX(HIREDATE) || ' : ' || MAX(TRUNC(SYSDATE - HIREDATE)) "최근입사 근무일", 
       MIN(HIREDATE) || ' : ' || MIN(TRUNC(SYSDATE - HIREDATE)) "최후입사 근무일"
FROM EMP;

-- 부서번호가 10번인 사원 중 상여 를 받는 사원수는
SELECT COUNT(COMM)
FROM EMP
WHERE DEPTNO = 10;

SELECT COMM
FROM EMP
WHERE DEPTNO = 10;

-- 
SELECT COUNT(COMM) FROM EMP WHERE DEPTNO = 10;
SELECT COUNT(COMM) FROM EMP WHERE DEPTNO = 20;
SELECT COUNT(COMM) FROM EMP WHERE DEPTNO = 30; -- 4명

-- GROUP BY 절 :  GROUP BY 절 다음에는 칼럼의 별칭을 사용할 수 없고, 반드시 칼럼명을 기술해야 한다. 
SELECT DEPTNO, COUNT(COMM) 
FROM EMP
GROUP BY DEPTNO
ORDER BY DEPTNO;

-- 부서별 급여 평균
SELECT DEPTNO, TRUNC(AVG(SAL))
FROM EMP
GROUP BY DEPTNO
ORDER BY DEPTNO;

-- 부서별 상여금을 받는 사원수
SELECT DEPTNO "NO", COUNT(*) , COUNT(COMM)
FROM EMP 
GROUP BY DEPTNO
ORDER BY NO;

-- 입사년도 별 사원의 급여 평균을 출력하세요.
SELECT TO_CHAR(HIREDATE,'YYYY') HIRE, AVG(SAL)
FROM EMP
GROUP BY TO_CHAR(HIREDATE, 'YYYY')
ORDER BY HIRE;

SELECT EXTRACT(YEAR FROM HIREDATE) HIRE, AVG(SAL)
FROM EMP
GROUP BY EXTRACT(YEAR FROM HIREDATE)
ORDER BY HIRE;

-- 부서명 별 급여 합계
SELECT SUM(SAL) 
FROM EMP E, DEPT D
WHERE E.DEPTNO = D.DEPTNO
GROUP BY DNAME;

----------------------------------------------------------
--                      GROUP BY 예제                   --
----------------------------------------------------------
--(1)	사원 테이블에서 인원수,최대 급여,최소 급여,급여의 합을 계산하여 출력하는 SELECT 문장을 작성하여라.
SELECT COUNT(ENAME), MAX(SAL), MIN(SAL), SUM(SAL)
FROM EMP;

--(2)	사원테이블에서 업무별 인원수를 구하여 출력하는 SELECT 문장을 작성하여라.
SELECT JOB, COUNT(ENAME)
FROM EMP
GROUP BY JOB;

--(3)	사원테이블에서 최고 급여와 최소 급여의 차이는 얼마인가 출력하는 SELECT문장을 작성하여라.
SELECT (MAX(SAL) - MIN(SAL)) "급여차이"
FROM EMP;

--(4)	각 부서별로 인원수, 급여 평균, 최저 급여, 최고 급여, 급여의 합을 출력하되 급여의 합이 많은 순으로 출력하라.
SELECT COUNT(ENAME), TRUNC(AVG(SAL)), MIN(SAL), MAX(SAL), SUM(SAL) "SALTOTAL"
FROM EMP
GROUP BY DEPTNO
ORDER BY SALTOTAL DESC;

--(5)	부서별, 업무별 그룹하여 결과를 부서번호, 업무, 인원수, 급여의 평균, 급여의 합을 구하여 출력하라(출력결과는 부서번호, 업무순으로 오름차순 정렬)
SELECT DEPTNO, JOB, COUNT(*), AVG(SAL), SUM(SAL)
FROM EMP
GROUP BY DEPTNO, JOB
ORDER BY DEPTNO, JOB;

--(6)	업무별, 부서별 그룹하여 결과를 부서번호, 업무, 인원수, 급여의 평균, 급여의 합을 구하여 출력하라.(출력결과는 업무순, 부서번호 순 오름차순 정렬)
SELECT DEPTNO, JOB, COUNT(*), AVG(SAL), SUM(SAL)
FROM EMP
GROUP BY JOB, DEPTNO
ORDER BY JOB, DEPTNO;

----------------------------------------------------------

-- 3 HAVING 절 : 그룹의 대한 조건절을 정의 할때 쓰는 예약어.
-- 업무별 인원수를 구하여 인원수가 3명이상인 업무에 대해 인원수를 출력.

SELECT JOB, COUNT(*) CNT FROM EMP
--WHERE COUNT(*) >= 3 -- 오류가 남.  그룹함수의 대한 조건은  WHERE 절에 올수 없음.
GROUP BY JOB
HAVING COUNT(*) >= 3
ORDER BY JOB;

-----------------------------------
-- 
-----------------------------------
-- SELECT column, group_function --
-- FROM table                    --
-- [WHERE condition]             --
-- [GROUP BY group_by_expression]--
-- [HAVING   group_condition]    --
-- [ORDER BY column] ;           --
-----------------------------------


----------------------------------------------------------
--                      GROUP BY 예제    2                --
----------------------------------------------------------
--(7)	사원수가 5명상 넘는 부서번호와 사원수를 출력하시오.
SELECT DEPTNO, COUNT(*)
FROM EMP
GROUP BY DEPTNO
HAVING COUNT(*) >= 5;

--(8)	사원수가 5명이상 넘는 부서명과 사원수를 출력하시오
SELECT D.DNAME, COUNT(*)
FROM EMP E, DEPT D
WHERE E.DEPTNO = D.DEPTNO
GROUP BY D.DNAME
HAVING  COUNT(*) >= 5;

--(9)	사원 테이블에서 업무별 급여의 평균이 3000이상인 업무에 대해서 업무명, 평균 급여, 급여의 합을 구하여 출력하라
SELECT JOB, AVG(SAL), SUM(SAL)
FROM EMP
GROUP BY JOB
HAVING  AVG(SAL) >= 3000;

--(10)	사원테이블에서 전체 급여가 5000을 초과하는 각 업무에 대해서 업무와 급여합계를 출력하라 단, 급여 합계로 내림차순 정렬하라.
SELECT JOB, SUM(SAL) SALTOTAL
FROM EMP
GROUP BY JOB
HAVING  SUM(SAL) > 5000
ORDER BY SALTOTAL DESC;

--(11)	부서별 급여평균, 부서별 급여합계, 부서별 최소급여를 출력하라.
SELECT D.DNAME, TRUNC(AVG(SAL)), SUM(SAL) SALTOTAL, MIN(SAL)
FROM EMP E, DEPT D
WHERE E.DEPTNO = D.DEPTNO
GROUP BY D.DNAME;

--(12)	위의 11번을 수정하여, 부서별 급여평균 최대치, 부서별 급여합의 최대치, 부서별 최소급여의 최대치를 출력하라.
SELECT TRUNC(MAX(AVG(SAL))) AVGMAX, MAX(SUM(SAL)) TOTALMAX, MAX(MIN(SAL)) MINMAX
FROM EMP E, DEPT D
WHERE E.DEPTNO = D.DEPTNO
GROUP BY D.DNAME;

--(13)	사원 테이블에서 아래의 결과를 출력하는 SELECT 문장을 작성하여라.
--     H_YEAR	COUNT(*)	MIN(SAL)	MAX(SAL)	AVG(SAL)	SUM(SAL)
--		80	  1		800		800		800		800
--		81	 10		950		5000		2282.5		22825
--		82	  2		1300		3000		2150		4300
--		83	  1		1100		1100		1100		1100
SELECT TO_CHAR(HIREDATE, 'YY') H_YEAR, COUNT(*), MIN(SAL), MAX(SAL), AVG(SAL), SUM(SAL)
FROM EMP
GROUP BY TO_CHAR(HIREDATE, 'YY')
ORDER BY H_YEAR;

-----------------------------------
-- 4. 피벗 테이블. 
-----------------------------------
-- 부서별 JOB 별 급여합을 알고 싶다.
SELECT DEPTNO, JOB, SUM(SAL) FROM EMP
GROUP BY ROLLUP(DEPTNO, JOB)
ORDER BY DEPTNO, JOB;

--- 피벗 테이블 표현 1단계
SELECT DEPTNO, DECODE(JOB, 'CLERK', SAL, 0) CLERK,
               DECODE(JOB, 'MANAGER', SAL, 0) MANAGER,
               DECODE(JOB, 'PRESIDENT', SAL, 0) PRESIDENT,
               DECODE(JOB, 'ANALYST', SAL, 0) ANALYST,
               DECODE(JOB, 'SALESMAN', SAL, 0) SALESMAN
            FROM EMP;
            
--- 피벗 테이블 표현 2단계
SELECT DEPTNO, SUM(DECODE(JOB, 'CLERK',     SAL, 0)) CLERK,
               SUM(DECODE(JOB, 'MANAGER',   SAL, 0)) MANAGER,
               SUM(DECODE(JOB, 'PRESIDENT', SAL, 0)) PRESIDENT,
               SUM(DECODE(JOB, 'ANALYST',   SAL, 0)) ANALYST,
               SUM(DECODE(JOB, 'SALESMAN',  SAL, 0)) SALESMAN
            FROM EMP
            GROUP BY DEPTNO; 
            
--- 피벗 테이블 표현 3단계 : 합계추가
SELECT DEPTNO, SUM(DECODE(JOB, 'CLERK',     SAL, 0)) CLERK,
               SUM(DECODE(JOB, 'MANAGER',   SAL, 0)) MANAGER,
               SUM(DECODE(JOB, 'PRESIDENT', SAL, 0)) PRESIDENT,
               SUM(DECODE(JOB, 'ANALYST',   SAL, 0)) ANALYST,
               SUM(DECODE(JOB, 'SALESMAN',  SAL, 0)) SALESMAN,
               SUM(SAL) "TOTAL"
            FROM EMP
            GROUP BY ROLLUP(DEPTNO); -- ROLLUP() : 소계를 내고 ORDER BY 까지 해준다. (이 엑셀)
            
-- ROLLUP()  : 소계를 내고 ORDER BY 까지 해준다.
SELECT DEPTNO, SUM(SAL) FROM EMP
GROUP BY DEPTNO;

SELECT DEPTNO, SUM(SAL) FROM EMP
GROUP BY ROLLUP(DEPTNO);

SELECT DEPTNO, TRUNC(AVG(SAL), 2) FROM EMP
GROUP BY ROLLUP(DEPTNO);

SELECT DEPTNO, JOB, TRUNC(AVG(SAL), 2) FROM EMP
GROUP BY ROLLUP(DEPTNO, JOB);

SELECT JOB, DEPTNO, TRUNC(AVG(SAL), 2) FROM EMP
GROUP BY ROLLUP(JOB, DEPTNO);

--(14)	 사원테이블에서 아래의 결과를 출력하는 SELECT 문 작성
--TOTAL		1980	1981	1982	1983
--14		1	    10	    2	    1
SELECT NVL(TO_CHAR(HIREDATE, 'YYYY'), 'TOTAL') H_YEAR, COUNT(*)
FROM EMP
GROUP BY ROLLUP(TO_CHAR(HIREDATE, 'YYYY'))
ORDER BY H_YEAR;

SELECT SUM(COUNT(*)) TOTAL,  SUM(DECODE(TO_CHAR(HIREDATE, 'YYYY'), '1980', COUNT(*), 0)) "1980",
                             SUM(DECODE(TO_CHAR(HIREDATE, 'YYYY'), '1981', COUNT(*), 0)) "1981",
                             SUM(DECODE(TO_CHAR(HIREDATE, 'YYYY'), '1982', COUNT(*), 0)) "1982",
                             SUM(DECODE(TO_CHAR(HIREDATE, 'YYYY'), '1983', COUNT(*), 0)) "1983"
FROM EMP
GROUP BY TO_CHAR(HIREDATE, 'YYYY');

--(15)	사원테이블에서 아래의 결과를 출력하는 SELECT 문 작성(JOB 순으로 오름차순 정렬)
--JOB		DEPTNO10	DEPTNO20	DEPTNO30     TOTAL
--ANALYST	     0		   6000		    0		6000
--CLERK		  1300		   1900		  950		4150
--….
--SALESMAN	      0	 		0	 5600		 5600
SELECT JOB, SUM(DECODE(DEPTNO, 10, SAL, 0)) "DEPTNO10",
            SUM(DECODE(DEPTNO, 20, SAL, 0)) "DEPTNO20",
            SUM(DECODE(DEPTNO, 30, SAL, 0)) "DEPTNO30",
            SUM(SAL) TOTAL
        FROM EMP
        GROUP BY JOB
        ORDER BY JOB;

--(16)	 사원테이블에서 최대급여, 최소급여, 전체급여합, 평균을 구하시오
SELECT MAX(SAL), MIN(SAL), SUM(SAL), TRUNC(AVG(SAL), 2)
FROM EMP ;

--(17)	사원테이블에서 부서별 인원수를 구하시오
SELECT D.DNAME, COUNT(*)
FROM EMP E, DEPT D
WHERE E.DEPTNO = D.DEPTNO
GROUP BY D.DNAME;

--(18)	 사원 테이블에서 부서별 인원수가 6명이상인 부서코드를 구하시오
SELECT DEPTNO
FROM EMP
GROUP BY DEPTNO
HAVING COUNT(DEPTNO) >= 6;

--(19)	사원테이블에서 다음과 같은 결과가 나오게 하시오
--DNAME               CLERK    MANAGER  PRESIDENT    ANALYST   SALESMAN
--ACCOUNTING            1300       2450       5000          0          0
--RESEARCH               1900       2975          0       6000          0
--SALES                 950       2850          0          0       5600
SELECT D.DNAME, SUM(DECODE(JOB, 'CLERK', SAL, 0)) "CLERK",
            SUM(DECODE(JOB, 'MANAGER', SAL, 0)) "MANAGER",
            SUM(DECODE(JOB, 'PRESIDENT', SAL, 0)) "PRESIDENT",
            SUM(DECODE(JOB, 'ANALYST', SAL, 0)) "ANALYST",
            SUM(DECODE(JOB, 'SALESMAN', SAL, 0)) "SALESMAN"
        FROM EMP E, DEPT D
        WHERE E.DEPTNO = D.DEPTNO
        GROUP BY D.DNAME
        ORDER BY D.DNAME;


--(20)	 사원테이블에서 급여가 높은 순서대로 등수를 부여하여 다음과 같은 결과가 나오게 하시오. (힌트 self join, group by, count사용)
--?	ENAME	    등수
--?	________________________
--?	KING		1
--?	SCOTT		2
--?	FORD		2
--?	JONES		4
--?	……
SELECT  E1.ENAME, COUNT(E2.ENAME) RANGKING
FROM EMP E1, EMP E2
WHERE E1.SAL <= E2.SAL
GROUP BY E1.ENAME
ORDER BY RANGKING;

-- 동점일 경구 등수 조정
SELECT  E1.ENAME, COUNT(E2.ENAME) + 1 RANGKING
FROM EMP E1, EMP E2
WHERE E1.SAL < E2.SAL(+)
GROUP BY E1.ENAME 
ORDER BY RANGKING; -- KING 이 조건에 없기 때문에 KING OUTTER JOIN 해아함.

