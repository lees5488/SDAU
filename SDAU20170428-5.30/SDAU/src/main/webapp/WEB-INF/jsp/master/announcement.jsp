<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>公告</title>
</head>
<body>

<h4 style="color: #A4D3EE;">
				编辑公告时如需换行，请使用&lt;br&gt;换行
</h4>
<form id="announcementForm">
<!-- <form id="announcementForm" onSubmit="return check();">
 -->

<textarea rows="30px" cols="100%" name = "anno">${anno.anno }</textarea>
<input id="updateDate" name = "updateDateStr" data-options="formatter:myformatter,parser:myparser" class="detail-value-input td-date" readonly="readonly" value="${anno.updateDateStr}"  type="hidden"  />

						 
</form >
 <a id="announcementBtnSave" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-save'"  >保存</a>
<!--  <a id="announcementBtnSave" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-save'" style="float: left;; background-color: " >保存</a>
 -->
<script type="text/javascript">

//保存
$('#announcementBtnSave').click(function(){
	debugger;
	//var table = $('#impForecastDetailTable');
	//var form = $('#impForecastDetailForm');
	//if (form.form('validate')	// 表单验证，ajaxFormSubmit本身默认已经提供验证的，但是这里明细的内容需要自行验证，为了保证先验证form在这里调用validate，ajaxFormSubmit不再验证
	//		&& table.datagrid('isEndRowEditing') 	// 编辑正常结束
	//		&& impForecastDetailTableValid()){	
		// 取变更过的行数据
		//var changeData = table.datagrid('getChanges');
		// 取预报单号
		//var forecastNo = $('#impForecastDetailForecastNo').val();

		var submitUrl = '/SDAU/announcement/updateAnnouncement'
			//(forecastNo == '') ? 
			//	'impForecastDetail/insertIncomingForcast' : 'impForecastDetail/updateIncomingForcast';
		
		$('#announcementForm').ajaxFormSubmit({
		    url:submitUrl,
		    validate:false,	// 不再验证
		    onParam:function(data){
		    	var msgp;
		    	msgp = [''];
		    	//if(changeData.length > 0){
		    		// 追加明细的数据
		    	//	data.details = changeData;
		    	//}
		    },
		    onSuccess:function(data){
		    	$.showMessage('保存成功',  [''], function(){
                    var tabPanel = $('#tabs').tabs('getTab', subtitle);
                	 tabPanel.panel('refresh');
		    	});
		    }
		});
	//};
});

function myformatter(date){
	var y = date.getFullYear();
	var m = date.getMonth()+1;
	var d = date.getDate();
	return y+'-'+(m<10?('0'+m):m)+'-'+(d<10?('0'+d):d);
}
function myparser(s){
	if (!s) return new Date();
	var ss = (s.split('-'));
	var y = parseInt(ss[0],10);
	var m = parseInt(ss[1],10);
	var d = parseInt(ss[2],10);
	if (!isNaN(y) && !isNaN(m) && !isNaN(d)){
		return new Date(y,m-1,d);
	} else {
		return new Date();
	}
}
</script>
</body>
</html>