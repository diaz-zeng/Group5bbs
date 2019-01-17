<%--
  Created by IntelliJ IDEA.
  User: 杨吉祥
  Date: 2019/1/15
  Time: 19:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="../../css/index.css"/>
    <script src="../../js/jquery-3.2.1.min.js"></script>
    <%--<script src="../../js/cache.js" />--%>
    <title>后端首页</title>
    <c:set var="contextPath" value="${pageContext.request.contextPath}" scope="application"/>
    <script>
               function check(){
                   document.getElementsByClassName("admin_rt")[0].innerHTML="<iframe src='${contextPath}/resourceadmin/unaudited.action' scrolling='no'></iframe>";
               }
               function doSomething(){
                   document.getElementsByClassName("admin_rt")[0].innerHTML="<iframe src='${contextPath}/resourceadmin/release.action' scrolling='no'></iframe>";
               }
               function doSome(){
                   document.getElementsByClassName("admin_rt")[0].innerHTML="<iframe src='${contextPath}/resourceadmin/failed.action'scrolling='no'></iframe>";
               }
        $(function(){
            $(".md").click(function(){
                var tag = $(this) ;
                var flag = tag.data('flag')!=null? $(this).data('flag'):true;
                $(this).parent().find("ul").slideToggle(200 , function(){
                    flag = !flag ;
                    if(flag) {
                        $(this).prev().find("b").html("···");
                    }else{
                        $(this).prev().find("b").html("&there4;");
                    }
                    tag.data('flag' , flag);
                });
            });

        });
    </script>
</head>
<body>
<!-- 登录弹出层 -->
<div class="cvs" style="display:none" id="cvs2_logon">
    <div class="newModWin">
        <div class="title">登录爱下下账号</div>
        <div class="close" id="cvs2_close" onclick="close_win()">X</div>

        <div class="logWin">
            <form action="${pageContext.request.contextPath}/admin/login.action" method="post">
                <input type="text" class="inp user" name="id" placeholder="请输入管理员ID" />
                <input type="password" class="inp pass" name="password" placeholder="请输入管理员密码" />
                <a href="" class="find_pass">忘记密码，立即找回</a>
                <input type="submit" class="su_btn" value="登录" />
                <%--<a href="register.html" class="reg">注册</a>--%>
            </form>
        </div>
    </div>
</div>

<!-- 网站头信息-->
<div id="nav">
    <div id="logon">
        <div class="cons">
            欢迎光临爱下下！
        </div>
      <%--  <div class="opers">
            <input type="button" value="上传资料"/>
        </div>--%>
    </div>

    <div id="login">
        <c:if test="${admin==null}">
        <a href="javascript:void(0)" onclick="showWin()">点击登录</a>
        </c:if>
    <c:if test="${admin!=null}">
            <a href="javascript:void(0)" onclick="showWin()">管理员:${admin.admin_id}</a>
        </c:if>
    </div>
</div>

<!-- 网站主体 -->
<div id="admin">
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
                <span class="md"><a>评论管理</a><b>···</b></span>
                <ul>
                    <li class="ml"><a>评论审核</a></li>
                    <li class="ml"><a>已审核评论</a></li>
                    <li class="ml"><a>未通过评论</a></li>
                </ul>
            </li>
            <li class="admin_mod">
                <span class="md"><a>积分管理</a><b>···</b></span>
                <ul>
                    <li class="ml"><a>积分查询</a></li>
                </ul>
            </li>
        </ul>
    </div>
    <c:if test="${admin==null}">
        <div class="admin_rt">
           <p style="text-align:center;font-size: 30px">查看信息需要管理员权限</p>
        </div>
    </c:if>
    <c:if test="${admin!=null}">
    <div class="admin_rt">
        <%--<p>nihh</p>--%>
        <iframe src="${pageContext.request.contextPath}/resourceadmin/unaudited.action" scrolling="no"></iframe>
    </div>
    </c:if>
</div>
<script>
    function showWin(){
        //获取对应的DIV元素
        var div = document.getElementById("cvs2_logon");
        div.style = 'display:block' ;
    }

    function close_win(){
        var div = document.getElementById("cvs2_logon");
        div.style = 'display:none' ;
    }

</script>
</body>
</html>
