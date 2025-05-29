// 컴포넌트 들고오기, 확장자 명은 생략
import {Element1,Element2} from "./01JSX/JSX_Basic";
import {Element3} from "./01JSX/JSX_Basic";
import {Element4,Element4_1} from "./01JSX/JSX_Basic";
import {Element5} from "./01JSX/JSX_Basic";

// 디폴트 지정을 하면 그냥 꺼내올 수 있음
import Default from "./01JSX/JSX_Basic";
import CustomComponent from "./01JSX/CustomComponent";

// 이벤트 확인
import {Component_01} from "./01JSX/JSX_Event"
import {Component_02} from "./01JSX/JSX_Event"
import {Component_03} from "./01JSX/JSX_Event"

function App() {
  // 여기는 함수 : 변수명 지정 가능
  const headerTitle = "Header Title";
  const mainContents = "main contents";
  return (
    <>
      <div className="App">
        hello 단일 문장은 소괄호() 필요없음<br></br>
        class 이름 쓸 때는 class가 아니라 className으로 지정 (class라 사용 시 console에 오류 확인 가능)
        <div className='header' style={{fontSize:"20px",color:"orange",fontWeight:800,backgroundColor:"lemonchiffon"}}>Header 변수를 쓰고 싶다면 중괄호로 감싸고 사용 {headerTitle}</div>
        <div className='main'>{mainContents}</div>
        <div style={{backgroundColor:"lemonchiffon",padding:"20px"}}>이벤트 확인
          <Component_01/>
          <hr/>
          <Component_02/>
          <hr/>
          <Component_03/>
        </div>
        <div className='footer'>
          <Element3 auth={"ROLE_ADMIN"} name={"이름"}/> 
          <Element3 auth={"ROLE_USER"} name={"이름"}/> 
          <hr/>
          <Element4 auth={"ROLE_ADMIN"} name={"이름"}/> 
          <Element4 auth={"ROLE_USER"} name={"이름"}/> 
          <hr/>
          <Element4_1 auth={"ROLE_ADMIN"} name={"이름"}/> 
          <Element4_1 auth={"ROLE_USER"} name={"이름"}/> 
          <hr/>
          <Element5 list={["aaa","bbb","ccc"]}/>
          <hr/>
          <Default.DefaultComponent1/>
          <Default.DefaultComponent2/>
          <hr/>
          <CustomComponent/>
        </div>
        <div>style 인라인으로 사용할 때 중괄호로 감싸기</div>
      </div>
      <div>상위 태그 하나에 가두지 않으면 오류 발생 <></> 빈태그로라도 감싸기</div>
      {Element1}
      <Element2/>
    </>
  );
}

export default App;
