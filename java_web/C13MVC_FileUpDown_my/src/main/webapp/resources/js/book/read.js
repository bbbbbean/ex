/**
 * 
 */

console.log("read.js");
// 서버 경로 정보 -> 해당 jsp파일에서 설정해주기! 그곳의 프로젝트 경로를 읽어와야하니까!
//const path='${pageContext.request.contextPath}';
console.log(path)


const replyAddBtn = document.querySelector(".reply-add-btn")

replyAddBtn.addEventListener('click',()=>{
	console.log("read.click");
	
	// 입력을 누른 순간 contents(댓글내용) 받아오기
	// .value를 쓰면 입력한 내용 받아올 수 있음
	const contents = document.querySelector('.reply-header textarea').value;
	
	// ?를 던져 받는 방법
	// param.으로 받는 방법
	// 네트워크에서 확인 가능
	axios.get(`${path}/book/reply/create?bookCode=${bookCode}&contents=${contents}`)
		 .then((resp)=>{
			console.log(resp);
			document.querySelector('.reply-header textarea').value='';	// 로그 확인 후 댓글 창 비우기
			receiveReplyDate();
		})	// 성공 결과 콜백형태로 받음
		 .catch((error)=>{console.log(resp);})	// 우리는 데이터만 확인하면 되니까 .data

	// 동일한 북코드를 가지는 모든 댓글들을 불러와 띄울 예정
		 
	
	// 클릭을 하면 댓글 확인 창이 생김
	// 댓글 Db 추가, bookcode에 따른 댓글 이스트 확인 후 -> 해당 내용들을 집어넣은 댓글 확인창 생성 필요
	// createReplyItem();
	
})

// bookCode : read.jsp에서 전역화 시켜놨음
function receiveReplyDate(){
	// 비동기 처리
	// 북코드만 주면 알아서 리스트 뽑아오니까 북코드만 전달
	axios.get(`${path}/book/reply/list?bookCode=${bookCode}`)
			 .then((resp)=>{
				// 기존 노드 제거
				const itemsEl = document.querySelector('.reply-body .items');
				while(itemsEl.firstChild){
					itemsEl.removeChild(itemsEl.firstChild);
				}
				
				console.log(resp);
				const data = resp.data;
				const cnt = data.replyCnt;
				const replyCntEl = document.querySelector(".reply-cnt");
				replyCntEl.innerHTML=cnt;
				
				const items = data.replyList;
				console.log(items);
				// 배열 오브젝트를 꺼내 아래 댓글 확인으로 던지기
				//const items = resp.data;
				items.forEach(item=>createReplyItem(item));
				
			})	// 성공 결과 콜백형태로 받음
			 .catch((error)=>{console.log(resp);}) // 배열 오브젝트가 받아져와야함
}
receiveReplyDate();	// 최초 1회는 동작시켜줘야함

// 넣어야 하는 내용 어떻게 받아오나
// private int no;	// 자동으로 받아옴
// private String bookcode;	// read 페이지에서 받아옴 프론트
// private String username;	// 로그인 이후 session에서 받아욤
// private String contents;	// 프론트에서 받아옴
// private LocalDateTime createAt;	// 백에서 처리
// 전부 js가 연결된 read 페이지를 통해 들고 올 예정

function createReplyItem(item){ // 입력 누르면 댓글 확인 창이 하나 더 생기게 하는 작업!
	// div 생성
	const itemEl = document.createElement('div');
	itemEl.className='item';
	// 좌우용, 각 요소들 다 따로 생성 - 각 요소에 맞게 생성 요소 선택하기
	const leftEl = document.createElement('div');
	leftEl.className='left';
	const profileEl = document.createElement('div');
	profileEl.className='profile';
	const usernameEl = document.createElement('div');
	usernameEl.className='username';
	usernameEl.innerHTML=item.username;	// 기본값 설정
	
	const rightEl = document.createElement('div');
	rightEl.className='right';
	const dateEl = document.createElement('div');
	dateEl.className='date';
	dateEl.innerHTML=item.createAt;		// 기본값 설정
	const contentEl = document.createElement('div');
	contentEl.className='content';
		const textAreaEl = document.createElement('textarea');
		textAreaEl.value=item.contents;
		console.log(item.contents);
	const buttonGroupEl = document.createElement('div');
	buttonGroupEl.className='button-group';
	
	// 연결 작업
	// 태그 순서에 맞게 연결!
	// 좁은 범위가 위로 오게!
	contentEl.appendChild(textAreaEl);
	
	rightEl.appendChild(dateEl);
	rightEl.appendChild(contentEl);
	rightEl.appendChild(buttonGroupEl);
	
	leftEl.appendChild(profileEl);
	leftEl.appendChild(usernameEl);
	
	itemEl.appendChild(leftEl);
	itemEl.appendChild(rightEl);
	
	const itemsEl = document.querySelector('.items');
	itemsEl.appendChild(itemEl);
}