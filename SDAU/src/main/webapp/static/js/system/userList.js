$('#userListBtnAdd').click(function() {
	$('#userListDialog').dialog('open').dialog('refresh', 'userDetail');
});
// 初始化
$('#userListTable').datagrid(
		{
			url : '/SDAU/system/userListQuery',
			exOnClickLinkCell : function(rowIndex, field, value) {
				// 弹出详细画面
				$('#userListDialog').dialog('open').dialog('refresh',
						'userDetail?userName=' + value);
			},
			onBeforeLoad : function(param) {
				var queryData = $('#userListSearchForm').serializeObject();
				param = $.extend(param, queryData);
			}
		});

// 查询
$('#userListBtnQuery').click(function() {
	$('#userListTable').datagrid('load');
});
// 重置
$('#userListBtnReset').click(function() {
	$('#userListSearchForm').form('reset');
});
// 删除
$('#userListBtnDelete').click(function() {

	// 获取选中的row
	var selections = $('#userListTable').datagrid('getChecked');
	// 未选中任何信息
	if (selections == null || selections.length == 0) {
		$.messager.alert('警告', '没有指定任何数据', 'warning');
		return;
	}
	// 确认删除
	$.messager.confirm('提示', '确认删除?', function(r) {
		if (r) {
			// 定义接受的Array
			var deleteObj = new Array();
			// 循环选中的数据
			for (var i = 0; i < selections.length; i++) {
				// 取出第i行
				var row = selections[i];
				// 加到Array中
				deleteObj.push({
					"id" : row.id,
					"userName" : row.userName
				});
			}
			// 检查通过
			$.requestJson('/SDAU/system/userListDelete', deleteObj, function() {
				// 删除成功
				$.messager.alert('提示', '操作成功！', 'info');
				$('#userListTable').datagrid('reload');
			});
		}
	});
});
// 新增
/*
 * function userListDelete(){ var selections =
 * $('#userListTable').datagrid('getChecked'); // 未选中任何信息 if(selections == null ||
 * selections.length == 0){ $.messager.alert('警告','没有指定任何数据','warning'); return; } }
 */
// 编辑行
function userListTableOnClickRow(rowIndex, rowData) {
	var table = $(this);
	// 编辑
	if (table.datagrid('isEndRowEditing')) {
		table.datagrid('exBeginEditRow', rowIndex);
	}
}

$.extend($.fn.validatebox.defaults.rules,{
					phoneNum : { // 验证手机号
						validator : function(value, param) {
							return /^1[3-8]+\d{9}$/.test(value);
						},
						message : '请输入正确的手机号码。'
					},

					telNum : { // 既验证手机号，又验证座机号
						validator : function(value, param) {
							return /(^(0[0-9]{2,3}\-)?([2-9][0-9]{6,7})+(\-[0-9]{1,4})?$)|(^((\d3)|(\d{3}\-))?(1[358]\d{9})$)/
									.test(value);
						},
						message : '请输入正确的电话号码。'
					}
});