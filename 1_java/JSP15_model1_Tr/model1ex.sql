-- 테이블 생성하기
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
    bid NUMBER(5) PRIMARY KEY,                  -- 책번호
    btitle VARCHAR2(100) NOT NULL,              -- 책제목
    bprice NUMBER(7) NOT NULL,                  -- 책가격
    bimage1 VARCHAR2(100) DEFAULT 'nothing.jpg',-- 책이미지1
    bimage2 VARCHAR2(100) DEFAULT 'nothing.jpg',-- 책이미지2
    bcontent VARCHAR2(1000),                    -- 책소개내용
    -- 저자,출판사,출판년(일),발행년(일), 판수생략
    bdiscount NUMBER(3));                  -- 할인율
    
DROP SEQUENCE BOOK_SEQ;
CREATE SEQUENCE BOOK_SEQ;

---------------------------------------------CUSTOMER

-- CustomerDao의 confirmId와 회원가입
SELECT * FROM CUSTOMER WHERE CID='aaa';

INSERT INTO CUSTOMER VALUES
    ('aaa','111','홍','9999-9999','h@h','m','서울종로');
    
commit;

-- CustomerDao의 로그인
SELECT * FROM CUSTOMER WHERE CID='aaa';
-- CustomerDao의 회원정보 수정
UPDATE CUSTOMER SET CPW='111', CNAME='박',
    CTEL='8888-8888', CEMAIL='A@A', CGENDER='f',
    CADDR='서울시' WHERE CID='aaa';
-- 메인화면에서 쓸 회원정보 리스트(페이징 안되는거)
SELECT * FROM CUSTOMER ORDER BY CID;
-- 메인화면에서 쓸 회원정보 리스트(페이징 되는 거 만들어보자)
SELECT ROWNUM RN, A.* FROM
    (SELECT * FROM CUSTOMER ORDER BY CID) A;
SELECT * FROM 
    (SELECT ROWNUM RN, A.* FROM
        (SELECT * FROM CUSTOMER ORDER BY CID) A)
    WHERE RN BETWEEN 2 AND 3;
SELECT COUNT(*) FROM CUSTOMER;

---------------------------------------------FILEBOARD

-- FILEBoardDao의 글갯수 리턴
SELECT COUNT(*) TOTCNT FROM FILEBOARD;
-- FILEBoardDao의 글 입력
INSERT INTO FILEBOARD VALUES (FILEBOARD_SEQ.NEXTVAL, 'aaa','제목','본문\n입니다',
        NULL,0,'11',fileboard_seq.CURRVAL, 0,0,'127.0.0.1',SYSDATE);
rollback;
-- 답변글 추가 전 해야할 ⓐ STEP   
UPDATE FILEBOARD SET FRE_STEP = FRE_STEP+1 WHERE FREF=1 AND FRE_STEP>0;
-- FILEBoardDao의 글목록
SELECT F.*, C.CNAME, C.CEMAIL FROM FILEBOARD F, CUSTOMER C
    WHERE F.CID=C.CID ORDER BY FNUM DESC;
SELECT ROWNUM RN, A.* FROM 
    (SELECT F.*, C.CNAME, C.CEMAIL FROM FILEBOARD F, CUSTOMER C
    WHERE F.CID=C.CID ORDER BY FNUM DESC) A;
SELECT *
    FROM (SELECT ROWNUM RN, A.* FROM 
    (SELECT F.*, C.CNAME, C.CEMAIL FROM FILEBOARD F, CUSTOMER C
    WHERE F.CID=C.CID ORDER BY fref DESC, frestep) A)
    WHERE RN BETWEEN 1 AND 100; -- 페이징처리에서 쓸 TOP-N구문
    
truncate table fileboard;
SELECT COUNT(*) TOTCNT FROM FILEBOARD;
select * from fileboard where fnum>=390;

-- FILEBoardDao의 글 상세보기
UPDATE FILEBOARD SET FREADCOUNT = FREADCOUNT + 1 WHERE FNUM=1;
SELECT F.*, C.CNAME, C.CEMAIL FROM FILEBOARD F, CUSTOMER C
    WHERE F.CID=C.CID AND F.FNUM=1;
    
commit;
-- 글 수정
UPDATE FILEBOARD SET 
    FSUBJECT = '제',
    FFILENAME = NULL,
    FCONTENT = '본',
    FPW = '11',
    FIP = '127.0.0.1'
    WHERE FNUM = 1;
DELETE FROM FILEBOARD WHERE FNUM=1 AND FPW='11';
ROLLBACK;

---------------------------------------------BOOK TABLE

-- 책 등록
INSERT INTO BOOK VALUES (BOOK_SEQ.NEXTVAL, 'JSP',20000,'nothing.jpg','nothing.jpg',
        'jsp 2.3 웹프로그래밍기초부터 중급까지',0); -- DAO 사용
INSERT INTO BOOK (BID, BTITLE, BPRICE, BCONTENT ,BDISCOUNT)
    VALUES (BOOK_SEQ.NEXTVAL, 'sPRING',10000, '스프링4.0책',10);
INSERT INTO BOOK (BID, BTITLE, BPRICE, BCONTENT, BIMAGE1, BDISCOUNT)
    VALUES (BOOK_SEQ.NEXTVAL, 'jQuery',10000, 'jQuery','nothing.jpg',10);
INSERT INTO BOOK (BID, BTITLE, BPRICE, BCONTENT, BIMAGE2, BDISCOUNT)
    VALUES (BOOK_SEQ.NEXTVAL, 'android',10000,'android책','nothing.jpg', 10);
commit;
-- 책 목록 보기
SELECT * FROM BOOK ORDER BY BID DESC;
SELECT ROWNUM RN, A.* FROM (SELECT * FROM BOOK ORDER BY BID DESC) A;

SELECT * FROM (SELECT ROWNUM RN, A.* FROM 
            (SELECT * FROM BOOK ORDER BY bID DESC) A)
    WHERE RN BETWEEN 3 AND 4;  -- 페이징처리에 쓸 TOP-N구문
    
-- 특정책의 상세보기
SELECT * FROM BOOK WHERE BID=5;
commit;
-- 등록된 책 갯수
SELECT COUNT(*) FROM BOOK;

delete from book where bid=5;