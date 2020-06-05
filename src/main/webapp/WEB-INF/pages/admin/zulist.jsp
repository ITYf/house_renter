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
        if (error == "zusuccess") {

            alert("该房已租赁，可在租赁列表中查看详情！");
        } else if (error == "checkoutsuccess") {
            alert("该合同已被终止！");
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
            在租列表
            <small>管理员</small>
        </h1>
        <ol class="breadcrumb">
            <li><a href="/toIndex.go"><i class="fa fa-dashboard"></i> 首页</a></li>
            <li><a href="/findApplyList.go"><i class="fa fa-building"></i> 看房申请</a></li>
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

                    <!-- form start -->
                    <form id="houseForm" name="houseForm"
                          action="/text2/zulist/findzulist.action"
                          method=post>
                        <div class="result-title">
                            <div class="result-list">


                            </div>
                        </div>

                        <div class="result-content">
                            <table id=grid
                                   class="result-tab" width="100%">
                                <tbody>
                                <tr style="text-align:center; FONT-WEIGHT: bold; FONT-STYLE: normal; BACKGROUND-COLOR: #eeeeee; TEXT-DECORATION: none">
                                    <td>房屋id</td>
                                    <td>地址</td>
                                    <td>价格</td>
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
                                               href="/Contract/seeContract.go?house_id=${zulist.house_id }">查看合同</a>
                                            &nbsp;&nbsp;

                                            <a class="link-del"
                                               href="/Contract/deleteContract.go?house_id=${zulist.house_id }"
                                               onclick="return window.confirm('确定要终止合同吗？')">终止合同</a></td>
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