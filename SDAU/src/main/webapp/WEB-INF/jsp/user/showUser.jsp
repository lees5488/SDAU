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
  </head>
  
  <body>
  <div class="easyui-panel" style="padding:5px;width:'auto'" data-options="fit:true,border:false">
 	 <div class="easyui-panel func-btn-panel" style="padding:5px;" data-options="doSize:false">
        <a id="showUserBtnQuery" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search'">查询</a>
        <a id="showUserBtnAdd" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-add'" >新增</a>
    </div>
  	<div class="spacing"></div>
  	<div class="easyui-panel search-panel" title="查询条件" style="" data-options="doSize:false">
  		  <form id="showUserSearchForm" method="post">
  		  	<table class="search-table">
  		  		<tr>
  		  			<td>事件编号</td>
  		  			<td><input class="midText" type="text" name="problemNo"></td>
  		  			<td>事件名称</td>
  		  			<td><input class="midText" type="text" name="problem"></td>
  		  			<td>上报日期</td>
  		  			<td><input name="reportDateStart" class="easyui-datebox" type="text" data-options="validType:'dateType'" value="$!{queryParam.reportDateStart}"/></td>
                    <td class="txt-center">～</td>
                    <td><input name="reportDateEnd" class="easyui-datebox" type="text" data-options="validType:'dateType'" value="$!{queryParam.reportDateEnd}"/></td>
                    <td>事件状态</td>
                    <td>
                    	  <select name="problemFlg" class="easyui-combobox detail-value-combo" data-options="editable:false">
                    	  <option value=""></option>
                    	  <option value="已上报">已上报</option>
                    	  <option value="已分配">已分配</option>
                    	  <option value="已处理">已处理</option>
                    	  <option value="已反馈">已反馈</option>
                    	  <option value="已完结">已完结</option>
                    </td>
  		  		</tr>
  		  	</table>
  		  </form>
  	</div>
  	
  	  <div class="spacing"></div>
  	  
<%--   	<table id="${pageId}Table" class="autosize-table base-table" title="查询结果" style="width:auto" > --%>
  	
  	<div class="easyui-panel search-panel" title="查询结果" style="" data-options="doSize:false">
  	<table id="showUserTable" class="easyui-datagrid" 
			toolbar="#toolbar" 
			pagination="true"
			url="${pageContext.request.contextPath}/user/showUserQuery"
		   <%--  fit="true"
			url="${path}/user/showUser" 
			toolbar="#toolbar" 
			pagination="true"
			fitColumns="true" 
			singleSelect="true" 
			rownumbers="true"
			striped="true"
			border="false" 
			nowrap="false" --%>>
  		<thead data-options="frozen:true">
            <tr>
               <!--  <th data-options="checkbox:true"></th> -->
                
                <th data-options="field:'id',width:'180',halign:'center',align:'left',sortable:true">事件编号</th>
                <th data-options="field:'userName',width:'180',halign:'center',align:'left',sortable:true">事件名称</th>
                <th data-options="field:'password',width:'180',halign:'center',align:'left',sortable:true">上报日期</th>
                <th data-options="field:'address',width:'180',halign:'center',align:'left',sortable:true">事件状态</th>
      <!--           
                <th data-options="field:'id',width:'180',halign:'center',align:'left',sortable:true">事件编号</th>
				<th data-options="field:'problemName',width:'80',halign:'center',align:'left',sortable:true">事件名称</th>
				<th data-options="field:'reportDate',width:'180',halign:'center',align:'left',sortable:true">上报日期</th>
				<th data-options="field:'processDate',width:'100',halign:'center',align:'right',sortable:true">处理日期</th>
				<th data-options="field:'accomplishDate',width:'80',halign:'center',align:'center',sortable:true">完结日期</th>
				<th data-options="field:'problemStatus',width:'180',halign:'center',align:'left',sortable:true">事件状态</th>
				<th data-options="field:'printStatus',width:'80',halign:'center',align:'center',sortable:true" >打印状态</th>
				 -->
				<!--  
				<th data-options="field:'userName',width:'80',halign:'center',align:'center',sortable:true" >打印状态</th>
				 -->
            </tr>
        </thead>
  	</table>
<!--   	<div class="easyui-pagination" data-options=""></div> -->
  </div>
<div id="showUserDialog" class="easyui-dialog detail-dialog" closed="true"  data-options="width:'1070',height:'569'" title="事件上报详细">
</div>
 <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/user/showUser.js"></script>
<%--  <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/user/showUser.js"></script>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/icon.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/jquery-easyui-1.5.1/demo/demo.css">
	<script type="text/javascript" src="${pageContext.request.contextPath}/static/jquery-easyui-1.5.1/jquery.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/static/jquery-easyui-1.5.1/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/static/jquery-easyui-1.5.1/locale/easyui-lang-zh_CN.js"></script>
   --%>
<script type="text/javascript">

$('#showUserBtnAdd').click(function(){
	$('#showUserDialog').dialog('open').dialog('refresh', 'showUserDetail');
});
/* $('#showUserTable').datagrid({
	url:'${pageContext.request.contextPath}/user/showUserQuery',
	exOnClickLinkCell:function(rowIndex, field, value){
		// 弹出详细画面
		$('#impForecastListDialog').dialog('open').dialog('refresh', 'inComingForecastDetail?forecastNo=' + value);
	},
	onBeforeLoad:function(param){
		var queryData = $('#showUserSearchForm').serializeObject();
		param = $.extend(param, queryData);
	}
}); */


</script>
  </body>
</html>
