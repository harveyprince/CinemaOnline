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
					<li><a href="mainmanarstatistic"><i class="fa fa-pie-chart"></i>统计</a></li>
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
				<li><a href="#tab2">利润规划</a></li>
				<li><a href="#tab3">完结规划</a></li>
			</ul>
			<div class="pane-wrapper slide clearfix">
				<div class="tab-page">
					<div id="container" style="min-width: 310px; height: 100px; max-width: 600px; margin: 0 auto">
						<div class="statistic-label">总利润:<span class="profit-show"></span></div>
					</div>
					<div id="profit-container" style="height: 400px; width: 601px; margin: 0 auto"></div>
					<!-- 罗列利润规划的平均影片利润走势（规划和实际） -->
				</div>
				<div class="tab-page">
					<!-- 罗列未完结利润规划，包括，规划所对应的影片 -->
					<a id="profitplan-panel-link" href="#profitplan-panel">新增规划</a>
					<div class="profit-plan-list" action="getworkingprofitplan"></div>

				</div>
				<div class="tab-page">
					<!-- 罗列各个利润规划，点击显示单个规划的利润分配和实际利润以及平均利润的规划与实际，显示要素：影片名称、种类 -->
					<div></div>
				</div>
			</div>
		</div>
	</div>
	<!-- Right panel -->
	<div id="right-panel" class="panel">
		<div class="close-panel-bt">X</div>
	</div>
	<div id="profitplan-panel" class="panel">
		<div class="close-panel-bt">X</div>
		<form action="addProfitPlan" id="profitplan-form" onSubmit="return false;">
			<div class="row-line">
				<div class="row-label">计划盈利总额:</div>
				<div class="form-group has-success row-content">
					<input class="form-control duration-input" type="number" placeholder="profitsum" name="profitsum"/>
				</div>
			</div>
			<div class="row-line">
				<div class="row-label">匹配影片:</div>
				<div class="span3 row-content form-control" style="padding: 6px 12px;height: auto;">
					<select class="form-control select select-primary select-block mbl film-input" multiple="multiple" name="film">
					</select>
				</div>
			</div> 
		</form>
		<div class="row-line">
		 	<button class="btn btn-primary add-profitplan">
						确定增加
			</button>
		</div>
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
var filmslist = [
<s:iterator id="film" value="filmlist" status="st">
{ id: <s:property value="#film.filmId"/>, text: '<s:property value="#film.name"/>' }
<s:if test="%{!#st.last}">,</s:if>
</s:iterator>
];

</script>
<script src="./Public/js/common/form.js"></script>
<script src="./Public/js/server/server.js"></script>
<script src="./Public/js/mainmanager/mainmanagerprofit.js"></script>
<script src="./Public/js/mainmanager/statistic.js"></script>
<script src="./Public/js/mainmanager/statisticworker.js"></script>
</html>