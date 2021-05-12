// 动态加载角色列表
$(document).ready(function (){
    // window.location.href+"/../RoleShow.do",
    $.ajax({
        "url": "RoleShow.do",
        "type": "POST",
        "dataType": "json",
        "success": function(data){
            if(data!=null){
                var result=data;
                $.each(result,function (index,item){
                   var select=$("#rid").val()
                    $("option[value="+select+"]").attr("selected","selected");
                    $("#userRole").append("<option  value='"+item.id+"'>"+item.roleName+"</option>");
                })
            }
        },
        "error":function (xhr, textStatus, errorThrown){
            alert("请求失败");
        }
    });
})
