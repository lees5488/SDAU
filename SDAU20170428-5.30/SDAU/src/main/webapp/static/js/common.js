$(document).ready(function(){
	// 对应ie没有console.log的情况
	if (!window.debug) {
		window.debug = function(message) {
			try {
				if (!window.console) {
					window.console = {};
					window.console.log = function() {
						return;
					};
				}
				window.console.log(message + ' ');
			} catch (e) {
			}
		};
		console = window.console;
	}
	
	// 阻断 BackSpace 防止不小心造成页面回退
	$(document).keydown(function(e) {
	    var nodeName = e.target.nodeName.toLowerCase();

	    if (e.which === 8) {
	        if (((nodeName === 'input' && (e.target.type === 'text'||e.target.type === 'password')) ||
	        		nodeName === 'textarea') 
	            && !e.target.readOnly && !e.target.disabled) {
	            // do nothing

	        } else {
	            e.preventDefault();
	        }
	    }
	});
	
	// datagrid 按键处理
	/*$('.datagrid-view').live('keyup',function(e){
		var table = $(this).children('table');
		if(!table.datagrid('options').keyEdit){
			return;
		}
		
		var editIndex = table.datagrid('getEditingRowIndex');
		var rowCnt = table.datagrid('getRows').length;
		if(editIndex == undefined || rowCnt < 2){
			// 非处在编辑状态 或 小于2行也无视
			return;
		}
		
		// 当光标在combo的输入框不支持按键切换编辑行
		if($(e.target).hasClass('combo-text')){
			return;
		}
		
		var d = 0;
		if(e.keyCode == 38){
			// up
			d = -1;
		}else if(e.keyCode == 40){
			// down
			d = 1;
		}else{
			return;
		}
		
		if($(e.target).hasClass('numberbox')){
			// numberbox提前触发blur事件
			$(e.target).blur();
		}

		var editField = $(e.target).parents('.datagrid-row>td').attr('field');
		if(table.datagrid('isEndRowEditing')){
			var newEdit = editIndex + d;
			if(newEdit >= rowCnt){
				newEdit = 0;
			}else if(newEdit < 0){
				newEdit = rowCnt - 1;
			}
			if(editField){
				// 定位到当前编辑列
				table.datagrid('exBeginEditRow', {'index':newEdit, 'field':editField});
			}else{
				table.datagrid('exBeginEditRow', newEdit);
			}
		}
	});
	*/
	// enter 转 tab
/*	$('input').live("keypress", enterToTab);
	if ($.fn.numberbox) {
		(function(){
			var oldf = $.fn.numberbox.defaults.filter;
			$.fn.numberbox.defaults.filter = function (e) {
				if(enterToTab(e)){
					return oldf.call(this, e);
				}
			};
			
			$('.numberbox').live('focusin', function(e){
				var value = $(this).val();
				value = value.replace(/,/g,'');
				$(this).val(value);
			});
		})();
	}
	if ($.fn.combo) {
		(function(){
			var oldf = $.fn.combo.defaults.keyHandler.enter;
			$.fn.combo.defaults.keyHandler.enter = function (e) {
				oldf.call(this, e);
				enterToTab.call(e.target, e);
			};
		})();
	}
	if ($.fn.combobox) {
		(function(){
			var oldf = $.fn.combobox.defaults.keyHandler.enter;
			$.fn.combobox.defaults.keyHandler.enter = function (e) {
				var cmb = this;
				if ($(cmb).is('.easyui-combobox') && !$(cmb).is('.freeinput')) {
					oldf.call(cmb, e);
				} else {
					$(this).combobox('hidePanel');
				}
				
				enterToTab.call(e.target, e);
			};
			$.fn.combobox.defaults.keyHandler.up = function(e) {
				var data = $(this).combobox('getData');
				if(data){
					var v = $(this).combobox('getValue');
					var valueField = $(this).combobox('options').valueField;
					var prev = data[data.length - 1];
					$.each(data, function(i, n){
						if(n[valueField] == v){
							if(i > 0){
								prev = data[i - 1];
							}
						}
					});
					$(this).combobox('setValue', prev[valueField]);
				}
			};
			$.fn.combobox.defaults.keyHandler.down = function(e) {
				var data = $(this).combobox('getData');
				if(data){
					var v = $(this).combobox('getValue');
					var valueField = $(this).combobox('options').valueField;
					var next = data[0];
					$.each(data, function(i, n){
						if(n[valueField] == v){
							if(i < data.length - 1){
								next = data[i + 1];
							}
						}
					});
					$(this).combobox('setValue', next[valueField]);
				}
			};
			
			var gridEnter = $.fn.combogrid.defaults.keyHandler.enter;
			$.fn.combogrid.defaults.keyHandler.enter = function (e) {
				if (($(this).is('.easyui-combogrid') || $(this).is('.combogrid-f')) && !$(this).is('.freeinput')) {
					gridEnter.call(this, e);
				} else {
					$(this).combogrid('hidePanel');
				}
				
				var options=$(this).combogrid('options');
				// 如果触发过combogrid自身的onChange事件，将执行onValChange事件
				if(options.onValChange && options.isChanged){
					options.onValChange.call(this);
					options.isChanged = undefined;
				}

				enterToTab.call(e.target, e);
			};
			
			// 失去焦点的时候自动执行原来回车的操作
			$('.combo-text').live('blur', function(e){
				var cmb = $(this).parent().prev().get(0);
				var options = undefined;
				if ($(cmb).is('.easyui-combobox') && !$(cmb).is('.freeinput')) {
					oldf.call(cmb, e);
					options = $(cmb).combobox('options');
				}
				if (($(cmb).is('.easyui-combogrid') || $(cmb).is('.combogrid-f')) && !$(cmb).is('.freeinput')) {
					gridEnter.call(cmb, e);
					options = $(cmb).combogrid('options');
				}

				// 如果触发过combogrid自身的onChange事件，将执行onValChange事件
				if(options && options.onValChange && options.isChanged){
					options.onValChange.call(cmb);
					options.isChanged = undefined;
				}
			});
		})();
	}*/

	if ($.fn.datebox) {
		(function(){
			//var oldf = $.fn.datebox.defaults.keyHandler.enter;
			$.fn.datebox.defaults.keyHandler.enter = function (e) {
				//oldf.call(this, e);
				enterToTab.call(e.target, e);
			};
		})();
	}
	
	if ($.fn.datetimebox) {
		(function(){
			//var oldf = $.fn.datebox.defaults.keyHandler.enter;
			$.fn.datetimebox.defaults.keyHandler.enter = function (e) {
				//oldf.call(this, e);
				enterToTab.call(e.target, e);
			};
		})();
	}
});

function enterToTab(e) {
	//log('enterToTab ' + e.keyCode);
    if (e.keyCode == 13 && e.target.tagName.toLowerCase() != 'textarea') {
    	$(this).emulateTab();
    	var $f = $(':focus');
    	while($f.is('[readonly]') && !$f.hasClass('combo-text')){
    		$f.emulateTab();
    		$f = $(':focus');
    	}
    	$f.select();
		e.preventDefault();
    	return false;
    } else {
    	return true;
    }
}

//function focusNextInput(input, cnt){
//    /* FOCUS ELEMENT */
//    var inputs = $(input).parents("form").eq(0).find(":input");
//    var idx = inputs.index(input);
//    for(;idx <= inputs.length - 1; idx++){
//    	var next;
//        if (idx == inputs.length - 1) {
//            idx = 0;
//            next = $(inputs[idx]);
//            //break;
//        }else{
//            next = $(inputs[idx + 1]);
//        }
//        
//        if (next.is(':visible') && next.is(':enabled')) {
//        	next.focus();
//        	next.select();
//        	cnt--;
//            if (cnt <=0) {
//            	break;
//            }
//        }
//    }
//}

/**
* 使用实例
* formatDate("yyyy-MM-dd",time);
*/
function formatDate(dataFormate, time) {
	if(null==time || undefined ==time || time==''){
		return "";
	}
	if(null==dataFormate || undefined ==dataFormate || dataFormate==''){
	dataFormate = "yyyy-MM-dd HH:mm:ss";
	}
	var date = new Date();
	time = time+"";
	if(time.length!=13){
		if(time.charAt(10) == 'T'){
			date.setTime(Date.fromISO(time));
		}else{
			time = time.substring(0,time.length-1);
			var a=time.split(/[^0-9]/);
			var d=new Date(a[0],a[1]-1,a[2],a[3],a[4],a[5]);
			date.setTime(d.getTime());
		}
	}else {
		date.setTime(time);
	}
	return date.pattern(dataFormate);
}

Date.prototype.pattern = function(fmt) {
  var o = {
      "M+" : this.getMonth() + 1, //月份     
      "d+" : this.getDate(), //日     
      "h+" : this.getHours() % 12 == 0 ? 12 : this.getHours() % 12, //小时     
      "H+" : this.getHours(), //小时     
      "m+" : this.getMinutes(), //分     
      "s+" : this.getSeconds(), //秒     
      "q+" : Math.floor((this.getMonth() + 3) / 3), //季度     
      "S" : this.getMilliseconds()
  //毫秒     
  };
  var week = {
      "0" : "日",
      "1" : "一",
      "2" : "二",
      "3" : "三",
      "4" : "四",
      "5" : "五",
      "6" : "六"
  };
  if (/(y+)/.test(fmt)) {
      fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "")
              .substr(4 - RegExp.$1.length));
  }
  if (/(E+)/.test(fmt)) {
      fmt = fmt.replace(RegExp.$1,
              ((RegExp.$1.length > 1) ? (RegExp.$1.length > 2 ? "星期" : "周")
                      : "")
                      + week[this.getDay() + ""]);
  }
  if (/(e+)/.test(fmt)) {
      fmt = fmt.replace(RegExp.$1,
              ((RegExp.$1.length > 1) ? (RegExp.$1.length > 2 ? "星期" : "周")
                      : "")
                      + this.getDay());
  }
  for ( var k in o) {
      if (new RegExp("(" + k + ")").test(fmt)) {
          fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k])
                  : (("00" + o[k]).substr(("" + o[k]).length)));
      }
  }
  return fmt;
};

//将from 表单序列化为 json 对象
$.fn.serializeObject = function(){
var o = {};
var a = this.serializeArray();
$.each(a, function() {
   if (o[this.name]) {
       if (!o[this.name].push) {
           o[this.name] = [o[this.name]];
       }
       o[this.name].push(this.value || '');
   } else {
       o[this.name] = this.value || '';
   }
});
return o;
};

//全局的ajax访问，处理ajax清求时sesion超时  
$.ajaxSetup({
    complete:function(XMLHttpRequest,textStatus){   
        var sessionstatus = XMLHttpRequest.getResponseHeader("sessionstatus"); //通过XMLHttpRequest取得响应头，sessionstatus
        if(sessionstatus == "timeout"){
        	//如果超时就处理 ，指定要跳转的页面  
    		window.location.replace("login.htm");   
        }   
    }   
}); 

/**
 * 封装的 json 请求
 * 
 * @param uri
 * 		请求地址
 * @param param
 * 		参数
 * @param okCallback (data, comment)
 * 		服务器成功返回，并且JsonResult为ok时的回调方法
 * 		data 为JsonResult的data
 * 		comment 为JsonResult的data
 * @param failCallback (data, comment)
 * 		服务器成功返回，但JsonResult【不】为ok时的回调方法，若有JsonResult有消息则在点完确定后执行回调
 * 		data 为JsonResult的data
 * 		comment 为JsonResult的data
 * @param lockScreen 锁屏
 */
$.requestJson = function(uri,param, okCallback, failCallback, lockScreen){
	if(lockScreen == undefined || lockScreen){
		lockBody();
	}
	param = param ? param :{};
	$.ajax({
		url:uri,
		dataType:"json",
		type:"POST",
		data:JSON.stringify(param),
		contentType:"application/json; charset=utf-8",
		success:function(data, textStatus, jqXHR){
			commonReqSuccessHandler(data, okCallback, failCallback, lockScreen);
		},
		error:function(jqXHR, textStatus, errorThrown){
			if(lockScreen == undefined || lockScreen){
				unlockBody();
			}
			log(jqXHR.status + '-' + textStatus + '-' + errorThrown);
			$.messager.alert('错误','未知的错误发生了', 'error');
		//	$.showMessage('E000000200', null, function(){
//			$.showMessage('E000000200' + '-' + jqXHR.status + '-' + textStatus + '-' + errorThrown, null, function(){
	//		});
		}
	});
};

/**
 * 共通请求成功回掉
 */
function commonReqSuccessHandler(data, okCallback, failCallback, lockScreen){
	if(lockScreen == undefined || lockScreen){
		unlockBody();
	}
	if(data == null){
		log('return data is null');
		return;
	}
	if(data.ok){
		if($.isFunction(okCallback)){
			okCallback(data.data, data.comment);
		}
	}else{
		if(data.message){
			showMsg(data.message, data.msgType, function(){
				if($.isFunction(failCallback)){
					failCallback(data.data, data.comment);
				}
			});
		}else{
			if($.isFunction(failCallback)){
				failCallback(data.data, data.comment);
			}
		}
	}
}

/**
 * form ajax 提交，提交前进行进行验证
 * 
 * options ：{}	
 * 		   	属性：
 * 			url							地址
 * 			validate:（bool）			是否验证，默认验证
 * 			onParam:function(data)		可以在from参数的基础上再做处理
 * 			onSuccess:function(data, comment)
 * 										操作成功: JsonResult.isOk() == true
 * 			onFail:function(data, comment)
 * 										操作失败: JsonResult.isOk() == false
 * 			onError:function(jqXHR, textStatus, errorThrown)
 * 										ajax异常
 */
$.fn.ajaxFormSubmit = function(options){
	var isValidate = options.validate == undefined ? true : options.validate;
	if(isValidate && !$(this).form('validate')){
		return;
	}
	
	var data = $(this).serializeObject();
	if(options.onParam){
		options.onParam(data);
	}
	
	$.requestJson(options.url, data, function(data, comment){
		if(options.onSuccess){
			options.onSuccess(data, comment);
		}
	}, function(data, comment){
		if(options.onFail){
			options.onFail(data, comment);
		}
		
	}, function(jqXHR, textStatus, errorThrown){
		if(options.onError){
			options.onError(jqXHR, textStatus, errorThrown);
		}
	});
};


/**
 * form submit 提交，下载文件时提交
 * 
 * options ：{}	
 * 		   	属性：
 * 			url							地址
 * 			queryData		            可以在from参数的基础上再做处理
 * 			okCallback:function()
 * 										操作成功: JsonResult.isOk() == true
 * 			failCallback:function()
 * 										操作失败: JsonResult.isOk() == false
 */
function downloadSubmit(options){
	$('#downloadForm').form('submit', {
	    url:options.url,
	    onSubmit: function(param){
	    	if(options.queryData!=null){
	    		param = $.extend(param, options.queryData);
	    	}
	    },
	    success:function(data){
	    	// 反转义
	    	data = HTMLDecode(data);
	        var dataObj = JSON.parse(data);
			commonReqSuccessHandler(dataObj, options.okCallback, options.failCallback, true);
	    }
	});
}

/**
 * form submit 提交
 * $form 要提交的form
 * options ：{}	
 * 		   	属性：
 * 			url							地址
 * 			queryData		            可以在from参数的基础上再做处理
 * 			okCallback:function()
 * 										操作成功: JsonResult.isOk() == true
 * 			failCallback:function()
 * 										操作失败: JsonResult.isOk() == false
function formSubmit($form,options){
	$form.form('submit', {
	    url:options.url,
	    onSubmit: function(param){
	    	if(options.queryData!=null){
	    		param = $.extend(param, options.queryData);
	    	}
	    },
	    success:function(data){
			commonReqSuccessHandler(data, options.okCallback, options.failCallback, true);
	    }
	});
}
 */

//判断标签是否存在
function isTagExist(tagId){
	var obj = $("#"+tagId);
	if(obj){
		return true;
	}
	return false;
}

//unix时间专为当前时间
hx_getnowtime=function(unixtime){
	var iunixtime=parseInt(unixtime);
	var date=new Date(iunixtime);
	return (date).toLocaleDateString() + " " + (date).toLocaleTimeString();
};

// html 解码  将后台读取的html内容还原为html内容，放在富文本中显示
UTIL_HtmlDiscode=function(theString){
 return theString.replaceAll("&gt;", ">")
.replaceAll("&lt;", "<")
.replaceAll("&nbsp;", " ")
.replaceAll(" &nbsp;", " ")
.replaceAll("&quot;", "\"")
.replaceAll("&#39;", "\'");
};

Date.prototype.format = function(format) 
{ 
var o = 
{ 
"M+" : this.getMonth()+1, //month 
"d+" : this.getDate(), //day 
"h+" : this.getHours(), //hour 
"m+" : this.getMinutes(), //minute 
"s+" : this.getSeconds(), //second 
"q+" : Math.floor((this.getMonth()+3)/3), //quarter 
"S" : this.getMilliseconds() //millisecond 
} ;

if(/(y+)/.test(format)) 
{ 
format = format.replace(RegExp.$1, (this.getFullYear()+"").substr(4 - RegExp.$1.length)); 
} 

for(var k in o) 
{ 
if(new RegExp("("+ k +")").test(format)) 
{ 
format = format.replace(RegExp.$1, RegExp.$1.length==1 ? o[k] : ("00"+ o[k]).substr((""+ o[k]).length)); 
} 
} 
return format; 
} ;


Date.fromISO= (function(){
    var testIso = '2011-11-24T09:00:27+0200';
    // Chrome
    var diso= Date.parse(testIso);
    if(diso===1322118027000) return function(s){
        return new Date(Date.parse(s));
    };
    // JS 1.8 gecko
    var noOffset = function(s) {
      var day= $.map(s.slice(0,-5).split(/\D/), function(itm){
        return parseInt(itm, 10) || 0;
      });
      day[1]-= 1;
      day= new Date(Date.UTC.apply(Date, day));  
      var offsetString = s.slice(-5);
      var offset = parseInt(offsetString,10)/100; 
      if (offsetString.slice(0,1)=="+") offset*=-1;
      day.setHours(day.getHours()+offset);
      return day.getTime();
    };
    if (noOffset(testIso)===1322118027000) {
       return noOffset;
    }  
    return function(s){ // kennebec@SO + QTax@SO
        var day, tz, 
//        rx = /^(\d{4}\-\d\d\-\d\d([tT][\d:\.]*)?)([zZ]|([+\-])(\d{4}))?$/,
        rx = /^(\d{4}\-\d\d\-\d\d([tT][\d:\.]*)?)([zZ]|([+\-])(\d\d):?(\d\d))?$/,
            
        p= rx.exec(s) || [];
        if(p[1]){
            day= p[1].split(/\D/).map(function(itm){
                return parseInt(itm, 10) || 0;
            });
            day[1]-= 1;
            day= new Date(Date.UTC.apply(Date, day));
            if(!day.getDate()) return NaN;
            if(p[5]){
                tz= parseInt(p[5], 10)/100*60;
                if(p[6]) tz += parseInt(p[6], 10);
                if(p[4]== "+") tz*= -1;
                if(tz) day.setUTCMinutes(day.getUTCMinutes()+ tz);
            }
            return day;
        }
        return NaN;
    };
})();

/**
 * 验证字符串是否为空
 * 
 * hasText(undefind) = false
 * hasText(null) = false
 * hasText("") = false
 * hasText(" ") = true
 * hasText("Hello") = true
 * 
 *  @param str
 */
function hasText(str){
	if (str == null 
			|| str == undefined 
			|| $.trim(str).length == 0){
		return false;
	}
	return true;
}

//JS 四舍五入 自定义小数位数，空缺补0,添加千位符
function round(num,n){
	var   dd=1;  
	var   tempnum;  
	for(var i=0;i<n;i++){  
	dd*=10;  
	}  
	tempnum=num*dd;  
	tempnum=Math.round(tempnum);
	tempnum=formatnumber(tempnum/dd,n);
	tempnum=milliFormat(tempnum);
	return tempnum;  
}

//HTML转义
function HTMLEncode(html)
{
	var temp = document.createElement ("div");
	(temp.textContent != null) ? (temp.textContent = html) : (temp.innerText = html);
	var output = temp.innerHTML;
	temp = null;
	return output;
}

//HTML反转义
function HTMLDecode(text)
{
	var temp = document.createElement("div");
	temp.innerHTML = text;
	var output = temp.innerText || temp.textContent;
	temp = null;
	return output;
}

//空缺补0
function formatnumber(value, num){
    var a, b, c, i;
    a = value.toString();
    b = a.indexOf(".");
    c = a.length;
    if (num == 0) {
        if (b != -1) {
            a = a.substring(0, b);
        }
    } else {
        if (b == -1) {
            a = a + ".";
            for (i = 1; i <= num; i++) {
                a = a + "0";
            }
        } else {
            a = a.substring(0, b + num + 1);
            for (i = c; i <= b + num; i++) {
                a = a + "0";
            }
        }
    }
    return a;
}

//添加千位符
function milliFormat(s){
	s = s+"";
	var s1=s,s2="";
	var pIdx=s.indexOf(".");
	if(pIdx>=0){
		s1=s.substring(0,pIdx);
		s2=s.substring(pIdx+1,s.length);
	}
	var p=/(\d+)(\d{3})/;
	while(p.test(s1)){
		s1=s1.replace(p,"$1,$2");
	}
	if(pIdx>=0){
		s1 = s1 + "." + s2;
	}
	return s1;
}


/*
 * 处理过长的字符串，截取并添加省略号
 * 注：半角长度为1，全角长度为2
 * 
 * pStr:字符串
 * pLen:截取长度
 * 
 * return: 截取后的字符串
 */
function autoAddEllipsis(pStr, pLen) {

	var _ret = cutString(pStr, pLen);
	var _cutFlag = _ret.cutflag;
	var _cutStringn = _ret.cutstring;

	if ("1" == _cutFlag) {
		return _cutStringn + "...";
	} else {
		return _cutStringn;
	}
}

/*
 * 取得指定长度的字符串
 * 注：半角长度为1，全角长度为2
 * 
 * pStr:字符串
 * pLen:截取长度
 * 
 * return: 截取后的字符串
 */
function cutString(pStr, pLen) {

	// 原字符串长度
	var _strLen = pStr.length;

	var _cutString = '';

	// 默认情况下，返回的字符串是原字符串的一部分
	var _cutFlag = "1";

	var _lenCount = 0;

	var _ret = false;

	if (_strLen <= pLen/2) {
		_cutString = pStr;
		_ret = true;
	}

	if (!_ret) {
		for (var i = 0; i < _strLen ; i++ ) {
			if (isFull(pStr.charAt(i))) {
				_lenCount += 2;
			} else {
				_lenCount += 1;
			}

			if (_lenCount > pLen) {
				_cutString = pStr.substring(0, i);
				_ret = true;
				break;
			} else if (_lenCount == pLen) {
				_cutString = pStr.substring(0, i + 1);
				_ret = true;
				break;
			}
		}
	}
	
	if (!_ret) {
		_cutString = pStr;
		_ret = true;
	}

	if (_cutString.length == _strLen) {
		_cutFlag = "0";
	}

	return {"cutstring":_cutString, "cutflag":_cutFlag};
}

/*
 * 判断是否为全角
 * 
 * pChar:长度为1的字符串
 * return: true:全角
 * 			false:半角
 */
function isFull (pChar) {
	if ((pChar.charCodeAt(0) > 128)) {
		return true;
	} else {
		return false;
	}
}

/**
 * 是否含有中文
 * @param str 
 * @returns {Boolean}
 */
function isContainChinese(str){   
	if(/.*[\u4e00-\u9fa5]+.*$/.test(str)){   
		return true;   
	}else{
		return false;   
	}
}   

/**
 * 冻结屏幕
 */
function lockBody(){
	$("body").mask("请稍等...");
}

/**
 * 解锁屏幕
 */
function unlockBody(){
	$("body").unmask();
}

/**
 * 返回屏幕是否lock
 */
function isBodyLocked(){
	return $("body").isMasked();
}

// log
function log(s){
	if(console){
		console.log(s);
	}
}

/**
 * 导入，控件与easyui linkbutton相结合
 * 
 * @param options JSON类 参数设置
 * 可配参数：
 * 	url
 * 		string 上传路径		
 * 	sizeLimit 
 * 		number 文件最大size。默认：5 * 1024 * 1024
 * 	validTypes 
 * 		array 验证文件类型。默认：['xlsx'] 
 *  beforePop
 *  	function 弹出文件选择框之前执行，返回false的话将阻止pop
 *  okCallback
 *  	function(data, comment) 
 *  failCallback
 * 		function(data, comment) 
 */ 
$.fn.uploader = function(options){
	var a = $(this);
	var text = a.text();
	a.removeClass('easyui-linkbutton')	// 删除easyui-linkbutton，避免再次初始化控件
		.linkbutton()					// 初始化控件
		.unbind('click.linkbutton')		// 接触《a》的点击事件，否则上传控件点击不到
		.addClass('uploader');			// 加css class
	var textSpan = a.find('.l-btn-text');
	// 对调text和icon的位置，是整个按钮点下去都可以弹出选择框
	textSpan.before(a.find('.l-btn-icon'));
	
	// 上传初始化
	var op = $.extend({
		sizeLimit : 5 * 1024 * 1024,
		validTypes:['xlsx']
	}, options);
	
	textSpan.fineUploader({
		request : {
			inputName : 'file',
			endpoint : op.url,
			forceMultipart : true
		},
        autoUpload: true,
		multiple : false,
		validation : {
			sizeLimit : op.sizeLimit,
			allowedExtensions : op.validTypes
		},
		messages : {
			sizeError:msgFormat('E000000069', op.sizeLimit / (1024 * 1024)),
			typeError:msgFormat('E000000070', op.validTypes.join('|'))
		},
        showMessage: function(message){
        	$.showMessage(message);
        },
		debug : false
    }).on('complete', function(event, id, fileName, responseJSON) {
		// 解锁屏
		log('complete');
		unlockBody();
		if(responseJSON.success){
			if($.isFunction(op.okCallback)){
				op.okCallback(responseJSON.data, responseJSON.comment);
			}
		}
	}).on('submit', function(event, id, name){
		log('submit');
		lockBody();
		if(op.onSubmit){
			$(this).fineUploader('setParams', op.onSubmit.call(this, id, name), id);
		}
	}).on('progress', function(event,id, name, uploadedBytes, totalBytes){
		log('progress - ' + id + ' ' + name + ' ' + uploadedBytes +' ' + totalBytes);
	}).on('error', function(event,id, name, errorReason){
		unlockBody();
		if(!errorReason){
			errorReason = msgFormat('E000000200');
		}
		showMsg(errorReason, 'E', function(){
			if($.isFunction(op.failCallback)){
				op.failCallback(data.data, data.comment);
			}
		});
	});
	// 文本
	a.find('.qq-upload-button').children(':first').addClass('qq-uploader-button-text').html(text);
	a.find('input[type="file"]').click(function(e){
		if($.isFunction(op.beforePop)){
			if(op.beforePop() === false){
				e.preventDefault();
			}
		}
	});
};

/**
 * 消息弹窗封装
 * @param id 	 消息id
 * @param params 数组，消息参数，或者字符串（只有一个参数的时候适用）
 * @param fn	 回调
 */
$.showMessage = function(id, params,fn){
	var msgText = msgFormat(id, params);
	var type = id.charAt(0);
	showMsg(msgText, type, fn);
};

function showMsg(msgText, type, fn){
	var msgText = "<div class=\"message-text-body\">"+msgText+"</div>";
	if(type == 'I'){
		$.messager.alert('',msgText, 'info', fn);
	}else if(type == 'W'){
		$.messager.alert('',msgText, 'warning', fn);
	}else if(type == 'E'){
		$.messager.alert('',msgText, 'error', fn);
	}else if(type == 'Q'){
		$.messager.confirm('',msgText, fn);
	}
}

/**
 * 消息格式化方法，如果消息id不存在，则返回 [消息id] +（费定义）
 * 
 * @param msgId 		消息id
 * @param msgParams		消息参数
 * @returns {String}	格式化后的消息内容
 */
function msgFormat(msgId, msgParams){
	var msgContent = msg[msgId];
	if(msgContent == undefined) {
		msgContent = msgId + "（未定义）";
	}else{
		if(msgParams){
			var p = msgParams;
			if(!$.isArray(p)){
				p = [p];
			}
			
			for (var i = 0; i < p.length; i++) {
		        var reg = "\\{" + i + "\\}";
		        msgContent = msgContent.replace(new RegExp(reg, "g"), p[i]);
		    }
		}
	}
	
	return msgContent;
}

// 供应商comboloader
var comboSupplierLoader = function(param,success,error){
	return comboLoader('supplier', param, success,error);
};

// 仓库comboloader
var comboWarehouseLoader = function(param,success,error){
	return comboLoader('warehouse', param, success,error);
};

// 区域comboloader
var comboZoneLoader = function(param,success,error){
	return comboLoader('zone', param, success,error);
};

//商品信息
var comboProductLoader=function(param,success,error){
	return comboLoader('product', param, success,error);
};

// 员工信息
var comboEmployeeLoader=function(param,success,error){
	return comboLoader('employee', param, success,error);
};
// 派车员工信息
var comboDispatchEmployeeLoader=function(param,success,error){
	return comboLoader('dispatchemployee', param, success,error);
};

// 用户页面专用员工信息autoComplete
var comboEmployeeForUserLoader=function(param,success,error){
	return comboLoader('employeeForUser', param, success,error);
};

//商品类别comboloader
var comboProductCategoryLoader=function(param,success,error){
	return comboLoader('productCategory', param, success,error);
};

//商品最小类别comboloader
var comboProductLowestCategoryLoader=function(param,success,error){
	return comboLoader('productLowestCategory', param, success,error);
};

//货主comboloader
var comboConsignorLoader=function(param,success,error){
	return comboLoader('consignor', param, success,error);
};

//部门comboloader
var comboDepartmentLoader=function(param,success,error){
	return comboLoader('department', param, success,error);
};

//承运商comboloader
var comboCarrierLoader=function(param,success,error){
	return comboLoader('carrier', param, success,error);
};

//储位comboloader
var comboLocationLoader=function(param,success,error){
	return comboLoader('location', param, success,error);
};

//盘点策略comboloader
var comboStocktakeStrategyLoader=function(param,success,error){
	return comboLoader('stocktakeStrategy', param, success,error);
};

//门店comboloader
var comboShopLoader=function(param,success,error){
	return comboLoader('shop', param, success,error);
};


/**
 * combo共通loader
 * 
 * @param type
 * @param param
 * @param success
 * @param error
 * @returns {Boolean}
 */
function comboLoader(type, param,success,error){
    var q = param.q || '';
    if (q.length < $CONFIG.auto_complete_min_char){return false;}
    $.ajax({
        url: 'combo',
        type:'POST',
        dataType: 'json',
		contentType:"application/json; charset=utf-8",
        data: JSON.stringify({
            'startsWith': q,
            'type':type,
            'condition':param.condition
        }),
        success: function(data){
            success(data);
        },
        error: function(){
            error.apply(this, arguments);
        }
    });
    return true;
}

/**
 * 记住当前页面所打开的dialog，以便在画面关闭的时候自动销毁.
 * ! 注意，必须在生成 dialog 之前调用
 * @param id
 * @param pageNo 非必须，有权限控制的dialog画面则必须，规则为跟对应vm文件同名
 */
function rememberDialog(id, pageNo) {
	var panel = $(id).parents('div.panel-body').eq(0);
	if (panel) {
		var op = panel.panel('options');
		if (op.dialogs) {
			op.dialogs.push(id);
		} else {
			op.dialogs = [id];
		}
	}
	
	var options = $(id).attr('data-options');
	var onload = 'onLoad:bindRememberDialogOnload';
	if(options){
		options += ',' + onload;
	}else{
		options = onload;
	}
	if(pageNo){
		options += ",pageNo:'" + pageNo + "'";
	}
	$(id).attr('data-options', options);
}

/**
 * 绑定rememberDialog onload事件
 */
function bindRememberDialogOnload(){
	//log('detail dialog load ~~');
	var pageNo = $(this).dialog('options').pageNo;
	if(pageNo!=undefined){
		var RolePageFunctions = getRolePageFunctions(pageNo);//角色权限按钮
		if(RolePageFunctions==undefined){
			RolePageFunctions="";
		}
		var BtnQuit=pageNo+"BtnQuit";
		var pageFunctions = $(this).find(".dialog-bottom-buttons a");//页面按钮
		$.each(pageFunctions,function(i,e){
			var id=$(e).attr("id");
			if(RolePageFunctions.indexOf(id)==-1){//按钮无权限，移除按钮
				if(id!=BtnQuit){
					$(e).remove();
				}
			}
		});
	}
	focusFirstInput($(this));
	// 调用自定义的onLoad事件
	$(this).dialog('options').exOnLoad.call(this);
}

/**
 * 派车选择员工
 * @param callBack
 */
function employeeSelect(selectBack,params){
	var div="<div id='employeeSelectDialog' class='detail-dialog' title='配送员选择'>";
	$("body").append(div);
	var url="employeeSelect?";
	for(var key in params){
		url=url+key+"="+params[key]+"&";
	}
	//去除末尾的?或者&
	url=url.substring(0,url.length-1);
	$("#employeeSelectDialog").dialog({
		width:624,
		height:400,
		href:url,
		onClose:function(){
			$("#employeeSelectDialog").dialog('destroy');
		},
		mycallBack:selectBack
	}).dialog('open');
}

/**
 * 商品选择共通，selectBack(data)返回函数，返回一个data商品信息的object
 * @param callBack
 */
function productInfoSelect(selectBack,params){
	var div="<div id='productSelectDialog' class='detail-dialog' title='商品选择'>";
	$("body").append(div);
	var url="productSelect?";
	for(var key in params){
		url=url+key+"="+params[key]+"&";
	}
	//去除末尾的?或者&
	url=url.substring(0,url.length-1);
	$("#productSelectDialog").dialog({
		width:879,
		height:500,
		href:url,
		onClose:function(){
			$("#productSelectDialog").dialog('destroy');
		},
		mycallBack:selectBack
	}).dialog('open');
}


/**
 * 商品类别选择共通，selectBack(data)返回函数，返回一个data商品类别信息的object
 * @param callBack
 * @param params 参数 map型
 */
function productCategorySelect(selectBack,params){
	var div="<div id='productCategorySelectDialog' class='detail-dialog' title='商品类别选择'>";
	$("body").append(div);
	var url="productCategorySelect?";
	for(var key in params){
		url=url+key+"="+params[key]+"&";
	}
	//去除末尾的?或者&
	url=url.substring(0,url.length-1);
	$("#productCategorySelectDialog").dialog({
		width:729,
		height:500,
		href:url,
		onClose:function(){
			$("#productCategorySelectDialog").dialog('destroy');
		},
		mycallBack:selectBack
	}).dialog('open');
}


/**
 * 供应商选择共通，selectBack(data)返回函数，返回一个data供应商信息的object
 * @param callBack
 */
function supplierInfoSelect(selectBack,params){
	var div="<div id='supplierSelectDialog' class='detail-dialog' title='供应商选择'>";
	$("body").append(div);
	var url="supplierSelect?";
	for(var key in params){
		url=url+key+"="+params[key]+"&";
	}
	//去除末尾的?或者&
	url=url.substring(0,url.length-1);
	$("#supplierSelectDialog").dialog({
		width:900,
		height:500,
		href:url,
		onClose:function(){
			$("#supplierSelectDialog").dialog('destroy');
		},
		mycallBack:selectBack
	}).dialog('open');
}

/**
 * 储位选择共通，selectBack(data)返回函数，返回一个data储位信息的object
 * @param callBack
 */
function locationInfoSelect(selectBack,params){
	var div="<div id='locationSelectDialog' class='detail-dialog' title='储位选择'>";
	$("body").append(div);
	var url="locationSelect?";
	for(var key in params){
		url=url+key+"="+params[key]+"&";
	}
	//去除末尾的?或者&
	url=url.substring(0,url.length-1);
	$("#locationSelectDialog").dialog({
		width:1050,
		height:520,
		href:url,
		onClose:function(){
			$("#locationSelectDialog").dialog('destroy');
		},
		mycallBack:selectBack
	}).dialog('open');
}
/**
 * 库存选择共通，selectBack(data)返回函数
 * @param callBack
 */
function stockInfoSelect(selectBack,params){
	var div="<div id='stockSelectDialog' class='detail-dialog' title='库存选择'>";
	$("body").append(div);
	var url="stockSelect?";
	for(var key in params){
		url=url+key+"="+params[key]+"&";
	}
	//去除末尾的?或者&
	url=url.substring(0,url.length-1);
	$("#stockSelectDialog").dialog({
		width:929,
		height:550,
		href:url,
		onClose:function(){
			$("#stockSelectDialog").dialog('destroy');
		},
		mycallBack:selectBack
	}).dialog('open');
}

/**
 * 区域选择共通，selectBack(data)返回函数，返回一个data储位信息的object
 * @param callBack
 */
function zoneInfoSelect(selectBack,params){
	var div="<div id='zoneSelectDialog' class='detail-dialog' title='区域选择'>";
	$("body").append(div);
	var url="zoneSelect?";
	for(var key in params){
		url=url+key+"="+params[key]+"&";
	}
	//去除末尾的?或者&
	url=url.substring(0,url.length-1);
	$("#zoneSelectDialog").dialog({
		width:879,
		height:500,
		href:url,
		onClose:function(){
			$("#zoneSelectDialog").dialog('destroy');
		},
		mycallBack:selectBack
	}).dialog('open');
}

/**
 * 货主选择共通，selectBack(data)返回函数，返回一个data储位信息的object
 * @param callBack
 */
function consignorInfoSelect(selectBack,params){
	var div="<div id='consignorSelectDialog' class='detail-dialog' title='货主选择'>";
	$("body").append(div);
	var url="consignorSelect?";
	for(var key in params){
		url=url+key+"="+params[key]+"&";
	}
	//去除末尾的?或者&
	url=url.substring(0,url.length-1);
	$("#consignorSelectDialog").dialog({
		width:829,
		height:500,
		href:url,
		onClose:function(){
			$("#consignorSelectDialog").dialog('destroy');
		},
		mycallBack:selectBack
	}).dialog('open');
}

/**
 * 承运商选择共通，selectBack(data)返回函数，返回一个data储位信息的object
 * @param callBack
 */
function carrierInfoSelect(selectBack,params){
	var div="<div id='carrierInfoSelectDialog' class='detail-dialog' title='承运商选择'>";
	$("body").append(div);
	var url="carrierSelect?";
	for(var key in params){
		url=url+key+"="+params[key]+"&";
	}
	//去除末尾的?或者&
	url=url.substring(0,url.length-1);
	$("#carrierInfoSelectDialog").dialog({
		width:829,
		height:500,
		href:url,
		onClose:function(){
			$("#carrierInfoSelectDialog").dialog('destroy');
		},
		mycallBack:selectBack
	}).dialog('open');
}
/**
 * 门店选择共通，selectBack(rowData) 返回函数，返回一个门店信息的对象
 * @param selectBack
 * @param params
 */
function shopSelect(selectBack, params){
	var div="<div id='shopSelectDialog' class='detail-dialog' title='门店选择'>";
	$("body").append(div);
	var url="shopSelect?";
	for(var key in params){
		url=url+key+"="+params[key]+"&";
	}
	//去除末尾的？或者&
	url=url.substring(0, url.length-1);
	$("#shopSelectDialog").dialog({
		width:800,
		height:500,
		href:url,
		onClose:function(){
			$("#shopSelectDialog").dialog("destroy");
		},
		mycallBack:selectBack
	}).dialog("open");
}



/**
 * 控件disable时，去掉绑定的单击事件
 * 
 */
function linkButtonListUnbind(){
	for (var i = 0; i < arguments.length; i++) {
		var isDisabled=arguments[i].linkbutton("options").disabled;
		if(isDisabled){
			arguments[i].unbind('click');
		}
 	}
}


/**
 * 浮点数加法运算
 * @param arg1
 * @param arg2
 * @returns {Number}
 */
function accAdd(arg1,arg2){
	var r1,r2,m;
	try{r1=arg1.toString().split(".")[1].length;}catch(e){r1=0;}
	try{r2=arg2.toString().split(".")[1].length;}catch(e){r2=0;}
	m=Math.pow(10,Math.max(r1,r2));
	return (Math.round(arg1*m)+Math.round(arg2*m))/m;
} 

/**
 * 浮点数加法运算
 */
function accAddX(arg){
	var res = arg;
	for (var i = 1; i < arguments.length; i++) {
		res = accAdd(res,arguments[i]);
 	}
	return res;                 
}

/**
 * 浮点数减法运算
 * @param arg1
 * @param arg2
 * @returns {Number}
 */
function accSubtr(arg1,arg2){
	var r1,r2,m,n;
	try{r1=arg1.toString().split(".")[1].length;}catch(e){r1=0;};
	try{r2=arg2.toString().split(".")[1].length;}catch(e){r2=0;};
	m=Math.pow(10,Math.max(r1,r2));
	//动态控制精度长度
	n=(r1>=r2)?r1:r2;
	return ((arg1*m-arg2*m)/m).toFixed(n);
}

/**
 * 浮点数减法运算
 */
function accSubtrX(arg){
	var res = arg;
	for (var i = 1; i < arguments.length; i++) {
		res = accSubtr(res,arguments[i]);
 	}
	return res;                 
}

/**
 * 浮点数乘法运算
 */
function accMul(arg1,arg2){
	var m=0,s1=arg1.toString(),s2=arg2.toString();
	try{m+=s1.split(".")[1].length;}catch(e){}
	try{m+=s2.split(".")[1].length;}catch(e){}
	return Number(s1.replace(".",""))*Number(s2.replace(".",""))/Math.pow(10,m);
} 

/**
 * 浮点数乘法运算
 */
function accMulX(arg){
	var res = arg;
	for (var i = 1; i < arguments.length; i++) {
		res = accMul(res,arguments[i]);
 	}
	return res;                 
}

/**
 * 浮点数除法运算
 * 
 * @param arg1
 * @param arg2
 * @returns {Number}
 */
function accDiv(arg1,arg2){
	var t1=0,t2=0,r1,r2;
	try{t1=arg1.toString().split(".")[1].length;}catch(e){}
	try{t2=arg2.toString().split(".")[1].length;}catch(e){}
	with(Math){
		r1=Number(arg1.toString().replace(".",""));
		r2=Number(arg2.toString().replace(".",""));
		return (r1/r2)*pow(10,t2-t1);
	}
} 

//将已作废的行背景色变灰
function invalidStyle(index,row){
	if (row.isuse==0){
		return {'class':'invalid-style'};
	}
}

//将已作废的行背景色变灰
function linkCellStyler(value,row,index){
	return {'class':'table-link-cell'};
}

//将isuse 替换成有效/已作废
function isuseFormat(value,row,index){
    if (value==10){
    	return '有效';
    }
    if (value==0) {
    	return '已作废';
    }
}

/**
 * 数字前补0
 * 
 * @param num 数字
 * @param length 长度
 * @returns 返回值
 */
function addZeroBeforeNum(num,length){
	num=new Number(num);//转成数值型
	if(isNaN(num)){//如果不是数值型清空
		return "";
	}else{//将数字转字符型
		str=num.toString();
	}
	return new Array(Number(length) - str.length + 1).join('0') + str;//补0
}

function commonLinkCellClick(event){
	event = event || window.event;
	var t = event.target || event.srcElement;
	var $a = $(t);
	var grid = $a.parents('.datagrid-view').eq(0).children('table').eq(0);
	grid.datagrid('options').exOnClickLinkCell.call(grid[0], $a.attr('index'), $a.attr('field'), $a.text());
	if (window.event) {
		event.cancelBubble=true;     // ie下阻止冒泡
	} else {
		event.stopPropagation();     // 其它浏览器下阻止冒泡
	}
}

//表格数值格化方法
function linkCellFormatter(value,row,index){
	if(hasText(value)){
		return '<a class=\'table-link-cell\' field=\'' + this.field + '\' index=\''+index+'\' onclick=\'commonLinkCellClick(event);\'>'+value+'</a>';
	}
	return '';
}

// 表格数值格化方法
function numberFormatter(value,row,index){
	if (value){
		return milliFormat(value);
	} else {
		return value;
	}
}

/**
 * 获取最大值
 * getMax(5,2) -> 999.99
 * getMax(6,2) -> 9999.99
 * getMax(6,3) -> 999.99(默认显示为精度2)
 * getMax(6,3,3) -> 999.999
 * getMax(6,3,0) -> 999
 * 
 * @param len 表字段长度
 * @param d   表字段精度
 * @param c	  精度，非必须，不设则视为默认精度
 * @returns {Number}
 */
function getMax(len, d, c){
	c = (c != undefined && c != null) ? c : $CONFIG.amount_decimal;
	return Math.pow(10, len - d) - Math.pow(10, -c);
}


/**
 * 获取页面权限按钮
 * 
 * @param pageNo 页面id
 * @returns
 */
function getRolePageFunctions(pageNo){
	return eval("$ROLE_RIGHT."+pageNo);
}

/**
 * 带时间的日期格式的Formatter
 * 
 * @param date
 */
function dateTimeFormatter(date){
	dataFormate = "yyyy-MM-dd HH:mm:ss";
	return dateFormatter(date,dataFormate);
}

/**
 * 不带时间的日期格式ForMatter
 * 
 * @param date
 * @param dataFormate
 * @returns
 */
function dateFormatter(date,dataFormate){
	if(date==undefined){
		return;
	}
	if(null==dataFormate || undefined ==dataFormate || dataFormate==''){
		dataFormate = "yyyy-MM-dd";
		}
	 if(date.length!=0&&date.length!=13){
		 if(date.charAt(10) == 'T'){
			 return formatDate(dataFormate,date);
		 }
	 }
	 return date;
}


////////////////////Extension ///////////////////////

//datagrid扩展方法
$.extend($.fn.datagrid.methods, {
	// 编辑单元格
    editCell: function(jq,param){
        return jq.each(function(){
            var editcol = $(this).datagrid('getColumnOption', param.field);
        	if(!editcol.editor){
                $(this).datagrid('options').editIndex = undefined;
                $(this).datagrid('options').editField = undefined;
        		return;
        	}
            var fields = $(this).datagrid('getColumnFields',true).concat($(this).datagrid('getColumnFields'));
            for(var i=0; i<fields.length; i++){
                var col = $(this).datagrid('getColumnOption', fields[i]);
                col.editor1 = col.editor;
                if (fields[i] != param.field){
                    col.editor = null;
                }
            }
            $(this).datagrid('selectRow', param.index).datagrid('beginEdit', param.index);
            
            for(var i=0; i<fields.length; i++){
                var col = $(this).datagrid('getColumnOption', fields[i]);
                col.editor = col.editor1;
            }
            
            $(this).datagrid('options').editIndex = param.index;
            $(this).datagrid('options').editField = param.field;
            
            var ed = $(this).datagrid('getEditor', param);
            if(ed != null) {
            	if($(ed.target).hasClass('datagrid-editable-input')){
            		$(ed.target).focus();
            	}
            }
        });
    },
    // 判断当前是否可以正确的结束【单元格】的编辑状态，可以将结束编辑
    isEndCellEditing:function(jq){
    	var editIndex = jq.datagrid('options').editIndex;
    	var editField = jq.datagrid('options').editField;
        if (editIndex == undefined || editField == undefined){
        	return true;
        }
        if (jq.datagrid('exValidateRow',editIndex)){
    		var oldData = jq.datagrid('getRows')[editIndex][editField];

    		var ed = jq.datagrid('getEditor', {index:editIndex,field:editField});
    		if(ed){
    			if($(ed.target).hasClass('combogrid-f')){
    				// 将datagrid数据存到column option，避免丢失
		            var co = jq.datagrid('getColumnOption', editField);
		            var cmbData = $(ed.target).combogrid('grid').datagrid('getSelected');
		    		co.editor.options.data = [cmbData];
    			}
    		}
    		
        	jq.datagrid('endEdit', editIndex);
        	if(jq.datagrid('options').onEndCellEdit){
        		jq.datagrid('options').onEndCellEdit.call(jq, editIndex, editField, oldData);
        	}
        	jq.datagrid('unselectRow', editIndex);
        	jq.datagrid('options').editIndex = undefined;
        	jq.datagrid('options').editField = undefined;
            return true;
        } else {
            return false;
        }
    },
    // 判断当前是否可以正确的结束【行】的编辑状态，可以将结束编辑
    isEndRowEditing:function(jq){
    	var editIndex = jq.datagrid('getEditingRowIndex');
    	if (editIndex == undefined){
//        	jq.datagrid('unselectAll');
    		return true;
		}
    	
        if (jq.datagrid('exValidateRow', editIndex)){
        	var editors = jq.datagrid('getEditors', editIndex);
        	var rowData = jq.datagrid('getRows')[editIndex];
        	for(var i = 0; i < editors.length; i++){
        		var ed = editors[i];
        		if(ed.type == "combobox"){
    				// 将combobox的text值放到row data里面
        			var textField = $(ed.target).combobox('options').textField;
        			rowData[textField] = $(ed.target).combobox('getText');
        		}else if(ed.type == "combogrid"){
    				// 将datagrid数据存到column option，避免丢失
		            var co = jq.datagrid('getColumnOption', ed.field);
		            var cmbData = $(ed.target).combogrid('grid').datagrid('getSelected');
		    		co.editor.options.data = [cmbData];
    			}
        	}
        	
        	jq.datagrid('exEndEdit', editIndex).datagrid('setEditingRowIndex', undefined);
            return true;
        } else {
    		jq.datagrid('unselectAll').datagrid('selectRow', editIndex);
            return false;
        }
    },
    // 获取编辑中的单元格参数
    getEditingCell:function(jq){
    	var editIndex = jq.datagrid('options').editIndex;
    	var editField = jq.datagrid('options').editField;
    	return {index:editIndex, field:editField};
    },
    // 获取当前编辑行index
    getEditingRowIndex:function(jq){
    	return jq.datagrid('options').editIndex;
    },
    // 设置当前编辑行index
    setEditingRowIndex:function(jq, index){
    	jq.datagrid('options').editIndex = index;
    	return jq;
    },
    // 自定义的开始编辑行方法，集成选中、设定EditingRowIndex flag、开始编辑。
    // 参数可以是row的index，自动将第一个编辑框获得焦点；
    // 也可以是options（{index,field}），自动将传入的cell坐标编辑框获得焦点，如果该cell坐标编辑框不支持输入则将第一个编辑框获得焦点；
    exBeginEditRow:function(jq, p){
    	var index = $.isNumeric(p) ? p : p.index;
    	var option = jq.datagrid('options');
    	if(option.exBeforeEdit!=undefined){
    		option.exBeforeEdit.call(jq[0],index);
    	}
    	jq.datagrid('unselectAll')
    		.datagrid('selectRow', index)
		   	 .datagrid('setEditingRowIndex', index)
		   	 .datagrid('beginEdit', index);
		
 		function focusEditor(ed){
			var focusInput = null;
	    		if(ed.type.indexOf('combo') == 0 || ed.type == 'datebox'){
	    			focusInput = $(ed.target).combo('textbox');
	    		}else if(ed.type == 'searchbox'){
	    			focusInput = $(ed.target).searchbox('textbox');
	    		}else if(ed.type != 'label'){
	    			focusInput = $(ed.target);
	    		}
	    		if(focusInput){
					focusInput.focus();
					if(jq.datagrid('options').keyEdit){
						focusInput.select();
					}
					return true;
	    		}
	    		return false;
 		}
 		
 		// 选中指定cell
	   	if(typeof p == 'object'){
	   		var ed = jq.datagrid('getEditor',p);
	   		if(focusEditor(ed)){
	   			return jq;
	   		}
	   	}
 		
 		if(_lastClickTarget){
 			var field = null;
 			if($(_lastClickTarget).hasClass('datagrid-cell')){
 				field = $(_lastClickTarget).parent().attr('field');
 			}else if($(_lastClickTarget).is('td')){
 				field = $(_lastClickTarget).attr('field');
 			}
 			if(field != null){
 				var ed = jq.datagrid('getEditor',{'index':p,'field':field});
 				if(ed!=null&&focusEditor(ed)){
 					return jq;
 				}
 			}
 			// 第一个输入框获得焦点
 			var editors = jq.datagrid('getEditors', index);
 			for(var i = 0,len = editors.length; i < len; i++){
 				var ed = editors[i];
 				if(focusEditor(ed)){
 					return jq;
 				}
 			}
 		}
        return jq;
    },
    exEndEdit:function(jq, index){
    	jq.datagrid('endEdit', index);
    	var tr=jq.datagrid("options").finder.getTr(jq[0],index);
    	var ck=tr.find("div.datagrid-cell-check input[type=checkbox]");
    	if(ck.is(':checked')){
    		tr.addClass("datagrid-row-checked");
    	}
    	return jq;
    },
    // 追加一行可编辑的空行
    appendEditRow:function(jq, data){
    	// 判断是否正在编辑的cell能不能正常结束
        if (jq.datagrid('isEndRowEditing')){
        	var rdata = $.extend({}, data);
        	jq.datagrid('appendRow',rdata);
	    	index = jq.datagrid('getRows').length-1;
	    	jq.datagrid('exBeginEditRow', index);
        }
        return jq;
    },
    // 删除checkbox勾中的行，在rowData中设置一个属性deleteFlag=true，表示该数据是被删除的。默认不弹确认框，需弹窗参数设置为true，弹窗需要回调设参数设置为回调方法
    deleteCheckedRows:function(jq, p){
    	var checkedRows = jq.datagrid('getChecked');
    	if(checkedRows.length == 0){
    		// 没选中任何数据
    		$.showMessage('W000000001', ['记录']);
    		return jq;
    	}
    	
    	function del(){
    		var editIndex = jq.datagrid('getEditingRowIndex');
    		var editRow = jq.datagrid('getRows')[editIndex];
	    	$.each(checkedRows, function(){
		    	var delIndex = jq.datagrid('getRowIndex', this);
	    		if(editIndex == delIndex){
	    			// 编辑中的row取消掉。
	    			jq.datagrid('cancelEdit', delIndex).datagrid('setEditingRowIndex', undefined);
	    			editRow = null;
	    		}
	    		jq.datagrid('deleteRow', delIndex);
	    		this['deleteFlag'] = true;
	    	});
	    	if(editRow){
    			jq.datagrid('setEditingRowIndex', jq.datagrid('getRowIndex', editRow));
	    	}
    	};
    	
    	if(p){
    		// 确认
    		$.showMessage('Q000000001', null, function(r){
    			if(!r)return;
    			del();
    			if($.isFunction(p)){
    				p();
    			}
    		});
    	}else{
    		del();
    	}
		return jq;
    },
    // 清空grid
    clearGrid:function(jq){
    	var rows = jq.datagrid('getRows');
    	for(var i=rows.length-1; i>= 0; i--){
    		rows[i]['deleteFlag'] = true;
    		jq.datagrid('deleteRow',i);
    	}
    	return jq;
    },
    // exUpdateRow 在原来的updateRow的基础上，将该行添加到updateRows，使其能用getChanges方法获取得到
    exUpdateRow:function(jq, param){
    	jq.datagrid('updateRow', param);
    	var row = jq.datagrid('getRows')[param.index];
    	var updatedRows=$.data(jq[0],"datagrid").updatedRows;
    	var insertedRows=$.data(jq[0],"datagrid").insertedRows;

    	var exist = false;
		for(var i=0,len=insertedRows.length;i<len;i++){
			if(insertedRows[i] == row){
				exist = true;
				break;
			}
		}
		for(var i=0,len=updatedRows.length;i<len;i++){
			if(updatedRows[i] == row){
				exist = true;
				break;
			}
		}
    	if(!exist){
    		updatedRows.push(row);
    	}
		
    	return jq;
    },
    // 扩展的编辑行验证方法，从easyui source中copy的，追加了第一个不合格的输入元素获得焦点的代码
    exValidateRow:function(jq, index){
    	var tr=jq.datagrid("options").finder.getTr(jq[0],index);
    	if(!tr.hasClass("datagrid-row-editing")){
    	return true;
    	}
    	var vbox=tr.find(".validatebox-text");
    	vbox.validatebox("validate");
    	vbox.trigger("mouseleave");
    	var invalid=tr.find(".validatebox-invalid");
    	if(invalid.length > 0){
    		invalid[0].focus();
    		return false;
    	}
    	return true;
    },
    // 高亮单行
    exHighlightSingleRow:function(jq, index){
    	$.each(jq, function(){
        	var oldHlRow = $(this).datagrid('options').exHighlightSingleRowIdx;
        	if(oldHlRow != index){
        		$(this).datagrid("options").finder.getTr(this,oldHlRow).removeClass('ex-datagrid-highlight');
        		$(this).datagrid("options").finder.getTr(this,index).addClass('ex-datagrid-highlight');
        		
        		$(this).datagrid('options').exHighlightSingleRowIdx = index;
        	}
    	});
    	return jq;
    },
    // 获取高亮单index
    exGetHighlightSingleRow:function(jq){
    	return jq.datagrid('options').exHighlightSingleRowIdx;
    },
    // 编辑单元格：损溢画面和盘点画面用的
    exEditCellForProfitLoss: function(jq,param){
        return jq.each(function(){
            var editcol = $(this).datagrid('getColumnOption', param.field);
        	if(!editcol.editor){
                $(this).datagrid('options').editIndex = undefined;
                $(this).datagrid('options').editField = undefined;
        		return;
        	}
            var fields = $(this).datagrid('getColumnFields',true).concat($(this).datagrid('getColumnFields'));
            for(var i=0; i<fields.length; i++){
                var col = $(this).datagrid('getColumnOption', fields[i]);
                col.editor1 = col.editor;
               
                if (fields[i] != 'mode' 
                	&& fields[i] != 'profitLossQty'
                	&& fields[i] != 'stockQty'
                	&& fields[i] != 'stocktakeQty'
                	&& fields[i] != 'differenceQty'
                	&& fields[i] != 'onHandQty'
                	&& fields[i] != 'remark'){
                    col.editor = null;
                }
            }
            $(this).datagrid('selectRow', param.index).datagrid('beginEdit', param.index);
            
            for(var i=0; i<fields.length; i++){
                var col = $(this).datagrid('getColumnOption', fields[i]);
                col.editor = col.editor1;
            }
            
            $(this).datagrid('options').editIndex = param.index;
            $(this).datagrid('options').editField = param.field;
            
            var ed = $(this).datagrid('getEditor', param);
            if(ed != null) {
            	if($(ed.target).hasClass('datagrid-editable-input')){
            		$(ed.target).focus();
            	}
            }
        });
    },
	// 设置表头chekbox勾选状态
	setHeadCheckboxChecked:function(jq, param){
    	$.each(jq, function(){
    		var dc = $.data(this,"datagrid").dc;
    		dc.header1.find("input[type=checkbox]").attr('checked',param);
    		dc.header2.find("input[type=checkbox]").attr('checked',param);
    	});
    	return jq;
	}
});


function getContextPath() {
    var pathName = document.location.pathname;
    var index = pathName.substr(1).indexOf("/");
    var result = pathName.substr(0,index+1);
    return result;
}

//自定义验证手机号码
/*$.extend($.fn.validatebox.defaults.rules, {
phoneRex: {
  validator: function(value){
  var rex=/^1[3-8]+\d{9}$/;
  //var rex=/^(([0\+]\d{2,3}-)?(0\d{2,3})-)(\d{7,8})(-(\d{3,}))?$/;
  //区号：前面一个0，后面跟2-3位数字 ： 0\d{2,3}
  //电话号码：7-8位数字： \d{7,8
  //分机号：一般都是3位数字： \d{3,}
   //这样连接起来就是验证电话的正则表达式了：/^((0\d{2,3})-)(\d{7,8})(-(\d{3,}))?$/		 
  var rex2=/^((0\d{2,3})-)(\d{7,8})(-(\d{3,}))?$/;
  if(rex.test(value)||rex2.test(value))
  {
    // alert('t'+value);
    return true;
  }else
  {
   //alert('false '+value);
     return false;
  }
    
  },
  message: '请输入正确电话或手机格式'
}
});*/