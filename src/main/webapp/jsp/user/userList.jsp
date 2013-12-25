<%@page contentType="text/html;charset=UTF-8"%>
<%@include file="/common/taglibs.jsp"%>
<!doctype html>
<html>

  <head>
    <%@include file="/common/meta.jsp"%>
    <title>用户管理</title>
	<%@include file="/common/js.jsp"%>
  </head>
  <body>
  nihao
  <table id="list"></table>   
   <div id="gridpager"></div>
  </body>
  <script type="text/javascript">
  $(function(){
	  alert(22);
	  $("#list").jqGrid({
		   	url:'',
			datatype: "json",
		   	colNames:['id','显示名称', '邮箱', '真实名称','电话','状态','注册时间'],
		   	colModel:[
		   		{name:'id',index:'id', width:55},
		   		{name:'invdate',index:'invdate', width:90},
		   		{name:'name',index:'name asc, invdate', width:100},
		   		{name:'amount',index:'amount', width:80, align:"right"},
		   		{name:'tax',index:'tax', width:80, align:"right"},		
		   		{name:'total',index:'total', width:80,align:"right"},		
		   		{name:'note',index:'note', width:150, sortable:false}		
		   	],
		   	rowNum:10,
		   	rowList:[10,20,30],
		   	pager: '#gridpager',
		   	sortname: 'id',
		    viewrecords: true,
		    sortorder: "desc",
		    caption:"JSON Example"
		});
  });
  
  </script>
  </html>