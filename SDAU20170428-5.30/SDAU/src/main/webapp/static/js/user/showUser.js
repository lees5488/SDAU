/**
 * 
 */
function click2(){
	alert("click!");
}


/*$('#showUserDialog').dialog({'href':'showUserDetail'}).dialog('open');*/

/*$('#dispatchListTable').datagrid({
	url:'dispatchList/query',
	onBeforeLoad:function(param){
		var queryData = $('#dispatchListSearchForm').serializeObject();
		param = $.extend(param,queryData);
	},
	exOnClickLinkCell:function(rowIndex,field,value){
		if(field == 'dispatchNo'){
			var rows = $('#dispatchListTable').datagrid('getRows');
			var dispatchNo = rows[rowIndex]['dispatchNo'];
			$('#dispatchListDialog').dialog({'href':'dispatchInfoDetail?dispatchNo=' + dispatchNo}).dialog('open');
		}
	}
});
*/
/*
$('#showTable').datagrid({
	url:'user/showUser',
	OnBeforeLoad:function(param){
		var queryData = $('#SearchForm').serializeObject();
		param = $.extend(param,queryData);
	}
});*/