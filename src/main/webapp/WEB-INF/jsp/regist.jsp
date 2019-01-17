<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="/css/index.css"/>
    \
    <title>用户注册</title>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.2.1.min.js"></script>
    <script type="text/javascript">
        $(function () {
            /*   $("#reg").click(function () {
                   var formData = new FormData($("#myform"));
                  $.ajax({
                      type:"post",
                      url:"/User/regist.action",
                      contentType:false,
                      data:formData,
                      dataType:text,
                      success
                  })
               })
            })
      */
            $("#name").change(function () {
                $.ajax({
                    type: "post",
                    dataType: "text",
                    url: "${pageContext.request.contextPath}/User/userName.action",
                    data:
                        {"name": $("#name").val()},
                    success: function (data) {
                        if (data) {
                            $("#nameb").text(data);
                        } else {
                            $("#nameb").text('error');
                        }
                    }
                })
            })

        })

    </script>
</head>
<body>
<div class="header">
    <div class="lf">
        <a href="index.html">首页</a>
        <a href="bbs.html">论坛</a>
        <a href="upload.html">上传资料</a>
    </div>

    <div class="rf">
        <a href="personal.html">个人信息</a>
        <a href="shoucang.html">我的收藏</a>
        <a href="point.html">积分</a>
        <a>退出登录</a>
    </div>
</div>

<!-- 网站主体 -->
<div id="main">
    <!-- 上传表单-->
    <div class="upload">
        <p>用户注册</p>
        <hr/>
        <form action="${pageContext.request.contextPath}/User/addUser.action" id="myform" method="post"
              enctype="multipart/form-data">
                <span>
                    <label>用户头像：</label>
                    <input class="upt" type="text" readonly="readonly"/>
                    <input class="upt" type="file" name="photo" value=""/>
                    <b>文件格式可以是jpg,gif,png等图片格式</b>
                </span>
            <span>
                    <label>用户名：</label>
                    <input id="name" class="upt" type="text" name="name" value=""/>
                    <b id="nameb">账号可以包含字母，数字，下划线，不允许出现其他符号</b>
                </span>
            <span>
                    <label>密码：</label>
                    <input id="password" class="upt" type="password" name="password" value=""/>
                    <b>密码长度为6-20位</b>
                </span>
            <span>
                    <label>确认密码：</label>
                    <input id="confirmPass" class="upt" type="password" name="abd" value=""/>
                    <b>两次输入的密码必须保持一致</b>
                </span>
            <span>
                    <label>联系方式：</label>
                    <input id="tel" class="upt" type="text" name="phone" value=""/>
                    <b>您丢失密码后找回密码的凭证</b>
                </span>
            <span>
                    <label>电子邮箱：</label>
                    <input id="email" class="upt" type="text" name="g " value=""/>
                    <b>您丢失密码后找回密码的凭证</b>
                </span>
            <span>
                <input type="hidden" name="scores" value="20"/>
            </span>

            <span><label class="btn"><input id="reg" type="submit" value="注册"/></label></span>
        </form>
    </div>

</div>
<script>

</script>
</body>

</html>
