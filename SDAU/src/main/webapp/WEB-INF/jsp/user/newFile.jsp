<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
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
	<script type="text/javascript" src="${pageContext.request.contextPath}/static/jquery-easyui-1.5.1/locale/easyui-lang-zh_CN.js"></script>

</head>
<body class="easyui-layout" id="cc">  
    @*头部区域*@  
    <div data-options="region:'north',border:false" style="height: 80px; padding: 10px; background-color: #2d3e50;color:#c7c7c7;">  
        <div style="float:left;height:50px;padding:0px;margin:0px;">  
            <div style="height:24px;width:120px;border-bottom:1px solid #c4c4c4;font-size:18px;">  
                GM.Authority  
            </div>  
            <a href="#" class="easyui-splitbutton" data-options="menu:'#mm1',iconCls:'icon-edit'" style="color:#c7c7c7;margin-top:2px;">修改主题</a>  
        </div>  
        <div style="height:50px;width:800px;">  
  
        </div>  
    </div>  
  
    @*隐藏的导航栏*@  
    <div data-options="region:'west',split:true,collapsed:true,  
                hideExpandTool: true,  
                expandMode: null,  
                hideCollapsedContent: false,  
                collapsedSize: 120,  
                collapsedContent: function(){  
                    return $('#titlebar');  
                }  
                " title="导航栏" style="width: 119px;">  
        <div class="easyui-accordion">  
            <div title="站点管理" data-options="iconCls:'icon-ok'" style="overflow:auto;padding:10px;">  
                <ul style="padding: 0px; margin: 0px;">  
                    <li style=" margin:4px 12px;"><a href="#" style="list-style:none;text-decoration:none;" onclick="javascript: AddTab('站点配置', '/SiteInfo/Index')">站点配置</a></li>  
                    <li style=" margin:4px 12px;"><a href="#" style="list-style:none;text-decoration:none;" onclick="javascript: AddTab('功能配置', '/UrlInfo/Index')">功能配置</a></li>  
                </ul>  
            </div>  
            <div title="部门管理" data-options="iconCls:'icon-help'" style="padding:10px;">  
                <ul style="padding: 0px; margin: 0px;">  
                    <li style=" margin:4px 12px;"><a href="#" style="list-style:none;text-decoration:none;" onclick="javascript: AddTab('部门配置', '/Department/Index')">部门配置</a></li>  
                </ul>  
            </div>  
            <div title="职位管理" data-options="iconCls:'icon-search'" style="padding:10px;">  
                  
            </div>  
            <div title="用户管理" data-options="iconCls:'icon-search'" style="padding:10px;">  
  
            </div>  
            <div title="权限管理" data-options="iconCls:'icon-search'" style="padding:10px;">  
  
            </div>  
        </div>  
    </div>  
  
    @*右边区域*@  
    @*<div data-options="region:'east',split:true,collapsed:true,title:'其他'" style="width:100px;">east region</div>*@  
  
    @*底部区域*@  
    <div data-options="region:'south',border:false" style="height: 20px; background:#712369;">底部</div>  
  
    @*中间操作区域*@  
    <div data-options="region:'center',title:'展示区'">  
        <div class="easyui-tabs" style="width:100%;height:100%" id="tabs">  
            <div title="主页" style="padding:10px">  
                <p>欢迎来到权限后台管理系统！</p>  
                <p>管理员：xxx</p>  
                @*<a href="javascript:void(0)" class="easyui-linkbutton" onclick="topCenter('ok')">TopCenter</a>*@  
            </div>  
        </div>  
    </div>  
  
    @*导航栏*@  
    <div id="titlebar" style="padding:2px;">  
        <a href="javascript:void(0)" class="easyui-linkbutton" style="width:100%" data-options="iconCls:'layout-button-right'" onclick="$('#cc').layout('expand','west')">菜单栏</a>  
        <a href="javascript:void(0)" class="easyui-linkbutton" style="width:100%" data-options="iconCls:'icon-large-picture',size:'large',iconAlign:'top'">Picture</a>  
        <a href="javascript:void(0)" class="easyui-linkbutton" style="width:100%" data-options="iconCls:'icon-large-shapes',size:'large',iconAlign:'top'">Shapes</a>  
        <a href="javascript:void(0)" class="easyui-linkbutton" style="width:100%" data-options="iconCls:'icon-large-smartart',size:'large',iconAlign:'top'">SmartArt</a>  
        <a href="javascript:void(0)" class="easyui-linkbutton" style="width:100%" data-options="iconCls:'icon-large-chart',size:'large',iconAlign:'top'">Chart</a>  
    </div>  
  
    @*主题*@  
    <div id="mm1" style="width:150px;">  
        <div onclick="changeTheme('metro');">metro</div>  
        <div onclick="changeTheme('metro-blue');">metro-blue</div>  
        <div onclick="changeTheme('metro-gray');">metro-gray</div>  
        <div onclick="changeTheme('metro-green');">metro-green</div>  
        <div onclick="changeTheme('metro-orange');">metro-orange</div>  
        <div onclick="changeTheme('metro-red');">metro-red</div>  
        <div class="menu-sep"></div>  
        <div onclick="changeTheme('black');">black</div>  
        <div onclick="changeTheme('bootstrap');">bootstrap</div>  
        <div onclick="changeTheme('default');">default</div>  
        <div onclick="changeTheme('gray');">gray</div>  
        <div onclick="changeTheme('material');">material</div>  
        <div class="menu-sep"></div>  
        <div onclick="changeTheme('ui-cupertino');">ui-cupertino</div>  
        <div onclick="changeTheme('ui-dark-hive');">ui-dark-hive</div>  
        <div onclick="changeTheme('ui-pepper-grinder');">ui-pepper-grinder</div>  
        <div onclick="changeTheme('ui-sunny');">ui-sunny</div>  
    </div>  
  
    @*脚本*@  
    <script type="text/javascript">  
        $(function () {  
            //读取easyuiThemeName Cookie  
            var ThreadCookie = getCookie("themeName");  
            if (ThreadCookie != "") { changeTheme(ThreadCookie) };//LoadThread  
        });  
  
        //提示框  
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
  
        //加载开始  
        function ajaxLoading() {  
            $("<div class=\"datagrid-mask\"></div>").css({ display: "block", width: "100%", height: $(window).height() }).appendTo("body");  
            $("<div class=\"datagrid-mask-msg\"></div>").html("正在处理，请稍候。。。").appendTo("body").css({ display: "block", left: ($(document.body).outerWidth(true) - 190) / 2, top: ($(window).height() - 45) / 2 });  
        };  
  
        //加载结束  
        function ajaxLoadEnd() {  
            $(".datagrid-mask").remove();  
            $(".datagrid-mask-msg").remove();  
        };  
  
        //添加选项卡  
        function AddTab(subtitle, url) {  
            if (!$('#tabs').tabs('exists', subtitle)) {  
                $('#tabs').tabs('add', {  
                    title: subtitle,  
                    href: url,  
                    closable: true,  
                    width: $('#mainPanle').width() - 10,  
                    height: $('#mainPanle').height() - 10  
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
  
        //切换主题  
        changeTheme = function (themeName) {  
            var $easyuiTheme = $('#easyuiTheme');  
            var url = $easyuiTheme.attr('href');  
            var href = url.substring(0, url.indexOf('themes')) + 'themes/' + themeName + '/easyui.css';  
            $easyuiTheme.attr('href', href);  
            var $iframe = $('iframe');  
            if ($iframe.length > 0) {  
                for (var i = 0; i < $iframe.length; i++) {  
                    var ifr = $iframe[i];  
                    $(ifr).contents().find('#easyuiTheme').attr('href', href);  
                }  
            }  
            setCookie("themeName", themeName, 7)  
            //友情提示  
            topCenter("当前主题：" + themeName, 1000);  
        };  
  
        //设置cookie  
        function setCookie(cname, cvalue, exdays) {  
            var d = new Date();  
            d.setTime(d.getTime() + (exdays * 24 * 60 * 60 * 1000));  
            var expires = "expires=" + d.toUTCString();  
            document.cookie = cname + "=" + cvalue + "; " + expires;  
        }  
  
        //获取cookie  
        function getCookie(cname) {  
            var name = cname + "=";  
            var ca = document.cookie.split(';');  
            for (var i = 0; i < ca.length; i++) {  
                var c = ca[i];  
                while (c.charAt(0) == ' ') c = c.substring(1);  
                if (c.indexOf(name) != -1) return c.substring(name.length, c.length);  
            }  
            return "";  
        }  
    </script>  
</body>  
</html>