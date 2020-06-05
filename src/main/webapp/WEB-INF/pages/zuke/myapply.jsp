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

</head>
<body>
<!-- 内容区域 -->
<!-- Content Wrapper. Contains page content -->
<div>
    <!-- Content Header (Page header) -->
    <section class="content-header">
        <h1>
            我的看房申请记录
            <small>租客</small>
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
                        <form id="houseForm" name="houseForm"
                              action="#" method=post>

                            <div class="result-content">
                                <table id=grid class="result-tab" width="100%">
                                    <tbody>
                                    <tr style="text-align:center; FONT-WEIGHT: bold; FONT-STYLE: normal; BACKGROUND-COLOR: #eeeeee; TEXT-DECORATION: none">
                                        <td>申请人</td>
                                        <td>申请人身份证号</td>
                                        <td>申请人联系电话</td>
                                        <td>房屋id</td>
                                        <td>地址</td>
                                        <td>价格</td>
                                        <td>状态</td>
                                    </tr>

                                    <c:forEach items="${userlist}" varStatus="i" var="userlist">

                                        <tr style="text-align: center; FONT-WEIGHT: normal; FONT-STYLE: normal; BACKGROUND-COLOR: white; TEXT-DECORATION: none">
                                        <c:forEach items="${userlist.apply}" var="apply">
                                            <tr style="text-align: center">
                                                <td>${userlist.name }</td>

                                                <td>${userlist.idcard}</td>

                                                <td>${userlist.phone}</td>

                                                <td>${apply.house_id}</td>
                                                <td>${apply.address}</td>
                                                <td>${apply.price}</td>

                                                <td>${apply.status}</td>
                                            </tr>

                                        </c:forEach>
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