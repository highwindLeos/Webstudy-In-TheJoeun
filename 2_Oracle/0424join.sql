-- JOIN 2�� �̻��� ���̺��� �����ؼ� �����͸� ���
SELECT ENAME, DEPTNO FROM EMP;
SELECT * FROM EMP;
SELECT * FROM DEPT;
SELECT * FROM SALGRADE;

-- CROSS JOIN
SELECT * FROM EMP, DEPT WHERE ENAME = 'SMITH'; -- 

-- EQUI JOIN : ���� ���� ���� ����.
SELECT EMP.EMPNO, EMP.ENAME, EMP.JOB, EMP.MGR, EMP.HIREDATE, EMP.SAL, EMP.COMM, EMP.DEPTNO, DEPT.DNAME, DEPT.LOC 
FROM EMP, DEPT 
WHERE ENAME = 'SMITH' AND EMP.DEPTNO = DEPT.DEPTNO; -- �� ���̺��� ���� �ʵ��� ���� ���� ������ ����ϴ� JOIN

-- TABLE �� ALIAS �� �ִ¹� (30�� ����, ���ĺ� ����)
SELECT E.ENAME, E.JOB, E.DEPTNO, DNAME, LOC
FROM EMP E, DEPT D
WHERE E.DEPTNO = D.DEPTNO;

-----------------------------------
-- EQUI JOIN ���� 
-----------------------------------
-- ��� �̸� �޿� �μ����� �μ���
SELECT EMPNO, ENAME, SAL, E.DEPTNO, DNAME  
FROM EMP E, DEPT D
WHERE E.DEPTNO = D.DEPTNO;

-- �̸� ���� �޿� �μ��� �ٹ��� (���� : SAL �� 2000 �̻�) 
-- �Լ� : TO_CHAR(�ʵ��, 'ǥ�ù���') - �ʵ带 ���ڿ��� �˷��ش�.
SELECT ENAME, JOB, TO_CHAR(SAL, '$9,999'), DNAME, LOC  
FROM EMP E, DEPT D
WHERE E.DEPTNO = D.DEPTNO AND SAL >= 2000;

-- �̸� ���� �μ��� �ٹ��� (���� : �ٹ����� CHICAGO �� �����)
SELECT ENAME, JOB, DNAME, LOC  
FROM EMP E, DEPT D
WHERE E.DEPTNO = D.DEPTNO AND D.LOC = UPPER('chicago');

-- �̸�, �޿�, ���� (���� = SAL*12+COMM), �μ��� �ٹ���(���� : JOB �� SALESMAN �̰ų� MANAGER �ΰ�� ������ ū������ ����)
SELECT ENAME, SAL, COMM, TO_CHAR(SAL*12+NVL(COMM, 0), '9,999,999') AS ����, DNAME, LOC
FROM EMP E, DEPT D
WHERE E.DEPTNO = D.DEPTNO AND JOB IN ('SALESMAN','MANAGER')
ORDER BY ���� DESC;

-- �̸�, �޿�, �Ի���, �μ���ȣ, �μ���, (���� : COMM �� NULL�̰� �޿��� 1200�̻��� ��� �μ��� ������ ���� �μ����� ������ SAL�� ���� ����)
SELECT ENAME, SAL, HIREDATE, E.DEPTNO, DNAME  
FROM EMP E, DEPT D
WHERE E.DEPTNO = D.DEPTNO AND (COMM IS NULL AND SAL >= 1200)
ORDER BY DNAME, SAL DESC;

-- źź ������ ����
-- ���忡�� �ٹ��ϴ� ����� �̸��� �޿��� ����Ͻÿ�
SELECT ENAME, SAL 
FROM EMP E, DEPT D 
WHERE E.DEPTNO = D.DEPTNO AND LOC = 'NEW YORK';
    
--	ACCOUNTING �μ� �Ҽ� ����� �̸��� �Ի����� ����Ͻÿ�
SELECT ENAME, HIREDATE 
FROM EMP E, DEPT D
WHERE E.DEPTNO = D.DEPTNO AND UPPER(DNAME) = 'ACCOUNTING';

--	������ MANAGER�� ����� �̸�, �μ����� ����Ͻÿ�
SELECT ENAME, DNAME
FROM EMP E, DEPT D
WHERE E.DEPTNO = D.DEPTNO AND JOB = 'MANAGER';

--	Comm�� null�� �ƴ� ����� �̸�, �޿�, �μ��ڵ�, �ٹ����� ����Ͻÿ�.
SELECT ENAME SAL, D.DEPTNO, LOC
FROM EMP E, DEPT D
WHERE E.DEPTNO = D.DEPTNO AND COMM IS NOT NULL;

-- NON EQUI JOIN : ������ ������ �ʵ��� �� Ư�� �������� �ִ��� ���ο� ���� ����.
SELECT ENAME, SAL FROM EMP; -- 14��
SELECT * FROM SALGRADE; -- 5��

SELECT ENAME, SAL, GRADE, LOSAL, HISAL
FROM EMP E, SALGRADE S
WHERE ENAME = 'SMITH' AND SAL BETWEEN LOSAL AND HISAL; -- BETWEEN ���� ������ ���� ��쿡�� ����ϵ��� �Ѵ�.

-- ���, �̸�, ����, ������, �����, �Ի���, �޿�, �޿����, COMM(0)
SELECT EMPNO, ENAME, JOB, MGR, HIREDATE, SAL, GRADE || '���' AS GRADE, NVL(TO_CHAR(COMM), '-')
FROM EMP E, SALGRADE S
WHERE SAL BETWEEN LOSAL AND HISAL;

-- źź ������ : 
--	Comm�� null�� �ƴ� ����� �̸�, �޿�, ���, �μ��̸�, �ٹ����� ����Ͻÿ�.
SELECT ENAME, SAL, GRADE, D.DNAME, LOC
FROM EMP E, SALGRADE S, DEPT D
WHERE E.DEPTNO = D.DEPTNO AND SAL BETWEEN LOSAL AND HISAL AND COMM IS NOT NULL;

--�̸�, �޿�, �Ի���, �޿����
SELECT ENAME, SAL, GRADE
FROM EMP E, SALGRADE S
WHERE SAL BETWEEN LOSAL AND HISAL;

--�̸�, �޿�, �Ի���, �޿����, �μ���, �ٹ���
SELECT ENAME, SAL, HIREDATE, GRADE, DNAME, LOC 
FROM EMP E, DEPT D, SALGRADE S
WHERE E.DEPTNO = D.DEPTNO AND SAL BETWEEN LOSAL AND HISAL;

--�̸�, �޿�, ���, �μ��ڵ�, �ٹ���. �� comm �� null�ƴ� ���
SELECT ENAME, SAL, E.DEPTNO, LOC
FROM EMP E, DEPT D, SALGRADE S 
WHERE  E.DEPTNO = D.DEPTNO AND SAL BETWEEN LOSAL AND HISAL AND COMM IS NOT NULL;

--�̸�, �޿�, �޿����, ����, �μ���, �μ��� ���, �μ��� ������ ������. ����=(sal+comm)*12 comm�� null�̸� 0
SELECT ENAME, SAL, GRADE, (SAL+NVL(COMM, 0))*12 SALARY, D.DNAME
FROM EMP E, DEPT D, SALGRADE S
WHERE E.DEPTNO = D.DEPTNO AND SAL BETWEEN LOSAL AND HISAL
ORDER BY DNAME, SALARY;

--�̸�, ����, �޿�, ���, �μ��ڵ�, �μ��� ���. �޿��� 1000~3000����. �������� : �μ���, �μ������� ������, ���������� �޿� ū��
SELECT ENAME, JOB, SAL, GRADE, D.DEPTNO, DNAME
FROM EMP E, DEPT D, SALGRADE S
WHERE E.DEPTNO = D.DEPTNO AND SAL BETWEEN LOSAL AND HISAL AND SAL BETWEEN 1000 AND 3000
ORDER BY DNAME, SAL;

--�̸�, �޿�, ���, �Ի���, �ٹ���. 81�⿡ �Ի��� ���. ��� ū��
SELECT ENAME, SAL, GRADE, HIREDATE, LOC 
FROM EMP E, DEPT D, SALGRADE S 
WHERE E.DEPTNO = D.DEPTNO AND SAL BETWEEN LOSAL AND HISAL 
        AND TO_CHAR(HIREDATE, 'yyyy') = '1981';


---
-- SELF JOIN  : �ڱ� ���̺��� �����ؼ� ���̺��� �����ؼ� ������ش�.
---
SELECT EMPNO, ENAME, MGR, EMP FROM EMP;
SELECT EMPNO, ENAME FROM EMP;

SELECT WORKER.EMPNO, WORKER.ENAME, WORKER.MGR, MANAGER.EMPNO, MANAGER.ENAME
FROM EMP WORKER, EMP MANAGER
WHERE WORKER.MGR = MANAGER.EMPNO; -- 1*14 : 

-- źź ������ ����

-- �ƹ��� ���� ������ ���Դϴ�.
SELECT W.ENAME ||' ���� ���� ' || M.ENAME || ' �Դϴ�.'
FROM EMP W, EMP M
WHERE W.MGR = M.EMPNO;

-- ����� �̸��� KING �� ������� �̸��� ���� �� ����ϼ���.
SELECT W.ENAME, W.JOB
FROM EMP W, EMP M
WHERE W.MGR = M.EMPNO AND M.ENAME = 'KING';

-- SCOTT �� ������ �ٹ������� �ٹ��ϴ� ����� �̸��� ����Ͻÿ� 
-- SCOTT �� DEPTNO �� ���� ����� �̸� ���.
SELECT W.ENAME, W.DEPTNO, M.ENAME, M.DEPTNO
FROM EMP W, EMP M
WHERE W.DEPTNO = M.DEPTNO AND M.ENAME != 'SCOTT';

SELECT E1.ENAME, D.LOC, E2.ENAME, D.LOC
FROM EMP E1, EMP E2, DEPT D
WHERE E1.DEPTNO = D.DEPTNO AND E2.DEPTNO = D.DEPTNO 
AND E1.ENAME = 'SCOTT' AND E2.ENAME != 'SCOTT';

------------------
-- OUTTER JOIN (+)
------------------

SELECT  W.ENAME, M.ENAME manager, W.MGR, M.EMPNO
FROM EMP W, EMP M
WHERE W.MGR(+) = M.EMPNO; -- ���� ������ ��� �ٽ� �Ʒ��� ��µ�.

SELECT  W.ENAME, NVL(M.ENAME, '������'), NVL(TO_CHAR(W.MGR),'������'), NVL(TO_CHAR(M.EMPNO),'������')
FROM EMP W, EMP M
WHERE W.MGR = M.EMPNO(+);

SELECT ENAME, E.DEPTNO, D.DEPTNO, DNAME
FROM EMP E, DEPT D
WHERE E.DEPTNO(+) = D.DEPTNO;

SELECT * From EMP;

-- KING�� �Ŵ����� ���Դϴ�.
SELECT W.ENAME || ' �� �޴����� ' || NVL(M.ENAME,'��') || ' �Դϴ�.' AS MGROUT
FROM EMP W, EMP M
WHERE W.MGR = M.EMPNO(+);

-- ���� �������� �̸��� ����Ѵ�.
SELECT W.ENAME, M.ENAME
FROM EMP W, EMP M
WHERE W.MGR(+) = M.EMPNO;

SELECT M.ENAME
FROM EMP W, EMP M
WHERE W.MGR(+) = M.EMPNO AND W.ENAME IS NULL;

-- <��������>
--1. �̸�, ���ӻ��
SELECT W.ENAME WORKER, M.ENAME MANAGER
FROM EMP W, EMP M
WHERE W.MGR = M.EMPNO;

--2. �̸�, �޿�, ����, ���ӻ��
SELECT W.ENAME, W.SAL, W.JOB, M.ENAME
FROM EMP W, EMP M
WHERE W.MGR = M.EMPNO;

--3. �̸�, �޿�, ����, ���ӻ��. (��簡 ���� �������� ��ü ���� �� ���. ��簡 ���� �� ������������ ���)
SELECT W.ENAME, W.SAL, W.JOB,  NVL(M.ENAME, '����')
FROM EMP W, EMP M
WHERE W.MGR = M.EMPNO(+);

--4. �̸�, �޿�, �μ���, ���ӻ���
SELECT W.ENAME, W.SAL, D.DNAME, M.ENAME
FROM EMP W, EMP M, DEPT D
WHERE W.MGR = M.EMPNO AND M.DEPTNO = D.DEPTNO;

--5. �̸�, �޿�, �μ��ڵ�, �μ���, �ٹ���, ���ӻ���, (��簡 ���� �������� ��ü ���� �� ���) *****
SELECT W.ENAME, W.SAL, D.DEPTNO, D.DNAME, D.LOC, NVL(M.ENAME, '����') MANAGER
FROM EMP W, EMP M, DEPT D
WHERE W.MGR = M.EMPNO(+) AND W.DEPTNO = D.DEPTNO;

--6. �̸�, �޿�, ���, �μ���, ���ӻ���. �޿��� 2000�̻��� ���
SELECT W.ENAME, W.SAL, GRADE, D.DNAME, M.ENAME
FROM EMP W, EMP M, DEPT D, SALGRADE S
WHERE W.MGR = M.EMPNO AND D.DEPTNO = M.DEPTNO AND W.SAL BETWEEN S.LOSAL AND S.HISAL AND W.SAL >= 2000;

--7. �̸�, �޿�, ���, �μ���, ���ӻ���, (���ӻ�簡 ���� �������� ��ü���� �μ��� �� ����)
SELECT W.ENAME, W.SAL, GRADE, D.DNAME, M.ENAME
FROM EMP W, EMP M, DEPT D, SALGRADE S
WHERE W.MGR = M.EMPNO(+) AND W.DEPTNO = D.DEPTNO AND W.SAL BETWEEN S.LOSAL AND S.HISAL
ORDER BY DNAME;

--8. �̸�, �޿�, ���, �μ���, ����, ���ӻ���. ����=(�޿�+comm)*12 �� comm�� null�̸� 0
SELECT W.ENAME, W.SAL, GRADE, D.DNAME, (W.SAL+NVL(W.COMM, 0))*12 SLAYAER, M.ENAME MGR
FROM EMP W, EMP M , DEPT D, SALGRADE S
WHERE W.MGR = M.EMPNO AND W.SAL BETWEEN S.LOSAL AND S.HISAL AND D.DEPTNO = M.DEPTNO;

--9. 8���� �μ��� �� �μ��� ������ �޿��� ū �� ����
SELECT W.ENAME, W.SAL, W.JOB, (W.SAL+NVL(W.COMM, 0))*12 SLAYAER, M.ENAME MGR
FROM EMP W, EMP M , DEPT D
WHERE W.MGR = M.EMPNO AND D.DEPTNO = M.DEPTNO
ORDER BY D.DNAME, SAL DESC;

-----------------------------------------------------------------------------------------
--1.EMP ���̺��� ��� ����� ���� �̸�,�μ���ȣ,�μ����� ����ϴ� SELECT ������ �ۼ��Ͽ���.
SELECT ENAME, D.DEPTNO, D.DNAME
FROM EMP E, DEPT D
WHERE E.DEPTNO = D.DEPTNO;

--2. EMP ���̺��� NEW YORK���� �ٹ��ϰ� �ִ� ����� ���Ͽ� �̸�,����,�޿�,�μ����� ����ϴ� SELECT ������ �ۼ��Ͽ���.
SELECT ENAME, JOB, SAL, D.DNAME
FROM EMP E, DEPT D
WHERE E.DEPTNO = D.DEPTNO AND D.LOC = 'NEW YORK';

--3. EMP ���̺��� ���ʽ��� �޴� ����� ���Ͽ� �̸�,�μ���,��ġ�� ����ϴ� SELECT ������ �ۼ��Ͽ���.
SELECT ENAME, D.DNAME,D.LOC
FROM EMP E, DEPT D
WHERE E.DEPTNO = D.DEPTNO AND COMM IS NOT NULL AND COMM != 0;

--4. EMP ���̺��� �̸� �� L�ڰ� �ִ� ����� ���Ͽ� �̸�,����,�μ���,��ġ�� ����ϴ� SELECT ������ �ۼ��Ͽ���.
SELECT ENAME, JOB, D.DNAME, D.LOC
FROM EMP E, DEPT D
WHERE E.DEPTNO = D.DEPTNO AND E.ENAME LIKE '%L%';

--5. ���, �����, �μ��ڵ�, �μ����� �˻��϶�. ������������ ������������
SELECT EMPNO, E.ENAME, D.DEPTNO, D.DNAME
FROM EMP E, DEPT D
WHERE E.DEPTNO = D.DEPTNO
ORDER BY E.ENAME;

--6. ���, �����, �޿�, �μ����� �˻��϶�. �� �޿��� 2000�̻��� ����� ���Ͽ� �޿��� �������� ������������ �����Ͻÿ�
SELECT EMPNO, E.ENAME, SAL, D.DNAME
FROM EMP E, DEPT D
WHERE E.DEPTNO = D.DEPTNO AND E.SAL >= 2000
ORDER BY E.SAL DESC;

--7. ���, �����, ����, �޿�, �μ����� �˻��Ͻÿ�. �� ������ MANAGER�̸� �޿��� 2500�̻��� ����� ���Ͽ� ����� �������� ������������ �����Ͻÿ�.
SELECT EMPNO, E.ENAME, JOB, SAL, D.DNAME
FROM EMP E, DEPT D
WHERE E.DEPTNO = D.DEPTNO AND E.JOB = 'MANAGER' AND E.SAL >= 2500
ORDER BY E.EMPNO;

--8. ���, �����, ����, �޿�, ����� �˻��Ͻÿ�. ����� �޿��� ���Ѱ��� ���Ѱ� ������ ���Եǰ� �޿����� ������������ �����Ͻÿ�
SELECT EMPNO, E.ENAME, JOB, SAL, S.GRADE
FROM EMP E, SALGRADE S
WHERE SAL BETWEEN LOSAL AND HISAL
ORDER BY E.SAL DESC;

--9. ������̺��� �����, ����� ��縦 �˻��Ͻÿ�(��簡 ���� �������� ��ü)
SELECT E.ENAME, M.ENAME
FROM EMP E, EMP M
WHERE E.MGR = M.EMPNO(+);

--10. �����, ����, ����� ������ �˻��Ͻÿ�
SELECT E.ENAME, M.ENAME, MM.ENAME
FROM EMP E, EMP M, EMP MM
WHERE E.MGR = M.EMPNO AND M.MGR = MM.EMPNO;

--11. ���� ������� ���� ��簡 ���� ��� ������ �̸��� ��µǵ��� �����Ͻÿ�
SELECT E.ENAME, M.ENAME "���", MM.ENAME "����� ���"
FROM EMP E, EMP M, EMP MM
WHERE E.MGR = M.EMPNO(+) AND M.MGR = MM.EMPNO(+);


