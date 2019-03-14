<%--
  Created by IntelliJ IDEA.
  User: 杨吉祥
  Date: 2019/1/16
  Time: 19:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="/css/index.css"/>
    <script src="../../js/jquery-3.2.1.min.js"></script>
    <script src="../../js/cache.js"></script>
    <script src="/js/bootstrap.js"></script>
    <link rel="stylesheet" type="text/css" href="/css/bootstrap.css">
    <title>资源管理</title>
    <script>
        $(function () {
            $("#checkAll").click(function () {
                if (this.checked){
                    $("input[type='checkbox']").prop("checked",true);
                }else {
                    $("input[type='checkbox']").prop("checked",false);
                }
            });
            remove = function (id) {
                $.ajax({
                    type: "post",
                    url: "${pageContext.request.contextPath}/resourceadmin/remove.action?id=" + id + "",
                    dateType: "text",
                    success: function (date) {
                        if (date == "1") {
                            // $("#tr_"+id).remove();
                            alert("操作成功")
                            window.location.reload();
                        }
                    },
                    error: function () {
                        alert("网络异常，请稍后重试")
                    }
                });
            }
        });
    </script>
</head>
<body  style="background-color: azure">
<div class="header">
    <div class="lf">
        <a href="/admin/param.action">首页</a>
        <a href="/resourceadmin/unaudited.action">资源审核</a>
        <a href="/resourceadmin/release.action">已发布资源</a>
        <a href="/resourceadmin/failed.action">未通过资源</a>
    </div>
    <div class="rf">
        <a href="/comment/all.action">评论审核</a>
        <a href="/comment/pass.action">已发布审核</a>
        <a href="/comment/loser.action">未通过审核</a>
        <a href="/comment/integral.action">积分查询</a>
    </div>
</div>
<div class="container-fluid" style="background-color: azure">
    <div class="container">
        <div class="page_nav">
            <p>当前位置：<span>资源管理</span>/<span>资源审核</span>
                <button id="cleanRes" class="btn btn-danger" >选中撤销
                </button>
            </p>
        </div>

        <table class="table table-bordered table-responsive table-hover table-striped">
            <thead>
            <tr>
                <th><input type="checkbox" id="checkAll"/></th>
                <th>序号</th>
                <th>资源名</th>
                <th>资源描述</th>
                <th>上传者</th>
                <th>资源分数</th>
                <th>上传时间</th>
                <th>操作</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="resources" items="${resourcesAll}">
                <tr style="text-align: center" id="tr_${resources.id}">
                    <td><input type="checkbox" value="${resources.id}"/></td>
                    <td>${resources.id}</td>
                    <td>${resources.name}</td>
                    <td>${resources.describe}</td>
                    <td>${resources.user.name}</td>
                    <td>${resources.score}</td>
                    <td><fmt:formatDate value="${resources.date}" pattern="yyyy-MM-dd hh:mm:ss"/></td>
                    <td>
                        <a href="${pageContext.request.contextPath}/resourceadmin/update.action?id=${resources.id}">审核</a>&nbsp;|&nbsp;<a
                            id="${resources.id}" onclick="remove(this.id)">撤销</a></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <nav aria-label="...">
            <ul class="pager">
                <li><a href="javascript:void(0);" onclick="turnPage(${page-1})">上一页</a></li>
                <li><label>当前第${page}页</label></li>
                <li><a href="javascript:void(0);" onclick="turnPage(${page+1})">下一页</a></li>
            </ul>
        </nav>
    </div>
</div>
<script>
    function turnPage(page) {
        if (page >= 1 && page <${pageCount}) {
            window.location.href = "/resourceadmin/unaudited.action?page=" + page.toString();
        }
    }
</script>
</body>
</html>
