$('#employeeListBtnAdd').click(function() {
	$('#employeeListDialog').dialog('open').dialog('refresh', 'employeeDetail');
});
// 初始化
$('#employeeListTable').datagrid({
			url : '/SDAU/employeeList/query',
			
/*			exOnClickLinkCell : function(rowIndex, field, value) {
				// 弹出详细画面
				$('#employeeListDialog').dialog('open').dialog('refresh',
						'userDetail?userName=' + value);
			},
			*/
			onBeforeLoad : function(param) {
				var queryData = $('#employeeListSearchForm').serializeObject();
				param = $.extend(param, queryData);
			}
		});

// 查询
$('#employeeListBtnQuery').click(function() {
	$('#employeeListTable').datagrid('load');
});
// 重置
$('#employeeListBtnReset').click(function() {
	$('#employeeListSearchForm').form('reset');
});