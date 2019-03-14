<%--
  Created by IntelliJ IDEA.
  User: 辉
  Date: 2019/1/15
  Time: 17:33
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="/css/index.css"/>
    <title>资源上传</title>
    <script src="/js/jquery-3.2.1.min.js"></script>
    <script src="/js/bootstrap.js"></script>
    <link rel="stylesheet" type="text/css" href="/css/bootstrap.css">
    <%--<link rel="stylesheet" type="text/css" href="/css/bootstrap-theme.css">--%>
    <link rel="stylesheet" type="text/css" href="/css/index.css"/>
    <script src="/js/cache.js"></script>
    <script>
        $(function () {

        });
    </script>
</head>
<body style="background-color: azure">
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

<div class="page_nav">
    <p>当前积分：<span>${u.scores}</span></p>
</div>

<div class="container">
    <table class="table table-striped table-bordered table-hover">
        <thead>
        <tr>
            <th>序号</th>
            <th>积分</th>
            <th>时间</th>
            <th>来源</th>
        </tr>
        </thead>
        <c:forEach var="record" items="${records}">
            <tbody>
            <tr style="text-align: center">
                <td>${record.id}</td>
                <td>${record.integral}</td>
                <td><fmt:formatDate value="${record.date}" pattern="yyyy-MM-dd hh:mm:ss"></fmt:formatDate></td>
                <td>${record.source}</td>
            </tr>
            </tbody>
        </c:forEach>
    </table>
    <nav aria-label="...">
        <ul class="pager">
            <li><a href="javascript:void(0);" onclick="turnPage(${currentPage-1})">上一页</a></li>
            <li><label>当前第${currentPage}页</label></li>
            <li><a href="javascript:void(0);" onclick="turnPage(${currentPage+1})">下一页</a></li>
        </ul>
    </nav>
</div>
</body>
<script>
    function turnPage(currentPage) {
        if (articlePage > 0 && articlePage <=${totalPage}) {
            window.location.href = "/User/point" + currentPage + ".action";
        }
    }
</script>
</html>
