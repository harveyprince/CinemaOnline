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
						<li><a href="#"><i class="fa fa-film"></i>影院限制</a></li>
						<li><a id="right-panel-link" href="#right-panel">Open panel</a></li>
					</ul>
				</div>
			</div>
			<div class="user-button"><a href="logout"><i class="fa fa-sign-out"></i>退出</a></div>
		</div>
		<!-- left side bar//////////////////////////////////////////////////////////////////////////////// -->
		<div class="bar-match-content">
		<div class="info-show-panel">
			<ul class="nav nav-tabs" data-trigger="tab">
				<li><a href="#tab1">盈利统计</a></li>
				<li><a href="#tab2">发展规划</a></li>
			</ul>
			<div class="pane-wrapper slide clearfix">
				<div class="tab-page">
					<div id="container" style="min-width: 310px; height: 100px; max-width: 600px; margin: 0 auto">
						<div class="statistic-label">总利润:<span class="profit-show"></span></div>
					</div>
					
					<div id="profit-container" style="height: 400px; width: 601px; margin: 0 auto"></div>
				</div>
				<div class="tab-page">
					<div></div>
				</div>
			</div>
		</div>
	</div>
	<!-- Right panel -->
  <div id="right-panel" class="panel">
    <div id="close-panel-bt">X</div>
  </div>

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
$('#right-panel-link').panelslider({side: 'right', clickClose: true, duration: 200, easingOpen: 'easeInBack', easingClose: 'easeOutBack'});

    $('#close-panel-bt').click(function() {
      $.panelslider.close();
    });
</script>
<script src="./Public/js/common/form.js"></script>
<script src="./Public/js/server/server.js"></script>
<script src="./Public/js/mainmanager/statistic.js"></script>
<script src="./Public/js/mainmanager/statisticworker.js"></script>
</html>