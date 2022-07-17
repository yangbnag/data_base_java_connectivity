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
    
    header{
        /* background: yellow; */
        width: 500px;
        margin: 50px auto 0;
        text-align: center;
        padding: 20px;
        border: 2px solid #000;
        border-bottom: 4px double;
        border-radius: 10%;
    }


    #wrapper {
        width: 1000px;
        height: 500px;
        margin: 100px auto 0 ;
        /* background: #000; */
    }

    table{
        text-align: center;
        border: 1px solid #000;
    }

    table th{
        background: gray;
        width: 70px;
        border: 1px solid #000;
        font-size: 700;
        width: 120px;
        /* background: green; */
        text-align: center;
    }

    table th:nth-child(3){
        width: 600px;
        /* background: green; */
        text-align: center;
    }

    table td{
        border: 1px solid #000;
    }

    .btn-write {
        width: 100px;
        height: 50px;
        margin-bottom: 100px;
        margin-left: 900px;
        padding-top: 15px;
        box-sizing: border-box;
        text-align: center;
        border: 2px solid #000;
        font-weight: 700;
        font-size: 20px;
    }



</style>

</head>
<header>
    <h1> 게시판 제작 연습용 페이지</h1>
</header>

<body>
    <div id = "wrapper">
<table>
    <tr>
        <th>게시번호</th>
        <th>작성자</th>
        <th>제목</th>
        <th>조회수</th>
        <th>작성일자</th>
    </tr>

    <c:forEach var = "b" items = "${boards}">
    <tr>
        <td>${b.boardNo}</td>
        <td>${b.writer}</td>
        <td><a href="/board/content?boardNo=${b.boardNo}"> ${b.title} </a></td>
        <td>${b.viewCnt}</td>
        <td>${b.date}</td>
    </tr>
</c:forEach>
</table>

<div class="btn-write">
    <a class="btn btn-outline-danger btn-outline-danger" href="/board/write"> 글쓰기 </a>
</div>
</div>

</body>

</html>