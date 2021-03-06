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
        .content-container {
            width: 60%;
            margin: 150px auto;
            position: relative;
        }

        .content-container .main-title {
            font-size: 24px;
            font-weight: 700;
            text-align: center;
            border-bottom: 2px solid rgb(75, 73, 73);
            padding: 0 20px 15px;
            width: fit-content;
            margin: 20px auto 30px;
        }

        .content-container .main-content {
            border: 2px solid #ccc;
            border-radius: 20px;
            padding: 10px 25px;
            font-size: 1.1em;
            text-align: justify;
            min-height: 400px;
        }

        .content-container .custom-btn-group {
            position: absolute;
            bottom: -10%;
            left: 50%;
            transform: translateX(-50%);
        }
    </style>
</head>

<body>

    <div class="wrap">


        <div class="content-container">

            <form action="/board/modify" method="post">

                <input type="hidden" name="boardNo" value="${b.boardNo}">

                <h1 class="main-title">${b.boardNo}??? ?????????</h1>

                <div class="mb-3">
                    <label for="exampleFormControlInput1" class="form-label">?????????</label>
                    <input type="text" class="form-control" id="exampleFormControlInput1" placeholder="??????" name="writer"
                        value="?????????">
                </div>
                <div class="mb-3">
                    <label for="exampleFormControlInput2" class="form-label">?????????</label>
                    <input type="text" class="form-control" id="exampleFormControlInput2" placeholder="??????" name="title"
                        value="?????????">
                </div>

                <div class="mb-3">
                    <label for="exampleFormControlTextarea1" class="form-label">??????</label>
                    <textarea name="content" class="form-control" id="exampleFormControlTextarea1"
                        rows="10">????????????</textarea>
                </div>


                <div class="btn-group btn-group-lg custom-btn-group" role="group">
                    <button id="mod-btn" type="submit" class="btn btn-warning">??????</button>
                    <button type="button" class="btn btn-dark">??????</button>
                </div>

            </form>

        </div>

        <script>

            

        </script>


</body>
</html>