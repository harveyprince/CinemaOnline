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
						<li class="active"><a href="#"><i class="fa fa-pencil-square-o"></i>Film Plan</a></li>
						<li ><a href="serverfilm"><i class="fa fa-film"></i>Film</a></li>
						<li><a href="serveractivity"><i class="fa fa-dribbble"></i> Activity</a></li>
						<li><a href="ticketsale"><i class="fa fa-usd"></i> Ticket Sale</a></li>
						<li><a href="#"><i class="fa fa-user"></i> VIP</a></li>
					</ul>
				</div>
			</div>
		</div>
		<!-- left side bar//////////////////////////////////////////////////////////////////////////////// -->


		<!-- changable place -->

		<div class="bar-match-content">
			<div class="table-box">
				<ul class="nav nav-tabs" data-trigger="tab">
					<li><a href="#tab1">future plan</a></li>
					<li><a href="#tab2">old plan</a></li>
				</ul>
				<div class="pane-wrapper slide clearfix">
					<div class="tab-page">
						<button class="btn btn-primary add-plan" data-toggle="modal" data-target="#modalAdd">
							Add Plan
						</button>
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
									<th>edit</th>
									<th>submit</th>
									<th><div class="btn-group">
										<button class="btn btn-inverse dropdown-toggle table-button" type="button" data-toggle="dropdown">
											status <span class="caret"></span>
										</button>
										<ul class="dropdown-menu dropdown-menu-inverse" role="menu">
											<li><a href="#">status</a></li>
											<li><a href="#">unsubmited</a></li>
											<li><a href="#">waiting for check</a></li>
											<li><a href="#">checked pass</a></li>
											<li><a href="#">checked failed</a></li>
										</ul>
									</div>

								</th>
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
								<th class="beginTime" date-time='<s:property value="#plan.beginTtime"/>'><s:property value="#plan.begindft"/></th>
								<th class="endTime" date-time='<s:property value="#plan.endTtime"/>'><s:property value="#plan.enddft"/></th>
								<th class="price"><s:property value="#plan.price"/></th>
								<th>
									<s:if test="%{#plan.status==1||#plan.status==2}">
									<button class="btn btn-inverse table-button" disabled="disabled">
										<i class="fa fa-pencil-square-o"></i>
									</button>
								</s:if>
								<s:else>
								<button class="btn btn-inverse table-button film-edit-button" data-toggle="modal" data-target="#modalEdit">
										<i class="fa fa-pencil-square-o"></i>
									</button>
							</s:else>
								</th>
								<th>
									<s:if test="%{#plan.status==1||#plan.status==2}">
									<button class="btn btn-inverse table-button" disabled="disabled">
										<i class="fa fa-arrow-up"></i>
									</button>
									</s:if>
								<s:else>
								<button class="btn btn-inverse table-button submitforcheck-button" target="plansubmit">
										<i class="fa fa-arrow-up"></i>
									</button>
							</s:else>
								</th>
								<th><s:property value="#plan.strstatus"/></th>
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
	<!-- Modal -->
	<div id="modalEdit" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="modalEditLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
				<h5 id="myModalLabel">Film Plan Edit</h5>
			</div>
			<div class="modal-body">
				<form action="planedit" id="planedit-form" onSubmit="return false;">
					<div class="row-line" style="display:none;">
					<div class="row-label">planid:</div>
					<div class="form-group has-success row-content">
						<input class="form-control planid-input" type="text" placeholder="planid" name="planid"/>
					</div>
				</div>
				<div class="row-line">
					<div class="row-label">film:</div>
					<div class="span3 row-content">
						<select class="form-control select select-primary select-block mbl film-input" name="filmid"></select>
					</div>
				</div>
				<div class="row-line">
					<div class="row-label">hallNo:</div>
					<div class="span3 row-content">
						<select class="form-control select select-primary select-block mbl hall-input" name="hallNo"></select>
					</div>
				</div> 
				<div class="row-line">
					<div class="row-label">seatSum:</div>
					<div class="form-group has-success row-content">
						<input class="form-control seat-input" type="number" placeholder="Sum" name="seatSum"/>
					</div>
				</div>
				<div class="row-line">
					<div class="row-label">price:</div>
					<div class="form-group has-success row-content">
						<input class="form-control price-input" type="number" placeholder="price" name="price"/>
					</div>
				</div> 
				<div class="row-line">
					<div class="row-label">beginTime:</div>
					<div class="form-group has-success row-content">
						<input class="form-control beginTime-input" type="datetime-local" placeholder="beginTime" name="beginTime" />
					</div>
				</div> 
				<div class="row-line">
					<div class="row-label">endTime:</div>
					<div class="form-group has-success row-content">
						<input class="form-control endTime-input" type="datetime-local" placeholder="endTime" name="endTime"/>
					</div>
				</div> 
			</form>
			</div>
			<div class="modal-footer">
				<button class="btn" data-dismiss="modal" aria-hidden="true">关闭</button>
				<button class="btn btn-primary save-button">Save changes</button>
			</div>
		</div>
	</div>

	<!-- Modal -->
	<div id="modalAdd" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="modalAddLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
				<h5 id="myModalLabel">Film Plan Add</h5>
			</div>
			<div class="modal-body">
				<form action="planadd" id="planadd-form" onSubmit="return false;">
				<div class="row-line">
					<div class="row-label">film:</div>
					<div class="span3 row-content">
						<select class="form-control select select-primary select-block mbl film-input" name="filmid"></select>
					</div>
				</div>
				<div class="row-line">
					<div class="row-label">hallNo:</div>
					<div class="span3 row-content">
						<select class="form-control select select-primary select-block mbl hall-input" name="hallNo"></select>
					</div>
				</div> 
				<div class="row-line">
					<div class="row-label">seatSum:</div>
					<div class="form-group has-success row-content">
						<input class="form-control seat-input" type="number" placeholder="Sum" name="seatSum"/>
					</div>
				</div>
				<div class="row-line">
					<div class="row-label">price:</div>
					<div class="form-group has-success row-content">
						<input class="form-control price-input" type="number" placeholder="price" name="price"/>
					</div>
				</div> 
				<div class="row-line">
					<div class="row-label">beginTime:</div>
					<div class="form-group has-success row-content">
						<input class="form-control beginTime-input" type="datetime-local" placeholder="beginTime" name="beginTime"/>
					</div>
				</div> 
				<div class="row-line">
					<div class="row-label">endTime:</div>
					<div class="form-group has-success row-content">
						<input class="form-control endTime-input" type="datetime-local" placeholder="endTime" name="endTime"/>
					</div>
				</div> 
				</form>
			</div>
			<div class="modal-footer">
				<button class="btn" data-dismiss="modal" aria-hidden="true">关闭</button>
				<button class="btn btn-primary save-button">Save changes</button>
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
<script src="./Public/js/server/serverFilmPlan.js"></script>
</html>