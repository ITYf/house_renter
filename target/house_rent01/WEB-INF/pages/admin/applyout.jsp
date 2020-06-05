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
        if (error == "applysuccess") {

            alert("申请已提交，请耐心等待管理员的处理。如需查看进度，可前往“我的退租申请”中查看");
        } else if (error == "deletesucess") {
            alert("删除成功");
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
            退租申请列表
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
                        <form id="houseForm" name="houseForm"
                              action="#"
                              method=post>

                            <div class="result-content">
                                <table id=grid
                                       class="result-tab" width="100%">
                                    <tbody>
                                    <tr style="text-align: center; FONT-WEIGHT: bold; FONT-STYLE: normal; BACKGROUND-COLOR: #eeeeee; TEXT-DECORATION: none">

                                        <td>房屋id</td>
                                        <td>地址</td>
                                        <td>状态</td>
                                        <td>申请人</td>
                                        <td>申请人身份证号</td>
                                        <td>申请人联系电话</td>
                                        <td>操作</td>

                                    </tr>
                                    <c:forEach items="${applyout}" var="applyout">

                                        <tr style="text-align: center; FONT-WEIGHT: normal; FONT-STYLE: normal; BACKGROUND-COLOR: white; TEXT-DECORATION: none">
                                            <td>${applyout.house_id}</td>
                                            <td>${applyout.address}</td>
                                            <td><font color="red">${applyout.status}</font></td>
                                            <c:forEach items="${applyout.userlist}" var="userlist">
                                                <td>${userlist.name}</td>
                                                <td>${userlist.idcard}</td>
                                                <td>${userlist.phone}</td>
                                                <td>
                                                    <c:choose>
                                                        <c:when test="${applyout.status!='申请中'}">
                                                            <a class="link-del"
                                                               href="/applyout/deleteApplyout.go?id=${applyout.id}"
                                                               onclick="return window.confirm('确定要删除该记录吗？')">删除</a>
                                                        </c:when>
                                                        <c:otherwise>
                                                            <a class="link-update"
                                                               href="/applyout/agreeApplyout.go?id=${applyout.id }"
                                                               onclick="return window.confirm('确定要同意退租吗？')">同意</a>
                                                            &nbsp;&nbsp;

                                                            <a class="link-del"
                                                               href="/applyout/refuseApplyout.go?id=${applyout.id }"
                                                               onclick="return window.confirm('确定要拒绝吗？')">拒绝</a>
                                                        </c:otherwise>
                                                    </c:choose>
                                                </td>
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