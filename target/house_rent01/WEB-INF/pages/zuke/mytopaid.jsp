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

    <style type="text/css">
        .sum {
            float: right;
        }
    </style>

    <script type="text/javascript">
        $().ready(function () {
            // 在键盘按下并释放及提交后验证提交表单
            $("#fromdate").datepicker();
            $("#todate").datepicker();
        });
    </script>

</head>
<body>
<div>
    <!-- 内容区域 -->
    <!-- Content Wrapper. Contains page content -->
    <div>
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>
                我的未缴租金
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
                            <form action="${basePath}/paid/myTopaidList.go" method="post" name="myform">


                                <div class="result-content">
                                    <table id=grid
                                           class="result-tab" width="100%">
                                        <tbody>
                                        <tr style="text-align: center; FONT-WEIGHT: bold; FONT-STYLE: normal; BACKGROUND-COLOR: #eeeeee; TEXT-DECORATION: none">
                                            <td>房屋id</td>
                                            <td>地址</td>
                                            <td>应缴租金</td>
                                            <td>租金应缴日期</td>
                                            <td>租客姓名</td>
                                            <td>状态</td>
                                            <td>操作</td>
                                        </tr>

                                        <c:forEach items="${topaid}" var="topaid">
                                            <tr style="text-align: center; FONT-WEIGHT: normal; FONT-STYLE: normal; BACKGROUND-COLOR: white; TEXT-DECORATION: none">
                                                <td>${topaid.house_id }</td>

                                                <td>${topaid.address}</td>

                                                <td>${topaid.price}</td>
                                                <td>${topaid.date}</td>

                                                <td>${topaid.name}</td>
                                                <td>${topaid.status}</td>

                                                <td><a class="link-update"
                                                       href="${basePath}/paid/goToPay.go?id=${topaid.id }"
                                                       onclick="return window.confirm('确定要支付吗?')">支付租金</a>
                                                    &nbsp;&nbsp;
                                                </td>

                                            </tr>

                                        </c:forEach>

                                        </tbody>
                                    </table>
                                </div>
                            </form>
                        </div>
                    </div>
                    <!-- /.box-body -->
                </div>
                <!-- /.box -->
            </div>
            <!-- /.row -->
        </section>
        <!-- /.content -->
    </div>
</div>
<!-- /.content-wrapper -->

</body>
</html>