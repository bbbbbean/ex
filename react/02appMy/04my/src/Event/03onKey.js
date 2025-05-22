// keydown
function handleKeyDown(event) {
  console.log("key down!", event.keyCode);
}

function MyComponent1() {
  return <div>Key Down : <input type="text" onKeyDown={handleKeyDown} /></div>;
}

//keyup
function handleKeyUp(event) {
  console.log("key up! ", event.keyCode);
}

function MyComponent2() {
  return <div>Key up : <input type="text" onKeyUp={handleKeyUp} /></div>;
}

//keypress
function handleKeyPress(event) {
  console.log("key pressed! key : ", event.key);
}

function MyComponent3() {
  return <div>Key press : <input type="text" onKeyPress={handleKeyPress} /></div>;
}

export default {
  MyComponent1,
  MyComponent2,
  MyComponent3,
};
