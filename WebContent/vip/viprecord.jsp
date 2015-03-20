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
						<li><a href="vipinfo"><i class="fa fa-pencil-square-o"></i>vip info</a></li>
						<li><a href="vipcard"><i class="fa fa-film"></i>vip card</a></li>
						<li class="active"><a href="#"><i class="fa fa-dribbble"></i> vip record</a></li>
						<li><a href="vipactivity"><i class="fa fa-user"></i> vip activity</a></li>
					</ul>
				</div>
			</div>
		</div>
		<!-- left side bar//////////////////////////////////////////////////////////////////////////////// -->


		<!-- changable place -->

		<div class="bar-match-content">
			<div class="table-box">
				
				<div class="clearfix">
					<div class="tab-page">
						
						<table class="table">
							<thead>
								<tr>
									<th>id</th>
									<th>time</th>
									<th>num</th>
									<th>purpose</th>
									<th>result</th>
									<th>comment</th>
								</tr>
							</thead>
							<tbody>
								<s:iterator id="record" value="recordlist" status="st">
								<s:if test="%{#record.result==0}">
								<tr class="danger">
								</s:if>
								<s:if test="%{#record.result==1}">
								<s:if test="%{#record.recordNumber>0}">
								<tr class="success">
								</s:if>
								<s:else>
								<tr class="warning">
							</s:else>
								</s:if>
									<th class="recordId"><s:property value="#record.recordId"/></th>
									<th class="recordTime"><s:property value="#record.strrecordTime"/></th>
									<th class="operanum"><s:property value="#record.recordNumber"/></th>
									<th class="purpose"><s:property value="#record.purpose"/></th>
									<th class="result"><s:property value="#record.strresult"/></th>
									<th class="comment"><s:property value="#record.comment"/></th>
								</tr>
								</s:iterator>
							</tbody>
						</table>
					</div>




					<!-- /////////////////////////////////////////////////////// -->

				</div>
			</div>

		</div>
		<!-- changable place -->
	</body>
	<script src="./Public/jquery/jquery.min.js"></script>
	<script src="./Public/dist/js/bootstrap.min.js"></script>
	<script src="./Public/sco/js/sco.panes.js"></script>
	<script src="./Public/sco/js/sco.tab.js"></script>
	<script src="./Public/Flat-UI-master/dist/js/flat-ui.js"></script>
	<script type="text/javascript">

	</script>
	<script src="./Public/js/server/server.js"></script>
	<script src="./Public/js/server/serverFilmPlan.js"></script>
	</html>