<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title></title>
 <!-- reset css -->
 <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/reset-css@5.0.1/reset.min.css">

 <!-- linear icons -->
 <!-- https://linearicons.com/free#cdn -->
 <link rel="stylesheet" href="https://cdn.linearicons.com/free/1.0.0/icon-font.min.css">
 
 <!-- bootstrap css -->
 <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
 
 <!-- custom css -->
 <link rel="stylesheet" href="/css/main.css">
 
 <!-- bootstrap js -->
 <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" defer></script>
 
 <!-- custom js -->
 <script src="/js/gnb-event.js" defer></script>
 
     <style>
         .write-container {
             width: 50%;
             margin: 200px auto 150px;
             font-size: 1.2em;
         }
     </style>
 
 
 </head>
 <body>
     <div class="write-container">
 
         <form action="/board/write" method="post" autocomplete="off">
 
             <div class="mb-3">
                 <label for="exampleFormControlInput1" class="form-label">작성자</label>
                 <input type="text" class="form-control" id="exampleFormControlInput1" placeholder="이름"
                     name="writer">
             </div>
             <div class="mb-3">
                 <label for="exampleFormControlInput2" class="form-label">글제목</label>
                 <input type="text" class="form-control" id="exampleFormControlInput2" placeholder="제목" name="title">
             </div>
             <div class="mb-3">
                 <label for="exampleFormControlTextarea1" class="form-label">내용</label>
                 <textarea name="content" class="form-control" id="exampleFormControlTextarea1" rows="10"></textarea>
             </div>
 
             <div class="d-grid gap-2">
                 <button class="btn btn-dark" type="submit">글 작성하기</button>
                 <button id="to-list" class="btn btn-warning" type="button">목록으로</button>
             </div>
 
         </form>
 
     </div>

</body>
</html>