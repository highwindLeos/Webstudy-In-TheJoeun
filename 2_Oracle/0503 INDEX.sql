--------------------------------------------------------------------------------------------------------------------------------
-- INDEX : 10���� �̻��� �����Ϳ��� Ư���� ���ǿ��� �˻� �ӵ��� ����Ű�� ���� ����.
--------------------------------------------------------------------------------------------------------------------------------

DROP TABLE EMP01;

-- EMP TABLE COPY : ������ ������ ���̺��� ���������� ������� �ʴ´�.
CREATE TABLE EMP01
AS SELECT * FROM EMP;

INSERT INTO EMP01 SELECT * FROM EMP; -- EMP ���̺� ������ �״�� ������ �Է�.
INSERT INTO EMP01 SELECT * FROM EMP;
INSERT INTO EMP01 SELECT * FROM EMP;
INSERT INTO EMP01 SELECT * FROM EMP;
INSERT INTO EMP01 SELECT * FROM EMP;
INSERT INTO EMP01 SELECT * FROM EMP;
INSERT INTO EMP01 SELECT * FROM EMP;
INSERT INTO EMP01 SELECT * FROM EMP;
INSERT INTO EMP01 SELECT * FROM EMP;
INSERT INTO EMP01 SELECT * FROM EMP;
INSERT INTO EMP01 SELECT * FROM EMP;
INSERT INTO EMP01 SELECT * FROM EMP;
INSERT INTO EMP01 SELECT * FROM EMP;
INSERT INTO EMP01 SELECT * FROM EMP;
INSERT INTO EMP01 SELECT * FROM EMP;
INSERT INTO EMP01 SELECT * FROM EMP;

SELECT COUNT(*) FROM EMP01;

INSERT INTO EMP01 (EMPNO, ENAME, JOB, SAL, DEPTNO) VALUES (9999, 'HONG', 'CLERK', 5000, 20);

SELECT * FROM EMP01 WHERE ENAME = 'HONG';

CREATE INDEX IDX_EMP01_ENAME ON EMP01(ENAME); -- �˻� �ε����� �÷��� �����Ѵ�.
-- ��Ű�� �ƴ�  ENAME �� �߽����� ��ȸ�ϴ� ���� ��ä ������ 95% �̻�
-- EMP01 ���̺��� ENAME�� �߽����� ��ȸ �� �� ���� �ӵ��� ���̴µ� ����

SELECT * FROM EMP01 WHERE ENAME = 'HONG';

DROP INDEX IDX_EMP01_ENAME; -- �ε����� ����