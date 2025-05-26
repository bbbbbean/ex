import Layout from "../layouts/Layout";

// 레이아웃에 포함된 특정 요소 표시 X : showAside={false} -> 레이아웃이 받음
const Home = ()=>{
    return(
        <Layout showAside={false}>
            <h1>home page</h1>
            <p>홈페이지의 메인 영역</p>
        </Layout>
    )
}

export default Home;