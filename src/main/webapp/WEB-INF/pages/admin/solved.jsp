<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
    Date d = new Date();
    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    String now = df.format(d);
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
<!-- 内容区域 -->
<!-- Content Wrapper. Contains page content -->
<div>
    <!-- Content Header (Page header) -->
    <section class="content-header">
        <h1>
            已处理报障
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
                        <form method="post" name="myform" action="${basePath}/wrong/findAllSolved.go">
                            <table class="search-tab">
                                <tr>
                                    <th width="95">租客姓名:</th>
                                    <td><input class="common-text" placeholder="姓名" name="zuname" value="${vo.zuname }"
                                               id="zuname" type="text"></td>
                                    <th width="95">起始日期:</th>
                                    <td><input class="common-text" name="fromdate" placeholder="报障日期"
                                               value="${vo.fromdate}" id="fromdate" type="text" readonly></td>&emsp;
                                    <input type="hidden" id="page" name="page" value="">
                                    <td><input class="btn btn-primary btn2" name="sub" value="查询" type="submit"></td>
                                </tr>
                            </table>
                        </form>
                    </div>
                </div>


                <div class="result-content">
                    <table id=grid class="result-tab" width="100%">
                        <tr style="text-align: center; FONT-WEIGHT: bold; FONT-STYLE: normal; BACKGROUND-COLOR: #eeeeee; TEXT-DECORATION: none">
                            <td>房屋id</td>
                            <td>地址</td>
                            <td>报障日期</td>
                            <td>租赁人</td>
                            <td>报障内容</td>
                            <td>状态</td>
                            <td>操作</td>
                        </tr>

                        <c:forEach items="${solve}" var="solve">
                            <tr style="text-align: center; FONT-WEIGHT: normal; FONT-STYLE: normal; BACKGROUND-COLOR: white; TEXT-DECORATION: none">
                                <td>${solve.house_id }</td>
                                <td>${solve.address}</td>
                                <td>${solve.date}</td>
                                <td>${solve.name}</td>
                                <td>${solve.detail}</td>
                                <td>${solve.status}</td>
                                <td>
                                    <a class="link-update"
                                       href="/wrong/deleteSolved.go?id=${solve.id}"
                                       onclick="return window.confirm('确定删除吗？')">删除</a>
                                    &nbsp;&nbsp;
                                </td>
                            </tr>

                        </c:forEach>

                    </table>
                </div>


            </div>
            <!-- /.box-body -->
        </div>
        <!-- /.box -->
        <!-- /.row -->
    </section>
    <!-- /.content -->
</div>
<!-- /.content-wrapper -->
</body>
</html>