SELECT * FROM ALL_TABLES;

CREATE TABLE MEMBER(
	MID VARCHAR(15) PRIMARY KEY,
	MPW VARCHAR(15) NOT NULL
);

DROP TABLE MEMBER;

CREATE TABLE PRODUCT(
	PID INT PRIMARY KEY,
	NAME VARCHAR(30) NOT NULL,
	PRICE INT NOT NULL
);

INSERT INTO PRODUCT VALUES(101,'귤 탕후루',4000);
INSERT INTO PRODUCT VALUES(102,'붕어빵',2000);
INSERT INTO PRODUCT VALUES(103,'프라푸치노',6500);
INSERT INTO PRODUCT VALUES(104,'아이스 아메리카노',4100);

DROP TABLE PRODUCT;

SELECT * FROM MEMBER;

SELECT * FROM PRODUCT;