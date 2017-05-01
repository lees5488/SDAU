<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" 
           uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
		<div class="spacing"></div>

		<div class="easyui-panel" style="padding: 5px; width: 'auto'"
			data-options="fit:true,border:false">
			<div class="easyui-panel func-btn-panel" style="padding: 5px;"
				data-options="doSize:false"></div>
			<div class="spacing"></div>
			<div class="easyui-panel" title="主表信息">
				<table id="$userDetailTable" class="detail-property-table "
					style="width: 100%">
					<tbody>
						<tr>
							<c:if test="${empty user.userName}">
							<td>姓名</td>
							<td><input type="text" id="userName" name="userName"
								 class="detail-value-input midText"
								value="${user.userName}"></td>
							</c:if>
							<c:if test="${user.userName!=null}">
							<td>姓名</td>
							<td><input type="text" id="userName" name="userName"
								readonly="readonly"
								 class="detail-value-input midText"
								value="${user.userName}"></td>
							</c:if>
					    </tr>
					    <tr>
							<td>密码</td>
							<td><input type="text" name="password" 
								class="detail-value-input midText" maxlength="50"
								value="${user.password}"></td>
						</tr>
						<tr>
							<td>年龄</td>
							<td><input type="text" id="age" 
								class="detail-value-input midText" value="${user.age}">
							</td>
						</tr>
						<tr>
							<td>联系电话</td>
							<td><input type="text" id="phone" 
								class="detail-value-input midText" value="${user.phone}">
							</td>
						</tr>
						<tr>
							<td>联系地址</td>
							<td><input type="text" id="address"
								class="detail-value-input midText" value="${user.address}">
							</td>
						</tr>
						<tr>
							<td>创建时间</td>
							<td><input type="text" id="createDate" readonly="readonly"
								class="detail-value-input midText" value="${user.createDateStr}">
							</td>
						</tr>
					</tbody>
				</table>
				<div class="dialog-bottom-buttons" align="right">
					<a id="userDetaliBtnSave" href="#" class="easyui-linkbutton"
						iconCls='icon-save'>保存</a> 
					<a id="userDetaliBtnQuit" href="#" class="easyui-linkbutton"
					    iconCls='icon-back'>退出</a>
				</div>
			</div>
		</div>
<script type="text/javascript">
//退出按钮
$('#userDetaliBtnQuit').click(function(){
	$('#userListDialog').dialog('close');
});

</script>
</body>
</html>