<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
  <head>
	<title>测试</title>
<!-- 	  <script type="text/javascript">
  function click(){
	  alert("Click!!!");
  }
  </script> -->
  <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/showUser.js"></script>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/icon.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/jquery-easyui-1.5.1/demo/demo.css">
<!-- 	
	<link rel="stylesheet" type="text/css" href="../../../static/css/icon.css">
	<link rel="stylesheet" type="text/css" href="../../../static/js/demo/demo.css">
	 -->
	<!-- <script type="text/javascript" src="js/jquery.min.js"></script> -->
	<script type="text/javascript" src="${pageContext.request.contextPath}/static/jquery-easyui-1.5.1/jquery.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/static/jquery-easyui-1.5.1/jquery.easyui.min.js"></script>
<!-- 	<script type="text/javascript" src="../../../static/js/jquery.easyui.min.js"></script> -->
	<!-- <script type="text/javascript" src="#springUrl('/static/js/jquery.min.js')"></script> -->
	<script type="text/javascript">
	
	$(function(){

		$('#addUserTable').datagrid({
			url:'/user/query',
			onBeforeLoad:function(param){
				param = $.extend(param);
			}
		});
		
	});
	</script>
  </head>
  
  <body>
 	<div style="margin:20px 0;"></div>
  	<div class="easyui-layout" style="width:700px;height:350px;">
		<div data-options="region:'north'" style="height:50px"></div>
		<div data-options="region:'south',split:true" style="height:50px;"></div>
		<div data-options="region:'east',split:true" title="East" style="width:100px;"></div>
		<div data-options="region:'west',split:true" title="West" style="width:100px;"></div>
		<div data-options="region:'center',title:'Main Title',iconCls:'icon-ok'">
			<table id="addUserTable" class="easyui-datagrid"
					data-options="method:'get',border:false,singleSelect:true,fit:true,fitColumns:true">
				<thead>
					<tr>
						<th data-options="field:'itemid'" width="80">Item ID</th>
						<th data-options="field:'productid'" width="100">Product ID</th>
						<th data-options="field:'listprice',align:'right'" width="80">List Price</th>
						<th data-options="field:'unitcost',align:'right'" width="80">Unit Cost</th>
						<th data-options="field:'attr1'" width="150">Attribute</th>
						<th data-options="field:'status',align:'center'" width="60">Status</th>
					</tr>
				</thead>
			</table>
		</div>
	</div>
  
    ${user.userName}
    ${user.password}
    <div class="age">
    ${user.age}
    <h2>
    YYYYYYY
    </h2>
    <input type="button" onclick="click()" value="CLICK">
    </div>
  </body>

</html>
