<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>server page</title>
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
						<li class="active"><a href="#"><i class="fa fa-pencil-square-o"></i>check Plan</a></li>
					</ul>
				</div>
			</div>
		</div>
		<!-- left side bar//////////////////////////////////////////////////////////////////////////////// -->


		<!-- changable place -->

		<div class="bar-match-content">
			<div class="table-box">
				<ul class="nav nav-tabs" data-trigger="tab">
					<li><a href="#tab1">checking plan</a></li>
					<li><a href="#tab2">checked plan</a></li>
				</ul>
				<div class="pane-wrapper slide clearfix">
					<div class="tab-page">
						<table class="table">
							<thead>
								<tr>
									<th>id</th>
									<th>filmname</th>
									<th>No</th>
									<th>seatSum</th>
									<th>begintime</th>
									<th>endtime</th>
									<th>price</th>
									<th>pass</th>
									<th>unpass</th>
							</tr>
						</thead>
						<tbody>
							<s:iterator id="plan" value="filmplanlist" status="st">
							<s:if test="%{#plan.status==0}">
							<tr class="warning">
							</s:if>
							<s:if test="%{#plan.status==1}">
							<tr class="active">
							</s:if>
							<s:if test="%{#plan.status==2}">
							<tr class="success">
							</s:if>
							<s:if test="%{#plan.status==3}">
							<tr class="danger">
							</s:if>
								<th class="planId"><s:property value="#plan.planid"/></th>
								<th class="filmName" filmId='<s:property value="#plan.filmid"/>'><s:property value="#plan.filmName"/></th>
								<th class="hallNo" hallId='<s:property value="#plan.hall.hallNo"/>'><s:property value="#plan.hall.name"/></th>
								<th class="seatSum"><s:property value="#plan.seatSum"/></th>
								<th class="beginTime" date-time='<s:property value="#plan.beginTtime"/>' data-toggle="tooltip" data-placement="top" title='<s:property value="#plan.beginTtime"/>'><s:property value="#plan.begindft"/></th>
								<th class="endTime" date-time='<s:property value="#plan.endTtime"/>' data-toggle="tooltip" data-placement="top" title='<s:property value="#plan.endTtime"/>'><s:property value="#plan.enddft"/></th>
								<th class="price"><s:property value="#plan.price"/></th>
								<th>
								<button class="btn btn-inverse table-button plan-pass-button plan-judge-button" target="planpass">
										<i class="fa fa-check"></i>
									</button>
								</th>
								<th>
								<button class="btn btn-inverse table-button plan-unpass-button plan-judge-button" target="planunpass">
										<i class="fa fa-times"></i>
									</button>
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
								<th>id</th>
								<th>filmname</th>
								<th>No</th>
								<th>time</th>
								<th>price</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<th>#</th>
								<th>#</th>
								<th>#</th>
								<th>#</th>
								<th>#</th>
							</tr>
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
<script type="text/javascript">

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
<script src="./Public/js/manager/plancheck.js"></script>
</html>