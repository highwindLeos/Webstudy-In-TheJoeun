DROP TABLE MVC_MEMBER;

CREATE TABLE MVC_MEMBER (
    MID VARCHAR2(30) PRIMARY KEY,
    MPW VARCHAR2(30) NOT NULL,
    MNAME VARCHAR2(30) NOT NULL,
    MEMAIL VARCHAR2(30) NOT NULL,
    MPHOTO VARCHAR2(30) DEFAULT 'nothing.jpg',
    MBIRTH DATE NOT NULL,
    MADDRESS VARCHAR2(300),
    MRDATE DATE DEFAULT SYSDATE
);

--멤버 리스트 보기
SELECT * FROM
    (SELECT ROWNUM RN, A.* FROM (SELECT * FROM MVC_MEMBER ORDER BY MRDATE) A)
        WHERE RN BETWEEN 1 AND 10;

-- 글의 행수 구하기
SELECT COUNT(*) FROM MVC_MEMBER;

-- 가입 멤버 비교 : 가입멤버 보기()
SELECT * FROM MVC_MEMBER WHERE MID = 'leos';

-- 가입 처리 
INSERT INTO MVC_MEMBER (MID, MPW, MNAME, MEMAIL, MPHOTO, MBIRTH, MADDRESS, MRDATE) 
    VALUES ('leo','111','이데이','leo@gmail.com','photo1.jpg','1982-09-16','서울시 도봉구', SYSDATE);

COMMIT;

-- 가입멤버 수정
UPDATE MVC_MEMBER SET 
            MPW = '222', 
            MNAME = '이유리', 
            MEMAIL = 'yu@gmail.com', 
            MPHOTO = 'photo2.jpg', 
            MBIRTH = '1990-09-12', 
            MADDRESS = '서울시 종로구'
WHERE MID = 'leos';

--가입 멤버 탈퇴 
DELETE FROM MVC_MEMBER WHERE MID = 'leo'AND MPW = '111';

