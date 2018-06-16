DROP TABLE MEMBERS;

CREATE TABLE MEMBERS (
    ID VARCHAR2(30) PRIMARY KEY, -- ID
    PW VARCHAR(30) NOT NULL,     -- �н�����
    NAME VARCHAR2(30) NOT NULL,  -- �̸�
    EMAIL VARCHAR2(30),          -- �̸���
    BIRTH DATE NOT NULL,         -- �������
    RDATE DATE NOT NULL,         -- ������ ��¥�� �ð�
    ADDRESS VARCHAR2(50)         -- �ּ�
);

SELECT * FROM MEMBERS;

-- ȸ�� ���� �� ID ���� �� ���� �ǴܵǴ� ������ �ʿ�
SELECT * MEMBERS WHERE ID = 'aaa';

-- ȸ�����Խ� INSERT.
INSERT INTO MEMBERS VALUES ('aaa', '111', '�̵���', 'lee@gmail.com', '1990-01-01', SYSDATE, '���� ����');
INSERT INTO MEMBERS VALUES ('bbb', '222', '�տ���', 'son@gmail.com', '1990-02-02', SYSDATE, '���� ����');

-- �α��� �� ID �� �˻� ���� PW Ȯ��.
SELECT *  FROM MEMBERS WHERE ID = 'aaa';

-- ȸ������ ���� �� �� ID�� DTO ��ȯ. JSP ȭ������ ���.
SELECT *  FROM MEMBERS WHERE ID = 'aaa';

-- ȸ������ ���� �� ��, UPDATE
UPDATE MEMBERS SET PW = '111', NAME='�̸�ȭ', EMAIL= 'days@gmail.com', BIRTH = '1990-01-02', ADDRESS = '���� ����' 
WHERE ID = 'aaa';

DELETE FROM MEMBERS WHERE ID = 'aaa';

COMMIT;