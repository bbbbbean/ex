// 여러 컴포넌트 만들어 사용
// 외부에서 사용할 수 있는 형태

// 01 기본 JSX 요소 생성
export const Element1 = <h1>hello world - 1</h1>        // 바로 내보내기 잡을 수 있음
export const func1 = ()=>{return <h1>hello world - 1</h1>};    // 이걸 줄이면? 상단의 element1이 됨, 한줄짜리들은 생략가능한게 많았지..

// 02 function 예약어로 Export
export function Element2(){
    return <h2>hello world - 2</h2>
}

// 03 외부 인자 받기
export function Element3(props){
    if(props.auth === "ROLE_ADMIN"){
        return <h2>hello admin, name : {props.name}</h2>
    }
    if(props.auth === "ROLE_USER"){
        return <h2>hello user, name : {props.name}</h2>
    }
}

// 03-1 외부인자 받기(구조분해 할당) const {a,b} = props
// props 명칭을 생략하고 싶을 때
export function Element4({auth,name}){
    if(auth === "ROLE_ADMIN"){
        return <h2>hello admin, name : {name}</h2>
    }
    if(auth === "ROLE_USER"){
        return <h2>hello user, name : {name}</h2>
    }
}
// 화살표 함수도 됨
export const Element4_1  = ({auth,name}) => {
    if(auth === "ROLE_ADMIN") {
        return <h2>HELLO ADMIN , NAME : {name}</h2>
    }
    if(auth === "ROLE_USER") {
        return <h2>HELLO USER  , NAME : {name}</h2>
    }
}
