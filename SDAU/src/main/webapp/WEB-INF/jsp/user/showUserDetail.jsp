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
  <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/user/showUser.js"></script>
  
  <%-- 
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
    </div>
  	<div class="spacing"></div>
  	 <div class="easyui-panel" title="主表信息">
        <table id="${pageId}Header" class="detail-property-table " style="width:100%">
        	<tbody >
                <tr>
                    <td>事件名称</td>
                    <td><input type="text" id="${pageId}DispatchNo" name="dispatchNo"  class="detail-value-input midText" value=""></td>
                   
				</tr>
				
                <tr>
                  	<td>备注</td>
                    <td>
						<input type="text" id="${pageId}dispatchDate"  class="detail-value-input midText" value="">
					</td>
                 </tr>
                 <tr>
                  	<td>创建时间</td>
                    <td>
						<input type="text" id="${pageId}dispatchDate" readonly="readonly" class="detail-value-input midText" value="">
					</td>
                 </tr>
                 <tr>
					<td>事件内容</td>
                    <td><input type="text" name="dispatchEmployeeNo"  class="detail-value-input midText" maxlength="50" value=""></td>
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

</body>

</html>
