console.log("main.js loaded.");

// 로그인 시 이메일(아아디)/비밀번호 입력 확인

// -> 미작성 시 alert() 이용해서 메세지를 출력하고
//    로그인 form태그의 제출을 막는 기본 이벤트 제거 진행

function loginValidate(){ // 로그인 유효성검사
    // validate : 유효하다
    // invalidate : 무효하다

    // 이메일 입력 input 요소 ***** name으로 얻어오면 배열로 얻어오는거라 인덱스 표시를 해줘야함 ******
    const inputEmail = document.getElementsByName("inputEmail")[0];

    // 비밀번호 입력 input 요소
    const inputPw = document.getElementsByName("inputPw")[0];

    // 이메일이 입력되지 않은 경우 false를 반환
    if(inputEmail.value.trim().length ==0){
        // 문자열.trim() : 문자열 양쪽 공백을 제거
        // 문자열.length : 문자열 길이 (몇글자?)

        alert("이메일을 입력해주세요.");
        inputEmail.value=""; // 이메일 input 입력된 내용을 모두삭제
        inputEmail.focus(); // 이메일 input에 포커스를 맞춰줌
        return false;
    }

    // 비밀번호를 입력하지 않은 경우 false 반환
    if(inputPw.value.trim() ==""){
        // 문자열.trim() : 문자열 양쪽 공백을 제거
        // 문자열.length : 문자열 길이 (몇글자?)

        alert("비밀번호를 입력해주세요.");
        inputPw.value=""; // pw input 입력된 내용을 모두삭제
        inputPw.focus(); // pw input에 포커스를 맞춰줌
        return false;
    }

    return true; // form 태그 기본 이벤트 정상 수행

}

// 아이디 저장 체크박스가 체크되었을 때 이벤트 처리

// redio, checkbox 체크 시 change 이벤트 발생

document.getElementById("saveId").addEventListener("change",function(){

    // 체크 여부 확인
    console.log(this.checked)
    // this : change 이벤트가 발생한 요소(체크박스)
    // 체크박스요소.checked : 체크 여부 반환(true/false)

    if(this.checked){ // 체크박스가 체크된 경우

        const str = "개인 정보 보호를 위해 개인 PC에서의 사용을 권장합니다.\n개인 PC가 아닌경우 취소를 눌러주세요."

        // confirm(str) 확인(true) / 취소(false) 대화상장
        
        if(!confirm(str)){ // 취소를 눌렀을 때
            this.checked = false; // 체크해제
        }
    }
})


// 회원 정보 조회 비동기 통신(AJAX)
document.getElementById("select1").addEventListener("click",function(){

    const input = document.getElementById("in1");
    const div = document.getElementById("result1");

    $.ajax({
        // /community/member/selectOne

        // /community/index.jsp

        url : "member/selectOne",
        data : {"memberEmail" : input.value},
        type : "POST",
        dataType : "JSON", // dataType : 응답데이터 형식을 지정
                           //  -> JSON으로 지정시 자동으로 JS객체로 전환
        success : function(member){
            console.log(member); // JS 객체 형태 문자열

            // JSON.parse(문자열) : 문자열 -> JS 객체로 변환
            // console.log(JSON.parse(member));

            div.innerText = ""

            if(member !=null){ // 회원 정보 존재 O

                // 1) div에 작성된 내용 모두 삭제

                // 2) ul 요소 생성
                const ul = document.createElement("ul");

                // 3) li 요소 생성 *5 + 내용추가
                const li1 = document.createElement("li");
                li1.innerText="이메일 : "+ member.memberEmail;

                const li2 = document.createElement("li");
                li2.innerText="닉네임 : "+ member.memberNickname;

                const li3 = document.createElement("li");
                li3.innerText="전화번호 : "+ member.memberTel;

                const li4 = document.createElement("li");
                li4.innerText="주소 : "+ member.memberAddress;

                const li5 = document.createElement("li");
                li5.innerText="가입일 : "+ member.enrollDate;

                // 4) ul에 li를 순서대로 추가

                ul.append(li1,li2,li3,li4,li5);

                // 5) div 에 ul 추가
                div.append(ul);

            }else{ // 회원 정보 존재 X
                // 1) h4 요소 생성
                const h4 = document.createElement("h4");
                // 2) 내용 추가
                h4.innerText="일치하는 회원이 없습니다";
                // 3) 색 추가
                h4.style.color= "red";
                // 4) div 에 추가
                div.append(h4);
            }


        },
        error : function(request, status, error){

            console.log("AJAX 에러발생");

            console.log("상태코드 : " + request.status); // 404,500

            console.log(request.responseText); // 에러 메세지

            console.log(error); // 에러 객체 출력


        }

    });

});


//-----------------------------------------------------------------------------

/* 일정 시간 마다 회원 목록 조회 */

function selectAll(){ // 회원 전체 조회 함수

    // ajax 코드
    $.ajax({
        url : "member/selectAll",
        dataType : "json", // 응답 데이터의 형식을 "json"으로 지정
                           // -> 자동으로 JS 객체로 변환됨
        success : function(memberInfo){
            console.log(memberInfo);

        },
        error : function(){
            console.log("에러 발생");
        }
        



    });

}

// 즉실 실행 함수
(function(){

    selectAll(); // 함수 호출 -> 회원 목록을 먼저 조회

    // window.setInterval(함수, 딜레이(ms))
    window.setInterval(selectAll,10000); // 10초
    // 함수 이름만 작성

})();