<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" 
           uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
  <head>
	<title>测试</title>
	
<link rel="shortcut icon" href="${pageContext.request.contextPath}/static/img/grid.ico">
	
<%-- 	
	
<!-- 	  <script type="text/javascript">
  function click(){
	  alert("Click!!!");
  }
  </script> -->
  <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/user/addUser.js"></script> 
  <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/user/showUser.js"></script>
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
	<script type="text/javascript" src="${pageContext.request.contextPath}/static/jquery-easyui-1.5.1/locale/easyui-lang-zh_CN.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/highcharts.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/common.js"></script>
 <!-- 	<style type="text/css">
	.easyui-linkbutton{
		margin: 0px;
		background-color: red;
	}
	
	</style>  -->
	
	 --%>

	
  </head>
  
  <body class="easyui-layout">
 	<div style="margin:20px 0;"></div>
<!--   	<div class="easyui-layout" style="width:90%;height:700px;"> -->
	 	<div data-options="region:'north'"  style="height: 80px; padding: 10px; background-color: #2d3e50;color:#c7c7c7;">
	 	 	<div style="height:24px;width:400px;border-bottom:1px solid #c4c4c4;font-size:18px;">  
             	社区网格管理系统
            </div>  
	 	</div>
		<div data-options="region:'south'"  style="height:50px;">
			<div class="easyui-panel login-info-panel" title="登录信息" 
			data-options="doSize:false,style:{position: 'absolute',left:0}">
                <a id="modifyPassword" href="#">${loginUser.userName}</a>
                <a href="${pageContext.request.contextPath}/login/logout.html">退出</a>
			</div>
		
			<div class="copyright" align="center">Copyright © 2017</div>
		
		</div>
		<!-- <div data-options="region:'east',split:true" title="East" style="width:100px;"></div> -->
		<div data-options="region:'west',split:true " title="菜单" style="width:100px;">
			<div class="easyui-accordion" data-options="fit:true,border:false">
				<div title="基本管理" style="padding:10px;">
					<a href="#" class="easyui-linkbutton" onclick="javascript: AddTab('网格管理', '/announcement/grid')">网格管理</a>
					<a href="#" class="easyui-linkbutton" onclick="javascript: AddTab('人员管理', '${pageContext.request.contextPath}/employeeList/index')">员工管理</a>
					<a href="#" class="easyui-linkbutton" onclick="javascript: AddTab('部门管理', '${pageContext.request.contextPath}/department/index')">部门管理</a>
					<a href="#" class="easyui-linkbutton" onclick="javascript: AddTab('机构管理', '/SiteInfo/Index')">机构管理</a>
					<a href="#" class="easyui-linkbutton" onclick="javascript: AddTab('公告管理', '${pageContext.request.contextPath}/announcement/anno')">公告管理</a>
				</div>
				<div title="事件管理" style="padding:10px;">	
					<a href="#" class="easyui-linkbutton" onclick="javascript: AddTab('事件上报', '${pageContext.request.contextPath}/user/showUser')">事件上报</a>
					<a href="#" class="easyui-linkbutton" onclick="javascript: AddTab('事件查看', '/SiteInfo/Index')">事件查看</a>
					<a href="#" class="easyui-linkbutton" onclick="javascript: AddTab('事件分配', '/SiteInfo/Index')">事件分配</a>
					<a href="#" class="easyui-linkbutton" onclick="javascript: AddTab('事件处理', '/SiteInfo/Index')">事件处理</a>
					<a href="#" class="easyui-linkbutton" onclick="javascript: AddTab('事件反馈', '/SiteInfo/Index')">事件反馈</a>
					<a href="#" class="easyui-linkbutton" onclick="javascript: AddTab('事件完结', '/SiteInfo/Index')">事件完结</a>
				<!-- 	
					<a href="javascript:void(0)" class="easyui-linkbutton" onclick="javascript:$('#addUserTable').panel('open')"
					data-options="doSize:false,style:{position: 'absolute',bottom: 0,right:0,left:0}">事件分配</a>
					 -->
				</div>
				<div title="统计分析" style="padding:10px">
					<a href="#" class="easyui-linkbutton" onclick="javascript: AddTab('事件统计', '${pageContext.request.contextPath}/user/weather')">事件统计</a>
					<a href="#" class="easyui-linkbutton" onclick="javascript: AddTab('评分统计', '${pageContext.request.contextPath}/statistics/scoreList')">评分统计</a>
				</div>
				<div title="系统管理" style="padding:10px">
					<a href="#" class="easyui-linkbutton" onclick="javascript: AddTab('用户管理', '')">用户管理</a>
					<a href="#" class="easyui-linkbutton" onclick="javascript: AddTab('用户列表', '${pageContext.request.contextPath}/system/userList')">用户列表</a>
					<a href="#" class="easyui-linkbutton" onclick="javascript: AddTab('角色管理', '/SiteInfo/Index')">角色管理</a>
				</div>
			</div>
		</div>
		<div data-options="region:'center',title:'CGM TYS'">
			<div id="tabs" class="easyui-tabs tabs-body" data-options="fit:true,border:false, plain:true">
				<div title="公告" style="padding:10px">  
	                <h3 align="center">Welcome to The Community Grid Managing TY System 1.0</h3>
	                <h2 align="left">
	                	<br>${anno.anno }
	                </h2>
<%--  
	              <table>
	                 <tr>
	                 <td>编号</td>
	                 <td>姓名</td>
	                  <td>密码</td>
	                  <td>地址</td>
	                  <td>号码</td>
	                  <td>创建时间</td>
	                  <td>创建者</td>
	                  
	               </tr>
	              <c:forEach var="item"   items="${user}">
	               <tr>
	               	<td>${item.id}</td>
	               	<td>${item.userName}</td>
	               	<td>${item.password}</td>
	               	<td>${item.address}</td>
	               	<td>${item.phone}</td>
	               	<td>${item.createDateStr}</td>
	               	<td>${item.createUser}</td>
	               </tr>   
                  </c:forEach>
	                </table>
	              	    <div class="age">
					    <h2>
					    YYYYYYY
 --%>
	                @*<a href="javascript:void(0)" class="easyui-linkbutton" onclick="topCenter('ok')">TopCenter</a>*@  
	       		</div> 
	    	</div>
		</div>
	</div>
<!--     	<script type="text/javascript">
		var toolbar = [{
			text:'新增',
			iconCls:'icon-add',
			handler:function(){alert('add')}
		},'-',{
			text:'Cut',
			iconCls:'icon-cut',
			handler:function(){alert('cut')}
		},'-',{
			text:'保存',
			iconCls:'icon-save',
			handler:function(){alert('save')}
		}];
	</script> -->
	<script type="text/javascript">
	
	 function topCenter(val,time) {  
         $.messager.show({  
             title: '友情提示！',  
             msg: val,  
             timeout: time,  
             showType: 'slide',  
             style: {  
                 right: '',  
                 bottom: '',  
                 top: 80  
             }  
         });  
     };  
     //新增tabs
	 function AddTab(subtitle, url) {  
		 var urlsplit= new Array();
		 urlsplit = url.split("/");
         if (!$('#tabs').tabs('exists', subtitle)) {  
             $('#tabs').tabs('add', {  
                 title: subtitle,  
                 href: url,  
                 closable: true,  
                 width: $('#mainPanle').width() - 10,  
                 height: $('#mainPanle').height() - 10,  
                 tools:[{
                     iconCls:'icon-mini-refresh',
                     handler:function(){
                    	 //刷新页面的方法体
                         //alert('refresh');
                         var tabPanel = $('#tabs').tabs('getTab', subtitle);
                       /*   
                         var ds = tabPanel.panel('options').dialogs;
                     	 if (!ds) return;
                     	 for (var i = 0; i < ds.length; i++ ) {
                     		$(ds[i]).dialog('destroy');
                     		log('destroy dialog ' + ds[i]);
                     	 } 
                       */
	                 	 tabPanel.panel('refresh');
                       //destroyTabDialog(tabPanel);
                       //tabPanel.panel('refresh');
                     }
                 }]
             });  
         } else {  
             $('#tabs').tabs('select', subtitle);  
         }  
         TabClose();  
     }  
	  function TabClose() {  
          $(".tab-inner").dblclick(function () {  
              var subtitle = $(this).children("span").text();  
              $('#tabs').tabs('close', subtitle)  
          })  
      }  
	</script>
	<%@include file="/WEB-INF/jsp/easyui.jsp"%>
  </body>

</html>
