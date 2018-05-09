--1~4 ������ ���� ������ ���̺��� �����ϱ� ���� ���̺� �����ϴ� SQL���� �ۼ�.
--  (��, ���̺��� ������ ���̺��� �����ϰ� �����Ͻÿ�) 
--  (����1. �������� ������ ��, �̸� �̿��Ͽ� cno�� ��ȣ�� �ڵ� �����Ѵ�.)
-- (����2. customer���̺��� levelno�� cus_level���̺��� levelno �� �ܷ�Ű ����)

--1 ������ �Է� SQL���� ������� �ۼ��Ͻÿ�.
--[ customer ���̺� ] - cno�� ��Ű, phone�� �ٸ������ �ٸ��� �Էµǵ��� ������
--		      joindate�� �Է����� ������ ���糯¥�� �Է�

--  cno    cname   joindate    phone         point  levelno
--   1   ȫ�浿   17/10/17  010-9999-9999     300     1
--   2   ��ö��   16/09/06  010-9999-9888    NULL     2
--   3   ȫ���   16/09/07  010-9999-7777      50     3

--[ cus_level ���̺� ] - levelno�� ��Ű, levelname�� NOT NULL ����.
--       levelno     levelname
--   	1            VVIP
--  	2             VIP           
--   	3            NORMAL
--   	4            BLACK

-- �������� �� NOT NULL
-- �������� �� UNIQUE
-- �������� �� PRIMARY KEY
-- �������� �� REFERENCES ���̺��̸�(�÷��̸�)
--          �� DEFAULT ����Ʈ��

DROP TABLE CUS_LEVEL;
CREATE TABLE CUS_LEVEL(
    LEVELNO NUMBER(2) PRIMARY KEY,
    LEVELNAME VARCHAR2(15) NOT NULL
);

DROP TABLE CUSTOMER_WORK;
CREATE TABLE CUSTOMER_WORK(
    CNO NUMBER(3) PRIMARY KEY,
    CNAME VARCHAR2(20) NOT NULL,
    JOINDATE DATE DEFAULT SYSDATE,
    PHONE VARCHAR2(40) UNIQUE,
    POINT NUMBER(4),
    LEVELNO NUMBER(2) REFERENCES CUS_LEVEL(LEVELNO)
);

DROP SEQUENCE SEQ_CUSTOMER;
CREATE SEQUENCE SEQ_CUSTOMER;

SELECT SEQ_CUSTOMER.CURRVAL FROM DUAL;

INSERT INTO CUS_LEVEL (LEVELNO, LEVELNAME) VALUES (1, 'VVIP');
INSERT INTO CUS_LEVEL (LEVELNO, LEVELNAME) VALUES (2, 'VIP');
INSERT INTO CUS_LEVEL (LEVELNO, LEVELNAME) VALUES (3, 'NORMAL');
INSERT INTO CUS_LEVEL (LEVELNO, LEVELNAME) VALUES (4, 'BLACK');

INSERT INTO CUSTOMER_WORK (CNO, CNAME, JOINDATE, PHONE, POINT, LEVELNO) 
VALUES (SEQ_CUSTOMER.NEXTVAL, 'ȫ�浿', TO_DATE('171017', 'YYMMDD'), '010-9999-9999', 300, 1);

INSERT INTO CUSTOMER_WORK (CNO, CNAME, JOINDATE, PHONE, LEVELNO) 
VALUES (SEQ_CUSTOMER.NEXTVAL, '��ö��', TO_DATE('160906', 'YYMMDD'), '010-9999-9888', 2);

INSERT INTO CUSTOMER_WORK (CNO, CNAME, JOINDATE, PHONE, POINT, LEVELNO) 
VALUES (SEQ_CUSTOMER.NEXTVAL, 'ȫ���', TO_DATE('160907', 'YYMMDD'), '010-9999-7777', 300, 3);

SELECT * FROM CUS_LEVEL;
SELECT * FROM CUSTOMER_WORK;

COMMIT;

--2. ���� ���� �ΰ��� ���̺��� �̿��Ͽ� �Ʒ��� ���� ����ϴ� SQL���� �ۼ��Ͻÿ�
--  cno    cname   joindate    phone         point  levelname
--   1   ȫ�浿   12/12/17  010-9999-9999     300     VVIP
--   2   ��ö��   16/09/06  010-9999-9888    NULL     VIP
--   3   ȫ���   16/09/07  010-9999-7777      50     NORMAL

SELECT CNO, CNAME, JOINDATE, PHONE, POINT, L.LEVELNAME
FROM CUSTOMER_WORK W, CUS_LEVEL L
WHERE W.LEVELNO = L.LEVELNO;

