<%--
  Created by IntelliJ IDEA.
  User: 86155
  Date: 2019/1/15
  Time: 18:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

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
                window.location.href = "/comment/all.action?page=" + page.toString();
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

<!-- 网站头信息-->
<%--    <div id="nav">
        <div id="logon">
            <div class="cons">
                欢迎光临爱下下！
            </div>
           &lt;%&ndash; <div class="opers">
                <input type="button" value="上传资料"/>
            </div>&ndash;%&gt;
        </div>

        <div id="login">
            <c:if test="${admin==null}">
                <a href="javascript:void(0)" onclick="showWin()">点击登录</a>
            </c:if>
            <c:if test="${admin!=null}">
                <a>管理员:${admin.admin_id}</a>
                <div class="opers">
                    <a href="${pageContext.request.contextPath}/admin/clear.action" style="color: black">退出登录</a>
                </div>
            </c:if>
        </div>
    </div>--%>

<!-- 网站主体 -->
<%-- <div id="admin">
     <div class="admin_lt">
         <ul>
             <li class="admin_mod">
                 <span class="md"><a href="/resourceadmin/unaudited.action">资源管理</a><b>···</b></span>
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
            <p>当前位置：<span>评论管理</span>/<span>评论审核</span></p>
        </div>
        <div style="margin-top: 30px" class="container-fluid">


            <table class="table table-hover table-responsive table-striped table-bordered">
                <thead>
                <tr><%--
					<th><input type="checkbox" value="all" /></th>--%>
                    <th>文章id</th>
                    <th>用户id</th>
                    <th>用户名字</th>
                    <th>发表时间</th>
                    <th>帖子标题</th>
                    <th>操作</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="article" items="${articles}">
                    <tr id="${article.id}">
                        <td>${article.id}</td>
                            <%--<td><input type="checkbox" value="1" /></td>--%>
                        <td>${article.user.id}</td>
                        <td>${article.user.name}</td>
                        <td><fmt:formatDate value="${article.date}" pattern="yyyy-MM-dd hh:mm:ss"/></td>
                        <td>${article.title}</td>
                        <td><a id="pass" href="#" onclick="manage('${article.id}')">审核</a>&nbsp;|
                            &nbsp;<a id="loser" href="#" onclick="loser('${article.id}')">撤销</a>

                        </td>
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

  
  
  
  
  
  
  
  
  
  
