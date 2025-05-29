// 상태 정보 저장
import { useState, useContext } from "react";
import Son_02 from './Son_02';
import MyContext from "./MyContext";


// 하위 컴포넌트 -> 상위 컴포넌트 전달 (callBack 함수 전달)
const Parent_02 = ()=>{
    const {globalState, setGlobalState} = useContext(MyContext);
    const [name, setName] = useState('자식으로 전달할 상태값');
    const handleNameChange=(name)=>{
        setName(name);
    }
    return(
        <div>
            <h1>parent_02</h1>
            전역 변수 : {globalState} <br/>
            전역 변수 변경 : <button onClick={(e)=>{setGlobalState('parent_02에서 변경')}}>변경하기</button><br/>
            <hr/>
            <Son_02 name={name} handleNameChange={handleNameChange}/>
        </div>
    )
}

export default Parent_02;