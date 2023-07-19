CREATE TABLE "MEMBER" (
   "MEMBER_NO"   NUMBER   PRIMARY KEY,
   "MEMBER_EMAIL"   VARCHAR2(50) NOT NULL,
   "MEMBER_PW"   VARCHAR2(30) NOT NULL,
   "MEMBER_NICK"   VARCHAR2(30) NOT NULL,
   "MEMBER_TEL"   CHAR(11) NOT NULL,
   "MEMBER_ADDR"   VARCHAR2(500),
   "PROFILE_IMG"   VARCHAR2(200),
   "ENROLL_DT"   DATE DEFAULT SYSDATE ,
   "SECESSION_FL"   CHAR(1)   DEFAULT 'N'
);


COMMENT ON COLUMN "MEMBER"."MEMBER_NO" IS '회원 번호';
COMMENT ON COLUMN "MEMBER"."MEMBER_EMAIL" IS '회원 이메일(아이디)';
COMMENT ON COLUMN "MEMBER"."MEMBER_PW" IS '회원 비밀번호';
COMMENT ON COLUMN "MEMBER"."MEMBER_NICK" IS '회원 닉네임(중복x)';
COMMENT ON COLUMN "MEMBER"."MEMBER_TEL" IS '전화번호(- 미포함)';
COMMENT ON COLUMN "MEMBER"."MEMBER_ADDR" IS '회원 주소';
COMMENT ON COLUMN "MEMBER"."PROFILE_IMG" IS '회원 프로필 이미지';
COMMENT ON COLUMN "MEMBER"."ENROLL_DT" IS '회원 가입일';
COMMENT ON COLUMN "MEMBER"."SECESSION_FL" IS '탈퇴여부(Y:탈퇴, N:미탈퇴)';


-- 회원 번호 시퀀스
CREATE SEQUENCE SEQ_MEMBER_NO;


INSERT INTO MEMBER
VALUES(SEQ_MEMBER_NO.NEXTVAL, 'user01@kh.or.kr', 'pass01!', 
    '유저일', '01012341234', '04540,,서울특별시 강남구 테헤란로 14길 6 5층',
     NULL, DEFAULT, DEFAULT);

COMMIT;


--암호화된 비밀번호로 업데이트
UPDATE MEMBER SET
MEMBER_PW = 'aBN5hiegXlvAovJLipPoPd5LB+xjPrAeu1tcAVg0p5MKGocvo6l825SD+ZMCOcHBFeGB7MnzH31SAnDzYYsSdg==';

-- MEMBER TABLE 비밀번호 컬럼 크기 변경
ALTER TABLE MEMBER
MODIFY MEMBER_PW VARCHAR2(100);

-- 암호화된 비밀번호로 업데이트
UPDATE MEMBER SET
MEMBER_PW = 'aBN5hiegXlvAovJLipPoPd5LB+xjPrAeu1tcAVg0p5MKGocvo6l825SD+ZMCOcHBFeGB7MnzH31SAnDzYYsSdg=='
WHERE MEMBER_NO ='1';

commit;

UPDATE MEMBER SET
MEMBER_PW = 'ybuT5RE3Qb/bE69MynKRp21UqUH7gwxtO8uOGrOsKqgPt95nPzymK/si9YTYCIxP0CfaqS2StvpiQ0W5UwyCVg=='
WHERE MEMBER_NO ='2';

commit;

UPDATE MEMBER SET
MEMBER_PW = 'iplxewLli7qPQF+vVHtB4loDo/E9Zw9efFh7eEh1NI+MrrMXTVqtmYEe/HBLnduhQ2VTnkV+2AkVdHiNnxR8mg=='
WHERE MEMBER_NO ='22';

-- 회원 정보 수정
UPDATE MEMBER SET
MEMBER_NICK = ?,
MEMBER_TEL = ?,
MEMBER_ADDR = ?

WHERE MEMBER_NO = ?;

-- 비밀번호 수정
UPDATE MEMBER SET
MEMBER_PW = ?
WHERE MEMBER_NO = ?
AND MEMBER_PW =?;

-- 회원 탈퇴
UPDATE MEMBER SET SECESSION_FL ='Y'
WHERE MEMBER_NO= ? 
AND MEMBER_PW =?;

commit;

-- 이메일 중복 검사
SELECT COUNT(*) FROM MEMBER
WHERE MEMBER_EMAIL = 'user01@kh.or.kr'
AND SECESSION_FL ='N';

-- 닉네임 중복 검사
-- 중복 되면 1 , 아니면 0
SELECT COUNT(*) FROM MEMBER
WHERE MEMBER_NICK = ?
AND SECESSION_FL = 'N';

-- 이메일이 일치하는 회원 정보 조회
SELECT MEMBER_EMAIL,MEMBER_NICK,MEMBER_TEL,MEMBER_ADDR,
    TO_CHAR( ENROLL_DT, 'YYYY"년" MM"월" DD"일"') AS ENROLL_DATE
FROM MEMBER
WHERE MEMBER_EMAIL = 'user01@kh.or.kr'
AND SECESSION_FL = 'N';

-- 회원 목록 조회(회원 번호, 이메일, 닉네임)
SELECT MEMBER_NO, MEMBER_EMAIL,MEMBER_NICK FROM MEMBER
WHERE SECESSION_FL ='N'
ORDER BY MEMBER_NO;


--------------------2023.07.17 ERDCLOUD-------------------------------

-- ""가 없으면, 테이블명, 컬럼명, 시퀀스명 등을 무조건 대문자로 저장
-- ""가 있으면 대소문자로 구분

-- 게시판 종류 

DROP TABLE "BOARD_TYPE";

CREATE TABLE "BOARD_TYPE" (
	"BOARD_CD"	NUMBER		PRIMARY KEY,
	"BOARD_NM"	VARCHAR2(50)		NOT NULL
);

COMMENT ON COLUMN "BOARD_TYPE"."BOARD_CD" IS '게시판 코드';

COMMENT ON COLUMN "BOARD_TYPE"."BOARD_NM" IS '게시판 이름';


-- 게시판 (게시글 저장 테이블)
DROP TABLE "BOARD";

CREATE TABLE "BOARD" (
	"BOARD_NO"	NUMBER		NOT NULL,
	"BOARD_TITLE"	VARCHAR2(150)		NOT NULL,
	"BOARD_CONTENT"	VARCHAR2(4000)		NOT NULL,
	"CREATE_DT"	DATE	DEFAULT SYSDATE	NOT NULL,
	"UPDATE_DT"	DATE		NULL,
	"READ_COUNT"	NUMBER	DEFAULT 0	NOT NULL,
	"BOARD_ST"	CHAR(1)	DEFAULT 'N'	NOT NULL,
	"MEMBER_NO"	NUMBER		NOT NULL,
	"BOARD_CD"	NUMBER		NOT NULL
);

COMMENT ON COLUMN "BOARD"."BOARD_NO" IS '게시글번호(시퀀스)';
COMMENT ON COLUMN "BOARD"."BOARD_TITLE" IS '게시글제목';
COMMENT ON COLUMN "BOARD"."BOARD_CONTENT" IS '게시글내용';
COMMENT ON COLUMN "BOARD"."CREATE_DT" IS '작성일';
COMMENT ON COLUMN "BOARD"."UPDATE_DT" IS '마지막수정일';
COMMENT ON COLUMN "BOARD"."READ_COUNT" IS '조회수';
COMMENT ON COLUMN "BOARD"."BOARD_ST" IS '게시글상태(정상N,삭제Y)';
COMMENT ON COLUMN "BOARD"."MEMBER_NO" IS '작성자 회원 번호';
COMMENT ON COLUMN "BOARD"."BOARD_CD" IS '게시판 코드';

-- BOARD 테이블 제약조건 추가
ALTER TABLE BOARD
ADD PRIMARY KEY(BOARD_NO); -- 제약조건명 생략(SYS_XXXX)

ALTER TABLE BOARD
ADD CONSTRAINT "FK_BOARD_CD" -- 제약 조건명 지정
FOREIGN KEY("BOARD_CD") -- BOARD의 BOARD_CODE 컬럼에 FK 지정
REFERENCES "BOARD_TYPE"; -- 참조할 테이블

ALTER TABLE BOARD
ADD CONSTRAINT "CHK_BOARD_ST"
CHECK("BOARD_ST" IN('N','Y'));

ALTER TABLE BOARD
ADD CONSTRAINT "FK_BOARD_MEMBER"
FOREIGN KEY("MEMBER_NO")
REFERENCES MEMBER;

-- BOARD_NO용 시퀀스
CREATE SEQUENCE SEQ_BOARD_NO
       INCREMENT BY 1 -- 증가값
       START WITH 1 -- 시작값
       MINVALUE 1; -- 최솟값
       
-- BOARD_TYPE 데이터 삽입
INSERT INTO BOARD_TYPE VALUES(1,'공지사항');
INSERT INTO BOARD_TYPE VALUES(2,'자유 게시판');
INSERT INTO BOARD_TYPE VALUES(3,'질문 게시판');

-- BOARD 테이블 샘플 데이터 삽입(PL / SQL)

SELECT * FROM MEMBER;
BEGIN
    FOR I IN 1..500 LOOP
        
        INSERT INTO BOARD
        VALUES(SEQ_BOARD_NO.NEXTVAL,
               SEQ_BOARD_NO.CURRVAL || '번째 게시글',
               SEQ_BOARD_NO.CURRVAL || '번째 게시글 내용입니다.',
               DEFAULT,DEFAULT,DEFAULT,DEFAULT,1,3
               
        );
        
    END LOOP;
END;
/

-- 공지사항 게시판 조회
SELECT COUNT(*) FROM BOARD WHERE BOARD_CD= 1;

-- 자유 게시판 조회
SELECT COUNT(*) FROM BOARD WHERE BOARD_CD= 2;

-- 질문 게시판 조회
SELECT COUNT(*) FROM BOARD WHERE BOARD_CD= 3;

-- 게시판 이름 조회
SELECT BOARD_NM FROM BOARD_TYPE
WHERE BOARD_CD =2;

-- 특정 게시판의 전체 게시글 수 조회
-- (단, 삭제글은 제외)
SELECT COUNT(*) FROM BOARD
WHERE BOARD_CD =1
AND BOARD_ST = 'N';

-- 특정 게시판에서 일정한 범위의 목록 조회
SELECT * FROM(
    SELECT ROWNUM RNUM, A.* FROM(
        SELECT BOARD_NO, BOARD_TITLE, MEMBER_NICK, 
              TO_CHAR(CREATE_DT, 'YYYY-MM-DD')AS CREATE_DT
              ,READ_COUNT FROM BOARD
        JOIN MEMBER USING(MEMBER_NO)
        WHERE BOARD_CD = 2
        AND BOARD_ST = 'N'
        ORDER BY BOARD_NO DESC
    ) A
)
WHERE RNUM BETWEEN 1 AND 10;

-- 게시판 이미지 테이블 생성
CREATE TABLE BOARD_IMG(
    IMG_NO NUMBER PRIMARY KEY,
    IMG_RENAME VARCHAR2(500) NOT NULL,
    IMG_ORIGINAL VARCHAR2(500) NOT NULL,
    IMG_LEVEL NUMBER NOT NULL,
    BOARD_NO NUMBER REFERENCES BOARD
);

COMMENT ON COLUMN BOARD_IMG.IMG_NO IS '이미지 번호';
COMMENT ON COLUMN BOARD_IMG.IMG_RENAME IS '이미지 저장 경로 + 변경명';
COMMENT ON COLUMN BOARD_IMG.IMG_ORIGINAL IS '이미지 원본명';
COMMENT ON COLUMN BOARD_IMG.IMG_LEVEL IS '이미지위치 저장 번호';
COMMENT ON COLUMN BOARD_IMG.BOARD_NO IS '게시글 번호';

-- 이미지 번호 시퀀스 생성
CREATE SEQUENCE SEQ_IMG_NO NOCACHE;

-- 샘플 데이터
INSERT INTO BOARD_IMG VALUES(
    SEQ_IMG_NO.NEXTVAL,'/resources/images/board/sample1.jpg', 'cat1.jpg',0,500
);
INSERT INTO BOARD_IMG VALUES(
    SEQ_IMG_NO.NEXTVAL,'/resources/images/board/sample2.jpg', 'cat2.jpg',1,500
);
INSERT INTO BOARD_IMG VALUES(
    SEQ_IMG_NO.NEXTVAL,'/resources/images/board/sample3.jpg', 'cat3.jpg',3,500
);
INSERT INTO BOARD_IMG VALUES(
    SEQ_IMG_NO.NEXTVAL,'/resources/images/board/sample4.jpg', 'cat4.jpg',4,500
);
INSERT INTO BOARD_IMG VALUES(
    SEQ_IMG_NO.NEXTVAL,'/resources/images/board/sample5.jpg', 'cat5.jpg',5,500
);

COMMIT;


