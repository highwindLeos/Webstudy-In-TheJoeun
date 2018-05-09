-- SCOTT1 이라는 계정을 만들고 SCOTT 에게 DBA 권한을 부여
-- 'DAYS' 이라는 사용자 계정을 하나 만들고 비번 DAY1234 DAYS 에게 접속 권한 EMPV1 을 SELECT 하는 권한.
--                                                           EMPV2 는 일부만 UPDATE 하는 권한
CREATE USER DAYS IDENTIFIED BY DAY1234; -- 계정 생성명령.

-- 권한을 준다. (접속 권한)
GRANT CREATE SESSION TO DAYS;
GRANT DBA TO DAYS;

-- LEOS.EMPV1 을 SELECT 하는 권한
GRANT SELECT ON LEOS.EMPV1 TO DAYS;
GRANT SELECT ON LEOS.EMPV2 TO DAYS;

-- LEOS.EMPV2 을 UPDATE 하는 권한
GRANT UPDATE (SAL, COMM) ON LEOS.EMPV2 TO DAYS;

-- 권한을 해제 해본다.
REVOKE SELECT ON LEOS.EMPV2 FROM DAYS;
REVOKE UPDATE ON LEOS.EMPV2 FROM DAYS;
REVOKE SELECT ON LEOS.EMPV1 FROM DAYS;

-- LEOS 계정의 DBA 권한을 박탈하는 DCL 명령어는.?
REVOKE DBA FROM LEOS;

-- 계정을 삭제하는 명령어. (DAYS 계정이 로그 아웃일 경우가능)
DROP USER DAYS CASCADE;

EXIT;

-- 1 계정 만드는 명령어 : CREATE USER 계정명 IDENTIFIED BY 접속비밀번호;
-- 2 권한 부여 : GRANT 권한 TO 계정명
-- 3 권한 박탈 : REVOKE 권한 FROM 계정
-- 4 계정 삭제 : DROP USER 계정 CASCADE

SHOW USER;