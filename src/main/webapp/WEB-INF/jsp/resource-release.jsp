<%--
  Created by IntelliJ IDEA.
  User: 杨吉祥
  Date: 2019/1/16
  Time: 19:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="../../css/index.css"/>
    <script src="../../js/jquery-3.2.1.min.js"></script>
    <title>资源管理</title>

    <script>
        $(function(){
            $(".page_tb [value=all]").click(function(){

                var val = $(this).prop('checked');
                //获取tbody下的所有checkbox
                $(".page_tb tbody [type=checkbox]").prop('checked' , val);
            });


            $(".page_tb tbody [type=checkbox]").click(function(){
                //如果所有的checkbox都被选中，第一个需要被选中
                //如果有任何一个checkbox未被选中，第一个需要被取消
                var chs = $(".page_tb tbody [type=checkbox]");
                var flag = true ; //假设所有的变量都选中

                $.each(chs , function(i ,ch){
                    //获取当前checkbox的选中状态
                    var f = $(ch).prop('checked');
                    if(!f) {
                        flag = false ;
                        //去掉第一个checkbox的对勾
                        $(".page_tb [value=all]").prop('checked',false);
                        return false ;
                    }
                });

                if(flag) {
                    $(".page_tb [value=all]").prop('checked' , true);
                }
            });
        });
    </script>
</head>
<body>

<div class="page_nav">
    <p>当前位置：<span>资源管理</span>/<span>已发布资源</span></p>
</div>

<div class="page_tb">
    <table>
        <thead>
        <tr>
            <th><input type="checkbox" value="all" /></th>
            <th>序号</th>
            <th>资源名</th>
            <th>资源描述</th>
            <th>上传者</th>
            <th>资源分数</th>
            <th>上传时间</th>
            <th>操作</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="resources" items="${release}">
            <tr>
                <td><input type="checkbox" value="1" /></td>
                <td>${resources.id}</td>
                <td>${resources.name}</td>
                <td>${resources.describe}</td>
                <td>${resources.user.name}</td>
                <td>${resources.score}</td>
                <td>${resources.date}</td>>
                <td><a href="">撤销</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

    <div class="panigation">
        <a>上一页</a>
        <a>1</a>
        <a>2</a>
        <a class="act">3</a>
        <a>4</a>
        <a>5</a>
        <a>下一页></a>
    </div>
</div>
</body>
</html>
