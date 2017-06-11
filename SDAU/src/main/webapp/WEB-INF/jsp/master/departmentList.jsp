<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>部门管理</title>
</head>
<body>
<div class="easyui-panel" style="padding:5px;width:'auto'" data-options="fit:true,border:false">
		<div class="easyui-panel func-btn-panel" style="padding: 5px;"data-options="doSize:false">
			<a id="departmentBtnAdd" href="#" class="easyui-linkbutton"	data-options="iconCls:'icon-add'">新增</a>
			<a id="departmentBtnQuery" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search'">查询</a>
			<a id="departmentBtnReset" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-clear'">重置</a> 
			<a id="departmentBtnDelete" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-remove'">删除</a>
		</div>
	<div class="spacing"></div>
  	<div class="easyui-panel search-panel" title="查询条件" data-options="doSize:false">
  		  <form id="departmentSearchForm" method="post">
  		  	<table class="search-table">
  		  		<tr>
  		  			<td>部门名称</td>
  		  			<td><input class="midText" type="text" name="fullName"></td>
  		  		</tr>
  		  	</table>
  		  </form>
  	</div>

	<div class="spacing"></div>
  	
    <div class="easyui-panel search-panel" title="查询结果" style="" data-options="doSize:false">
  	<table id="departmentTable" class="easyui-datagrid" 
			toolbar="#toolbar" 
			pagination="true"
			striped="true"
			rownumbers="true"
			singleSelect="true"
			checkOnSelect="true"
			selectOnCheck="false"
			data-options="sortable:true,   
        url:'',
		pagination:false">
  		<thead data-options="frozen:true">
            <tr>
            <th data-options="field:'ck',checkbox:true"></th>
                <th data-options="field:'shortName',width:'13%',halign:'center',align:'left',sortable:true">部门简称</th>
                <th data-options="field:'fullName',width:'17%',halign:'center',align:'right',sortable:true">部门全称</th>
                <th data-options="field:'parentName',width:'10%',halign:'center',align:'right',sortable:true">部门负责人</th>
                <th data-options="field:'level',width:'10%',halign:'center',align:'left',sortable:true">部门等级</th>
                <th data-options="field:'isuse',width:'7%',halign:'center',align:'left',sortable:true">使用标志</th>
                <th data-options="field:'remark',width:'10%',halign:'center',align:'left',sortable:true">备注</th>
            </tr>
        </thead>
  	</table>
  </div>
</div>
<div id="departmentDialog" class="easyui-dialog detail-dialog" closed="true"  data-options="width:'1070',height:'569'" title="部门详情">
<div class="spacing"></div>

<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/master/departmentList.js">

</body>
</html>