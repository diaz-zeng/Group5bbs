<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>详情</title>
    <link rel="stylesheet" type="text/css" href="/css/index.css"/>
    <link rel="stylesheet" type="text/css" href="/css/bootstrap.css">
    <%--<link rel="stylesheet" href="/css/bootstrap-theme.css">--%>
    <script src="/js/jquery-3.2.1.min.js"></script>
    <script src="/js/bootstrap.js"></script>
    <script type="text/javascript">
        $(function () {

            $("#shoucang").click(function () {
                $.ajax({
                    type: "get",
                    dateType: "text",
                    url: "${pageContext.request.contextPath}/User/shoucang.action",
                    data: {
                        "userid":${u.id},
                        "reaourceid":${resource.id},
                    },
                    success: function (data) {
                        if (data == 1) {
                            alert("收藏成功");
                        } else {
                            alert("已收藏过")
                        }
                    }
                })
            })

            $("div.star span").click(function () {
                $(this).addClass('act').prevAll("span").addClass("act");
                $("#start").val($(this).addClass('act').prevAll("span").length + 1);
                $(this).nextAll("span").removeClass("act");
            });
            $(".rf a:first").removeAttr('href');
            /*$("#download").click(function () {
                                        alert("hello")
                                        $.ajax({
                                            type: "post",
                                            dataType: "text",
                                            url: "\${pageContext.request.contextPath}/resources/downloadResources.action",
                                            data: {"name": "\${resource.name}"},
                                            success: function (data) {

                                            }
                                        })
                                    })*/
            $("#sub").click(function () {
                $("#myForm").submit()
            });
            /* $("#download").click(function () {
                        $.ajax({
                        type: "post",
                        dataType: "json",
                        url: "\${pageContext.request.contextPath}/resources/elementIsNull.action",
                        success: function (data) {
                        alert(data);
                        }
                        })
                        })*/
        });

        function downloadFile(id, uid, resourceScore) {
            $.ajax({
                type: "post",
                dataType: "json",
                url: "/resources/elementIsNull.action",
                data: {
                    "id": id,
                    "uid": uid
                },
                success: function (json) {
                    if (json["status"].toString() == "success") {
                        if (json["userScore"] < resourceScore) {
                            alert("积分不足！");
                            return;
                        }
                        window.open(json['url']);
                    } else {
                        alert(json['msg']);
                    }
                    window.location.reload();
                }
            })
            <%--window.open('${pageContext.request.contextPath}/resources/downloadResources.action?id=' + id);--%>
        }
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
        <a href="/User/favorite.action">我的收藏</a>
        <a href="/User/point.action">积分</a>
        <a href="/User/logout.action">退出登录</a>
    </div>
</div>

<div class="container">
    <!-- 网站主体 -->
    <div id="main" style="padding: 0">
        <!-- 定义详细目录-->
        <div id="detail">
            <div class="title"> <!-- 主信息-->
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
                <div class="cons">
                    <div>
                        <label>${resource.name}</label>
                        <input type="hidden" value="${resource.name}" name="name">
                    </div>
                    <div>
                        <label><fmt:formatDate value="${resource.date}" pattern="yyyy-MM-dd hh:mm:ss"/>
                            上传大小：${size}</label>&nbsp;&nbsp;&nbsp;
                        <c:if test="${resource.keywords.contains(' ')}">
                            <c:forEach items="${fn:split(resource.keywords, ' ')}" var="keyword">
                                <span>${keyword}</span>
                            </c:forEach>
                        </c:if>
                        <%--<c:if test="${resource.keywords.contains(',')}">--%>
                        <%--<c:forEach items="${fn:split(resource.keywords, ',')}" var="keyword">--%>
                        <%--<span>${keyword}</span>--%>
                        <%--</c:forEach>--%>
                        <%--</c:if>--%>
                    </div>
                </div>
            </div>
            <div class="desc"> <!-- 信息描述-->
                ${resource.describe}
            </div>
            <div class="msg"> <!-- 评价信息-->
                <c:choose>
                    <c:when test="${resource.times<=10}">
                        <c:forEach begin="1" end="5" varStatus="cc">
                            <c:if test="${1 >= cc.count}">
                                <span class="act">★</span>
                            </c:if>
                            <c:if test="${1 < cc.count}">
                                <span>★</span>
                            </c:if>
                        </c:forEach>
                    </c:when>
                    <c:when test="${resource.times<=20}">
                        <c:forEach begin="1" end="5" varStatus="cc">
                            <c:if test="${2 >= cc.count}">
                                <span class="act">★</span>
                            </c:if>
                            <c:if test="${2 < cc.count}">
                                <span>★</span>
                            </c:if>
                        </c:forEach>
                    </c:when>
                    <c:when test="${resource.times<=30}">
                        <c:forEach begin="1" end="5" varStatus="cc">
                            <c:if test="${3 >= cc.count}">
                                <span class="act">★</span>
                            </c:if>
                            <c:if test="${3 < cc.count}">
                                <span>★</span>
                            </c:if>
                        </c:forEach>
                    </c:when>
                    <c:when test="${resource.times<=40}">
                        <c:forEach begin="1" end="5" varStatus="cc">
                            <c:if test="${4 >= cc.count}">
                                <span class="act">★</span>
                            </c:if>
                            <c:if test="${4 < cc.count}">
                                <span>★</span>
                            </c:if>
                        </c:forEach>
                    </c:when>
                    <c:otherwise>
                        <c:forEach begin="1" end="5" varStatus="cc">
                            <c:if test="${5 >= cc.count}">
                                <span class="act">★</span>
                            </c:if>
                        </c:forEach>
                    </c:otherwise>
                </c:choose>
            </div>
            <div class="oper"> <!-- 下载操作-->
                <span>所需积分：<b>${resource.score}</b></span>
                <span>下载次数：<b>${resource.times}</b></span>
                <span>
                <a class="btn" id="download" onclick="downloadFile(${resource.id}, ${u.id}, ${resource.score})">下载</a>
					<a id="shoucang" class="btn">收藏</a>
                </span>
            </div>
        </div>
        <div id="comment">
            <div class="title">
                评论：<span>共有
             <c:if test="${comments.size()!=0}">
                 ${comments.size()}
             </c:if>
            <c:if test="${comments.size()==0}">
                0
            </c:if>
            条</span>
                <hr/>
            </div>
            <!--每一条评论 -->
            <c:forEach var="comment" items="${comments}">
                <div class="cons">
                    <div class="img">
                        <img src="${comment.user.phone}"/>
                    </div>
                    <div class="cmt">
                        <div>
                            <span class="author">${comment.user.name}</span>
                            <span class="timer"> <fmt:formatDate value="${comment.date}"
                                                                 pattern="yyyy-MM-dd hh:mm:ss"/></span>
                            <span class="star">

                            <c:forEach begin="1" end="5" varStatus="cc">
                                <c:if test="${comment.star >= cc.count}">
                                    <span class="act">★</span>
                                </c:if>
                                <c:if test="${comment.star < cc.count}">
                                    <span>★</span>
                                </c:if>
                            </c:forEach>
                        </span>
                        </div>

                        <div class="msg">
                            <dt>${comment.context}</dt>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>

    </div>
    <!-- 开始评论-->
    <div id="mycomments">
        <div>
            <span>我的评论</span>
            <hr/>
            <form name="myForm" id="myForm" method="post"
                  action="${pageContext.request.contextPath}/resourceComments/addResourceComment.action"
                  enctype="application/x-www-form-urlencoded">
                <input type="hidden" value="${u.id}" name="userid">
                <input type="hidden" name="resourceid" value="${resource.id}"/>
                <textarea name="context" placeholder="可以留下您的宝贵意见哟"></textarea>
                <div class="star"> <!-- 评价信息-->
                    <span>★</span>
                    <span>★</span>
                    <span>★</span>
                    <span>★</span>
                    <span>★</span>
                    <input type="hidden" id="start" name="star"/>
                </div>
            </form>
            <c:if test="${u!=null}">
                <input type="button" value="评论" id="sub"/>
            </c:if>
            <c:if test="${u==null}">
                <input type="button" value="评论" onclick="userNull()"/>
                <script>
                    function userNull() {
                        alert("您未登录,不能评论该资源！")
                    }
                </script>
            </c:if>

            <%--<a class="btn" id="release">评论</a>--%>
        </div>

    </div>

</div>

</body>

</html>
