select * from members where id = 'aaa'; -- �ߺ�Ȯ�� (������)

-- ���� ���� 1

select * from goods; 

SELECT * FROM GOODS WHERE GNAME = '����';

update goods set gstock = 20 where gname = '������';

commit;

-- ���տ��� 2

SELECT * FROM EMP WHERE ENAME LIKE '%'||'A'||'%' AND JOB LIKE '%'||'MA'||'%';