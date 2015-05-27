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
	<link rel="stylesheet" type="text/css" href="./Public/css/server/ServerSale.css">
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
						<li><a href="vipinfo"><i class="fa fa-user"></i>个人信息</a></li>
						<li><a href="vipcard"><i class="fa fa-credit-card"></i>会员卡</a></li>
						<li><a href="viprecord"><i class="fa fa-tasks"></i>收支记录</a></li>
						<li class="active"><a href="vipticket"><i class="fa fa-trophy"></i>购票</a></li>
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
					<li><a href="#tab1">正在出售</a></li>
				</ul>
				<div class="pane-wrapper slide clearfix">
					<div class="tab-page">
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
									<th>购买</th>
								</tr>
							</thead>
							<tbody class="ticket-tbody">
								
							</tbody>
						</table>
					</div>




					

				</div>
			</div>

		</div>
		<!-- changable place -->
		<!-- Modal -->
		<div id="modalSale" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="modalEditLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
					<h5 id="myModalLabel">购票</h5>
				</div>
				<div class="modal-body">
					<ul class="nav nav-tabs" data-trigger="tab">
						<li><a href="#infoconfirm" class="info-tab">信息确认</a></li>
						<li><a href="#ticket" class="ticket-tab">票券</a></li>
						<li><a href="#pay" class="pay-tab">支付</a></li>
						<li><a href="#seats" class="seats-tab">座位</a></li>
					</ul>
					<div class="pane-wrapper slide clearfix">
						<div class="modal-tab-page">
							<div class="row-line" style="display:none;">
								<div class="row-label">计划ID:</div>
								<div class="span3 row-content">
									<div class="text-shown planid-shown"></div>
								</div>
							</div>
							<div class="row-line">
								<div class="row-label">影片:</div>
								<div class="span3 row-content">
									<div class="text-shown film-shown"></div>
								</div>
							</div>
							<div class="row-line">
								<div class="row-label">厅号:</div>
								<div class="span3 row-content">
									<div class="text-shown hall-shown"></div>
								</div>
							</div> 
							<div class="row-line">
								<div class="row-label">剩余座位数:</div>
								<div class="form-group has-success row-content">
									<div class="text-shown seat-shown"></div>
								</div>
							</div>
							<div class="row-line">
								<div class="row-label">价格:</div>
								<div class="form-group has-success row-content">
									<div class="text-shown price-shown"></div>
								</div>
							</div> 
							<div class="row-line">
								<div class="row-label">时间:</div>
								<div class="form-group has-success row-content">
									<div class="text-shown time-shown"></div>
								</div>
							</div> 
							<div class="row-line">

								<div class="form-group has-success row-content">
									<button class="btn btn-primary film-plan-confirm">下一步</button>
								</div>
							</div>
						</div>
						<div class="modal-tab-page">
							<div class="row-line">
								<div class="row-label">购票数:</div>
								<div class="form-group has-success row-content">
									<input class="form-control seatnum-input" type="number" placeholder="seats" min="1" value='1'/>
								</div>
							</div>
							<div class="row-line">

								<div class="form-group has-success row-content">
									<button class="btn btn-primary ticket-confirm" target="vipticketCheck">next step</button>
								</div>
							</div>
						</div>
						<div class="modal-tab-page">
							<div class="row-line">
								<div class="row-label">账单:</div>
								<div class="form-group has-success row-content">
									<div class="text-shown bill-shown"></div>
								</div>
							</div>
							<div class="row-line">
								<div class="row-label">支付方式:</div>
								<div class="span3 row-content">
									<select class="form-control select select-primary select-block mbl payway-input">
										<option value="2">vipcard</option>
										<option value="1">bankcard</option>
									</select>
								</div>
							</div>
							<div class="bank-box account-box">
								<div class="row-line">
									<div class="row-label">bankNo:</div>
									<div class="span3 row-content">
										<input class="form-control bank-no-input" type="number" placeholder="Sum" />
									</div>
								</div> 
								<div class="row-line">
									<div class="row-label">bankPassword:</div>
									<div class="span3 row-content">
										<input class="form-control bank-password-input" type="password" placeholder="id" />
									</div>
								</div> 
							</div>
							<div class="row-line">

								<div class="form-group has-success row-content">
									<button class="btn btn-primary ticket-finish-button" target="vipticketPay">finish</button>
								</div>
							</div>
						</div>
						<div class="modal-tab-page">
							<div class="row-line">
								<div class="row-label">座位:</div>
								<div class="span3 row-content">
									<div class="text-shown seats-shown"></div>
								</div>
							</div>
							<div class="row-line">

								<div class="form-group has-success row-content">
									<button class="btn btn-primary sale-close-button">确认</button>
								</div>
							</div>
						</div>
					</div>

				</div>
				<div class="modal-footer">
					<button class="btn" data-dismiss="modal" aria-hidden="true">关闭</button>
				</div>
			</div>
		</div>


</body>
<script src="./Public/jquery/jquery.min.js"></script>
<script src="./Public/jquery/jquery.md5.js"></script>
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
<script src="./Public/js/server/server.js"></script>
<script src="./Public/js/vip/vipticket.js"></script>
</html>