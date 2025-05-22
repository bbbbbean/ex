import Basic01 from "./Condition/01Basic";

function App() {
  return (
    <div className="App">
      <Basic01.Component01 isAuth={true}/>
      <hr/>
      <Basic01.Component02 isAuth={true}/>
      <hr/>
      <Basic01.Component03 items={['a','f','g']}/>
    </div>
  );
}

export default App;
