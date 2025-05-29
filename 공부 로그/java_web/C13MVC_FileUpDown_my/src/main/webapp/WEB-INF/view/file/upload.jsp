<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

 <style>
        div {
            width: 300px;
            height: 200px;
        }

        .drag-block {
            display: flex;
            justify-content: left;
            align-items: center;

            flex-wrap: wrap;
            width: 100%;
            height: 100%;
            
            gap: 20px;
        }

        .d4 {
            width: 500px;
            height: 500px;
            padding: 10px;
            border: 5px dashed gray;
            position: relative;
            color: gray;
        }

        .d4::after {
            content: "+";
            font-size: 7rem;

            display: flex;
            justify-content: center;
            align-items: center;
            margin: 0;
            width: 100%;
            height: 100%;
            position: relative;
            top: -20px;
        }

        .preview {
            width: 150px;
            height: 500px;
            border: 1px solid;
            padding: 10px;

            display: flex;
            justify-content: start;
            align-items: center;
            overflow-y: auto;
            overflow-x: hidden;
            gap: 5px;
            flex-direction: column;
        }

        .preview::-webkit-scrollbar {
            display: none;
        }
    </style>

</head>
<body>
	<h1>File Upload</h1>
	<form action="${pageContext.request.contextPath }/file/upload" method="post" enctype="multipart/form-data">
		<input type="file" name="files" multiple />
		<button>업로드</button>
	</form>
	<hr />
	
	<a href="javascript:void(0)" class="image-upload-btn">업로드</a>
	<div class="drag-block">
        <div class="d4"></div>
        <div class="preview"></div>
    </div>
	
	
	<!-- axios -->
	<script src="https://cdnjs.cloudflare.com/ajax/libs/axios/1.8.4/axios.min.js" integrity="sha512-2A1+/TAny5loNGk3RBbk11FwoKXYOMfAK6R7r4CpQH7Luz4pezqEGcfphoNzB7SM4dixUoJsKkBsB6kg+dNE2g==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
	<script>
	const formData = new FormData();
	
	let maxSize = 1024 * 1024 * 1   // 최대 업로드 가능 사이즈 (1Mb)
    function isValid(file)              // 유효성 체크 함수 
    {
        if (!file.type.startsWith("image/")) {
            //이미지 파일인지
            alert("이미지 파일만 업로드 가능합니다.")
            return false;
        }
        else if (file.size >= (1024 * 1024 * 1)) {
            //사이즈가 maxSize를 초과하는지
            alert("파일 업로드의 최대 사이즈는 1 MB입니다.")
            return false;
        } else {return true;}
    }

    const d4El = document.querySelector('.d4');
    d4El.addEventListener('dragenter', (e) => {
        e.preventDefault();
        console.log('dragenter', e)
    })
    d4El.addEventListener('dragover', (e) => {
        e.preventDefault();
        d4El.style.border = "5px dashed lightgray";
        d4El.style.color = "lightgray";
        console.log('dragover', e)
    })
    d4El.addEventListener('dragleave', (e) => {
        d4El.style.border = "5px dashed gray";
        d4El.style.color = "gray";
        e.preventDefault();

        console.log('dragleave', e)
    })
    d4El.addEventListener('dragend', (e) => {
        e.preventDefault();

        console.log('dragend', e)
    })
    d4El.addEventListener('drop', (e) => {
        e.preventDefault();
        d4El.style.border = "5px dashed gray";
        d4El.style.color = "gray";

        console.log('drop', e)
        console.log('drop', e.target)
        console.log('drop', e.dataTransfer)
        console.log('drop', e.dataTransfer.files)

        const files = e.dataTransfer.files;
        // 파일 하나만 드랍 예정
        // 서버 파라미터 이름을 files로 잡았으니 해당 파일도 files 라고 naming
        formData.append("files",files[0]);
        
        
        for (let i = 0; i < files.length; i++) {
            console.log('drop', e.dataTransfer.files[i])
            const file = e.dataTransfer.files[i];

            //유효성 확인(FN)
            if (!isValid(file)) return;

            //미리보기로 이미지 보여주기
            const previewEl = document.querySelector('.preview');
            const newImgEl = document.createElement('img');
            newImgEl.src = URL.createObjectURL(file);
            newImgEl.setAttribute('style', 'width:100%;height:100%;object-fit:contain;height:150px;border:1px solid;padding:2px;');
            previewEl.prepend(newImgEl);
        }
    })
    
    const imageUploadBtnEl = document.querySelector(".image-upload-btn");
    const path = '${pageContext.request.contextPath}'  // 프로 젝트 경로 잡아서 아래 넣어주기
    imageUploadBtnEl.addEventListener('click',()=>{
		console.log("click")
		
		// 비동기 함수(axios 사용 - 상단에 경로 설정해주기)
		// 기본 형태
		// axios.post("url",param,metaData)	메타가 중요! 잘 찾아보고 정리해.. 
		//		.then(resp=>console.log(resp))
		//		.catch(error=>console.log(error))
		// 경로 지정때 백틱(`)사용해도 O
		axios.post(path+"/file/upload",formData,{headers:{'content-Type':'multipart/form-data'}})
			 .then(resp=>console.log(resp))
			 .catch(error=>console.log(error))
		
		// 비동기 처리 : 뷰 이동에서 그냥 해당 페이지를 던져버리기 때문에 데이터로 페이지 소스 전체가 들어옴 -> 컨트롤러로 빼기
    })
    
	</script>
	
</body>
</html>