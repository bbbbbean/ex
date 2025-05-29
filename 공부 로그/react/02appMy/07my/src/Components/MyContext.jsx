// 전역 데이터 저장 공간
// context를 사용 -> 새로고침(새로 랜더링)하면 초기화
// 반영구적인 데이터 보관 (프론트): localStorage(일정 기간), sessionStorage(세션 닫으면 끝), cookie

import React from "react";
const AppContext = React.createContext();   // context 만드는 작업
export default AppContext;