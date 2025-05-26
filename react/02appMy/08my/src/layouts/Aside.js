

const Aside = ({asideLinks=[]})=>{
    return(
        <aside>
            <ul>
                {asideLinks.length>0 && asideLinks.map((item,index)=>{
                    return(
                        // list형 데이터는 key값 넣어주기
                        <li key={index}><a href={item.href}>{item.title}</a></li>
                    )
                })}
            </ul>
        </aside>
    )
}

export default Aside;