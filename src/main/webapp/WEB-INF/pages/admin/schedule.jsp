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
</head>
<body>
<div>
    <!-- 内容区域 -->
    <!-- Content Wrapper. Contains page content -->
    <div>
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>
                查看日程
                <small>管理员</small>
            </h1>
            <ol class="breadcrumb">
                <li><a href="/toIndex.go"><i class="fa fa-dashboard"></i> 首页</a></li>
                <li><a href="/schedule/toAddSchedule.go"><i class="fa fa-car"></i> 添加日程</a></li>
            </ol>
        </section>

        <!-- Main content -->
        <section class="content">
            <div class="row">
                <!-- left column -->
                <div class="col-md-12">
                    <!-- general form elements -->
                    <div class="box box-primary">
                        <!-- form start -->
                        <form id="houseForm" name="houseForm"
                              action="#"
                              method=post>

                            <div class="result-content">
                                <table id=grid
                                       class="result-tab" width="100%">
                                    <tbody>
                                    <tr style="text-align: center; FONT-WEIGHT: bold; FONT-STYLE: normal; BACKGROUND-COLOR: #eeeeee; TEXT-DECORATION: none">
                                        <td>日期</td>
                                        <td>日程</td>
                                        <td>操作</td>
                                    </tr>

                                    <c:forEach items="${schedule}" var="schedule">
                                        <tr style="text-align: center; FONT-WEIGHT: normal; FONT-STYLE: normal; BACKGROUND-COLOR: white; TEXT-DECORATION: none">
                                            <td>${schedule.date}</td>
                                            <td>${schedule.content}</td>
                                            <td>
                                                <a class="link-update"
                                                   href="${basePath}/schedule/toUpdateSchedule.go?id=${schedule.id}">修改</a>
                                                &nbsp;&nbsp;
                                                <input type="hidden" name="id" value="${houselist.id}"/>
                                                <a class="link-del" href="${basePath}/schedule/deleteSchedule.go?id=${schedule.id}"
                                                   onclick="return window.confirm('确定删除吗？')"
                                                >删除</a></td>
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
            <!-- /.row -->
        </section>
        <!-- /.content -->
    </div>
</div>
<!-- /.content-wrapper -->
</body>
</html>