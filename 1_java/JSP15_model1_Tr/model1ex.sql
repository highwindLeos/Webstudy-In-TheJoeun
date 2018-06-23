-- ���̺� �����ϱ�
DROP TABLE FILEBOARD;
DROP TABLE CUSTOMER;

CREATE TABLE CUSTOMER(
    cId VARCHAR2(30) PRIMARY KEY,
    cPw VARCHAR2(30) NOT NULL,
    cName VARCHAR2(30) NOT NULL,
    cTel VARCHAR2(30),
    cEmail VARCHAR2(30) NOT NULL,
    cGender VARCHAR2(10),
    cAddr VARCHAR2(100));
    
DROP SEQUENCE FILEBOARD_SEQ;
CREATE SEQUENCE FILEBOARD_SEQ;

CREATE TABLE FILEBOARD(
    fNum NUMBER(5) PRIMARY KEY,
    cId VARCHAR2(30),
    fSubject VARCHAR2(300) NOT NULL,
    fContent VARCHAR2(1000) NOT NULL,
    fFilename VARCHAR2(100),
    fReadcount NUMBER(5) NOT NULL,
    fPw        VARCHAR2(30) NOT NULL,
    fRef       NUMBER(5) NOT NULL,
    fRe_step   NUMBER(5) NOT NULL,
    fRe_level  NUMBER(2) NOT NULL,
    fIp        VARCHAR2(20) NOT NULL,
    fRdate     DATE NOT NULL,
    FOREIGN KEY(cId) REFERENCES CUSTOMER(cId));
    
DROP TABLE BOOK;
CREATE TABLE BOOK(
    bid NUMBER(5) PRIMARY KEY,                  -- å��ȣ
    btitle VARCHAR2(100) NOT NULL,              -- å����
    bprice NUMBER(7) NOT NULL,                  -- å����
    bimage1 VARCHAR2(100) DEFAULT 'nothing.jpg',-- å�̹���1
    bimage2 VARCHAR2(100) DEFAULT 'nothing.jpg',-- å�̹���2
    bcontent VARCHAR2(1000),                    -- å�Ұ�����
    -- ����,���ǻ�,���ǳ�(��),�����(��), �Ǽ�����
    bdiscount NUMBER(3));                  -- ������
    
DROP SEQUENCE BOOK_SEQ;
CREATE SEQUENCE BOOK_SEQ;

---------------------------------------------CUSTOMER

-- CustomerDao�� confirmId�� ȸ������
SELECT * FROM CUSTOMER WHERE CID='aaa';

INSERT INTO CUSTOMER VALUES
    ('aaa','111','ȫ','9999-9999','h@h','m','��������');
    
commit;

-- CustomerDao�� �α���
SELECT * FROM CUSTOMER WHERE CID='aaa';
-- CustomerDao�� ȸ������ ����
UPDATE CUSTOMER SET CPW='111', CNAME='��',
    CTEL='8888-8888', CEMAIL='A@A', CGENDER='f',
    CADDR='�����' WHERE CID='aaa';
-- ����ȭ�鿡�� �� ȸ������ ����Ʈ(����¡ �ȵǴ°�)
SELECT * FROM CUSTOMER ORDER BY CID;
-- ����ȭ�鿡�� �� ȸ������ ����Ʈ(����¡ �Ǵ� �� ������)
SELECT ROWNUM RN, A.* FROM
    (SELECT * FROM CUSTOMER ORDER BY CID) A;
SELECT * FROM 
    (SELECT ROWNUM RN, A.* FROM
        (SELECT * FROM CUSTOMER ORDER BY CID) A)
    WHERE RN BETWEEN 2 AND 3;
SELECT COUNT(*) FROM CUSTOMER;

---------------------------------------------FILEBOARD

-- FILEBoardDao�� �۰��� ����
SELECT COUNT(*) TOTCNT FROM FILEBOARD;
-- FILEBoardDao�� �� �Է�
INSERT INTO FILEBOARD VALUES (FILEBOARD_SEQ.NEXTVAL, 'aaa','����','����\n�Դϴ�',
        NULL,0,'11',fileboard_seq.CURRVAL, 0,0,'127.0.0.1',SYSDATE);
rollback;
-- �亯�� �߰� �� �ؾ��� �� STEP   
UPDATE FILEBOARD SET FRE_STEP = FRE_STEP+1 WHERE FREF=1 AND FRE_STEP>0;
-- FILEBoardDao�� �۸��
SELECT F.*, C.CNAME, C.CEMAIL FROM FILEBOARD F, CUSTOMER C
    WHERE F.CID=C.CID ORDER BY FNUM DESC;
SELECT ROWNUM RN, A.* FROM 
    (SELECT F.*, C.CNAME, C.CEMAIL FROM FILEBOARD F, CUSTOMER C
    WHERE F.CID=C.CID ORDER BY FNUM DESC) A;
SELECT *
    FROM (SELECT ROWNUM RN, A.* FROM 
    (SELECT F.*, C.CNAME, C.CEMAIL FROM FILEBOARD F, CUSTOMER C
    WHERE F.CID=C.CID ORDER BY fref DESC, frestep) A)
    WHERE RN BETWEEN 1 AND 100; -- ����¡ó������ �� TOP-N����
    
truncate table fileboard;
SELECT COUNT(*) TOTCNT FROM FILEBOARD;
select * from fileboard where fnum>=390;

-- FILEBoardDao�� �� �󼼺���
UPDATE FILEBOARD SET FREADCOUNT = FREADCOUNT + 1 WHERE FNUM=1;
SELECT F.*, C.CNAME, C.CEMAIL FROM FILEBOARD F, CUSTOMER C
    WHERE F.CID=C.CID AND F.FNUM=1;
    
commit;
-- �� ����
UPDATE FILEBOARD SET 
    FSUBJECT = '��',
    FFILENAME = NULL,
    FCONTENT = '��',
    FPW = '11',
    FIP = '127.0.0.1'
    WHERE FNUM = 1;
DELETE FROM FILEBOARD WHERE FNUM=1 AND FPW='11';
ROLLBACK;

---------------------------------------------BOOK TABLE

-- å ���
INSERT INTO BOOK VALUES (BOOK_SEQ.NEXTVAL, 'JSP',20000,'nothing.jpg','nothing.jpg',
        'jsp 2.3 �����α׷��ֱ��ʺ��� �߱ޱ���',0); -- DAO ���
INSERT INTO BOOK (BID, BTITLE, BPRICE, BCONTENT ,BDISCOUNT)
    VALUES (BOOK_SEQ.NEXTVAL, 'sPRING',10000, '������4.0å',10);
INSERT INTO BOOK (BID, BTITLE, BPRICE, BCONTENT, BIMAGE1, BDISCOUNT)
    VALUES (BOOK_SEQ.NEXTVAL, 'jQuery',10000, 'jQuery','nothing.jpg',10);
INSERT INTO BOOK (BID, BTITLE, BPRICE, BCONTENT, BIMAGE2, BDISCOUNT)
    VALUES (BOOK_SEQ.NEXTVAL, 'android',10000,'androidå','nothing.jpg', 10);
commit;
-- å ��� ����
SELECT * FROM BOOK ORDER BY BID DESC;
SELECT ROWNUM RN, A.* FROM (SELECT * FROM BOOK ORDER BY BID DESC) A;

SELECT * FROM (SELECT ROWNUM RN, A.* FROM 
            (SELECT * FROM BOOK ORDER BY bID DESC) A)
    WHERE RN BETWEEN 3 AND 4;  -- ����¡ó���� �� TOP-N����
    
-- Ư��å�� �󼼺���
SELECT * FROM BOOK WHERE BID=5;
commit;
-- ��ϵ� å ����
SELECT COUNT(*) FROM BOOK;

delete from book where bid=5;