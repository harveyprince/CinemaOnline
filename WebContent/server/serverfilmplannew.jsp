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
						<li><a href="serverfilmplan"><i class="fa fa-pencil-square-o"></i>放映计划</a></li>
						<li class="active"><a href="serverfilmplannew"><i class="fa fa-pencil-square-o"></i>放映计划new</a></li>
						<li><a href="ticketsale"><i class="fa fa-usd"></i>售票</a></li>
						<li><a href="viewVipDetail"><i class="fa fa-user"></i> VIP</a></li>
						<li><a href="serverstatistic"><i class="fa fa-user"></i>统计</a></li>
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
					<li><a href="#tab1">future plan</a></li>
				</ul>
				<div class="pane-wrapper slide clearfix">
					<div class="tab-page">
						<input class="form-control time-input date-input" type="date" placeholder="time" value="1994-10-20" style="width:220px;"/>
						<select class="form-control select select-primary select-block mbl hall-input" name="hallNo"></select>
						<button class="btn btn-primary film-plan-manage">
							放映安排
						</button>

						
				</div>

			</div>
		</div>

	</div>
	<!-- changable place -->
	

		</div>
	</div>
</body>
<script src="./Public/jquery/jquery.min.js"></script>
<script src="./Public/dist/js/bootstrap.min.js"></script>
<script src="./Public/sco/js/sco.panes.js"></script>
<script src="./Public/sco/js/sco.tab.js"></script>
<script src="./Public/sco/js/sco.message.js"></script>
<script src="./Public/Flat-UI-master/dist/js/flat-ui.js"></script>
<script src="./Public/js/common/date.js"></script>
<script src="./Public/js/common/form.js"></script>
<script src="./Public/js/server/server.js"></script>
<script type="text/javascript">
var date = new Date();
date.setDate(date.getDate()+1);
$(".time-input").val(date.format("yyyy-MM-dd"));

var hallslist = [
<s:iterator id="hall" value="halllist" status="st">
{ id: <s:property value="#hall.hallNo"/>, text: '<s:property value="#hall.name"/>' }
<s:if test="%{!#st.last}">,</s:if>
</s:iterator>
];

selectInitial($("select.hall-input"),hallslist);
$("select.hall-input").select2();

$(".film-plan-manage").click(function(){
	var datestring = $(".time-input").val();
	var datearray = datestring.split("-");
	var date = new Date(Number(datearray[0]),Number(datearray[1])-1,Number(datearray[2]));
	var hallNo = $("select.hall-input").val();
	window.open("calenderPlanPage"+"?"+"date="+date.getTime()+"&"+"hid="+hallNo);
});
</script>
<script src="./Public/js/server/serverFilmPlanNew.js"></script>
</html>