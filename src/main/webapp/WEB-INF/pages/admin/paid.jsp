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
                已缴纳租金
                <small>管理员</small>
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
                        <!-- form start -->
                        <form action="${basePath}/paid/findAllPaid.go" method="post" name="myform">
                            <table class="search-tab">
                                <tr>
                                    <th width="95">租客姓名：</th>
                                    <td><input class="common-text" placeholder="姓名" name="zuname" value="${vo.zuname }"
                                               id="zuname"
                                               type="text"></td>
                                    <th width="95">应缴日期:</th>
                                    <td><input class="common-text" name="fromdate" placeholder="请选择应缴日期"
                                               value="${vo.fromdate}"
                                               id="fromdate" type="text" readonly></td>
                                    <th width="95">实缴日期:</th>
                                    <td><input class="common-text" placeholder="请选择实缴日期" name="todate"
                                               value="${vo.todate}"
                                               id="todate" type="text" readonly></td>
                                    <input type="hidden" id="page" name="page" value="">

                                    <td><input class="btn btn-primary btn2" name="sub" value="查询" type="submit"></td>

                                </tr>
                            </table>
                        </form>
                        <!-- form end -->
                    </div>
                    <!-- div box -->
                </div>
                <!-- div col-md-12 -->

                <br>
                <div class="result-content">
                    <table id=grid
                           class="result-tab" width="100%">

                        <tbody>
                        <tr style="text-align: center; FONT-WEIGHT: bold; FONT-STYLE: normal; BACKGROUND-COLOR: #eeeeee; TEXT-DECORATION: none">
                            <td>房屋id</td>
                            <td>地址</td>
                            <td>租金</td>
                            <td>租金应缴日期</td>
                            <td>租金实缴日期</td>
                            <td>租客姓名</td>
                            <td>状态</td>
                            <td>操作</td>
                        </tr>


                        <c:forEach items="${paid}" var="paid">
                            <tr style="text-align: center; FONT-WEIGHT: normal; FONT-STYLE: normal; BACKGROUND-COLOR: white; TEXT-DECORATION: none">
                                <td>${paid.house_id }</td>
                                <td>${paid.address}</td>
                                <td>${paid.price}</td>
                                <td>${paid.date}</td>
                                <td>${paid.paydate}</td>
                                <td>${paid.name}</td>
                                <td>${paid.status}</td>
                                <td>
                                    <a class="link-update"
                                       href="${basePath}/paid/deletePaid.go?id=${paid.id}"
                                       onclick="return window.confirm('确定删除吗？')">删除</a>
                                    &nbsp;&nbsp;
                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
                <tr>
                    <div style="LINE-HEIGHT: 20px; HEIGHT: 20px; TEXT-ALIGN: right; margin-top:10px">
                        以上共缴租金：<B style="color:red">${sum} </B>元
                    </div>
                </tr>
            </div>
        </section>
    </div>
</div>
</body>
</html>