<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
    <style>
        .error {
            font-size: 13px;
            color: red;
        }
    </style>
    <script type="text/javascript">
        $().ready(function () {
            // 在键盘按下并释放及提交后验证提交表单

            $("#date").datepicker();
            $("#myform").validate({

                rules: {
                    date: {
                        required: true,
                    },
                    detail: {
                        required: true,

                    }
                },
                messages: {
                    date: {
                        required: "日期不能为空",
                    },
                    detail: {
                        required: "报障内容不能为空",

                    }
                }
            });
        })
    </script>
</head>
<body>

<!-- 内容区域 -->
<!-- Content Wrapper. Contains page content -->
<div>
    <!-- Content Header (Page header) -->
    <section class="content-header">
        <h1>
            添加报障信息
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
                    <form action="${basePath}/wrong/insertWrong.go" method="post"
                          enctype="application/x-www-form-urlencoded" id="myform" name="myform">
                        <table class="insert-tab" width="100%">
                            <tbody>
                            <th><i class="require-red">*</i>房屋id：</th>
                            <td>
                                <input class="common-text required" value="${zulist.house_id}" id="house_id"
                                       name="house_id"
                                       size="50" type="text" readonly>
                            </td>
                            </tr>
                            <tr>
                                <th><i class="require-red">*</i>地址：</th>
                                <td><input class="common-text" name="address" value="${zulist.address }" id="address"
                                           size="50"
                                           type="text" readonly></td>
                            </tr>
                            <tr>
                                <th><i class="require-red">*</i>租客姓名：</th>
                                <td><input class="common-text" name="name" value="${zulist.userlist.name }" id="name"
                                           size="50"
                                           type="text" readonly></td>
                            </tr>
                            <tr>
                                <th><i class="require-red">*</i>报障日期：</th>
                                <td><input class="common-text" name="date" value="" id="date" size="50" type="text"></td>
                            </tr>
                            <tr>
                                <th><i class="require-red">*</i>报障内容：</th>
                                <td><textarea class="common-text" name="detail" id="detail"
                                              style="width:430px;height:80px;"></textarea></td>
                            </tr>
                            <input type="hidden" name="userlist_id" id="userlist_id" value="${zulist.userlist_id}"/>
                            <tr>
                                <th></th>
                                <td>
                                    <input class="btn btn-primary btn6 mr10" value="提交" type="submit">
                                    <input class="btn btn6" onclick="history.go(-1)" value="返回" type="button">
                                </td>
                            </tr>
                            <tr>
                                <font id="error" color="red">${error }</font>
                            </tr>
                            </tbody>
                        </table>
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