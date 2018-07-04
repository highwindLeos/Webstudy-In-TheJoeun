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

--��� ����Ʈ ����
SELECT * FROM
    (SELECT ROWNUM RN, A.* FROM (SELECT * FROM MVC_MEMBER ORDER BY MRDATE) A)
        WHERE RN BETWEEN 1 AND 10;

-- ���� ��� ���ϱ�
SELECT COUNT(*) FROM MVC_MEMBER;

-- ���� ��� �� : ���Ը�� ����()
SELECT * FROM MVC_MEMBER WHERE MID = 'leos';

-- ���� ó�� 
INSERT INTO MVC_MEMBER (MID, MPW, MNAME, MEMAIL, MPHOTO, MBIRTH, MADDRESS, MRDATE) 
    VALUES ('leo','111','�̵���','leo@gmail.com','photo1.jpg','1982-09-16','����� ������', SYSDATE);

COMMIT;

-- ���Ը�� ����
UPDATE MVC_MEMBER SET 
            MPW = '222', 
            MNAME = '������', 
            MEMAIL = 'yu@gmail.com', 
            MPHOTO = 'photo2.jpg', 
            MBIRTH = '1990-09-12', 
            MADDRESS = '����� ���α�'
WHERE MID = 'leos';

--���� ��� Ż�� 
DELETE FROM MVC_MEMBER WHERE MID = 'leo'AND MPW = '111';

