<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>登录</title>

    <%--静态包含base标签和jQuery文件--%>
    <%@include file="/pages/Common/Head.jsp"%>

    <link type="text/css" rel="stylesheet" href="statics/css/LoginStyle.css">
</head>
<body>
    <div id="login_header">
        <img id="logo_img" alt="健康" src="statics/Picture/健康.gif">
    </div>

    <div class="login_banner">

    <div id="content">
        <div class="login_form">
            <div class="login_box">
                <div class="tit">
                    <h1>行程与健康平台用户中心</h1>
                    <a href="pages/User/Regist.jsp">立即注册</a>
                </div>
                <div id="msg_cont">
                    <b></b>
                    <span id="errorMsg">
                        <img id="errorMsg_icon" src="statics/Picture/triangle-exclamation-solid.svg">
                        <b id="errorMsg_text">
<%--                            <%=request.getAttribute("msg") == null ? "请输入用户名和密码！" : request.getAttribute("msg")%>--%>
                            ${empty requestScope.msg ? "请输入用户名和密码！" : requestScope.msg}
                        </b>
                    </span>
                </div>
                <div class="form">
                    <form action="userServlet" method="post">
                        <input type="hidden" name="action" value="login"/>
                        <img class="login_user_name" alt="账号" src="statics/Picture/user-solid.svg"></img>
                        <input class="itxt" type="text" placeholder="请输入用户名"
<%--                               value="<%=request.getAttribute("msg") == null ? "" : request.getAttribute("username")%>"--%>
                               value="${requestScope.username}"
                               autocomplete="off" tabindex="1" name="username"/>
                        <br/>
                        <br/>
                        <img class="login_user_password" alt="密码" src="statics/Picture/key-solid.svg"></img>
                        <input class="itxt" type="password" placeholder="请输入密码" autocomplete="off" tabindex="1"
                               name="password"/>
                        <br/>
                        <br/>
                        <input type="submit" value="登录" id="sub_btn"/>
                    </form>
                </div>

            </div>
        </div>
    </div>
</div>

    <div id="bottom">
            <span>
                <p>关于平台</p>
                <p>行程与健康平台.Copyright &copy;2022</p>
			</span>
    </div>
</body>
</html>