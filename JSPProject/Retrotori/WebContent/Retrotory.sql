-- 생성전 삭제
DROP TABLE COMANT;
DROP TABLE FOLLOW;
DROP TABLE BOARD;

DROP TABLE MEMBER;

DROP TABLE GGRADE;
DROP TABLE GAME;

DROP TABLE ADMIN;
DROP TABLE NOTICE;

-- 시퀀스 생성전 삭제
DROP SEQUENCE MEMBER_SEQ;
DROP SEQUENCE GAME_SEQ;

DROP SEQUENCE FOLLOW_SEQ;
DROP SEQUENCE COMANT_SEQ;
DROP SEQUENCE BOARD_SEQ;
DROP SEQUENCE NOTICE_SEQ;


-- 테이블과 시퀀스 생성
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
-- 테이블 정보 확인
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
-- 게임 등급
---------------------------------------------------------------------------------------
-- 게임 등급 설정
INSERT INTO GGRADE (GGNO, GRNAME, LOWPOINT, HIPOINT) VALUES (1, '브론즈', 0, 9999); -- 브론즈
INSERT INTO GGRADE (GGNO, GRNAME, LOWPOINT, HIPOINT) VALUES (2, '실버', 10000, 19999); -- 실버
INSERT INTO GGRADE (GGNO, GRNAME, LOWPOINT, HIPOINT) VALUES (3, '골드', 20000, 29999); -- 골드
INSERT INTO GGRADE (GGNO, GRNAME, LOWPOINT, HIPOINT) VALUES (4, '플래티넘', 30000, 39999); -- 플래티넘
INSERT INTO GGRADE (GGNO, GRNAME, LOWPOINT, HIPOINT) VALUES (5, '프리미엄', 40000, 49999); -- 프리미엄
INSERT INTO GGRADE (GGNO, GRNAME, LOWPOINT, HIPOINT) VALUES (6, '레전드', 50000, 99999999); -- 레전드

UPDATE GGRADE SET HIPOINT = 99999999 WHERE GGNO = 6;

COMMIT;
---------------------------------------------------------------------------------------
-- 게임 테이블
---------------------------------------------------------------------------------------
-- top-n 페이징 기능 (게임 리스트)
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
-- 최신글 8개 출력
SELECT RN, GID, GNAME, GIMAGE, GDES, GPUB, GRDATE, GGRADE, GVOTECNT, GGNO, GRNAME, LOWPOINT, HIPOINT FROM 
        (SELECT ROWNUM RN, A.* FROM 
        (SELECT GID, GNAME, GIMAGE, GDES, GPUB, GRDATE, GGRADE, GVOTECNT, GA.GGNO, GRNAME, LOWPOINT, HIPOINT 
                FROM GAME GA, GGRADE R 
                WHERE GGRADE BETWEEN R.LOWPOINT AND R.HIPOINT) A) 
WHERE RN BETWEEN 1 AND 8;

-- 게임 수 구하기
SELECT COUNT(*) FROM GAME;

-- 게임 등록하기
INSERT INTO GAME (gId, gName, gImage, gDes, gPub, gRdate, gGrade, gVoteCnt, gGno)
VALUES ('A'||GAME_SEQ.NEXTVAL, '게임이름4', 'gameimage.jpg', '게임 설명4', '제작사4', '1984-07-05', 0, 0, 1);

COMMIT;
-- 게임 정보수정
UPDATE GAME SET 
            gName = '수정제목', 
            gImage = 'modifyimage.jpg', 
            gDes = '수정본문', 
            gPub = '수정 제작사',
            gRdate = '1988-06-05'
WHERE gId = '2';

UPDATE GAME SET GVOTECNT = 2500 WHERE GID = '22';
-- 게임 삭제
DELETE FROM GAME WHERE GID = '22';
commit;
rollback;
-- 게임 투표 하기 
UPDATE GAME SET GGRADE = GGRADE + 10, GVOTECNT = GVOTECNT + 1
WHERE GID = 2;
-- 투표시 게임 등급 조정
SELECT R.GGNO FROM GAME G, GGRADE R
                            WHERE GGRADE BETWEEN R.LOWPOINT AND R.HIPOINT; -- SUBQUERY
                            
UPDATE GAME SET Ggno = (SELECT R.GGNO FROM GAME G, GGRADE R
                        WHERE GGRADE BETWEEN R.LOWPOINT AND R.HIPOINT AND GID LIKE '%'||2)
                        WHERE GID LIKE '%'||2;
                        
-- 게임 검색 : 기본
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
DELETE FROM GAME WHERE GID = 'A돈킹콩 1982년';


-- 게임 검색 : 상세검색
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
-- 게임 코멘트 기능
------------------------------------------------
SELECT * FROM COMANT;
-- 게임의 대한 간단한 코멘트 달기
INSERT INTO COMANT (CNUM, GID, MID, COMANT) 
VALUES (COMANT_SEQ.NEXTVAL, '2', 'leo', '코멘트입니다');

UPDATE MEMBER SET MPOINT = MPOINT + 5 WHERE MID = 'leo';

SELECT * FROM COMANT WHERE GID = 'A42' ORDER BY CNUM DESC;

-- 최신글 리스트
SELECT * FROM
(SELECT ROWNUM RN, A.* FROM (SELECT * FROM COMANT ORDER BY CNUM DESC) A)
WHERE RN BETWEEN 1 AND 5 AND MID = 'leo';

-- 코멘트 삭제
DELETE FROM COMANT WHERE CNUM = '25';

commit;
ROLLBACK;
------------------------------------------------
-- 회원 기능
------------------------------------------------
-- 회원 리스트 :
SELECT * FROM MEMBER order by mrdate;

-- 회원 수 구하기
SELECT COUNT(*) FROM MEMBER;

-- 회원 검증 : 아이디 중복 과 로그인 체크 기능
SELECT * FROM MEMBER WHERE MID = 'leo';

--회원 가입
INSERT INTO MEMBER (MID, MPW, MNAME, MEMAIL, MPHOTO, MTEL, MGENDER, MADDR, MTEXT, MBIRTH)
VALUES ('leo', '1234', '이데이', 'a@a.a', 'member1.jpg','010-9999-9999', '남자', '서울시 종로구', '자기소개', '1982-09-16');

INSERT INTO MEMBER (MID, MPW, MNAME, MEMAIL, MPHOTO, MTEL, MGENDER, MADDR, MTEXT, MBIRTH)
VALUES ('leoday', '1234', '이레오', 'a@a.a', 'member2.jpg','010-9999-8888', '여자', '서울시 도봉구', '자기소개2', '1982-09-17');

COMMIT;
rollback;
-- 회원 수정 
UPDATE MEMBER SET 
        mPW = '1212',
        mName = '이데라',
        mPhoto = 'nothing.jpg',
        mTel = '010-5678-1234',
        mGender = '여자',
        mAddr = '서울시 강북구',
        mText = '자기소개 변경',
        mBirth = '1982-09-20'
WHERE MID = 'leo';

-- 회원 탈퇴 (삭제)
DELETE FROM MEMBER WHERE MID = 'leo'and MPW = '1212'; 

------------------------------------------------
-- 자유 게시판 기능
------------------------------------------------
-- top-n 페이징 기능
SELECT * FROM  
(SELECT ROWNUM RN, A.* FROM (SELECT B.*, M.MNAME, MPHOTO FROM BOARD b, MEMBER M 
    WHERE M.MID = B.MID ORDER BY BREF DESC, BSTEP) A)  
WHERE RN BETWEEN 1 AND 100;

--게시글 상세보기
SELECT B.*, M.MNAME , M.MPHOTO  FROM BOARD B, MEMBER M WHERE B.MID = M.MID AND  BNUM = 143;

-- 게시글 수 구하기
SELECT COUNT(*) FROM BOARD;

-- 조회수 증가
UPDATE BOARD SET BCNT = BCNT + 1 WHERE Bnum = 1; 

-- 좋아요 기능 1 업
UPDATE BOARD SET BLIKE = BLIKE + 1 WHERE BNUM = 149;

--답변 글일 경우 글쓰기 전 해야하는 것 (A STEP)
UPDATE BOARD SET BSTEP = BSTEP + 1 
WHERE BREF = 1 AND BSTEP > 0; 

-- 게시판 글쓰기 (원글 쓰기)
-- 글을 쓰면 해당 작성자의 point 가 증가
UPDATE MEMBER SET MPOINT = MPOINT + 10 WHERE MID = 'leo';

INSERT INTO BOARD (bNum, mId, bTitle, bContent, bCnt, bFile1, bRef, bStep, bLevel, bLike, bIp, bRdate)
VALUES (BOARD_SEQ.NEXTVAL, 'leo', '제목', '내용', 0, '', BOARD_SEQ.CURRVAL, 0, 0, 0, '127.0.0.1', SYSDATE);

INSERT INTO BOARD (BNUM, MID, BTITLE, BCONTENT, BCNT, BFILE1, BREF, BSTEP, BLEVEL, BLIKE, BIP, BRDATE) 
VALUES (BOARD_SEQ.NEXTVAL, 'leo', '제목', '내용', 0, '', BOARD_SEQ.CURRVAL, 0, 0, 0, '127.0.0.1', SYSDATE);

-- 게시판 글수정
UPDATE BOARD SET 
            bTitle = '수정제목', 
            bContent = '수정본문', 
            bFile1 = 'FILE.JPG', 
            bIp = '127.0.0.2', 
            bRdate = SYSDATE
WHERE BNUM = 1;

-- 게시글 삭제
DELETE FROM BOARD WHERE BNUM = 1;

commit;
------------------------------------------------
-- 팔로우 기능
------------------------------------------------
SELECT FNUM, F.MID, FID, MNAME, MPHOTO FROM FOLLOW F, MEMBER M WHERE F.FID = M.MID;
-- 팔로워 가져오기
SELECT FNUM, F.MID, FID, MNAME, MPHOTO FROM FOLLOW F, MEMBER M WHERE F.MID = M.MID AND FID = 'leo';
SELECT count(*) FROM FOLLOW WHERE FID = 'leo';

-- 팔로우 가져오기
SELECT FNUM, F.MID, FID, MNAME, MPHOTO FROM FOLLOW F, MEMBER M WHERE F.FID = M.MID AND F.MID ='leo';
SELECT count(*) FROM FOLLOW WHERE MID = 'leo';

-- 팔로우 하기
INSERT INTO FOLLOW (FNUM, MID, FID) VALUES (FOLLOW_SEQ.NEXTVAL, 'leo', 'days');

-- 언팔로우 하기
DELETE FROM FOLLOW WHERE FID = 'days';

DELETE FROM FOLLOW WHERE FNUM = 62;
DELETE FROM FOLLOW;
COMMIT;
------------------------------------------------
-- 관리자 테이블
------------------------------------------------
-- 관리자 보기
SELECT * FROM ADMIN;

-- 중복 관리자 확인 
SELECT * FROM ADMIN WHERE AID = 'admin';

-- 관리자 등록
INSERT INTO ADMIN (ANUM, AID, APW, ANAME) 
VALUES (ADMIN_SEQ.NEXTVAL, 'admin', 'highwind26', '관리자');
COMMIT;

-- 관리자 정보 수정
UPDATE ADMIN SET 
            APW = 'leos26',
            ANAME = '부관리자'
WHERE AID = 1;

-- 관리자 삭제 
DELETE FROM ADMIN WHERE AID = 'admin' AND APW = 'highwind26';

------------------------------------------------
-- 공지사항
------------------------------------------------
SELECT * FROM
(SELECT ROWNUM RN, A.* FROM 
(SELECT * FROM NOTICE ORDER BY NRDATE DESC) A)
WHERE RN BETWEEN 1 AND 10;

-- 공지쓰기
INSERT INTO NOTICE (NNUM, NTITLE, NCONTENT, NAUTHOR) 
VALUES (NOTICE_SEQ.NEXTVAL, '공지제목', '공지내용', '관리자');
COMMIT;
-- 공지 수정
UPDATE NOTICE SET 
            NTITLE = '수정 제목',
            NCONTENT = '수정 내용',
            NAUTHOR = '관리자'            
WHERE NNUM = 2;
-- 공지 삭제
DELETE FROM NOTICE WHERE NNUM = 2;

