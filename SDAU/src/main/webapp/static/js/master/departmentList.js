$('#departmentBtnAdd').click(function() {
	$('#departmentDialog').dialog('open').dialog('refresh', 'userDetail');
});
// 初始化
$('#departmentTable').datagrid(
		{
			url : '/SDAU/department/query',
			
/*			exOnClickLinkCell : function(rowIndex, field, value) {
				// 弹出详细画面
				$('#departmentDialog').dialog('open').dialog('refresh',
						'userDetail?userName=' + value);
			},
			*/
			onBeforeLoad : function(param) {
				var queryData = $('#departmentSearchForm').serializeObject();
				param = $.extend(param, queryData);
			}
		});

// 查询
$('#departmentBtnQuery').click(function() {
	$('#departmentTable').datagrid('load');
});
// 重置
$('#departmentBtnReset').click(function() {
	$('#departmentSearchForm').form('reset');
});