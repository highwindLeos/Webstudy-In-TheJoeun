---------------------------------------------------------------------------------------------
-- 학사 관리 테이블 예제
---------------------------------------------------------------------------------------------

DROP TABLE STUDENT;
DROP TABLE MAJOR;

CREATE TABLE MAJOR(
    MAJOR_CODE NUMBER(3),
    MAJOR_NAME VARCHAR2(100) NOT NULL,
    OFFICE_LOC VARCHAR2(50),
    PRIMARY KEY(MAJOR_CODE)
);

CREATE TABLE STUDENT(
    HAKBUN VARCHAR2(15),
    NAME VARCHAR2(15),
    SCORE NUMBER(3),
    MAJOR_CODE NUMBER(3),
    PRIMARY KEY(HAKBUN),
    FOREIGN KEY(MAJOR_CODE) REFERENCES MAJOR(MAJOR_CODE)
);

SELECT * FROM MAJOR;
SELECT * FROM STUDENT;

-- MAJOR TABLE INSERT
INSERT INTO MAJOR VALUES (1, '경영정보', '3층 인문실');
INSERT INTO MAJOR VALUES (2, '소프트웨어 공학', '3층 인문실');
INSERT INTO MAJOR VALUES (3, '디자인', '4층 과학실');
INSERT INTO MAJOR VALUES (4, '경제', '4층 과학실');

-- HAKBUN TABLE INSERT
INSERT INTO HAKBUN VALUES ('A01', '김길동', 100, 1);
INSERT INTO HAKBUN VALUES ('A02', '문길동', 90, 2);
INSERT INTO HAKBUN VALUES ('A03', '홍길동', 80, 1);

COMMIT;

-----------------------------------------------------------------------------------------
-- 1 PAGE
-----------------------------------------------------------------------------------------
-- 1.
CREATE TABLE MY_DATA(
    ID NUMBER(4) NOT NULL,
    NAME VARCHAR2(10),
    USERID VARCHAR2(30),
    SALARY NUMBER(10,2)
);

--2.
INSERT INTO MY_DATA (ID, NAME, USERID, SALARY) VALUES (1, 'SCOTT', 'SSCOTT', 10000);
INSERT INTO MY_DATA (ID, NAME, USERID, SALARY) VALUES (2, 'FORD', 'FFORD', 12000);
INSERT INTO MY_DATA (ID, NAME, USERID, SALARY) VALUES (3, 'PATAL', 'PPATEL', 33000);
INSERT INTO MY_DATA (ID, NAME, USERID, SALARY) VALUES (4, 'REPORT', 'RREPORT', 23500);
INSERT INTO MY_DATA (ID, NAME, USERID, SALARY) VALUES (5, 'GOOD', 'GGOOD', 44450);

--3.
SELECT * FROM MY_DATA;

--4 
COMMIT;

-- 6.
UPDATE MY_DATA SET SALARY = 65000 WHERE ID = 3; 

-- 7.
DELETE MY_DATA WHERE NAME = 'FORD';

-- 8.
UPDATE MY_DATA SET SALARY = 15000 WHERE SALARY <= 15000;

-- 9.
DROP TABLE MY_DATA;

-------------------------------------------
-- 쇼핑몰 테이블의 설계.

-- 상품 (분류, 코드 이름 가격)
-- 고객 (이름, 생일, 등등)
-- 고객 등급 테이블 (고객등급, 등급이름, 할인율)

-- 주문 테이블 ()
-- 주문 상세 테이블 
-- 장바구니 (고객아이디, CODE, 갯수, 총가격)
-- 후기 테이블

-----------------------------------------------------------------------------------------
-- 2 PAGE
-----------------------------------------------------------------------------------------

-- 먼저 포린키로 참조될 테이블을 먼저 만든다.
DROP TABLE CUSTOMER;
CREATE TABLE CUSTOMER (
    CNO VARCHAR2(5),
    CNAME VARCHAR2(20),
    ADDRESS VARCHAR2(100),
    EMAIL VARCHAR2(50),
    PHONE VARCHAR2(20),
    PRIMARY KEY(CNO)
);

DROP TABLE PRODUCT;
CREATE TABLE PRODUCT (
    PNO VARCHAR2(5),
    PNAME VARCHAR2(20),
    COST NUMBER(8),
    STOCK NUMBER(6),
    PRIMARY KEY(PNO)
);

-- 부모 테이블을 참조해서 FOREIGN KEY 를 참조하는 테이블을 만든다.
DROP TABLE ORDERS;
CREATE TABLE C (
    ORDERNO VARCHAR2(10),
    ORDERDATE DATE,
    ADDRESS VARCHAR2(100),
    PHONE VARCHAR2(20),
    CNO VARCHAR2(5),
    PRIMARY KEY(ORDERNO),
    FOREIGN KEY(CNO) REFERENCES CUSTOMER(CNO)
);

DROP TABLE ORDERSTAIL;
CREATE TABLE ORDERSTAIL (
    ORDERNO VARCHAR2(10),
    PNO VARCHAR2(5),
    QTY NUMBER(6),
    COST NUMBER(8),
    FOREIGN KEY(PNO) REFERENCES PRODUCT(PNO),
    FOREIGN KEY(ORDERNO) REFERENCES ORDERS(ORDERNO)
);

SELECT * FROM CUSTOMER;
SELECT * FROM PRODUCT;
SELECT * FROM ORDERS;
SELECT * FROM ORDERSTAIL;

-----------------------------------------------------------------------------------------
-- 3 PAGE : market DB 설계
-----------------------------------------------------------------------------------------
DROP TABLE ORDERTAIL;
DROP TABLE ORDERS;
DROP TABLE CART;
DROP TABLE COMENTS;
DROP TABLE GOODS;
DROP TABLE CUSTOMERS;

CREATE TABLE CUSTOMERS (
    cNO VARCHAR2(6) PRIMARY KEY,
    cNAME VARCHAR2(15) NOT NULL,
    cADDRESS VARCHAR2(100),
    cPHONE VARCHAR2(80),
    cMAIL VARCHAR2(50)
);

CREATE TABLE GOODS (
    gCODE VARCHAR2(10) PRIMARY KEY,
    gNAME VARCHAR2(15) NOT NULL,
    gPRICE NUMBER(10),
    gSTOCK NUMBER(3)
);

CREATE TABLE COMENTS (
    cID NUMBER(10) PRIMARY KEY,
    cNO VARCHAR2(6) REFERENCES CUSTOMERS(cNO),
    gCODE VARCHAR2(10) REFERENCES GOODS(gCODE),
    COMENT VARCHAR(255),
    cDATE DATE DEFAULT SYSDATE,
    cIP VARCHAR2(30)
);

CREATE TABLE CART (
    cID NUMBER(10) PRIMARY KEY,
    cNO VARCHAR2(6) REFERENCES CUSTOMERS(cNO),
    gCODE VARCHAR2(10) REFERENCES GOODS(gCODE),
    bQTY VARCHAR(3) DEFAULT 1,
    COST NUMBER(10)
);

CREATE TABLE ORDERS(
    oNO VARCHAR2(10) PRIMARY KEY,
    oDATE DATE DEFAULT SYSDATE,
    oNAME VARCHAR2(50),
    oADDRESS VARCHAR2(200),
    oTEL VARCHAR2(20),
    cNO VARCHAR2(6) REFERENCES CUSTOMERS(cNO)
);

CREATE TABLE ORDERTAIL(
    odNO NUMBER(10) PRIMARY KEY,
    oNO VARCHAR2(10) REFERENCES ORDERS(oNO),
    gCODE VARCHAR2(50) REFERENCES GOODS(gCODE),
    QYT NUMBER(6),
    COST NUMBER(10)
);

SELECT * FROM CUSTOMERS;
SELECT * FROM GOODS;
SELECT * FROM COMENTS;
SELECT * FROM CART;
SELECT * FROM ORDERS;
SELECT * FROM ORDERTAIL;

-- 고객 데이터 입력.
INSERT INTO CUSTOMERS VALUES ('가', '홍길동', '경기도 과천', '111-1111-1111', 'HIGH@GMAIL.COM');
INSERT INTO CUSTOMERS VALUES ('나', '전투왕', '서울시 연희동', '222-4444-4444', 'LOW@GMAIL.COM');

-- 주문서를 보고 데이터 입력해 보기.
INSERT INTO GOODS VALUES ('A1', '맥주', 2000, 10);
INSERT INTO GOODS VALUES ('B1', '땅콩', 3000, 10);
INSERT INTO GOODS VALUES ('A2', '소주', 1500, 10);
INSERT INTO GOODS VALUES ('B2', '오징어', 5000, 10);
INSERT INTO GOODS VALUES ('C1', '기저귀', 7000, 10);

-- 주문  데이터 입력.
INSERT INTO ORDERS VALUES ('12051701', TO_DATE('20120517','YYYYMMDD'), '홍길동', '경기도 과천', '111-1111-1111', '가');
INSERT INTO ORDERS VALUES ('12051702', TO_DATE('20120517','YYYYMMDD'), '전투왕', '서울시 연희동', '222-4444-4444', '나');
INSERT INTO ORDERS VALUES ('12052901', TO_DATE('20120529','YYYYMMDD'), '홍길동', '경기도 과천', '111-1111-1111', '가');

-- 주문 데이터 입력. 2
INSERT INTO ORDERTAIL VALUES (1, '12051701', 'A1', 3, 6000); 
INSERT INTO ORDERTAIL VALUES (2, '12051701', 'B1', 1, 3000);
INSERT INTO ORDERTAIL VALUES (3, '12051701', 'A2', 2, 3000);
INSERT INTO ORDERTAIL VALUES (4, '12051701', 'B2', 1, 5000);
INSERT INTO ORDERTAIL VALUES (5, '12051702', 'A2', 2, 3000);
INSERT INTO ORDERTAIL VALUES (6, '12051702', 'B2', 1, 5000);
INSERT INTO ORDERTAIL VALUES (7, '12051702', 'C1', 1, 7000);
INSERT INTO ORDERTAIL VALUES (8, '12052901', 'A1', 3, 6000);
INSERT INTO ORDERTAIL VALUES (9, '12052901', 'B1', 1, 3000);
INSERT INTO ORDERTAIL VALUES(10, '12052901', 'C1', 1, 7000);

COMMIT;

-- 홍길동 (고객 번호 : 가) 이 주문한 내역을 출력.
SELECT O.ODATE, D.GCODE, G.GNAME, D.QYT, D.COST
FROM ORDERS O, ORDERTAIL D, GOODS G
WHERE O.ONO = D.ONO AND D.GCODE = G.GCODE 
AND O.CNO = '가';

-- 주문한 날짜별로 주문 총 금액 출력.
SELECT ODATE, SUM(COST)
FROM ORDERS O, ORDERTAIL T
WHERE O.ONO = T.ONO
GROUP BY ODATE;