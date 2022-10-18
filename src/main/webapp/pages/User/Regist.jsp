<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>注册</title>

    <%--静态包含base标签和jQuery文件--%>
    <%@include file="/pages/Common/Head.jsp"%>

    <link type="text/css" rel="stylesheet" href="statics/css/RegistStyle.css">
    <script type="text/javascript">
        // 页面加载完成之后
        $(function () {
            // 给注册绑定单击事件
            $("#sub_btn").click(function () {
                // 验证用户名：必须由字母，数字或者下划线组成，并且长度为5到12位
                //1 获取用户名输入框里的内容
                var usernameText = $("#username").val();
                //2 创建正则表达式对象
                var usernamePatt = /^\w{5,12}$/;
                //3 使用test方法验证
                if (!usernamePatt.test(usernameText)) {
                    //4 提示用户结果
                    $("span.errorMsg").text("用户名称必须由字母，数字或下划线组成，并且长度为5到12位!");

                    return false;
                }

                // 验证密码：必须由字母，数字下划线组成，并且长度为5到12位
                //1 获取用户名输入框里的内容
                var passwordText = $("#password").val();
                //2 创建正则表达式对象
                var passwordPatt = /^\w{5,12}$/;
                //3 使用test方法验证
                if (!passwordPatt.test(passwordText)) {
                    //4 提示用户结果
                    $("span.errorMsg").text("密码不合法！");

                    return false;
                }

                // 验证确认密码：和密码相同
                //1 获取确认密码内容
                var repwdText = $("#repwd").val();
                //2 和密码相比较
                if (repwdText != passwordText) {
                    //3 提示用户
                    $("span.errorMsg").text("确认密码和密码不一致！");

                    return false;
                }

                //1 获取手机号码中的内容
                var phoneText = $("#phone").val();
                //2 创建正则表达式对象
                var phonePatt = /^1[3456789]\d{9}$/;
                //3 使用test方法验证是否合法
                if (!phonePatt.test(phoneText)) {
                    //4 提示用户
                    $("span.errorMsg").text("手机号码不合法！请重新检查您的手机号码！");

                    return false;
                }

                // 验证码：现在只需要验证用户已输入。因为还没讲到服务器。验证码生成。
                var codeText = $("#code").val();

                //去掉验证码前后空格
                // alert("去空格前：["+codeText+"]")
                codeText = $.trim(codeText);
                // alert("去空格后：["+codeText+"]")

                if (codeText == null || codeText == "") {
                    //4 提示用户
                    $("span.errorMsg").text("验证码不能为空！");

                    return false;
                }

                // 去掉错误信息
                $("span.errorMsg").text("");

            });

        });

    </script>
    <style type="text/css">
        .login_form {
            height: 420px;
            margin-top: 25px;
        }

    </style>
</head>

<body>
<div id="regist_header">
    <img class="logo_img" alt="健康" src="statics/Picture/健康.gif">
</div>

<div class="regist_banner">

    <div id="content">
        <div class="regist_form">
            <div class="regist_box">
                <div class="tit">
                    <h1>注册新用户</h1>
                    <span class="errorMsg">
<%--                        <%=request.getAttribute("msg") == null ? "" : request.getAttribute("msg")%>--%>
                        ${empty requestScope.msg ? "" : requestScope.msg}
                    </span>
                </div>
                <div class="form">
                    <form action="userServlet" method="post">
                        <label>用户名称：</label>
                        <input type="hidden" name="action" value="regist">
                        <input class="itxt" type="text" placeholder="请输入用户名"
                               value="${requestScope.username}"
                               autocomplete="off" tabindex="1" name="username" id="username"/>
                        <br/>
                        <br/>
                        <label>用户密码：</label>
                        <input class="itxt" type="password" placeholder="请输入密码"
                               autocomplete="off" tabindex="1" name="password" id="password"/>
                        <br/>
                        <br/>
                        <label>确认密码：</label>
                        <input class="itxt" type="password" placeholder="请确认密码"
                               autocomplete="off" tabindex="1" name="repwd" id="repwd"/>
                        <br/>
                        <br/>
                        <label>手机号码：</label>
                        <input class="itxt" type="text" placeholder="请输入手机号码"
                               value="${requestScope.phone}"
                               autocomplete="off" tabindex="1" name="phone" id="phone"/>
                        <br/>
                        <br/>
                        <label>验证码：</label>
                        <input class="itxt" type="text" name="code" style="width: 150px;" placeholder="请输入验证码" id="code"/>
                        <img alt="" src="static/img/code.bmp" style="float: right; margin-right: 40px">
                        <br/>
                        <br/>
                        <input type="submit" value="注册" id="sub_btn"/>
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