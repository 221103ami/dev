--�̴�������Ʈ

-- MEMBER
DROP TABLE MEMBER;
CREATE TABLE MEMBER(
    NO              NUMBER          PRIMARY KEY 
    , ID            VARCHAR2(100)   NOT NULL UNIQUE
    , PWD           VARCHAR2(100)   NOT NULL
    , NICK          VARCHAR2(100)   NOT NULL
    , ENROLL_DATE   TIMESTAMP       DEFAULT SYSDATE
    , QUIT_YN       CHAR(1)         DEFAULT 'N' CHECK( QUIT_YN IN('Y','N') )
);


DROP SEQUENCE SEQ_MEMBER_NO;
CREATE SEQUENCE SEQ_MEMBER_NO NOCACHE;

--���������߰��ϱ�




--�׽�Ʈ�� (�����Ұ͵�)
SELECT * FROM MEMBER;












