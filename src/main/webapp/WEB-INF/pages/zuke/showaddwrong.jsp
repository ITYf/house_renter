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
        if (error == "insertwrong") {
            alert("报障信息已添加，管理员将收到你的请求。");
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
            我要报障
            <small>租客</small>
        </h1>
        <ol class="breadcrumb">
            <li><a href="/toIndex.go"><i class="fa fa-dashboard"></i> 首页</a></li>
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
                    <form id="houseForm" name="houseForm" action="#" method="post">
                        <div class="result-content">
                            <table id=grid
                                   class="result-tab" width="100%">
                                <tbody>
                                <tr style="text-align: center; FONT-WEIGHT: bold; FONT-STYLE: normal; BACKGROUND-COLOR: #eeeeee; TEXT-DECORATION: none">
                                    <td>房屋id</td>
                                    <td>地址</td>
                                    <td>租金</td>
                                    <td>租赁人</td>
                                    <td>租赁人身份证号</td>
                                    <td>租赁人联系电话</td>
                                    <td>操作</td>
                                </tr>


                                <c:forEach items="${zulist}" var="zulist">
                                    <tr style="text-align: center; FONT-WEIGHT: normal; FONT-STYLE: normal; BACKGROUND-COLOR: white; TEXT-DECORATION: none">
                                        <td>${zulist.house_id }</td>
                                        <td>${zulist.address}</td>
                                        <td>${zulist.price}</td>
                                        <td>${zulist.userlist.name}</td>
                                        <td>${zulist.userlist.idcard}</td>
                                        <td>${zulist.userlist.phone}</td>
                                        <td><a class="link-update"
                                               href="${basePath}/wrong/addWrong.go?id=${zulist.zid }">报障</a>
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