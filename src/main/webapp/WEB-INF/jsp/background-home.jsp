<%--
  Created by IntelliJ IDEA.
  User: 杨吉祥
  Date: 2019/1/15
  Time: 19:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="/css/index.css"/>
    <script src="/js/jquery-3.2.1.min.js"></script>
    <script src="/js/cache.js"></script>
    <script src="/js/bootstrap.js"></script>
    <link rel="stylesheet" type="text/css" href="/css/bootstrap.min.css">
    <title>后端首页</title>
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
</head>
<body>
<!-- 登录弹出层 -->
<div class="cvs" style="display:none" id="cvs2_logon">
    <div class="newModWin">
        <div class="title">登录爱下下账号</div>
        <div class="close" id="cvs2_close" onclick="close_win()">&times;</div>

        <div class="logWin">
            <input type="text" class="inp user" id="aid" name="name" placeholder="请输入管理员账号"/>
            <input type="password" class="inp pass" id="apasswd" name="password" placeholder="请输入管理员密码"/>
            <input type="submit" class="su_btn" value="登录"/>
            <p id="msg"></p>
        </div>
    </div>
</div>

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


<div id="nav">
    <div id="logon">
        <div class="cons">
            欢迎光临爱下下！
        </div>
    </div>

    <div id="login">
        <c:if test="${admin==null}">
        <a href="javascript:void(0)" onclick="showWin()">点击登录</a>
        </c:if>
        <c:if test="${admin!=null}">
        <a>${admin.admin_name}</a>
        <div class="opers">
            <input type="button" id="admin_logout" class="btn btn-danger" value="退出登录" style="margin: 40px -100px;/>
                    </div>
            </c:if>
                    </div>
                    </div>
            <%-- <div class=" container-fluid" style="background-color: azure">
                    <div class="container">--%>
            <c:if test="${admin==null}">
                    <div class=" admin_rt" style="margin: 150px 270px;">
            <p style=" font-size: 30px">后台操作需要管理员权限</p>
        </div>
        </c:if>
        <c:if test="${admin!=null}">
        <div class="admin_rt">
                <%--<img src="/images/welcome.gif" style="margin: auto -1000px">--%>
            <table class="table table-striped table-bordered table-hover table-condensed">
                <tr>
                    <td><b>待审核资源数</b></td>
                    <td>${resourcesCount}</td>
                </tr>
                <tr>
                    <td><b>待审核发帖数</b></td>
                    <td>${articleCount}</td>
                </tr>
            </table>
        </div>
        </c:if>
        <%--     </div>
         </div>--%>
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

            $("#admin_logout").click(function () {
                $.ajax({
                    type: "post",
                    url: "/admin/clear.action",
                    dataType: "json",
                    success: function (data) {
                        if (data == 1) {
                            window.location.reload()
                        }
                    },
                    error: function () {
                        alert("网络异常，请稍后重试")
                    }
                })
            })
        </script>
</body>
</html>
