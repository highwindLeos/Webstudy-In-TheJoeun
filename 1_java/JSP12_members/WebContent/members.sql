DROP TABLE MEMBERS;

CREATE TABLE MEMBERS (
    ID VARCHAR2(30) PRIMARY KEY, -- ID
    PW VARCHAR(30) NOT NULL,     -- 패스워드
    NAME VARCHAR2(30) NOT NULL,  -- 이름
    EMAIL VARCHAR2(30),          -- 이메일
    BIRTH DATE NOT NULL,         -- 생년월일
    RDATE DATE NOT NULL,         -- 가입한 날짜와 시간
    ADDRESS VARCHAR2(50)         -- 주소
);

SELECT * FROM MEMBERS;

-- 회원 가입 시 ID 유무 에 따라서 판단되는 로직이 필요
SELECT * MEMBERS WHERE ID = 'aaa';

-- 회원가입시 INSERT.
INSERT INTO MEMBERS VALUES ('aaa', '111', '이데이', 'lee@gmail.com', '1990-01-01', SYSDATE, '서울 종로');
INSERT INTO MEMBERS VALUES ('bbb', '222', '손오공', 'son@gmail.com', '1990-02-02', SYSDATE, '서울 강남');

-- 로그인 시 ID 를 검색 한후 PW 확인.
SELECT *  FROM MEMBERS WHERE ID = 'aaa';

-- 회원정보 수정 할 때 ID로 DTO 반환. JSP 화면으로 출력.
SELECT *  FROM MEMBERS WHERE ID = 'aaa';

-- 회원정보 수정 할 때, UPDATE
UPDATE MEMBERS SET PW = '111', NAME='이만화', EMAIL= 'days@gmail.com', BIRTH = '1990-01-02', ADDRESS = '서울 도봉' 
WHERE ID = 'aaa';

DELETE FROM MEMBERS WHERE ID = 'aaa';

COMMIT;