<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>

    <h1>mvc버전 members.jsp</h1>
    <ul>


        <c:forEach var = "m" items = "${mList}">

            <li>
                # 회원번호 : ${m.userNum} , 
                아이디 : ${m.account}, 

                <a href="/mvc/v4/member?userNum=${m.userNum}">
                    이름 : ${m.getUserName()}
                </a>
                &nbsp;&nbsp;&nbsp;
                <a id ="rm-btn" href="/mvc/v4/remove?userNum=${m.userNum}">[delete]</a>

                
                <!-- m은 멤버 타임. 멤버 객체의 필드를 가져올때 get을 붙여도 되고 안붙여도 된다. -->
                <!-- get을 사용 할때는 클래스에 getter가 있어야 되고 끝에 ()를 써줘야 한다. -->
                <!-- jsp에서 getter를 생략해도 getter를 통해서 필드값을 가지고 온다.  -->
            </li>
            <a href="/mvc/join"> 새로운 회원가입하기</a>

            <script>
                const $rmBtn = document.querySelector('#rm-btn');
                $rmBtn.addEventListener('click', e=>{
                    if (!confirm('진짜루 삭제???')){
                        e.preventDefault(); // 링크이동중지
                        // 삭제 취소
                        return;
                    }
                    
                    // 삭제 진행
                    // location.href = '/mvc/v4/remove?userNum=${m.userNum}';
                });
            </script>

            

        </c:forEach>

    </ul>
</body>
</html>