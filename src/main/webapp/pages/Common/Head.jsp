<%--
  Created by IntelliJ IDEA.
  User: 12641
  Date: 2022/8/28
  Time: 23:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String basePath = request.getScheme()
            + "://"
            + request.getServerName()
            + ":"
            + request.getServerPort()
            + request.getContextPath()
            + "/";
%>
<!--写base标签，永远固定相对路径跳转的结果-->
<base href="<%=basePath%>">
<script type="text/javascript" src="jquery-3.6.0.min.js"></script>