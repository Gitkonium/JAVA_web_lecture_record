SELECT * FROM ALL_TABLES;

CREATE TABLE MEMBER(
	MID VARCHAR(20) PRIMARY KEY,
	MPW VARCHAR(20) NOT NULL,
	NAME VARCHAR(20) NOT NULL
);

CREATE TABLE REPLY(
	RID INT PRIMARY KEY,
	WRITER VARCHAR(20) NOT NULL, -- FK
	CONTENT VARCHAR(50) NOT NULL
);

-- 제약조건을 설정하면,
--  PK 데이터 삭제시 FK 데이터가 함께 삭제되는 것이 강제됨
-- 실제로는, '탈퇴한 회원입니다.' or '삭제된 댓글입니다.'
--  이런식으로 안내됨
-- 데이터끼리 별도로 관리하고싶어하기때문에 제약조건을 드물게 설정함

DROP TABLE MEMBER;
DROP TABLE REPLY;