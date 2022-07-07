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

    <h1>blah.jsp 입니다~~ 이 파일은 서버에서만 접근 가능합니다.</h1>

    <p>
        서버에서 온 메시지 : ${msg}
        <!-- 자바 코드를 html 태그 처럼 사용한 예시 -->

        <br>
        서버에서 온 숫자 : ${number}

        <br>
        서버에서 온 리스트 : ${hobbys.get(0)}
        <br>

        <!-- jstl : jsp standard tag library -->
        <c:forEach var="h" items="${hobbys}">
            # 취미 : ${h} <br>
        </c:forEach>

        <!-- fori문 -->
        <c:forEach var="i" begin="1" end="10" step="1">
            ${i}!!
        </c:forEach>
        <br>

        <!-- if문 -->
        <c:if test="${number == 100}">
            서버에서 온 숫자는 100과 같습니다!!
        </c:if>
        <br>

        <!-- 다중 if 문 -->
        <c:choose>
            <c:when test = "${hobbys.size() > 0}">
                취미가 있습니다~~
            </c:when>

            <c:otherwise>
                취미가 없습니다~~
            </c:otherwise>
        </c:choose>



</body>

</html>