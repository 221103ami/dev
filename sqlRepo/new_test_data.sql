alter session set nls_date_format='YYYY-MM-DD';
--���� ����
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

insert into emp values (7369,'��ö��','���',7902,'2000-12-17',200,null,20);
insert into emp values (7499,'������','����',7698,'2001-02-20',260,300,30);
insert into emp values (7521,'������','����',7698,'2002-02-22',325,500,30);
insert into emp values (7566,'��äȣ','����',7839,'2001-04-02',497,null,20);
insert into emp values (7654,'����ȣ','����',7698,'2001-09-28',325,1400,30);
insert into emp values (7698,'������','����',7839,'2001-05-01',485,null,30);
insert into emp values (7782,'����ö','����',7839,'2001-06-09',445,null,10);
insert into emp values (7788,'�۱⼺','����',7566,'1997-04-17',500,null,20);
insert into emp values (7839,'��öȣ','��ǥ',null,'2001-11-17',800,null,10);
insert into emp values (7844,'������','����',7698,'2001-09-08',350,0,30);
insert into emp values (7876,'Ȳ����','���',7788,'2007-05-23',210,null,20);
insert into emp values (7900,'�ڹμ�','���',7698,'2001-12-03',295,null,30);
insert into emp values (7902,'������','����',7566,'2001-12-03',600,null,20);
insert into emp values (7934,'��öȣ','���',7782,'2012-01-23',230,null,10);


CREATE UNIQUE INDEX PK_EMP ON EMP (EMPNO) ;
ALTER TABLE EMP ADD  CONSTRAINT PK_EMP PRIMARY KEY (EMPNO);

drop table dept purge ;
CREATE TABLE DEPT (
  DEPTNO   NUMBER(2,0), 
  DNAME    VARCHAR2(14), 
  LOC      VARCHAR2(13));

insert into dept values (10,'�渮��','�λ�');
insert into dept values (20,'������','����');
insert into dept values (30,'�ѹ���','�뱸');
insert into dept values (40,'������','��õ');

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
values(1001,'������','captain','������',550,to_date('1980-06-23','YYYY-MM-DD'),100,101,'captain@abc.net','http://www.abc.net');

insert into professor
values(1002,'�ڽ°�','sweety','������',380,to_date('1987-01-30','YYYY-MM-DD'),60,101,'sweety@abc.net','http://www.abc.net');

insert into professor
values (1003,'�۵���','powerman','���Ӱ���',270,to_date('1998-03-22','YYYY-MM-DD'),null,101,'pman@power.com','http://www.power.com');

insert into professor
values (2001,'�缱��','lamb1','���Ӱ���',250,to_date('2001-09-01','YYYY-MM-DD'),null,102,'lamb1@hamail.net',null);

insert into professor
values (2002,'�迵��','number1','������',350,to_date('1985-11-30','YYYY-MM-DD'),80,102,'number1@naver.com','http://num1.naver.com');

insert into professor
values (2003,'�ֽ���','bluedragon','������',490,to_date('1982-04-29','YYYY-MM-DD'),90,102,'bdragon@naver.com',null);

insert into professor
values (3001,'�赵��','angel1004','������',530,to_date('1981-10-23','YYYY-MM-DD'),110,103,'angel1004@hanmir.com',null);

insert into professor
values (3002,'���ѿ�','naone10','������',330,to_date('1997-07-01','YYYY-MM-DD'),50,103,'naone10@empal.com',null);

insert into professor
values (3003,'������','only-u','���Ӱ���',290,to_date('2002-02-24','YYYY-MM-DD'),null,103,'only_u@abc.com',null);

insert into professor
values (4001,'�ɽ�','simson','������',570,to_date('1981-10-23','YYYY-MM-DD'),130,201,'chebin@daum.net',null);

insert into professor
values (4002,'�ֽ���','gogogo','������',330,to_date('2009-08-30','YYYY-MM-DD'),null,201,'gogogo@def.com',null);

insert into professor
values (4003,'�ڿ���','mypride','������',310,to_date('1999-12-01','YYYY-MM-DD'),50,202,'mypride@hanmail.net',null);

insert into professor
values (4004,'����ö','ironman','���Ӱ���',260,to_date('2009-01-28','YYYY-MM-DD'),null,202,'ironman@naver.com',null);

insert into professor
values (4005,'�ٺ�','standkang','������',500,to_date('1985-09-18','YYYY-MM-DD'),80,203,'standkang@naver.com',null);

insert into professor 
values (4006,'����','napeople','���Ӱ���',220,to_date('2010-06-28','YYYY-MM-DD'),null,301,'napeople@jass.com',null);

insert into professor
values (4007,'����','silver-her','������',290,to_date('2001-05-23','YYYY-MM-DD'),30,301,'silver-her@daum.net',null);

commit;

drop table department purge;
create table department
( deptno number(3) primary key ,
  dname varchar2(30) not null,
  part number(3),
  build  varchar2(30))tablespace users;

insert into department 
values (101,'��ǻ�Ͱ��а�',100,'������');

insert into department
values (102,'��Ƽ�̵����а�',100,'��Ƽ�̵���');

insert into department
values (103,'����Ʈ������а�',100,'����Ʈ�����');

insert into department
values (201,'���ڰ��а�',200,'���������');

insert into department
values (202,'�����а�',200,'�������');

insert into department
values (203,'ȭ�а��а�',200,'ȭ�нǽ���');

insert into department
values (301,'���������а�',300,'�ι���');

insert into department
values (100,'��ǻ�������к�',10,null);

insert into department
values (200,'��īƮ�δн��к�',10,null);

insert into department
values (300,'�ι���ȸ�к�',20,null);

insert into department
values (10,'��������',null,null);

insert into department
values (20,'�ι�����',null,null);

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
9411,'������','75true',4,'7510231901813',to_date('1975-10-23','YYYY-MM-DD'),'055)381-2158',180,72,101,201,1001);

insert into student values (
9412,'�����','pooh94',4,'7502241128467',to_date('1975-02-24','YYYY-MM-DD'),'051)426-1700',172,64,102,null,2001);

insert into student values (
9413,'�̹̰�','angel000',4,'7506152123648',to_date('1975-06-15','YYYY-MM-DD'),'053)266-8947',168,52,103,203,3002);

insert into student values (
9414,'�����','gunmandu',4,'7512251063421',to_date('1975-12-25','YYYY-MM-DD'),'02)6255-9875',177,83,201,null,4001);

insert into student values (
9415,'�ڵ�ȣ','pincle1',4,'7503031639826',to_date('1975-03-03','YYYY-MM-DD'),'031)740-6388',182,70,202,null,4003);

insert into student values (
9511,'��ſ�','bingo',3,'7601232186327',to_date('1976-01-23','YYYY-MM-DD'),'055)333-6328',164,48,101,null,1002);

insert into student values (
9512,'������','jjang1',3,'7604122298371',to_date('1976-04-12','YYYY-MM-DD'),'051)418-9627',161,42,102,201,2002);

insert into student values (
9513,'������','nara5',3,'7609112118379',to_date('1976-09-11','YYYY-MM-DD'),'051)724-9618',177,55,202,null,4003);

insert into student values (
9514,'������','guyume',3,'7601202378641',to_date('1976-01-20','YYYY-MM-DD'),'055)296-3784',160,58,301,101,4007);

insert into student values (
9515,'�Ӽ���','shyun1',3,'7610122196482',to_date('1976-10-12','YYYY-MM-DD'),'02)312-9838',171,54,201,null,4001);

insert into student values (
9611,'������','onejimae',2,'7711291186223',to_date('1977-11-29','YYYY-MM-DD'),'02)6788-4861',182,72,101,null,1002);

insert into student values (
9612,'������','samjang7',2,'7704021358674',to_date('1977-04-02','YYYY-MM-DD'),'055)488-2998',171,70,102,null,2001);

insert into student values (
9613,'�ȱ���','nonnon1',2,'7709131276431',to_date('1977-09-13','YYYY-MM-DD'),'053)736-4981',175,82,201,null,4002);

insert into student values (
9614,'�蹮ȣ','munho',2,'7702261196365',to_date('1977-02-26','YYYY-MM-DD'),'02)6175-3945',166,51,201,null,4003);

insert into student values (
9615,'����ȣ','star123',2,'7712141254963',to_date('1977-12-14','YYYY-MM-DD'),'051)785-6984',184,62,301,null,4007);

insert into student values (
9711,'������','prettygirl',1,'7808192157498',to_date('1978-08-19','YYYY-MM-DD'),'055)278-3649',162,48,101,null,null);

insert into student values (
9712,'������','silverwt',1,'7801051776346',to_date('1978-01-05','YYYY-MM-DD'),'02)381-5440',175,63,201,null,null);

insert into student values (
9713,'�ο���','youngmin',1,'7808091786954',to_date('1978-08-09','YYYY-MM-DD'),'031)345-5677',173,69,201,null,null);

insert into student values (
9714,'������','kimjh',1,'7803241981987',to_date('1978-03-24','YYYY-MM-DD'),'055)423-9870',179,81,102,null,null);

insert into student values (
9715,'���','wooya2702',1,'7802232116784',to_date('1978-02-23','YYYY-MM-DD'),'02)6122-2345',163,51,103,null,null);

commit;





