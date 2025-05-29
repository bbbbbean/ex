function handleScroll(event) {
  console.log("scrolled! ",event.target.scrollTop);
}

function MyComponent() {
  return (
    <div
      style={{ height: "100px", overflow: "scroll" }}
      onScroll={handleScroll}
    >
      <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.</p>
      <p>Nullam pharetra velit id bibendum consectetur.</p>
      <p>Donec dignissim ante vel est molestie, at rutrum sapien euismod.</p>
    </div>
  );
}
export default {
  MyComponent,
};
