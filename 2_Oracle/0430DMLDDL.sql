-- DDL (������ ���Ǿ�) :  Data Definition Language ; �����Ϳ� �� ������ ����
-- CREATE : ������ ���̽� ��ü ����
-- DROP : ������ ���̽� ��ü�� ����
-- ALTER : ������ �����ϴ� �����ͺ��̽� ��ü�� �ٽ� ����

-- 1. ���̺� ����� (CREATE)

CREATE TABLE EMP01 (
    EMPNO NUMBER(4),
    ENAME VARCHAR2(20),
    SAL NUMBER(7,2)
    );
    
-- å�� ������ �����ϴ� ���̺� �����մϴ�.
-- BOOK TABLE : BOOKID(������ȣ) NUMBER : BOOKNAME (�����̸�) ����(20) : PUBLISHER (���ǻ�) ���� 30 : PRICE(����) : NUMBER
-- PUBLISING_DATE (������) : DATE

CREATE TABLE BOOK (
    BOOKID NUMBER, -- ������ȣ
    BOOKNAME VARCHAR2(20), -- �����̸�
    PUBLISHER VARCHAR2(30), -- ���ǻ�
    PRICE NUMBER, -- ����
    PBLISING_DATE DATE -- ������
);

SELECT * FROM BOOK;

CREATE TABLE BOOK ( -- �ٸ� ��ü (���̺�, VIEW, ��������) �̸��� ������ �� �̸� ���Ұ�.
    BOOKID VARCHAR2(10), -- ������ȣ
    BOOKNAME VARCHAR2(20), -- �����̸�
    PUBLISHER VARCHAR2(30), -- ���ǻ�
    PRICE NUMBER, -- ����
    PBLISING_DATE DATE -- ������
);


-- DEPT TABLE  ���� ������ ���̺��� DEPTNO �� �����Ѵ�.

DESC DEPT;

CREATE TABLE DEPTNO (
    DEPTNO NUMBER(2, 0),
    DNAME VARCHAR2(14),
    LOC VARCHAR2(13)
);

SELECT * FROM DEPTNO;

-- EMP TABLE �� ���� ������ ���� �����Ͱ� ����ִ� ���̺� EMP01 �� �����Ѵ�.
DROP TABLE EMP01; --  ���̺� ����

CREATE TABLE EMP01
    AS
    SELECT * FROM EMP; -- TABLE ����. : CREATE ������ ���� SUBQUERY. AS �ڿ� �´�.
    
SELECT * FROM EMP01; --���������� �̿��ؼ� ���̺��� �ۼ��ϸ� ������ �����͸� �Ѳ����� �ű�. ���������� ������� ����

DESC EMP;
DESC EMP01;

-- EMP TABLE �� EMPNO, ENAME �� �����ϴ� EMP02  ���̺��� �����Ѵ�.
CREATE TABLE EMP02
AS
SELECT EMPNO, ENAME FROM EMP;

DESC EMP02;
SELECT * FROM EMP02;

-- EMP ���̺��� �μ���ȣ�� 10���� �������� EMPNO, ENAME, SAL �� �����ϴ� EMP03 ���̺� ����
CREATE TABLE EMP03
AS
SELECT EMPNO, ENAME, SAL FROM EMP WHERE DEPTNO =10;

DESC EMP03;
SELECT * FROM EMP03;

-- EMP  TABLE�� ������ �����ϴ� EMP04 ����(�����ʹ� �������� ����)
CREATE TABLE EMP04
AS
SELECT * FROM EMP WHERE 1 = 0; -- �����ʹ� ������� ����. (WHERE ������ �׻� �����̱� ������ ��¹��� ���� ������ �ҷ���.)

-- 2. ���̺��� ������ �����ϱ�. (ALTER TABLE)
-- ������ ���̺� �ʵ� �߰��ϱ�

SELECT * FROM EMP02;
ALTER TABLE EMP02 ADD(JOB VARCHAR2(20)); 

SELECT * FROM EMP04;
ALTER TABLE EMP04 ADD(LOC VARCHAR2(20));

-- ������ ���̺��� �ʵ��� ������ Ÿ�Թ� �������� ����.
DESC EMP02;
ALTER TABLE EMP02 MODIFY(ENAME VARCHAR2(30)); -- ��������
ALTER TABLE EMP02 MODIFY(ENAME VARCHAR2(2)); -- ��������Ұ� (�����Ͱ� �ִٸ� �ش� �κ��� �����ؼ� ����Ǿ�� �Ѵ�.)

DESC EMP04;
ALTER TABLE EMP04 MODIFY(LOC NUMBER);

DESC DEPT01;
ALTER TABLE DEPT01 MODIFY(DEPTNO NUMBER(3));

-- ������ ���̺��� �ʵ带 �����ϱ�.
SELECT * FROM EMP01;

ALTER TABLE EMP01 DROP COLUMN SAL; -- ���������� SAL �ʵ带 ����.

ALTER TABLE EMP01 ADD(SAL NUMBER(7,2));

-- �������� JOB �ʵ带 �����մϴ�.
ALTER TABLE EMP01 SET UNUSED(JOB); -- �������� JOB �ʵ带 �����մϴ�.

-- �������� �����Ѱ��� ó�� (���������� ������ Ȯ��.)
ALTER TABLE EMP01 DROP UNUSED COLUMNS;

SELECT * FROM EMP01;

--3. ���̺��� ����. (DROP TABLE)
DROP TABLE EMP04;

DROP TABLE BOOK;
CREATE TABLE BOOK(
    ID VARCHAR2(10),
    TITLE VARCHAR2(100)
); -- ������ �ϰ� ����� �ݵ�� ����� �ȴ�.

-- 4 ���̺��� �̸��� ����.
RENAME EMP02 TO NEW_EMP02; -- EMP02 ���̺� �̸��� NEW_EMP02 ��

SELECT * FROM NEW_EMP02;

-- 5 ���̺� �� ��� �����͸� �����ϴ�  DDL
TRUNCATE TABLE NEW_EMP02; -- ���� �Ұ���.

SELECT * FROM NEW_EMP02;

-- 6 ������ ��ųʸ� VS ������ ��ųʸ� ��. (DBA_XXXX , ALL_XXX , USER_ XXXX)

SELECT * FROM DBA_TABLES; -- DBA ���� ���̺��� ��� ������

SELECT * FROM USER_TABLES; -- USER ���� ���̺��� ��� ������

SELECT * FROM ALL_TABLES; -- �ڽ��� ����, �ڽ��� ������ �ִ� ���̺��� ��� ������.

SELECT * FROM USER_CONSTRAINTS; -- �ڽ��� �����ϰ� �ִ� ��������.

SELECT * FROM USER_VIEWS; -- �ڽ��� ������ VIEW �� �����ش�.

SELECT * FROM USER_INDEXES; --�ڽ��� �����ϰ� �ִ� INDEX����.

DESC USER_TABLES;

-- DML (������ ���۾�)  :  Data Manipulation Language ; �����͸� �߰�(INSERT), ����(DELETE) ����(UPDATE) �˻�(SELECT) ��
-- INSERT : �����ͺ��̽� ��ü�� �����͸� �Է�
-- ���� : (1) INSERT INTO table_name (column_name, ..) VALUES (column_values, ��);
CREATE TABLE DEPT01
AS
SELECT * FROM DEPT WHERE 0 = 1; 

-- DEPTNO(10) DNAME('ACCOUNTING') LOC('NEW YORK') �� �߰�.
INSERT INTO DEPT01 (DEPTNO, DNAME, LOC) VALUES (10, 'ACCOUNTING', 'NEW YORK');

INSERT INTO DEPT01 (LOC, DNAME, DEPTNO) VALUES ('SEOUL', 'IT', 20);

INSERT INTO DEPT01 (DEPTNO, DNAME, LOC) VALUES (10, 'SALES', NULL); -- ������ NULL �� ������ ����.

INSERT INTO DEPT01 (DEPTNO, DNAME) VALUES (40, 'INSA'); -- ������� ���� �ʵ�� �ڵ����� NULL ���� ��.

INSERT INTO DEPT01 VALUES (50, 'MARKER', NULL); -- ��� �ʵ��� ���� �־�� ������ ���� �ʴ´�. 

COMMIT; -- ��� DML ����� DBMS �� ������.

ROLLBACK; -- ������ �Է� ��� ����. (���ķ� Ŀ�� �ϱ� ������ ���ư�.)

TRUNCATE TABLE EMP01;
COMMIT; ----------------------- ������ Ŀ�� ����

INSERT INTO EMP01 (EMPNO, ENAME, SAL) VALUES (1111, 'ȫ', 1000);

SAVEPOINT AA; -- AA����

INSERT INTO EMP01 (EMPNO, ENAME, SAL) VALUES (2222, '��', 2000);

SAVEPOINT BB; -- BB����

INSERT INTO EMP01 (EMPNO, ENAME, SAL) VALUES (3333, '��', 3000);

ROLLBACK TO BB; -- ���̺� ����Ʈ ���� BB ���� ���ư�.

ROLLBACK TO AA; -- ���̺� ����Ʈ ���� AA ���� ���ư�.

ROLLBACK; -- ������ COMMIT �������� ���ư�.

SELECT * FROM  EMP01;

COMMIT; -- ������ COMMIT ���������� DML ��ɾ ����Ŭ�� ����.

DROP TABLE SAM01;
CREATE TABLE SAM01 (
    EMPNO NUMBER(4),
    ENAME VARCHAR2(20),
    JOB VARCHAR2(15),
    SAL NUMBER(7)
);

DESC SAM01;

INSERT INTO SAM01 VALUES (1000, 'APPLE', 'POLICE', 10000);
INSERT INTO SAM01 VALUES (1010, 'BANANA', 'NURSE', 15000);
INSERT INTO SAM01 VALUES (1020, 'ORENGE', 'DOCTOR', 25000);
INSERT INTO SAM01 VALUES (1030, 'VERY', NULL, 25000);
INSERT INTO SAM01 VALUES (1040, 'CAT', NULL, 2000);

COMMIT;

-- 10�� �μ��� ���� ������� �������� ���, �̸�, ����, �޿��� SAM01 �� �ִ´�.
INSERT INTO SAM01 (SELECT EMPNO, ENAME, JOB, SAL FROM EMP WHERE DEPTNO = 10); -- �������� �̿�  INSERT INTO

SELECT EMPNO, ENAME, JOB, SAL FROM EMP WHERE DEPTNO = 10; -- SUBQUERY

SELECT * FROM SAM01;

-- EX> ������ ���� : TABLE BOOK(BOOKNAME, BOOKID, PUBLISHER, PRICE) (������ �̸� : ������ ����, ����ID : 11, ���ǻ� : �Ѽ����м���, ���� : 90000)
DROP TABLE BOOK;
CREATE TABLE BOOK (
    BOOKID NUMBER(3),
    BOOKNAME VARCHAR2(30),
    PUBLISHER VARCHAR(30),
    PRICE NUMBER(6)
);

INSERT INTO BOOK (BOOKID, BOOKNAME,  PUBLISHER, PRICE) VALUES (11, '������ ����', '�Ѽ����м���', 90000);
COMMIT;

SELECT * FROM BOOK;

--(2) ������ ���� : UPDATE ���̺�� SET �����ϰ��� �ϴ� �ʵ� = �����ϰ��� �ϴ� ��
-- ������ ������ WHERE ���� ���� �ݵ�� ����ϰ� �ȴ�. 


DROP TABLE EMP01;
CREATE TABLE EMP01 AS SELECT * FROM EMP;

-- ���������� ���� ���
UPDATE EMP01 SET SAL = SAL*1.1;

-- ���� ������ �ִ� ���. ENAME = SMITH
-- SMITH �� �μ��� 30�� �μ��� �ű�� SAL 1000 ���� �λ�. MANAGER ����� ��� 7839
UPDATE EMP01 SET DEPTNO = 30, SAL = 1000, JOB = 'MANAGER', MGR = 7839 WHERE ENAME = 'SMITH'; 

-- EMP01 ���̺��� SAL�� 3000 �̻��� ����� SAL �� 10% �λ��մϴ�.
UPDATE EMP01 SET SAL = SAL * 1.1 WHERE SAL >= 3000;

COMMIT;

-- EMP01 ���̺��� DALLAS �� �ٹ��ϴ� �������� ������ 1000�� �λ��մϴ�. (����������DB �� �ݿ�.)
UPDATE EMP01 SET SAL = SAL+1000 WHERE DEPTNO = (SELECT DEPTNO FROM DEPT WHERE LOC = 'DALLAS');

COMMIT;

-- 20�� �μ��� ������, �μ����� 40�� �μ��� ���������� �μ������� �����ϴ� UPDATE ���� �ۼ�.
UPDATE DEPT01 SET (DNAME, LOC) = (SELECT DNAME, LOC FROM DEPT01 WHERE DEPTNO = 40)
WHERE DEPTNO = 20;

COMMIT;

SELECT * FROM DEPT01;

-- EMP01 �� ��� ������ 'KING' �� ����� �޿��� �Ի��Ϸ� �����ϼ���.
UPDATE EMP01 SET (SAL, HIREDATE) = (SELECT SAL, HIREDATE FROM EMP01 WHERE ENAME = 'KING');

COMMIT;

-- ������ ������ ���� UPDATE ��.
UPDATE EMP01 SET SAL = 9999, HIREDATE = SYSDATE WHERE ENAME = 'ȫ�浿'; -- ������ ������ ���ٸ� 0�� ������Ʈ. (�������� ������ ����� ����.)

SELECT * FROM EMP01;
--(3) DELETE : �����ͺ��̽� ��ü�� �����͸� ����. : DELETE FROM TABLE�� WHERE ����

SELECT * FROM DEPT01;

DELETE FROM DEPT01; -- ���̺��� ��� ������ �����ϴ�  DML���
TRUNCATE TABLE DEPT01; --���̺��� ��� ������ ����. DDL ���

ROLLBACK; -- ���� DML �� DELETE�� UPDATE INSERT ���� �۵��Ѵ�.

-- EMP01 ���̺��� 30�� �μ��� ������ �����մϴ�.
SELECT * FROM EMP01;

DELETE FROM EMP01 WHERE DEPTNO = 30;

-- EMP01 ���̺��� SMITH ������ ����ϼ���.
DELETE FROM EMP01 WHERE ENAME = 'SMITH';

-- EMP01 ���̺��� �μ����� SALES �� ����� �����մϴ�.
DELETE FROM EMP01 WHERE DEPTNO = (SELECT DEPTNO FROM DEPT WHERE DNAME = 'SALES');

-- SAM01 ���̺��� JOB �� ���������� �ʴ� ������ �����մϴ�.
DELETE FROM SAM01 WHERE JOB IS NULL; -- NULL  �� ���������� IS �� ...

SELECT* FROM SAM01;

--8. �������� : ���̺� �������� �����ʹ� �ԷµǴ� ���� ���� �ϴ°� ����.
DROP TABLE DEPT1;
CREATE TABLE DEPT1(
    DEPTNO NUMBER(2), -- ��Ű�� ����.
    DNAME VARCHAR2(14) NOT NULL, -- NULL ���� �ü� ���� �ʵ�� ����.
    LOC VARCHAR2(13) NOT NULL, -- NULL ���� �ü� ���� �ʵ�� ����.
    CONSTRAINT DEPT1_C0 PRIMARY KEY(DEPTNO),
    CONSTRAINT DEPT1_C1 UNIQUE(DNAME));

SELECT * FROM USER_CONSTRAINTS WHERE CONSTRAINT_NAME LIKE '%EMP1%';
SELECT * FROM USER_CONSTRAINTS WHERE CONSTRAINT_NAME LIKE '%DEPT1%';

DROP TABLE EMP1;
CREATE TABLE EMP1(
    EMPNO NUMBER(4),
    ENAME VARCHAR2(10) NOT NULL,
    JOB VARCHAR2(9),
    MGR NUMBER(4),
    HIREDATE DATE DEFAULT SYSDATE, -- �ԷµǴ� ������ �ð��� �Է�.
    SAL NUMBER(7,2) CHECK(SAL > 0), -- �Է����������� �����ؾ� �Էµ�.
    COMM NUMBER(7,2),
    DEPTNO NUMBER(2), -- DEPT1 ���̺��� DEPTNO ������ �ִ� ���� �Էµǵ��� ����.
    CONSTRAINT EMP1_C0 PRIMARY KEY(EMPNO),
    CONSTRAINT EMP1_C1 FOREIGN KEY(DEPTNO) REFERENCES DEPT1(DEPTNO)
);

SELECT * FROM DEPT1;
SELECT * FROM EMP1;

INSERT INTO DEPT1 VALUES (10, 'ACCOUNTING', 'NEW YORK');
INSERT INTO DEPT1 VALUES (20, 'RESERACH', 'DALLAS');
INSERT INTO DEPT1 VALUES (30, 'SALES', 'CHICAGO');
INSERT INTO DEPT1 VALUES (40, 'OPERATION', 'BOSTON');

INSERT INTO DEPT1 VALUES (SELECT * FROM DEPT); -- �����͸� ����.
COMMIT;

INSERT INTO EMP1 (EMPNO, ENAME, DEPTNO) VALUES (1111, 'ȫ', 10);
INSERT INTO EMP1 (EMPNO, ENAME, DEPTNO, SAL) VALUES (2222, 'KIM', 20, 0);

-- ex> å���� ������ ���̽� TABLE �� �����ϰ� �����͸� �־��.
DROP TABLE BOOKKIND;
CREATE TABLE BOOKKIND (
    BOOKCODE NUMBER(3),
    BOOKKIND VARCHAR2(30) NOT NULL,
    LOC VARCHAR2(50),
    PRIMARY KEY(BOOKCODE),
    UNIQUE(BOOKKIND)
);


DROP TABLE BOOK;
CREATE TABLE BOOK (
    BOOKID VARCHAR2(10),
    BOOKCODE NUMBER(3) NOT NULL,
    BOOKNAME VARCHAR2(30) NOT NULL,
    PUBLISHER VARCHAR2(100) NOT NULL,
    PUBYEAR DATE DEFAULT SYSDATE,
    PRIMARY KEY(BOOKID),
    FOREIGN KEY(BOOKCODE) REFERENCES BOOKKIND(BOOKCODE)
);

SELECT * FROM BOOKKIND;
SELECT * FROM BOOK;

-- BOOKKIND �Է�
INSERT INTO BOOKKIND (BOOKCODE, BOOKKIND, LOC) VALUES (100, 'ö��', '3�� �ι���');
INSERT INTO BOOKKIND (BOOKCODE, BOOKKIND, LOC) VALUES (200, '�ι�', '3�� �ι���');
INSERT INTO BOOKKIND (BOOKCODE, BOOKKIND, LOC) VALUES (300, '�ڿ�����', '4�� ���н�');
INSERT INTO BOOKKIND (BOOKCODE, BOOKKIND, LOC) VALUES (400, 'IT', '4�� ���н�');

-- BOOK �Է�
INSERT INTO BOOK (BOOKID, BOOKCODE, BOOKNAME, PUBLISHER, PUBYEAR) VALUES ('100A01', 100, 'ö������ ��', '��������', SYSDATE);
INSERT INTO BOOK (BOOKID, BOOKCODE, BOOKNAME, PUBLISHER, PUBYEAR) VALUES ('100A02', 200, '�̰��� �ڹٴ�', '��������', SYSDATE);

COMMIT;


-- DCL (������ �����) : ����ڸ� �����, ����ڸ� ����. ����� ���Ѻο�, ����� ���� ��Ż.

