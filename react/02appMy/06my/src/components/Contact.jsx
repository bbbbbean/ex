import {Link,useNavigate} from 'react-router-dom';
import {useParams} from 'react-router-dom';

const Contact = () =>{
    const {name,age} = useParams();

    const navigete = useNavigate();
    const handleHome = ()=>{
        console.log("Home")
        navigete("/")
    }
    const handleAbout = ()=>{
        console.log("About")
        navigete("/about?name=Hong&age=20")
    }
    const handleContact = ()=>{
        console.log("Contact")
        navigete("/contact")
    }
    
    return(
        <div>
            <nav>
                <ul>
                    <li><button onClick={handleHome}>Home</button></li>
                    <li><button onClick={handleAbout}>About</button></li>
                    <li><button onClick={handleContact}>Contact</button></li>
                </ul>
            </nav>
            <h1>Contact</h1>
            name : {name}, age : {age} <br/>
            <p>welcome</p>
        </div>
    );
}

export default Contact;