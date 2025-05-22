// 01 if (잘안씀)
const Component01 = ({ isAuth }) => {
  if (isAuth) {
    return <h3>인증 되었습니다.</h3>;
  } else {
    return <h3>로그인이 필요합니다.</h3>;
  }
};

// 02 삼함연산자 **
// 조건식?참:거짓
// 코드가 한줄이면 그냥 나열
// 코드가 여러줄이면 소괄호 씌우기, 부모 태그 1개
const Component02 = ({ isAuth }) => {
  return (
    <>
      {isAuth ? (
        <>
          <h3>인증 되었습니다.</h3>
          <p>user1 계정 로그인</p>
        </>
      ) : (
        <h3>로그인이 필요합니다.</h3>
      )}
    </>
  );
};

// 03 && 연산자
// 아이템 받을 예정
// 연산자를 이용해 조건부 랜더링 이용
// 왼쪽이 참이어야 오른편으로 넘어가고, 왼편이 거짓이면 오른편은 아예 실행을 하지 않음을 이용
const Component03 = ({items}) => {
    return(
        <div className="items">
            {/* 아이템이 있을수도 없을수도 있으니까 */}
            {items.length>0 && items.map((item,idx)=>{
                return <li key={idx}>{item}</li>
            })}
        </div>
    );
};

export default {
  Component01,
  Component02,
  Component03,
};
