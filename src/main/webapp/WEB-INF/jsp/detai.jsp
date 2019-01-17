<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="index.css"/>
    <script src="./js/jquery-3.2.1.min.js"></script>
    <title>详情</title>
    <script>
        $(function(){
            $("div.star span").mouseover(function(){
                $(this).addClass('act').prevAll("span").addClass("act");
                $(this).nextAll("span").removeClass("act");
            });

            $(".rf a:first").removeAttr('href');
        });
    </script>
</head>
<body>

<div class="header">
    <div class="lf">
        <a href="index.html">首页</a>
        <a href="bbs.html">论坛</a>
        <a href="upload.html">上传资料</a>
    </div>

    <div class="rf">
        <a href="personal.html">个人信息</a>
        <a href="shoucang.html">我的收藏</a>
        <a href="point.html">积分</a>
        <a>退出登录</a>
    </div>
</div>

<!-- 网站主体 -->
<div id="main">
    <!-- 定义详细目录-->
    <div id="detail">
        <div class="title"> <!-- 主信息-->
            <div class="img">
                <img src="./images/txt.svg" />
            </div>
            <div class="cons">
                <div>
                    <label>spring cloud,spring boot 项目实例，两个</label>
                </div>
                <div>
                    <label>2017-06-19  上传大小：12.69MB</label>
                    <span>spring</span>
                    <span>clound</span>
                    <span>demo</span>
                </div>
            </div>
        </div>
        <div class="desc"> <!-- 信息描述-->
            spring cloud 项目基于Spring Cloud的云分布式后台管理系统架构，核心技术采用Eureka、Fegin、Ribbon、Zuul、Hystrix、Security、OAth、Mybatis、Ace-cache等主要框架和中间件，UI采用Bootstrap、jquery等前端组件spring boot项目是使用spring boot + thymeleaf 开发个人博客项目.本人参照好长时间，完美运行
        </div>
        <div class="msg"> <!-- 评价信息-->
            <span class="act">★</span>
            <span class="act">★</span>
            <span class="act">★</span>
            <span class="act">★</span>
            <span>★</span>
        </div>
        <div class="oper"> <!-- 下载操作-->
            <span>所需积分：<b>2</b></span>
            <span>下载次数：<b>100</b></span>
            <span>
                    <a class="btn">下载</a>
					<a class="btn">收藏</a>
                </span>
        </div>
    </div>
    <div id="comment">
        <div class="title">
            评论：<span>共有8条</span>
            <hr />
        </div>
        <!--每一条评论 -->
        <div class="cons">
            <div class="img">
                <img src="" />
            </div>
            <div class="cmt">
                <div>
                    <span class="author">zhangsan</span>
                    <span class="timer">2016-05-17 15:32:12</span>
                    <span class="star">
                            <span class="act">★</span>
                            <span class="act">★</span>
                            <span class="act">★</span>
                            <span>★</span>
                            <span>★</span>
                        </span>
                </div>

                <div class="msg">
                    <dt>这本书真心不错，值得下载~！</dt>
                </div>
            </div>
        </div>

        <div class="cons">
            <div class="img">
                <img src="" />
            </div>
            <div class="cmt">
                <div>
                    <span class="author">lisi</span>
                    <span class="timer">2016-05-17 15:32:12</span>
                    <span class="star">
                            <span class="act">★</span>
                            <span class="act">★</span>
                            <span class="act">★</span>
                            <span class="act">★</span>
                            <span>★</span>
                        </span>
                </div>

                <div class="msg">
                    <dt>不错哟，赞一个！</dt>
                </div>
            </div>
        </div>
    </div>

    <!-- 开始评论-->
    <div id="mycomments">
        <div>
            <span>我的评论</span>
            <hr />

            <textarea placeholder="可以留下您的宝贵意见哟"></textarea>
            <div class="star"> <!-- 评价信息-->
                <span>★</span>
                <span>★</span>
                <span>★</span>
                <span>★</span>
                <span>★</span>
            </div>
            <a class="btn">评论</a>
        </div>

    </div>
</div>

</body>

</html>
