// Header = topHeader + Nav
import TopHeader from "./TopHeader";
import Nav from "./Nav";

const Header = () => {
    return(
        <header>
            <TopHeader />
            <Nav />
        </header>
    )
}

export default Header;