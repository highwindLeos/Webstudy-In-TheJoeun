DROP TABLE FRIEND;
DROP SEQUENCE FRIEND_SEQ;

CREATE SEQUENCE FRIEND_SEQ;

CREATE TABLE FRIEND (
    NO NUMBER(5) PRIMARY KEY,
    FNAME VARCHAR2(20) NOT NULL,
    TEL VARCHAR2(20) NOT NULL
);

COMMIT;

INSERT INTO FRIEND VALUES(FRIEND_SEQ.NEXTVAL, '이데이', '010-9999-9999');
INSERT INTO FRIEND VALUES(FRIEND_SEQ.NEXTVAL, '이만화', '010-8888-8888');

--내용보기 
SELECT * FROM FRIEND;

SELECT * FROM FRIEND WHERE FNAME LIKE '%만%' AND TEL LIKE '%8888%';

DELETE FROM FRIEND WHERE NO = 32;
