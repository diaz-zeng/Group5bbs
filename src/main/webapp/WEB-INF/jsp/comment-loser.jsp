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
    <link rel="stylesheet" type="text/css" href="../index.css"/>
	<script src="../js/jquery-3.2.1.min.js"></script>
	<script src="cache.js" />
    <title>首页</title>

	<script>
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
                <form action="" method="post">
                    <input type="text" class="inp user" name="name" placeholder="请输入用户名" />
                    <input type="password" class="inp pass" name="password" placeholder="请输入密码" />
                    <a href="" class="find_pass">忘记密码，立即找回</a>
                    <input type="submit" class="su_btn" value="登录" />
                    <a href="register.html" class="reg">注册</a>
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
            <div class="opers">
                <input type="button" value="上传资料"/>
            </div>
        </div>

        <div id="login">
            <a href="javascript:void(0)" onclick="showWin()">点击登录</a>
        </div>
    </div>

    <!-- 网站主体 -->
    <div id="admin">
        <div class="admin_lt">
            <ul>
                <li class="admin_mod">
                    <span class="md"><a>资源管理</a><b>···</b></span>
                    <ul>
                        <li class="ml"><a>资源审核</a></li>
                        <li class="ml"><a>已发布资源</a></li>
                        <li class="ml"><a>未通过资源</a></li>
                    </ul>
                </li>
                <li class="admin_mod">
                    <span class="md"><a href="comment-manage.jsp">评论管理</a><b>···</b></span>
                    <ul>
                        <li class="ml"><a href="comment-manage.jsp">评论审核</a></li>
                        <li class="ml"><a href="comment-pass.jsp">已审核评论</a></li>
                        <li class="ml"><a href="comment-loser.jsp">未通过评论</a></li>
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

        <div class="admin_rt">
            <div class="page_nav">
        <p>当前位置：<span>评论管理</span>/<span>未通过评论</span></p>
    </div>

    <div class="page_tb">
        <table>
            <thead>
                <tr>
					<th><input type="checkbox" value="all" /></th>
                    <th>用户id</th>
                    <th>用户名字</th>
                    <th>评论内容</th>
                </tr>
            </thead>
            <tbody>





                <tr>
					<td><input type="checkbox" value="1" /></td>
                    <td>2</td>
                    <td>a</td>
                    <td>4</td>
                </tr>
     
            </tbody>
        </table>
        
		<div class="panigation">
			<a><上一页</a>
			<a>1</a>
			<a>2</a>
			<a class="act">3</a>
			<a>4</a>
			<a>5</a>
			<a>下一页></a>
		</div>
    </div>
        </div>
    </div>
</body>
