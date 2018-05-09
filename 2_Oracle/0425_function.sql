-- �Լ�
-- 1 ������ �Լ� - INPUT 1�� OUTPUT 1��
SELECT ENAME, TO_CHAR(HIGRDATE, 'YYYY') YEAR FROM EMP;
SELECT ENAME, REPLACE(ENAME, 'A', 'B') FROM EMP;

-- 2 �׷� �Լ�
SELECT SUM(SAL) FROM EMP;
SELECT AVG(SAL) FROM EMP;

SELECT DEPTNO, SUM(SAL) 
FROM EMP 
GROUP BY DEPTNO;

SELECT * FROM DUAL; -- ���� ���� �Լ��� �����ϴ� Ư���� ���̺� DUAL
DESC DUAL;

SELECT * FROM DUMMY;

-- 1 ���� ���� �������Լ�
SELECT -10, ABS(-10) FROM DUAL; -- ���밪 : ���� ���� �Լ��� �����ϴ� Ư���� ���̺� DUAL���� ���� �Լ��� �׽�Ʈ

SELECT EXP(2) FROM DUMMY; -- e�� 2��.

SELECT POWER(2,10) FROM DUAL; -- 2�� 10��

SELECT 34.5678, ROUND(34.5678) FROM DUAL; -- �Ҽ��� �ݿø�. 
SELECT 34.5678, ROUND(34.5678, 2) FROM DUAL; -- �Ҽ��� 2�ڸ� �ݿø�. 
SELECT 34.5678, ROUND(34.5678, -1) FROM DUAL; -- ���� �ڸ����� �ݿø�

SELECT ENAME, SAL, ROUND(SAL, -2) AS "SALROUND" FROM EMP; -- ���� �ڸ����� �ݿø�

SELECT 34.5678, FLOOR(34.5678) FROM DUAL; -- �Ҽ��� ���� ������.

SELECT 34.5678, TRUNC(34.5678) FROM DUAL; -- �Ҽ��� ���� ������.

SELECT 34.5678, TRUNC(34.5678, 2) FROM DUAL; -- �Ҽ��� 2�ڸ� ������.

SELECT 34.5678, TRUNC(34.5678, -1) FROM DUAL; -- ���� �ڸ� ������. ()?

SELECT 34.5678, CEIL(34.5678) FROM DUAL; -- �Ҽ������� �ø�.

SELECT MOD(5, 3) FROM DUAL; -- 5 / 3 �� ������ ��ȯ.

-- ����� Ȧ���� ������ ��� �̸� �޿� �Ի����� ���.
SELECT ENAME, SAL, HIREDATE
FROM EMP
WHERE MOD(EMPNO, 2) = 1; -- ����� Ȧ���� ���.

-- 2 ����ó�� ���� ������ �Լ�.
SELECT 'WELcome TO oracle', UPPER('WELcome TO oracle') FROM DUAL; -- ���̽��� �빮�ڷ� ��ȯ

SELECT 'WELcome TO oracle', LOWER('WELcome TO oracle') FROM DUAL; -- ���̽��� �ҹ��ڷ� ��ȯ

SELECT 'WELcome TO oracle', INITCAP('WELcome TO oracle') FROM DUAL; -- ù���ڸ� �빮�ڷ� ��ȯ

-- �̸� (ù���ڸ� �빮��) , JOB (�ҹ���)
SELECT INITCAP(ENAME), LOWER(JOB) FROM EMP;

-- SMITHCLERK
SELECT ENAME || ' - ' || JOB FROM EMP;

--CONCAT()
SELECT CONCAT(ENAME,JOB) FROM EMP;
SELECT CONCAT(ENAME, CONCAT(' - ', JOB)) FROM EMP;

SELECT ENAME || '(' || SAL ||')' FROM EMP;
SELECT CONCAT(ENAME ,CONCAT('(' , CONCAT(SAL, ')'))) SHOW FROM EMP; -- ���� ����� ��ġ�ϴ� ���.

-- SUBSTR()
SELECT SUBSTR('wELCOME to Oracle', 4, 6) FROM DUAL; -- 4��° ���ں��� 6���� ����
SELECT SUBSTR('wELCOME to Oracle', 12, 10) FROM DUAL; -- 12��° ���ں��� 10���� ����

SELECT SUBSTR('010-9999-9999', -5, 4) FROM DUAL; -- ���ڿ� �ڿ��� 5��°���� 4���� ����

-- EMP TABLE ���� �̸��� E �� ������ �����Ǹ�� �ʵ带 ���
SELECT * FROM EMP WHERE ENAME LIKE '%E';
SELECT * FROM EMP WHERE SUBSTR(ENAME, -1, 1) = 'E'; -- ���� ����� ���� ����.

-- �Ի�⵵�� 83�⵵�� �������� ��� �ʵ� ���.
SELECT * FROM EMP WHERE HIREDATE LIKE '83%';
SELECT * FROM EMP WHERE SUBSTR(HIREDATE, 1, 2) = '83'; 

-- 9���� �Ի��� ����ʵ��� ��� �ʵ带 ����ϼ���.
SELECT * FROM EMP WHERE HIREDATE LIKE '%-09-%';
SELECT * FROM EMP WHERE SUBSTR(HIREDATE, 4, 2) = '09';

-- SUBSTRB() : BYTE ������ ��� = SUBSTRB(str, ��������ġ,�����Ұ���) : ���ڸ� �߶� ���� (�ѱ��� 2byte)
SELECT SUBSTR('ABCDEFG', 3, 2), SUBSTRB('ABCDEFG', 3, 2) FROM DUAL;
SELECT SUBSTR('�����ͺ��̽�', 4, 3), SUBSTRB('�����ͺ��̽�', 4, 3) FROM DUAL;
-- �Լ��� B �� ���� �Լ��� Ư¡ : BYTE �� ����� ������ �����´�.

-- INSTR(string, str, n, k); = string �� n��° ���ں��� k��° ���� str �� ã�Ƽ� ���°���� ã�Ƽ� ��ȯ.
SELECT INSTR('ABC ABC ABC', 'B' , 3, 2), INSTRB('ABC ABC ABC', 'B' , 3, 2) FROM DUAL;
SELECT INSTR('ABC ABC', 'B' , 3, 2), INSTRB('ABC ABC', 'B' , 3) FROM DUAL; 
SELECT INSTR('�����ͺ��̽�', '��', 3 ),INSTRB('�����ͺ��̽�', '��', 3 ) FROM DUAL;


-- LENGTH(string) ������ ���̸� ��ȯ. string �� ���ڼ��� ��ȯ.
SELECT LENGTH('Oracle'), LENGTHB('Oracle') FROM DUAL;
SELECT LENGTH('����Ŭ'), LENGTHB('����Ŭ') FROM DUAL;

-- LPAD(�ʵ�, �ڸ���, ����), RPAD : �Է� ���� ���ڿ��� ��ȣ�� �����Ͽ� Ư�� ������ ���ڿ��� ��ȯ�Ѵ�
SELECT ENAME, LPAD(SAL, 10, '*') FROM EMP;
SELECT ENAME, RPAD(SAL, 10, '*') FROM EMP;

SELECT RPAD(SUBSTR(ENAME, 1, 1), LENGTH(ENAME), '*') "ENAME", LPAD(SAL, 8, '*') "SAL" FROM EMP;
-- 82�⵵ 12���� �Ի��� ������ ��� �ʵ带 ���
SELECT * FROM EMP WHERE SUBSTR(HIREDATE, 1, 5) = '82-12';

-- ��� �̸� JOB �޴��� �̸��� ���ڿ� ����ŭ ���
-- 7369 SMITH CLEAK
-- 7369 ALLEN SALES
SELECT EMPNO, ENAME, SUBSTR(JOB, 1, LENGTH(ENAME))
FROM EMP;

-- REPLACE(�ʵ�, ã�� ����, ������ ����)
SELECT REPLACE(ENAME, 'A', 'B') FROM EMP; -- 'A' �� 'B' �� ����.
SELECT TRANSLATE(SAL, '0123456789', '�����̻�����ĥ�ȱ�') FROM EMP;

-- TRIM() : �¿��� ������ �߶� ��� ��� ��� ����� ���� ����.
SELECT '    Oracle     ' FROM DUAL;
SELECT LTRIM('    Oracle     ') MSG FROM DUAL;
SELECT RTRIM('    Oracle     ') MSG FROM DUAL;
SELECT TRIM('    Oracle     ') MSG FROM DUAL;

SELECT TRIM('a' FROM 'aaaaORAaaCLEaaaa') FROM DUAL; --�¿��� a �� ��λ���

-- ��¥ ���� ������ �Լ�. : SYSDATEŰ���带 �����Ѵ�.
SELECT SYSDATE FROM DUAL;  -- ���� �����ð��� ����Ѵ�.

SELECT ENAME, HIREDATE, TRUNC(MONTHS_BETWEEN(SYSDATE, HIREDATE)) "�ٹ�������" FROM EMP;

SELECT SYSDATE-1 "����", SYSDATE "����", SYSDATE+1 "����" FROM DUAL;  -- ���� �����ð��� ����Ѵ�.

SELECT SYSDATE "������", SYSDATE+14 "�ݳ�������" FROM DUAL;  -- ���� �����ð��� ����Ѵ�.

-- EMP ���̺�κ��� �Ի��� ���� �ּ� �޼�
SELECT ENAME, HIREDATE, SYSDATE, 
    TRUNC(SYSDATE - HIREDATE) "����", 
    TRUNC((SYSDATE - HIREDATE) / 7) "�ּ�", 
    TRUNC(MONTHS_BETWEEN(SYSDATE, HIREDATE)) "�޼�"
FROM EMP;


-- SELECT ADD_MONTHS() : ������ ���Ѵ�.
SELECT ADD_MONTHS(SYSDATE, 6) FROM DUAL; -- �����ð����� 6������ ���� ���� ���.
SELECT ADD_MONTHS(SYSDATE, -6) FROM DUAL; -- �����ð����� 6������ ������ ���.

SELECT SYSDATE FROM DUAL;

-- SELECT NEXT_DAY()
SELECT NEXT_DAY(SYSDATE, '�����') FROM DUAL; -- Ư����¥���� ���ʷ� �����ϴ� ������ ��ȯ.
SELECT ENAME, NEXT_DAY(HIREDATE, '�����' ) "ù����" FROM EMP;

-- Ư���� ��¥ 4�� 25�� - 4�� 1�� �� / �ݿø�(5�� 1��) / 4�� 30��
SELECT ENAME, HIREDATE, TRUNC(HIREDATE, 'MONTH') FROM EMP;
SELECT ENAME, HIREDATE, ROUND(HIREDATE, 'MONTH') FROM EMP;

SELECT ENAME, HIREDATE, LAST_DAY(HIREDATE) ���޳� FROM EMP; -- ���������� ���

SELECT SYSDATE, TRUNC(SYSDATE, 'YEAR') FROM DUAL;  -- �⵵���� ¥��. 1�� 1��
SELECT SYSDATE, TRUNC(SYSDATE, 'MONTH') FROM DUAL;  -- ������ ¥��. �̴� 1��
SELECT SYSDATE, TRUNC(SYSDATE, 'DAY') FROM DUAL;  -- �Ͽ��� ¥��. ���Ͽ���

SELECT SYSDATE, ROUND(SYSDATE, 'YEAR') FROM DUAL;  -- �⵵���� ¥��.
SELECT SYSDATE, ROUND(SYSDATE, 'MONTH') FROM DUAL;  -- ������ ¥��.
SELECT SYSDATE, ROUND(SYSDATE, 'DAY') FROM DUAL;  -- ������ ¥��. �������Ͽ��Ϸ� ����.

-- 82�⵵�� �Ի��� ������ ��� �ʵ�
SELECT * FROM EMP WHERE HIREDATE LIKE '82%'; -- 

-- EXTRACT() � �κи� �����ؼ� ���.
SELECT *  FROM EMP WHERE EXTRACT(YEAR FROM HIREDATE) = 1982; -- 1982 �⿡ �Ի��� �������.

SELECT *  FROM EMP WHERE EXTRACT(MONTH FROM HIREDATE) = 9; -- 9�� �� �Ի��� ���� ���.

SELECT ENAME, EXTRACT(DAY FROM HIREDATE) FROM EMP; -- �ϸ� ����.

-- 4 �� ��ȯ �Լ�

-- TO_CHAR(��¥ ����, ��¥ ����) : DATE -> ���� (VARCHAR) : NUMBER -> ����
-- TO_DATE() : ���� -> DATE (VARCHAR)
-- TO NUMBER() : ���� -> NUMBER�� NUMBER��

--- TO_CHAR(��¥ ����, ��¥ ����) : DATE -> ���� (VARCHAR) : NUMBER -> ����
-- YYYY�� MM�� DD �� DAY DYDLF AM, PM (���� ����) HH12 HH24 MI�� SS��
SELECT TO_CHAR(SYSDATE, 'YYYY"��" MM"��" DD"��" DAY AM HH12"��" MI"��" SS"��"') FROM DUAL; -- DATE -> ���ڿ�
SELECT ENAME, HIREDATE, TO_CHAR(HIREDATE, 'YY-MM-DD HH24 : MI') FROM EMP;

-- 82�⵵�� �Ի��� ������ ����ʵ�.
SELECT * FROM EMP WHERE EXTRACT(YEAR FROM HIREDATE) = 1982;
SELECT * FROM EMP WHERE TO_CHAR(HIREDATE, 'YY') = '82';

-- TO_CHAR() NUMBER -> ���ڿ�
-- 9 �ڸ����� ��Ÿ���� �ڸ����� ���� ������ ��� X
-- 0 �ڸ����� ��Ÿ���� �ڸ����� ���� �ʾƵ� 0�� ���
-- õ�� �ڸ��� ������ ,
-- �Ҽ��� ���п� .
-- L (���� ��ȭ ��ȣ)
-- $ �޷�ȭ ǥ��

SELECT ENAME, SAL, TO_CHAR(SAL, '$9,999,999') "�޷�", TO_CHAR(SAL, 'L9,999,999') "������ȭ", TO_CHAR(SAL, '0,000.00') "�Ҽ���" 
FROM EMP;

-- TO_DATE(���ڵ�����, '��¥����') ���� -> DATE��
SELECT TO_DATE('04-25-2018', 'MM-DD-YYYY') FROM DUAL;

-- 81�� 2�� 20�� ���� 81�⵵ 5�� 20�� ���̿� �Ի��� ����� ����ʵ�
SELECT * FROM EMP 
WHERE HIREDATE BETWEEN '81-02-20' AND '81-05-20';

SELECT * FROM EMP 
WHERE HIREDATE BETWEEN TO_DATE('1981-02-20', 'YYYY-MM-DD') AND TO_DATE('1981-05-20', 'YYYY-MM-DD');

-- ������ ���غ��� ���� ��������?
SELECT TRUNC(SYSDATE-TO_DATE('2018-01-01', 'YYYY-MM-DD')) DAY FROM DUAL;


-- TO NUMBER('���ڵ�����', ��������) : ���� -> NUMBER��
-- 9 �ڸ����� ��Ÿ���� �ڸ����� ���� ������ ��� X
-- 0 �ڸ����� ��Ÿ���� �ڸ����� ���� �ʾƵ� 0�� ���
-- õ�� �ڸ��� ������ ,
-- �Ҽ��� ���п� .
-- L (���� ��ȭ ��ȣ)
-- $ �޷�ȭ ǥ��
SELECT TO_NUMBER('20,000', '99,999') FROM DUAL;

-- 5 NVL(NULL�ϼ��� �ִ� ������, NULL ���� ��ü�� ��) : NULL ���� �Լ� Ư���� ���ڳ� ���ڷ� ��ȯ�ϱ�����

-- ��� �̸� ���ӻ���� ��� (NULL -> ����)
SELECT EMPNO, ENAME, NVL(TO_CHAR(MGR), 'CEO') FROM EMP;

-- 6 DECODE(ǥ����, ����1, ���1, ����2, ���2, ����3, ���3, �⺻���n ) �Լ� 
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
--- �� �Ʒ��� ������ ���� ����.
SELECT ENAME, DEPTNO,
    CASE DEPTNO WHEN 10 THEN 'ACCOUNTING'
                WHEN 20 THEN 'RESERACH'
                WHEN 30 THEN 'SALES'
                WHEN 40 THEN 'OPERATION'
                ELSE 'ETC'
    END AS "DNAME" FROM EMP;
    
-- ������ ANALTST �� 10% �޿� �λ�, SALESMAN �̸� 20% �޿��λ� MANAGER �� 30% �λ�
-- CLERK �� 40% �޿��λ� �׿� ����� �޿�����
-- ��� �̸� �޿� JOB �λ�� �޿�.
SELECT EMPNO, ENAME, SAL, DECODE(JOB,'ANALTST', ROUND(SAL*1.1),
                                    'SALESMAN', ROUND(SAL*1.2),
                                    'MANAGER', ROUND(SAL*1.3),
                                    'CLERK', ROUND(SAL*1.4), SAL) AS "�λ�޿�" 
                                FROM EMP;

SELECT EMPNO, ENAME, SAL,
    CASE JOB    WHEN 'ANALTST' THEN ROUND(SAL*1.1)
                WHEN 'SALESMAN' THEN ROUND(SAL*1.2)
                WHEN 'MANAGER' THEN ROUND(SAL*1.3)
                WHEN 'CLERK' THEN ROUND(SAL*1.4)
                ELSE SAL
    END AS "�λ�޿�" FROM EMP;
    
-- 9 �׿� : EMP TABLE �� ������ ǥ��
--  LEVEL : ������ ���ǹ����� �˻��� ����� ���� �������� ���� ǥ��
--?	START WITH : �������� ��� ������ ǥ���ϱ� ���� �ֻ��� ��
--?	CONNECT BY PRIOR : ���� ������ �����͸� �����ϴ� �÷�
SELECT LEVEL, LPAD(' ', LEVEL * 3) || ENAME, EMPNO, MGR 
FROM EMP
WHERE ENAME <> 'CLARK'
    START WITH MGR IS NULL
    CONNECT BY PRIOR EMPNO = MGR;
    
--------------------------------------------------------------------
-- ������ ����
--------------------------------------------------------------------
--1 ���� ��¥�� ����ϰ� �� ���̺��� Current Date�� ����ϴ� SELECT ������ ����Ͻÿ�.
SELECT SYSDATE "Current Date" FROM DUAL;

--2 EMP ���̺��� ���� �޿��� 15%�� ������ �޿��� �����ȣ,�̸�,����,�޿�,������ �޿�(New Salary),������(Increase)�� ����ϴ� SELECT ������ ����Ͻÿ�.
SELECT EMPNO, ENAME, JOB, SAL, TRUNC(SAL*1.15, 2) "New Salary", TRUNC((SAL*1.15)-SAL, 2) "INCREASE"
FROM EMP;

--3 EMP ���̺��� �̸�,�Ի���,�Ի��Ϸκ��� 6���� �� ���ƿ��� ������ ���Ͽ� ����ϴ� SELECT ������ ����Ͻÿ�.
SELECT ENAME, HIREDATE, NEXT_DAY(ADD_MONTHS(HIREDATE, 6), '������') "���ƿ� ������"
FROM EMP;

--4 EMP ���̺��� �̸�,�Ի���, �Ի��Ϸκ��� ��������� ����,�޿�, �Ի��Ϻ��� ��������� �޿��� �Ѱ踦 ����ϴ� SELECT ������ ����Ͻÿ�.
SELECT ENAME, HIREDATE,  TRUNC(MONTHS_BETWEEN(SYSDATE, HIREDATE)) "����", SAL, TRUNC(MONTHS_BETWEEN(SYSDATE, HIREDATE)) * SAL "�ѱ޿�"
FROM EMP;

--5 EMP ���̺��� ��� ����� �̸��� �޿�(15�ڸ��� ��� ������ �� ���� ��*���� ��ġ)�� ����ϴ� SELECT ������ ����Ͻÿ�.
SELECT ENAME, LPAD(SAL, 15, '*')
FROM EMP;

--6 EMP ���̺��� ��� ����� ������ �̸�,����,�Ի���,�Ի��� ������ ����ϴ� SELECT ������ ����Ͻÿ�.
SELECT ENAME, JOB,  HIREDATE, TO_CHAR(HIREDATE, 'DAY') "����"
FROM EMP; 

--7 EMP ���̺��� �̸��� ���̰� 6�� �̻��� ����� ������ �̸�,�̸��� ���ڼ�,������ ����ϴ� SELECT ������ ����Ͻÿ�.
SELECT ENAME,LENGTH(ENAME), JOB
FROM EMP
WHERE LENGTH(ENAME) >= 6;

--8 EMP ���̺��� ��� ����� ������ �̸�, ����, �޿�, ���ʽ�, �޿�+���ʽ��� ����ϴ� SELECT ������ ����Ͻÿ�
SELECT ENAME, JOB, SAL, COMM, SAL+NVL(COMM,'0')
FROM EMP;

--9 ��� ���̺��� ������� 2��° ���ں��� 3���� ���ڸ� �����Ͻÿ�. 
SELECT SUBSTR(ENAME, 2, 3) FROM EMP;

------------------------------------------------------------------------------------------------

--10 ��� ���̺��� �Ի����� 12���� ����� ���, �����, �Ի����� �˻��Ͻÿ�
SELECT EMPNO, ENAME, HIREDATE
FROM EMP
WHERE EXTRACT(MONTH FROM HIREDATE) = 12;

SELECT EMPNO, ENAME, HIREDATE
FROM EMP
WHERE TO_CHAR(HIREDATE, 'MM') = 12;

--11 ������ ���� ����� �˻��� �� �ִ� SQL ������ �ۼ��Ͻÿ�
--EMPNO		ENAME		�޿�
--7369		SMITH		*******800
--7499		ALLEN		******1600
--7521		WARD		******1250
SELECT EMPNO, ENAME, LPAD(SAL, 10, '*') "�޿�" FROM EMP;

--12 ������ ���� ����� �˻��� �� �ִ� SQL ������ �ۼ��Ͻÿ�
--EMPNO	 ENAME 	�Ի���
--7369	  SMITH		1980-12-17
SELECT EMPNO, ENAME, TO_CHAR(HIREDATE, 'YYYY-MM-DD') AS �Ի��� FROM EMP;

--13 ��� ���̺��� �޿��� ���� ���, �̸�, �޿�, ����� �˻��ϴ� SQL ������ �ۼ� �Ͻÿ�. 
--(Hint : CASE �Լ� ���) �޿��� 0~1000 E / 1001~2000 D / 2001~3000 C / 3001~4000 B / 4001~5000 A
--(cf) �޿���- 0~999 E / 1000~1999 D / 2000~2999 C / 3000~3999 B / 4000�̻� A
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
-- DECODE�� �̿��� ���.
SELECT EMPNO, ENAME, SAL, DECODE(TRUNC((SAL-1) /1000),
                                                        0,   'E',
                                                        1,   'D',
                                                        2,   'C',
                                                        3,   'B',
                                                             'A') AS GRADE
FROM EMP
ORDER BY GRADE;

--14. ��� ���̺��� �μ� 20 �� �޿� �տ� $�� �����ϰ�3�ڸ����� ,�� ���
SELECT ENAME, JOB, TO_CHAR(SAL, '$999,999') "�޿�"
FROM EMP
WHERE DEPTNO = 20;
