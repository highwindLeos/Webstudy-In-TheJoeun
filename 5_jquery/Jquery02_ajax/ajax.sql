select * from members where id = 'aaa'; -- 중복확인 (있으면)

-- 종합 예제 1

select * from goods; 

SELECT * FROM GOODS WHERE GNAME = '땅콩';

update goods set gstock = 20 where gname = '기저귀';

commit;

-- 종합예제 2

SELECT * FROM EMP WHERE ENAME LIKE '%'||'A'||'%' AND JOB LIKE '%'||'MA'||'%';