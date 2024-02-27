SELECT trigger_name, trigger_body
FROM user_triggers
WHERE table_name = 'REVIEW';

-- 트리거 활성화 쿼리(디비버에서 사용 권장)
-- 트리거를 생성한다 이름은 INSERT_REVIEW_TRIGGER
-- CREATE OR REPLACE TRIGGER INSERT_REVIEW_TRIGGER // OR REPLACE 이미 있다면 변경
CREATE TRIGGER INSERT_REVIEW_TRIGGER
-- 트리거 발동 시기는 리뷰 테이블에 INSERT가 작동한 후
AFTER INSERT ON REVIEW
-- 트리거를 행에 적용하는 문구(기본양식)
FOR EACH ROW
-- 트리거에서 작동할 쿼리
BEGIN
    --BUYINFO테이블에서 HAS_REVIEW 1로 업데이트한다
    UPDATE BUYINFO
    SET HAS_REVIEW = 1
    -- :new.B_ID = INSERT(트리거가 발생하는 쿼리)가 작동했을 때 사용된 B_ID
    WHERE B_ID = :new.B_ID;
-- 트리거 에서 작동할 쿼리 종료
END;


-- 트리거
-- 리뷰 삭제 시 구매내역에서 리뷰유무 0으로 업데이트
CREATE TRIGGER DELETE_REVIEW_TRIGGER
-- 트리거 발동 시기는 리뷰 테이블에 DELETE가 작동한 후
AFTER DELETE ON REVIEW
-- 트리거를 행에 적용하는 문구(기본양식)
FOR EACH ROW
-- 트리거에서 작동할 쿼리
BEGIN
    -- BUYINFO 테이블에서 HAS_REVIEW를 0으로 업데이트한다
    UPDATE BUYINFO
    SET HAS_REVIEW = 0
    -- :old.B_ID = DELETE(트리거가 발생하는 쿼리)가 작동하기 전의 B_ID
    WHERE B_ID = :old.B_ID;
-- 트리거에서 작동할 쿼리 종료
END;

INSERT INTO COUPON (CP_ID, M_ID, CP_NAME, PERIOD, DISCOUNT, CATEGORY)
VALUES (
 '7', 	--쿠폰번호--
 'teemo',		--소유자MID--
 '임시쿠폰 4',	--쿠폰이름--
 SYSTIMESTAMP,	--현재시간 +30일--
 30,			-- 할인율
 '눈'
);

SELECT * FROM COUPON; 


















DROP TABLE PRODUCT; 

CREATE TABLE PRODUCT(
	-- 상품번호(기본키)
	P_ID INT PRIMARY KEY,
	-- 제품설명
	-- 01_18_NOT NULL 추가
	P_DETAIL VARCHAR2(500) NOT NULL,
	-- 상품이름(20자 제한)
	P_NAME VARCHAR2(60) NOT NULL,
	-- 상품 원가
	COST_PRICE INT NOT NULL,
	-- 상품 정가
	REGULAR_PRICE INT NOT NULL,
	-- 상품 판매가
	SELLING_PRICE INT NOT NULL,
	-- 상품재고
	P_QTY INT NOT NULL,
	-- 상품성분(상품 성분 100자 제한)
	-- 01_18_자료크기 300 -> 600
	INGREDIENT VARCHAR2(600) NOT NULL,
	-- 상품용법(25자 제한) //  1일 2회, 1회 2정 섭취(공백포함 21byte)
	-- 01_18_NOT NULL 추가
	USAGE VARCHAR2(75) DEFAULT '1일 2회, 1회 2정 섭취' NOT NULL,
	-- 유통기한
	-- 01_18_NOT NULL 추가
	EXP VARCHAR2(75) DEFAULT '제조일로부터 24개월' NOT NULL,
	-- 카테고리
	CATEGORY VARCHAR2(75) NOT NULL,
	-- 등록일
	REG_TIME TIMESTAMP NOT NULL,
	-- 판매상태
	-- NOT NULL 작성_01_13
	SELLING_STATE VARCHAR2(15) NOT NULL,
	-- 상품이미지 경로
	-- 추가작성_01_13
	IMAGE_PATH VARCHAR2(255)
);





DROP TABLE  REVIEW; 


CREATE TABLE REVIEW (
	--리뷰번호
	R_ID INT PRIMARY KEY,
	--회원ID
	--NOT NULL 제거_01_13
	M_ID VARCHAR2(15),
	--구매번호
	B_ID INT NOT NULL,
	--별점
	SCORE INT NOT NULL,
	--리뷰내용
	CONTENTS VARCHAR2(1500) NOT NULL,
	--작성일
	CREATE_TIME TIMESTAMP NOT NULL,
	--업로드 한 이미지 이름
	IMAGENAME VARCHAR2(100)
);















SELECT * FROM PRODUCT;








