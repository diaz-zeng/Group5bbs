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
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="index.css"/>
    <script src="./js/jquery-3.2.1.min.js"></script>
    <title>资源上传</title>
</head>
<body>
<div class="header">
    <div class="lf">
        <a href="index.html">首页</a>
        <a  href="bbs.html">论坛</a>
        <a href="upload.html">上传资料</a>
    </div>

    <div class="rf">
        <a href="personal.html">个人信息</a>
        <a class="t" href="shoucang.html">我的收藏</a>
        <a href="point.html">积分</a>
        <a>退出登录</a>
    </div>
</div>
<p></p>
<div></div>

<!-- 网站主体 -->
<div id="main">
    <!-- 上传表单-->
    <div class="upload">
        <p>上传资源</p>
        <hr />
        <form action="" method="post" enctype="multipart/form-data">
                <span>
                    <label>选择文件：</label>
                    <input class="upt" type="text" readonly="readonly"/>
                    <input class="upt" type="file" name="" value=""/>
                    <b>文件格式可以是txt、pdf、zip、rar等后缀</b>
                </span>
            <span>
                    <label>资源名称：</label>
                    <input class="upt" type="text" name="resource" value="" />
                </span>
            <span>
                    <label>资源类型：</label>
                    <select class="upt">
                        <option>文本文件</option>
                        <option>电子文件</option>
                        <option>压缩文件</option>
                    </select>
                </span>
            <span>
                    <label>关键词：</label>
                    <input class="upt" type="text" name="" value="" onchange="check(this)"/>
                    <b>多个关键词用空格分割,关键词不能超过5个</b>
                </span>
            <span>
                    <label>资源分：</label>
                    <select class="upt" id="sel">
                        <option>0</option>
                        <option>1</option>
                        <option>2</option>
                        <option selected="selected">3</option>
                        <option>4</option>
                        <option>5</option>
                        <option>6</option>
                        <option>7</option>
                        <option>8</option>
                        <option>9</option>
                        <option>10</option>
                    </select>
                </span>
            <span class="d_span">
                    <label>资源描述：</label>
                    <textarea  class="area" placeholder="描述不支持HTML标签；详细的资源描述有机会获得我们的推荐，更有利于他人下载，赚取更多积分。如资源描述不清，有可能审核不通过。"></textarea>
                </span>
            <span>
                    <label class="agree">
                        <input type="checkbox" name="" value="1" />
                        同意爱下下资源上传协议
                    </label>

                </span>

            <span><label class="btn"><input type="button" value="提交" /></label></span>
        </form>
    </div>
    <!-- 公告 -->
    <div class="advice">
        <p class="title">上传须知</p>
        <hr />
        <p><span>*</span>如涉及侵权内容,您的资源将被移除</p>
        <p><span>*</span>请勿上传小说、mp3、图片等与技术无关的内容.一旦发现将被删除</p>
        <p><span>*</span>请勿在未经授权的情况下上传任何涉及著作权侵权的资源，除非该资源完全由您个人创作</p>
        <p><span>*</span>点击上传资源即表示您确认该资源不违反资源分享的使用条款，并且您拥有该资源的所有版权或者上传资源的授权</p>
    </div>
</div>


</body>

</html>
