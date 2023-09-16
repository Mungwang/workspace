import React, { useState, useContext } from 'react';
import { TodoListContext } from './App';

const TodoList = () => {

    const { setTodoList ,loginMember, todoList } = useContext(TodoListContext);
    const [inputTodo, setInputTodo] = useState('');

    // 임의의 변수를 만들어 key값으로 사용하는걸 권장함!!
    let keyIndex = 0;

    // 할일 추가
    const handleAddTodo = () =>{

        // 입력 X
        if(inputTodo.trim().length === 0){
            alert("할 일을 입력해주세요");
            return;
        }

        fetch('/todo',{
            method : 'post',
            headers :  {'Content-Type' : 'application/json'},
            body : JSON.stringify({
                title : inputTodo,
                todoMemberNo : loginMember.todoMemberNo
            })
        })
        .then(resp => resp.text())
        .then(todoNo =>{

            if(Number(todoNo) === 0){ // 실패시 멈춤
                return;
            }

            // 기존 todoList + 새로 추가된 Todo를 이용해
            // 새 배열을 만들어
            // todoList에 대입

            // 새로 추가된 Todo 만들기
            const newTodo = {
                todoNo : todoNo, 
                title : inputTodo, 
                isDone : 'X', 
                todoMemberNo : loginMember.todoMemberNo
            };
            const newTodoList = [...todoList,newTodo];

            setTodoList(newTodoList);
            setInputTodo("");
        })
        .catch(e => console.log(e))

    }

    // O, X 업데이트
    const handleToggleTodo = (todo,index) =>{
        console.log(todo);
        console.log(index);
        
        fetch('/todo',{
            method : 'put',
            headers :  {'Content-Type' : 'application/json'},
            body : JSON.stringify({
                todoNo : todo.todoNo,
                isDone : todo.isDone === 'O'? 'X' : 'O'
            })
        })
        .then(resp => resp.text())
        .then( result =>{
            if(Number(result) === 0){ // 실패시 멈춤
                console.log('업데이트 실패');
                return;
            }
                
            // 수정 성공시 todoList 값을 변경해서 리렌더링
    
            // todoList를 깊은 복사(똑같은 배열을 하나 더 만듬)
            const newTodoList = [...todoList];
    
            // index번째 요스의 O,X를 반대로 변경
            newTodoList[index].isDone = newTodoList[index].isDone === 'O'? 'X' : 'O'; 
            
            setTodoList(newTodoList);

        })
        .catch(e => console.log(e));
        
    }

    // 삭제
    const handleDeleteTodo = (todoNo,index) =>{
        console.log(todoNo)
        // 배열.splice(인덱스,몇칸)
        // -> 배열의 인덱스 번째 요소 부터
        //    몇칸을 잘라내서 반환할지 지정

        fetch('/todo',{
            method : 'delete',
            headers :  {'Content-Type' : 'application/json'},
            body : todoNo
        })
        .then(resp => resp.text())
        .then( result =>{

            if(Number(result) === 0){ // 실패시 멈춤
                console.log('업데이트 실패');
                return;
            }

            const deleteTodoList = [...todoList];

            deleteTodoList.splice(index,1);

            setTodoList(deleteTodoList);

        })
        .catch(e => console.log(e));

    }


    return(
        <>
            <h1>{loginMember.name}의 Todo List</h1>
            <div className="todo-container">

                <h3>할 일(Todo) 입력</h3>
                <div>
                    <input type="text" value={inputTodo} onChange={e => setInputTodo(e.target.value)} />
                    <button onClick={handleAddTodo}>Todo 추가</button>
                </div>

                <ul>
                    {/* 배열.map : 기존 배열을 이용해서 새로운 배열 만들기 */}
                    {todoList.map((todo, index) => (
                        <li key={keyIndex++}>
                            <div>
                                <span className={todo.isDone === 'O' ? 'todo-compleate' : ''}> {todo.title} </span>

                                <span>
                                    <button onClick={() => { handleToggleTodo(todo, index) }}>{todo.isDone}</button>
                                    <button onClick={() => { handleDeleteTodo(todo.todoNo, index) }}>삭제</button>
                                </span>
                            </div>
                        </li>
                    ))}
                </ul>

            </div>
        
        </>
    )
};

export default TodoList;
