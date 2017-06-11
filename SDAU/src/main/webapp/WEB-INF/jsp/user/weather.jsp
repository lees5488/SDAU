<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8" />
<title>Highcharts 教程 | 折线图</title>
<script src="${pageContext.request.contextPath}/static/jquery-easyui-1.5.1/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/highcharts.js"></script>
</head>
<body>
<div id="container" style="width: 550px; height: 400px; margin: 0 auto"></div>
<script language="JavaScript">
$(document).ready(function() {
   var credits = {  
       enabled: false  
   };
   var title = {
       text: '月平均事件'   
   };
   var subtitle = {
        text: ''
   };
   // x轴
   var xAxis = {
       categories: ['一月', '二月', '三月', '四月', '五月', '六月'
              ,'七月', '八月', '九月', '十月', '十一月', '十二月']
   };
   // y轴
   var yAxis = {
      title: {
         text: '事件数'
      },
      plotLines: [{
         value: 0,
         width: 1,
         color: '#808080'
      }]
   };   

   //折线图提示单位
   var tooltip = {
      valueSuffix: '件'
   }

   var legend = {
      layout: 'vertical',
      align: 'right',
      verticalAlign: 'middle',
      borderWidth: 0
   };

   var series =  [
      {
         name: '测试地区1',
         data: [7.0, 6.9, 9.5, 14.5, 18.2, 21.5, 25.2,
            26.5, 23.3, 18.3, 13.9, 9.6]
      }, 
      {
         name: '测试地区2',
         data: [0, 0.8, 5.7, 11.3, 17.0, 22.0, 24.8,
            24.1, 20.1, 14.1, 8.6, 2.5]
      }, 
      {
         name: '测试地区3',
         data: [0.9, 0.6, 3.5, 8.4, 13.5, 17.0, 18.6,
            17.9, 14.3, 9.0, 3.9, 1.0]
      }, 
      {
         name: '测试地区4',
         data: [3.9, 4.2, 5.7, 8.5, 11.9, 15.2, 17.0, 
            16.6, 14.2, 10.3, 6.6, 4.8]
      }
   ];

   var json = {};

   json.title = title;
   json.subtitle = subtitle;
   json.xAxis = xAxis;
   json.yAxis = yAxis;
   json.tooltip = tooltip;
   json.legend = legend;
   json.series = series;
   json.credits = credits;

   $('#container').highcharts(json);
  
  
});
</script>
</body>
</html>