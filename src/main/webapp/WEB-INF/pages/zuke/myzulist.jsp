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
            我的租赁
            <small>租客</small>
        </h1>
        <ol class="breadcrumb">
            <li><a href="/toIndex.go"><i class="fa fa-dashboard"></i> 首页</a></li>
            <li><a href="/getMyApply.go"><i class="fa fa-car"></i> 我的看房申请</a></li>
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
                          action="/zulist/myzulist.action" method=post>
                        <div class="result-title">
                            <div class="result-list"></div>
                        </div>

                        <div class="result-content">
                            <table id=grid class="result-tab" width="100%">
                                <tbody>
                                <tr style="text-align: center; FONT-WEIGHT: bold; FONT-STYLE: normal; BACKGROUND-COLOR: #eeeeee; TEXT-DECORATION: none">

                                    <td>租赁人</td>
                                    <td>租赁人身份证号</td>
                                    <td>租赁人联系电话</td>
                                    <td>房屋id</td>
                                    <td>地址</td>
                                    <td>价格</td>
                                    <td>操作</td>

                                </tr>
                                <c:forEach items="${userlistzu}" varStatus="i" var="userlist">
                                    <tr style="text-align: center; FONT-WEIGHT: normal; FONT-STYLE: normal; BACKGROUND-COLOR: white; TEXT-DECORATION: none">
                                    <c:forEach items="${userlist.zulist}" var="zulist">
                                        <td>${userlist.name }</td>

                                        <td>${userlist.idcard}</td>

                                        <td>${userlist.phone}</td>

                                        <td>${zulist.house_id}</td>
                                        <td>${zulist.address}</td>
                                        <td>${zulist.price}</td>

                                        <td><a class="link-update"
                                               href="/Contract/zukeSeeContract.go?house_id=${zulist.house_id }">查看合同</a>
                                            &nbsp;&nbsp; <a class="link-del"
                                                            href="/applyout/insertApplyout.go?house_id=${zulist.house_id }"
                                                            onclick="return window.confirm('确定要申请退租吗？')">申请退租</a></td>
                                        </tr>
                                    </c:forEach>
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