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

    <div class="wrap">
        <h1>영화 선택</h1>
        
        <div class="menu">
            <form action="/movie/result" method="post" >
                <label>
                    #영화 목록 <br>
                    <select id ="menu-sel" name="menu">
                        <option value="captinamerica">캡틴아메리카</option>
                        <option value="ring">링</option>
                        <option value="ironman">아이언맨</option>
                    </select>
                </label>
                <label class="price"> #가격 : 12000원 </label>
                 <input id="price-tag" type="hidden" name = "price" value="12000">

                 <label>
                   <button type="submit"> 선택하기 </button> 
                </label>
            </form>
        </div>
    </div>

    <script>
        (function() {
            const moviePriceList = {
                captinamerica : 12000 ,
                ring : 8000,
                ironman : 10000,
            };

            const $sel = document.getElementById('menu-sel');
            $sel.onchange = e => {
                console.log(e.target.value);
                const price = moviePriceList[e.target.value];
                const $priceLabel = document.querySelector('.price');

                $priceLabel.textContent = '#가격: ' + price + "원";
                
                const $priceTag = document.getElementById('price-tag');
                $priceTag.value = price;
            };
        })();
    </script>

</body>
</html>