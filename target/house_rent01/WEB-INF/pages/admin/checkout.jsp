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
            在租列表
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
            <!-- left column -->
            <div class="col-md-12">
                <!-- general form elements -->
                <div class="box box-primary">
                    <br/>
                    <!-- form start -->
                    <form id="houseForm" name="houseForm"
                          action="/text2/checkout/getallcheckout.action"
                          method=post>
                        <div class="result-content">
                            <table id=grid
                                   class="result-tab" width="100%">
                                <tbody>
                                <tr style="text-align: center; FONT-WEIGHT: bold; FONT-STYLE: normal; BACKGROUND-COLOR: #eeeeee; TEXT-DECORATION: none">
                                    <td>房屋id</td>
                                    <td>地址</td>


                                    <td>申请人姓名</td>
                                    <td>申请人身份证号</td>
                                    <td>申请人电话号码</td>
                                    <td>状态</td>
                                    <td>操作</td>


                                </tr>
                                <c:forEach items="${checkout}" var="checkout">
                                    <tr style="text-align: center; FONT-WEIGHT: normal; FONT-STYLE: normal; BACKGROUND-COLOR: white; TEXT-DECORATION: none">
                                        <td>${checkout.house_id }</td>

                                        <td>${checkout.address}</td>


                                        <td>${checkout.userlist.name}</td>

                                        <td>${checkout.userlist.idcard}</td>
                                        <td>${checkout.userlist.phone}</td>
                                        <td>${checkout.status}</td>
                                        <td>

                                            <input type="hidden" name="id" value="${checkout.id}"/>
                                            <a class="link-del"
                                               href="/checkout/adminDeleteCheckout.go?id=${checkout.id}"
                                               onclick="return window.confirm('确定要删除该记录吗？')">删除</a></td>
                                        </td>
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