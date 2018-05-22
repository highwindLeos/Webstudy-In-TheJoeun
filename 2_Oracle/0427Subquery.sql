SELECT MAX(SAL) FROM EMP;
--------------------------------------------------------------------------------------------------
-- (1)	서브 쿼리는 하나의 SELECT 문장의 절 안에 포함된 또 하나의 SELECT 문장입니다. 
-- (2)	그렇기에 서브 쿼리를 포함하고 있는 쿼리문을 메인 쿼리, 포함된 또 하나의 쿼리를 서브 쿼리라 합니다.
-- (3)	서브 쿼리는 비교 연산자의 오른쪽에 기술하고 반드시 괄호로 둘러 쌓아야 합니다. 
-- (4)	서브 쿼리는 메인 쿼리가 실행되기 이전에 한번만 실행이 됩니다.
--------------------------------------------------------------------------------------------------
SELECT * FROM EMP;

SELECT ENAME, SAL 
FROM EMP
WHERE SAL = (SELECT MAX(SAL) FROM EMP); -- SUBQUERY : 우선 실행된다.

SELECT DNAME 
FROM EMP E, DEPT D
WHERE E.DEPTNO = D.DEPTNO AND ENAME = 'SCOTT'; -- JOIN이용

SELECT DNAME FROM DEPT
WHERE DEPTNO = (SELECT DEPTNO FROM EMP WHERE ENAME = 'SCOTT'); -- 서브쿼리 이용.

-- 1 단일행 서브쿼리. : 서브쿼리 결과가 한 행만 1ROW 있을 경우.
SELECT DNAME FROM DEPT
WHERE DEPTNO = (SELECT DEPTNO FROM EMP WHERE ENAME = 'SCOTT'); -- 서브쿼리 이용.

-- 2 다중행 서브쿼리 : 서브쿼리 결과가 2행 이상일 경우.
SELECT DEPTNO FROM  EMP WHERE SAL >= 3000; -- 서브쿼리 (결과가 다중행)

SELECT * 
FROM EMP 
WHERE DEPTNO IN (SELECT DEPTNO FROM  EMP WHERE SAL >= 3000); -- 서브쿼리 결과가 다중행이라면 = 이런 연산자가 아닌 IN 키워드를 써야한다.

--SCOTT과 같은 부서에서 근무하는 사원의 이름과 부서번호를 출력
SELECT DEPTNO FROM EMP WHERE ENAME = 'SCOTT'; -- 서브쿼리

SELECT ENAME, DEPTNO
FROM EMP
WHERE DEPTNO = (SELECT DEPTNO FROM EMP WHERE ENAME = 'SCOTT');

SELECT E2.ENAME, E2.DEPTNO FROM EMP E1, EMP E2 WHERE E1.ENAME = 'SCOTT' AND E1.DEPTNO = E2.DEPTNO; -- Self Join이용하여 이름과 부서번호 출력
SELECT E2.ENAME, DNAME FROM EMP E1, EMP E2, DEPT WHERE E1.ENAME = 'SCOTT' AND E1.DEPTNO = E2.DEPTNO AND DEPT.DEPTNO=E1.DEPTNO; -- Self Join이용하여 이름과 부서명 출력
SELECT ENAME, DEPTNO FROM EMP WHERE DEPTNO = (SELECT DEPTNO FROM EMP WHERE ENAME = 'SCOTT'); -- 서브 쿼리 이용하여 이름과 부서번호 출력
SELECT ENAME, DNAME FROM EMP E, DEPT D WHERE E.DEPTNO = D.DEPTNO AND E.DEPTNO = (SELECT DEPTNO FROM EMP WHERE ENAME = 'SCOTT'); -- 서브쿼리 이용하여 이름과 부서명 출력

-- SCOTT 과 같은 부서에 근무하는 사원들의 급여 총합을 출력.
SELECT DEPTNO, SUM(SAL)
FROM EMP
WHERE DEPTNO = (SELECT DEPTNO FROM EMP WHERE ENAME = 'SCOTT')
GROUP BY DEPTNO;

-- SCOTT 과 동일한 JOB 을 가진 사원의 모든 정보를 출력.
SELECT *
FROM EMP
WHERE JOB = (SELECT JOB FROM EMP WHERE ENAME = 'SCOTT');

-- SCOTT 과 동일하거나 더 많이 받는 사원명과 급여 출력.
SELECT ENAME, SAL 
FROM EMP
WHERE SAL >= (SELECT SAL FROM EMP WHERE ENAME= 'SCOTT');

--DALLAS 에서 근무하는 사원의 이름 
SELECT E.ENAME , D.LOC
FROM EMP E, DEPT D
WHERE E.DEPTNO = D.DEPTNO AND D.DEPTNO = (SELECT DEPTNO FROM DEPT WHERE LOC = 'DALLAS');

-- SALES 부서에 근무하는 모든 사원의 이름과 급여를 출력.
SELECT ENAME, SAL
FROM EMP  
WHERE DEPTNO = (SELECT DEPTNO FROM DEPT WHERE DNAME = 'SALES');

-- 직속 상관이 KING 인 사원의 이름과 급여를 출력.
SELECT E1.ENAME, E1.SAL
FROM EMP E1, EMP E2
WHERE E1.MGR = E2.EMPNO AND E2.ENAME = 'KING';

SELECT ENAME, SAL, (SELECT ENAME FROM EMP WHERE EMPNO = E.MGR) HIGHERORDER
FROM EMP E
WHERE MGR = (SELECT EMPNO FROM EMP WHERE ENAME = 'KING'); -- SUB QUERY

-- 평균 급여 이하로 받는 사원의 사번 이름 급여를 출력

SELECT EMPNO, ENAME, SAL
FROM EMP
WHERE SAL <= (SELECT AVG(SAL) FROM EMP)
ORDER BY SAL;

SELECT AVG(SAL) FROM EMP GROUP BY DEPTNO;--다중행 서브쿼리

SELECT EMPNO, ENAME, SAL
FROM EMP
WHERE SAL IN (SELECT AVG(SAL) FROM EMP GROUP BY DEPTNO)
ORDER BY SAL;

-- 다중 열, 단일 행 서브쿼리도 가능합니다.
-- 부서번호가 30 이고 급여가 1600 인 사원의 같은 직원을 출력.
SELECT JOB, COMM FROM EMP WHERE DEPTNO = 30 AND SAL = 1600;

SELECT * FROM EMP
WHERE (SAL, COMM) = (SELECT SAL, COMM FROM EMP WHERE DEPTNO = 30 AND SAL = 1600);

-- emp 테이블을 보고 직원의 급여를 이체를 몇번 해야하나. (단 상여는 1년에 한번)
SELECT COUNT(SAL) * 12 FROM EMP;
SELECT COUNT(COMM) FROM EMP;

SELECT (SELECT COUNT(SAL) * 12 FROM EMP) + (SELECT COUNT(COMM) FROM EMP) || '회' SALCOUNTYEAR FROM DUAL;

-- 다중행 서브쿼리

SELECT AVG(SAL) FROM EMP GROUP BY DEPTNO; 

-- IN (서브쿼리) / NOT IN (서브쿼리)
-- 급여가 3000 이상인 사원이 소속된 부서에 근무하는 직원들 모든 정보 출력
SELECT DEPTNO FROM EMP WHERE SAL >= 3000;

SELECT * FROM EMP WHERE DEPTNO IN (SELECT DEPTNO FROM EMP WHERE SAL >= 3000);

-- JOB 별로 최소 금액을 받는 사원의 이름 직책 급여를 출력.
SELECT ENAME, JOB, SAL
FROM EMP
WHERE (JOB, SAL) IN (SELECT JOB, MIN(SAL) FROM EMP GROUP BY JOB);

SELECT JOB, MIN(SAL) FROM EMP GROUP BY JOB; -- 다중행 서브쿼리

-- 부서별 급여를 제일 많이 받는 직원의 모든 정보 출력
SELECT DEPTNO, MAX(SAL) FROM EMP GROUP BY DEPTNO; -- 다중행

SELECT * FROM EMP
WHERE (DEPTNO, SAL) IN (SELECT DEPTNO, MAX(SAL) FROM EMP GROUP BY DEPTNO);

-- 부서명 별로 최소 급여자의 모든 정보를 출력.
SELECT * FROM EMP
WHERE (DEPTNO, SAL) IN (SELECT DEPTNO, MIN(SAL) FROM EMP GROUP BY DEPTNO);

-- 부서명 별로 최소 급여자의 모든 정보를 출력.
SELECT EMPNO, ENAME, SAL, E.DEPTNO 
FROM EMP E, DEPT D
WHERE E.DEPTNO = D.DEPTNO 
    AND (DNAME, SAL) IN (SELECT DNAME, MIN(SAL) FROM EMP E,DEPT D WHERE E.DEPTNO = D.DEPTNO GROUP BY DNAME);
    
-- JOB 별로 평균 급여 이상 받는 사람의 모든 정보 출력.
SELECT JOB, AVG(SAL) FROM EMP GROUP BY JOB; --SUBQUERY 

SELECT * FROM EMP E1
WHERE SAL >= (SELECT AVG(SAL) FROM EMP E2 WHERE E2.JOB = E1.JOB); -- 다중열로 출력할수 없다.


-- ANY (서브쿼리) / SOME (서브쿼리) :  하나 이상 만족할때 출력.

-- 부서 번호가 30번인 사원들의 급여보다 적게 받는 사우너들의 모든 정보를 출력
SELECT SAL FROM EMP WHERE DEPTNO = 30; -- 다중행 서브쿼리

--SELECT * FROM EMP
--WHERE SAL <  (SELECT SAL FROM EMP WHERE DEPTNO = 30); -- 이렇게 는 되지 않는다.
SELECT * FROM EMP
WHERE SAL < ANY (SELECT SAL FROM EMP WHERE DEPTNO = 30); -- 이렇게 사용할수 잇다.

SELECT * FROM EMP
WHERE SAL < (SELECT MAX(SAL) FROM EMP WHERE DEPTNO = 30); -- 위의 문장과 같은 쿼리 (단일행 서브쿼리)

-- 급여가 3000 이상인 사원이 소속된 부서에 근무하는 직원들 모든 정보 출력


-- ALL (서브쿼리) : 모두 만족 할때 출력.
SELECT * FROM EMP
WHERE SAL < ALL (SELECT SAL FROM EMP WHERE DEPTNO = 30); -- 

SELECT * FROM EMP
WHERE SAL < (SELECT MIN(SAL) FROM EMP WHERE DEPTNO = 30); -- 위의 문장과 같은 쿼리 (단일행 서브쿼리)

-- EXIST (서브쿼리) : 서브쿼리 결과가 있는 것만 출력.

-- 직속 부하가 있는 사원의 정보를 출력
SELECT * FROM EMP
WHERE EMPNO IN (SELECT MGR FROM EMP);

SELECT * FROM EMP MANAGER
WHERE EXISTS (SELECT * FROM EMP WORKER WHERE WORKER.MGR = MANAGER.EMPNO);

SELECT * FROM EMP MANAGER
WHERE NOT EXISTS (SELECT * FROM EMP WHERE MGR = MANAGER.EMPNO); -- 말단사원의 정보를 출력.

-- 부서별로 가장 급여를 많이 받는 사원의 사원 번호 사원이름 급여 부서 번호.
SELECT DEPTNO, NVL(SAL), FROM EMP GROUP BY DEPTNO;

SELECT EMPNO, ENAME, SAL, DEPTNO FROM EMP E
WHERE SAL = (SELECT MAX(SAL) FROM EMP WHERE DEPTNO = E.DEPTNO);

SELECT EMPNO, ENAME, SAL, DEPTNO FROM EMP E
WHERE (DEPTNO, SAL) IN (SELECT DEPTNO, MAX(SAL) FROM EMP GROUP BY DEPTNO);

-- 분기별로 가장 높은 급여를 받는 사람의 정보를 출력.
SELECT TRUNC(TO_CHAR(SYSDATE, 'MM') / 4) + 1 || '분기' FROM DUAL;

SELECT TRUNC(TO_CHAR(HIREDATE, 'MM') / 4) + 1 || '분기', MAX(SAL) FROM EMP GROUP BY TRUNC(TO_CHAR(HIREDATE, 'MM') / 4) + 1;

SELECT ENAME, SAL, HIREDATE, TRUNC(TO_CHAR(HIREDATE, 'MM') / 4) + 1 || '분기' "분기"
FROM EMP
WHERE (TRUNC(TO_CHAR(HIREDATE, 'MM') / 4) + 1, SAL) 
      IN (SELECT TRUNC(TO_CHAR(HIREDATE, 'MM') / 4) + 1, MAX(SAL) 
      FROM EMP 
      GROUP BY TRUNC(TO_CHAR(HIREDATE, 'MM') / 4) + 1)
      ORDER BY 분기;
      
-- SALESMAN 인 모든 사원들보다 급여를 많이 받는 이름 급여 JOB 을 출력
SELECT SAL FROM EMP WHERE JOB = 'SALESMAN';

SELECT ENAME, SAL, JOB FROM EMP
WHERE SAL > ALL (SELECT SAL FROM EMP WHERE JOB = 'SALESMAN');

SELECT ENAME, SAL, JOB FROM EMP
WHERE SAL > (SELECT MAX(SAL) FROM EMP WHERE JOB = 'SALESMAN');

-- SALESMAN 인 일부 어떤 한 사원들보다만 급여를 많이 받는 이름 급여 JOB 출력
SELECT ENAME, SAL, JOB FROM EMP
WHERE SAL > ANY (SELECT MAX(SAL) FROM EMP WHERE JOB = 'SALESMAN');

SELECT ENAME, SAL, JOB FROM EMP
WHERE SAL > ANY (SELECT MIN(SAL) FROM EMP WHERE JOB = 'SALESMAN');

-- 탄탄 다지기 예제.
-- SALESMAN 인 사원이 받는 급여의 최소 급여보다 많이 받는 사원의
-- 이름 급여 업무 부서 번호를 출력하되 부서 번호가 20번인 사원은 제외한다. (ANY 연산자 이용.)
SELECT SAL FROM EMP WHERE JOB = 'SALESMAN'; -- 서브쿼리

SELECT ENAME, SAL, JOB, DEPTNO
FROM EMP
WHERE SAL > ANY(SELECT SAL FROM EMP WHERE JOB = 'SALESMAN') AND DEPTNO != 20;


-----------------------------------------
-- 연습 문제  ---------------------------
-----------------------------------------
--(1)	사원테이블에서 가장 먼저 입사한 사람의 이름, 급여, 입사일
SELECT ENAME, SAL, HIREDATE
FROM EMP
WHERE HIREDATE = (SELECT MIN(HIREDATE) FROM EMP);

--(2)	회사에서 가장 급여가 적은 사람의 이름, 급여
SELECT ENAME, SAL
FROM EMP
WHERE SAL = (SELECT MIN(SAL) FROM EMP);
	
--(3)	회사 평균보다 급여를 많이 받는 사람의 이름, 급여, 부서코드
SELECT ENAME, SAL, DEPTNO
FROM EMP
WHERE SAL >= (SELECT AVG(SAL) FROM EMP);
	
--(4)	회사 평균 이하의 급여를 받는 사람의 이름, 급여, 부서명
SELECT ENAME, SAL, DNAME
FROM EMP E, DEPT D
WHERE E.DEPTNO = D.DEPTNO AND SAL <= (SELECT AVG(SAL) FROM EMP);
	
--(5)	SCOTT보다 먼저 입사한 사람의 이름, 급여, 입사일, 급여 등급
SELECT ENAME, SAL, HIREDATE, GRADE
FROM EMP, SALGRADE
WHERE SAL BETWEEN LOSAL AND HISAL AND HIREDATE <= (SELECT HIREDATE FROM EMP WHERE ENAME = 'SCOTT')
ORDER BY HIREDATE;

--(6)	5번에 부서명 추가하고 급여가 큰 순 정렬
SELECT ENAME, SAL, HIREDATE, GRADE, DNAME
FROM EMP E, DEPT D, SALGRADE
WHERE E.DEPTNO = D.DEPTNO AND SAL BETWEEN LOSAL AND HISAL 
    AND HIREDATE < (SELECT HIREDATE FROM EMP WHERE ENAME = 'SCOTT')
ORDER BY SAL DESC;

--(7)	사원테이블에서 BLAKE 보다 급여가 많은 사원들의 사번, 이름, 급여를 검색
SELECT EMPNO, ENAME, SAL
FROM EMP
WHERE SAL > (SELECT SAL FROM EMP WHERE ENAME = 'BLAKE');

--(8)	사원테이블에서 MILLER보다 늦게 입사한 사원의 사번, 이름, 입사일을 검색하시오
SELECT EMPNO, ENAME, HIREDATE
FROM EMP
WHERE HIREDATE > (SELECT HIREDATE FROM EMP WHERE ENAME = 'MILLER')
ORDER BY HIREDATE;

--(9)	사원테이블에서 사원전체 평균 급여보다 급여가 많은 사원들의 사번, 이름, 급여를 검색
SELECT EMPNO, ENAME, SAL
FROM EMP
WHERE SAL > (SELECT AVG(SAL) FROM EMP)
ORDER BY SAL;

--(10)	 사원테이블에서 CLARK와 같은 부서며, 
--사번이 7698인 직원의 급여보다 많은 급여를 받는 사원들의 사번, 이름, 급여 검색
SELECT EMPNO, ENAME, SAL 
FROM EMP
WHERE DEPTNO = (SELECT DEPTNO FROM EMP WHERE ENAME = 'CLARK') AND SAL >= (SELECT SAL FROM EMP WHERE EMPNO = 7698);

--(11)	 응용심화. 사원테이블에서 CLARK와 같은 부서명이며, 사번이 7698인 직원의 급여보다 많은 급여를 받는 사원들의 사번, 이름, 급여 검색
SELECT EMPNO, ENAME, SAL
FROM EMP E, DEPT D
WHERE E.DEPTNO = D.DEPTNO
AND SAL > (SELECT SAL FROM EMP WHERE EMPNO = 7698) 
AND DNAME = (SELECT DNAME FROM DEPT WHERE DEPTNO = (SELECT DEPTNO FROM EMP WHERE ENAME = 'CLARK'));

--(12)	사원 테이블에서 BLAKE와 같은 부서에 있는 모든 사원의 이름과 입사일자를 출력하는 SELECT문을 작성하시오.
SELECT ENAME, HIREDATE
FROM EMP
WHERE DEPTNO = (SELECT DEPTNO FROM EMP WHERE ENAME = 'BLAKE');

--(13)	 사원 테이블에서 평균 급여 이상을 받는 모든 종업원에 대해서 종업원 번호와 이름을 출력하는 SELECT문을 작성하시오. (단 급여가 많은 순으로 출력하여라.)
SELECT EMPNO, ENAME
FROM EMP
WHERE SAL >= (SELECT AVG(SAL) FROM EMP)
ORDER BY SAL DESC;
	
--(14)	 사원 테이블에서 이름에 “T”가 있는 사원이 근무하는 부서에서 근무하는 모든 종업원에 대해 사원 번호,이름,급여를 출력하는 SELECT문을 작성하시오. 단 사원번호 순으로 출력하여라.
SELECT EMPNO, ENAME, SAL
FROM EMP
WHERE DEPTNO IN (SELECT DEPTNO FROM EMP WHERE ENAME LIKE '%T%')
ORDER BY EMPNO;

--(15)	 사원 테이블에서 부서 위치가 Dallas인 모든 종업원에 대해 이름,업무,급여를 출력하는 SELECT문을 작성하시오.
SELECT ENAME, JOB, SAL
FROM EMP
WHERE DEPTNO = (SELECT DEPTNO FROM DEPT WHERE UPPER(LOC) = UPPER('Dallas'));

SELECT ENAME, JOB, SAL
FROM EMP
WHERE DEPTNO = (SELECT DEPTNO FROM DEPT WHERE INITCAP(LOC) = 'Dallas');
    
--(16)	EMP 테이블에서 King에게 보고하는 모든 사원의 이름과 급여를 출력하는 SELECT문을 작성하시오.
SELECT ENAME, SAL
FROM EMP
WHERE MGR = (SELECT EMPNO FROM EMP WHERE ENAME = 'KING');

SELECT ENAME, SAL
FROM EMP W
WHERE EXISTS (SELECT * FROM EMP WHERE EMPNO = W.MGR AND ENAME = 'KING'); -- EXISTS 로 출력.
	
--(17)	 사원 테이블에서 SALES부서 사원의 이름,업무를 출력하는 SELECT문을 작성하시오.
SELECT ENAME, JOB
FROM EMP
WHERE DEPTNO = (SELECT DEPTNO FROM DEPT WHERE DNAME = 'SALES');

SELECT ENAME, JOB FROM EMP E, DEPT D 
    WHERE E.DEPTNO=D.DEPTNO AND DNAME='SALES'; -- EQUE JOIN 이용

--(18)	사원 테이블에서 월급이 부서 30의 최저 월급보다 높은 사원을 출력하는 SELECT문을 작성하시오.
SELECT *
FROM EMP
WHERE SAL > (SELECT MIN(SAL) FROM EMP WHERE DEPTNO = 30)
ORDER BY SAL;

SELECT *
FROM EMP
WHERE SAL > ANY (SELECT SAL FROM EMP WHERE DEPTNO = 30)
ORDER BY SAL; -- ANY : 다중행 출력중 한조건이라도 참이라면 출력
	
--(19)	 사원 테이블에서 부서 10에서 부서 30의 사원과 같은 업무를 맡고 있는 사원의 이름과 업무를 출력하는 SELECT문을 작성하시오.
SELECT ENAME, JOB
FROM EMP
WHERE DEPTNO IN (SELECT DEPTNO FROM EMP WHERE DEPTNO = 10) 
AND JOB IN (SELECT JOB FROM EMP WHERE DEPTNO = 30);

SELECT ENAME, JOB
FROM EMP
WHERE DEPTNO = 10 
AND JOB IN (SELECT JOB FROM EMP WHERE DEPTNO = 30);

-- 응용 : 10번 부서나 30번 부서의 사원과 같은 업무를 맏고 있는 사원의 이름과 업무
SELECT ENAME, JOB
FROM EMP
WHERE JOB IN (SELECT JOB FROM EMP WHERE DEPTNO IN (10,30));

--(20)	사원 테이블에서 FORD와 업무도 월급도 같은 사원의 모든 정보를 출력하는 SELECT문을 작성하시오.
SELECT *
FROM EMP
WHERE (SAL,JOB) IN (SELECT SAL, JOB FROM EMP WHERE ENAME = 'FORD');
	
--(21)	사원 테이블에서 이름이 JONES인 직원의 JOB과 같거나 월급이 FORD이상인 사원의 정보를 이름,업무,부서번호,급여를 출력하는 SELECT문을 작성. 단, 업무별 알파벳 순, 월급이 많은 순으로 출력하여라.
SELECT ENAME, JOB, EMPNO, SAL
FROM EMP
WHERE JOB = (SELECT JOB FROM EMP WHERE ENAME = 'JONES') OR
      SAL >= (SELECT SAL FROM EMP WHERE ENAME = 'FORD')
ORDER BY JOB, SAL DESC;

--(22)	 사원 테이블에서 SCOTT 또는 WARD와 월급이 같은 사원의 정보를 이름,업무,급여를 출력하는 SELECT문을 작성하시오.
SELECT ENAME, JOB, SAL
FROM EMP
WHERE SAL = (SELECT SAL FROM EMP WHERE ENAME = 'SCOTT') OR 
      SAL = (SELECT SAL FROM EMP WHERE ENAME = 'WARD')
    AND ENAME NOT IN ('SCOTT','WARD');

SELECT ENAME, JOB, SAL
FROM EMP
WHERE SAL IN (SELECT SAL FROM EMP WHERE ENAME IN ('SCOTT','WARD')) AND 
ENAME NOT IN ('SCOTT','WARD');

--(23)	 사원 테이블에서 CHICAGO에서 근무하는 사원과 같은 업무를 하는 사원들의 이름,업무를 출력하는 SELECT문을 작성하시오.
SELECT ENAME, JOB 
FROM EMP
WHERE JOB IN (SELECT JOB FROM EMP E, DEPT D WHERE E.DEPTNO = D.DEPTNO AND LOC = 'CHICAGO');

--(24)	 사원 테이블에서 부서별로 월급이 평균 월급보다 높은 사원을 사원번호,이름,급여를 출력하는 SELECT문을 작성하시오.
SELECT EMPNO, ENAME, SAL
FROM EMP E1
WHERE SAL > (SELECT AVG(SAL) FROM EMP E2 WHERE E1.DEPTNO = E2.DEPTNO);

--(25)	 사원 테이블에서 업무별로 월급이 평균 월급보다 낮은 사원을 부서번호,이름,급여를 출력하는 SELECT문을 작성하시오.
SELECT DEPTNO, ENAME, SAL
FROM EMP E1
WHERE SAL < (SELECT AVG(SAL) FROM EMP WHERE JOB = E1.JOB);

    -- 아래는 답이 아닙니다. 업무별 평균 미만이 아닙니다.
SELECT DEPTNO,ENAME,SAL FROM EMP 
    WHERE SAL < ALL(SELECT AVG(SAL) FROM EMP GROUP BY JOB);

--(26)	 사원 테이블에서 적어도 한명 이상으로부터 보고를 받을 수 있는 사원을 업무,이름,사원번호,부서번호를 출력(단, 부서번호 순으로 오름차순 정렬)
SELECT DISTINCT E2.JOB, E2.ENAME, E2.EMPNO, E2.DEPTNO 
FROM EMP E1, EMP E2
WHERE E1.MGR = E2.EMPNO ORDER BY E2.DEPTNO; -- SELF JOIN 이용 : 중복 출력값을 DISTINCT로 제거

SELECT JOB, ENAME, EMPNO, DEPTNO
FROM EMP M
WHERE EXISTS (SELECT * FROM EMP WHERE MGR = M.EMPNO)
ORDER BY DEPTNO;   -- subQuery 이용

SELECT JOB, ENAME, EMPNO, DEPTNO FROM EMP
    WHERE EMPNO IN (SELECT MGR FROM EMP);

--(27)	사원 테이블에서 말단 사원의 사원번호, 이름, 업무, 부서번호를 출력하는 SELECT문을 작성하시오.
SELECT ENAME, JOB, EMPNO FROM EMP MANAGER
WHERE NOT EXISTS (SELECT * FROM EMP WORKER WHERE WORKER.MGR = MANAGER.EMPNO);

SELECT M.EMPNO, M.ENAME, M.JOB, M.DEPTNO 
FROM EMP W, EMP M WHERE W.MGR(+) = M.EMPNO AND W.ENAME IS NULL;
    
-- 서브쿼리 결과가 NULL이 있어 아래의 질의는 안 됨
SELECT EMPNO, ENAME, JOB, DEPTNO FROM EMP
WHERE EMPNO NOT IN (SELECT DISTINCT MGR FROM EMP); 
	