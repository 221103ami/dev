alter session set nls_date_format='YYYY-MM-DD';
--영구 삭제
drop table emp purge ;
CREATE TABLE EMP ( 
  EMPNO     NUMBER(4, 0), 
  ENAME     VARCHAR2(10), 
  JOB       VARCHAR2(9), 
  MGR       NUMBER(4, 0), 
  HIREDATE  DATE, 
  SAL       NUMBER(7, 2),
  COMM      NUMBER(7, 2), 
  DEPTNO    NUMBER(2, 0));

insert into emp values (7369,'김철수','사원',7902,'2000-12-17',200,null,20);
insert into emp values (7499,'이찬수','주임',7698,'2001-02-20',260,300,30);
insert into emp values (7521,'박종수','주임',7698,'2002-02-22',325,500,30);
insert into emp values (7566,'임채호','과장',7839,'2001-04-02',497,null,20);
insert into emp values (7654,'나대호','주임',7698,'2001-09-28',325,1400,30);
insert into emp values (7698,'박지성','과장',7839,'2001-05-01',485,null,30);
insert into emp values (7782,'구자철','과장',7839,'2001-06-09',445,null,10);
insert into emp values (7788,'송기성','부장',7566,'1997-04-17',500,null,20);
insert into emp values (7839,'김철호','대표',null,'2001-11-17',800,null,10);
insert into emp values (7844,'성명준','주임',7698,'2001-09-08',350,0,30);
insert into emp values (7876,'황인태','사원',7788,'2007-05-23',210,null,20);
insert into emp values (7900,'박민성','사원',7698,'2001-12-03',295,null,30);
insert into emp values (7902,'박진성','부장',7566,'2001-12-03',600,null,20);
insert into emp values (7934,'최철호','사원',7782,'2012-01-23',230,null,10);


CREATE UNIQUE INDEX PK_EMP ON EMP (EMPNO) ;
ALTER TABLE EMP ADD  CONSTRAINT PK_EMP PRIMARY KEY (EMPNO);

drop table dept purge ;
CREATE TABLE DEPT (
  DEPTNO   NUMBER(2,0), 
  DNAME    VARCHAR2(14), 
  LOC      VARCHAR2(13));

insert into dept values (10,'경리팀','부산');
insert into dept values (20,'연구팀','대전');
insert into dept values (30,'총무팀','대구');
insert into dept values (40,'전산팀','인천');

CREATE UNIQUE INDEX PK_DEPT ON DEPT (DEPTNO);
ALTER TABLE DEPT ADD  CONSTRAINT PK_DEPT PRIMARY KEY (DEPTNO);

ALTER TABLE EMP ADD CONSTRAINT FK_DEPTNO FOREIGN KEY (DEPTNO) REFERENCES DEPT (DEPTNO);



drop table professor purge;

create table professor
(profno number(4) primary key,
 name  varchar2(10) not null, 
 id  varchar2(15) not null,
 position varchar2 (20) not null,
 pay number (3) not null,
 hiredate  date not null,
 bonus number(4) ,
 deptno  number(3),
 email  varchar2(50),
 hpage  varchar2(50)) tablespace users;

insert into professor
values(1001,'조인형','captain','정교수',550,to_date('1980-06-23','YYYY-MM-DD'),100,101,'captain@abc.net','http://www.abc.net');

insert into professor
values(1002,'박승곤','sweety','조교수',380,to_date('1987-01-30','YYYY-MM-DD'),60,101,'sweety@abc.net','http://www.abc.net');

insert into professor
values (1003,'송도권','powerman','전임강사',270,to_date('1998-03-22','YYYY-MM-DD'),null,101,'pman@power.com','http://www.power.com');

insert into professor
values (2001,'양선희','lamb1','전임강사',250,to_date('2001-09-01','YYYY-MM-DD'),null,102,'lamb1@hamail.net',null);

insert into professor
values (2002,'김영조','number1','조교수',350,to_date('1985-11-30','YYYY-MM-DD'),80,102,'number1@naver.com','http://num1.naver.com');

insert into professor
values (2003,'주승재','bluedragon','정교수',490,to_date('1982-04-29','YYYY-MM-DD'),90,102,'bdragon@naver.com',null);

insert into professor
values (3001,'김도형','angel1004','정교수',530,to_date('1981-10-23','YYYY-MM-DD'),110,103,'angel1004@hanmir.com',null);

insert into professor
values (3002,'나한열','naone10','조교수',330,to_date('1997-07-01','YYYY-MM-DD'),50,103,'naone10@empal.com',null);

insert into professor
values (3003,'김현정','only-u','전임강사',290,to_date('2002-02-24','YYYY-MM-DD'),null,103,'only_u@abc.com',null);

insert into professor
values (4001,'심슨','simson','정교수',570,to_date('1981-10-23','YYYY-MM-DD'),130,201,'chebin@daum.net',null);

insert into professor
values (4002,'최슬기','gogogo','조교수',330,to_date('2009-08-30','YYYY-MM-DD'),null,201,'gogogo@def.com',null);

insert into professor
values (4003,'박원범','mypride','조교수',310,to_date('1999-12-01','YYYY-MM-DD'),50,202,'mypride@hanmail.net',null);

insert into professor
values (4004,'차범철','ironman','전임강사',260,to_date('2009-01-28','YYYY-MM-DD'),null,202,'ironman@naver.com',null);

insert into professor
values (4005,'바비','standkang','정교수',500,to_date('1985-09-18','YYYY-MM-DD'),80,203,'standkang@naver.com',null);

insert into professor 
values (4006,'전민','napeople','전임강사',220,to_date('2010-06-28','YYYY-MM-DD'),null,301,'napeople@jass.com',null);

insert into professor
values (4007,'허은','silver-her','조교수',290,to_date('2001-05-23','YYYY-MM-DD'),30,301,'silver-her@daum.net',null);

commit;

drop table department purge;
create table department
( deptno number(3) primary key ,
  dname varchar2(30) not null,
  part number(3),
  build  varchar2(30))tablespace users;

insert into department 
values (101,'컴퓨터공학과',100,'정보관');

insert into department
values (102,'멀티미디어공학과',100,'멀티미디어관');

insert into department
values (103,'소프트웨어공학과',100,'소프트웨어관');

insert into department
values (201,'전자공학과',200,'전자제어관');

insert into department
values (202,'기계공학과',200,'기계실험관');

insert into department
values (203,'화학공학과',200,'화학실습관');

insert into department
values (301,'문헌정보학과',300,'인문관');

insert into department
values (100,'컴퓨터정보학부',10,null);

insert into department
values (200,'메카트로닉스학부',10,null);

insert into department
values (300,'인문사회학부',20,null);

insert into department
values (10,'공과대학',null,null);

insert into department
values (20,'인문대학',null,null);

commit;
 

drop table student purge;

create table student
( studno number(4) primary key,
  name   varchar2(10) not null,
  id varchar2(20) not null unique,
  grade number check(grade between 1 and 6),
  jumin char(13) not null,
  birthday  date,
  tel varchar2(15),
  height  number(4),
  weight  number(3),
  deptno1 number(3),
  deptno2 number(3),
  profno  number(4)) tablespace users;

insert into student values (
9411,'서진수','75true',4,'7510231901813',to_date('1975-10-23','YYYY-MM-DD'),'055)381-2158',180,72,101,201,1001);

insert into student values (
9412,'서재수','pooh94',4,'7502241128467',to_date('1975-02-24','YYYY-MM-DD'),'051)426-1700',172,64,102,null,2001);

insert into student values (
9413,'이미경','angel000',4,'7506152123648',to_date('1975-06-15','YYYY-MM-DD'),'053)266-8947',168,52,103,203,3002);

insert into student values (
9414,'김재수','gunmandu',4,'7512251063421',to_date('1975-12-25','YYYY-MM-DD'),'02)6255-9875',177,83,201,null,4001);

insert into student values (
9415,'박동호','pincle1',4,'7503031639826',to_date('1975-03-03','YYYY-MM-DD'),'031)740-6388',182,70,202,null,4003);

insert into student values (
9511,'김신영','bingo',3,'7601232186327',to_date('1976-01-23','YYYY-MM-DD'),'055)333-6328',164,48,101,null,1002);

insert into student values (
9512,'신은경','jjang1',3,'7604122298371',to_date('1976-04-12','YYYY-MM-DD'),'051)418-9627',161,42,102,201,2002);

insert into student values (
9513,'오나라','nara5',3,'7609112118379',to_date('1976-09-11','YYYY-MM-DD'),'051)724-9618',177,55,202,null,4003);

insert into student values (
9514,'구유미','guyume',3,'7601202378641',to_date('1976-01-20','YYYY-MM-DD'),'055)296-3784',160,58,301,101,4007);

insert into student values (
9515,'임세현','shyun1',3,'7610122196482',to_date('1976-10-12','YYYY-MM-DD'),'02)312-9838',171,54,201,null,4001);

insert into student values (
9611,'일지매','onejimae',2,'7711291186223',to_date('1977-11-29','YYYY-MM-DD'),'02)6788-4861',182,72,101,null,1002);

insert into student values (
9612,'김진욱','samjang7',2,'7704021358674',to_date('1977-04-02','YYYY-MM-DD'),'055)488-2998',171,70,102,null,2001);

insert into student values (
9613,'안광훈','nonnon1',2,'7709131276431',to_date('1977-09-13','YYYY-MM-DD'),'053)736-4981',175,82,201,null,4002);

insert into student values (
9614,'김문호','munho',2,'7702261196365',to_date('1977-02-26','YYYY-MM-DD'),'02)6175-3945',166,51,201,null,4003);

insert into student values (
9615,'노정호','star123',2,'7712141254963',to_date('1977-12-14','YYYY-MM-DD'),'051)785-6984',184,62,301,null,4007);

insert into student values (
9711,'이윤나','prettygirl',1,'7808192157498',to_date('1978-08-19','YYYY-MM-DD'),'055)278-3649',162,48,101,null,null);

insert into student values (
9712,'안은수','silverwt',1,'7801051776346',to_date('1978-01-05','YYYY-MM-DD'),'02)381-5440',175,63,201,null,null);

insert into student values (
9713,'인영민','youngmin',1,'7808091786954',to_date('1978-08-09','YYYY-MM-DD'),'031)345-5677',173,69,201,null,null);

insert into student values (
9714,'김주현','kimjh',1,'7803241981987',to_date('1978-03-24','YYYY-MM-DD'),'055)423-9870',179,81,102,null,null);

insert into student values (
9715,'허우','wooya2702',1,'7802232116784',to_date('1978-02-23','YYYY-MM-DD'),'02)6122-2345',163,51,103,null,null);

commit;





