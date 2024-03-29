/*
-- FINAL 域舛 持失
CREATE USER FINAL IDENTIFIED BY 1234;
GRANT CONNECT , RESOURCE TO FINAL;
-- ORA-01950 降持 獣
ALTER USER FINAL DEFAULT TABLESPACE USERS QUOTA UNLIMITED ON USERS;
*/


-- DROP
DROP TABLE MEMBER CASCADE CONSTRAINTS; 
DROP TABLE NOTICE CASCADE CONSTRAINTS;
DROP TABLE BOARD CASCADE CONSTRAINTS;
DROP TABLE CATEGORY CASCADE CONSTRAINTS;
DROP TABLE GALLERY CASCADE CONSTRAINTS;
DROP TABLE ATTACHMENT CASCADE CONSTRAINTS;
DROP TABLE REPLY CASCADE CONSTRAINTS;

DROP SEQUENCE SEQ_MEMBER_NO;
DROP SEQUENCE SEQ_NOTICE_NO;
DROP SEQUENCE SEQ_BOARD_NO;
DROP SEQUENCE SEQ_GALLERY_NO;
DROP SEQUENCE SEQ_ATTACHMENT_NO;
DROP SEQUENCE SEQ_REPLY_NO;


-- MEMBER
CREATE TABLE MEMBER(
    NO              NUMBER        PRIMARY KEY
    , ID            VARCHAR2(100) NOT NULL UNIQUE
    , PWD           VARCHAR2(100) NOT NULL
    , NICK          VARCHAR2(100) UNIQUE
    , PROFILE       VARCHAR2(100)
    , HOBBY         VARCHAR2(100)
    , STATUS        CHAR(1)       DEFAULT 'O' CHECK (STATUS IN ('O', 'X'))
    , ENROLL_DATE   TIMESTAMP     DEFAULT SYSDATE
    , MODIFY_DATE   TIMESTAMP
);
CREATE SEQUENCE SEQ_MEMBER_NO NOCACHE NOCYCLE;


-- NOTICE
CREATE TABLE NOTICE(
    NO              NUMBER          PRIMARY KEY
    , TITLE         VARCHAR2(100)   NOT NULL
    , CONTENT       VARCHAR2(4000)  NOT NULL
    , ENROLL_DATE   TIMESTAMP       DEFAULT SYSDATE
    , MODIFY_DATE   TIMESTAMP       
    , STATUS        CHAR(1)         DEFAULT 'O' CHECK (STATUS IN ('O','X'))
    , HIT           NUMBER          DEFAULT 0
);
CREATE SEQUENCE SEQ_NOTICE_NO NOCYCLE NOCACHE;

-- BOARD
CREATE TABLE BOARD(
    NO              NUMBER          PRIMARY KEY
    , TITLE         VARCHAR2(100)   NOT NULL
    , CONTENT       VARCHAR2(4000)  NOT NULL
    , WRITER_NO     NUMBER          NOT NULL
    , CATEGORY_NO   NUMBER
    , ENROLL_DATE   TIMESTAMP       DEFAULT SYSDATE
    , STATUS        CHAR(1)         DEFAULT 'O' CHECK( STATUS IN ('O' , 'X') )
    , MODIFY_DATE   TIMESTAMP     
    , HIT           NUMBER          DEFAULT 0
);
CREATE SEQUENCE SEQ_BOARD_NO NOCACHE NOCYCLE;


-- ATTACHMENT
CREATE TABLE ATTACHMENT(
    NO              NUMBER          PRIMARY KEY
    , BNO           NUMBER
    , ORIGIN_NAME   VARCHAR2(1000)  NOT NULL
    , CHANGE_NAME   VARCHAR2(1000)  NOT NULL
    , ENROLL_DATE   TIMESTAMP       DEFAULT SYSDATE
    , STATUS        CHAR(1)         DEFAULT 'O' CHECK ( STATUS IN ('O' , 'X') )
);
CREATE SEQUENCE SEQ_ATTACHMENT_NO NOCACHE NOCYCLE;

--REPLY
CREATE TABLE REPLY(
    NO              NUMBER          PRIMARY KEY
    , BNO           NUMBER          NOT NULL
    , CONTENT       VARCHAR2(1000)  NOT NULL
    , WRITER_NO     NUMBER          NOT NULL
    , ENROLL_DATE   TIMESTAMP       DEFAULT SYSDATE
    , STATUS        CHAR(1)         DEFAULT 'O' CHECK ( STATUS IN ('O' , 'X') )
);
CREATE SEQUENCE SEQ_REPLY_NO NOCACHE NOCYCLE;


--GALLERY
CREATE TABLE GALLERY(
    NO              NUMBER          PRIMARY KEY
    , TITLE         VARCHAR2(100)   NOT NULL
    , CONTENT       VARCHAR2(4000)  NOT NULL
    , WRITER_NO     NUMBER          NOT NULL
    , ORIGIN_NAME   VARCHAR2(1000)  NOT NULL
    , CHANGE_NAME   VARCHAR2(1000)  NOT NULL
    , ENROLL_DATE   TIMESTAMP       DEFAULT SYSDATE
    , STATUS        CHAR(1)         DEFAULT 'O' CHECK( STATUS IN ('O','X') )
    , HIT           NUMBER          DEFAULT 0
);
CREATE SEQUENCE SEQ_GALLERY_NO NOCACHE NOCYCLE;

--CATEGORY
CREATE TABLE CATEGORY(
    NO          NUMBER          NOT NULL UNIQUE
    , NAME      VARCHAR2(100)   NOT NULL UNIQUE
);


-- 須掘徹
ALTER TABLE BOARD ADD CONSTRAINT FK_BOARD_MEMBER FOREIGN KEY(WRITER_NO) REFERENCES MEMBER(NO);
ALTER TABLE ATTACHMENT ADD CONSTRAINT FK_ATTACHMENT_BOARD FOREIGN KEY (BNO) REFERENCES BOARD(NO);
ALTER TABLE REPLY ADD CONSTRAINT FK_REPLY_MEMBER FOREIGN KEY (WRITER_NO) REFERENCES MEMBER(NO);
ALTER TABLE REPLY ADD CONSTRAINT FK_REPLY_BOARD FOREIGN KEY (BNO) REFERENCES BOARD(NO);
ALTER TABLE GALLERY ADD CONSTRAINT FK_GALLERY_MEMBER FOREIGN KEY(WRITER_NO) REFERENCES MEMBER(NO);
ALTER TABLE BOARD ADD CONSTRAINT FK_BOARD_CATEGORY FOREIGN KEY(CATEGORY_NO) REFERENCES CATEGORY(NO);

-- 児巴 汽戚斗 (CATEGORY)
INSERT INTO CATEGORY (NO, NAME) VALUES(10 , '切政');
INSERT INTO CATEGORY (NO, NAME) VALUES(20 , '坪漁');
INSERT INTO CATEGORY (NO, NAME) VALUES(30 , '惟績');
INSERT INTO CATEGORY (NO, NAME) VALUES(40 , '錘疑');
INSERT INTO CATEGORY (NO, NAME) VALUES(50 , '推軒');
COMMIT;

--児巴 汽戚斗 (MEMBER)
INSERT INTO MEMBER(NO, ID, PWD, NICK) VALUES(SEQ_MEMBER_NO.NEXTVAL , 'ADMIN', '1234', '淫軒切');
COMMIT;

--児巴 汽戚斗 (NOTICE)
INSERT INTO NOTICE (NO, TITLE, CONTENT) VALUES (SEQ_NOTICE_NO.NEXTVAL, '児巴 因走紫牌せせ', '因走紫牌鎧遂 ぞぞ');
INSERT INTO NOTICE (NO, TITLE, CONTENT) VALUES (SEQ_NOTICE_NO.NEXTVAL, '児巴 因走紫牌222せせ', '因走紫牌鎧遂22ぞぞ');
INSERT INTO NOTICE (NO, TITLE, CONTENT) VALUES (SEQ_NOTICE_NO.NEXTVAL, '児巴 因走紫牌333せせ', '因走紫牌鎧遂33ぞぞ');
COMMIT;

--児巴 汽戚斗 (BOARD)
INSERT INTO BOARD ( NO ,TITLE ,CONTENT ,WRITER_NO ,CATEGORY_NO ) VALUES ( SEQ_BOARD_NO.NEXTVAL ,'薦鯉せせせ11111' ,'鎧遂せせせ鎧遂鎧遂' ,1 ,10 );
INSERT INTO BOARD ( NO ,TITLE ,CONTENT ,WRITER_NO ,CATEGORY_NO ) VALUES ( SEQ_BOARD_NO.NEXTVAL ,'薦鯉せせせ照括' ,'鎧遂せせせ遂鎧遂鎧' ,1 ,20 );
INSERT INTO BOARD ( NO ,TITLE ,CONTENT ,WRITER_NO ,CATEGORY_NO ) VALUES ( SEQ_BOARD_NO.NEXTVAL ,'薦鯉せせせ鋼亜趨' ,'鎧遂せせせ照井' ,1 ,30 );
INSERT INTO BOARD ( NO ,TITLE ,CONTENT ,WRITER_NO ,CATEGORY_NO ) VALUES ( SEQ_BOARD_NO.NEXTVAL ,'薦鯉せせせ神潅精' ,'鎧遂せせせ輩球肉' ,1 ,40 );
INSERT INTO BOARD ( NO ,TITLE ,CONTENT ,WRITER_NO ,CATEGORY_NO ) VALUES ( SEQ_BOARD_NO.NEXTVAL ,'薦鯉せせせ鉢推析' ,'鎧遂せせせ挑車' ,1 ,50 );
INSERT INTO BOARD ( NO ,TITLE ,CONTENT ,WRITER_NO ,CATEGORY_NO ) VALUES ( SEQ_BOARD_NO.NEXTVAL ,'薦鯉せせせ戚魚亜佐据亜醤走ぞぞ' ,'鎧遂せせせ曽戚津' ,1 ,NULL );
COMMIT;


------------------------------------
-------------- 敗呪 -----------------
------------------------------------

-- 歎採督析 獣碇什葵聖 軒渡馬澗 敗呪
CREATE OR REPLACE FUNCTION GET_ATTACHMENT_SEQ
    RETURN NUMBER
IS
    TEMP NUMBER;
BEGIN
    TEMP := SEQ_ATTACHMENT_NO.NEXTVAL;
RETURN TEMP;
END;
/



