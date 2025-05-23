import {Link} from 'react-router-dom';

// 기본 페이지
const Home = () => {
    return(
        <div>
            <nav>
                <ul>
                    <li><Link to="/">Home</Link></li>
                    <li><Link to="/about?name=asd&age=123">About</Link></li>
                    <li><Link to="/contact/hjg/675">Contact</Link></li>
                </ul>
            </nav>
            <h1>Home</h1>
            <p>welcome</p>
        </div>
    );
}

export default Home;