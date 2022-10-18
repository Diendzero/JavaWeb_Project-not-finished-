<%--
  Created by IntelliJ IDEA.
  User: 12641
  Date: 2022/9/1
  Time: 20:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>后台管理</title>
    <%--静态包含base标签和jQuery文件--%>
    <%@include file="/pages/Common/Head.jsp"%>

    <link type="text/css" rel="stylesheet" href="statics/css/ManagerStyle.css">
</head>
<body>
    <div>
        <ul id="manager_ul_horizontal">
            <li id="manager_title">后台管理</li>
            <li class="manager_li_horizontal"><a href="http://localhost:8080/SummerProject/">返回首页</a></li>
            <li class="manager_li_horizontal"><a href="pages/Manager/HealthManager.jsp">健康管理</a></li>
            <li class="manager_li_horizontal"><a href="Manager/historyTrackingServlet?action=list">行程管理</a></li>
        </ul>
    </div>

    <div id="manager_content">
        <p id="manager_content_text">欢迎您使用后台管理系统！请选择右上角模块进行操作。</p>
    </div>

    <div id="bottom_line"></div>

    <div id="bottom">
        <span>
            <p>关于平台</p>
            <p>行程与健康平台.Copyright &copy;2022</p>
        </span>
    </div>
</body>
</html>
