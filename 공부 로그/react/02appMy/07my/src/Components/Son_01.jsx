import { useContext } from "react";
import MyContext from "./MyContext";

// 모든 부모가 전달하는 것은 props로 받을 수 있음
// props 대신 {name}형태 가능
// const Son_01 = ({name})=>{
// 부모로부터 전달된 내용 확인 : {name}
const Son_01 = (props)=>{
    const {globalState, setGlobalState} = useContext(MyContext); 
    return(
        <div>
            <h1>Son_01</h1>
            전역 변수 : {globalState} <br/>
            전역 변수 변경 : <button onClick={(e)=>{setGlobalState('son_01에서 변경')}}>변경하기</button><br/>
            부모로부터 전달된 내용 확인 : {props.name}
        </div>
    )
}

export default Son_01;