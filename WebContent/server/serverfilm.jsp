<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
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
						<li><a href="serverfilmplan"><i class="fa fa-pencil-square-o"></i>Film Plan</a></li>
						<li class="active"><a href="#"><i class="fa fa-film"></i>Film</a></li>
						<li><a href="#"><i class="fa fa-dribbble"></i> Activity</a></li>
						<li><a href="#"><i class="fa fa-usd"></i> Ticket Sale</a></li>
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
					<li><a href="#tab1">future film</a></li>
					<li><a href="#tab2">old film</a></li>
				</ul>
				<div class="pane-wrapper slide clearfix">
					<div class="tab-page">
						<button class="btn btn-primary add-film" data-toggle="modal" data-target="#modalAdd">
							Add Film
						</button>
						<table class="table">
							<thead>
								<tr>
									<th>id</th>
									<th>filmname</th>
									<th>duration</th>
									<th>kind</th>
									<th>releasetime</th>
									<th>shelvestime</th>
									<th>edit</th>
									<th>release</th>
									<th><div class="btn-group">
										<button class="btn btn-inverse dropdown-toggle table-button" type="button" data-toggle="dropdown">
											status <span class="caret"></span>
										</button>
										<ul class="dropdown-menu dropdown-menu-inverse" role="menu">
											<li><a href="#">status</a></li>
											<li><a href="#">unreleased</a></li>
											<li><a href="#">releasing</a></li>
										</ul>
									</div>

								</th>
							</tr>
						</thead>
						<tbody>
							<s:iterator id="film" value="filmlist" status="st">
							<s:if test="%{#film.status==0}">
							<tr class="warning">
							</s:if>
							<s:if test="%{#film.status==1}">
							<tr class="success">
							</s:if>
								<th class="filmId"><s:property value="#film.filmId"/></th>
								<th class="filmName"><s:property value="#film.name"/></th>
								<th class="duration"><s:property value="#film.duration"/></th>
								<th class="kind"><s:property value="#film.kind"/></th>
								<th class="releaseTime"><s:property value="#film.rtTime"/></th>
								<th class="shelvesTime"><s:property value="#film.stTime"/></th>
								
									<s:if test="%{#film.status==1}">
									<th>
									<button class="btn btn-inverse table-button" disabled="disabled">
										<i class="fa fa-pencil-square-o"></i>
									</button>
									</th>
									<th>
								<button class="btn btn-inverse table-button film-unrelease-button film-eye-button" target="unreleasefilm">
										<i class="fa fa-eye"></i>
									</button>
									</th>
									<th>releasing</th>
								</s:if>
								<s:if test="%{#film.status==0}">
								<th>
								<button class="btn btn-inverse table-button film-edit-button" data-toggle="modal" data-target="#modalEdit">
										<i class="fa fa-pencil-square-o"></i>
									</button>
									</th>
									<th>
								<button class="btn btn-inverse table-button film-release-button film-eye-button" target="releasefilm">
										<i class="fa fa-eye-slash"></i>
									</button>
									</th>
									<th>unreleased</th>
								</s:if>
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
				<h5 id="myModalLabel">Film Edit</h5>
			</div>
			<div class="modal-body">
				<form action="filmedit" id="filmedit-form" onSubmit="return false;">
				<div class="row-line" style="display:none;">
					<div class="row-label">filmid:</div>
					<div class="form-group has-success row-content">
						<input class="form-control filmid-input" type="text" placeholder="id" name="filmid"/>
					</div>
				</div>
				<div class="row-line">
					<div class="row-label">filmname:</div>
					<div class="form-group has-success row-content">
						<input class="form-control filmname-input" type="text" placeholder="name" name="name"/>
					</div>
				</div>
				<div class="row-line">
					<div class="row-label">duration:</div>
					<div class="form-group has-success row-content">
						<input class="form-control duration-input" type="number" placeholder="duration" name="duration"/>
					</div>
				</div>
				<div class="row-line">
					<div class="row-label">kind:</div>
					<div class="span3 row-content">
						<select class="form-control select select-primary select-block mbl kind-input" name="kind">
							<option value="happy">happy</option>
							<option value="fear">fear</option>
							<option value="scary">scary</option>
							<option value="joke">joke</option>
							<option value="cartoon">cartoon</option>
						</select>
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
				<h5 id="myModalLabel">Film Add</h5>
			</div>
			<div class="modal-body">
				<form action="filmadd" id="filmadd-form" onSubmit="return false;">
				<div class="row-line">
					<div class="row-label">filmname:</div>
					<div class="form-group has-success row-content">
						<input class="form-control filmname-input" type="text" placeholder="name" name="name"/>
					</div>
				</div>
				<div class="row-line">
					<div class="row-label">duration:</div>
					<div class="form-group has-success row-content">
						<input class="form-control duration-input" type="number" placeholder="duration" name="duration"/>
					</div>
				</div>
				<div class="row-line">
					<div class="row-label">kind:</div>
					<div class="span3 row-content">
						<select class="form-control select select-primary select-block mbl kind-input" name="kind">
							<option value="happy">happy</option>
							<option value="fear">fear</option>
							<option value="scary">scary</option>
							<option value="joke">joke</option>
							<option value="cartoon">cartoon</option>
						</select>
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

</script>
<script src="./Public/js/common/form.js"></script>
<script src="./Public/js/server/server.js"></script>
<script src="./Public/js/server/serverFilm.js"></script>
</html>