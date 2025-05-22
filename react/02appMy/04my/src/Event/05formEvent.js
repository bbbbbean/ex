function handleSubmit(event) {
  event.preventDefault();
  console.log("form submitted!");
}
function MyComponent() {
  return (
    <form onSubmit={handleSubmit}>
      <input type="text" />
      <button type="submit">Submit</button>
    </form>
  );
}
export default {
  MyComponent,
};
