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

CREATE TABLE "BOARD" (
	"BOARD_NO"	NUMBER		NOT NULL,
	"BOARD_TITLE"	VARCHAR2(300)		NOT NULL,
	"BOARD_CONTENT"	VARCHAR2(4000)		NOT NULL,
	"BOARD_DT"	DATE	DEFAULT SYSDATE	NOT NULL,
	"BOARD_ST"	CHAR(1)	DEFAULT 'N'	NOT NULL,
	"REVIEW_STAR"	NUMBER		NULL,
	"BOARD_CD"	NUMBER		NOT NULL,
	"MEMBER_NO"	NUMBER		NOT NULL
);

COMMENT ON COLUMN "BOARD"."BOARD_NO" IS '게시글번호(시퀀스)';

COMMENT ON COLUMN "BOARD"."BOARD_TITLE" IS '게시글제목';

COMMENT ON COLUMN "BOARD"."BOARD_CONTENT" IS '게시글내용';

COMMENT ON COLUMN "BOARD"."BOARD_DT" IS '작성일';

COMMENT ON COLUMN "BOARD"."BOARD_ST" IS '게시글상태(정상N,삭제Y)';

COMMENT ON COLUMN "BOARD"."REVIEW_STAR" IS '별점';

COMMENT ON COLUMN "BOARD"."BOARD_CD" IS '게시판 코드';

COMMENT ON COLUMN "BOARD"."MEMBER_NO" IS '회원번호';

CREATE TABLE "BOARD_TYPE" (
	"BOARD_CD"	NUMBER		NOT NULL,
	"BOARD_NM"	VARCHAR2(100)		NOT NULL
);

COMMENT ON COLUMN "BOARD_TYPE"."BOARD_CD" IS '게시판 코드';

COMMENT ON COLUMN "BOARD_TYPE"."BOARD_NM" IS '게시판 이름';

CREATE TABLE "REPLY" (
	"REPLY_NO"	NUMBER		NOT NULL,
	"REPLY_CONTENT"	VARCHAR2(4000)		NOT NULL,
	"CREATE_DT"	DATE	DEFAULT SYSDATE	NOT NULL,
	"REPLY_ST"	CHAR(1)	DEFAULT 'N'	NOT NULL,
	"PARENT_NO"	NUMBER		NULL,
	"MEMBER_NO"	NUMBER		NOT NULL,
	"BOARD_NO"	NUMBER		NOT NULL
);

COMMENT ON COLUMN "REPLY"."REPLY_NO" IS '댓글 번호(시퀀스)';

COMMENT ON COLUMN "REPLY"."REPLY_CONTENT" IS '댓글 내용';

COMMENT ON COLUMN "REPLY"."CREATE_DT" IS '댓글 작성일';

COMMENT ON COLUMN "REPLY"."REPLY_ST" IS '댓글 상태(N,Y)';

COMMENT ON COLUMN "REPLY"."PARENT_NO" IS '부모 댓글 번호';

COMMENT ON COLUMN "REPLY"."MEMBER_NO" IS '회원번호';

COMMENT ON COLUMN "REPLY"."BOARD_NO" IS '게시글번호';

CREATE TABLE "BOARD_IMAGE" (
	"BOARD_IMG_NO"	NUMBER		NOT NULL,
	"BOARD_IMG_PATH"	VARCHAR2(4000)		NOT NULL,
	"BOARD_IMG_ORDER"	NUMBER		NOT NULL,
	"BOARD_NO"	NUMBER		NOT NULL,
	"BOARD_IMG_RENAME"	VARCHAR2(4000)		NULL
);

COMMENT ON COLUMN "BOARD_IMAGE"."BOARD_IMG_NO" IS '이미지 번호';

COMMENT ON COLUMN "BOARD_IMAGE"."BOARD_IMG_PATH" IS '이미지 저장 경로+ 변경명';

COMMENT ON COLUMN "BOARD_IMAGE"."BOARD_IMG_ORDER" IS '이미지 위치 지정 번호';

COMMENT ON COLUMN "BOARD_IMAGE"."BOARD_NO" IS '게시글번호(시퀀스)';

CREATE TABLE "PETSITTER" (
	"PETSITTER_NO"	NUMBER		NOT NULL,
	"LOCATION"	VARCHAR2(200)		NULL,
	"CAREER"	VARCHAR2(200)		NULL,
	"MEMBER_NO"	NUMBER		NOT NULL
);

COMMENT ON COLUMN "PETSITTER"."MEMBER_NO" IS '회원번호';

CREATE TABLE "BOOK" (
	"BOOK_NO"	NUMBER		NOT NULL,
	"BOOK_DATE"	DATE		NOT NULL,
	"BOOK_SRART_TIME"	DATE		NOT NULL,
	"BOOK_END_TIME"	DATE	NOT NULL,
	"PETSITTER_NO"	NUMBER		NOT NULL,
	"MEMBER_NO"	NUMBER		NOT NULL,
	"PRICE_NO"	NUMBER		NOT NULL
);

COMMENT ON COLUMN "BOOK"."BOOK_NO" IS '예약번호';

COMMENT ON COLUMN "BOOK"."BOOK_DATE" IS '예약일';

COMMENT ON COLUMN "BOOK"."BOOK_SRART_TIME" IS '이용 시작 시간';

COMMENT ON COLUMN "BOOK"."BOOK_END_TIME" IS '이용 종료 시간';

COMMENT ON COLUMN "BOOK"."PETSITTER_NO" IS '펫시터 번호';

COMMENT ON COLUMN "BOOK"."MEMBER_NO" IS '회원번호';

COMMENT ON COLUMN "BOOK"."PRICE_NO" IS '가격';

CREATE TABLE "PET" (
	"DOG_NO"	NUMBER		NOT NULL,
	"DOG_SIZE"	VARCHAR2(100)		NOT NULL,
	"MEMBER_NO"	NUMBER		NOT NULL
);

COMMENT ON COLUMN "PET"."DOG_NO" IS '객실 번호(시퀀스)';

COMMENT ON COLUMN "PET"."DOG_SIZE" IS '반려견 크기(소형, 중형, 대형)';

COMMENT ON COLUMN "PET"."MEMBER_NO" IS '회원번호';

CREATE TABLE "REPORT" (
	"MEMBER_NO"	NUMBER		NOT NULL,
	"PETSITTER_NO"	NUMBER		NOT NULL,
	"REPORT_CONTENT"	VARCHAR2(4000)		NULL
);

COMMENT ON COLUMN "REPORT"."MEMBER_NO" IS '회원번호';

CREATE TABLE "CHATTING" (
	"REVEIVER"	NUMBER		NOT NULL,
	"MESSAGE"	VARCHAR2(4000)		NOT NULL,
	"SENT_TIMESTAMP"	TIMESTAMP	DEFAULT SYSDATE	NOT NULL,
	"MEMBER_NO2"	NUMBER		NOT NULL
);

COMMENT ON COLUMN "CHATTING"."REVEIVER" IS '회원번호(시퀀스)';

COMMENT ON COLUMN "CHATTING"."MESSAGE" IS '회원번호(시퀀스)';

COMMENT ON COLUMN "CHATTING"."SENT_TIMESTAMP" IS '채팅방 생성일';

COMMENT ON COLUMN "CHATTING"."MEMBER_NO2" IS '회원번호';

CREATE TABLE "PRICE" (
	"PRICE_NO"	NUMBER		NOT NULL,
	"TIME"	VARCHAR2(300)		NOT NULL,
	"PRICE"	VARCHAR2(1000)		NOT NULL
);

COMMENT ON COLUMN "PRICE"."PRICE_NO" IS '가격';

COMMENT ON COLUMN "PRICE"."TIME" IS '시간';

COMMENT ON COLUMN "PRICE"."PRICE" IS '금액';

CREATE TABLE "LIKE" (
	"MEMBER_NO2"	NUMBER		NOT NULL,
	"PETSITTER_NO2"	NUMBER		NOT NULL
);

COMMENT ON COLUMN "LIKE"."MEMBER_NO2" IS '회원번호';

CREATE TABLE "APPLICATION_TYPE" (
	"APPLICATION_CD"	NUMBER		NOT NULL,
	"APPLICATION_NM"	VARCHAR2(100)		NOT NULL
);

COMMENT ON COLUMN "APPLICATION_TYPE"."APPLICATION_CD" IS '신청 코드';

COMMENT ON COLUMN "APPLICATION_TYPE"."APPLICATION_NM" IS '신청 이름';

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

ALTER TABLE "MEMBER" ADD CONSTRAINT "PK_MEMBER" PRIMARY KEY (
	"MEMBER_NO"
);

ALTER TABLE "BOARD" ADD CONSTRAINT "PK_BOARD" PRIMARY KEY (
	"BOARD_NO"
);

ALTER TABLE "BOARD_TYPE" ADD CONSTRAINT "PK_BOARD_TYPE" PRIMARY KEY (
	"BOARD_CD"
);

ALTER TABLE "REPLY" ADD CONSTRAINT "PK_REPLY" PRIMARY KEY (
	"REPLY_NO"
);

ALTER TABLE "BOARD_IMAGE" ADD CONSTRAINT "PK_BOARD_IMAGE" PRIMARY KEY (
	"BOARD_IMG_NO"
);

ALTER TABLE "PETSITTER" ADD CONSTRAINT "PK_PETSITTER" PRIMARY KEY (
	"PETSITTER_NO"
);

ALTER TABLE "BOOK" ADD CONSTRAINT "PK_BOOK" PRIMARY KEY (
	"BOOK_NO"
);

ALTER TABLE "PET" ADD CONSTRAINT "PK_PET" PRIMARY KEY (
	"DOG_NO"
);

ALTER TABLE "PRICE" ADD CONSTRAINT "PK_PRICE" PRIMARY KEY (
	"PRICE_NO"
);

ALTER TABLE "APPLICATION_TYPE" ADD CONSTRAINT "PK_APPLICATION_TYPE" PRIMARY KEY (
	"APPLICATION_CD"
);

ALTER TABLE "APPLICATION" ADD CONSTRAINT "PK_APPLICATION" PRIMARY KEY (
	"APPLICATION_NO"
);

-- 이메일인증
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

ALTER TABLE "AUTH_KEY" ADD CONSTRAINT "PK_AUTH_KEY" PRIMARY KEY (
   "AUTH_KEY_NO"
);


CREATE SEQUENCE SEQ_AUTH_KEY_NO NOCACHE;
CREATE SEQUENCE SEQ_MEMBER_NO NOCACHE;