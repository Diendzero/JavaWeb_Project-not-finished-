<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 12641
  Date: 2022/9/1
  Time: 21:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>行程管理</title>
    <%--静态包含base标签和jQuery文件--%>
    <%@include file="/pages/Common/Head.jsp"%>

    <link type="text/css" rel="stylesheet" href="statics/css/HistoryTrackingManagerStyle.css">

    <script type="text/javascript">
        $(function () {
            $("#add_button").click(function () {
                $("#function_div_delete").hide();
                $("#function_div_edit").hide();
                $("#function_div_add").show();
            })
        })

        $(function () {
            $("#delete_button").click(function () {
                $("#function_div_add").hide();
                $("#function_div_edit").hide();
                $("#function_div_delete").show();
            })
        })

        $(function () {
            $("#edit_button").click(function () {
                $("#function_div_add").hide();
                $("#function_div_delete").hide();
                $("#function_div_edit").show();
            })
        })

        function confirm1() {
            if (confirm("确认删除ID序列为" + "[" + $(this).parent().find("td:first").text() + "]" + "的记录？")){
                alert("删除成功！");
            } else {
                alert("取消成功！");
            }
        }

        function confirm2() {
            if (confirm("确认删除用户名为" + "[" + $(this).parent().find("td:first").text() + "]" + "的所有记录？")){
                alert("删除成功！");
            } else {
                alert("取消成功！");
            }
        }
    </script>
</head>
<body>
    <div>
        <ul id="manager_historyTracking_ul_horizontal">
            <li id="manager_historyTracking_title">后台管理</li>
            <li class="manager_historyTracking_li_horizontal"><a href="http://localhost:8080/SummerProject/">返回首页</a></li>
            <li class="manager_historyTracking_li_horizontal"><a href="/pages/Manager/HealthManager.jsp">健康管理</a></li>
            <li id="manager_historyTracking_li_horizontal_special">行程管理</li>
        </ul>
    </div>

    <div id="function_div">
        <form id="function_div_add" action="Manager/historyTrackingServlet" method="post">
            <input type="hidden" name="action" value="add">
            <div id="function_div_addImg"><img class="square_plus_regular" src="statics/Picture/square-plus-regular.svg"></div>
            <div id="function_div_addTable">
                <table>
                    <thead>
                    <tr>
                        <td class="function_div_table_td">用户名:<input name="username" class="function_div_table_input" type="text" placeholder="请输入用户名" autocomplete="off" tabindex="1" style="width: 110px;"/></td>
                        <td class="function_div_table_td">GPS位置:<input name="gps_location" class="function_div_table_input" type="text" placeholder="请输入GPS位置" autocomplete="off" tabindex="1"/></td>
                        <td class="function_div_table_td">连接时间:<input name="connected_time" class="function_div_table_input" type="text" placeholder="请输入连接时间" autocomplete="off" tabindex="1"/></td>
                        <td class="function_div_table_td">离开时间:<input name="disconnected_time" class="function_div_table_input" type="text" placeholder="请输入离开时间" autocomplete="off" tabindex="1"/></td>
                        <td class="function_div_table_td">地区编号:<input name="district_bs_no" class="function_div_table_input" type="text" placeholder="请输入地区编号" autocomplete="off" tabindex="1"/></td>
                        <td class="function_div_table_td"><button id="submit_button">提交</button></td>
                    </tr>
                    </thead>
                </table>
            </div>
        </form>

        <div id="function_div_delete">
            <div id="function_div_deleteImg"><img class="square_plus_regular" src="statics/Picture/trash-can-regular.svg"></div>
            <div id="function_div_deleteArea">
                <form id="function_div_delete1" action="Manager/historyTrackingServlet" method="post">
                    <input type="hidden" name="action" value="deleteById">
                    <div>
                        <td class="function_div_table_td">按ID序列删除记录:<input name="history_tracking_id" class="function_div_table_input" type="text" placeholder="请输入ID序列" autocomplete="off" tabindex="1" style="width: 110px;"/></td>
                        <td class="function_div_table_td"><button id="confirm_button1" onclick="confirm1()">确认</button></td>
                    </div>
                </form>

                <form id="function_div_delete2" action="Manager/historyTrackingServlet" method="post">
                    <input type="hidden" name="action" value="deleteByUsername">
                    <div>
                        <td class="function_div_table_td">按用户名删除记录:<input name="username" class="function_div_table_input" type="text" placeholder="请输入用户名" autocomplete="off" tabindex="1" style="width: 110px;"/></td>
                        <td class="function_div_table_td"><button id="confirm_button2" onclick="confirm2()" href="Manager/historyTrackingServlet?action=delete&username=${username}">确认</button></td>
                    </div>
                </form>
            </div>
        </div>

        <div id="function_div_edit">
            <div id="function_div_editImg"><img class="square_plus_regular" src="statics/Picture/pen-to-square-regular.svg"></div>
            <div id="function_form_edit">
                <form action="Manager/historyTrackingServlet" method="post">
                    <input type="hidden" name="action" value="getHistoryTracking">
                    <div>
                        <td class="function_div_table_td">ID序列:<input name="history_tracking_id" class="function_div_table_input" type="text" placeholder="请输入需要修改的记录的ID序列" autocomplete="off" tabindex="1" style="width: 220px;"/></td>
                        <td class="function_div_table_td"><button id="edit_confirm_button">确认</button></td>
                    </div>
                </form>
            </div>
        </div>

    </div>

    <div id="main_div">
        <div id="main_subdiv1">
            <table>
                <thead>
                <tr>
                    <th>ID序列</th>
                    <th>用户名</th>
                    <th>GPS位置</th>
                    <th>连接时间</th>
                    <th>离开时间</th>
                    <th>地区编号</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${requestScope.page.item}" var="page">
                    <tr>
                        <td>${page.history_tracking_id}</td>
                        <td>${page.username}</td>
                        <td>${page.gps_location}</td>
                        <td>${page.connected_time}</td>
                        <td>${page.disconnected_time}</td>
                        <td>${page.district_bs_no}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>

            <div id="page_nav">
                <a href="#">上一页</a>
                <a href="#">1</a>
                【${requestScope.page.pageNo}】
                <a href="#">3</a>
                <a href="#">下一页</a>
                <a href="#">尾页</a>
                共${requestScope.page.pageTotal}页，共${requestScope.page.pageTotalCount}条记录 到第<input value="3" name="pn" id="pn_input"/>页
                <input type="button" value="确认">
            </div>
        </div>

        <div id="main_subdiv2">
            <table>
                <thead>
                    <tr>
                        <td>功能区</td>
                    </tr>
                </thead>

                <tbody>
                    <tr>
                        <td>
                            <button style="font-size: larger" id="add_button">
                                <div>
<%--                                    <div><a href="pages/Manager/AddHistoryTracking.jsp"><img class="square_plus_regular" src="statics/Picture/square-plus-regular.svg"></a></div>--%>
                                    <div><img class="square_plus_regular" src="statics/Picture/square-plus-regular.svg"></div>
                                    <div style="font-size: 10px">添加</div>
                                </div>
                            </button>
                        </td>

                        <td>
                            <button style="font-size: larger" id="delete_button">
                                <div>
                                    <div><img src="statics/Picture/trash-can-regular.svg" style="height: 25px; width: 25px;"></div>
                                    <div style="font-size: 10px">删除</div>
                                </div>
                            </button>
                        </td>
                    </tr>

                    <tr>
                        <td>
                            <button id="edit_button" style="font-size: larger">
                                <div>
                                    <div><img src="statics/Picture/pen-to-square-regular.svg" style="height: 25px; width: 25px;"></div>
                                    <div style="font-size: 10px">修改</div>
                                </div>
                            </button>
                        </td>
                    </tr>
                </tbody>
            </table>
        </div>


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
