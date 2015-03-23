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
	<link rel="stylesheet" type="text/css" href="./Public/css/server/ServerAdd.css">
	<link rel="stylesheet" type="text/css" href="./Public/sco/css/scojs.css">
	<link rel="stylesheet" type="text/css" href="./Public/sco/css/sco.message.css">
	<link rel="stylesheet" type="text/css" href="./Public/css/vip/vipactivity.css">
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
						<li><a href="viprecord"><i class="fa fa-dribbble"></i> vip record</a></li>
						<li class="active"><a href="#"><i class="fa fa-user"></i> vip activity</a></li>
					</ul>
				</div>
			</div>
		</div>
		<!-- left side bar//////////////////////////////////////////////////////////////////////////////// -->


		<!-- changable place -->

		<div class="bar-match-content">
			<div class="table-box">
				<ul class="nav nav-tabs" data-trigger="tab">
					<li><a href="#tab1">activity</a></li>
					<li><a href="#tab2">old activity</a></li>
				</ul>
				<div class="pane-wrapper slide clearfix">
					<div class="tab-page">
						<table class="table">
							<thead>
								<tr>
									<th>id</th>
									<th>title</th>
									<th>participate</th>
									<th><div class="btn-group">
										<button class="btn btn-inverse dropdown-toggle table-button" type="button" data-toggle="dropdown">
											status <span class="caret"></span>
										</button>
										<ul class="dropdown-menu dropdown-menu-inverse" role="menu">
											<li><a href="#">status</a></li>
											<li><a href="#">unparticipated</a></li>
											<li><a href="#">participated</a></li>
										</ul>
									</div>

								</th>
							</tr>
						</thead>
						<tbody>
							<s:iterator id="activity" value="activitylist_unparticipated" status="st">
							<tr class="active">
								<th class="activityId"><s:property value="#activity.activityId"/></th>
								<th class="activityName"><s:property value="#activity.title"/></th>
								<th>
									<button class="btn btn-inverse table-button participate-button" data-toggle="modal" data-target="#modalParticipate">
										<i class="fa fa-pencil-square-o"></i>
									</button>
								</th>
								<th class="activity-answers" style="display:none;">
									<s:iterator id="answer" value="#activity.answerlist" status="ast">
									<li value='<s:property value="#answer.answerId"/>'><s:property value="#answer.answerContent"/></li>
								</s:iterator>
								</th>
								
								<th>unparticipated</th>
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
									<th>title</th>
									<th>view</th>
									<th><div class="btn-group">
										<button class="btn btn-inverse dropdown-toggle table-button" type="button" data-toggle="dropdown">
											status <span class="caret"></span>
										</button>
										<ul class="dropdown-menu dropdown-menu-inverse" role="menu">
											<li><a href="#">status</a></li>
											<li><a href="#">unparticipated</a></li>
											<li><a href="#">participated</a></li>
										</ul>
									</div>

								</th>
							</tr>
						</thead>
						<tbody>
							<s:iterator id="activity" value="activitylist" status="st">
							<tr class="active">
								<th class="activityId"><s:property value="#activity.activityId"/></th>
								<th class="activityName"><s:property value="#activity.title"/></th>
								<th>
									<button class="btn btn-inverse table-button participated-button" data-toggle="modal" data-target="#modalParticipated">
										<i class="fa fa-pencil-square-o"></i>
									</button>
								</th>
								<th class="activity-answers" style="display:none;">
									<s:iterator id="answer" value="#activity.answerlist" status="ast">
										<s:if test="%{#answer.answerId==activityrecordlist[#st.index].activityAnswer.answerId}">
											<li value='<s:property value="#answer.answerId"/>' choosen="choosen"><s:property value="#answer.answerContent"/>[<s:property value="#answer.activityRecords.size()"/>]</li>
										</s:if>
										<s:else>
										<li value='<s:property value="#answer.answerId"/>'><s:property value="#answer.answerContent"/>[<s:property value="#answer.activityRecords.size()"/>]</li>
										</s:else>
									</s:iterator>
								</th>
								
								<th>participated</th>
							</tr>
						</s:iterator>
							
						</tbody>
					</table>
				</div>
			</div>
		</div>

	</div>
	<!-- changable place -->
	<!-- Modal -->
	<div id="modalParticipate" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="modalParticipateLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
				<h5 id="myModalLabel">Activity</h5>
			</div>
			<div class="modal-body">
				<div class="row-line" style="display:none;">
					<div class="row-label activityid-input"></div>
				</div>
				<div class="row-line">
					<div class="row-label">title:</div>
				</div>
				<div class="title-panel">
				</div>
				<div class="row-line">
					<div class="row-label">answer:</div>
				</div>
				<div class="answers-panel">
			</div>
		</div>
		<div class="modal-footer">
				<button class="btn" data-dismiss="modal" aria-hidden="true">关闭</button>
				<button class="btn btn-primary save-button" target="joinActivity">sure</button>
			</div>
	</div>
</div>
<div id="modalParticipated" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="modalParticipatedLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
				<h5 id="myModalLabel">Activity</h5>
			</div>
			<div class="modal-body">
				<div class="row-line" style="display:none;">
					<div class="row-label activityid-input"></div>
				</div>
				<div class="row-line">
					<div class="row-label">title:</div>
				</div>
				<div class="title-panel">
				</div>
				<div class="row-line">
					<div class="row-label">answer:</div>
				</div>
				<div class="answers-panel">
			</div>
		</div>
		<div class="modal-footer">
				<button class="btn" data-dismiss="modal" aria-hidden="true">关闭</button>
			</div>
	</div>
</div>

</body>
<script src="./Public/jquery/jquery.min.js"></script>
<script src="./Public/dist/js/bootstrap.min.js"></script>
<script src="./Public/sco/js/sco.panes.js"></script>
<script src="./Public/sco/js/sco.tab.js"></script>
<script src="./Public/sco/js/sco.message.js"></script>
<script src="./Public/Flat-UI-master/dist/js/flat-ui.js"></script>
<script type="text/javascript">
// $("#modalParticipate").modal('show');
</script>
<script src="./Public/js/server/server.js"></script>
<script src="./Public/js/vip/vipactivity.js"></script>
</html>