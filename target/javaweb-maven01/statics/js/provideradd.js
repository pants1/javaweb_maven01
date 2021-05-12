// $("#providerForm div img).attr("with");
//点击返回跳转到指定页面
$("#back").click(function (){
    window.location.href="providerlist.jsp";
})
$("#proCode").blur(function (){
    $("#providerForm div:eq(0)>img").remove();
    var value=$("#proCode").val();
    if(value==""){
        $("#providerForm div:eq(0)>font").html("不能为空！！！")
    }else{
        $.ajax({
            "url": window.location.href + "/../../provider/pro.do",
            data: "value="+value,
            "type": "POST",
            "dataType": "text",
            "success": function(data){
                if(data=="false"){
                    $("#providerForm div:eq(0)>font").html("已注册，请重新输入！！！")
                }else{
                    $("#providerForm div:eq(0)>font").before(" <img src=\"../images/y.png\">")
                    $("#errorCode").html("");
                }
            },
            "error":function (xhr, textStatus, errorThrown){
                alert("进入error---");
                alert("状态码："+xhr.status);
                alert("状态:"+xhr.readyState);//当前状态,0-未初始化，1-正在载入，2-已经载入，3-数据进行交互，4-完成。
                alert("错误信息:"+xhr.statusText );
                alert("返回响应信息："+xhr.responseText );//这里是详细的信息
                alert("请求状态："+textStatus);
                alert(errorThrown);
                alert("请求失败");
            }
        });
    }
})
var falg=true;

//下面用正则表达判断供应商名称：/联系人：/联系电话：这些字段是否正确
$("#proName").blur(function (){
    $("#providerForm div:eq(1)>img").remove();
    var proName=$("#proName").val();
    var regExp =/^[\u4e00-\u9fa5]{2,4}|[a-zA-Z]{2,16}$/g;
    if(!regExp.test(proName)){
        $("#providerForm div:eq(1)>font").html("名称格式错误，请重新输入")
    }else{
        $("#providerForm div:eq(1)>font").before(" <img  src=\"../images/y.png\">")
        $("#providerForm div:eq(1)>font").html("")
    }
})

$("#proPhone").blur(function (){
    $("#providerForm div:eq(3)>img").remove();
    var proName=$("#proPhone").val();
    var regExp = /^1[34578]\d{9}$/;;
    if(!regExp.test(proName)){
        $("#providerForm div:eq(3)>font").html("手机号码格式错误，请重新输入")
    }else{
        $("#providerForm div:eq(3)>font").before(" <img src=\"../images/y.png\">")
        $("#providerForm div:eq(3)>font").html("")
    }
})
//只有所有的数据合法才可以提交
//实现思路：在点击保存时验证所有的表单，如果最终返回true就可以提交数据
function ceckMform(){
    var falg=true;
    $("#providerForm font").each(function (index,item){
       if($(item).html()!=""){
           falg=false;
       }
    })
    return falg;
}





