<%--
  User: YanFei
  Date: 2020/4/12
  Time: 20:12
--%>
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
    <!-- 页面自适应布局 -->
    <meta content="width=device-width,initial-scale=1,maximum-scale=1,user-scalable=no" name="viewport">

    <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <script type="text/javascript" src="js/jquery-2.1.1.min.js"></script>
    <script type="text/javascript" src="js/libs/modernizr.min.js"></script>

    <script type="text/javascript">
        var error = "${param.error}";
        if (error == "fail") {

            alert("您还没完善个人信息，请到'其他操作'中完善个人信息后再进行申请操作");
        } else if (error == "applySuccess") {
            alert("申请成功，请耐心等待房东联系您！");
        }

    </script>

</head>
<body class="hold-transition skin-purple sidebar-mini">


<!-- 内容区域 -->
<!-- Content Wrapper. Contains page content -->
<div>
    <!-- Content Header (Page header) -->
    <section class="content-header">
        <h1>
            房源列表
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
                        <table id="example1" class="table table-bordered table-striped">
                            <thead>
                            <tr>
                                <th>房屋id</th>
                                <th>地址</th>
                                <th>面积</th>
                                <th>价格</th>
                                <th>状态</th>
                                <th>操作</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${houselist}" var="houselist">
                                <tr style="text-align: center">
                                    <td>${houselist.houseid }</td>
                                    <td>${houselist.address}</td>
                                    <td>${houselist.area}</td>
                                    <td>${houselist.price}</td>
                                    <td>${houselist.status}</td>
                                    <td>
                                        <c:choose>
                                            <c:when test="${ houselist.status=='未租赁'}">
                                                <a class="link-update"
                                                   href="/applyCheckUserlist.go?id=${houselist.id}">申请看房</a>
                                                &nbsp;&nbsp;
                                            </c:when>
                                            <c:when test="${ houselist.status=='已租赁'}">
                                                该房已被租赁
                                                &nbsp;&nbsp;
                                            </c:when>
                                            <c:otherwise>
                                                该房已被申请
                                            </c:otherwise>
                                        </c:choose>
                                    </td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
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


<!-- page script -->
<!-- 内容区域 /-->


<script>
    $(document).ready(function () {
        // 选择框
        $(".select2").select2();

        // WYSIHTML5编辑器
        $(".textarea").wysihtml5({
            locale: 'zh-CN'
        });
    });


    // 设置激活菜单
    function setSidebarActive(tagUri) {
        var liObj = $("#" + tagUri);
        if (liObj.length > 0) {
            liObj.parent().parent().addClass("active");
            liObj.addClass("active");
        }
    }


    $(function () {
        $("#example1").DataTable();
        $('#example2').DataTable({
            "paging": true,
            "lengthChange": false,
            "searching": false,
            "ordering": true,
            "info": true,
            "autoWidth": false
        });
    });


    // 激活导航位置
    setSidebarActive("tables-data");
</script>
</body>
</html>
