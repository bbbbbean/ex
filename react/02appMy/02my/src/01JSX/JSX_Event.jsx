// 이벤트 추가
// 클릭 이벤트
// 01
function handleClick_01(){
    console.log("clicked01");
}
export function Component_01(){
    return(
        <div>
            <h3>hello world01</h3>
            <button onClick={handleClick_01}>click me</button>
        </div>
    )
}

// 02
export function Component_02(){
    function handleClick_02(){
        console.log("clicked02");
    }
    return(
        <div>
            <h3>hello world02</h3>
            <button onClick={handleClick_02}>click me</button>
        </div>
    )
}

// 키보드 이벤트
// 03_down
export function Component_03(){
    function handleKey_down(event){
        console.log("keydown",event.key, event.target.value);
    }
    return(
        <div>
            <h3>key down event</h3>
            <input type="text" onKeyDown={handleKey_down}/>
        </div>
    )
}