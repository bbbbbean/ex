// 상태 정보 저장
import { useState,useContext } from "react";
import Son_01 from './Son_01';

// useContext가 있어야 값 꺼내올 수 있음
import MyContext from "./MyContext";

const Parent_01 = ()=>{
    // 상위 컴포넌트에서 하위 컴포넌트로 전달 (props 사용)
    const [name, setName] = useState('자식으로 전달할 상태값');
    const {globalState, setGlobalState} = useContext(MyContext);    // provider에서 관리하는 상태값
    return(
        <div>
            <h1>parent_01</h1>
            전역 변수 : {globalState} <br/>
            전역 변수 변경 : <button onClick={(e)=>{setGlobalState('parent_01에서 변경')}}>변경하기</button>
            <hr/>
            <Son_01 name={name}/>
        </div>
    )
}

export default Parent_01;