-- kh 계정생성
CREATE USER KH IDENTIFIED BY KH;
GRANT CONNECT,RESOURCE TO KH;

-- 뷰 생성 권한 부여
GRANT CREATE VIEW TO KH;