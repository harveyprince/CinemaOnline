<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta charset="UTF-8">
	<title>server page</title>
	<link rel="stylesheet" type="text/css" href="./Public/dist/css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="./Public/font-awesome-4.2.0/css/font-awesome.min.css">
	<link rel="stylesheet" type="text/css" href="./Public/Flat-UI-master/dist/css/flat-ui.min.css">
	<link rel="stylesheet" type="text/css" href="./Public/css/common/user-sidebar.css">
	<link rel="stylesheet" type="text/css" href="./Public/css/server/ServerPage.css">
	<link rel="stylesheet" type="text/css" href="./Public/css/server/ServerAdd.css">
	<link rel="stylesheet" type="text/css" href="./Public/sco/css/scojs.css">
	<link rel="stylesheet" type="text/css" href="./Public/sco/css/sco.message.css">
	<link rel="stylesheet" type="text/css" href="./Public/css/mainmanar/profit.css">
</head>
<body>
	<div class="contain clearfix">
	<!-- left side bar//////////////////////////////////////////////////////////////////////////////// -->
	<div class="left-sidebar">
		<div class="row">
			<div class="">
				<ul class="nav nav-list">
					<li class="active"><a href="#"><i class="fa fa-pencil-square-o"></i>盈利详情</a></li>
					<li><a href="mainmanarfilm"><i class="fa fa-film"></i>影片管理</a></li>
					<li><a href="mainmanar_limit"><i class="fa fa-film"></i>影院限制</a></li>
				</ul>
			</div>
		</div>
		<div class="user-button"><a href="logout"><i class="fa fa-sign-out"></i>退出</a></div>
	</div>
	<!-- left side bar//////////////////////////////////////////////////////////////////////////////// -->
	<div class="bar-match-content">
		<div class="info-show-panel">
			<ul class="nav nav-tabs" data-trigger="tab">
				<li><a href="#tab1">使用限制</a></li>
			</ul>
			<div class="pane-wrapper slide clearfix">
				<div class="tab-page">
					<s:iterator id="hall" value="halllist" status="st">
					<div>
						<span><s:property value="#hall.name"/></span>
						<input class="form-control times-input number-input" type="number" placeholder="times" style="width:220px;" hallNo='<s:property value="#hall.hallNo"/>'/>
					</div>
					</s:iterator>
					<div>
						<button class="btn btn-primary hall-limit">
							提交限制
						</button>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- Right panel -->

</body>
<script src="./Public/jquery/jquery.min.js"></script>
<script src="./Public/jquery/jquery.easing.min.js"></script>
<script src="./Public/jquery/jquery.panelslider.js"></script>
<script src="./Public/highcharts/js/highcharts.js"></script>
<script src="./Public/highcharts/js/modules/exporting.js"></script>
<script src="./Public/dist/js/bootstrap.min.js"></script>
<script src="./Public/sco/js/sco.panes.js"></script>
<script src="./Public/sco/js/sco.tab.js"></script>
<script src="./Public/sco/js/sco.message.js"></script>
<script src="./Public/Flat-UI-master/dist/js/flat-ui.js"></script>
<script type="text/javascript">
$(".hall-limit").click(function(){
	var data = new FormData();
	$(".times-input").each(function(idx){
		data.append("halllimitlist["+idx+"].hallNo",$(this).attr("hallNo"));
		data.append("halllimitlist["+idx+"].times",$(this).val());
	});
	var action = "submit_cinema_limit";
	$.ajax({
		data: data,
		type: "POST",
		url: action,
		cache: false,
		contentType: false,
		processData: false,
		success: function(data) {
			if(data=="success"){
				$.scojs_message(data, $.scojs_message.TYPE_OK);
			}else{
				$.scojs_message(data, $.scojs_message.TYPE_ERROR);
			}
		},
		error:function(){
			$.scojs_message('error occured!', $.scojs_message.TYPE_ERROR);
		}
	});
});
</script>
<script src="./Public/js/common/form.js"></script>
<script src="./Public/js/server/server.js"></script>
<script src="./Public/js/mainmanager/mainmanagerprofit.js"></script>
<script src="./Public/js/mainmanager/statistic.js"></script>
<script src="./Public/js/mainmanager/statisticworker.js"></script>
</html>