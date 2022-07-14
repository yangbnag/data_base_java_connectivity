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
    .board-list{ 
        
        border: 2px solid;
        width: 800px;
        margin: 50px auto 50px;

    }

    .board-list th {
        border: 2px solid;
        width: 100px;
    }

    .board-list th:nth-child(3){
        width: 400px;
    }

    .board-list th:nth-child(2){
        width: 150px;
    }

    .board-list td {
        border: 2px solid;
        text-align: center;
    }

    .btn-write {
        margin: 10px 0;
        margin-left: 680px;
        background: #000;
        width: 100px;
        text-align: center;

    }

    .btn {
        color: white;
    }


</style>    
</head>
<body>


 
    <div class="board-list">
        <table class="table table-dark table-striped table-hover articles">
            <tr>
                <th>번호</th>
                <th>작성자</th>
                <th>제목</th>
                <th>조회수</th>
                <th>작성시간</th>
            </tr>


            <c:forEach var="b" items="${boards}">
                <tr>
                    <td>${b.boardNo}</td>
                    <td>${b.writer}</td>
                    <td><a href="/board/content?boardNo=${b.boardNo}">${b.title}</a></td>
                    <td>${b.viewCnt}</td>
                    <td>${b.date}</td>
                </tr>
            </c:forEach>
            
              
            
        </table>

        <div class="btn-write">
            <a class="btn btn-outline-danger btn-lg" href="/board/write">글쓰기</a>
        </div>
    </div>

</body>
</html>