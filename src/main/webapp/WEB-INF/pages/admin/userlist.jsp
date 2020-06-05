<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="UTF-8">
    <title>房屋租赁系统</title>
    <link rel="stylesheet" type="text/css" href="/css/common.css"/>
    <link rel="stylesheet" type="text/css" href="/css/main.css"/>
    <script type="text/javascript" src="/js/jquery-2.1.1.min.js"></script>
    <script type="text/javascript" src="/js/libs/modernizr.min.js"></script>

    <script type="text/javascript">
        var error = "${param.error}";
        if (error == "deletesuccess") {
            alert("删除成功！");
        }
    </script>
</head>

<body>
<!-- 内容区域 -->
<!-- Content Wrapper. Contains page content -->
<div>
    <!-- Content Header (Page header) -->
    <section class="content-header">
        <h1>
            用户列表
            <small>管理员</small>
        </h1>
        <ol class="breadcrumb">
            <li><a href="/toIndex.go"><i class="fa fa-dashboard"></i> 首页</a></li>
            <li><a href="/zuList/findZulist.go"><i class="fa fa-car"></i> 在租列表</a></li>
        </ol>
    </section>

    <!-- Main content -->
    <section class="content">
        <div class="row">
            <div class="col-xs-12">
                <div class="box">

                    <div class="box-body">
                        <form id="houseForm" name="houseForm" action="/findalluserlist.action" method=post>
                            <div class="result-content">
                                <table id=grid
                                       class="result-tab" width="100%">
                                    <tbody>
                                    <tr style="text-align:center; FONT-WEIGHT: bold; FONT-STYLE: normal; BACKGROUND-COLOR: #eeeeee; TEXT-DECORATION: none">
                                        <td>租客用户名</td>
                                        <td>租客姓名</td>
                                        <td>租客身份证号码</td>
                                        <td>租客联系电话</td>
                                        <td>操作</td>
                                    </tr>

                                    <c:forEach items="${userlist}" var="userlist">
                                        <tr style="text-align: center; FONT-WEIGHT: normal; FONT-STYLE: normal; BACKGROUND-COLOR: white; TEXT-DECORATION: none">
                                            <td>${userlist.user.username}</td>
                                            <td>${userlist.name}</td>
                                            <td>${userlist.idcard}</td>
                                            <td>${userlist.phone}</td>
                                            <td>
                                                <a class="link-update"
                                                   href="/deleteUserlist.go?id=${userlist.user.id}"
                                                   onclick="return window.confirm('确定删除吗？')">删除</a>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                        </form>
                    </div>
                    <!-- /.box-body -->
                </div>
                <!-- /.box -->
            </div>
            <!-- /.col -->
        </div>
        <!-- /.row -->
    </section>
    <!-- /.content -->
</div>
<!-- /.content-wrapper -->
</body>
</html>