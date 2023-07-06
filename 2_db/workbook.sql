-- SQL01_SELECT(Basic)
--1
SELECT DEPARTMENT_NAME "학과 명", CATEGORY "계열"
FROM TB_DEPARTMENT;

--2
SELECT DEPARTMENT_NAME ||'의 정원은'|| CAPACITY ||'명 입니다.'"학과별 정원"
FROM TB_DEPARTMENT;

--3
SELECT STUDENT_NAME
FROM TB_STUDENT
WHERE DEPARTMENT_NO = (SELECT DEPARTMENT_NO FROM TB_DEPARTMENT WHERE DEPARTMENT_NAME = '국어국문학과')
AND SUBSTR(STUDENT_SSN,8,1) IN (2,4)
AND ABSENCE_YN = 'Y';

--4
SELECT STUDENT_NAME
FROM TB_STUDENT
WHERE STUDENT_NO IN ('A513079', 'A513090', 'A513091', 'A513110', 'A513119')
ORDER BY STUDENT_NAME DESC;

--5
SELECT DEPARTMENT_NAME, CATEGORY
FROM TB_DEPARTMENT
WHERE CAPACITY BETWEEN 20 AND 30;

--6
SELECT PROFESSOR_NAME
FROM TB_PROFESSOR
WHERE DEPARTMENT_NO IS NULL;

--7
SELECT STUDENT_NAME
FROM TB_STUDENT
WHERE DEPARTMENT_NO IN NULL;

--8
SELECT CLASS_NO
FROM TB_CLASS
WHERE PREATTENDING_CLASS_NO IS NOT NULL;

--9
SELECT CATEGORY
FROM TB_DEPARTMENT
GROUP BY CATEGORY;

--10
SELECT STUDENT_NO, STUDENT_NAME, STUDENT_SSN
FROM TB_STUDENT
WHERE STUDENT_NO LIKE 'A2%'
AND STUDENT_ADDRESS LIKE '%전주%'
AND ABSENCE_YN ='N';
---------------------------------------------------------------------------------------------------------------------------------
-- SQL02_SELECT(Function)

/* 1. 영어영문학과(학과코드 002) 학생들의 학번과 이름,입학년도를 입학년도가 빠른순으로 표시하는
 SQL 문장을 작성하시오.(단, 헤더는 "학번", "이름","입학년도"거 표시되록한다.)
*/

SELECT STUDENT_NO "학번", STUDENT_NAME "이름", TO_CHAR(ENTRANCE_DATE,'YYYY"-"MM"-"DD') "입학년도"
FROM TB_STUDENT
WHERE DEPARTMENT_NO = 002
ORDER BY 3;

/* 2. 춘 기술대학교의 교수 중 이름이 세글자가 아닌 교수가 한 명있다고 한다. 그 교수의 이름과
 주민번호를 화면에 출력하는 SQL 문장을 작성해보자.(*이때 올바르게 작성한 SQL문장의 결과 값이
 예상과 다르게 나올 수 있다. 원인이 무엇인지 생각해볼것 )
*/

SELECT PROFESSOR_NAME 교수이름, PROFESSOR_SSN 주민번호
FROM TB_PROFESSOR
WHERE LENGTH(PROFESSOR_NAME)!=3;

/* 3.춘 기술대학교의 남자 교수들의 이름과 나이를 출력하는 SQL문장을 작성하시오. 단 이때 나이가 적은
사람에서 많은 사람 순서로 화면에 출력 되도록만드시오.(단,교수 중 2000년 이후 출생자는 없으면 출력 헤더는
"교수이름","나이"로 한다. 나이는 '만'으로 계산한다.)
*/
SELECT SYSDATE FROM DUAL;
SELECT PROFESSOR_NAME,FLOOR((SYSDATE-TO_DATE(19||SUBSTR(PROFESSOR_SSN,1,6),'RRMMDD'))/365) 나이
FROM TB_PROFESSOR
WHERE SUBSTR(PROFESSOR_SSN,8,1) =1
ORDER BY 나이;

/* 4.교수들의 이름 중 성을 제외한 이름만 출력하는 SQL 문장을 작성하시오. 출력 헤더는 "이름"이 찍히도록한다
   (성이 2자인 경우교수는 없다고 가정하시오)
*/
SELECT SUBSTR(PROFESSOR_NAME,2,LENGTH(PROFESSOR_NAME)-1) 이름
FROM TB_PROFESSOR;

/* 5.춘 기술대학교의 재수생 입학자를 구하려고한다. 어떻게 찾아낼 것인가? 이때, 19살에
   입학하면 재수를 하지 않은것으로 간주한다.
*/
EXTRACT(YEAR FROM SYSDATE)-EXTRACT(YEAR FROM (TO_DATE(SUBSTR(EMP_NO,1,6),'RRMMDD')))"나이"
SELECT STUDENT_NO, STUDENT_NAME
FROM TB_STUDENT
WHERE EXTRACT(YEAR FROM ENTRANCE_DATE) - EXTRACT(YEAR FROM (TO_DATE(SUBSTR(STUDENT_SSN,1,6),'RRMMDD'))) >19;

-- 6.2020년 크리스마스는 무슨 요일인가?
SELECT TO_CHAR(TO_DATE('2020-12-25'),'DAY') FROM DUAL;

7. TO_DATE('99/10/11','YY/MM/DD') 2099년 10월11일
   TO_DATE('49/10/11','YY/MM/DD') 2049년 10월11일
   TO_DATE('99/10/11','RR/MM/DD') 1999년 10월11일
   TO_DATE('49/10/11','RR/MM/DD') 2049년 10월11일
   
/* 8.춘 기술대학교의 2000년도 이후 입학자들은 학번이 A로 시작하게 되어있다. 2000년도이전
     학번을 받은 학생들의 학번과 이름을 보여주는 SQL 문장을 작성하시오
*/

SELECT STUDENT_NO,STUDENT_NAME
FROM TB_STUDENT
WHERE STUDENT_NO LIKE '9%';

/* 9.학번이 A51718 인 한아름 학생의 학점 총 평점을 구하는 SQL문을 작성하시오. 단, 이때 출력화면의
   헤더는 "평점"이라고 찍히게 하고, 점수는 반올림하여 소수점 이하 한자리까지만 표시한다.
*/

SELECT ROUND(AVG(POINT),1) 평점
FROM TB_GRADE
WHERE STUDENT_NO='A517178';

-- 10.학과별 학생수를 구하여 "학과번호", "학생수(명)"의 형태로 헤더를 만들어 결과 값이 출력되도록하시오.
SELECT DEPARTMENT_NO 학과번호 ,COUNT(DEPARTMENT_NO) "학생수(명)"
FROM TB_STUDENT
GROUP BY DEPARTMENT_NO
ORDER BY DEPARTMENT_NO;

-- 11.지도 교수를 배정받지 못한 학생의 수는 몇명정도 되는지 알아내는 SQL문을 작성하시오.

SELECT COACH_PROFESSOR_NO
FROM TB_STUDENT;