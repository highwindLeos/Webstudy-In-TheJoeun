SELECT MAX(SAL) FROM EMP;
--------------------------------------------------------------------------------------------------
-- (1)	���� ������ �ϳ��� SELECT ������ �� �ȿ� ���Ե� �� �ϳ��� SELECT �����Դϴ�. 
-- (2)	�׷��⿡ ���� ������ �����ϰ� �ִ� �������� ���� ����, ���Ե� �� �ϳ��� ������ ���� ������ �մϴ�.
-- (3)	���� ������ �� �������� �����ʿ� ����ϰ� �ݵ�� ��ȣ�� �ѷ� �׾ƾ� �մϴ�. 
-- (4)	���� ������ ���� ������ ����Ǳ� ������ �ѹ��� ������ �˴ϴ�.
--------------------------------------------------------------------------------------------------
SELECT * FROM EMP;

SELECT ENAME, SAL 
FROM EMP
WHERE SAL = (SELECT MAX(SAL) FROM EMP); -- SUBQUERY : �켱 ����ȴ�.

SELECT DNAME 
FROM EMP E, DEPT D
WHERE E.DEPTNO = D.DEPTNO AND ENAME = 'SCOTT'; -- JOIN�̿�

SELECT DNAME FROM DEPT
WHERE DEPTNO = (SELECT DEPTNO FROM EMP WHERE ENAME = 'SCOTT'); -- �������� �̿�.

-- 1 ������ ��������. : �������� ����� �� �ุ 1ROW ���� ���.
SELECT DNAME FROM DEPT
WHERE DEPTNO = (SELECT DEPTNO FROM EMP WHERE ENAME = 'SCOTT'); -- �������� �̿�.

-- 2 ������ �������� : �������� ����� 2�� �̻��� ���.
SELECT DEPTNO FROM  EMP WHERE SAL >= 3000; -- �������� (����� ������)

SELECT * 
FROM EMP 
WHERE DEPTNO IN (SELECT DEPTNO FROM  EMP WHERE SAL >= 3000); -- �������� ����� �������̶�� = �̷� �����ڰ� �ƴ� IN Ű���带 ����Ѵ�.

--SCOTT�� ���� �μ����� �ٹ��ϴ� ����� �̸��� �μ���ȣ�� ���
SELECT DEPTNO FROM EMP WHERE ENAME = 'SCOTT'; -- ��������

SELECT ENAME, DEPTNO
FROM EMP
WHERE DEPTNO = (SELECT DEPTNO FROM EMP WHERE ENAME = 'SCOTT');

SELECT E2.ENAME, E2.DEPTNO FROM EMP E1, EMP E2 WHERE E1.ENAME = 'SCOTT' AND E1.DEPTNO = E2.DEPTNO; -- Self Join�̿��Ͽ� �̸��� �μ���ȣ ���
SELECT E2.ENAME, DNAME FROM EMP E1, EMP E2, DEPT WHERE E1.ENAME = 'SCOTT' AND E1.DEPTNO = E2.DEPTNO AND DEPT.DEPTNO=E1.DEPTNO; -- Self Join�̿��Ͽ� �̸��� �μ��� ���
SELECT ENAME, DEPTNO FROM EMP WHERE DEPTNO = (SELECT DEPTNO FROM EMP WHERE ENAME = 'SCOTT'); -- ���� ���� �̿��Ͽ� �̸��� �μ���ȣ ���
SELECT ENAME, DNAME FROM EMP E, DEPT D WHERE E.DEPTNO = D.DEPTNO AND E.DEPTNO = (SELECT DEPTNO FROM EMP WHERE ENAME = 'SCOTT'); -- �������� �̿��Ͽ� �̸��� �μ��� ���

-- SCOTT �� ���� �μ��� �ٹ��ϴ� ������� �޿� ������ ���.
SELECT DEPTNO, SUM(SAL)
FROM EMP
WHERE DEPTNO = (SELECT DEPTNO FROM EMP WHERE ENAME = 'SCOTT')
GROUP BY DEPTNO;

-- SCOTT �� ������ JOB �� ���� ����� ��� ������ ���.
SELECT *
FROM EMP
WHERE JOB = (SELECT JOB FROM EMP WHERE ENAME = 'SCOTT');

-- SCOTT �� �����ϰų� �� ���� �޴� ������ �޿� ���.
SELECT ENAME, SAL 
FROM EMP
WHERE SAL >= (SELECT SAL FROM EMP WHERE ENAME= 'SCOTT');

--DALLAS ���� �ٹ��ϴ� ����� �̸� 
SELECT E.ENAME , D.LOC
FROM EMP E, DEPT D
WHERE E.DEPTNO = D.DEPTNO AND D.DEPTNO = (SELECT DEPTNO FROM DEPT WHERE LOC = 'DALLAS');

-- SALES �μ��� �ٹ��ϴ� ��� ����� �̸��� �޿��� ���.
SELECT ENAME, SAL
FROM EMP  
WHERE DEPTNO = (SELECT DEPTNO FROM DEPT WHERE DNAME = 'SALES');

-- ���� ����� KING �� ����� �̸��� �޿��� ���.
SELECT E1.ENAME, E1.SAL
FROM EMP E1, EMP E2
WHERE E1.MGR = E2.EMPNO AND E2.ENAME = 'KING';

SELECT ENAME, SAL, (SELECT ENAME FROM EMP WHERE EMPNO = E.MGR) HIGHERORDER
FROM EMP E
WHERE MGR = (SELECT EMPNO FROM EMP WHERE ENAME = 'KING'); -- SUB QUERY

-- ��� �޿� ���Ϸ� �޴� ����� ��� �̸� �޿��� ���

SELECT EMPNO, ENAME, SAL
FROM EMP
WHERE SAL <= (SELECT AVG(SAL) FROM EMP)
ORDER BY SAL;

SELECT AVG(SAL) FROM EMP GROUP BY DEPTNO;--������ ��������

SELECT EMPNO, ENAME, SAL
FROM EMP
WHERE SAL IN (SELECT AVG(SAL) FROM EMP GROUP BY DEPTNO)
ORDER BY SAL;

-- ���� ��, ���� �� ���������� �����մϴ�.
-- �μ���ȣ�� 30 �̰� �޿��� 1600 �� ����� ���� ������ ���.
SELECT JOB, COMM FROM EMP WHERE DEPTNO = 30 AND SAL = 1600;

SELECT * FROM EMP
WHERE (SAL, COMM) = (SELECT SAL, COMM FROM EMP WHERE DEPTNO = 30 AND SAL = 1600);

-- emp ���̺��� ���� ������ �޿��� ��ü�� ��� �ؾ��ϳ�. (�� �󿩴� 1�⿡ �ѹ�)
SELECT COUNT(SAL) * 12 FROM EMP;
SELECT COUNT(COMM) FROM EMP;

SELECT (SELECT COUNT(SAL) * 12 FROM EMP) + (SELECT COUNT(COMM) FROM EMP) || 'ȸ' SALCOUNTYEAR FROM DUAL;

-- ������ ��������

SELECT AVG(SAL) FROM EMP GROUP BY DEPTNO; 

-- IN (��������) / NOT IN (��������)
-- �޿��� 3000 �̻��� ����� �Ҽӵ� �μ��� �ٹ��ϴ� ������ ��� ���� ���
SELECT DEPTNO FROM EMP WHERE SAL >= 3000;

SELECT * FROM EMP WHERE DEPTNO IN (SELECT DEPTNO FROM EMP WHERE SAL >= 3000);

-- JOB ���� �ּ� �ݾ��� �޴� ����� �̸� ��å �޿��� ���.
SELECT ENAME, JOB, SAL
FROM EMP
WHERE (JOB, SAL) IN (SELECT JOB, MIN(SAL) FROM EMP GROUP BY JOB);

SELECT JOB, MIN(SAL) FROM EMP GROUP BY JOB; -- ������ ��������

-- �μ��� �޿��� ���� ���� �޴� ������ ��� ���� ���
SELECT DEPTNO, MAX(SAL) FROM EMP GROUP BY DEPTNO; -- ������

SELECT * FROM EMP
WHERE (DEPTNO, SAL) IN (SELECT DEPTNO, MAX(SAL) FROM EMP GROUP BY DEPTNO);

-- �μ��� ���� �ּ� �޿����� ��� ������ ���.
SELECT * FROM EMP
WHERE (DEPTNO, SAL) IN (SELECT DEPTNO, MIN(SAL) FROM EMP GROUP BY DEPTNO);

-- �μ��� ���� �ּ� �޿����� ��� ������ ���.
SELECT EMPNO, ENAME, SAL, E.DEPTNO 
FROM EMP E, DEPT D
WHERE E.DEPTNO = D.DEPTNO 
    AND (DNAME, SAL) IN (SELECT DNAME, MIN(SAL) FROM EMP E,DEPT D WHERE E.DEPTNO = D.DEPTNO GROUP BY DNAME);
    
-- JOB ���� ��� �޿� �̻� �޴� ����� ��� ���� ���.
SELECT JOB, AVG(SAL) FROM EMP GROUP BY JOB; --SUBQUERY 

SELECT * FROM EMP E1
WHERE SAL >= (SELECT AVG(SAL) FROM EMP E2 WHERE E2.JOB = E1.JOB); -- ���߿��� ����Ҽ� ����.


-- ANY (��������) / SOME (��������) :  �ϳ� �̻� �����Ҷ� ���.

-- �μ� ��ȣ�� 30���� ������� �޿����� ���� �޴� ���ʵ��� ��� ������ ���
SELECT SAL FROM EMP WHERE DEPTNO = 30; -- ������ ��������

--SELECT * FROM EMP
--WHERE SAL <  (SELECT SAL FROM EMP WHERE DEPTNO = 30); -- �̷��� �� ���� �ʴ´�.
SELECT * FROM EMP
WHERE SAL < ANY (SELECT SAL FROM EMP WHERE DEPTNO = 30); -- �̷��� ����Ҽ� �մ�.

SELECT * FROM EMP
WHERE SAL < (SELECT MAX(SAL) FROM EMP WHERE DEPTNO = 30); -- ���� ����� ���� ���� (������ ��������)

-- �޿��� 3000 �̻��� ����� �Ҽӵ� �μ��� �ٹ��ϴ� ������ ��� ���� ���


-- ALL (��������) : ��� ���� �Ҷ� ���.
SELECT * FROM EMP
WHERE SAL < ALL (SELECT SAL FROM EMP WHERE DEPTNO = 30); -- 

SELECT * FROM EMP
WHERE SAL < (SELECT MIN(SAL) FROM EMP WHERE DEPTNO = 30); -- ���� ����� ���� ���� (������ ��������)

-- EXIST (��������) : �������� ����� �ִ� �͸� ���.

-- ���� ���ϰ� �ִ� ����� ������ ���
SELECT * FROM EMP
WHERE EMPNO IN (SELECT MGR FROM EMP);

SELECT * FROM EMP MANAGER
WHERE EXISTS (SELECT * FROM EMP WORKER WHERE WORKER.MGR = MANAGER.EMPNO);

SELECT * FROM EMP MANAGER
WHERE NOT EXISTS (SELECT * FROM EMP WHERE MGR = MANAGER.EMPNO); -- ���ܻ���� ������ ���.

-- �μ����� ���� �޿��� ���� �޴� ����� ��� ��ȣ ����̸� �޿� �μ� ��ȣ.
SELECT DEPTNO, NVL(SAL), FROM EMP GROUP BY DEPTNO;

SELECT EMPNO, ENAME, SAL, DEPTNO FROM EMP E
WHERE SAL = (SELECT MAX(SAL) FROM EMP WHERE DEPTNO = E.DEPTNO);

SELECT EMPNO, ENAME, SAL, DEPTNO FROM EMP E
WHERE (DEPTNO, SAL) IN (SELECT DEPTNO, MAX(SAL) FROM EMP GROUP BY DEPTNO);

-- �б⺰�� ���� ���� �޿��� �޴� ����� ������ ���.
SELECT TRUNC(TO_CHAR(SYSDATE, 'MM') / 4) + 1 || '�б�' FROM DUAL;

SELECT TRUNC(TO_CHAR(HIREDATE, 'MM') / 4) + 1 || '�б�', MAX(SAL) FROM EMP GROUP BY TRUNC(TO_CHAR(HIREDATE, 'MM') / 4) + 1;

SELECT ENAME, SAL, HIREDATE, TRUNC(TO_CHAR(HIREDATE, 'MM') / 4) + 1 || '�б�' "�б�"
FROM EMP
WHERE (TRUNC(TO_CHAR(HIREDATE, 'MM') / 4) + 1, SAL) 
      IN (SELECT TRUNC(TO_CHAR(HIREDATE, 'MM') / 4) + 1, MAX(SAL) 
      FROM EMP 
      GROUP BY TRUNC(TO_CHAR(HIREDATE, 'MM') / 4) + 1)
      ORDER BY �б�;
      
-- SALESMAN �� ��� ����麸�� �޿��� ���� �޴� �̸� �޿� JOB �� ���
SELECT SAL FROM EMP WHERE JOB = 'SALESMAN';

SELECT ENAME, SAL, JOB FROM EMP
WHERE SAL > ALL (SELECT SAL FROM EMP WHERE JOB = 'SALESMAN');

SELECT ENAME, SAL, JOB FROM EMP
WHERE SAL > (SELECT MAX(SAL) FROM EMP WHERE JOB = 'SALESMAN');

-- SALESMAN �� �Ϻ� � �� ����麸�ٸ� �޿��� ���� �޴� �̸� �޿� JOB ���
SELECT ENAME, SAL, JOB FROM EMP
WHERE SAL > ANY (SELECT MAX(SAL) FROM EMP WHERE JOB = 'SALESMAN');

SELECT ENAME, SAL, JOB FROM EMP
WHERE SAL > ANY (SELECT MIN(SAL) FROM EMP WHERE JOB = 'SALESMAN');

-- źź ������ ����.
-- SALESMAN �� ����� �޴� �޿��� �ּ� �޿����� ���� �޴� �����
-- �̸� �޿� ���� �μ� ��ȣ�� ����ϵ� �μ� ��ȣ�� 20���� ����� �����Ѵ�. (ANY ������ �̿�.)
SELECT SAL FROM EMP WHERE JOB = 'SALESMAN'; -- ��������

SELECT ENAME, SAL, JOB, DEPTNO
FROM EMP
WHERE SAL > ANY(SELECT SAL FROM EMP WHERE JOB = 'SALESMAN') AND DEPTNO != 20;


-----------------------------------------
-- ���� ����  ---------------------------
-----------------------------------------
--(1)	������̺��� ���� ���� �Ի��� ����� �̸�, �޿�, �Ի���
SELECT ENAME, SAL, HIREDATE
FROM EMP
WHERE HIREDATE = (SELECT MIN(HIREDATE) FROM EMP);

--(2)	ȸ�翡�� ���� �޿��� ���� ����� �̸�, �޿�
SELECT ENAME, SAL
FROM EMP
WHERE SAL = (SELECT MIN(SAL) FROM EMP);
	
--(3)	ȸ�� ��պ��� �޿��� ���� �޴� ����� �̸�, �޿�, �μ��ڵ�
SELECT ENAME, SAL, DEPTNO
FROM EMP
WHERE SAL >= (SELECT AVG(SAL) FROM EMP);
	
--(4)	ȸ�� ��� ������ �޿��� �޴� ����� �̸�, �޿�, �μ���
SELECT ENAME, SAL, DNAME
FROM EMP E, DEPT D
WHERE E.DEPTNO = D.DEPTNO AND SAL <= (SELECT AVG(SAL) FROM EMP);
	
--(5)	SCOTT���� ���� �Ի��� ����� �̸�, �޿�, �Ի���, �޿� ���
SELECT ENAME, SAL, HIREDATE, GRADE
FROM EMP, SALGRADE
WHERE SAL BETWEEN LOSAL AND HISAL AND HIREDATE <= (SELECT HIREDATE FROM EMP WHERE ENAME = 'SCOTT')
ORDER BY HIREDATE;

--(6)	5���� �μ��� �߰��ϰ� �޿��� ū �� ����
SELECT ENAME, SAL, HIREDATE, GRADE, DNAME
FROM EMP E, DEPT D, SALGRADE
WHERE E.DEPTNO = D.DEPTNO AND SAL BETWEEN LOSAL AND HISAL 
    AND HIREDATE < (SELECT HIREDATE FROM EMP WHERE ENAME = 'SCOTT')
ORDER BY SAL DESC;

--(7)	������̺��� BLAKE ���� �޿��� ���� ������� ���, �̸�, �޿��� �˻�
SELECT EMPNO, ENAME, SAL
FROM EMP
WHERE SAL > (SELECT SAL FROM EMP WHERE ENAME = 'BLAKE');

--(8)	������̺��� MILLER���� �ʰ� �Ի��� ����� ���, �̸�, �Ի����� �˻��Ͻÿ�
SELECT EMPNO, ENAME, HIREDATE
FROM EMP
WHERE HIREDATE > (SELECT HIREDATE FROM EMP WHERE ENAME = 'MILLER')
ORDER BY HIREDATE;

--(9)	������̺��� �����ü ��� �޿����� �޿��� ���� ������� ���, �̸�, �޿��� �˻�
SELECT EMPNO, ENAME, SAL
FROM EMP
WHERE SAL > (SELECT AVG(SAL) FROM EMP)
ORDER BY SAL;

--(10)	 ������̺��� CLARK�� ���� �μ���, 
--����� 7698�� ������ �޿����� ���� �޿��� �޴� ������� ���, �̸�, �޿� �˻�
SELECT EMPNO, ENAME, SAL 
FROM EMP
WHERE DEPTNO = (SELECT DEPTNO FROM EMP WHERE ENAME = 'CLARK') AND SAL >= (SELECT SAL FROM EMP WHERE EMPNO = 7698);

--(11)	 �����ȭ. ������̺��� CLARK�� ���� �μ����̸�, ����� 7698�� ������ �޿����� ���� �޿��� �޴� ������� ���, �̸�, �޿� �˻�
SELECT EMPNO, ENAME, SAL
FROM EMP E, DEPT D
WHERE E.DEPTNO = D.DEPTNO
AND SAL > (SELECT SAL FROM EMP WHERE EMPNO = 7698) 
AND DNAME = (SELECT DNAME FROM DEPT WHERE DEPTNO = (SELECT DEPTNO FROM EMP WHERE ENAME = 'CLARK'));

--(12)	��� ���̺��� BLAKE�� ���� �μ��� �ִ� ��� ����� �̸��� �Ի����ڸ� ����ϴ� SELECT���� �ۼ��Ͻÿ�.
SELECT ENAME, HIREDATE
FROM EMP
WHERE DEPTNO = (SELECT DEPTNO FROM EMP WHERE ENAME = 'BLAKE');

--(13)	 ��� ���̺��� ��� �޿� �̻��� �޴� ��� �������� ���ؼ� ������ ��ȣ�� �̸��� ����ϴ� SELECT���� �ۼ��Ͻÿ�. (�� �޿��� ���� ������ ����Ͽ���.)
SELECT EMPNO, ENAME
FROM EMP
WHERE SAL >= (SELECT AVG(SAL) FROM EMP)
ORDER BY SAL DESC;
	
--(14)	 ��� ���̺��� �̸��� ��T���� �ִ� ����� �ٹ��ϴ� �μ����� �ٹ��ϴ� ��� �������� ���� ��� ��ȣ,�̸�,�޿��� ����ϴ� SELECT���� �ۼ��Ͻÿ�. �� �����ȣ ������ ����Ͽ���.
SELECT EMPNO, ENAME, SAL
FROM EMP
WHERE DEPTNO IN (SELECT DEPTNO FROM EMP WHERE ENAME LIKE '%T%')
ORDER BY EMPNO;

--(15)	 ��� ���̺��� �μ� ��ġ�� Dallas�� ��� �������� ���� �̸�,����,�޿��� ����ϴ� SELECT���� �ۼ��Ͻÿ�.
SELECT ENAME, JOB, SAL
FROM EMP
WHERE DEPTNO = (SELECT DEPTNO FROM DEPT WHERE UPPER(LOC) = UPPER('Dallas'));

SELECT ENAME, JOB, SAL
FROM EMP
WHERE DEPTNO = (SELECT DEPTNO FROM DEPT WHERE INITCAP(LOC) = 'Dallas');
    
--(16)	EMP ���̺��� King���� �����ϴ� ��� ����� �̸��� �޿��� ����ϴ� SELECT���� �ۼ��Ͻÿ�.
SELECT ENAME, SAL
FROM EMP
WHERE MGR = (SELECT EMPNO FROM EMP WHERE ENAME = 'KING');

SELECT ENAME, SAL
FROM EMP W
WHERE EXISTS (SELECT * FROM EMP WHERE EMPNO = W.MGR AND ENAME = 'KING'); -- EXISTS �� ���.
	
--(17)	 ��� ���̺��� SALES�μ� ����� �̸�,������ ����ϴ� SELECT���� �ۼ��Ͻÿ�.
SELECT ENAME, JOB
FROM EMP
WHERE DEPTNO = (SELECT DEPTNO FROM DEPT WHERE DNAME = 'SALES');

SELECT ENAME, JOB FROM EMP E, DEPT D 
    WHERE E.DEPTNO=D.DEPTNO AND DNAME='SALES'; -- EQUE JOIN �̿�

--(18)	��� ���̺��� ������ �μ� 30�� ���� ���޺��� ���� ����� ����ϴ� SELECT���� �ۼ��Ͻÿ�.
SELECT *
FROM EMP
WHERE SAL > (SELECT MIN(SAL) FROM EMP WHERE DEPTNO = 30)
ORDER BY SAL;

SELECT *
FROM EMP
WHERE SAL > ANY (SELECT SAL FROM EMP WHERE DEPTNO = 30)
ORDER BY SAL; -- ANY : ������ ����� �������̶� ���̶�� ���
	
--(19)	 ��� ���̺��� �μ� 10���� �μ� 30�� ����� ���� ������ �ð� �ִ� ����� �̸��� ������ ����ϴ� SELECT���� �ۼ��Ͻÿ�.
SELECT ENAME, JOB
FROM EMP
WHERE DEPTNO IN (SELECT DEPTNO FROM EMP WHERE DEPTNO = 10) 
AND JOB IN (SELECT JOB FROM EMP WHERE DEPTNO = 30);

SELECT ENAME, JOB
FROM EMP
WHERE DEPTNO = 10 
AND JOB IN (SELECT JOB FROM EMP WHERE DEPTNO = 30);

-- ���� : 10�� �μ��� 30�� �μ��� ����� ���� ������ ���� �ִ� ����� �̸��� ����
SELECT ENAME, JOB
FROM EMP
WHERE JOB IN (SELECT JOB FROM EMP WHERE DEPTNO IN (10,30));

--(20)	��� ���̺��� FORD�� ������ ���޵� ���� ����� ��� ������ ����ϴ� SELECT���� �ۼ��Ͻÿ�.
SELECT *
FROM EMP
WHERE (SAL,JOB) IN (SELECT SAL, JOB FROM EMP WHERE ENAME = 'FORD');
	
--(21)	��� ���̺��� �̸��� JONES�� ������ JOB�� ���ų� ������ FORD�̻��� ����� ������ �̸�,����,�μ���ȣ,�޿��� ����ϴ� SELECT���� �ۼ�. ��, ������ ���ĺ� ��, ������ ���� ������ ����Ͽ���.
SELECT ENAME, JOB, EMPNO, SAL
FROM EMP
WHERE JOB = (SELECT JOB FROM EMP WHERE ENAME = 'JONES') OR
      SAL >= (SELECT SAL FROM EMP WHERE ENAME = 'FORD')
ORDER BY JOB, SAL DESC;

--(22)	 ��� ���̺��� SCOTT �Ǵ� WARD�� ������ ���� ����� ������ �̸�,����,�޿��� ����ϴ� SELECT���� �ۼ��Ͻÿ�.
SELECT ENAME, JOB, SAL
FROM EMP
WHERE SAL = (SELECT SAL FROM EMP WHERE ENAME = 'SCOTT') OR 
      SAL = (SELECT SAL FROM EMP WHERE ENAME = 'WARD')
    AND ENAME NOT IN ('SCOTT','WARD');

SELECT ENAME, JOB, SAL
FROM EMP
WHERE SAL IN (SELECT SAL FROM EMP WHERE ENAME IN ('SCOTT','WARD')) AND 
ENAME NOT IN ('SCOTT','WARD');

--(23)	 ��� ���̺��� CHICAGO���� �ٹ��ϴ� ����� ���� ������ �ϴ� ������� �̸�,������ ����ϴ� SELECT���� �ۼ��Ͻÿ�.
SELECT ENAME, JOB 
FROM EMP
WHERE JOB IN (SELECT JOB FROM EMP E, DEPT D WHERE E.DEPTNO = D.DEPTNO AND LOC = 'CHICAGO');

--(24)	 ��� ���̺��� �μ����� ������ ��� ���޺��� ���� ����� �����ȣ,�̸�,�޿��� ����ϴ� SELECT���� �ۼ��Ͻÿ�.
SELECT EMPNO, ENAME, SAL
FROM EMP E1
WHERE SAL > (SELECT AVG(SAL) FROM EMP E2 WHERE E1.DEPTNO = E2.DEPTNO);

--(25)	 ��� ���̺��� �������� ������ ��� ���޺��� ���� ����� �μ���ȣ,�̸�,�޿��� ����ϴ� SELECT���� �ۼ��Ͻÿ�.
SELECT DEPTNO, ENAME, SAL
FROM EMP E1
WHERE SAL < (SELECT AVG(SAL) FROM EMP WHERE JOB = E1.JOB);

    -- �Ʒ��� ���� �ƴմϴ�. ������ ��� �̸��� �ƴմϴ�.
SELECT DEPTNO,ENAME,SAL FROM EMP 
    WHERE SAL < ALL(SELECT AVG(SAL) FROM EMP GROUP BY JOB);

--(26)	 ��� ���̺��� ��� �Ѹ� �̻����κ��� ���� ���� �� �ִ� ����� ����,�̸�,�����ȣ,�μ���ȣ�� ���(��, �μ���ȣ ������ �������� ����)
SELECT DISTINCT E2.JOB, E2.ENAME, E2.EMPNO, E2.DEPTNO 
FROM EMP E1, EMP E2
WHERE E1.MGR = E2.EMPNO ORDER BY E2.DEPTNO; -- SELF JOIN �̿� : �ߺ� ��°��� DISTINCT�� ����

SELECT JOB, ENAME, EMPNO, DEPTNO
FROM EMP M
WHERE EXISTS (SELECT * FROM EMP WHERE MGR = M.EMPNO)
ORDER BY DEPTNO;   -- subQuery �̿�

SELECT JOB, ENAME, EMPNO, DEPTNO FROM EMP
    WHERE EMPNO IN (SELECT MGR FROM EMP);

--(27)	��� ���̺��� ���� ����� �����ȣ, �̸�, ����, �μ���ȣ�� ����ϴ� SELECT���� �ۼ��Ͻÿ�.
SELECT ENAME, JOB, EMPNO FROM EMP MANAGER
WHERE NOT EXISTS (SELECT * FROM EMP WORKER WHERE WORKER.MGR = MANAGER.EMPNO);

SELECT M.EMPNO, M.ENAME, M.JOB, M.DEPTNO 
FROM EMP W, EMP M WHERE W.MGR(+) = M.EMPNO AND W.ENAME IS NULL;
    
-- �������� ����� NULL�� �־� �Ʒ��� ���Ǵ� �� ��
SELECT EMPNO, ENAME, JOB, DEPTNO FROM EMP
WHERE EMPNO NOT IN (SELECT DISTINCT MGR FROM EMP); 
	