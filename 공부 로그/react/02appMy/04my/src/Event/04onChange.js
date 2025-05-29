import { useState } from "react";  
const MyComponent = ()=>{
  const[username,setUsername]=useState('');
  const[password,setPassword]=useState('');
  const handleUsernameChange = (event)=>{
    setUsername(event.target.value);
    console.log("username : ",event.target.value);
  }
  const handlePasswordChange = (event)=>{
    setPassword(event.target.value);
    console.log("password : ",event.target.value);
  }
  const handleSubmit = (event)=>{
    event.preventDefault();
    console.log("username : ",username,"password : ",password)
  }
  return (
    <form onSubmit={handleSubmit}>
      UserName : <input type="text" name="username" onChange={handleUsernameChange}/><br/>
      Password : <input type="password" name="password" onChange={handlePasswordChange}/><br/>
      <button type="submit">submit</button>
    </form>
  );
}
export default{
  MyComponent,
}
    