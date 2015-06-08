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
	<link rel="stylesheet" type="text/css" href="./Public/css/manar/statistic.css">
	<link rel="stylesheet" type="text/css" href="./Public/sco/css/scojs.css">
	<link rel="stylesheet" type="text/css" href="./Public/sco/css/sco.message.css">
</head>
<body>
	<div class="contain clearfix">

	<!-- left side bar//////////////////////////////////////////////////////////////////////////////// -->
	<div class="left-sidebar">
		<div class="row">
			<div class="">
				<ul class="nav nav-list">
					<li><a href="manager"><i class="fa fa-newspaper-o"></i>放映计划审阅</a></li>
					<li class="active"><a href="#"><i class="fa fa-pie-chart"></i>统计</a></li>
				</ul>
			</div>
		</div>
		<div class="user-button"><a href="logout"><i class="fa fa-sign-out"></i>退出</a></div>
	</div>
		<!-- left side bar//////////////////////////////////////////////////////////////////////////////// -->


		<!-- changable place -->

	<div class="bar-match-content">
		<div class="tab-pag-bar">
			<div class="time-choose-bar">
				<div class="row-line">
					<div class="row-label">时间:</div>
					<div class="form-group has-success row-content">
						<input class="form-control time-input" type="month" placeholder="duration" name="time"/>
					</div>
				</div>
				<div class="row-line" style="text-align:center;">
					<button class="btn btn-primary time-confirm">
						确认
					</button>
				</div>
			</div>
		</div>
		<div class="info-show-panel">
			<ul class="nav nav-tabs" data-trigger="tab">
				<li><a href="#tab1">VIP统计</a></li>
				<li><a href="#tab2">影院统计</a></li>
			</ul>
			<div class="pane-wrapper slide clearfix">
				<div class="tab-page">
					<div id="container" style="min-width: 310px; height: 100px; max-width: 600px; margin: 0 auto">
						<div class="statistic-label">总消费:<span class="consume-show"></span></div>
						<div class="statistic-label" style="display: none;">总活动参与度:<span class="participate-show"></span></div>
					</div>
					<div id="card-container" style="height: 400px; width: 601px; margin: 0 auto"></div>
					<div id="age-container" style="height: 400px; width: 601px; margin: 0 auto"></div>
					<div id="sex-container" style="height: 400px; width: 601px; margin: 0 auto"></div>
					<div id="location-container" style="height: 400px; width: 601px; margin: 0 auto"></div>
				</div>
				<div class="tab-page">
					<div id="container" style="min-width: 310px; height: 70px; max-width: 600px; margin: 0 auto">
						<div class="statistic-label">月总人数:<span class="person-month-show"></span></div>
					</div>
					<div id="person-day-container" style="height: 400px; width: 601px; margin: 0 auto"></div>
					<div id="film-attendence-container" style="height: 400px; width: 601px; margin: 0 auto"></div>
					<div id="hall-attendence-container" style="height: 400px; width: 601px; margin: 0 auto"></div>
					<div id="payway-container" style="height: 400px; width: 601px; margin: 0 auto"></div>
				</div>
			</div>
		</div>
	</div>


	<!-- changable place -->

</body>
<script src="./Public/jquery/jquery.min.js"></script>
<script src="./Public/highcharts/js/highcharts.js"></script>
<script src="./Public/highcharts/js/modules/exporting.js"></script>
<script src="./Public/dist/js/bootstrap.min.js"></script>
<script src="./Public/sco/js/sco.panes.js"></script>
<script src="./Public/sco/js/sco.tab.js"></script>
<script src="./Public/sco/js/sco.message.js"></script>
<script src="./Public/Flat-UI-master/dist/js/flat-ui.js"></script>
<script type="text/javascript">

</script>
<script src="./Public/js/common/form.js"></script>
<script src="./Public/js/server/server.js"></script>
</html>