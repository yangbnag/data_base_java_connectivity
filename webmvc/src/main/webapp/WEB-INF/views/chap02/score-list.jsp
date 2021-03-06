<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    
    <!-- reset css -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/reset-css@5.0.1/reset.min.css">
    
    <!-- bootstrap css -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
    
    
    <!-- bootstrap js -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" defer></script>

    <!-- jquery -->
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

    <style>
        label {
            display: block;
        }

        .score-list>li {
            margin-bottom: 10px;
        }

        .score-list>li:first-child {
            font-size: 1.2em;
            color: blue;
            font-weight: 700;
            border-bottom: 1px solid skyblue;
        }

        .del-btn {
            width: 10px;
            height: 10px;
            background: red;
            color: #fff;
            border-radius: 5px;
            margin-left: 5px;
            text-decoration: none;
            font-size: 0.7em;
            padding: 6px;
        }

        .del-btn:hover {
            background: orangered;
        }

        section.score {
            padding: 200px 50px 100px;
            font-size: 1.5em;
        }

        .list-header {
            display: flex;
            justify-content: space-between;

            width: 50%;
        }
        .list-header .sort-link-group {
            display: flex;

        }
        .list-header .sort-link-group div {
            margin-right: 20px;
        }


        .first-sut {
            background: yellow;
            
        }


    </style>
</head>

<body>

    <div class="wrap">


        <section class="score">
            <h1>?????? ?????? ??????</h1>
            <form action="/score/register" method="POST">
                <label>
                    # ??????: <input type="text" name="name">
                </label>
                <label>
                    # ??????: <input type="text" name="kor">
                </label>
                <label>
                    # ??????: <input type="text" name="eng">
                </label>
                <label>
                    # ??????: <input type="text" name="math">
                </label>
                <label>
                    <button type="submit">??????</button>
                    <button id="go-home" type="button">???????????????</button>
                </label>
            </form>

            <hr>

            <ul class="score-list">
                <li class="list-header">
                    <div class="count">??? ?????? ???: ${scores.size()}???</div>
                    <div class="sort-link-group">
                        <div><a href="/score/list?sort=num">?????????</a></div>
                        <div><a href="/score/list?sort=name">?????????</a></div>
                        <div><a href="/score/list?sort=average">?????????</a></div>
                    </div>

                </li>

                
                <c:forEach var = "f" items = "${firstScores}">
                <li class="first-stu">
                    #1??? : ${f.name} </li>
                </c:forEach>>

                <c:forEach var = "l" items = "${lastScores}">
                    <li class="last-stu">#?????? : ${l.name}</li>
                </c:forEach>
                
                  

                <c:forEach var="s" items="${scores}">
                    <li>
                        # ??????: ${s.stuNum}, ??????: <a href="/score/detail?stuNum=${s.stuNum}">${s.name}</a>, ??????:
                        ${s.kor}???,
                        ??????: ${s.eng}???, ??????: ${s.math}???, ??????: ${s.total}???
                        , ??????: ${s.average}???, ?????? : ${s.grade}
                        <a class="del-btn" href="/score/delete?stuNum=${s.stuNum}">??????</a>
                    </li>
                </c:forEach>
            </ul>

        </section>



    </div>

    <script>
        const $ul = document.querySelector('.score-list');

        $ul.addEventListener('click', e => {
            if (!e.target.matches('a.del-btn')) return;

            e.preventDefault();
            //console.log('??????????????? ??????!');

            if (confirm('????????? ?????????????????????????')) {
                //?????? ??????                
                location.href = e.target.getAttribute('href');
            } else {
                //?????? ??????
                return;
            }

        });

        //??????????????? ?????? ?????????
        const $homeBtn = document.getElementById('go-home');
        $homeBtn.onclick = e => {
            location.href = '/';
        };
    </script>

</body>

</html>