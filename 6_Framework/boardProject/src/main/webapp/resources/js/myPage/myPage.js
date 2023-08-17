// 내 정보(수정) 페이지

const memberNickname = document.getElementById("memberNickname");
const memberTel = document.getElementById("memberTel");
const updateInfo = document.getElementById("updateInfo");


const updateObj ={"memberNickname":false,"memberTel":false}

// 내 정보 수정 form태그가 존재할 때 (내 정보 페이지)
if(updateInfo !=null){
    
    // *전역변수*로 수정 전 닉네임/ 전화번호를 저장
    initNickname = memberNickname.value;
    initTel = memberTel.value;

    // 닉네임 유효성 검사
    memberNickname.addEventListener("input",e=>{

        // 변경전 닉네임과 입력 값이 같을 경우
        if(initNickname == memberNickname.value){
            memberNickname.removeAttribute("style");
            return;
        }

        // 정규 표현식으로 유효성 검사
        const regEx = /^[가-힣\d\w]{2,10}$/

        if(regEx.test(memberNickname.value)){
            memberNickname.style.color ="green"

            updateObj.memberNickname = true;
            return;


        }else{
            memberNickname.style.color ="red"
            updateObj.memberNickname = false;
        }



    });

     // 전화번호 유효성 검사
     memberTel.addEventListener("input",e=>{

        // 변경 전 전화번호와 입력 값이 같을 경우
        if(initTel == memberTel.value){
            memberTel.removeAttribute("style");
            return;
        }


        // 정규 표현식으로 유효성 검사
        const regEx =/^0(1[01679]|2|[3-6][1-5]|70)\d{3,4}\d{4}$/;

        if(regEx.test(memberTel.value)){

            memberTel.style.color ="green"
            updateObj.memberTel = true;

        }else{

            memberTel.style.color ="red"
            updateObj.memberTel = false;
        }

     });
    
     // form태그 제출시 유효하지 않은 값이 있으면 제출 X
     updateInfo.addEventListener("submit", e=>{

        for(let key in updateObj){

            if(!updateObj[key]){

                switch(key){
                    case "memberNickname" : alert("닉네임이 유효하지않습니다."); break;
                    case "memberTel" : alert("전화번호가 유효하지않습니다."); break;
                }

                document.getElementById(key).focus();
                e.preventDefault();
                return;
            }
        }
     });

} // if end

// 비밀번호 변경 제출시
const currentPw = document.getElementById("currentPw");
const newPw = document.getElementById("newPw");
const newPwConfirm = document.getElementById("newPwConfirm");

const changePwFrm = document.getElementById("changePwFrm");

// 비밀번호 변경 페이지 인 경우
if(changePwFrm !=null){

    changePwFrm.addEventListener("submit",e=>{
        
        // 현재 비밀번호 미작성시
        if(currentPw.value.trim().length==0){
            alert("현재 비밀번호를 작성해주세요.")
            e.preventDefault();
            currentPw.value="";
            currentPw.focus();
            return;
        }
        
        // 비밀번호 유효성 검사
        const regEx =  /^[A-za-z0-9\!\@\#\-\_]{6,20}$/;

        if(!regEx.test(newPw.value)){
            alert("새 비밀번호 형식이 유효하지않습니다.")
            e.preventDefault();
            newPw.focus();
            return;
        } 
        
        // 비밀번호 == 비밀번호 확인
        if(newPw.value != newPwConfirm.value){
            alert("변경할 비밀번호가 일치하지않습니다")
            e.preventDefault();
            newPwConfirm.focus();
            return;
        }
    });  
}







