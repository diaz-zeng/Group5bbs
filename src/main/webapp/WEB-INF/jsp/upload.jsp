<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2019/1/17
  Time: 13:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html lang="en">
<head>
    <title>资源上传</title>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="/css/index.css"/>
    <link rel="stylesheet" type="text/css" href="/css/index.css"/>
    <link rel="stylesheet" type="text/css" href="/css/bootstrap.css">
    <%--<link rel="stylesheet" href="/css/bootstrap-theme.css">--%>
    <script src="/js/jquery-3.2.1.min.js"></script>
    <script src="/js/bootstrap.js"></script>
    <script type="text/javascript">

        var fileFlag = false;

        function showFileName(obj) {
            var fileName = obj.files[0].name;
            $("#fileName").val(fileName);
            if (fileName.indexOf(".docx") != -1 || fileName.indexOf(".txt") != -1 || fileName.indexOf(".pdf") != -1 || fileName.indexOf(".zip") != -1 || fileName.indexOf(".rar") != -1 || fileName.indexOf("TXT") != -1 || fileName.indexOf("PDF") != -1 || fileName.indexOf("ZIP") != -1 || fileName.indexOf("RAR") != -1) {
                $("#t1").html("文件格式正确")
                fileFlag = true;
            } else {
                $("#t1").html("文件格式不正确");
                fileFlag = false;
            }

        }

        $(function () {
            $("#btn1").click(function () {
                if ($("#agree").prop('checked') && fileFlag) {
                    $("#myForm").submit();
                } else {
                    alert("您未同意上传协议,请点击同意协议!")
                }
            });
            $("#subFile").change(function () {
                $("#text").val($("#subFile").val());
            });
        })

        function check(keywords) {
            var keywords = $("#keywords").val();
            var arr = new Array();
            arr = keywords.split(' ');
            if (arr.length > 5 || arr.length == 0) {
                $("#keywordNum").html("长度有误,请重新输入!");
                return;
            } else {
                $("#keywordNum").html("多个关键词用\" \"分割,关键词不能超过5个");
            }
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
<p></p>
<div></div>

<!-- 网站主体 -->
<div id="main">
    <!-- 上传表单-->
    <div class="upload">
        <p>上传资源</p>
        <hr/>
        <form action="${pageContext.request.contextPath}/resources/saveResources.action" name="myForm" id="myForm"
              method="post" enctype="multipart/form-data">
            <input name="userid" value="${u.id}" type="hidden"/>
            <span>
                    <label>选择文件：</label>
                    <input class="upt" id="fileName" type="text"/>
                    <input class="upt" id="subFile" type="file" onchange="showFileName(this)" name="uploadFile"/>

                    <b id="t1">文件格式可以是txt、pdf、zip、rar等后缀</b>
                </span>
            <span>
                    <label>资源名称：</label>
                    <input class="upt" type="text" name="name" value=""/>
                </span>
            <%--<span>--%>
            <%--&lt;%&ndash;<label>资源类型：</label>&ndash;%&gt;--%>
            <%--&lt;%&ndash;<select class="upt" name="fileType">&ndash;%&gt;--%>
            <%--&lt;%&ndash;<option value="1">文本文件</option>&ndash;%&gt;--%>
            <%--&lt;%&ndash;<option value="2">电子文件</option>&ndash;%&gt;--%>
            <%--&lt;%&ndash;<option value="3">压缩文件</option>&ndash;%&gt;--%>
            <%--&lt;%&ndash;</select>&ndash;%&gt;--%>
            <%--</span>--%>
            <span>
                    <label>关键词：</label>
                    <input class="upt" type="text" name="keywords" id="keywords" value="" onchange="check(this)"/>
                    <b id="keywordNum">多个关键词用" "分割,关键词不能超过5个</b>
                </span>
            <span>
                    <label>资源分：</label>
                    <select class="upt" id="sel" name="score">
                        <option value="0">0</option>
                        <option value="1">1</option>
                        <option value="2">2</option>
                        <option value="3">3</option>
                        <option value="4">4</option>
                        <option value="5">5</option>
                        <option value="6">6</option>
                        <option value="7">7</option>
                        <option value="8">8</option>
                        <option value="9">9</option>
                        <option value="10">10</option>
                    </select>
                </span>
            <span class="d_span">
                    <label>资源描述：</label>
                    <textarea class="area" name="describe"
                              placeholder="描述不支持HTML标签；详细的资源描述有机会获得我们的推荐，更有利于他人下载，赚取更多积分。如资源描述不清，有可能审核不通过。"></textarea>
                </span>
            <span>
                    <label class="agree">
                        <input type="checkbox" name="" value="1" id="agree"/>
                        同意爱下下资源上传协议
                    </label>
                </span>
            <span><label class="btn"><input type="button" id="btn1" value="提交"/></label></span>
        </form>
    </div>
    <!-- 公告 -->
    <div class="advice">
        <p class="title">上传须知</p>
        <hr/>
        <p><span>*</span>如涉及侵权内容,您的资源将被移除</p>
        <p><span>*</span>请勿上传小说、mp3、图片等与技术无关的内容.一旦发现将被删除</p>
        <p><span>*</span>请勿在未经授权的情况下上传任何涉及著作权侵权的资源，除非该资源完全由您个人创作</p>
        <p><span>*</span>点击上传资源即表示您确认该资源不违反资源分享的使用条款，并且您拥有该资源的所有版权或者上传资源的授权</p>
    </div>
</div>

</body>
</html>
