<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="/css/index.css"/>
    <title>首页</title>
    <script></script>
</head>
<body>
<!-- 登录弹出层 -->
<div class="cvs" style="display:none" id="cvs2_logon">
    <div class="newModWin">
        <div class="title">登录爱下下账号</div>
        <div class="close" id="cvs2_close" onclick="close_win()">X</div>

        <div class="logWin">
            <form action="/User/userLogin.action" method="post">
                <input type="text" class="inp user" name="name" autocomplete="off" placeholder="请输入用户名"/>
                <input type="password" class="inp pass" name="password" autocomplete="off" placeholder="请输入密码"/>
                <a href="findpass.html" class="find_pass">忘记密码，立即找回</a>
                <input type="submit" class="su_btn" value="登录"/>
                <a href="/User/regist.action" class="reg">注册</a>
            </form>
        </div>
    </div>
</div>

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

<!-- 网站头信息-->
<div id="nav">
    <div id="search">
        <input type="text" name="name" autocomplete="off"/>
        <a class="btn">搜索 </a>
    </div>

    <div id="logon">
        <div class="cons">
            欢迎光临爱下下！
        </div>
        <div class="opers">
            <a class="btn" href="upload.html">上传资料 </a>
        </div>
    </div>

    <div id="login">
        <a href="javascript:void(0)" onclick="showWin()">点击登录</a>
    </div>
</div>

<!-- 网站主体 -->
<div id="main">
    <!-- 定义一个条目-->
    <c:if test="${resources != null}">
        <c:forEach var="resource" items="${resources}">
            <div class="pro">
                <div class="img">
                    <img src="/images/rar.svg"/>
                </div>
                <div class="cs">
                    <div class="up">
                        <a href="${pageContext.request.contextPath }/resources/queryResourcesById.action?id=${resource.id}">${resource.describe}</a>
                    </div>
                    <div class="down">
                        上传者：${resource.user.name} 上传时间：
                        <fmt:formatDate value="${resource.date}" pattern="yyyy-MM-dd hh:mm:ss"/>
                    </div>
                </div>
                <div class="arr">
                    积分：<span>${resource.score}</span>
                </div>
            </div>
        </c:forEach>
    </c:if>


    <div class="panigation">
        <a>上一页</a>
        <a>1</a>
        <a>2</a>
        <a class="act">3</a>
        <a>4</a>
        <a>5</a>
        <a>下一页></a>
    </div>
</div>


<script>
    function showWin() {
        //获取对应的DIV元素
        var div = document.getElementById("cvs2_logon");
        div.style = 'display:block';
    }

    function close_win() {
        var div = document.getElementById("cvs2_logon");
        div.style = 'display:none';
    }

</script>

</body>

</html>