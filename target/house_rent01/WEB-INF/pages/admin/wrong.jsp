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
    <script type="text/javascript">
        var error = "${param.error}";
        if (error == "inserttopaid") {
            alert("租金信息添加成功！");
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
            待处理报障
            <small>管理员</small>
        </h1>
        <ol class="breadcrumb">
            <li><a href="/toIndex.go"><i class="fa fa-dashboard"></i> 首页</a></li>
        </ol>
    </section>

    <!-- Main content -->
    <section class="content">
        <div class="row">
            <div class="col-xs-12">
                <div class="box">
                    <div class="box-body">
                        <form id="houseForm" name="houseForm" action="#" method=post>
                            <div class="result-content">
                                <table id=grid
                                       class="result-tab" width="100%">
                                    <tbody>
                                    <tr style="text-align: center; FONT-WEIGHT: bold; FONT-STYLE: normal; BACKGROUND-COLOR: #eeeeee; TEXT-DECORATION: none">
                                        <td>房屋id</td>
                                        <td>地址</td>
                                        <td>报障日期</td>
                                        <td>租赁人</td>
                                        <td>报障内容</td>
                                        <td>状态</td>
                                        <td>操作</td>
                                    </tr>

                                    <c:forEach items="${wrong}" var="wrong">
                                        <tr style="text-align: center; FONT-WEIGHT: normal; FONT-STYLE: normal; BACKGROUND-COLOR: white; TEXT-DECORATION: none">
                                            <td>${wrong.house_id }</td>
                                            <td>${wrong.address}</td>
                                            <td>${wrong.date}</td>
                                            <td>${wrong.name}</td>
                                            <td>${wrong.detail}</td>
                                            <td>${wrong.status}</td>
                                            <td><a class="link-update"
                                                   href="${basePath}/wrong/goToSolve.go?id=${wrong.id }"
                                                   onclick="return window.confirm('确定你已处理此报障？')">已处理</a>
                                                &nbsp;&nbsp;
                                        </tr>
                                    </c:forEach>

                                    </tbody>
                                </table>
                            </div>
                        </form>
                        <!-- form end -->
                    </div>
                    <!-- /.box -->
                </div>
            </div>
            <!-- /.row -->
    </section>
    <!-- /.content -->
</div>
<!-- /.content-wrapper -->
<!-- 内容区域 /-->
</body>
</html>