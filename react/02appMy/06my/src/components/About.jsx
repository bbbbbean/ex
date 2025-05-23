import {Link} from 'react-router-dom';
import { useLocation } from 'react-router-dom';

const About = () =>{
    // location 사용할 수 있게 설정
    const location = useLocation();
    const query = new URLSearchParams(location.search);

    return(
        <div>
            <nav>
                <ul>
                    <li><Link to="/">Home</Link></li>
                    <li><Link to="/about">About</Link></li>
                    <li><Link to="/contact/dfg/876">Contact</Link></li>
                </ul>
            </nav>
            <h1>About</h1>
            param : {query.get("name")}, {query.get("age")}
            <p>welcome</p>
        </div>
    );
}

export default About;