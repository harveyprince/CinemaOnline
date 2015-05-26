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
						<li class="active"><a href="#"><i class="fa fa-pencil-square-o"></i>放映计划</a></li>
						<li ><a href="serverfilm"><i class="fa fa-film"></i>电影</a></li>
						<li><a href="ticketsale"><i class="fa fa-usd"></i>售票</a></li>
						<li><a href="viewVipDetail"><i class="fa fa-user"></i> VIP</a></li>
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
						<button class="btn btn-primary add-plan" data-toggle="modal" data-target="#modalAdd">
							增加计划
						</button>
						<div class="pagination pagination-success page-button">
							<a href="#" class="btn btn-success previous">上一页</a>
							<a href="#" class="btn btn-success next">下一页</a>
						</div>
						<table class="table">
							<thead>
								<tr>
									<th>计划ID</th>
									<th>影片名称</th>
									<th>厅号</th>
									<th>座位数</th>
									<th>开始时间</th>
									<th>结束时间</th>
									<th>价格</th>
									<th>编辑</th>
									<th>提交</th>
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
						<tbody class="film-tbody">
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
				<h5 id="myModalLabel">放映计划编辑</h5>
			</div>
			<div class="modal-body">
				<form action="planedit" id="planedit-form" onSubmit="return false;">
					<div class="row-line" style="display:none;">
					<div class="row-label">计划ID:</div>
					<div class="form-group has-success row-content">
						<input class="form-control planid-input" type="text" placeholder="planid" name="planid"/>
					</div>
				</div>
				<div class="row-line">
					<div class="row-label">影片:</div>
					<div class="span3 row-content">
						<select class="form-control select select-primary select-block mbl film-input" name="filmid"></select>
					</div>
				</div>
				<div class="row-line">
					<div class="row-label">厅号:</div>
					<div class="span3 row-content">
						<select class="form-control select select-primary select-block mbl hall-input" name="hallNo"></select>
					</div>
				</div> 
				<div class="row-line">
					<div class="row-label">座位数:</div>
					<div class="form-group has-success row-content">
						<input class="form-control seat-input" type="number" placeholder="Sum" name="seatSum"/>
					</div>
				</div>
				<div class="row-line">
					<div class="row-label">价格:</div>
					<div class="form-group has-success row-content">
						<input class="form-control price-input" type="number" placeholder="price" name="price"/>
					</div>
				</div> 
				<div class="row-line">
					<div class="row-label">开始时间:</div>
					<div class="form-group has-success row-content">
						<input class="form-control beginTime-input" type="datetime-local" placeholder="beginTime" name="beginTime" />
					</div>
				</div> 
				<div class="row-line">
					<div class="row-label">结束时间:</div>
					<div class="form-group has-success row-content">
						<input class="form-control endTime-input" type="datetime-local" placeholder="endTime" name="endTime"/>
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
				<h5 id="myModalLabel">放映计划增加</h5>
			</div>
			<div class="modal-body">
				<form action="planadd" id="planadd-form" onSubmit="return false;">
				<div class="row-line">
					<div class="row-label">影片:</div>
					<div class="span3 row-content">
						<select class="form-control select select-primary select-block mbl film-input" name="filmid"></select>
					</div>
				</div>
				<div class="row-line">
					<div class="row-label">厅号:</div>
					<div class="span3 row-content">
						<select class="form-control select select-primary select-block mbl hall-input" name="hallNo"></select>
					</div>
				</div> 
				<div class="row-line">
					<div class="row-label">座位数:</div>
					<div class="form-group has-success row-content">
						<input class="form-control seat-input" type="number" placeholder="Sum" name="seatSum" min="0" value='<s:property value="halllist[0].seats"/>' max='<s:property value="halllist[0].seats"/>'/>
					</div>
				</div>
				<div class="row-line">
					<div class="row-label">价格:</div>
					<div class="form-group has-success row-content">
						<input class="form-control price-input" type="number" placeholder="price" name="price"/>
					</div>
				</div> 
				<div class="row-line">
					<div class="row-label">开始时间:</div>
					<div class="form-group has-success row-content">
						<input class="form-control beginTime-input" type="datetime-local" placeholder="beginTime" name="beginTime"/>
					</div>
				</div> 
				<div class="row-line">
					<div class="row-label">结束时间:</div>
					<div class="form-group has-success row-content">
						<input class="form-control endTime-input" type="datetime-local" placeholder="endTime" name="endTime"/>
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

var filmslist = [
<s:iterator id="film" value="filmlist" status="st">
{ id: <s:property value="#film.filmId"/>, text: '<s:property value="#film.name"/>' }
<s:if test="%{!#st.last}">,</s:if>
</s:iterator>
];

var film_time = {
<s:iterator id="film" value="filmlist" status="st">
 '<s:property value="#film.filmId"/>': '<s:property value="#film.duration"/>' 
<s:if test="%{!#st.last}">,</s:if>
</s:iterator>
}

var hallslist = [
<s:iterator id="hall" value="halllist" status="st">
{ id: <s:property value="#hall.hallNo"/>, text: '<s:property value="#hall.name"/>' }
<s:if test="%{!#st.last}">,</s:if>
</s:iterator>
];

var hall_seat = {
<s:iterator id="hall" value="halllist" status="st">
 '<s:property value="#hall.hallNo"/>': '<s:property value="#hall.seats"/>' 
<s:if test="%{!#st.last}">,</s:if>
</s:iterator>
}
</script>
<script src="./Public/js/common/date.js"></script>
<script src="./Public/js/common/form.js"></script>
<script src="./Public/js/server/server.js"></script>
<script src="./Public/js/server/serverFilmPlan.js"></script>
</html>