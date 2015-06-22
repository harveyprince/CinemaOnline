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
						<li><a href="viewManagerProfitPlan"><i class="fa fa-pie-chart"></i>利润决策</a></li>
						<li class="active"><a href="viewFilmPlan"><i class="fa fa-pie-chart"></i>影片规划</a></li>
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
					<li><a href="#tab1">未规划影片</a></li>
					<li><a href="#tab2">已规划影片</a></li>
				</ul>
				<div class="pane-wrapper slide clearfix">
					<div class="tab-page">
						<table class="table">
							<thead>
								<tr>
									<th>影片名称</th>
									<th>票价</th>
									<!-- iterator -->
									<s:iterator id="hall" value="halllist" status="st">
									<th hallId='<s:property value="#hall.hallNo"/>'><s:property value="#hall.name"/></th>
									</s:iterator>
									<!-- iterator -->
									<th>开始时间</th>
									<th>上映天数</th>
									<th>实际盈利</th>
									<th>目标盈利</th>
									<th>发布</th>
							</tr>
						</thead>
						<tbody class="film-plan-tbody">
							<s:iterator id="film" value="filmlist" status="ft">
								<tr>
									<th filmId='<s:property value="#film.filmId"/>' filmcost='<s:property value="#film.cost"/>'><s:property value="#film.name"/></th>
									<th><input class="form-control price-input number-input" type="number" min="0" value="0"/></th>
									<!-- iterator -->
									<s:iterator id="hall" value="halllist" status="st">
									<th hallId='<s:property value="#hall.hallNo"/>' cost='<s:property value="#hall.cost"/>' seats='<s:property value="#hall.seats"/>'>
										<input class="form-control times-input number-input" type="number" min="0" value="0"/>
									</th>
									</s:iterator>
									<!-- iterator -->
									<th>
										<input class="form-control beginTime-input date-input" type="date" placeholder="beginTime" value="1994-10-20"/>
									</th>
									<th><input class="form-control timeLength-input number-input" type="number" min="0" value="0"/></th>
									<th class="actual-profit">0</th>
									<th>
										<s:property value="%{formatDouble(#film.filmProfitPlan.profitPercent * #film.filmProfitPlan.profitPlan.profitSum / 100 )}" />
								</th>
									<th>
										<button class="btn btn-success publish">发布</button>
									</th>
							</tr>
							</s:iterator>
						</tbody>
					</table>
					</div>

					<!-- /////////////////////////////////////////////////////// -->
					<div class="tab-page">
						<table class="table">
							<thead>
								<tr>
									<th>影片名称</th>
									<!-- iterator -->
									<s:iterator id="hall" value="halllist" status="st">
									<th></th>
									</s:iterator>
									<!-- iterator -->
									<th>票价</th>
									<th>开始时间</th>
									<th>结束时间</th>
							</tr>
						</thead>
						<tbody class="film-plan-tbody">
							<s:iterator id="film" value="planedfilmlist" status="ft">
								<tr>
									<th><s:property value="#film.name"/></th>
									
									<!-- iterator -->
									<s:iterator id="hall" value="#film.filmReleasePlanlist" status="st">
									<th>
										<s:property value="#hall.hall.name"/>:<s:property value="#hall.playTimes"/>
									</th>
									<s:if test="%{#st.last}">
									<th><s:property value="#hall.price"/></th>
										<th>
										<s:property value="%{formatDate(#hall.beginTime)}"/>
									</th>
									<th>
										<s:property value="%{formatDate(#hall.endTime)}"/>
									</th>
									</s:if>
									</s:iterator>
									<!-- iterator -->
									
							</tr>
							</s:iterator>
						</tbody>
					</table>
					</div>
				</div>
			</div>

		</div>
		<!-- changable place -->


</body>
<script src="./Public/jquery/jquery.min.js"></script>
<script src="./Public/dist/js/bootstrap.min.js"></script>
<script src="./Public/sco/js/sco.panes.js"></script>
<script src="./Public/sco/js/sco.tab.js"></script>
<script src="./Public/sco/js/sco.message.js"></script>
<script src="./Public/Flat-UI-master/dist/js/flat-ui.js"></script>
<script src="./Public/js/common/date.js"></script>
<script type="text/javascript">
var date = new Date();
date.setDate(date.getDate()+1);
$(".beginTime-input").val(date.format("yyyy-MM-dd"));
var filmslist = [
<s:iterator id="film" value="filmlist" status="st">
{ id: <s:property value="#film.filmId"/>, text: '<s:property value="#film.name"/>' }
<s:if test="%{!#st.last}">,</s:if>
</s:iterator>
];

var hallslist = [
<s:iterator id="hall" value="halllist" status="st">
{ id: <s:property value="#hall.hallNo"/>, text: '<s:property value="#hall.name"/>' }
<s:if test="%{!#st.last}">,</s:if>
</s:iterator>
];
</script>

<script src="./Public/js/common/form.js"></script>
<script src="./Public/js/server/server.js"></script>
<script src="./Public/js/manager/filmplan.js"></script>
</html>