SELECT * FROM MEMBERS WHERE ID = 'AAA'; -- �ߺ�Ȯ�� (������)

-- ���� ���� 1

SELECT * FROM GOODS;

SELECT * FROM GOODS WHERE GNAME = '����';

UPDATE GOODS SET GSTOCK = 20 WHERE GNAME = '������';

COMMIT;

-- ���տ��� 2

SELECT empno, ename, job, mgr, hiredate, sal, NVL(comm, 0) comm, deptno
FROM EMP WHERE ENAME LIKE '%'||'A'||'%' AND JOB LIKE '%'||'MA'||'%';

select * from emp;