<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>首页</title>
    <link type="text/css" rel="stylesheet" href="statics/css/IndexStyle.css">
    <script type="text/javascript" src="jquery-3.6.0.min.js"></script>
    <script type="text/javascript">
        $(function () {
            $("#bar").click(function () {
                $("#div-vertical-nav").slideToggle();
            })
        })
    </script>
</head>
<body>

    <div>
        <ul id="ul-horizontal">
            <button id="bar"><img src="statics/Picture/bars-solid.svg"></button>
            <li id="title">行程与健康平台</li>
            <li class="li-horizontal"><a href="#contact">个人中心</a></li>
            <li class="li-horizontal"><a href="pages/Manager/Manager.jsp">后台管理</a></li>
            <li class="li-horizontal"><a href="pages/User/Login.jsp">登录</a></li>
        </ul>
    </div>

    <div id="div-vertical-nav">
        <ul id="ul-vertical">
            <div id="ul-vertical-subdiv1">
                <li class="li-vertical"><a href="" class="a-information">信息填报</a></li>
                <li class="li-vertical"><a href="" class="a-search">数据查询</a></li>
            </div>

            <div id="ul-vertical-subdiv2">
                <li class="li-vertical"><a href="" class="a-health">我的健康</a></li>
                <li class="li-vertical"><a href="" class="a-itinerary">我的行程</a></li>
            </div>
        </ul>
    </div>


</body>
</html>