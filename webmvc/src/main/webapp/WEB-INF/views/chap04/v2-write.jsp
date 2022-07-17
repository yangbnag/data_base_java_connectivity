<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title></title>
    <style>

        h1 {
            border: 2px solid #000;
            width: 400px;
            text-align: center;
            margin-left: 50px;
            margin-top: 100px;
        }
        
        .write-container{
            /* background: yellow; */
            width: 800px;
            height: 500px;
            margin: 100px auto 0;
        }

        div{
            margin-bottom: 20px;
        }
      

        .content-box {
            /* background: pink; */
        }

        .content-box label {
            /* background: gray; */
            margin-bottom: 100px;
            position: absolute;
        }

        #contentInput {
            /* background: green; */
            margin-top: 30px;
            margin-left: 10px;
            width: 750px;
        }


    </style>


</head>

<header>
    <h1> 새로운 게시글 등록 </h1>
</header>

<body>
    <div class="write-container">

        <form action="/board/write" method="post" autocomplete="off">
    
            <div class="writer-box">
               <label for="writerInput"> 작성자 </label>
               <input type="text" id="writerInput" placeholder="이름" name="writer">
            </div>
            <div class="title-box">
                <label for="titleInput"> 글제목 </label>
                <input type="text" id="titleInput" placeholder="제목" name="title">
             </div>
             <div class="content-box">
                <label for="contentInput"> 내용 </label>
                <textarea id="contentInput"  name="content" rows="10"></textarea>
             </div>
    
               <div class="btn-box">
                  <button class="btn-write" type="submit"> 글 작성하기</button>
                   <button class="btn-main" type="button"> 목록으로 </button>
                </div>
    
        </form>           
      </div>

      <script>
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