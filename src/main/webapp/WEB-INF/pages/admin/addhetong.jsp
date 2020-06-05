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
            $("#fromdate").datepicker();
            $("#todate").datepicker();
            $("#myform").validate({

                rules: {
                    house_id: {
                        required: true,
                    },

                    address: {
                        required: true,

                    },
                    chuzu: {
                        required: true,


                    },
                    price: {
                        required: true,
                        min: 1

                    },
                    chuzu_idcard: {
                        required: true,


                    },
                    zuke: {
                        required: true,


                    },
                    zuke_idcard: {
                        required: true,


                    },
                    fromdate: {
                        required: true,
                    },
                    todate: {
                        required: true,
                    },
                    payday: {
                        required: true,
                        min: 0,
                        max: 31,
                    }

                },
                messages: {
                    house_id: {
                        required: "房屋id不能为空",
                    },

                    address: {
                        required: "房屋地址不能为空",

                    },
                    chuzu: {
                        required: "出租方不能为空",


                    },
                    price: {
                        required: "租金不能为空",
                        min: "请输入正确的租金"

                    },
                    chuzu_idcard: {
                        required: "出租方证件号不能为空",


                    },
                    zuke: {
                        required: "承租方不能为空",


                    },
                    zuke_idcard: {
                        required: "承租方证件号不能为空",


                    },
                    fromdate: {
                        required: "起租时间不能为空",
                    },
                    todate: {
                        required: "退租时间不能为空",
                    },
                    payday: {
                        required: "每月交租日不能为空",
                        min: "每月交租日必须大于0",
                        max: "每月交租日必须小于31",
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
            添加合同信息
            <small>请确认合同信息无误后再提交</small>
        </h1>
        <ol class="breadcrumb">
            <li><a href="/toIndex.go"><i class="fa fa-dashboard"></i> 首页</a></li>
            <li><a href="/findApplyList.go"><i class="fa fa-car"></i> 看房申请</a></li>
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
                    <form action="/Contract/insertContract.go" method="post" id="myform" name="myform"
                          enctype="application/x-www-form-urlencoded">
                        <table class="insert-tab" width="100%">
                            <tbody>
                            <th><i class="require-red">*</i>房屋id：</th>
                            <td>
                                <input class="common-text required" value="${contract.house_id}" id="house_id"
                                       name="house_id"
                                       size="50" type="text" readonly>
                            </td>
                            </tr>
                            <tr>
                                <th><i class="require-red">*</i>地址：</th>
                                <td><input class="common-text" name="address" value="${contract.address }" id="address"
                                           size="50"
                                           type="text"></td>
                            </tr>
                            <tr>
                                <th><i class="require-red">*</i>出租方（甲方）：</th>
                                <td><input class="common-text" name="chuzu" value="${contract.chuzu }" id="chuzu"
                                           size="50"
                                           type="text"></td>
                            </tr>
                            <tr>
                                <th><i class="require-red">*</i>出租方（甲方）证件号码：</th>
                                <td><input class="common-text" name="chuzu_idcard" value="${contract.chuzu_idcard}"
                                           id="chuzu_idcard"
                                           size="50" type="text"></td>
                            </tr>
                            <tr>
                                <th><i class="require-red">*</i>承租方（乙方）：</th>
                                <td><input class="common-text" name="zuke" value="${contract.zuke}" id="zuke" size="50"
                                           type="text">
                                </td>
                            </tr>
                            <tr>
                                <th><i class="require-red">*</i>承租方（乙方）证件号码：</th>
                                <td><input class="common-text" name="zuke_idcard" value="${contract.zuke_idcard}"
                                           id="zuke_idcard"
                                           size="50" type="text"></td>
                            </tr>
                            <tr>
                                <th><i class="require-red">*</i>起租时间：</th>
                                <td><input class="common-text" name="fromdate" id="fromdate" value="${contract.fromdate}"
                                           size="50"
                                           type="text" readonly></td>
                            </tr>
                            <tr>
                                <th><i class="require-red">*</i>退租时间：</th>
                                <td><input class="common-text" name="todate" id="todate" value="${contract.todate}"
                                           size="50"
                                           type="text" readonly></td>
                            </tr>
                            <tr>
                                <th><i class="require-red">*</i>每月租金：</th>
                                <td><input class="common-text" name="price" id="price" value="${contract.price}" size="50"
                                           type="text"></td>
                            </tr>
                            <tr>
                                <th><i class="require-red">*</i>每月交租日（数字）：</th>
                                <td><input class="common-text" name="payday" id="payday" value="${contract.payday}"
                                           size="50"
                                           type="text"></td>
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