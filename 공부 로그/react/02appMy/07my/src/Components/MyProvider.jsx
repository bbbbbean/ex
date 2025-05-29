import {useState} from "react";
import AppContext from "./MyContext";

// children : props.children

// 전역 데이터 관리 부분
const MyProvider = ({children})=>{
    console.log(children);
    const [globalState, setGlobalState] = useState('asd'); // provider에서 관리하는 상태값
    const value = {globalState, setGlobalState} // object로 묶어 처리, 컴포넌트로 전달하기 위한 객체 생성
    return(
        // 하위 모든 요소에 값 전달 됨
        <AppContext.Provider value={value}> 
            {children}
        </AppContext.Provider>
    )
}

export default MyProvider;