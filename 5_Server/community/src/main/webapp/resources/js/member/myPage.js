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
    if(newPw1.value!=newPw2.value){
        alert("새 비밀번호가 일치하지않습니다");
        return false;
    }
    
    return true;
}    
//-----------------------------------------------------------------//
/* 회원탈퇴 */

function secessionValidate() {

    const memberPw = document.getElementById("memberPw");
    const agree = document.getElementById("agree");

    if(memberPw.value.trim() == "") {
        return printAlert(memberPw, "비밀번호를 입력해주세요.");
    }
    if(!agree.checked) {
        return printAlert(agree, "약관 동의 후 탈퇴 버튼을 클릭해주세요");
    }

    // 정말 탈퇴할지 확인
    // - window.confirm("내용") : 대화 상자에 확인/취소 생성
    //      -> 확인 클릭시 true / 취소 클리식 false

    if(!confirm("정말 탈퇴 하시겠습니까?")){ // 취소를 눌렀을 때
        return false
    } 
    return true;
}

// 회원 프로필 이미지 변경(미리보기)
const inputImage = document.getElementById("input-image");

if(inputImage !=null){ // inputImage 요소가 화면에 존자할 때
    
    // input type="file" 요소는 파일이 선택 될 때 change 이벤트가 발생하다.
    inputImage.addEventListener("change", function(){
        console.log(this.files);

        // this : 이벤트가 발생할 요소(input type="file")

        // files : input type = "file"만 사용 가능한 속성으로
        //          선택된 파일 목록(배열)을 반환

        // console.log(this.files);
        // console.log(this.files[0]); // 파일목록에서 첫 번째 파일 객체를 선택

        if(this.files[0] != undefined){ // 파일이 선택되었을 때

            const reader = new FileReader();
            // 자바스크립트의 FileReader
            // - 웹 어플리케이션이 비동기적으로 데이터를 읽기 위하여 사용하는 객체

            reader.readAsDataURL(this.files[0]);
            // FileReader.readAsDataURL(파일)
            // - 지정된 파일의 내용을 읽기 시작함
            // - 읽어오는게 완료되면 result 속성 data:에
            //   읽어온 파일의 위치를 나타내는 URL이 포함된다.
            // -> 해당 URL을 이용해서 브라우저에 이미지를 볼수 있다.

            // FileReaer.onload = function(){}
            // - FileReader가 파일을 다 읽어온 경우 함수를 수행

            reader.onload = function(e){ // 고전이벤트 모델
                // e : 이벤트 발생 객체
                // e.target : 이벤트가 발생한 요소 -> FileReader
                // e.target.result : FileReader가 읽어온 파일의 URL

                // 프로필 이미지의 src 속성의 값을 FileReader가 읽어온 파일의 URL로 변경
                const profileImage = document.getElementById("profile-image");

                profileImage.setAttribute("src",e.target.result);
                // -> setAttribute() 호출 시 중복되는 속성이 존재하면 덮어쓰기

            }

        }

    
    });
}
