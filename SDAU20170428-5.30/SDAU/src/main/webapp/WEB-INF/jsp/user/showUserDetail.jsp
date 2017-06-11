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
                    <td>装车单号</td>
                    <td><input type="text" id="${pageId}DispatchNo" name="dispatchNo" readonly="readonly" class="detail-value-input midText" value="$!{dispatchInfo.dispatchNo}"></td>
                    <td>司机</td>
                    <td><input type="text" name="dispatchEmployeeNo" readonly="readonly" class="detail-value-input midText" maxlength="50" value="$!esc.html($!{dispatchInfo.dispatchEmployeeNo})"></td>
                    <td>派车日期</td>
                    <td>
						<input type="text" id="${pageId}dispatchDate" readonly="readonly" class="detail-value-input midText" value="$!dateTimeUtil.format($!{dispatchInfo.dispatchDate})">
					</td>
                    <td>装车单状态</td>
                    <td>
						<input type="text" id="${pageId}dispatchStatusText" readonly="readonly" class="detail-value-input midText" value="$!{dispatchInfo.dispatchStatusText}">
					</td>
                </tr>
                <tr>
                    <td>打印状态</td>
                    <td>
						<input type="text" id="${pageId}printFlgText" readonly="readonly" class="detail-value-input midText" value="$!{dispatchInfo.printFlgText}">
					</td>
                    <td>回车日期</td>
                    <td>
						<input type="text" id="${pageId}returnDate" readonly="readonly" class="detail-value-input midText" value="$!dateTimeUtil.format($!{dispatchInfo.returnDate})">
					</td>
                    <td>商品合计</td>
                    <td>
						<input type="text" id="${pageId}sumQty" data-options="min:0,precision:0"  readonly="readonly" class="easyui-numberbox" value="$!{dispatchInfo.sumQty}" id="${pageId}sumQty" >
					</td>
                 </tr>
            </tbody>
        </table>
    </div>

</div>

</body>

</html>
