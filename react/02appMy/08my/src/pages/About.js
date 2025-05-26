import { href } from "react-router-dom";
import Layout from "../layouts/Layout";

const About = () => {
    const asideLinks=[
        {title:"회사 소개", href:"/about/1"},
        {title:"연혁", href:"/about/2"},
        {title:"팀 소개", href:"/about/3"},
        {title:"오시는 길", href:"/about/4"},
    ];
    return (
        <Layout showAside={true} asideLinks={asideLinks}>
            <h1>About</h1>
            <p>홈체이지의 about 페이지</p>
        </Layout>
    )
}

export default About;