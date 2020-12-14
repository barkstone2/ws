DROP TABLE member;

DROP TABLE if EXISTS member100;

CREATE TABLE member (
id VARCHAR(50) NOT NULL PRIMARY key,
pwd VARCHAR(50) NOT NULL,
NAME VARCHAR(50) NOT NULL,
byear int NOT NULL,
bmonth int NOT NULL,
bday int NOT NULL,
gender VARCHAR(2) NOT null,
email varCHAR(50) UNIQUE KEY NOT null,
phonenation VARCHAR(50) NOT NULL,
phonenumber VARCHAR(50) NOT NULL UNIQUE key,
wdate datetime not null DEFAULT NOW()
);

INSERT INTO member
VALUES('hong',PASSWORD('1111')	,'홍길동',	'2000',	'12',	'12',	'남자',	'hong@gmail.com','korea','010-1111-1111', default
);

INSERT INTO member
VALUES('jang',PASSWORD('2222'),'장천용','1999','11','11','남자','jang@gmail.com','korea','010-2222-2222', default
);
INSERT INTO member
VALUES('lee',	PASSWORD('3333'),	'이영자',	'1998',	'10',	'10',	'여자',	'lee@gmail.com','korea',	'010-3333-3333',default
);
INSERT INTO member
VALUES('lee2',	PASSWORD('3333'),	'이영자',	'1998',	'10',	'10',	'여자',	'lee2@gmail.com','korea',	'010-4444-4444',default
);

DESC member;

insert into member set
id = 'kim',
pwd = PASSWORD('0000'),
name = '김민수',
byear = 1995,
bmonth = 9,
bday = 31,
gender = '남자',
email = 'kim@gmail.com',
phonenation = 'korea',
phonenumber = '010-1234-5678';


SHOW TABLES;

CREATE TABLE if NOT EXISTS member (
id VARCHAR(50) NOT NULL PRIMARY KEY,
NAME VARCHAR(50) NOT NULL
);

ALTER TABLE member ADD COLUMN pwdcheck VARCHAR(50);
DESC member;

ALTER TABLE member DROP COLUMN pwdcheck;

ALTER TABLE member ADD COLUMN age VARCHAR(50);

DESC member;


DROP TABLE member2;

CREATE TABLE member2 (
id VARCHAR(50) NOT NULL,
NAME VARCHAR(50) NOT NULL
);

INSERT INTO member2
VALUES('hong1', '홍길동1');
INSERT INTO member2 VALUES('hong2','홍길동2');
INSERT INTO member2 VALUES('hong3','홍길동3');
INSERT INTO member2 VALUES('hong4','홍길동4');
INSERT INTO member2 VALUES('hong5','홍길동5');

SELECT * FROM member2;

ALTER TABLE member2 ADD COLUMN passwd VARCHAR(50) NOT NULL DEFAULT '';
ALTER TABLE member2 add COLUMN address VARCHAR(50) NOT NULL DEFAULT '서울';

SELECT * FROM member2;

ALTER TABLE member2 ADD COLUMN gender VARCHAR(50) NOT NULL DEFAULT '' first;

SELECT * FROM member2;

ALTER TABLE member2 ADD COLUMN email VARCHAR(50) NOT NULL DEFAULT '' AFTER NAME;
SELECT * FROM member2;


ALTER TABLE member2 CHANGE column address addr VARCHAR(1000) NULL; 

DESC member2;

DROP TABLE myfriend;

CREATE TABLE myfriend(
id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
NAME VARCHAR(10) NOT NULL,
mobile VARCHAR(15) NOT NULL,
email VARCHAR(30) NOT NULL,
date_1 DATE not NULL,
date_2 DATETIME NOT NULL
);
/*
SELECT * FROM myfriend;
*/
INSERT INTO myfriend (NAME, mobile, email, date_1, date_2) values
('이영희',	'010-1122-3421',	'lyh@hanmail.com',	curdate(),	NOW());
INSERT INTO myfriend values
(NULL, '황명이',	'010-8302-4876',	'hmi@naver.com',	curdate(),	NOW());
INSERT into myfriend SET
NAME='김정애',
mobile='010-5635-1274',
email='kje@gmail.com',
date_1	=curdate(),	
date_2=	NOW();
/*
SELECT 8 FROM myfriend;

ALTER TABLE myfriend CHANGE COLUMN NAME memberTblMemberName VARCHAR(50);

DESC myfriend;

SELECT id, memberTblMemberName AS member_name FROM myfriend;
*/
SELECT * FROM myfriend ORDER BY id ASC;
SELECT * FROM myfriend ORDER BY NAME;
SELECT id, name FROM myfriend ORDER BY email DESC; /* X(안 좋은 방식) */
SELECT id, NAME, email FROM myfriend ORDER BY email DESC; /* O */
SELECT id, NAME, email FROM myfriend ORDER BY NAME DESC, id ASC;
SELECT id, NAME, email FROM myfriend ORDER BY 2,3; /* 이런 방식은 안 쓰기 */
SELECT * FROM myfriend WHERE NAME='김정애';
SELECT * FROM myfriend WHERE email='lyh@hanmail.com';
SELECT * FROM myfriend WHERE id >='1' AND id<='3';
SELECT * FROM myfriend WHERE id <> '2';
SELECT * FROM myfriend WHERE id != '2';

ALTER TABLE myfriend ADD COLUMN addr VARCHAR(50) NULL;

SELECT * FROM myfriend WHERE addr IS NULL;


DROP TABLE shop_member;

CREATE table shop_member(
member_id VARCHAR(8) not null PRIMARY KEY,
member_name VARCHAR(10) NOT NULL,
birth_year INT NOT null,
member_addr CHAR(2) NOT null,
mobile CHAR(15) null,
height SMALLINT null,
wdate DATE null
);

INSERT INTO shop_member
VALUES('hds',	'하동식',	'1964',	'서울',	'0100000000',	'178',	'2012-04-06'
);

INSERT INTO shop_member
VALUES('jcy',	'장천용',	'1960',	'경남',	'0112222222',	'175',	'2011-03-05'
);

INSERT INTO shop_member
VALUES('jkh',	'장기훈',	'1956',	'경기',	'0189999999',	'174',	'2009-09-11'
);

INSERT INTO shop_member
VALUES('kcs',	'김춘삼',	'1960',	'서울',	Null,	'188',	'2012-11-13'
);

INSERT INTO shop_member
VALUES('kdh',	'김두한',	'1941',	'경기',	'0114444444',	'168',	'2008-03-05'
);

INSERT INTO shop_member
VALUES('kyc',	'김영철',	'1950',	'경남',	null,	'170',	'2004-04-06'
);

INSERT INTO shop_member
VALUES('ljj',	'이정재',	'1954',	'서울',	'0166666666',	'186',	'2008-08-10'
);

INSERT INTO shop_member
VALUES('lsd',	'이상대',	'1978',	'서울',	'0111111111',	'184',	'2007-07-09'
);

INSERT INTO shop_member
VALUES('lss',	'이성순',	'1962',	'전남',	'0193333333',	'179',	'2006-06-08'
);

INSERT INTO shop_member
VALUES('ysj',	'윤세준',	'1963',	'경북',	'0118888888',	'176',	'2013-02-04'
);


DROP TABLE shop_buy;

CREATE TABLE shop_buy (
num INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
member_id VARCHAR(8) NOT NULL,
prod_name VARCHAR(6) NOT NULL,
prod_bunryu VARCHAR(4),
prod_price INT NOT NULL,
prod_amount SMALLINT NOT NULL,
FOREIGN KEY (member_id) REFERENCES shop_member(member_id)
);

INSERT INTO shop_buy
VALUES(null,'jcy',	'구두',	null,	'300000',	'2'
);

INSERT INTO shop_buy
VALUES(NULL,'jcy',	'노트북',	'전자',	'10000000',	'1'
);

INSERT INTO shop_buy
VALUES(null,	'kdh',	'모니터',	'전자',	'2000000',	'1'
);

INSERT INTO shop_buy
VALUES(null,	'hds',	'모니터',	'전자',	'2000000',	'5'
);

INSERT INTO shop_buy
VALUES(null,	'jcy',	'바지',	'의류',	'500000',	'3'
);

INSERT INTO shop_buy
VALUES(null,	'hds',	'메모리',	'전자',	'800000',	'10'
);

INSERT INTO shop_buy
VALUES(null,	'kcs',	'잡지',	'서적',	'150000',	'5'
);

INSERT INTO shop_buy
VALUES(null,	'ysj',	'잡지',	'서적',	'150000',	'2'
);

INSERT INTO shop_buy
VALUES(null,	'ysj',	'바지',	'의류',	'500000',	'1'
);

INSERT INTO shop_buy
VALUES(null,	'hds',	'구두',	null,	'300000',	'2'
);

INSERT INTO shop_buy
VALUES(null,	'ysj',	'잡지',	'서적',	'150000',	'1'
);

INSERT INTO shop_buy
VALUES(null,	'hds',	'구두',	null,	'300000',	'2'
);


SELECT * FROM shop_member;


DROP TABLE book_info;

CREATE TABLE book_info(
id INT(11) NOT NULL AUTO_INCREMENT,
subject VARCHAR(100) NOT NULL,
author VARCHAR(10) NULL,
created DATE NOT NULL,
profile VARCHAR(10) NULL,
PRIMARY KEY(id)
);

insert into book_info values(	null,	'점프 투 파이썬',	'박응용',	'2019-07-14',	'프로그래밍'	);
insert into book_info values(	null,	'점프 투 자바',	'박응용',	'2018-08-25',	'프로그래밍'	);
insert into book_info values(	null,	'딥 러닝을 이용한 자연어 처리 입문',	'WJY',	'2019-07-12',	'프로그래밍'	);
insert into book_info values(	null,	'공이의 수학정리노트',	'Donghoon',	'2019-04-05',	'수학'	);
insert into book_info values(	null,	'예제로 배우는 ORACLE 11g',	'초록우산',	'2019-07-12',	'데이타베이스'	);
insert into book_info values(	null,	'주식 시장을 이기는 마법의 자동매매',	'엑슬론',	'2019-03-16',	'주식'	);
insert into book_info values(	null,	'비트코인 개발자 가이드',	'Soori',	'2018-02-24',	'금융'	);
insert into book_info values(	null,	'미국 금융공학 유학',	'엑슬론',	'2019-07-12',	'주식'	);
insert into book_info values(	null,	'Deep Inside VBA',	'곽승주',	'2019-04-27',	'VBA'	);
insert into book_info values(	null,	'CentOS 만들기',	'박응용',	'2016-10-19',	'프로그래밍'	);
insert into book_info values(	null,	'Windows Server 만들기',	'박응용',	'2017-08-09',	'프로그래밍'	);










DROP TABLE book_01;

CREATE TABLE book_01(
id INT(11) NOT NULL AUTO_INCREMENT,
author VARCHAR(10) NULL,
profile VARCHAR(10) NULL,
PRIMARY KEY(id)
);


insert into book_01 values(	null,	'박응용',	'프로그래밍'	);
insert into book_01 values(	null,	'WJY',	'WJY'	);
insert into book_01 values(	null,	'Donghoon',	'수학'	);
insert into book_01 values(	null,	'초록우산',	'데이타베이스'	);
insert into book_01 values(	null,	'엑슬론',	'주식'	);
insert into book_01 values(	null,	'Soori',	'금융'	);
insert into book_01 values(	null,	'곽승주',	'VBA'	);


DROP TABLE book_02;

CREATE TABLE book_02(
id INT(11) NOT NULL auto_increment,
subject VARCHAR(100) NOT NULL,
created DATE NOT NULL,
author_id INT(11) NOT NULL,
PRIMARY KEY(id)
);

insert into book_02 values(	null,	'점프 투 파이썬',	'2019-07-14',	'1'	);
insert into book_02 values(	null,	'점프 투 자바',	'2018-08-25',	'1'	);
insert into book_02 values(	null,	'딥 러닝을 이용한 자연어 처리 입문',	'2019-07-12',	'2'	);
insert into book_02 values(	null,	'공이의 수학정리노트',	'2019-04-05',	'3'	);
insert into book_02 values(	null,	'예제로 배우는 ORACLE 11g',	'2019-07-12',	'4'	);
insert into book_02 values(	null,	'주식 시장을 이기는 마법의 자동매매',	'2019-03-16',	'5'	);
insert into book_02 values(	null,	'비트코인 개발자 가이드',	'2018-02-24',	'6'	);
insert into book_02 values(	null,	'미국 금융공학 유학',	'2019-07-12',	'5'	);
insert into book_02 values(	null,	'Deep Inside VBA',	'2019-04-27',	'7'	);
insert into book_02 values(	null,	'CentOS 만들기',	'2016-10-19',	'1'	);
insert into book_02 values(	null,	'Windows Server 만들기',	'2017-08-09',	'1'	);



select subject, created, 
(select author from book_01 
where book_02.author_id = book_01.id) as author
FROM book_02;




SELECT book_02.id, subject, created, 
author, PROFILE
 FROM book_02
 LEFT OUTER JOIN book_01
 ON book_02.author_id = book_01.id;










CREATE TABLE book_02(
id INT(11) NOT NULL AUTO_INCREMENT,
subject VARCHAR(100) NOT NULL,
author VARCHAR(10) NULL,
created DATE NOT NULL,
profile VARCHAR(10) NULL,
PRIMARY KEY(id),
FOREIGN KEY (author) REFERENCES book_01(author) ON UPDATE cascade
);

insert into book_02 values(	null,	'점프 투 파이썬',	'박응용',	'2019-07-14',	'프로그래밍'	);
insert into book_02 values(	null,	'점프 투 자바',	'박응용',	'2018-08-25',	'프로그래밍'	);
insert into book_02 values(	null,	'딥 러닝을 이용한 자연어 처리 입문',	'WJY',	'2019-07-12',	'프로그래밍'	);
insert into book_02 values(	null,	'공이의 수학정리노트',	'Donghoon',	'2019-04-05',	'수학'	);
insert into book_02 values(	null,	'예제로 배우는 ORACLE 11g',	'초록우산',	'2019-07-12',	'데이타베이스'	);
insert into book_02 values(	null,	'주식 시장을 이기는 마법의 자동매매',	'엑슬론',	'2019-03-16',	'주식'	);
insert into book_02 values(	null,	'비트코인 개발자 가이드',	'Soori',	'2018-02-24',	'금융'	);
insert into book_02 values(	null,	'미국 금융공학 유학',	'엑슬론',	'2019-07-12',	'주식'	);
insert into book_02 values(	null,	'Deep Inside VBA',	'곽승주',	'2019-04-27',	'VBA'	);
insert into book_02 values(	null,	'CentOS 만들기',	'박응용',	'2016-10-19',	'프로그래밍'	);
insert into book_02 values(	null,	'Windows Server 만들기',	'박응용',	'2017-08-09',	'프로그래밍'	);


UPDATE book_01 SET author='박응용' WHERE id='1';








