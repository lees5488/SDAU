<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
	<title>测试</title>
<!-- 	  <script type="text/javascript">
  function click(){
	  alert("Click!!!");
  }
  </script> -->
<%--   <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/user/showUser.js"></script>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/icon.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/jquery-easyui-1.5.1/demo/demo.css">
	<script type="text/javascript" src="${pageContext.request.contextPath}/static/jquery-easyui-1.5.1/jquery.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/static/jquery-easyui-1.5.1/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/static/jquery-easyui-1.5.1/locale/easyui-lang-zh_CN.js"></script>
  --%>
  <style>
	.userName:link {color:#000000;}      /* 未访问链接*/
	.userName {color:#00FF00;}  /* 已访问链接 */
	.userName:hover {color:#FF00FF;}  /* 鼠标移动到链接上 */
	.userName:active {color:#0000FF;}  /* 鼠标点击时 */
</style>
  </head>
  
  <body>
  <div class="easyui-panel" style="padding:5px;width:'auto'" data-options="fit:true,border:false">
 	 <div class="easyui-panel func-btn-panel" style="padding:5px;" data-options="doSize:false">
        <a id="userListBtnAdd" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-add'">新增</a>
        <a id="userListBtnQuery" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search'">查询</a>
        <a id="userListBtnReset" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-clear'" >重置</a>
        <a id="userListBtnDelete" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-remove'" >删除</a>
    </div>
  	<div class="spacing"></div>
  	<div class="easyui-panel search-panel" title="查询条件" style="" data-options="doSize:false">
  		  <form id="userListSearchForm" method="post">
  		  	<table class="search-table">
  		  		<tr>
  		  			<td>姓名</td>
  		  			<td><input class="midText" type="text" name="userName"></td>
  		  			<td>密码</td>
  		  			<td><input class="midText" type="text" name="password"></td>
  		  			<td>电话</td>
  		  			<td><input class="midText" type="text" name="phone"></td>
  		  			<td>地址</td>
  		  			<td><input class="midText" type="text" name="address"></td>
  		  		</tr>
  		  	</table>
  		  </form>
  	</div>
  	
  	  <div class="spacing"></div>
  	  
<%--   	<table id="${pageId}Table" class="autosize-table base-table" title="查询结果" style="width:auto" > --%>
  	<div class="easyui-panel search-panel" title="查询结果" style="" data-options="doSize:false">
  	<table id="userListTable" class="easyui-datagrid" 
			toolbar="#toolbar" 
			pagination="true"
			striped="true"
			rownumbers="true"
			singleSelect="true"
			checkOnSelect="true"
			selectOnCheck="false"
		   <%--  fit="true"
			url="${path}/user/showUser" 
			toolbar="#toolbar" 
			pagination="true"
			fitColumns="true" 
			singleSelect="true" 
			rownumbers="true"
			striped="true"
			border="false" 
			nowrap="false" --%>
		data-options="sortable:true,   
        url:'',
        onClickRow:userListTableOnClickRow ,
		pagination:false">
  		<thead data-options="frozen:true">
            <tr>
            <th data-options="field:'ck',checkbox:true"></th>
                <th class="userName" data-options="field:'userName',width:'10%',halign:'center',align:'left',sortable:true,formatter:linkCellFormatter"
                 ,editor = "{
                    type:'validatebox',
                    options:{ required:true }
                }">姓名</th>
                <th data-options="field:'password',width:'10%',halign:'center',align:'left',sortable:true"
                >密码</th>
                <th data-options="field:'age',width:'3%',halign:'center',align:'right',sortable:true",
                 editor = "{
                    type:'numberbox',
                    options:{ required:true,min:0,max:100 }
                }">年龄</th>
                <th data-options="field:'phone',width:'10%',halign:'center',align:'left',sortable:true ,prompt:'请输入正确的手机号码。',validType:'phoneNum'"
                >联系电话</th>
                <th data-options="field:'address',width:'20%',halign:'center',align:'left',sortable:true",
                 editor = "{
                    type:'validatebox',
                    options:{ required:true }
                }">联系地址</th>
                <th data-options="field:'createDateStr',width:'18%',halign:'center',align:'left',sortable:true">创建时间</th>
                <th data-options="field:'createUserStr',width:'4%',halign:'center',align:'left',sortable:true">创建人</th>
                <th data-options="field:'updateDateStr',width:'18%',halign:'center',align:'left',sortable:true">更新时间</th>
                <th data-options="field:'updateUserStr',width:'4%',halign:'center',align:'left',sortable:true">更新人</th>
            </tr>
        </thead>
  	</table>
        <a id="userListBtnSave" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-save'" style="float: right; background-color: " >保存</a>
  </div>
</div>
<div id="userListDialog" class="easyui-dialog detail-dialog" closed="true"  data-options="width:'1070',height:'569'" title="用户详细">
  <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/system/userList.js">

  </script>
  </body>
</html>
