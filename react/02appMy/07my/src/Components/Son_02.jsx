

// 모든 부모가 전달하는 것은 props로 받을 수 있음
const Son_02 = ({name,handleNameChange})=>{
    
    return(
        <div>
            <h1>Son_02</h1>
            부모로부터 전달된 내용 자식에서 확인 : {name} <br/>
            <input type="text" placeholder="자식에서 부모로 보낼 값 입력" onChange={(e)=>{handleNameChange(e.target.value)}}/>
            <button>이름 변경</button>
        </div>
    )
}

export default Son_02;