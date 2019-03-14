<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>首页</title>
    <link rel="stylesheet" type="text/css" href="/css/index.css"/>
    <link rel="stylesheet" type="text/css" href="/css/bootstrap.css">
    <%--<link rel="stylesheet" href="/css/bootstrap-theme.css">--%>
    <script src="/js/jquery-3.2.1.min.js"></script>
    <script src="/js/bootstrap.js"></script>
    <script type="text/javascript">
        $(function () {
            if (${msg==true}) {
                alert("注册成功，请登录")
            }

            if (${flag==false}) {
                alert("用户名或密码错误")
            }

            $("#queryBtn").click(function () {
                var name = $("#resName").val()
                if (name != null && name != "") {
                    searchForm.submit();
                }
            })
        });
    </script>
</head>
<body style="background-color: azure">
<!-- 登录弹出层 -->
<div class="cvs" style="display:none" id="cvs2_logon">
    <div class="newModWin">
        <div class="title">登录爱下下账号</div>
        <div class="close" id="cvs2_close" onclick="close_win()">X</div>

        <div class="logWin">
            <form action="/User/userLogin.action" method="post">
                <input type="text" class="inp user" name="name" autocomplete="off" placeholder="请输入用户名"/>
                <input type="password" class="inp pass" name="password" autocomplete="off" placeholder="请输入密码"/>
                <a href="/User/findpassword.action" class="find_pass">忘记密码，立即找回</a>
                <input type="submit" class="su_btn" value="登录"/>
                <a href="/User/regist.action" class="reg">注册</a>
            </form>
        </div>
    </div>
</div>

<div class="header">
    <div class="lf">
        <a href="/resources/listResourcesByPage.action">首页</a>
        <a href="/BBS/index.action">论坛</a>
        <a href="/resources/toUpload.action">上传资料</a>
    </div>

    <div class="rf">
        <a href="/User/personal.action">个人信息</a>
        <a href="/User/favorite.action">我的收藏</a>
        <a href="/User/point.action">积分</a>
        <a href="/User/logout.action">退出登录</a>
    </div>
</div>

<!-- 网站头信息-->
<div id="nav">
    <div id="search">
        <form action="${pageContext.request.contextPath}/resources/queryResourcesNameLike.action" name="searchForm">
            <input type="text" name="name" id="resName"/>
            <a class="btn" id="queryBtn">搜索 </a>
        </form>
    </div>

    <div id="logon">
        <div class="cons">
            欢迎光临爱下下！
        </div>

        <c:choose>
            <c:when test="${u != null}">
                <div class="opers">
                    <a href="${pageContext.request.contextPath}/resources/toUpload.action">上传资料</a>
                </div>
            </c:when>
            <c:otherwise>
                <div class="opers">
                    <a onclick="userNull2()">上传资料</a>
                    <script>
                        function userNull2() {
                            alert("登录信息异常，请重新登录!")
                        }
                    </script>
                </div>
            </c:otherwise>
        </c:choose>

    </div>

    <c:if test="${u!=null}">
        <div id="login">
            <img style="border-radius: 60px; width: 120px; height: 120px"
                 src="${pageContext.request.contextPath}/photo/${u.photo}">
        </div>
    </c:if>
    <c:if test="${u==null}">
        <div id="login">
            <a href="javascript:void(0)" onclick="showWin()">点击登录</a>
        </div>
    </c:if>

</div>

<!-- 网站主体 -->
<div id="main">
    <!-- 定义一个条目-->
    <c:if test="${resources != null}">
        <c:forEach var="resource" items="${resources}">
                <div class="pro">
                    <div class="cs">
                        <div class="up">
                            <a href="${pageContext.request.contextPath }/resources/queryResourcesById.action?id=${resource.id}">${resource.name}</a>
                        </div>
                        <div class="down">
                            上传者：${resource.user.name} 上传时间：
                            <fmt:formatDate value="${resource.date}" pattern="yyyy-MM-dd hh:mm:ss"/>
                        </div>
                    </div>
                    <div class="img">
                        <c:choose>
                            <c:when test="${resource.filepath.endsWith('rar')}">
                                <img src="/images/rar.svg"/>
                            </c:when>
                            <c:when test="${resource.filepath.endsWith('pdf')}">
                                <img src="/images/pdf.svg"/>
                            </c:when>
                            <c:when test="${resource.filepath.endsWith('zip')}">
                                <img src="/images/zip.svg"/>
                            </c:when>
                            <c:when test="${resource.filepath.endsWith('docx')}">
                                <img src="/images/docx.svg"/>
                            </c:when>
                            <c:otherwise>
                                <img src="/images/txt.svg"/>
                            </c:otherwise>
                        </c:choose>
                    </div>
                    <div class="arr">
                        积分：<span>${resource.score}</span>
                    </div>
                </div>
        </c:forEach>
    </c:if>


    <div class="panigation">
        <div style="text-align: center;">
            当前页：${currentPage} / <span id="total">${totalPage}</span> &nbsp;&nbsp;&nbsp;&nbsp;
            <a href="javascript:void(0)" onclick="pagination('first')">首页</a>
            <a href="javascript:void(0)" onclick="pagination('pre')">上一页</a>
            <a href="javascript:void(0)" onclick="pagination('next')">下一页</a>
            <a href="javascript:void(0)" onclick="pagination('last')">尾页</a>
            go<input type="text" size="1" id="go" onchange="pagination('go')">
            <form action="${pageContext.request.contextPath}/resources/listResourcesByPage.action" method="post"
                  name="pageForm">
                <input type="hidden" id="curr" name="currentPage" value="${currentPage}">
            </form>
        </div>
        <script type="text/javascript">
            function pagination(page) {
                var total = document.getElementById("total").innerHTML;
                var curr = document.getElementById("curr");
                if (page == 'first') {
                    curr.value = 1;
                } else if (page == 'last') {
                    curr.value = total;
                } else if (page == 'pre') {
                    var temp = curr.value - 1;
                    if (temp <= 0) {
                        temp = 1;
                    }
                    curr.value = temp;
                } else if (page == 'next') {
                    var temp = parseInt(curr.value) + 1;
                    if (temp >= total) {
                        temp = total;
                    }
                    curr.value = temp;
                } else if (page == 'go') {
                    var go = document.getElementById("go").value;
                    if (go > 0 && go <= total) {
                        curr.value = go;
                    } else {
                        alert("输入页码有误");
                        return;
                    }
                }
                pageForm.submit();
            }
        </script>
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