<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsp/common/head.jsp"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="right">
	<div class="location">
		<strong>你现在所在的位置是:</strong>
		<span>用户管理页面</span>
	</div>
	<div class="search">
		<input type="hidden" id="content" value="${pageContext.request.contextPath}">
		<form method="post"  action="${pageContext.request.contextPath }/User/queryList.do">
			<input name="method" value="query" class="input-text" type="hidden">
			<span>用户名：</span>
			<input name="queryname" class="input-text"	type="text" value="${queryname}">
			<span>用户角色：</span>
			<select name="queryUserRole" id="queryUserRole">
				<c:if test="${roleList!=null }">
					<option value="0">--请选择--</option>
					<c:forEach var="role" items="${roleList}">
						<option <c:if test="${role.id== queryUserRole}">selected="selected"</c:if>
								value="${role.id}">${role.roleName}</option>
					</c:forEach>
				</c:if>
			</select>

			<input type="hidden" name="beginPage" value="1"/>
			<input	value="查 询" type="submit" id="searchbutton">
			<a href="${pageContext.request.contextPath}/User/addUser.do" >添加用户</a>
		</form>
	</div>
	<!--用户-->
	<table class="providerTable" cellpadding="0" cellspacing="0">
		<tr class="firstTr">
			<th width="10%">用户编码</th>
			<th width="20%">用户名称</th>
			<th width="10%">性别</th>
			<th width="10%">年龄</th>
			<th width="10%">电话</th>
			<th width="10%">用户角色</th>
			<th width="30%">操作</th>
		</tr>
		<p style="color: red">${data}</p>
		<c:forEach var="user" items="${userList }" varStatus="status">
			<tr id="${user.id }">
				<td>
					<span>${user.userCode }</span>
				</td>
				<td>
					<span>${user.userName }</span>
				</td>
				<td>
							<span>
								<c:if test="${user.gender==1}">男</c:if>
								<c:if test="${user.gender==2}">女</c:if>
							</span>
				</td>
				<td>
					<span>${user.age}</span>
				</td>
				<td>
					<span>${user.phone}</span>
				</td>
				<td>
					<span>${user.roleName}</span>
				</td>
				<td>
					<span><a class="viewUser" href="javascript:;" userid=${user.id } username=${user.userName }><img src="${pageContext.request.contextPath }/statics/images/read.png" alt="查看" title="查看"/></a></span>
					<span><a class="modifyUser" href="javascript:;" userid=${user.id } username=${user.userName }><img src="${pageContext.request.contextPath }/statics/images/xiugai.png" alt="修改" title="修改"/></a></span>
					<span><a class="deleteUser" href="javascript:;" userid=${user.id } username=${user.userName }><img src="${pageContext.request.contextPath }/statics/images/schu.png" alt="删除" title="删除"/></a></span>
				</td>
			</tr>
		</c:forEach>
	</table>
	<input type="hidden" id="totalPageCount" value="${page.totalPageCount}"/>
	<c:import url="rollpage.jsp">
		<c:param name="totalCount" value="${page.totalCount}"/>
		<c:param name="currentPageNo" value="${page.currPageNo}"/>
		<c:param  name="totalPageCount"  value="${page.totalPageCount}"/>
	</c:import>
</div>
</section>

<!--点击删除按钮后弹出的页面-->
<div class="zhezhao"></div>
<div class="remove" id="removeUse">
	<div class="removerChid">
		<h2>提示</h2>
		<div class="removeMain">
			<p>你确定要删除该用户吗？</p>
			<a href="#" id="yes">确定</a>
			<a href="#" id="no">取消</a>
		</div>
	</div>
</div>
<%@include file="/WEB-INF/jsp/common/foot.jsp"%>
<script src="${pageContext.request.contextPath }/statics/js/jquery-1.12.4.js" charset="utf-8"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/statics/js/userlist.js"></script>
