const inputId = document.getElementById("inputId");
const regExp = /^[a-z](\d|\w|\-|_){5,13}$/;
inputId.addEventListener("keyup", function(){

    if(regExp.test(inputId.value)){
        this.style.backgroundColor = "green";
    } else{
        this.style.background = "red";
        this.style.color = "white";
    }
});

const inputPw = document.getElementById("inputPw");
const inputPwConfirm = document.getElementById("inputPwConfirm");

inputPwConfirm.addEventListener("keyup", function(){
    if(inputPw.value.length == 0){
        this.value = "";
        alert("비밀번호를 입력해주세요");
        inputPw.focus();
    }
});
const pwMessage = document.getElementById("pwMessage");

inputPw.addEventListener("keyup", function(){

    if( (inputPw.value == inputPwConfirm.value) && inputPw.value.length != 0  ){
        pwMessage.innerText = "비밀번호 일치";
        pwMessage.classList.add("confirm");
        pwMessage.classList.remove("error");

    } else{
        pwMessage.innerText = "비밀번호 불일치";
        pwMessage.classList.add("error");
        pwMessage.classList.remove("confirm");
    }

    if( inputPw.value.length == 0 && inputPwConfirm.value.length == 0 ){
        pwMessage.innerText = "";
    }
});

inputPwConfirm.addEventListener("keyup", function(){

    if( (inputPw.value == inputPwConfirm.value) && inputPw.value.length != 0  ){
        pwMessage.innerText = "비밀번호 일치";
        pwMessage.classList.add("confirm");
        pwMessage.classList.remove("error");

    } else{
        pwMessage.innerText = "비밀번호 불일치";
        pwMessage.classList.add("error");
        pwMessage.classList.remove("confirm");
    }

    if( inputPw.value.length == 0 && inputPwConfirm.value.length == 0 ){
        pwMessage.innerText = "";
    }
});


const inputName = document.getElementById("inputName");
const nameMessage = document.getElementById("nameMessage");
inputName.addEventListener("keyup", function(){
    const regExp = /^[가-힣]{2,5}$/;

    if(regExp.test(inputName.value)){
        nameMessage.innerText =  "정상입력";
        nameMessage.style.color = "green";

    } else {
        nameMessage.innerText =  "한글만 입력하세요";
        nameMessage.style.color = "red";
    }

    if(inputName.value.length == 0){
        nameMessage.innerText =  "";
    }
})

function validate(){

    const gender = document.getElementsByName("gender");
    
    //값이 많으면 for문으로
    if(!gender[0].checked && !gender[1].checked){
        alert("성별을 선택해주세요")

        return false;
    }

    const tel = document.getElementById("inputTel");
    const regExp = /^[0][0-9]{1,2}-[0-9]{3,4}-[0-9]{4}$/
    
    if(tel.value.length == 0){
        alert("전화번호를 입력해주세요.")
        return false;
    }
    
    if(!regExp.test(tel.value)){
        alert("전화번호의 형식 올바르지 않습니다");
        return false;
    }
    
    // 전화번호를 입력하지 않았을 떄
    // "전화번호를 입력해주세요" 경고창 출력
    
    
    








}