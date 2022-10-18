<%--
  Created by IntelliJ IDEA.
  User: 12641
  Date: 2022/9/4
  Time: 20:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改行程记录</title>

    <%--静态包含base标签和jQuery文件--%>
    <%@include file="/pages/Common/Head.jsp"%>

    <link type="text/css" rel="stylesheet" href="statics/css/EditHistoryTrackingStyle.css">
</head>
<body>
    <div>
      <ul id="edit_historyTracking_ul_horizontal">
        <li id="edit_historyTracking_title">添加行程</li>
      </ul>
    </div>

    <div id="edit_main">
        <form id="function_div_edit" action="Manager/historyTrackingServlet" method="post">
            <input type="hidden" name="action" value="updateHistoryTracking">
            <table id="edit_main_table">
                <thead>
                <tr>请输入需要修改的数据</tr>
                </thead>

                <tbody>
                <tr>
                    <td>ID序列:</td>
                    <td><input name="history_tracking_id" type="text" value="${requestScope.historyTracking.history_tracking_id}" autocomplete="off" tabindex="1"></td>
                </tr>

                <tr>
                    <td>用户名:</td>
                    <td><input name="username" type="text" value="${requestScope.historyTracking.username}" autocomplete="off" tabindex="1"></td>
                </tr>

                <tr>
                    <td>GPS位置:</td>
                    <td><input name="gps_location" type="text" value="${requestScope.historyTracking.gps_location}" autocomplete="off" tabindex="1"/></td>
                </tr>

                <tr>
                    <td>连接时间:</td>
                    <td><input name="connected_time" type="text" value="${requestScope.historyTracking.connected_time}" autocomplete="off" tabindex="1"/></td>
                </tr>

                <tr>
                    <td>离开时间:</td>
                    <td><input name="disconnected_time" type="text" value="${requestScope.historyTracking.disconnected_time}" autocomplete="off" tabindex="1"/></td>
                </tr>

                <tr>
                    <td>地区编号:</td>
                    <td><input name="district_bs_no" type="text" value="${requestScope.historyTracking.district_bs_no}" autocomplete="off" tabindex="1"/></td>
                </tr>

                <tr>
                    <td><button id="submit_button">确认修改</button></td>
                </tr>
                </tbody>
            </table>
        </form>
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
