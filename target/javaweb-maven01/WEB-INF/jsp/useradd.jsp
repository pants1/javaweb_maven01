<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsp/common/head.jsp"%>

<div class="right">
    <div class="location">
        <strong>你现在所在的位置是:</strong>
        <span>用户管理页面 >> 用户添加页面</span>
    </div>
    <div class="providerAdd">
        <form id="userForm" name="userForm"  method="post"
              enctype="multipart/form-data"
              action="${pageContext.servletContext.contextPath }/User/user.do">
            <input type="hidden" name="method" value="add">
            <!--div的class 为error是验证错误，ok是验证成功-->
            <div>
                <label for="userCode">用户编码：</label>
                <input type="text" name="userCode" id="userCode" value="">
                <!-- 放置提示信息 -->
                <font color="red"></font>
            </div>
            <div>
                <label for="userName">用户名称：</label>
                <input type="text" name="userName" id="userName" value="">
                <font color="red"></font>
            </div>
            <div>
                <label for="userPassword">用户密码：</label>
                <input type="password" name="userPassword" id="userPassword" value="">
                <font color="red"></font>
            </div>
            <div>
                <label for="ruserPassword">确认密码：</label>
                <input type="password" name="ruserPassword" id="ruserPassword" value="">
                <font color="red"></font>
            </div>
            <div>
                <label >用户性别：</label>
                <select name="gender" id="gender">
                    <option value="1" selected="selected">男</option>
                    <option value="2">女</option>
                </select>
            </div>
            <div>
                <label for="birthday">出生日期：</label>
                <input type="text" Class="Wdate" id="birthday" name="birthday"
                       readonly="readonly" onclick="WdatePicker()">
                <font color="red"></font>
            </div>
            <div>
                <label for="phone">用户电话：</label>
                <input type="text" name="phone" id="phone" value="">
                <font color="red"></font>
            </div>
            <div>
                <label for="address">用户地址：</label>
                <input name="address" id="address"  value="">
            </div>
            <div>
                <label >用户角色：</label>
                <!-- 列出所有的角色分类 -->
                <input type="hidden" id="contextPath" value="${pageContext.servletContext.contextPath}">
                <select name="userRole" id="userRole">
                </select>
                <font color="red"></font>
            </div>
            <div>
                <label >文件上传：</label>
                <!-- 列出所有的角色分类 -->
                <input  type="file" name="path" id="path"/>
                <br>
                <img id="uploadImg" style="width: 300px;height: 200px;margin-left: 30px"/>
                <font color="red"></font>
            </div>
            <div class="providerAddBtn">
                <input type="submit" name="add" id="add" value="保存" >
                <input type="button" id="back" name="back" value="返回" >
            </div>
        </form>
    </div>
</div>
</section>
<%@include file="/WEB-INF/jsp/common/foot.jsp" %>
<script src="${pageContext.request.contextPath }/statics/js/jquery-1.12.4.js" charset="utf-8"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/statics/js/useradd.js"></script>
<script>
    //给file元素绑定change事件,实现显示客户端选中的图片
    $("#pic").change(function (){
        //获取file文件对象
        var file = $(this)[0].files[0];
        //等价于document.getElementById("pic").files[0];
        //获取一个指向该元素的地址
        var path = window.URL.createObjectURL(file);
        console.log(path);
        $("#uploadImg").attr('src', path);
    })

</script>