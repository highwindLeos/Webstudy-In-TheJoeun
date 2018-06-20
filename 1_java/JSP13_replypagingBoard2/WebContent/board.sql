DROP TABLE BOARD;

CREATE TABLE BOARD (
    NUM NUMBER PRIMARY KEY,         -- 글번호
    WRITER VARCHAR2(30) NOT NULL,   -- 글쓴이
    SUBJECT VARCHAR2(50) NOT NULL,  -- 제목
    CONTENT VARCHAR2(300) NOT NULL, -- 글내용
--    CONTENT VARCHAR2(100) NOT NULL, -- 글내용
    EMAIL VARCHAR2(30),             -- 이메일
    READCOUNT NUMBER NOT NULL,     -- 조회수
    PW VARCHAR2(30) NOT NULL,       -- 글 삭제시 쓸 비번
    REF NUMBER NOT NULL,            -- 답변글끼리 ref 같에 한 그룹 처리
    RE_STEP NUMBER NOT NULL,        -- 한 그룹내 출력 순서
    RE_LEVEL NUMBER NOT NULL,       -- 들여 쓰기 정도
    IP VARCHAR2(20) NOT NULL,       -- 글쓴이 컴퓨터 아이피
    RDATE DATE NOT NULL           -- 글쓴 시간
);

-- 글 목록 보기 (LIST.JSP)
SELECT COUNT(*) FROM BOARD; -- 저장된 글 갯수
SELECT * FROM BOARD ORDER BY NUM DESC;        -- 글 목록들 출력
SELECT * FROM BOARD ORDER BY REF DESC;        -- 글 쓴 그룹 
-- 글쓰기
SELECT NVL(MAX(NUM), 0) + 1 NUMCOUNT FROM BOARD;
INSERT INTO BOARD VALUES (1, '이데이', '글제목1', '글내용', 'lee@gmail.com', 0, 'password', 1, 0, 0, '192.168.0.123', SYSDATE);
INSERT INTO BOARD VALUES ((SELECT NVL(MAX(NUM), 0) + 1 NUMCOUNT FROM BOARD), '이나라', '글2', '글내용2', 'na@gmail.com', 0, 'password2', (SELECT NVL(MAX(NUM), 0) + 1 NUMCOUNT FROM BOARD), 0, 0, '192.168.0.124', SYSDATE);

COMMIT;
-- 해당 글 내용 보기
SELECT * FROM BOARD WHERE ref = 222;

-- 글 수정하기
UPDATE BOARD SET WRITER = '손오공', SUBJECT = '새제목', CONTENT = '새본문', EMAIL = 'NEW@GMAIL.COM', PW = '111', IP = '127.0.0.1' WHERE NUM = 1; 

-- 글 삭제하기
DELETE FROM BOARD WHERE NUM = 2 AND PW = 'password'; -- 비번 틀리면 삭제 안됨.
DELETE FROM BOARD WHERE NUM = 2 AND PW = 'password2';

-- 전 데이터 삭제
DELETE FROM BOARD;
COMMIT;

-- SQL : TOP-N 구문 페이징처리에 쓰이는 쿼리
SELECT * FROM BOARD ORDER BY REF DESC; -- 1 단계

SELECT ROWNUM RN, A.* FROM (SELECT * FROM BOARD ORDER BY REF DESC) A; -- 2단계

SELECT ROWNUM RN, A.* FROM (SELECT * FROM BOARD ORDER BY REF DESC) A
    WHERE ROWNUM BETWEEN 11 AND 20; -- 2단계 는 안된다.
    
SELECT * FROM (SELECT ROWNUM RN, A.* FROM (SELECT * FROM BOARD ORDER BY REF DESC, RE_STEP ASC) A)
    WHERE RN BETWEEN 11 AND 20; -- 3단계 탑앤구문 : 2단계를 인라인 뷰로 가져온다.
    
-- 답변글을 입력하기전 re_step 처리
SELECT * FROM BOARD WHERE NUM = 1;
UPDATE BOARD SET RE_STEP = RE_STEP + 1
    WHERE REF = 1 AND RE_STEP > 0;
