// 클릭 시 클릭 카운팅을 버튼에 표시할 예정
// 훅? 리액트 기본 제공
import {useState,useEffect} from "react";
//  : 상태값을 외부로 보여줄 때

const MyComponent = () =>{
    // 일단 해보는 카운트, 비추천
    // 리액트는 훅??이라는게 있대 그거 사용
    //let count = 0;
    // const handleClick = ()=>{
    //     console.log("Button Click",setCount(count+1));
    // }

    // useState : component 내의 상태값을 유지할 때
    const [count,setCount] = useState(0);
    // 비동기 함수의 순서를 지정?
    const handleClick = () =>{
        setCount(count+1);
        // console.log("Button Click",count)
    }

    //useEffect(()=>{},상태값)
    // useEffect : component(여기서는 count)의 현재 상태 정보 변화 감지, 상태값 변화 감지
    // 여러 항목 감시 가능 : 배열로 넣기
    
    // 상태값을 비우면 처음 한번만 실행 : 최초 1회 실행
    useEffect(()=>{
        console.log('init setting');
    },[])
    // count state가 변경 될 때 마다 실행
    useEffect(()=>{
        console.log('count state changed',count);
    },[count])
    
    return(
        <div>
            <h1>Title</h1>
            <h2>Sub Title</h2>
            <hr/>
            <button onClick={handleClick}>Button Count : {count}</button>
        </div>
    )
}

export default MyComponent;