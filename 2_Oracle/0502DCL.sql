-- SCOTT1 �̶�� ������ ����� SCOTT ���� DBA ������ �ο�
-- 'DAYS' �̶�� ����� ������ �ϳ� ����� ��� DAY1234 DAYS ���� ���� ���� EMPV1 �� SELECT �ϴ� ����.
--                                                           EMPV2 �� �Ϻθ� UPDATE �ϴ� ����
CREATE USER DAYS IDENTIFIED BY DAY1234; -- ���� �������.

-- ������ �ش�. (���� ����)
GRANT CREATE SESSION TO DAYS;
GRANT DBA TO DAYS;

-- LEOS.EMPV1 �� SELECT �ϴ� ����
GRANT SELECT ON LEOS.EMPV1 TO DAYS;
GRANT SELECT ON LEOS.EMPV2 TO DAYS;

-- LEOS.EMPV2 �� UPDATE �ϴ� ����
GRANT UPDATE (SAL, COMM) ON LEOS.EMPV2 TO DAYS;

-- ������ ���� �غ���.
REVOKE SELECT ON LEOS.EMPV2 FROM DAYS;
REVOKE UPDATE ON LEOS.EMPV2 FROM DAYS;
REVOKE SELECT ON LEOS.EMPV1 FROM DAYS;

-- LEOS ������ DBA ������ ��Ż�ϴ� DCL ��ɾ��.?
REVOKE DBA FROM LEOS;

-- ������ �����ϴ� ��ɾ�. (DAYS ������ �α� �ƿ��� ��찡��)
DROP USER DAYS CASCADE;

EXIT;

-- 1 ���� ����� ��ɾ� : CREATE USER ������ IDENTIFIED BY ���Ӻ�й�ȣ;
-- 2 ���� �ο� : GRANT ���� TO ������
-- 3 ���� ��Ż : REVOKE ���� FROM ����
-- 4 ���� ���� : DROP USER ���� CASCADE

SHOW USER;