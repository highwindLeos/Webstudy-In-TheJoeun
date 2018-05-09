--1. �׷� �Լ�. --

SELECT SUM(SAL) FROM EMP; -- �հ� �Լ�
SELECT AVG(SAL) FROM EMP; -- ����Լ�
SELECT COUNT(SAL) FROM EMP; -- �������� ����

SELECT ROUND(SUM(SAL) / COUNT(SAL)), ROUND(AVG(SAL)) FROM EMP; -- �ݿø�

SELECT COMM FROM EMP;
SELECT SUM(COMM) FROM EMP; --�׷��Լ��� ���ϴ� �߰��� NULL �� �־ �����ϰ� ���Ǿ� �����Եȴ�.
SELECT AVG(COMM), COUNT(COMM), SUM(COMM) / FROM EMP;

-- SUM  AVG STDDEV VARIANCE �� ������Ÿ���� NUMBER�� ����. 

SELECT COUNT(SAL), COUNT(COMM), COUNT(*) FROM EMP;

SELECT MAX(SAL), MIN(SAL) FROM EMP; 
SELECT MAX(ENAME), MIN(ENAME) FROM EMP; -- VARCHR ���̶�� �ƽ�Ű�ڵ��� ������ �������� �����´�.
SELECT MAX(HIREDATE) "�����Ի���", MIN(HIREDATE) "�����Ի���" FROM EMP; -- ���� �Ի��� ���� �Ի���

SELECT SAL, MAX(SAL) FROM EMP; -- GROUP BY �� ���̴� ���� �ʵ忡 �׷��Լ��� ���� ����.
SELECT COUNT(DISTINCT JOB) FROM EMP; -- �ߺ����� �ʴ� JOB ��

SELECT ROUND(AVG(SAL)), ROUND(STDDEV(SAL)) FROM EMP; -- STDDEV() ǥ������

SELECT ROUND(STDDEV(sal)) ǥ������,
    ROUND(STDDEV(SAL) * STDDEV(SAL)) �л�,
    ROUND(VARIANCE(SAL)) �л� FROM EMP;

-- ���� �ֱٿ� �Ի��� ����� ���� ���ʿ� �Ի��� ����� �Ի��ϰ� �ٹ����� ���.
SELECT MAX(HIREDATE) || ' : ' || MAX(TRUNC(SYSDATE - HIREDATE)) "�ֱ��Ի� �ٹ���", 
       MIN(HIREDATE) || ' : ' || MIN(TRUNC(SYSDATE - HIREDATE)) "�����Ի� �ٹ���"
FROM EMP;

-- �μ���ȣ�� 10���� ��� �� �� �� �޴� �������
SELECT COUNT(COMM)
FROM EMP
WHERE DEPTNO = 10;

SELECT COMM
FROM EMP
WHERE DEPTNO = 10;

-- 
SELECT COUNT(COMM) FROM EMP WHERE DEPTNO = 10;
SELECT COUNT(COMM) FROM EMP WHERE DEPTNO = 20;
SELECT COUNT(COMM) FROM EMP WHERE DEPTNO = 30; -- 4��

-- GROUP BY �� :  GROUP BY �� �������� Į���� ��Ī�� ����� �� ����, �ݵ�� Į������ ����ؾ� �Ѵ�. 
SELECT DEPTNO, COUNT(COMM) 
FROM EMP
GROUP BY DEPTNO
ORDER BY DEPTNO;

-- �μ��� �޿� ���
SELECT DEPTNO, TRUNC(AVG(SAL))
FROM EMP
GROUP BY DEPTNO
ORDER BY DEPTNO;

-- �μ��� �󿩱��� �޴� �����
SELECT DEPTNO "NO", COUNT(*) , COUNT(COMM)
FROM EMP 
GROUP BY DEPTNO
ORDER BY NO;

-- �Ի�⵵ �� ����� �޿� ����� ����ϼ���.
SELECT TO_CHAR(HIREDATE,'YYYY') HIRE, AVG(SAL)
FROM EMP
GROUP BY TO_CHAR(HIREDATE, 'YYYY')
ORDER BY HIRE;

SELECT EXTRACT(YEAR FROM HIREDATE) HIRE, AVG(SAL)
FROM EMP
GROUP BY EXTRACT(YEAR FROM HIREDATE)
ORDER BY HIRE;

-- �μ��� �� �޿� �հ�
SELECT SUM(SAL) 
FROM EMP E, DEPT D
WHERE E.DEPTNO = D.DEPTNO
GROUP BY DNAME;

----------------------------------------------------------
--                      GROUP BY ����                   --
----------------------------------------------------------
--(1)	��� ���̺��� �ο���,�ִ� �޿�,�ּ� �޿�,�޿��� ���� ����Ͽ� ����ϴ� SELECT ������ �ۼ��Ͽ���.
SELECT COUNT(ENAME), MAX(SAL), MIN(SAL), SUM(SAL)
FROM EMP;

--(2)	������̺��� ������ �ο����� ���Ͽ� ����ϴ� SELECT ������ �ۼ��Ͽ���.
SELECT JOB, COUNT(ENAME)
FROM EMP
GROUP BY JOB;

--(3)	������̺��� �ְ� �޿��� �ּ� �޿��� ���̴� ���ΰ� ����ϴ� SELECT������ �ۼ��Ͽ���.
SELECT (MAX(SAL) - MIN(SAL)) "�޿�����"
FROM EMP;

--(4)	�� �μ����� �ο���, �޿� ���, ���� �޿�, �ְ� �޿�, �޿��� ���� ����ϵ� �޿��� ���� ���� ������ ����϶�.
SELECT COUNT(ENAME), TRUNC(AVG(SAL)), MIN(SAL), MAX(SAL), SUM(SAL) "SALTOTAL"
FROM EMP
GROUP BY DEPTNO
ORDER BY SALTOTAL DESC;

--(5)	�μ���, ������ �׷��Ͽ� ����� �μ���ȣ, ����, �ο���, �޿��� ���, �޿��� ���� ���Ͽ� ����϶�(��°���� �μ���ȣ, ���������� �������� ����)
SELECT DEPTNO, JOB, COUNT(*), AVG(SAL), SUM(SAL)
FROM EMP
GROUP BY DEPTNO, JOB
ORDER BY DEPTNO, JOB;

--(6)	������, �μ��� �׷��Ͽ� ����� �μ���ȣ, ����, �ο���, �޿��� ���, �޿��� ���� ���Ͽ� ����϶�.(��°���� ������, �μ���ȣ �� �������� ����)
SELECT DEPTNO, JOB, COUNT(*), AVG(SAL), SUM(SAL)
FROM EMP
GROUP BY JOB, DEPTNO
ORDER BY JOB, DEPTNO;

----------------------------------------------------------

-- 3 HAVING �� : �׷��� ���� �������� ���� �Ҷ� ���� �����.
-- ������ �ο����� ���Ͽ� �ο����� 3���̻��� ������ ���� �ο����� ���.

SELECT JOB, COUNT(*) CNT FROM EMP
--WHERE COUNT(*) >= 3 -- ������ ��.  �׷��Լ��� ���� ������  WHERE ���� �ü� ����.
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
--                      GROUP BY ����    2                --
----------------------------------------------------------
--(7)	������� 5��� �Ѵ� �μ���ȣ�� ������� ����Ͻÿ�.
SELECT DEPTNO, COUNT(*)
FROM EMP
GROUP BY DEPTNO
HAVING COUNT(*) >= 5;

--(8)	������� 5���̻� �Ѵ� �μ���� ������� ����Ͻÿ�
SELECT D.DNAME, COUNT(*)
FROM EMP E, DEPT D
WHERE E.DEPTNO = D.DEPTNO
GROUP BY D.DNAME
HAVING  COUNT(*) >= 5;

--(9)	��� ���̺��� ������ �޿��� ����� 3000�̻��� ������ ���ؼ� ������, ��� �޿�, �޿��� ���� ���Ͽ� ����϶�
SELECT JOB, AVG(SAL), SUM(SAL)
FROM EMP
GROUP BY JOB
HAVING  AVG(SAL) >= 3000;

--(10)	������̺��� ��ü �޿��� 5000�� �ʰ��ϴ� �� ������ ���ؼ� ������ �޿��հ踦 ����϶� ��, �޿� �հ�� �������� �����϶�.
SELECT JOB, SUM(SAL) SALTOTAL
FROM EMP
GROUP BY JOB
HAVING  SUM(SAL) > 5000
ORDER BY SALTOTAL DESC;

--(11)	�μ��� �޿����, �μ��� �޿��հ�, �μ��� �ּұ޿��� ����϶�.
SELECT D.DNAME, TRUNC(AVG(SAL)), SUM(SAL) SALTOTAL, MIN(SAL)
FROM EMP E, DEPT D
WHERE E.DEPTNO = D.DEPTNO
GROUP BY D.DNAME;

--(12)	���� 11���� �����Ͽ�, �μ��� �޿���� �ִ�ġ, �μ��� �޿����� �ִ�ġ, �μ��� �ּұ޿��� �ִ�ġ�� ����϶�.
SELECT TRUNC(MAX(AVG(SAL))) AVGMAX, MAX(SUM(SAL)) TOTALMAX, MAX(MIN(SAL)) MINMAX
FROM EMP E, DEPT D
WHERE E.DEPTNO = D.DEPTNO
GROUP BY D.DNAME;

--(13)	��� ���̺��� �Ʒ��� ����� ����ϴ� SELECT ������ �ۼ��Ͽ���.
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
-- 4. �ǹ� ���̺�. 
-----------------------------------
-- �μ��� JOB �� �޿����� �˰� �ʹ�.
SELECT DEPTNO, JOB, SUM(SAL) FROM EMP
GROUP BY ROLLUP(DEPTNO, JOB)
ORDER BY DEPTNO, JOB;

--- �ǹ� ���̺� ǥ�� 1�ܰ�
SELECT DEPTNO, DECODE(JOB, 'CLERK', SAL, 0) CLERK,
               DECODE(JOB, 'MANAGER', SAL, 0) MANAGER,
               DECODE(JOB, 'PRESIDENT', SAL, 0) PRESIDENT,
               DECODE(JOB, 'ANALYST', SAL, 0) ANALYST,
               DECODE(JOB, 'SALESMAN', SAL, 0) SALESMAN
            FROM EMP;
            
--- �ǹ� ���̺� ǥ�� 2�ܰ�
SELECT DEPTNO, SUM(DECODE(JOB, 'CLERK',     SAL, 0)) CLERK,
               SUM(DECODE(JOB, 'MANAGER',   SAL, 0)) MANAGER,
               SUM(DECODE(JOB, 'PRESIDENT', SAL, 0)) PRESIDENT,
               SUM(DECODE(JOB, 'ANALYST',   SAL, 0)) ANALYST,
               SUM(DECODE(JOB, 'SALESMAN',  SAL, 0)) SALESMAN
            FROM EMP
            GROUP BY DEPTNO; 
            
--- �ǹ� ���̺� ǥ�� 3�ܰ� : �հ��߰�
SELECT DEPTNO, SUM(DECODE(JOB, 'CLERK',     SAL, 0)) CLERK,
               SUM(DECODE(JOB, 'MANAGER',   SAL, 0)) MANAGER,
               SUM(DECODE(JOB, 'PRESIDENT', SAL, 0)) PRESIDENT,
               SUM(DECODE(JOB, 'ANALYST',   SAL, 0)) ANALYST,
               SUM(DECODE(JOB, 'SALESMAN',  SAL, 0)) SALESMAN,
               SUM(SAL) "TOTAL"
            FROM EMP
            GROUP BY ROLLUP(DEPTNO); -- ROLLUP() : �Ұ踦 ���� ORDER BY ���� ���ش�. (�� ����)
            
-- ROLLUP()  : �Ұ踦 ���� ORDER BY ���� ���ش�.
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

--(14)	 ������̺��� �Ʒ��� ����� ����ϴ� SELECT �� �ۼ�
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

--(15)	������̺��� �Ʒ��� ����� ����ϴ� SELECT �� �ۼ�(JOB ������ �������� ����)
--JOB		DEPTNO10	DEPTNO20	DEPTNO30     TOTAL
--ANALYST	     0		   6000		    0		6000
--CLERK		  1300		   1900		  950		4150
--��.
--SALESMAN	      0	 		0	 5600		 5600
SELECT JOB, SUM(DECODE(DEPTNO, 10, SAL, 0)) "DEPTNO10",
            SUM(DECODE(DEPTNO, 20, SAL, 0)) "DEPTNO20",
            SUM(DECODE(DEPTNO, 30, SAL, 0)) "DEPTNO30",
            SUM(SAL) TOTAL
        FROM EMP
        GROUP BY JOB
        ORDER BY JOB;

--(16)	 ������̺��� �ִ�޿�, �ּұ޿�, ��ü�޿���, ����� ���Ͻÿ�
SELECT MAX(SAL), MIN(SAL), SUM(SAL), TRUNC(AVG(SAL), 2)
FROM EMP ;

--(17)	������̺��� �μ��� �ο����� ���Ͻÿ�
SELECT D.DNAME, COUNT(*)
FROM EMP E, DEPT D
WHERE E.DEPTNO = D.DEPTNO
GROUP BY D.DNAME;

--(18)	 ��� ���̺��� �μ��� �ο����� 6���̻��� �μ��ڵ带 ���Ͻÿ�
SELECT DEPTNO
FROM EMP
GROUP BY DEPTNO
HAVING COUNT(DEPTNO) >= 6;

--(19)	������̺��� ������ ���� ����� ������ �Ͻÿ�
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


--(20)	 ������̺��� �޿��� ���� ������� ����� �ο��Ͽ� ������ ���� ����� ������ �Ͻÿ�. (��Ʈ self join, group by, count���)
--?	ENAME	    ���
--?	________________________
--?	KING		1
--?	SCOTT		2
--?	FORD		2
--?	JONES		4
--?	����
SELECT  E1.ENAME, COUNT(E2.ENAME) RANGKING
FROM EMP E1, EMP E2
WHERE E1.SAL <= E2.SAL
GROUP BY E1.ENAME
ORDER BY RANGKING;

-- ������ �汸 ��� ����
SELECT  E1.ENAME, COUNT(E2.ENAME) + 1 RANGKING
FROM EMP E1, EMP E2
WHERE E1.SAL < E2.SAL(+)
GROUP BY E1.ENAME 
ORDER BY RANGKING; -- KING �� ���ǿ� ���� ������ KING OUTTER JOIN �ؾ���.

