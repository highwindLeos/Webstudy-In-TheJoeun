DROP TABLE BOARD;

CREATE TABLE BOARD (
    NUM NUMBER PRIMARY KEY,         -- �۹�ȣ
    WRITER VARCHAR2(30) NOT NULL,   -- �۾���
    SUBJECT VARCHAR2(50) NOT NULL,  -- ����
    CONTENT VARCHAR2(300) NOT NULL, -- �۳���
--    CONTENT VARCHAR2(100) NOT NULL, -- �۳���
    EMAIL VARCHAR2(30),             -- �̸���
    READCOUNT NUMBER NOT NULL,     -- ��ȸ��
    PW VARCHAR2(30) NOT NULL,       -- �� ������ �� ���
    REF NUMBER NOT NULL,            -- �亯�۳��� ref ���� �� �׷� ó��
    RE_STEP NUMBER NOT NULL,        -- �� �׷쳻 ��� ����
    RE_LEVEL NUMBER NOT NULL,       -- �鿩 ���� ����
    IP VARCHAR2(20) NOT NULL,       -- �۾��� ��ǻ�� ������
    RDATE DATE NOT NULL           -- �۾� �ð�
);

-- �� ��� ���� (LIST.JSP)
SELECT COUNT(*) FROM BOARD; -- ����� �� ����
SELECT * FROM BOARD ORDER BY NUM DESC;        -- �� ��ϵ� ���
SELECT * FROM BOARD ORDER BY REF DESC;        -- �� �� �׷� 
-- �۾���
SELECT NVL(MAX(NUM), 0) + 1 NUMCOUNT FROM BOARD;
INSERT INTO BOARD VALUES (1, '�̵���', '������1', '�۳���', 'lee@gmail.com', 0, 'password', 1, 0, 0, '192.168.0.123', SYSDATE);
INSERT INTO BOARD VALUES ((SELECT NVL(MAX(NUM), 0) + 1 NUMCOUNT FROM BOARD), '�̳���', '��2', '�۳���2', 'na@gmail.com', 0, 'password2', (SELECT NVL(MAX(NUM), 0) + 1 NUMCOUNT FROM BOARD), 0, 0, '192.168.0.124', SYSDATE);

COMMIT;
-- �ش� �� ���� ����
SELECT * FROM BOARD WHERE ref = 222;

-- �� �����ϱ�
UPDATE BOARD SET WRITER = '�տ���', SUBJECT = '������', CONTENT = '������', EMAIL = 'NEW@GMAIL.COM', PW = '111', IP = '127.0.0.1' WHERE NUM = 1; 

-- �� �����ϱ�
DELETE FROM BOARD WHERE NUM = 2 AND PW = 'password'; -- ��� Ʋ���� ���� �ȵ�.
DELETE FROM BOARD WHERE NUM = 2 AND PW = 'password2';

-- �� ������ ����
DELETE FROM BOARD;
COMMIT;

-- SQL : TOP-N ���� ����¡ó���� ���̴� ����
SELECT * FROM BOARD ORDER BY REF DESC; -- 1 �ܰ�

SELECT ROWNUM RN, A.* FROM (SELECT * FROM BOARD ORDER BY REF DESC) A; -- 2�ܰ�

SELECT ROWNUM RN, A.* FROM (SELECT * FROM BOARD ORDER BY REF DESC) A
    WHERE ROWNUM BETWEEN 11 AND 20; -- 2�ܰ� �� �ȵȴ�.
    
SELECT * FROM (SELECT ROWNUM RN, A.* FROM (SELECT * FROM BOARD ORDER BY REF DESC, RE_STEP ASC) A)
    WHERE RN BETWEEN 11 AND 20; -- 3�ܰ� ž�ر��� : 2�ܰ踦 �ζ��� ��� �����´�.
    
-- �亯���� �Է��ϱ��� re_step ó��
SELECT * FROM BOARD WHERE NUM = 1;
UPDATE BOARD SET RE_STEP = RE_STEP + 1
    WHERE REF = 1 AND RE_STEP > 0;
