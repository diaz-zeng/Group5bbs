<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="/css/index.css"/>
    <script src="./js/jquery-3.2.1.min.js"></script>
    <title>论坛</title>
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

<c:if test="${u!=null}">
    <!-- 网站主体 -->
    <div id="main">
        <div class="personal">
            <div class="lf">
                <img style="width:200px; height:200px;border-radius: 10px;" src="/photo/${u.photo}" alt="暂无头像">
            </div>

            <div class="rf">
                <div>
                    <span>${u.name}</span>
                    <span><b>${u.truename}</b> | <b>${u.sex}</b> |  <b><fmt:formatDate value="${u.birth}"
                                                                                       pattern="yyyy-MM-dd"/> </b></span>
                </div>

                <div>
                    <span><b>${u.scores}</b></span>
                    <span><b>${u.attention}</b></span>
                </div>
            </div>
        </div>
    </div>
</c:if>
<c:if test="${u==null}">

</c:if>


</body>

</html>
