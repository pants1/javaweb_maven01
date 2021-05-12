// 焦点离开验证输入的原密码
$("#oldpassword").blur(function (){
    $("#oldpassword").next("font").html("");
    var oldPWd=$("#oldpassword").val();
    $.ajax({
        "url":window.location.href+"/../testingpwd.do",
        data: "oldPassword="+oldPWd,
        "type": "POST",
        async: false,
        "dataType": "text",
        "success": function(data){
            if(data=="false"){
                $("#oldpassword").next("font").html("原密码输入错误，请重新输入");
            }else{
                $("#oldpassword").next("font").before(" <img style='width: 20px' class='dui' src=\"../statics/images/y.png\">")
                $("#oldpassword").next("font").html(" ");
            }
        },
        "error":function (xhr, textStatus, errorThrown){
            alert("请求失败");
        }
    });
})

//新密码不为空
$("#newpassword").blur(function (){
    if($(this).val()==""){
        $("#newpassword").next("font").html("新密码不能为空！");
    }else{
        $("#newpassword").next("font").before(" <img style='width: 20px' class='dui' src=\"../statics/images/y.png\">")
        $("#newpassword").next("font").html(" ");
    }
})
//判断新密码和二次密码是否相同
$("#rnewpassword").blur(function (){
    var newpw =$("#newpassword").val();
    if($(this).val()!=newpw||$(this).val()==""){
        $(this).next("font").html("两次密码不同，请重新输入");
    }else{
        $("#rnewpassword").next("font").before(" <img style='width: 20px' class='dui' src=\"../statics/images/y.png\">")
        $(this).next("font").html("");
    }
})

function  check(){
    $("#oldpassword").blur();
    $("#newpassword").blur();
    $("#rnewpassword").blur();
    var flag=true;
    $("#userForm font").each(function (index,item){
        if($(item).html()!=""){
            flag=false;
        }else{
            flag=true;
        }
    })
    return flag;
}