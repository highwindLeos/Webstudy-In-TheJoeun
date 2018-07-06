SELECT * FROM MEMBERS WHERE ID = 'AAA'; -- 중복확인 (있으면)

-- 종합 예제 1

SELECT * FROM GOODS;

SELECT * FROM GOODS WHERE GNAME = '땅콩';

UPDATE GOODS SET GSTOCK = 20 WHERE GNAME = '기저귀';

COMMIT;

-- 종합예제 2

SELECT empno, ename, job, mgr, hiredate, sal, NVL(comm, 0) comm, deptno
FROM EMP WHERE ENAME LIKE '%'||'A'||'%' AND JOB LIKE '%'||'MA'||'%';

select * from emp;