--1~4 다음과 같은 구조의 테이블을 생성하기 위한 테이블 생성하는 SQL문을 작성.
--  (단, 테이블이 있을시 테이블을 삭제하고 생성하시오) 
--  (조건1. 시퀀스를 생성한 뒤, 이를 이용하여 cno의 번호를 자동 생성한다.)
-- (조건2. customer테이블의 levelno는 cus_level테이블의 levelno 와 외래키 연결)

--1 데이터 입력 SQL문을 순서대로 작성하시오.
--[ customer 테이블 ] - cno가 주키, phone은 다른사람과 다르게 입력되도록 제한함
--		      joindate는 입력하지 않을시 현재날짜로 입력

--  cno    cname   joindate    phone         point  levelno
--   1   홍길동   17/10/17  010-9999-9999     300     1
--   2   이철수   16/09/06  010-9999-9888    NULL     2
--   3   홍길순   16/09/07  010-9999-7777      50     3

--[ cus_level 테이블 ] - levelno가 주키, levelname은 NOT NULL 조건.
--       levelno     levelname
--   	1            VVIP
--  	2             VIP           
--   	3            NORMAL
--   	4            BLACK

-- 제약조건 ① NOT NULL
-- 제약조건 ② UNIQUE
-- 제약조건 ③ PRIMARY KEY
-- 제약조건 ④ REFERENCES 테이블이름(컬럼이름)
--          ⑤ DEFAULT 디폴트값

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
VALUES (SEQ_CUSTOMER.NEXTVAL, '홍길동', TO_DATE('171017', 'YYMMDD'), '010-9999-9999', 300, 1);

INSERT INTO CUSTOMER_WORK (CNO, CNAME, JOINDATE, PHONE, LEVELNO) 
VALUES (SEQ_CUSTOMER.NEXTVAL, '이철수', TO_DATE('160906', 'YYMMDD'), '010-9999-9888', 2);

INSERT INTO CUSTOMER_WORK (CNO, CNAME, JOINDATE, PHONE, POINT, LEVELNO) 
VALUES (SEQ_CUSTOMER.NEXTVAL, '홍길순', TO_DATE('160907', 'YYMMDD'), '010-9999-7777', 300, 3);

SELECT * FROM CUS_LEVEL;
SELECT * FROM CUSTOMER_WORK;

COMMIT;

--2. 위와 같은 두개의 테이블을 이용하여 아래와 같이 출력하는 SQL문도 작성하시오
--  cno    cname   joindate    phone         point  levelname
--   1   홍길동   12/12/17  010-9999-9999     300     VVIP
--   2   이철수   16/09/06  010-9999-9888    NULL     VIP
--   3   홍길순   16/09/07  010-9999-7777      50     NORMAL

SELECT CNO, CNAME, JOINDATE, PHONE, POINT, L.LEVELNAME
FROM CUSTOMER_WORK W, CUS_LEVEL L
WHERE W.LEVELNO = L.LEVELNO;

