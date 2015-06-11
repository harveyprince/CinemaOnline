<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>CinemaOnline</title>
	<link rel="stylesheet" type="text/css" href="./Public/dist/css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="./Public/font-awesome-4.2.0/css/font-awesome.min.css">
	<link rel="stylesheet" type="text/css" href="./Public/Flat-UI-master/dist/css/flat-ui.min.css">
	<link rel="stylesheet" type="text/css" href="./Public/css/common/user-sidebar.css">
	<link rel="stylesheet" type="text/css" href="./Public/css/server/ServerPage.css">
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
						<li><a href="#"><i class="fa fa-newspaper-o"></i>放映计划审阅</a></li>
						<li><a href="viewStatics"><i class="fa fa-pie-chart"></i>统计</a></li>
						<li class="active"><a href="viewManagerProfitPlan"><i class="fa fa-pie-chart"></i>利润决策</a></li>
					</ul>
				</div>
			</div>
			<div class="user-button"><a href="logout"><i class="fa fa-sign-out"></i>退出</a></div>
		</div>
		<!-- left side bar//////////////////////////////////////////////////////////////////////////////// -->


		<!-- changable place -->

		<div class="bar-match-content">
			<div class="table-box">
				<ul class="nav nav-tabs" data-trigger="tab">
					<li><a href="#tab1">待分配计划</a></li>
					<li><a href="#tab2">已分配计划</a></li>
				</ul>
				<div class="pane-wrapper slide clearfix">
					<div class="tab-page">
						<div class="profit-plan-list" action="getworkingprofitplan"></div>
					</div>

				<!-- /////////////////////////////////////////////////////// -->
				<div class="tab-page">
					
				</div>
			</div>
		</div>

	</div>
	<!-- changable place -->
<div id="right-panel" class="panel">
		<div class="close-panel-bt">X</div>
	</div>

</body>
<script src="./Public/jquery/jquery.min.js"></script>
<script src="./Public/jquery/jquery.easing.min.js"></script>
<script src="./Public/jquery/jquery.panelslider.js"></script>
<script src="./Public/dist/js/bootstrap.min.js"></script>
<script src="./Public/sco/js/sco.panes.js"></script>
<script src="./Public/sco/js/sco.tab.js"></script>
<script src="./Public/sco/js/sco.message.js"></script>
<script src="./Public/Flat-UI-master/dist/js/flat-ui.js"></script>
<script type="text/javascript">

</script>
<script src="./Public/js/common/form.js"></script>
<script src="./Public/js/server/server.js"></script>
<script src="./Public/js/manager/profitplan.js"></script>
</html>