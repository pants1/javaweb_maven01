// 动态加载角色列表
$(document).ready(function (){
    // window.location.href+"/../RoleShow.do",
    $.ajax({
        "url": window.location.href+"/../../User/RoleShow.do",
        "type": "POST",
        "dataType": "json",
        "success": function(data){
            if(data!=null){
                var result=data;
                $.each(result,function (index,item){
                    $("#userRole").append("<option  value='"+item.id+"'>"+item.roleName+"</option>");
                })
            }
        },
        "error":function (xhr, textStatus, errorThrown){
            alert("请求失败");
        }
    });
})

//需求:
//实现异步验证用户编码：userCode
$("#userCode").blur(function (){
    if($(this).val()==""){
        $("#userForm font:eq(0)").html("密码不能为空")
    }else{
        $("#userForm font:eq(0)").html("")
        var userCode=$(this).val()
        $.ajax({
            "url":window.location.href+"/../../User/UserCode.do",
            data: "userCode="+userCode,
            "type": "POST",
            "dataType": "text",
            "success": function(data){
                if(data=="false"){
                    $("#userForm font:eq(0)").html("已存在,请重新输入")
                }else{
                    $("#userForm font:eq(0)").html("")
                }
            },
            "error":function (xhr, textStatus, errorThrown){
                alert("请求失败");
            }
        });
    }
})
$("#userPassword").blur(function (){

    if($(this).val()==""){
        $("#userForm font:eq(2)").html("密码不能为空")
    }else{
        $("#userForm font:eq(2)").html("")
    }
})
$("#ruserPassword").blur(function (){
    var newpw =$("#userPassword").val();
    if($(this).val()==""){
        $("#userForm font:eq(3)").html("不能为空")
    }else{
        $("#userForm font:eq(3)").html("")
    }
    if($(this).val()!=newpw){
        $("#userForm font:eq(3)").html("二次密码错误，请重新输入")
    }else{
        $("#userForm font:eq(3)").html("")
    }
})
// function  addSubmit(){
//     var Froms=$("#userForm").serialize();
//     var url=$("#contextPath").val();
//     $.ajax({
//         "url":  "../User/user.do",
//         "data":Froms,
//         "type": "post",
//         "dataType": "text",
//         "success": function(data){
//             // if(data=="true"){
//             //     alert("添加成功")
//             //     location.href("/UserView.do");
//             // }
//         },
//         "error":function (xhr, textStatus, errorThrown){
//             alert("请求失败");
//         }
//     });
//     birthday.bind("focus",function(){
//         validateTip(birthday.next(),{"color":"#666666"},"* 点击输入框，选择日期",false);
//     }).bind("blur",function(){
//         if(birthday.val() != null && birthday.val() != ""){
//             validateTip(birthday.next(),{"color":"green"},imgYes,true);
//         }else{
//             validateTip(birthday.next(),{"color":"red"},imgNo + " 选择的日期不正确,请重新输入",false);
//         }
//     });
// }








