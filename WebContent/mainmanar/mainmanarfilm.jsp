<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
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
</head>
<body>
	<div class="contain clearfix">

		<!-- left side bar//////////////////////////////////////////////////////////////////////////////// -->
		<div class="left-sidebar">
			<div class="row">
				<div class="">
					<ul class="nav nav-list">
						<li><a href="mainmanagerprofit"><i class="fa fa-pencil-square-o"></i>盈利详情</a></li>
						<li class="active"><a href="#"><i class="fa fa-film"></i>影片管理</a></li>
						<li><a href="#"><i class="fa fa-film"></i>影院限制</a></li>
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
					<li><a href="#tab1">类型分析</a></li>
					<li><a href="#tab2">计划影片</a></li>
					<li><a href="#tab3">已推送</a></li>
					<li><a href="#tab4">已结束</a></li>
				</ul>
				<div class="pane-wrapper slide clearfix">
					<div class="tab-page">
					</div>

					<!--  -->
					<div class="tab-page">
						<button class="btn btn-primary add-film" data-toggle="modal" data-target="#modalAdd">
							Add Film
						</button>
						<div class="pagination pagination-success page-button">
							<a href="#" class="btn btn-success previous">上一页</a>
							<a href="#" class="btn btn-success next">下一页</a>
						</div>
						<table class="table">
							<thead>
								<tr>
									<th>影片ID</th>
									<th>影片名称</th>
									<th>时长</th>
									<th>种类</th>
									<th>成本</th>
									<th>编辑</th>
									<th>推送</th>
							</tr>
						</thead>
						<tbody class="film-tbody">
							
						</tbody>
					</table>
				</div>




				<!-- /////////////////////////////////////////////////////// -->
				<div class="tab-page">
					<div class="pagination pagination-success page-button">
							<a href="#" class="btn btn-success release-previous">上一页</a>
							<a href="#" class="btn btn-success release-next">下一页</a>
						</div>
					<table class="table">
							<thead>
								<tr>
									<th>影片ID</th>
									<th>影片名称</th>
									<th>时长</th>
									<th>种类</th>
									<th>成本</th>
							</tr>
						</thead>
						<tbody class="release-film-tbody">
							<!-- film.jsp -->
						</tbody>
					</table>
				</div>

				<div class="tab-page">
					<div class="pagination pagination-success page-button">
							<a href="#" class="btn btn-success old-previous">上一页</a>
							<a href="#" class="btn btn-success old-next">下一页</a>
						</div>
					<table class="table">
							<thead>
								<tr>
									<th>影片ID</th>
									<th>影片名称</th>
									<th>时长</th>
									<th>种类</th>
									<th>成本</th>
							</tr>
						</thead>
						<tbody class="old-film-tbody">
							<!-- film.jsp -->
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
				<h5 id="myModalLabel">影片编辑</h5>
			</div>
			<div class="modal-body">
				<form action="filmedit" id="filmedit-form" onSubmit="return false;">
				<div class="row-line" style="display:none;">
					<div class="row-label">影片ID:</div>
					<div class="form-group has-success row-content">
						<input class="form-control filmid-input" type="text" placeholder="id" name="filmid"/>
					</div>
				</div>
				<div class="row-line">
					<div class="row-label">影片名称:</div>
					<div class="form-group has-success row-content">
						<input class="form-control filmname-input" type="text" placeholder="name" name="name"/>
					</div>
				</div>
				<div class="row-line">
					<div class="row-label">时长:</div>
					<div class="form-group has-success row-content">
						<input class="form-control duration-input" type="number" placeholder="duration" name="duration"/>
					</div>
				</div>
				<div class="row-line">
					<div class="row-label">种类:</div>
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
				<div class="row-line">
					<div class="row-label">成本:</div>
					<div class="form-group has-success row-content">
						<input class="form-control cost-input" type="number" placeholder="cost" name="cost"/>
					</div>
				</div>   
			</form>
			</div>
			<div class="modal-footer">
				<button class="btn" data-dismiss="modal" aria-hidden="true">关闭</button>
				<button class="btn btn-primary save-button">保存修改</button>
			</div>
		</div>
	</div>
<!-- Modal -->
	<div id="modalAdd" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="modalAddLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
				<h5 id="myModalLabel">影片增加</h5>
			</div>
			<div class="modal-body">
				<form action="filmadd" id="filmadd-form" onSubmit="return false;">
				<div class="row-line">
					<div class="row-label">影片名称:</div>
					<div class="form-group has-success row-content">
						<input class="form-control filmname-input" type="text" placeholder="name" name="name"/>
					</div>
				</div>
				<div class="row-line">
					<div class="row-label">时长:</div>
					<div class="form-group has-success row-content">
						<input class="form-control duration-input" type="number" placeholder="duration" name="duration"/>
					</div>
				</div>
				<div class="row-line">
					<div class="row-label">种类:</div>
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
				<div class="row-line">
					<div class="row-label">成本:</div>
					<div class="form-group has-success row-content">
						<input class="form-control cost-input" type="number" placeholder="cost" name="cost"/>
					</div>
				</div>  
			</form>
			</div>
			<div class="modal-footer">
				<button class="btn" data-dismiss="modal" aria-hidden="true">关闭</button>
				<button class="btn btn-primary save-button">保存修改</button>
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