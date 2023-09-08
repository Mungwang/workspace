import React, { useState , useContext } from 'react';
import UserContext from '../contexts/UserContext';


const User = () =>{

    // useContext(Context명) : 지정된 Context를 사용
    // -> 부모 컴포넌트에서 제공한 값을 꺼내쓸 수 있다
    const {user,temp} = useContext(UserContext) // user, temp
    // UserContext에서 user를 꺼내서 변수 user에 저장
    // UserContext에서 temp를 꺼내서 변수에 temp에 저장
    console.log(user);
    console.log(temp);


    return(
        <ul>
            <li>{user.name}</li>
            <li>{user.email}</li>
        </ul>
    );
}

const Profile =()=>{

    const [user, setUser] = useState(null);

    const print = () => {
        setUser({name : '김미영', email : 'my-kim@kh.or.kr'});
    }
    const temp = '임시변수';

    const hide = () =>{
        setUser(null);
    }

    return(
        /* UserContextr가 감싸고 있는 자식컴포넌트에게 
           Context API를 이용해서 user를 제공
        
        */
        <UserContext.Provider value={ {user,temp} }>
            <div>
                {/* 삼항 연산자 이용한 컴포넌트 랜더링 제어*/}
                {user !=null ? (
                    <>
                    <User/>
                    <button onClick={hide}>개인 정보 숨기기</button>
                    </>

                ) : (

                    <button onClick={print}>개인 정보 출력</button>
                )}

                


            </div>
        </UserContext.Provider>


    );


}
export default Profile;
