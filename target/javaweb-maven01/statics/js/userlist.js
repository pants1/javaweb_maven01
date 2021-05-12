// 实现删除功能
var url=window.location.href +"/../../User/queryList.do"
$(".deleteUser").click(function(){
    var userid=$(this).attr("userid")
    $.ajax({
        // window.location.href +"/../../User/delectUser.do"
        "url": "delectUser.do",
        data: "userid="+userid,
        "type": "POST",
        "dataType": "text",
        "success": function(data){
            if(data=="true"){
                $("#"+userid).remove();
                alert("删除成功")
            }else{
                alert("删除失败")
            }
        },
        "error":function (){
            alert("请求失败");
        }
    });
})

// 实现修改功能
$(".modifyUser").click(function(){
    var  url=$("#content").val();
    var userid=$(this).attr("userid")
    // location.href("/modifyUser.do?userid="+userid);
    $(window).attr('location',url+"/User/modifyUser.do?userid="+userid);
})
//实现查看功能
$(".viewUser").click(function (){
    var userid=$(this).attr("userid")
    $(window).attr('location',url+"/User/view.do/"+userid);
})
