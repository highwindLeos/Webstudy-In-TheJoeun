-- 2 SELECT �� : �����͸� �о���� ��ɹ�.

--SELECT [DISTINCT] {*, column [Alias], ��.}
--FROM ���̺��
--[WHERE condition]
--[ORDER BY {column, expression} [ASC|DESC]] ;

SELECT * FROM TAB; --Leos ������ ������ ���̺��� ��� �����ش�.
SELECT * FROM EMP; -- EMP TABLE �� ��� �ʵ带 ���.
SELECT * FROM DEPT; -- DEPT TABLE : �μ���ȣ(DEPTNO) �μ��̵�(DNAME) �μ���ġ(LOC).

DESC DEPT; -- TABLE �� ������ ���. SELECT �����͸� ���. DESC ������ ���
DESC EMP; -- TABLE �� ������ ���. SELECT �����͸� ���. DESC ������ ���

SELECT EMPNO,ENAME, SAL FROM EMP; -- EMP table ���� ��� �̸� �޿� �� �����´�.

SELECT EMPNO AS "���", ENAME AS "�̸�", SAL AS "�޿�", JOB AS "����" FROM EMP; -- EMP table ���� �ʵ忡 ������ �޾Ƽ� ����Ѵ�.
SELECT EMPNO "���", ENAME "�̸�", SAL "�޿�", JOB "����" FROM EMP; -- EMP table ���� �ʵ忡 ������ �޾Ƽ� ����Ѵ�. (AS�� "" ��������) 
SELECT EMPNO ���, ENAME �̸�, SAL �޿�, JOB ���� FROM EMP; -- EMP table ���� �ʵ忡 ������ �޾Ƽ� ����Ѵ�. (AS�� "" ��������) 

SELECT EMPNO, ENAME, SAL FROM EMP WHERE SAL = 3000; --������ 3000�� ����� ��� �̸� �޿��� ���.

SELECT EMPNO, ENAME, SAL FROM EMP WHERE SAL != 3000; --������ 3000�� �ƴ� ����� ��� �̸� �޿��� ���.
SELECT EMPNO, ENAME, SAL FROM EMP WHERE SAL <> 3000; --������ 3000�� �ƴ� ����� ��� �̸� �޿��� ���.
SELECT EMPNO, ENAME, SAL FROM EMP WHERE SAL ^= 3000; --������ 3000�� �ƴ� ����� ��� �̸� �޿��� ���. (������ �����ڴ� ��� ���� ��)

SELECT * FROM EMP WHERE DEPTNO = 10; -- 10�� �μ��� ��� ������ ��� �ʵ� ���.
SELECT * FROM EMP WHERE ENAME = 'FORD'; -- �̸��� FORD �� ����� ��� �ʵ带 ���.

-- 4 ��� ������. + - * / % : ��������  NULL �� ������ �����  NULL 
-- ����� NULL �� �ȳ����� �Ϸ��� NVL() �Լ��� ���

SELECT ENAME, SAL, SAL*12, COMM, SAL*12+COMM FROM EMP WHERE ENAME = 'FORD'; -- �̸���  FORD �� ����� �̸� ���� ���� �󿩱��� ����Ѵ�.
SELECT ENAME, SAL, SAL*12 AS "����", SAL*12+NVL(COMM, 0) AS "����+��" FROM EMP WHERE ENAME = 'FORD'; -- �̸���  FORD �� ����� �̸� ���� ���� �󿩱��� ����Ѵ�.
-- NVL(var1, var2) var1 �� null �� ��� var2 �� ���ϴ� �Լ� ���� Ÿ���϶��� ���.
SELECT ENAME, SAL, NVL(COMM, '0'), NVL(JOB, '��������') FROM EMP; -- 

-- 5. �������� AND(&&), OR(||) 
SELECT EMPNO, ENAME, JOB, MGR, HIREDATE, SAL, NVL(COMM, 0) COMM, DEPTNO  
        FROM EMP WHERE DEPTNO = 10 AND JOB = 'MANAGER'; -- DEPTNO 10 �̰� JOB �� MANAGER �� ����� �ʵ带 ���. (�ʵ尪���� ��� ������ ���ΰ�� AND)
        
SELECT EMPNO, ENAME, JOB, MGR, HIREDATE, SAL, NVL(COMM, 0) COMM, DEPTNO  
        FROM EMP WHERE DEPTNO = 10 OR JOB = 'MANAGER'; --  DEPTNO �� 10 �̰ų� JOB �� MANAGER �� ����� �ʵ带 ���. (�ʵ尪���� ������ �ϳ��� ���̾ ��� OR)
        
SELECT * FROM EMP WHERE NOT DEPTNO = 10; -- DEPTNO �� 10�� �ƴ� ��� �ʵ带 ���. (NOT)

SELECT * FROM EMP WHERE SAL > 2000 AND SAL < 2999; -- �޿��� 2000 ~ 2999 ������ ��� �ʵ带 ���.

ALTER SESSION set NLS_DATE_FORMAT = 'RR-MM-DD'; -- ��¥ �ʵ��� ������ �����Ѵ�. (���� �������� ������ ���۸��̳�  TOOL �� ����� �̿��Ѵ�.)

--  HIREDATE �� '82-01-01' �̻��̰� HIREDATE ���� '83-01-01' ���� �ʵ带 ��� ���.
SELECT * FROM EMP WHERE HIREDATE >= '82-01-01' AND HIREDATE < '83-01-01'; 

-- 6. ���� ������ ( || ) PIPE : �ʵ峪 ���ڿ��� �����ϴ� ������.
SELECT ENAME ||' �� '|| JOB "��� �� ����" FROM EMP; -- �ϳ��� �ʵ�� ���ļ� ���

-- �ƹ����� ������ �󸶿���? 
SELECT ENAME || ' �� ������ ' || (SAL*12+NVL(COMM, 0)) || ' ����' AS "�����ڷ�" FROM EMP;

-- 7902�� CLARK �Դϴ�.
SELECT EMPNO || ' �� ' || ENAME || '�Դϴ�.' AS show FROM EMP;

-- �ƹ��� �� MENAGER (���� : SAL �� 2000 �̻� 3000�̸��� ����� ���)
SELECT ENAME || ' �� ' || JOB || '�Դϴ�.' AS show 
        FROM EMP 
        WHERE SAL >= 2000 AND SAL < 3000;
        
--  �ߺ��� �����ؼ� ��� : DISTINCT �����.
SELECT JOB FROM EMP;
SELECT DISTINCT JOB FROM EMP;

SELECT  DEPTNO FROM EMP;
SELECT DISTINCT DEPTNO FROM EMP;

--------------------------------------------------------------------------------------------
-- EXAMPLE ����
--------------------------------------------------------------------------------------------

--1.	emp ���̺��� ���� ���
DESC EMP;

--2.	emp ���̺��� ��� ������ ��� 
SELECT * From EMP;

--3.	�� �������� ��밡���� ���̺� ���
SELECT * FROM TAB;

--4.	emp ���̺��� ���, �̸�, �޿�, ����, �Ի��� ���
SELECT EMPNO, ENAME, SAL, JOB, HIREDATE FROM EMP;

--5.	emp ���̺��� �޿��� 2000�̸��� ����� ���, �̸�, �޿� ���
SELECT EMPNO, ENAME, SAL FROM EMP WHERE SAL < 2000;

--6.	emp ���̺��� �Ի����� 81/02���Ŀ� �Ի��� ����� ���, �̸�, ����, �Ի��� ���
SELECT EMPNO, ENAME, JOB, HIREDATE FROM EMP WHERE HIREDATE >= '82-02-01';

--7.	emp ���̺��� ������ SALESMAN�� ����� ��� �ڷ� ���
SELECT * FROM EMP WHERE JOB = 'SALESMAN'; 

--8.	emp ���̺��� ������ CLERK�� �ƴ� ����� ��� �ڷ� ���
SELECT * FROM EMP WHERE NOT JOB = 'CLERK';
SELECT * FROM EMP WHERE JOB != 'CLERK';
SELECT * FROM EMP WHERE JOB ^= 'CLERK';
SELECT * FROM EMP WHERE JOB <> 'CLERK';

--9.	emp ���̺��� �޿��� 1500�̻��̰� 3000������ ����� ���, �̸�, �޿� ���
SELECT EMPNO, ENAME, SAL FROM EMP WHERE SAL >= 1500 AND SAL <= 3000;

--10.	emp ���̺��� �μ��ڵ尡 10���̰ų� 30�� ����� ���, �̸�, ����, �μ��ڵ� ���
SELECT EMPNO, ENAME, JOB, DEPTNO FROM EMP WHERE DEPTNO = 10 OR DEPTNO = 30;

--11.	emp ���̺��� ������ SALESMAN�̰ų� �޿��� 3000�̻��� ����� ���, �̸�, ����, �μ��ڵ� ���
SELECT EMPNO, ENAME, JOB, DEPTNO FROM EMP WHERE JOB = 'SALESMAN' OR SAL >= 3000;

--12.	emp ���̺��� �޿��� 2500�̻��̰� ������ MANAGER�� ����� ���, �̸�, ����, �޿� ���
SELECT EMPNO, ENAME, JOB, DEPTNO FROM EMP WHERE SAL >= 2500 AND JOB = 'MANAGER';

--13.	emp ���̺��� ��ename�� XXX �����̰� ������ XX�١� ��Ÿ�Ϸ� ��� ���
SELECT ENAME || ' �� ' || JOB || ' �����̰� ������ ' || (SAL*12+NVL(COMM,0)) AS "SHOWMSG" FROM EMP;

--------------------------------------------------------------------------------------------
-- SQL ������
--------------------------------------------------------------------------------------------
-- 8. BETWEEN a AND b / IN / LIKE (���ϵ�ī��� ����) = �� �����ڵ��� ��� NOT ���� �ݴ밪�� �����ü� �ִ�.
SELECT EMPNO, ENAME, SAL FROM EMP WHERE SAL >= 1500 AND SAL <= 3000;

SELECT  EMPNO, ENAME, SAL FROM EMP WHERE SAL BETWEEN 1500 AND 3000; 

-- IN (LIST) ������
SELECT * FROM EMP WHERE DEPTNO = 10 OR DEPTNO = 30;

SELECT * FROM EMP WHERE DEPTNO IN(10,30);

-- ����� 7902 7788 7566 �� ������� ��� �ʵ� ������ ����ϼ���.
SELECT * FROM EMP WHERE EMPNO = 7902 OR EMPNO = 7788 OR EMPNO = 7566;

SELECT * FROM EMP WHERE EMPNO IN (7902, 7788, 7566);

-- LIKE ������ (% <�ѱ��� �̻� ����> _ <�ѱ���> : ���ϵ� ī��� ���� ����.)
SELECT * FROM EMP WHERE ENAME LIKE 'M%'; --�̸��� M���� �����ϴ� ����.

SELECT * FROM EMP WHERE ENAME LIKE '%M%'; -- M�� �ѱ��ڶ� ���ԵǴ� ����

SELECT * FROM EMP WHERE ENAME LIKE '_A%'; -- A�տ� �ݵ�� �ѱ��ڰ� �ִ� �ʵ�.

-- �Ի����� 82���� ����� ��� �ʵ带 ����ϼ���.
SELECT * FROM EMP WHERE HIREDATE >= '82-01-01' AND HIREDATE <= '82-12-31';

SELECT * FROM EMP WHERE HIREDATE LIKE '82%';

-- �Ի����� 1���� ����� ��� �ʵ带 ���
SELECT * FROM EMP WHERE HIREDATE LIKE '__-01-__';

-- COMM �� NULL �� �������� ��� �ʵ带 ���. (NULL �� IS �����ڷ� ���ؾ���.)
SELECT * FROM EMP WHERE COMM IS NULL;

-- COMM �� NULL �ƴ� �������� ��� �ʵ带 ���. (NULL �� IS �����ڷ� ���ؾ���.)
SELECT * FROM EMP WHERE COMM IS NOT NULL;

---------------------------------------------------------
--BETWEEN a AND b <-> NOT BETWEEN a AND b
--IN(LIST) a AND b <-> NOT IN(LIST) 
--LIKE '���ϵ�ī�嵿��' <-> NOT LIKE '���ϵ�ī�嵿��'
-- IS NULL <-> IS NOT NULL
---------------------------------------------------------

-- JOB �� '%'���� ������ ��� �ʵ� ���
SELECT * FROM EMP WHERE JOB LIKE '%\%%' ESCAPE '\'; -- ESCAPE \ �� ��ȣ�ڿ� �ִ� ���ڸ� �̽��������Ѵ�.
-- JOB �� 'A'���� ������ ��� �ʵ� ���
SELECT * FROM EMP WHERE JOB LIKE '%A%';

--9 ���� ��� (���� ���� / ���� ����)
SELECT * FROM EMP ORDER BY SAL; -- SAL �������� (�⺻�� ASC)
SELECT * FROM EMP ORDER BY SAL DESC; -- SAL ��������

SELECT * FROM EMP ORDER BY ENAME; -- �̸��� �������� (A ~ , �� ~ )  
SELECT * FROM EMP ORDER BY ENAME DESC;  -- �̸��� �������� (A ~ , �� ~ )

SELECT * FROM EMP ORDER BY HIREDATE; -- �̸��� �������� (A ~ , �� ~ )  
SELECT * FROM EMP ORDER BY HIREDATE DESC;  -- �̸��� �������� (A ~ , �� ~ )

-- ������ ū������� �ü� ������ ������� �ٸ� ������ �������� ���� �� �� �ִ�
-- ORDER BY �ʵ�1 DESC, �ʵ�2 ASC ... �̷����� ���� ������ ������ ���� ���� �ִ�.
SELECT * FROM EMP ORDER BY SAL DESC, EMPNO;

-- �̸�, ����*14 {��, ���� *14 �� ���� �������}

SELECT ENAME name, SAL*14 salary, DEPTNO dno 
FROM EMP 
WHERE DEPNO = 20 -- WHERE ������ ������ �ü� ����. 
ORDER BY salary; --���� (ALIAS) �� ���İ� �ʵ���� ��� �� �� �ִ�.

-- SQL �� �������
-- SELECT ENAME name, SAL*14 salary, DEPTNO dno --3��
-- FROM EMP  -- 1��
-- WHERE DEPNO = 20 -- 2��
-- ORDER BY salary; -- 4�� ... 
-- �� ������ �ִ�. 

-- ����(SAL*12+COMM) �� 2000 �̻��� ����� �̸� ������ ����ϵ� ������ ������ �����Ѵ�.
SELECT ENAME, SAL*12+NVL(COMM,0) AS ���� 
FROM EMP 
WHERE SAL*12+NVL(COMM,0) >= 15000
ORDER BY ���� DESC;

--1.	EMP ���̺��� sal�� 3000�̻��� ����� empno, ename, job, sal�� ���
SELECT EMPNO, ENAME, JOB, SAL 
FROM EMP
WHERE SAL >= 3000;

--2.	EMP ���̺��� empno�� 7788�� ����� ename�� deptno�� ���
SELECT ENAME, DEPTNO 
FROM EMP
WHERE EMPNO = '7788';

--3.	������ 24000�̻��� ���, �̸�, �޿� ��� (�޿�������)
SELECT EMPNO, ENAME, SAL
FROM EMP
WHERE (SAL*12+NVL(COMM,0)) >= 24000
ORDER BY SAL;

--4.	EMP ���̺��� hiredate�� 1981�� 2�� 20�� 1981�� 5�� 1�� ���̿� �Ի��� ����� ename,job,hiredate�� ����ϴ� SELECT ������ �ۼ� (�� hiredate ������ ���)
SELECT ENAME, JOB, HIREDATE
FROM EMP 
WHERE HIREDATE BETWEEN '81-02-20' AND '81-05-01'
ORDER BY HIREDATE;

--5.	EMP ���̺��� deptno�� 10,20�� ����� ��� ������ ��� (�� ename������ ����)
SELECT *
FROM EMP
WHERE DEPTNO IN (10, 20)
ORDER BY ENAME;

--6.	EMP ���̺��� sal�� 1500�̻��̰� deptno�� 10,30�� ����� ename�� sal�� ���(�� HEADING�� employee�� Monthly Salary�� ���)
SELECT ENAME "employee", SAL "Monthly Salary"
FROM EMP
WHERE SAL >= 1500 AND DEPTNO IN (10,30)
ORDER BY SAL;

--7.	EMP ���̺��� hiredate�� 1982���� ����� ��� ������ ���
SELECT *
FROM EMP
WHERE HIREDATE LIKE '1982%';

--8.	�̸��� ù�ڰ� C����  P�� �����ϴ� ����� �̸�, �޿� �̸��� ����
SELECT ENAME, SAL
FROM EMP
WHERE ENAME BETWEEN 'C' AND 'P' AND ENAME != 'Q'
ORDER BY ENAME, ENAME;

SELECT ENAME, SAL
FROM EMP
WHERE ENAME BETWEEN 'C%' AND 'P%' AND ENAME != 'Q'
ORDER BY ENAME;

--9.	EMP ���̺��� comm�� sal���� 10%�� ���� ��� ����� ���Ͽ� �̸�, �޿�, �󿩱��� ����ϴ� SELECT ���� �ۼ�
SELECT ENAME, SAL, COMM
FROM EMP
WHERE COMM >= SAL*1.1;

--10.	EMP ���̺��� job�� CLERK�̰ų� ANALYST�̰� sal�� 1000,3000,5000�� �ƴ� ��� ����� ������ ���
SELECT *
FROM EMP
WHERE JOB IN ('CLERK','ANALYST') AND SAL NOT IN (1000, 3000, 5000);  

--11.	EMP ���̺��� ename�� L�� �� �ڰ� �ְ� deptno�� 30�̰ų� �Ǵ� mgr�� 7782�� ����� ��� ������ ����ϴ� SELECT ���� �ۼ��Ͽ���.
SELECT *
FROM EMP
WHERE ENAME LIKE '%L%L%' AND (DEPTNO = 30 OR EMPNO = '7782');

--12.	��� ���̺��� �Ի����� 81�⵵�� ������ ���,�����, �Ի���, ����, �޿��� ���
SELECT EMPNO, ENAME, HIREDATE, JOB, SAL
FROM EMP
WHERE HIREDATE LIKE '81%';

--13.	��� ���̺��� �Ի����� 81���̰� ������ 'SALESMAN'�� �ƴ� ������ ���, �����, �Ի���, ����, �޿��� �˻��Ͻÿ�.
SELECT EMPNO, ENAME, HIREDATE, JOB, SAL
FROM EMP
WHERE HIREDATE LIKE '81%' AND JOB != 'SALESMAN';

SELECT EMPNO, ENAME, HIREDATE, JOB, SAL
FROM EMP
WHERE HIREDATE BETWEEN '81-01-01' AND '81-12-31' AND JOB != 'SALESMAN';

--14.	��� ���̺��� ���, �����, �Ի���, ����, �޿��� �޿��� ���� ������ �����ϰ�, �޿��� ������ �Ի����� ���� ������� �����Ͻÿ�.
SELECT EMPNO, ENAME, HIREDATE, JOB, SAL
FROM EMP
ORDER BY SAL DESC, HIREDATE ASC;

--15.	��� ���̺��� ������� �� ��° ���ĺ��� 'N'�� ����� ���, ������� �˻��Ͻÿ�
SELECT EMPNO, ENAME
FROM EMP
WHERE ENAME LIKE '__N%';

--16.	��� ���̺�������(SAL*12)�� 35000 �̻��� ���, �����, ������ �˻� �Ͻÿ�.
SELECT EMPNO, ENAME, SAL*12 AS SALYEAR
FROM EMP
WHERE SAL*12 >= 35000;
