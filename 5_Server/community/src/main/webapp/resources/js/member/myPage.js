function infoValidate(){

    console.log("myPage.js loaded.");
    const nick = document.getElementsByName("memberNickname")[0];
    const tel = document.getElementsByName("memberTel")[0];

   
    // const regExp =/^\w(\w|\d|[가-힣]){9}$/;
    // const regExp1 =/^[01](0|1|7|6)[0-9]{8}$/

    /* 선생님 */
    const regExp1= /^[a-zA-z0-9가-힣]{2,10}$/
    const regExp2= /^0(1[01679]|2|[3-6][1-5]|70)\d{3,4}\d{4}$/

    if(nick.value.trim()==""){
        alert("닉네임을 입력해주세요")
        nick.focus();
        return false;
    }
    if(!regExp1.test(nick.value)){
        alert("닉네임은 영어/숫자/한글 2~10글자 사이로 작성해주세요")
        nick.focus();
        return false;
    }

    if(tel.value.trim()==""){
        alert("전화번호를 입력해주세요.(-제외)")
        tel.focus();
        return false;
    }
    if(!regExp2.test(tel.value)){
        /* alert("전화번호 형식이 올바르지 않습니다.")
        tel.focus();
        return false; */

        return printAlert(tel,"전화번호 형식이 올바르지 않습니다.");
    }


    return true; // true를 반환해서 form 제출 수행
}

// 경고 출력 + 포커스 + false 반환 함수
function printAlert(el, message){ // 매개변수 el 요소
    
    alert(message);
    el.focus();
    return false;

}
//--------------------------------------------------------------------//
/* 비밀번호 변경 */
function changePwValidate(){

    const pw = document.getElementById("currentPw");
    const newPw1 = document.getElementById("newPw1");
    const newPw2 = document.getElementById("newPw2");

    const regExp= /^[a-zA-z0-9!@#\-_]{6,30}$/

    if(pw.value.trim()==""){
        return printAlert(pw,"현재 비밀번호를 입력해주세요");
    }
    if(newPw1.value.trim()==""){
        return printAlert(newPw1,"새 비밀번호를 입력해주세요");
    }
    if(!regExp.test(newPw1.value)){
        return printAlert(newPw1,"영어, 숫자, 특수문자(!,@,#,-,_) 6~30글자 사이로 작성해주세요.");
    }
    if(newPw2.value.trim()==""){
        return printAlert(newPw2,"새 비밀번호 확인을 입력해주세요");
    }
    if(newPw1!==newPw2){
        alert("새 비밀번호가 일치하지않습니다")
        return false;
    }
}    
