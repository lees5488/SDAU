// 记录最后一次点击的target
var _lastClickTarget = null;

$(function(){
    $(document).mouseup(function(event) {
    		_lastClickTarget = event.target;
    });
});
