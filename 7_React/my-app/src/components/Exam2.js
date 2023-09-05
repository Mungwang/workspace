import React, { useState } from 'react';

// 함수형 컴포넌트
// 1. 함수 생성하기
// 2. return 구문에 출력하고 자하는 html 코드 작성
// 3. 만든 함수를 export default 지정하기
function Exam2(){

    const [count, setCount] = useState(100);
    // count라는 변수에 초기값 100 대입
    // count 값(상태)을 변경할 때는 setCount 함수를 이용

    const handleClick = () =>{           // setCount(()=> {return count -1})
        setCount(() => count -1) // 기본 화살표함수 모양 return이 한줄이고 반환값이 한개면 {} , return생략가능
        
    };

    return(
        <>
           <h2>함수영 컴포넌트</h2>
           <h1>Count : {count}</h1>
           <button onClick={handleClick}>Decrement</button>
        </>

    );   
}
export default Exam2;