//01 mouseEnter
function handleMouseEnter(event) {
  console.log("mouse entered!");
}

function MyComponent1() {
  return (
    <div
      onMouseEnter={handleMouseEnter}
      style={{ width: "150px", height: "150px", border: "1px solid" }}
    >
      MouseEnter Test
    </div>
  );
}
//02 onMouseLeave
function handleMouseLeave(event) {
  console.log("mouse left!");
}

function MyComponent2() {
  return (
    <div
      onMouseLeave={handleMouseLeave}
      style={{ width: "150px", height: "150px", border: "1px solid" }}
    >
      MouseEnter Leave
    </div>
  );
}

export default {
  MyComponent1,
  MyComponent2,
};
