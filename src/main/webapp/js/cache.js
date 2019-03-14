function pagination(page){
    var total = document.getElementById("total").innerHTML;
    var curr = document.getElementById("curr");
    if(page == 'first'){
        curr.value = 1;
    }else if(page == 'last'){
        curr.value = total;
    }else if(page == 'pre'){
        var temp = curr.value -1;
        if(temp <=0){
            temp = 1;
        }
        curr.value = temp;
    }else if(page == 'next'){
        var temp = parseInt(curr.value) + 1;
        if(temp >= total){
            temp = total;
        }
        curr.value = temp;
    }else if(page == 'go'){
        var go = document.getElementById("go").value;
        if(go > 0 && go <= total){
            curr.value = go;
        }else{
            alert("输入页码有误");
            return;
        }
    }
    pageForm.submit();
}
$(function () {
    $(".su_btn").click(function () {
        $("#msg").html("登录中....").css({"color":"red","text-align":"center"})
        var name=$("#aid").val();
        var passwd=$("#apasswd").val();
        $.ajax({
            type:"post",
            url:"/admin/login.action",
            data:{name:name,password:passwd},
            success:function (data) {
                if(data=='1'){
                    window.location.reload();
                }else {
                    $("#msg").html("密码或账号错误").css({"color":"red","text-align":"center"});
                }
            },
            error:function () {
                $("#msg").html("网络异常，稍后重试").css({"color":"red","text-align":"center"});
            }
        })
    })
    $("#cleanRes").click(function () {
        var check=$("input[type='checkbox']:checked").length;
        if (check==0){
            alert("请至少选中一个")
            return false;
        }
        var checks=$("input[type='checkbox']:checked");
        $.each(checks,function () {
            $.ajax({
                type:"post",
                url:"/resourceadmin/remove.action",
                data:{id:$(this).val()},
                dataType:"json",
                success:function(data){
                    if (data==1){
                        window.location.reload()
                    }
                },
                error:function () {
                    alert("网络异常，请稍后重试")
                }
            })
        })
    })
})