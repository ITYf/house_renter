<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

    <style type="text/css">
        .title {
            margin: 10px auto;
            text-align: center;
            font-size: 30px;
        }

        .button {
            margin: 10px auto;
            text-align: center;
        }
    </style>
    <script type="text/javascript">
        function to_dayin() {
            alert("打印中...");
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
            查看合同
            <small>管理员</small>
        </h1>
        <ol class="breadcrumb">
            <li><a href="/toIndex.go"><i class="fa fa-dashboard"></i> 首页</a></li>
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
                    <br>
                    <!-- form start -->
                    <form name="hetong" action="/Contract/updateContract.go">
                        <div class="title">房屋租赁合同</div>
                        <input type="hidden" name="house_id" value="${contract.house_id}"/>
                        &emsp;<p>出租方：<span name="chuzu"><strong>${contract.chuzu}</strong></span>（以下简称甲方）；</p>　　　
                        &emsp;<p>承租方：<span name="zuke"><strong>${contract.zuke}</strong></span>（以下简称乙方）。　</p>　
                        &emsp;<p>租赁房屋地址：<span name="zuke"><strong>${contract.address}</strong></span>　</p>　
                        &emsp;<p>依据《XXXX共和国合同法》有关条款，甲乙双方经过充分协商，就乙方租赁甲方房屋事宜达成如下协议：</p>
                        &emsp;<p>一、乙方租赁甲方房屋，以下简称租赁房屋。</p>
                        &emsp;<p>二、起租时间：<span name="fromdate"><strong>${contract.fromdate}</strong></span>，退租时间：<span
                                name="todate"><strong>${contract.todate}</strong></span>。
                        在合同签订之日，乙方需向甲方支付房屋租金￥<span name="price"><strong>${contract.price}</strong></span>。如续租，请提前3天通知甲方，并重新办理租赁手续。<br/>
                        </p>　　　　
                        &emsp;<p>三、违约处理：</p>　
                        &emsp;<p>甲方违约：</p>　
                        &emsp;<p>1．如甲方未能及时将押金退还乙方，甲方每天应按押金的2％向乙方支付违约金；</p>
                        &emsp;<p>2．如甲方提供的维修服务项目与协议不相符，乙方有权提前退租，甲方应全额退还剩余的租金。</p>
                        &emsp;<p>乙方违约：</p>　　
                        &emsp;<p>1．如乙方不按时缴纳租金，甲方有权在其押金中扣除，同时收回房屋，所有损失由乙方负责；</p>　
                        &emsp;<p>2．如果乙方在租赁期限未满时退租，甲方仅退还剩余租金的40％（租期未满一个月的不在此例）；</p>　
                        &emsp;<p>四、本协议书一式两份，甲乙双方各执一份；本协议甲乙双方签字后生效。补充协议亦属于合同的一部分。</p>　
                        　<br/>　　&emsp;甲方（盖章）：_________　　　　　　　　&emsp;乙方（盖章）：_________　　<br/>　
                        　&emsp;法定代表人（签字）：_________　　　　　&emsp;法定代表人（签字）：_________　　<br/>　　
                        &emsp;担保人（签章）：_________　　<br/>　　
                        &emsp;_________年____月____日　　　　　　　　&emsp;_________年____月____日　　<br/>　　
                        &emsp;签订地点：_________　　　　　　　　　　&emsp;签订地点：_________
                        <br><br>
                        <div class="button">
                            <input class="btn btn-primary btn6 mr10" value="修改合同" type="submit">
                            <input class="btn btn6" onclick="javascript:to_dayin()" value="打印合同" type="button">
                            <input class="btn btn6" onclick="history.go(-1)" value="返回" type="button">
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