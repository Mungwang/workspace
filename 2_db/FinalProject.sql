------------------------------------- 회원 테이블 ----------------------------------------

CREATE TABLE "MEMBER" (
	"MEMBER_NO"	NUMBER		NOT NULL,
	"MEMBER_NM"	VARCHAR2(30)		NOT NULL,
	"MEMBER_EMAIL"	VARCHAR2(100)		NOT NULL,
	"MEMBER_NICKNAME"	VARCHAR2(100)		NOT NULL,
	"MEMBER_PW"	VARCHAR2(100)		NOT NULL,
	"MEMBER_TEL"	VARCHAR2(30)		NOT NULL,
	"MEMBER_ADDRESS"	VARCHAR2(500)		NOT NULL,
	"ENROLL_DATE"	DATE	DEFAULT SYSDATE	NOT NULL,
	"SECESSION_FL"	CHAR(1)	DEFAULT 'N'	NOT NULL,
	"MEMBER_ADMIN"	CHAR(1)	DEFAULT 'N'	NOT NULL,
	"MEMBER_PETSITTER"	CHAR(1)	DEFAULT 'N'	NOT NULL,
	"PROFILE_IMG"	VARCHAR2(4000)		NULL
);

COMMENT ON COLUMN "MEMBER"."MEMBER_NO" IS '회원번호';

COMMENT ON COLUMN "MEMBER"."MEMBER_NM" IS '회원이름';

COMMENT ON COLUMN "MEMBER"."MEMBER_EMAIL" IS '이메일';

COMMENT ON COLUMN "MEMBER"."MEMBER_NICKNAME" IS '닉네임';

COMMENT ON COLUMN "MEMBER"."MEMBER_PW" IS '회원비밀번호';

COMMENT ON COLUMN "MEMBER"."MEMBER_TEL" IS '전화번호';

COMMENT ON COLUMN "MEMBER"."MEMBER_ADDRESS" IS '주소';

COMMENT ON COLUMN "MEMBER"."ENROLL_DATE" IS '가입일';

COMMENT ON COLUMN "MEMBER"."SECESSION_FL" IS '탈퇴(N,Y)';

COMMENT ON COLUMN "MEMBER"."MEMBER_ADMIN" IS '관리자(N,Y)';

COMMENT ON COLUMN "MEMBER"."MEMBER_PETSITTER" IS '펫시터(N,Y)';

COMMENT ON COLUMN "MEMBER"."PROFILE_IMG" IS '프로필 이미지';



-------------------------------------------------------------------------------------------

---------------------------------이메일 인증 테이블 -------------------------------------

CREATE TABLE "AUTH_KEY" (
   "AUTH_KEY_NO"   NUMBER      NOT NULL,
   "CODE"   CHAR(6)      NOT NULL,
   "EMAIL"   VARCHAR2(50)      NOT NULL,
   "CREATE_TIME"   DATE   DEFAULT SYSDATE   NOT NULL
);

COMMENT ON COLUMN "AUTH_KEY"."AUTH_KEY_NO" IS '인증키 구분 번호(SEQ_AUTH_KEY_NO)';

COMMENT ON COLUMN "AUTH_KEY"."CODE" IS '코드';

COMMENT ON COLUMN "AUTH_KEY"."EMAIL" IS '이메일';

COMMENT ON COLUMN "AUTH_KEY"."CREATE_TIME" IS '인증 코드 생성 시간';




------------------------------------------------------------------------------------------

--------------------------------------신청 종류 테이블 ---------------------------------

CREATE TABLE "APPLICATION_TYPE" (
	"APPLICATION_CD"	NUMBER		NOT NULL,
	"APPLICATION_NM"	VARCHAR2(100)		NOT NULL
);

COMMENT ON COLUMN "APPLICATION_TYPE"."APPLICATION_CD" IS '신청 코드';

COMMENT ON COLUMN "APPLICATION_TYPE"."APPLICATION_NM" IS '신청 이름';

------------------------------------------------------------------------------------------


--------------------------------------신청 테이블 ---------------------------------------
CREATE TABLE "APPLICATION" (
	"APPLICATION_NO"	NUMBER		NOT NULL,
	"APPLICATION_CONTENT"	VARCHAR2(4000)		NOT NULL,
	"APPLICATION_DT"	DATE	DEFAULT SYSDATE	NOT NULL,
	"APPLICATION_LOCATION"	VARCHAR2(300)		NULL,
	"APPLICATION_EX"	CHAR(1)		NULL,
	"MEMBER_NO"	NUMBER		NOT NULL,
	"APPLICATION_CD"	NUMBER		NOT NULL
);

COMMENT ON COLUMN "APPLICATION"."APPLICATION_NO" IS '신청 번호(시퀀스)';

COMMENT ON COLUMN "APPLICATION"."APPLICATION_CONTENT" IS '신청 내용';

COMMENT ON COLUMN "APPLICATION"."APPLICATION_DT" IS '신청일';

COMMENT ON COLUMN "APPLICATION"."APPLICATION_LOCATION" IS '신청지역';

COMMENT ON COLUMN "APPLICATION"."APPLICATION_EX" IS '반려경험';

COMMENT ON COLUMN "APPLICATION"."MEMBER_NO" IS '회원번호';

COMMENT ON COLUMN "APPLICATION"."APPLICATION_CD" IS '신청 코드';


------------------------------------------------------------------------------------------

---------------------------------------반려견 테이블 -----------------------------------

CREATE TABLE "PET" (
	"PET_NO"	 	NUMBER		NOT NULL,
	"MEMBER_NO"	NUMBER		NOT NULL,
	"PET_NM"	VARCHAR2(30)		NOT NULL,
	"PET_TYPE"	VARCHAR2(300)		NOT NULL,
	"PET_BIRTH"	VARCHAR2(300)		NOT NULL,
	"PET_GENDER"	VARCHAR2(30)		NOT NULL,
	"PET_PROFILE"	VARCHAR2(1000)		NULL,
	"PET_OPTION"	VARCHAR2(4000)		NULL
);

COMMENT ON COLUMN "PET"."DOG_NO" IS '반려견 번호(시퀀스)';

COMMENT ON COLUMN "PET"."MEMBER_NO" IS '회원번호';

COMMENT ON COLUMN "PET"."PET_NM" IS '반려견 이름';

COMMENT ON COLUMN "PET"."PET_TYPE" IS '품종';

COMMENT ON COLUMN "PET"."PET_BIRTH" IS '생년월';

COMMENT ON COLUMN "PET"."PET_GENDER" IS '성별';

COMMENT ON COLUMN "PET"."PET_PROFILE" IS '반려견 프로필 사진';

COMMENT ON COLUMN "PET"."PET_OPTION" IS '반려견 특이사항';


--------------------------------------------------------------------------------------------

-------------------------------------- 펫시터 테이블 ----------------------------------

CREATE TABLE "PETSITTER" (
   "PETSITTER_NO"   NUMBER      NOT NULL,
   "LOCATION"   VARCHAR2(200)      NULL,
   "PET_CAREER"   CHAR(1)      NOT NULL,
   "MEMBER_NO"   NUMBER      NOT NULL
);

COMMENT ON COLUMN "PETSITTER"."PETSITTER_NO" IS '펫시터번호(시퀀스)';

COMMENT ON COLUMN "PETSITTER"."LOCATION" IS '선호지역';

COMMENT ON COLUMN "PETSITTER"."PET_CAREER" IS '반려동물 경험';

COMMENT ON COLUMN "PETSITTER"."MEMBER_NO" IS '회원번호';


----------------------------------------------------------------------------------------

-------------------------------------- 게시판 코드 테이블 ----------------------------

CREATE TABLE "BOARD_TYPE" (
	"BOARD_CD"	NUMBER		NOT NULL,
	"BOARD_NM"	VARCHAR2(100)		NOT NULL
);

COMMENT ON COLUMN "BOARD_TYPE"."BOARD_CD" IS '게시판 코드';

COMMENT ON COLUMN "BOARD_TYPE"."BOARD_NM" IS '게시판 이름';


----------------------------------------------------------------------------------------

-------------------------------------- 게시판 테이블 ----------------------------------

CREATE TABLE "BOARD" (
	"BOARD_NO"	NUMBER		NOT NULL,
	"BOARD_TITLE"	VARCHAR2(300)		NOT NULL,
	"BOARD_CONTENT"	VARCHAR2(4000)		NOT NULL,
	"BOARD_DT"	DATE	DEFAULT SYSDATE	NOT NULL,
	"READ_COUNT"	NUMBER	DEFAULT 0	NOT NULL,
	"BOARD_ST"	CHAR(1)	DEFAULT 'N'	NOT NULL,
	"BOARD_CD"	NUMBER		NOT NULL,
	"MEMBER_NO"	NUMBER		NOT NULL
);

COMMENT ON COLUMN "BOARD"."BOARD_NO" IS '게시글번호(시퀀스)';

COMMENT ON COLUMN "BOARD"."BOARD_TITLE" IS '게시글제목';

COMMENT ON COLUMN "BOARD"."BOARD_CONTENT" IS '게시글내용';

COMMENT ON COLUMN "BOARD"."BOARD_DT" IS '작성일';

COMMENT ON COLUMN "BOARD"."READ_COUNT" IS '조회수';

COMMENT ON COLUMN "BOARD"."BOARD_ST" IS '게시글상태(정상N,삭제Y)';

COMMENT ON COLUMN "BOARD"."BOARD_CD" IS '게시판 코드';

COMMENT ON COLUMN "BOARD"."MEMBER_NO" IS '회원번호';



------------------------------------------------------------------------------------------

-------------------------------- 게시판 이미지 테이블 ----------------------------------
CREATE TABLE "BOARD_IMAGE" (
	"BOARD_IMG_NO"	NUMBER		NOT NULL,
	"BOARD_IMG_PATH"	VARCHAR2(4000)		NOT NULL,
	"BOARD_IMG_ORDER"	NUMBER		NOT NULL,
	"BOARD_IMG_RENAME"	VARCHAR2(4000)		NULL,
	"BOARD_NO"	NUMBER		NOT NULL
);

COMMENT ON COLUMN "BOARD_IMAGE"."BOARD_IMG_NO" IS '이미지 번호';

COMMENT ON COLUMN "BOARD_IMAGE"."BOARD_IMG_PATH" IS '이미지 저장 경로+ 변경명';

COMMENT ON COLUMN "BOARD_IMAGE"."BOARD_IMG_ORDER" IS '이미지 위치 지정 번호';

COMMENT ON COLUMN "BOARD_IMAGE"."BOARD_NO" IS '게시글번호(시퀀스)';



------------------------------------------------------------------------------------------

-------------------------------- 게시판 이미지 테이블 ----------------------------------
CREATE TABLE "SERVICE TYPE" (
	"SERVICE_NO"	NUMBER		NOT NULL,
	"SERVICE_TYPE"	VARCHAR2(300)		NOT NULL,
	"SERVICE_TIME"	VARCHAR2(300)		NOT NULL,
	"SERVICE_PRICE"	VARCHAR2(1000)		NOT NULL
);

COMMENT ON COLUMN "SERVICE TYPE"."SERVICE_NO" IS '서비스 번호';

COMMENT ON COLUMN "SERVICE TYPE"."SERVICE_TYPE" IS '타입';

COMMENT ON COLUMN "SERVICE TYPE"."SERVICE_TIME" IS '시간';

COMMENT ON COLUMN "SERVICE TYPE"."SERVICE_PRICE" IS '금액';

------------------------------------------------------------------------------------------

-------------------------------- 예약 테이블 ----------------------------------
CREATE TABLE "RESERVATION" (
	"RS_NO"	NUMBER		NOT NULL,
	"RS_DATE"	DATE		NOT NULL,
	"RS_START_DATE"	DATE		NOT NULL,
	"RS_ADDRESS"	VARCHAR2(4000)		NOT NULL,
	"PETSITTER_NO"	NUMBER		NOT NULL,
	"MEMBER_NO"	NUMBER		NOT NULL,
	"PETSITTER_ST"	CHAR(1)	DEFAULT 'N'	NOT NULL,
	"PAY_ST"	CHAR(1)	DEFAULT 'N'	NOT NULL,
	"SERVICE_ST"	CHAR(1)	DEFAULT 'N'	NOT NULL,
	"RS_PLACE"	VARCHAR2(4000)		NOT NULL,
	"SERVICE_NO"	NUMBER		NOT NULL
);

COMMENT ON COLUMN "RESERVATION"."RS_NO" IS '예약번호';

COMMENT ON COLUMN "RESERVATION"."RS_DATE" IS '방문 날짜';

COMMENT ON COLUMN "RESERVATION"."RS_START_DATE" IS '방문 시간';

COMMENT ON COLUMN "RESERVATION"."RS_ADDRESS" IS '방문 장소';

COMMENT ON COLUMN "RESERVATION"."PETSITTER_NO" IS '펫시터 번호';

COMMENT ON COLUMN "RESERVATION"."MEMBER_NO" IS '회원번호';

COMMENT ON COLUMN "RESERVATION"."PETSITTER_ST" IS '펫시터 수락 상태';

COMMENT ON COLUMN "RESERVATION"."PAY_ST" IS '결제 상태';

COMMENT ON COLUMN "RESERVATION"."SERVICE_ST" IS '서비스 완료 상태';

COMMENT ON COLUMN "RESERVATION"."RS_PLACE" IS '예약 장소';

COMMENT ON COLUMN "RESERVATION"."SERVICE_NO" IS '서비스 번호';

------------------------------------------------------------------------------------------

-------------------------------- 예약 반려견 목록 테이블 ----------------------------------

CREATE TABLE "RESERVATION PET" (
	"BOOK_NO"	NUMBER		NOT NULL,
	"PET_NO"	NUMBER		NOT NULL
);

COMMENT ON COLUMN "RESERVATION PET"."BOOK_NO" IS '예약번호';

COMMENT ON COLUMN "RESERVATION PET"."PET_NO" IS '반려견 번호(시퀀스)';
	
------------------------------------------------------------------------------------------

-------------------------------- 라이브 카드 테이블 ----------------------------------
CREATE TABLE "LIVE_CARD" (
	"LIVE_NO"	NUMBER		NOT NULL,
	"LIVE_IMAGE"	VARCHAR2(4000)		NOT NULL,
	"LIVE_CONTENT"	VARCHAR2(4000)		NOT NULL,
	"RS_NO"	NUMBER		NOT NULL
);

COMMENT ON COLUMN "LIVE_CARD"."LIVE_NO" IS '라이브 카드 번호';

COMMENT ON COLUMN "LIVE_CARD"."LIVE_IMAGE" IS '라이브 카드 이미지';

COMMENT ON COLUMN "LIVE_CARD"."LIVE_CONTENT" IS '라이브 카드 내용';

COMMENT ON COLUMN "LIVE_CARD"."RS_NO" IS '예약번호';
------------------------------------------------------------------------------------------

-------------------------------------- 신고 테이블 --------------------------------------
CREATE TABLE "REPORT" (
	"MEMBER_NO"	NUMBER		NOT NULL,
	"PETSITTER_NO"	NUMBER		NOT NULL,
	"REPORT_CONTENT"	VARCHAR2(4000)		NOT NULL,
	"REPORT_DATE"	DATE	DEFAULT SYSDATE	NOT NULL
);

COMMENT ON COLUMN "REPORT"."MEMBER_NO" IS '회원번호';

COMMENT ON COLUMN "REPORT"."PETSITTER_NO" IS '펫시터번호(시퀀스)';

COMMENT ON COLUMN "REPORT"."REPORT_CONTENT" IS '신고 내용';

COMMENT ON COLUMN "REPORT"."REPORT_DATE" IS '신고 날짜';

--------------------------------------------------------------------------------------------

--------------------------------------- 찜목록 테이블 ----------------------------------------

CREATE TABLE "WISH_LIST" (
	"MEMBER_NO"	NUMBER		NOT NULL,
	"PETSITTER_NO"	NUMBER		NOT NULL
);

COMMENT ON COLUMN "WISH_LIST"."MEMBER_NO" IS '회원번호';

COMMENT ON COLUMN "WISH_LIST"."PETSITTER_NO" IS '펫시터번호(시퀀스)';



------------------------------------------------------------------------------------------


--------------------------------------제약조건-------------------------------------------

-- MEMBER 테이블 PK 설정
ALTER TABLE "MEMBER" ADD CONSTRAINT "PK_MEMBER" PRIMARY KEY (
	"MEMBER_NO"
);

-- 이메일 인증 테이블 PK 설정
ALTER TABLE "AUTH_KEY" ADD CONSTRAINT "PK_AUTH_KEY" PRIMARY KEY (
   "AUTH_KEY_NO"
);

-- 신청 코드 테이블 PK 설정
ALTER TABLE "APPLICATION_TYPE" ADD CONSTRAINT "PK_APPLICATION_TYPE" PRIMARY KEY (
	"APPLICATION_CD"
);

-- 신청 테이블 PK 설정
ALTER TABLE "APPLICATION" ADD CONSTRAINT "PK_APPLICATION" PRIMARY KEY (
	"APPLICATION_NO"
);

-- 반려견 테이블 PK 설정
ALTER TABLE "PET" ADD CONSTRAINT "PK_PET" PRIMARY KEY (
	"PET_NO"
);

-- 펫시터 테이블 PK 설정
ALTER TABLE "PETSITTER" ADD CONSTRAINT "PK_PETSITTER" PRIMARY KEY (
   "PETSITTER_NO"
);

-- 게시판 코드 테이블 PK 설정
ALTER TABLE "BOARD_TYPE" ADD CONSTRAINT "PK_BOARD_TYPE" PRIMARY KEY (
	"BOARD_CD"
);

-- 게시판 테이블 PK 설정
ALTER TABLE "BOARD" ADD CONSTRAINT "PK_BOARD" PRIMARY KEY (
	"BOARD_NO"
);

-- 게시판 이미지 테이블 PK 설정
ALTER TABLE "BOARD_IMAGE" ADD CONSTRAINT "PK_BOARD_IMAGE" PRIMARY KEY (
	"BOARD_IMG_NO"
);

-- 예약 테이블 PK 설정
ALTER TABLE "RESERVATION" ADD CONSTRAINT "PK_RESERVATION" PRIMARY KEY (
	"RS_NO"
);

-- 예약 반려견 목록 테이블 복합키 설정
ALTER TABLE "RESERVATION PET" ADD CONSTRAINT "PK_RESERVATION PET" PRIMARY KEY (
	"BOOK_NO",
	"PET_NO"
);

ALTER TABLE "RESERVATION PET" ADD CONSTRAINT "FK_RESERVATION_TO_RESERVATION PET_1" FOREIGN KEY (
	"BOOK_NO"
)
REFERENCES "RESERVATION" (
	"RS_NO"
);

ALTER TABLE "RESERVATION PET" ADD CONSTRAINT "FK_PET_TO_RESERVATION PET_1" FOREIGN KEY (
	"PET_NO"
)
REFERENCES "PET" (
	"PET_NO"
);


-- 신고 테이블 복합키 및 PK 설정
ALTER TABLE "REPORT" ADD CONSTRAINT "FK_MEMBER_TO_REPORT_1" FOREIGN KEY (
	"MEMBER_NO"
)
REFERENCES "MEMBER" (
	"MEMBER_NO"
);

ALTER TABLE "REPORT" ADD CONSTRAINT "FK_PETSITTER_TO_REPORT_1" FOREIGN KEY (
	"PETSITTER_NO"
)
REFERENCES "PETSITTER" (
	"PETSITTER_NO"
);




--------------------------------------------------------------------------------------------

--------------------------------------- 시퀀스 번호 ----------------------------------------

CREATE SEQUENCE SEQ_MEMBER_NO NOCACHE; -- 멤버 넘버 시퀀스

CREATE SEQUENCE SEQ_AUTH_KEY_NO NOCACHE; -- 이메일 인증 번호 시퀀스 

CREATE SEQUENCE SEQ_PETSITTER_NO NOCACHE; -- 펫시터 번호 시퀀스

CREATE SEQUENCE SEQ_APPLICATION_NO NOCACHE; -- 신청 번호 시퀀스

CREATE SEQUENCE SEQ_PET_NO NOCACHE; -- 반려견 번호 시퀀스

CREATE SEQUENCE SEQ_BOARD_NO NOCACHE; -- 게시판 번호 시퀀스

CREATE SEQUENCE SEQ_BOARD_IMG_NO NOCACHE; -- 게시판 이미지 번호 시퀀스

CREATE SEQUENCE SEQ_SERVICE_NO NOCACHE; -- 서비스 형태 번호 시퀀스

CREATE SEQUENCE SEQ_RS_NO NOCACHE; -- 예약 번호 시퀀스

CREATE SEQUENCE SEQ_LIVE_NO NOCACHE; -- 라이브 카드 번호 시퀀스


--------------------------------------------------------------------------------------------