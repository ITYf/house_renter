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

<!-- 内容区域 -->
<!-- Content Wrapper. Contains page content -->
<div>
    <!-- Content Header (Page header) -->
    <section class="content-header">
        <h1>
            看房申请列表
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
                              action="/houseList.go"
                              method=post>

                            <div class="result-content">
                                <table id=grid class="result-tab" width="100%">
                                    <tr style="text-align: center; FONT-WEIGHT: bold; FONT-STYLE: normal; BACKGROUND-COLOR: #eeeeee; TEXT-DECORATION: none">
                                        <td>房屋id</td>
                                        <td>地址</td>
                                        <td>面积</td>
                                        <td>价格</td>
                                        <td>申请人姓名</td>
                                        <td>申请人身份证号</td>
                                        <td>申请人电话号码</td>
                                        <td>操作</td>
                                    </tr>

                                    <c:forEach items="${applylist}" var="apply">
                                        <tr style="text-align: center; FONT-WEIGHT: normal; FONT-STYLE: normal; BACKGROUND-COLOR: white; TEXT-DECORATION: none">
                                            <td>${apply.house_id }</td>
                                            <td>${apply.address}</td>
                                            <td>${apply.area}</td>
                                            <td>${apply.price}</td>
                                            <td>${apply.userlist.name}</td>
                                            <td>${apply.userlist.idcard}</td>
                                            <td>${apply.userlist.phone}</td>
                                            <td>
                                                <a class="link-update"
                                                   href="/zuList/toAddContract.go?house_id=${apply.house_id}">同意租赁</a>
                                                &nbsp;&nbsp;
                                                <input type="hidden" name="id" value="${houselist.id}"/>
                                                <a class="link-del"
                                                   href="/refuseApply.go?house_id=${apply.house_id}"
                                                   onclick="return window.confirm('确定要拒绝该租客的申请吗？')">拒绝租赁</a></td>
                                            </td>
                                        </tr>
                                    </c:forEach>
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