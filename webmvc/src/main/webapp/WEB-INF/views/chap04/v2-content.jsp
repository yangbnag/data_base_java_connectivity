<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title></title>




</head>

<body>

    <header>
        <h1> ${b.boardNo} 번 게시물 </h1>
    </header>
    
    <body>
        <div class="write-container">
    
        
                <div class="writer-box">
                   <label for="writerInput"> 작성자 </label>
                   <input type="text" id="writerInput" placeholder="이름" name="writer" 
                   value="${b.writer}" disabled>
                </div>
                <div class="title-box">
                    <label for="titleInput"> 글제목 </label>
                    <input type="text" id="titleInput" placeholder="제목" name="title"
                    value="${b.title}" disabled>
                 </div>
                 <div class="content-box">
                    <label for="contentInput"> 내용 </label>
                    <p id="contentInput">
                        ${b.content}
                    </p>
                 </div>
        
                   <div class="btn-box">
                      <button class="btn-modify" type="submit"> 수정</button>
                       <button class="btn-del" type="button"> 삭제 </button>
                       <button class="btn-main" type="button"> 목록 </button>
                    </div>
   
          </div>

          <script>
            
            const $btnmod = document.querySelector('.btn-modify');
            console.log($btnmod);

            $btnmod.addEventListener('click', e => {
                if(!e.target.matches('.btn-modify')) return;

                console.log('수정버튼 클릭')
                
                e.preventDefault();
                if(confirm('수정 하시겠습니까?')){
                    location.href = '/board/modify?boardNo=${b.boardNo}';
                } else {return;}
            })


           const $btndel = document.querySelector('.btn-del');
           console.log($btndel)

           $btndel.addEventListener('click', e => {
            if(!e.target.matches('.btn-del')) return;
            
            
            console.log('삭제버튼 클릭');

            e.preventDefault();

            if(confirm('정말로 삭제하시겠습니까?')){
                location.href = '/board/delete?boardNo=${b.boardNo}';
            } else{
                return;
            }

           });


           const $mainbtn = document.querySelector('.btn-main');
        // console.log($mainbtn);

        $mainbtn.addEventListener('click',e=>{
            // console.log('목록으로 버튼 눌리나?')
            // if(!e.target.matches('btn-main')) return;
            // console.log('목록으로 버튼 클릭');

            e.preventDefault();

            location.href = '/board/list';
        });




          </script>

    

</body>

</html>