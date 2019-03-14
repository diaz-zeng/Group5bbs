<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 86155
  Date: 2019/1/15
  Time: 18:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="/css/index.css"/>
    <script src="../js/jquery-3.2.1.min.js"></script>
    <script src="/js/sl.js"></script>
    <script src="/js/comment-manage.js"></script>
    <script src="/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="/css/bootstrap.css">
    <title>首页</title>

    <script>
        $(function () {

            $(".md").click(function () {
                var tag = $(this);
                var flag = tag.data('flag') != null ? $(this).data('flag') : true;
                $(this).parent().find("ul").slideToggle(200, function () {
                    flag = !flag;
                    if (flag) {
                        $(this).prev().find("b").html("···");
                    } else {
                        $(this).prev().find("b").html("&there4;");
                    }
                    tag.data('flag', flag);
                });
            });
        });
    </script>

    <script>
        function turnPage(page) {
            if (page >= 1 && page <${pageCount}) {
                window.location.href = "/comment/pass.action?page=" + page.toString();
            }
        }

    </script>
</head>
<body>
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

<!-- 网站主体 -->
<%-- <div class="container-fluid"  style="background-color: azure">
       <div class="admin_lt">
           <ul>
               <li class="admin_mod">
                   <span class="md"><a>资源管理</a><b>···</b></span>
                   <ul>
                       <li class="ml"><a href="javascript:void(0)" onclick="check()">资源审核</a></li>
                       <li class="ml"><a href="javascript:void(0)" onclick="doSomething()">已发布资源</a></li>
                       <li class="ml"><a href="javascript:void(0)" onclick="doSome()">未通过资源</a></li>
                   </ul>
               </li>
               <li class="admin_mod">
                   <span class="md"><a href="/comment/all.action">评论管理</a><b>···</b></span>
                   <ul>
                       <li class="ml"><a href="/comment/all.action">评论审核</a></li>
                       <li class="ml"><a href="/comment/pass.action">已审核评论</a></li>
                       <li class="ml"><a href="/comment/loser.action">未通过评论</a></li>
                   </ul>
               </li>
               <li class="admin_mod">
                   <span class="md"><a>积分管理</a><b>···</b></span>
                   <ul>
                       <li class="ml"><a href="/comment/integral.action">积分查询</a></li>
                   </ul>
               </li>
           </ul>
       </div>--%>

<div class="container-fluid" style="background-color: azure">
    <div class="container">
        <div class="page_nav">
            <p>当前位置：<span>评论管理</span>/<span>已审核评论</span></p>
        </div>
        <div style="margin-top: 30px" class="container-fluid">
            <table class="table table-hover table-responsive table-striped table-bordered">
                <thead>
                <tr><%--
					<th><input type="checkbox" value="all" /></th>--%>
                    <th>文章id</th>
                    <th>用户id</th>
                    <th>用户名字</th>
                    <th>帖子标题</th>
                    <th>撤销</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="pas" items="${pass}">
                    <tr id="${pas.id}"><%--
                    <td><input type="checkbox" value="1" /></td>--%>
                        <td>${pas.id}</td>
                        <td>${pas.user.id}</td>
                        <td>${pas.user.name}</td>
                        <td>${pas.title}</td>
                        <td><a id="loser" href="#" onclick="loser('${pas.id}')">撤销</a></td>
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
</div>
</body>
</html>
