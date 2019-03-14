<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="/css/index.css"/>
    <title>用户注册</title>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.2.1.min.js"></script>
    <script type="text/javascript">
        $(function () {

            var name2 = false;
            var password3 = false;
            var password4 = false;
            var phone5 = false;
            var email6 = false;







            //校验name是否重复
            $("#name").change(function () {
                $.ajax({
                    type: "post",
                    dataType: "text",
                    url: "${pageContext.request.contextPath}/User/userName.action",
                    data: {"name": $("#name").val()},
                    success: function (data) {
                     if(data=='用户名可用'){
                         $("#nameb").html(data);
                         // alert(data);
                         $("#nameb").css("color","green");
                         name2=true;
                     }else {
                         $("#nameb").html(data);
                         $("#nameb").css("color","red");
                     }
                    }
                })
            })


            //显示头像文件名
            $("#file").change(function () {
                $("#text").val($("#file").val());
            })

            //密码校验
           $("#password").change(function () {
               var pattern = /^[a-zA-Z0-9_-]{6,20}$/;
               if(pattern.test($("#password").val())){
                  $("#p1").html("密码可用");
                   $("#p1").css("color","green");
                   password3=true;
               }else {
                   $("#p1").html("密码不符合规范");
                   $("#p1").css("color","red");
               }
           })

            //密码二次校验
            $("#confirmPass").change(function () {
                if($("#password").val()==$("#confirmPass").val()){
                    $("#p2").html("密码相同");
                    $("#p2").css("color","green");
                    password4=true;
                }else {
                    $("#p2").html("密码不同");
                    $("#p2").css("color","red");
                }
            })

            //电话校验
            $("#tel").change(function () {
                var mPattern = /^0?(13[0-9]|15[012356789]|18[0236789]|14[57])[0-9]{8}$/;
                if (mPattern.test($("#tel").val())){
                    $("#p3").html("电话可用");
                    $("#p3").css("color","green");
                    phone5=true;
                }else {
                    $("#p3").html("电话不可用");
                    $("#p3").css("color","red");
                }
            })

            //邮箱校验
            $("#email").change(function () {
                var ePattern = /^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+((\.[a-zA-Z0-9_-]{2,3}){1,2})$/;
                if (ePattern.test($("#email").val())){
                    $("#p4").html("邮箱可用");
                    $("#p4").css("color","green");
                    email6=true;
                }else {
                    $("#p4").html("邮箱不可用");
                    $("#p4").css("color","red");
                }
            })

            //提交
            $("#reg").click(function () {
                if (name2==true   &&   password3==true   &&   password4==true   &&   phone5==true   &&   email6==true){
                        $("#myform").submit();
                }
            })

        })

    </script>
</head>
<body>
<div class="header">
    <div class="lf">
        <a href="/resources/listResourcesByPage.action">首页</a>
        <a href="/BBS/index.action">论坛</a>
        <a href="/resources/toUpload.action">上传资料</a>
    </div>

    <div class="rf">
        <a href="/User/personal.action">个人信息</a>
        <a href="/User/favorite.action?userid=${u.id}">我的收藏</a>
        <a href="/User/point.action?id=${u.id}">积分</a>
        <a href="/User/logout.action">退出登录</a>
    </div>
</div>

<!-- 网站主体 -->
<div id="main">
    <!-- 上传表单-->
    <div class="upload">
        <p>用户注册</p>
        <hr/>
        <form action="${pageContext.request.contextPath}/User/addUser.action" id="myform" method="post" enctype="multipart/form-data">
                <span>
                    <label>用户头像：</label>
                    <input id="text" class="upt" type="text" readonly="readonly"/>
                    <input id="file" class="upt" type="file" name="pho" value=""/>
                    <b>文件格式可以是jpg,gif,png等图片格式</b>
                </span>




            <span>
                <label>真实姓名:</label>
                <input id="truename" class="upt" type="text" name="truename" value="" required/>
                <b>请填写身份证上面的真实姓名</b>
            </span>



            <span>
                    <label>用户名：</label>
                    <input id="name" class="upt" type="text" name="name" value=""/>
                    <b id="nameb">账号可以包含字母，数字，下划线，不允许出现其他符号</b>
                </span>



            <span>
                <label>出生日期:</label>
                <input id="birth"class="upt" type="date"  name="date" value=""  />
                <b>请填写身份证上面的日期</b>
            </span>



            <span >
                <label>性别:</label>
                男&nbsp;&nbsp;<input  type="radio" name="sex" value="男" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                女&nbsp;&nbsp;<input  type="radio" name="sex" value="女"/>
                <b>请选择性别</b>
            </span>



            <span>
                    <label>密码：</label>
                    <input id="password" class="upt" type="password" name="password" value=""/>
                    <b id="p1">密码长度为6-20位</b>
                </span>



            <span>
                    <label>确认密码：</label>
                    <input id="confirmPass" class="upt" type="password" name="abd" value=""/>
                    <b id="p2">两次输入的密码必须保持一致</b>
                </span>



            <span>
                    <label>联系方式：</label>
                    <input id="tel" class="upt" type="text" name="phone" value=""/>
                    <b id="p3">您丢失密码后找回密码的凭证</b>
                </span>



            <span>
                    <label>电子邮箱：</label>
                    <input id="email" class="upt" type="text" name="email" value=""/>
                    <b id="p4">您丢失密码后找回密码的凭证</b>
                </span>



            <span>
                <input type="hidden" name="scores" value="20"/>
            </span>



            <span>
                <input type="hidden" name="attention" value="0"/>
            </span>

            <span><label class="btn" ><input id="reg" type="button" value="注册" /></label></span>
        </form>
    </div>

</div>
<script>

</script>
</body>

</html>
