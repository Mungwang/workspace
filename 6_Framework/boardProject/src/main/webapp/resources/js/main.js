const loginFrm = document.getElementById("loginFrm");

const memberEmail = document.querySelector("#loginFrm input[name='memberEmail']");
const memberPw = document.querySelector("#loginFrm input[name='memberPw']");

if(loginFrm != null){
    
    // 로그인 시도를 할 때
    loginFrm.addEventListener("submit", e=> {
        // alert("로그인")
        
        // preventDefault : form ,a 기본 이벤트 제거
        // e.preventDefault(); 

        // 이메일이 입력되지 않은 경우
        if(memberEmail.value.trim().length == 0){

            alert("이메일을 입력해주세요.")
            memberEmail.value="";  // 잘못 입력된 값(공백) 제거
            memberEmail.focus();   // 이메일 input태그에 초점 맞춤
            e.preventDefault();    // 제출 못하게 하기
            return;               
         
        }

        if(memberPw.value.trim().length == 0){

            alert("비밀번호를 입력해주세요.")
            memberPw.value="";  // 잘못 입력된 값(공백) 제거
            memberPw.focus();   // 이메일 input태그에 초점 맞춤
            e.preventDefault(); // 제출 못하게 하기
            return;
           
        }

    })

}

// 비동기로 이메일이 일치하는 회원의 닉네임 조회
function selectNickname(email){

    fetch("/selectNickname?email="+ email) 
        // 지정된 주소로 GET방식 비동기 요청(ajax)
        // 전달하고자 하는 파라미터를 주소 뒤 쿼리스트링으로 추가

    .then(response => response.text()) // 요청에 대한 응답 객체(response)를 필요한 형태로 파싱
 
    .then(nickname => {console.log(nickname)}) // 첫 번째 then에서 파싱한 데이터를 이용한 동작 작성

    .catch(e => {console.log(e)}) // 예외 발생시 처리할 내용을 작성

}

// 닉네임이 일치하는 회원의 전화번호 조회
const inputNickname = document.getElementById("inputNickname")
const btn1 = document.getElementById("btn1")
const result1 = document.getElementById("result1")

btn1.addEventListener("click", e=>{

    // fetch() API를 이용해서 ajax(비동기 통신)

    // GET 방식 요청(파라미터를 쿼리스트링으로 추가)
    fetch("/selectMemberTel?nickname="+ inputNickname.value)
    .then(resp => resp.text() )

    // resp : 응답 객체
    // resp.text() : 응답 객체 내용을 문자열로 변환하여 반환
    // tel : 파싱되어 반환된 값이 저장된 변수
    .then( tel => {
        /* 비동기 요청 후 수행할 코드 */
        result1.innerText = tel; // 조회 결과를 result1에 출력

    })

    .catch(err => console.log(err));
    // 에러 발생시 콘솔에 출력

});


// fetch() API를 이용한 POST 방식 요청

// 이메일을 입력 받아 일치하는 회원의 정보를 모두 조회
const inputEmail = document.getElementById("inputEmail");
const btn2 = document.getElementById("btn2");
const result2 = document.getElementById("result2");

btn2.addEventListener("click", ()=>{

    // POST 방식 비동기 요청   ** key값은 문자열밖에 없다고 생각해서 생략해도 '' 붙은걸로 인식 **
                           // ** json은 자바스크립트 객체를 문자열로 바꾼것 **

    // JSON.stringify() : JS객체 -> JSON
    // JSON.parse()     : JSON -> JS객체

    fetch("/selectMember",{
        method : "POST",
        headers : {"Content-Type" : "application/json"},
        body : JSON.stringify({"email" : inputEmail.value}) // 자바스크립트 객체
    })

    .then( resp => resp.json()) // 응답 객체를 매개변수로 얻어와서 파싱

    .then( member => {
        console.log(member);

    }) // 파싱한 데이터를 이용해서 비동기 처리 후 동작

    .catch( err => console.log(err))
    // .catch( (err) => {return console.log(err)}) // 이게 *정석*  매개변수 1개만있을때 생략가능 or 객체가아니라면 생략가능
    

})

