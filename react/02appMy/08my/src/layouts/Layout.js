// Layout = Header + ( Aside + Section ) + Footer
import Header from "./Header";
import Footer from "./Footer";
import Aside from "./Aside";
import Section from "./Section";
import './css/Layout.css'

// 하위 태그들을 children으로 받을 수 있음
// showAside : 설정값 -> and 이용 Aside가 참일때만 표시하도록 설정
// asideLinks : 반복 처리할 떄 문제될 수 있으니까 기본 값 잡아주기
const Layout = ({children, showAside, asideLinks})=>{
    return(
        <div className="">
            <Header/>
            <main>
                {showAside && <Aside asideLinks={asideLinks}/>}
                <Section>
                    {children}
                </Section>
            </main>
            <Footer/>
        </div>
    )
}

export default Layout;