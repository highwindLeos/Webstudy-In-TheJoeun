-- ������ ����
DROP TABLE COMANT;
DROP TABLE FOLLOW;
DROP TABLE BOARD;

DROP TABLE MEMBER;

DROP TABLE GGRADE;
DROP TABLE GAME;

DROP TABLE ADMIN;
DROP TABLE NOTICE;

-- ������ ������ ����
DROP SEQUENCE MEMBER_SEQ;
DROP SEQUENCE GAME_SEQ;

DROP SEQUENCE FOLLOW_SEQ;
DROP SEQUENCE COMANT_SEQ;
DROP SEQUENCE BOARD_SEQ;
DROP SEQUENCE NOTICE_SEQ;


-- ���̺�� ������ ����
CREATE TABLE MEMBER (
    mId VARCHAR2(20) PRIMARY KEY,
    mPW VARCHAR2(20) NOT NULL,
    mName VARCHAR2(30) NOT NULL,
    mEmail VARCHAR2(50) NOT NULL,
    mPhoto VARCHAR2(50) DEFAULT 'nothing.png',
    mTel VARCHAR2(30) NOT NULL,
    mGender VARCHAR2(10) NOT NULL,
    mAddr VARCHAR2(100) NOT NULL,
    mText VARCHAR2(300),
    mBirth DATE NOT NULL,
    mRdate DATE DEFAULT SYSDATE,
    mPoint NUMBER(10) DEFAULT 100
);

CREATE TABLE COMANT (
    cNum NUMBER(9) PRIMARY KEY,
    gId VARCHAR2(20) REFERENCES GAME(gId),
    mId VARCHAR2(20) REFERENCES MEMBER(mId),
    comant VARCHAR2(200) NOT NULL
);

CREATE TABLE FOLLOW (
    fNum NUMBER(9) PRIMARY KEY,
    mId VARCHAR2(20) REFERENCES MEMBER(mId),
    fId VARCHAR2(20) NOT NULL
);

CREATE TABLE BOARD (
    bNum NUMBER(9) PRIMARY KEY,
    mId VARCHAR2(20) REFERENCES MEMBER(mId),
    bTitle VARCHAR2(100) NOT NULL,
    bContent CLOB NOT NULL,
    bCnt NUMBER(9) DEFAULT 0,
    bFile1 VARCHAR2(100),
    bRef NUMBER(5) NOT NULL,
    bStep NUMBER(5) NOT NULL,
    bLevel NUMBER(5) NOT NULL,
    bLike NUMBER(9) DEFAULT 0,
    bIp VARCHAR2(20) NOT NULL,
    bRdate DATE DEFAULT SYSDATE
);

CREATE TABLE GGRADE (
    gGno NUMBER(3) PRIMARY KEY,
    GRNAME VARCHAR2(10) NOT NULL,
    LOWPOINT NUMBER(5) NOT NULL,
    HIPOINT NUMBER(5) NOT NULL
);

CREATE TABLE GAME (
    gId VARCHAR2(20) PRIMARY KEY,
    gNaME VARCHAR2(100) NOT NULL,
    gImage VARCHAR2(50) DEFAULT 'emptyGame.png',
    gDes CLOB NOT NULL,
    gPub VARCHAR2(30) NOT NULL,
    gRdate DATE NOT NULL,
    gGrade NUMBER(10) NOT NULL,
    gVoteCnt NUMBER(10) NOT NULL,
    gGno NUMBER(3) REFERENCES GGRADE(gGno)
);

CREATE TABLE ADMIN (
    aNum NUMBER(9) PRIMARY KEY,
    aId VARCHAR2(20) NOT NULL,
    aPw VARCHAR2(20) NOT NULL,
    aName VARCHAR2(30) NOT NULL    
);

CREATE TABLE NOTICE (
    nNum NUMBER(9) PRIMARY KEY,
    nTitle VARCHAR2(100) NOT NULL,
    nContent CLOB NOT NULL,
    nAuthor VARCHAR2(10) NOT NULL,
    nRdate DATE DEFAULT SYSDATE
);

CREATE SEQUENCE GAME_SEQ;
CREATE SEQUENCE FOLLOW_SEQ;
CREATE SEQUENCE COMANT_SEQ;
CREATE SEQUENCE BOARD_SEQ;
CREATE SEQUENCE NOTICE_SEQ;
CREATE SEQUENCE ADMIN_SEQ;


----------------------------------------------------------------------------------------
-- ���̺� ���� Ȯ��
----------------------------------------------------------------------------------------
SELECT * FROM ADMIN;
SELECT * FROM BOARD;
SELECT * FROM COMANT;
SELECT * FROM FOLLOW;
SELECT * FROM GAME;
SELECT * FROM GGRADE;
SELECT * FROM MEMBER;
SELECT * FROM NOTICE;
---------------------------------------------------------------------------------------
-- ���� ���
---------------------------------------------------------------------------------------
-- ���� ��� ����
INSERT INTO GGRADE (GGNO, GRNAME, LOWPOINT, HIPOINT) VALUES (1, '�����', 0, 9999); -- �����
INSERT INTO GGRADE (GGNO, GRNAME, LOWPOINT, HIPOINT) VALUES (2, '�ǹ�', 10000, 19999); -- �ǹ�
INSERT INTO GGRADE (GGNO, GRNAME, LOWPOINT, HIPOINT) VALUES (3, '���', 20000, 29999); -- ���
INSERT INTO GGRADE (GGNO, GRNAME, LOWPOINT, HIPOINT) VALUES (4, '�÷�Ƽ��', 30000, 39999); -- �÷�Ƽ��
INSERT INTO GGRADE (GGNO, GRNAME, LOWPOINT, HIPOINT) VALUES (5, '�����̾�', 40000, 49999); -- �����̾�
INSERT INTO GGRADE (GGNO, GRNAME, LOWPOINT, HIPOINT) VALUES (6, '������', 50000, 99999999); -- ������

UPDATE GGRADE SET HIPOINT = 99999999 WHERE GGNO = 6;

COMMIT;
---------------------------------------------------------------------------------------
-- ���� ���̺�
---------------------------------------------------------------------------------------
-- top-n ����¡ ��� (���� ����Ʈ)
SELECT GID, GNAME, GIMAGE, GDES, GPUB, GRDATE, GGRADE, GVOTECNT, GA.GGNO, GRNAME, LOWPOINT, HIPOINT, 
TRUNC((NVL(GGRADE / DECODE(GVOTECNT, 0, null, GVOTECNT), 0) * 10) / 10, 2) GRADEAVG 
        FROM GAME GA, GGRADE R 
        WHERE
        GGRADE BETWEEN R.LOWPOINT AND R.HIPOINT AND gId LIKE '2'
ORDER BY GRDATE DESC;

SELECT RN, GID, GNAME, GIMAGE, GDES, GPUB, GRDATE, GGRADE, GVOTECNT, GGNO, GRNAME, LOWPOINT, HIPOINT FROM
    (SELECT ROWNUM RN, A.* FROM 
    (SELECT GID, GNAME, GIMAGE, GDES, GPUB, GRDATE, GGRADE, GVOTECNT, GA.GGNO, GRNAME, LOWPOINT, HIPOINT
        FROM GAME GA, GGRADE R 
        WHERE GGRADE BETWEEN R.LOWPOINT AND R.HIPOINT ORDER BY GRDATE DESC) A)
WHERE RN BETWEEN 1 AND 10;
-- �ֽű� 8�� ���
SELECT RN, GID, GNAME, GIMAGE, GDES, GPUB, GRDATE, GGRADE, GVOTECNT, GGNO, GRNAME, LOWPOINT, HIPOINT FROM 
        (SELECT ROWNUM RN, A.* FROM 
        (SELECT GID, GNAME, GIMAGE, GDES, GPUB, GRDATE, GGRADE, GVOTECNT, GA.GGNO, GRNAME, LOWPOINT, HIPOINT 
                FROM GAME GA, GGRADE R 
                WHERE GGRADE BETWEEN R.LOWPOINT AND R.HIPOINT) A) 
WHERE RN BETWEEN 1 AND 8;

-- ���� �� ���ϱ�
SELECT COUNT(*) FROM GAME;

-- ���� ����ϱ�
INSERT INTO GAME (gId, gName, gImage, gDes, gPub, gRdate, gGrade, gVoteCnt, gGno)
VALUES ('A'||GAME_SEQ.NEXTVAL, '�����̸�4', 'gameimage.jpg', '���� ����4', '���ۻ�4', '1984-07-05', 0, 0, 1);

COMMIT;
-- ���� ��������
UPDATE GAME SET 
            gName = '��������', 
            gImage = 'modifyimage.jpg', 
            gDes = '��������', 
            gPub = '���� ���ۻ�',
            gRdate = '1988-06-05'
WHERE gId = '2';

UPDATE GAME SET GVOTECNT = 2500 WHERE GID = '22';
-- ���� ����
DELETE FROM GAME WHERE GID = '22';
commit;
rollback;
-- ���� ��ǥ �ϱ� 
UPDATE GAME SET GGRADE = GGRADE + 10, GVOTECNT = GVOTECNT + 1
WHERE GID = 2;
-- ��ǥ�� ���� ��� ����
SELECT R.GGNO FROM GAME G, GGRADE R
                            WHERE GGRADE BETWEEN R.LOWPOINT AND R.HIPOINT; -- SUBQUERY
                            
UPDATE GAME SET Ggno = (SELECT R.GGNO FROM GAME G, GGRADE R
                        WHERE GGRADE BETWEEN R.LOWPOINT AND R.HIPOINT AND GID LIKE '%'||2)
                        WHERE GID LIKE '%'||2;
                        
-- ���� �˻� : �⺻
SELECT GID, GNAME, GIMAGE, GDES, GPUB, GRDATE, GGRADE, GVOTECNT, GA.GGNO, GRNAME, LOWPOINT, HIPOINT, 
TRUNC((NVL(GGRADE / DECODE(GVOTECNT, 0, null, GVOTECNT), 0) * 10) / 10, 2) GRADEAVG 
        FROM GAME GA, GGRADE R 
        WHERE
        GGRADE BETWEEN R.LOWPOINT AND R.HIPOINT 
        AND UPPER(GNAME) LIKE '%'||''||'%' 
        AND UPPER(GPUB)  LIKE '%'||''||'%' 
        AND UPPER(GDES) LIKE '%'||''||'%'
ORDER BY GRDATE DESC;

SELECT * FROM GAME;
DELETE FROM GAME WHERE GID = 'A��ŷ�� 1982��';


-- ���� �˻� : �󼼰˻�
SELECT GID, GNAME, GIMAGE, GDES, GPUB, GRDATE, GGRADE, GVOTECNT, GA.GGNO, GRNAME, LOWPOINT, HIPOINT, 
TRUNC((NVL(GGRADE / DECODE(GVOTECNT, 0, null, GVOTECNT), 0) * 10) / 10, 2) GRADEAVG 
        FROM GAME GA, GGRADE R 
        WHERE
        GGRADE BETWEEN R.LOWPOINT AND R.HIPOINT 
        AND UPPER(GNAME) LIKE '%'||''||'%' 
        AND UPPER(GPUB)  LIKE '%'||''||'%' 
        AND UPPER(GDES) LIKE '%'||''||'%'
        AND GA.GGNO = 1
        AND TRUNC((NVL(GGRADE / DECODE(GVOTECNT, 0, null, GVOTECNT), 0) * 10) / 10, 2) >= 2 
        AND UPPER(GID) LIKE 'A'||'%'
ORDER BY GRDATE DESC;
------------------------------------------------
-- ���� �ڸ�Ʈ ���
------------------------------------------------
SELECT * FROM COMANT;
-- ������ ���� ������ �ڸ�Ʈ �ޱ�
INSERT INTO COMANT (CNUM, GID, MID, COMANT) 
VALUES (COMANT_SEQ.NEXTVAL, '2', 'leo', '�ڸ�Ʈ�Դϴ�');

UPDATE MEMBER SET MPOINT = MPOINT + 5 WHERE MID = 'leo';

SELECT * FROM COMANT WHERE GID = 'A42' ORDER BY CNUM DESC;

-- �ֽű� ����Ʈ
SELECT * FROM
(SELECT ROWNUM RN, A.* FROM (SELECT * FROM COMANT ORDER BY CNUM DESC) A)
WHERE RN BETWEEN 1 AND 5 AND MID = 'leo';

-- �ڸ�Ʈ ����
DELETE FROM COMANT WHERE CNUM = '25';

commit;
ROLLBACK;
------------------------------------------------
-- ȸ�� ���
------------------------------------------------
-- ȸ�� ����Ʈ :
SELECT * FROM MEMBER order by mrdate;

-- ȸ�� �� ���ϱ�
SELECT COUNT(*) FROM MEMBER;

-- ȸ�� ���� : ���̵� �ߺ� �� �α��� üũ ���
SELECT * FROM MEMBER WHERE MID = 'leo';

--ȸ�� ����
INSERT INTO MEMBER (MID, MPW, MNAME, MEMAIL, MPHOTO, MTEL, MGENDER, MADDR, MTEXT, MBIRTH)
VALUES ('leo', '1234', '�̵���', 'a@a.a', 'member1.jpg','010-9999-9999', '����', '����� ���α�', '�ڱ�Ұ�', '1982-09-16');

INSERT INTO MEMBER (MID, MPW, MNAME, MEMAIL, MPHOTO, MTEL, MGENDER, MADDR, MTEXT, MBIRTH)
VALUES ('leoday', '1234', '�̷���', 'a@a.a', 'member2.jpg','010-9999-8888', '����', '����� ������', '�ڱ�Ұ�2', '1982-09-17');

COMMIT;
rollback;
-- ȸ�� ���� 
UPDATE MEMBER SET 
        mPW = '1212',
        mName = '�̵���',
        mPhoto = 'nothing.jpg',
        mTel = '010-5678-1234',
        mGender = '����',
        mAddr = '����� ���ϱ�',
        mText = '�ڱ�Ұ� ����',
        mBirth = '1982-09-20'
WHERE MID = 'leo';

-- ȸ�� Ż�� (����)
DELETE FROM MEMBER WHERE MID = 'leo'and MPW = '1212'; 

------------------------------------------------
-- ���� �Խ��� ���
------------------------------------------------
-- top-n ����¡ ���
SELECT * FROM  
(SELECT ROWNUM RN, A.* FROM (SELECT B.*, M.MNAME, MPHOTO FROM BOARD b, MEMBER M 
    WHERE M.MID = B.MID ORDER BY BREF DESC, BSTEP) A)  
WHERE RN BETWEEN 1 AND 100;

--�Խñ� �󼼺���
SELECT B.*, M.MNAME , M.MPHOTO  FROM BOARD B, MEMBER M WHERE B.MID = M.MID AND  BNUM = 143;

-- �Խñ� �� ���ϱ�
SELECT COUNT(*) FROM BOARD;

-- ��ȸ�� ����
UPDATE BOARD SET BCNT = BCNT + 1 WHERE Bnum = 1; 

-- ���ƿ� ��� 1 ��
UPDATE BOARD SET BLIKE = BLIKE + 1 WHERE BNUM = 149;

--�亯 ���� ��� �۾��� �� �ؾ��ϴ� �� (A STEP)
UPDATE BOARD SET BSTEP = BSTEP + 1 
WHERE BREF = 1 AND BSTEP > 0; 

-- �Խ��� �۾��� (���� ����)
-- ���� ���� �ش� �ۼ����� point �� ����
UPDATE MEMBER SET MPOINT = MPOINT + 10 WHERE MID = 'leo';

INSERT INTO BOARD (bNum, mId, bTitle, bContent, bCnt, bFile1, bRef, bStep, bLevel, bLike, bIp, bRdate)
VALUES (BOARD_SEQ.NEXTVAL, 'leo', '����', '����', 0, '', BOARD_SEQ.CURRVAL, 0, 0, 0, '127.0.0.1', SYSDATE);

INSERT INTO BOARD (BNUM, MID, BTITLE, BCONTENT, BCNT, BFILE1, BREF, BSTEP, BLEVEL, BLIKE, BIP, BRDATE) 
VALUES (BOARD_SEQ.NEXTVAL, 'leo', '����', '����', 0, '', BOARD_SEQ.CURRVAL, 0, 0, 0, '127.0.0.1', SYSDATE);

-- �Խ��� �ۼ���
UPDATE BOARD SET 
            bTitle = '��������', 
            bContent = '��������', 
            bFile1 = 'FILE.JPG', 
            bIp = '127.0.0.2', 
            bRdate = SYSDATE
WHERE BNUM = 1;

-- �Խñ� ����
DELETE FROM BOARD WHERE BNUM = 1;

commit;
------------------------------------------------
-- �ȷο� ���
------------------------------------------------
SELECT FNUM, F.MID, FID, MNAME, MPHOTO FROM FOLLOW F, MEMBER M WHERE F.FID = M.MID;
-- �ȷο� ��������
SELECT FNUM, F.MID, FID, MNAME, MPHOTO FROM FOLLOW F, MEMBER M WHERE F.MID = M.MID AND FID = 'leo';
SELECT count(*) FROM FOLLOW WHERE FID = 'leo';

-- �ȷο� ��������
SELECT FNUM, F.MID, FID, MNAME, MPHOTO FROM FOLLOW F, MEMBER M WHERE F.FID = M.MID AND F.MID ='leo';
SELECT count(*) FROM FOLLOW WHERE MID = 'leo';

-- �ȷο� �ϱ�
INSERT INTO FOLLOW (FNUM, MID, FID) VALUES (FOLLOW_SEQ.NEXTVAL, 'leo', 'days');

-- ���ȷο� �ϱ�
DELETE FROM FOLLOW WHERE FID = 'days';

DELETE FROM FOLLOW WHERE FNUM = 62;
DELETE FROM FOLLOW;
COMMIT;
------------------------------------------------
-- ������ ���̺�
------------------------------------------------
-- ������ ����
SELECT * FROM ADMIN;

-- �ߺ� ������ Ȯ�� 
SELECT * FROM ADMIN WHERE AID = 'admin';

-- ������ ���
INSERT INTO ADMIN (ANUM, AID, APW, ANAME) 
VALUES (ADMIN_SEQ.NEXTVAL, 'admin', 'highwind26', '������');
COMMIT;

-- ������ ���� ����
UPDATE ADMIN SET 
            APW = 'leos26',
            ANAME = '�ΰ�����'
WHERE AID = 1;

-- ������ ���� 
DELETE FROM ADMIN WHERE AID = 'admin' AND APW = 'highwind26';

------------------------------------------------
-- ��������
------------------------------------------------
SELECT * FROM
(SELECT ROWNUM RN, A.* FROM 
(SELECT * FROM NOTICE ORDER BY NRDATE DESC) A)
WHERE RN BETWEEN 1 AND 10;

-- ��������
INSERT INTO NOTICE (NNUM, NTITLE, NCONTENT, NAUTHOR) 
VALUES (NOTICE_SEQ.NEXTVAL, '��������', '��������', '������');
COMMIT;
-- ���� ����
UPDATE NOTICE SET 
            NTITLE = '���� ����',
            NCONTENT = '���� ����',
            NAUTHOR = '������'            
WHERE NNUM = 2;
-- ���� ����
DELETE FROM NOTICE WHERE NNUM = 2;

