import logo from "./logo.svg";
import "./App.css";
import onClickTest from "./Event/01onClick";
import onMouseTest from "./Event/02onMouse";
import onKeyTest from "./Event/03onKey";
import onChangeTest from "./Event/04onChange";
import onFormTest from "./Event/05formEvent";
import onScrollTest from "./Event/06onScroll";

function App() {
  return (
      <div className="App">
        {/* 01 Onclick */}
        <onClickTest.MyComponent />
        <hr />
        {/* 01 OnMouse */}
        <onMouseTest.MyComponent1 />
        <onMouseTest.MyComponent2 />
        <hr />
        {/* 01 onKeyboard */}
        <onKeyTest.MyComponent1 />
        <onKeyTest.MyComponent2 />
        <onKeyTest.MyComponent3 />
        <hr />
        {/* 01 onChange */}
        <onChangeTest.MyComponent />
        <hr />
        {/* 01 onForm */}
        <onFormTest.MyComponent />
        <hr />
        {/* 01 onScroll */}
        <onScrollTest.MyComponent />
      </div>
  );
}

export default App;
