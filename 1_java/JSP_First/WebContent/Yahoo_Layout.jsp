<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Yahoo Search Page</title>
    <link rel="stylesheet" href="./css/Yahoo.css">
</head>
<body>
    <div id="header_nav">
        <ul class="gnb">
            <li><a href="<% request.getRequestURI(); %>">Home</a></li>
            <li><a href="#">Mail</a></li>
            <li><a href="#">Answer</a></li>
            <li><a href="#">Group</a></li>
            <li><a href="#">Fliker</a></li>
            <li><a href="#">Tumblr</a></li>
            <li><a href="#">Games</a></li>
            <li><a href="#">Live</a></li>
            <li><a href="#">Screen</a></li>
            <li><a href="#">Mobile</a></li>
            <li><a href="#">More</a></li>
            <span class="survivalFootball"><img src="./img/survivalFootball.png" alt="skull"/>  Play survival Football for FREE &amp; win up to $100K</span>
        </ul>
    </div>
    <div id="wrap">
        <header>
            <div id="search">
                <a href="<% request.getRequestURI(); %>"><img class="logo" src="./img/yahoo.png" alt="Yahoo"></a>
                <form action="" method="GET">
                    <input type="text" name="search"/>
                    <input class="btn_search" type="submit" value="Search Web"/>
                </form>
                <span><a href="#">My Yahoo</a></span>
                <span><a href="#">Sing In</a></span>
                <span><a href="#">Mail</a></span>
            </div>
        </header>
        <div id="content">
            <div id="main_menu">
                <ul>
                    <li><a href="#">Mail</a></li>
                    <li><a href="#">News</a></li>
                    <li><a href="#">Sports</a></li>
                    <li><a href="#">Finance</a></li>
                    <li><a href="#">Autos</a></li>
                    <li><a href="#">Celebrity</a></li>
                    <li><a href="#">Shopping</a></li>
                    <li><a href="#">Movies</a></li>
                    <li><a href="#">Politice</a></li>
                    <li><a href="#">Beauty</a></li>
                </ul>
            </div>
            <div id="main">
                <div class="banner1">main Big Banner</div>
                <div class="banner2">main Side Banner</div>
                <div class="menu">
                    <ul>
                        <li><a href="#">All Stories</a></li>
                        <li><a href="#">News</a></li>
                        <li><a href="#">Entertainment</a></li>
                        <li><a href="#">Sports</a></li>
                        <li><a href="#">Business</a></li>
                        <li><a href="#">More</a></li>
                    </ul>
                </div>
                <div class="banner3">main Topic</div>
                <div class="banner4">main Topic</div>
                <div class="banner5">main Topic</div>
                <div class="banner6">main Topic</div>
            </div>
            <div id="mainbanner">
                <div class="ad1">hit search Word</div>
                <div class="ad2">Ad 1</div>
                <div class="ad3">Ad 2</div>
                <div class="ad4">Ad 3</div>
                <div class="ad5">Ad 4</div>
            </div>
        </div>
        <footer>
            <ul>
                <li><a href="<% request.getRequestURI(); %>"><img class="footer_logo" src="./img/yahoo.png" alt="footer1"></a></li>
                <li><img class="footer_company" src="./img/footer.jpg" alt="footer2"></li>
            </ul>
        </footer>
     </div><!-- Wrap div -->
</body>
</html>