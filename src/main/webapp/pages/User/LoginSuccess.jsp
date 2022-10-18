<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>登录成功</title>

  <%--静态包含base标签和jQuery文件--%>
  <%@include file="/pages/Common/Head.jsp"%>

  <link type="text/css" rel="stylesheet" href="statics/css/LoginSuccessStyle.css">
</head>
<body>
<div id="loginSuccess_header">
  <img class="logo_img" alt="健康" src="statics/Picture/健康.gif">
</div>

<div class="loginSuccess_banner">

  <div id="content">
    <div class="loginSuccess_form">
      <div class="loginSuccess_box">
        <div class="tit">
          <h1>您已成功登录！请点击此处<a href="http://localhost:8080/SummerProject/">返回首页。</a></h1>
        </div>
      </div>
    </div>
  </div>
</div>
<div id="loginSuccess_bottom">
			<span>
                <p>关于平台</p>
                <p>行程与健康平台.Copyright &copy;2022</p>
			</span>
</div>
</body>
</html>