<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
    <meta charset="UTF-8">
    <title>房屋租赁系统</title>
    <link rel="stylesheet" type="text/css" href="/css/common.css"/>
    <link rel="stylesheet" type="text/css" href="/css/main.css"/>
    <script type="text/javascript" src="/js/libs/modernizr.min.js"></script>
    <script type="text/javascript" src="/js/jquery-2.1.1.min.js"></script>
    <script type="text/javascript" src="/js/jquery.validate.min.js"></script>
    <style>
        .error {
            font-size: 13px;
            color: red;
        }

    </style>
    <script type="text/javascript">
        $().ready(function () {
            // 在键盘按下并释放及提交后验证提交表单
            $("#myform").validate({

                rules: {
                    houseid: {
                        required: true,
                    },

                    address: {
                        required: true,

                    },
                    area: {
                        required: true,
                        min: 0

                    },
                    price: {
                        required: true,
                        min: 0

                    }

                },
                messages: {
                    houseid: {
                        required: "房屋id不能为空！",
                    },

                    address: {
                        required: "地址不能为空！",

                    },
                    area: {
                        required: "面积不能为空！",
                        min: "请输入正确的面积"

                    },
                    price: {
                        required: "价格不能为空！",
                        min: "请输入正确的租金"

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
            添加房源
            <small>管理员</small>
        </h1>
        <ol class="breadcrumb">
            <li><a href="/toIndex.go"><i class="fa fa-dashboard"></i> 首页</a></li>
            <li><a href="/toAhouseList.go"><i class="fa fa-dashboard"></i> 房源列表</a></li>
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
                    <form action="/addHouse.go" method="post" id="myform" name="myform"
                          enctype="application/x-www-form-urlencoded"><!-- enctype:对提交的表单数据的编码方式 -->
                        <table class="insert-tab" width="100%">
                            <tbody>
                            <th><i class="require-red">*</i>房屋id：</th>
                            <td>
                                <input class="common-text required" value="${houselist.houseid}" id="houseid" name="houseid"
                                       size="50" type="text">
                            </td>
                            </tr>
                            <tr>
                                <th><i class="require-red">*</i>地址：</th>
                                <td><input class="common-text" name="address" value="${houselist.address }" id="address" size="50"
                                           type="text"></td>
                            </tr>
                            <tr>
                                <th><i class="require-red">*</i>面积：</th>
                                <td><input class="common-text" name="area" value="${houselist.area }" id="area" size="50"
                                           type="text"></td>
                            </tr>
                            <tr>
                                <th><i class="require-red">*</i>租金：</th>
                                <td><input class="common-text" name="price" value="${houselist.price }" id="price" size="50"
                                           type="text"></td>
                            </tr>
                            <tr>
                                <th><i class="require-red">*</i>状态：</th>
                                <td>
                                    <select name="status" id="status" class="required">

                                        <option value="已租赁" <c:if test="${houselist.status == '已租赁'}">selected</c:if>>已租赁</option>
                                        <option value="未租赁" <c:if test="${houselist.status == '未租赁'}">selected</c:if>>未租赁</option>
                                    </select>
                                </td>
                            </tr>
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