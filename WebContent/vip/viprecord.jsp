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
						<li><a href="vipinfo"><i class="fa fa-user"></i>个人信息</a></li>
						<li><a href="vipcard"><i class="fa fa-credit-card"></i>会员卡</a></li>
						<li class="active"><a href="#"><i class="fa fa-tasks"></i>收支记录</a></li>
						<li><a href="vipticket"><i class="fa fa-trophy"></i>购票</a></li>
					</ul>
				</div>
			</div>
			<div class="user-button"><a href="logout"><i class="fa fa-sign-out"></i>退出</a></div>
		</div>
		<!-- left side bar//////////////////////////////////////////////////////////////////////////////// -->


		<!-- changable place -->

		<div class="bar-match-content">
			<div class="table-box">
				
				<div class="clearfix">
					<div class="tab-page">
						<div class="pagination pagination-success page-button">
							<a href="#" class="btn btn-success previous">上一页</a>
							<a href="#" class="btn btn-success next">下一页</a>
						</div>
						<table class="table">
							<thead>
								<tr>
									<th>id</th>
									<th>时间</th>
									<th>收支数</th>
									<th>用途</th>
									<th>结果</th>
									<th>备注</th>
								</tr>
							</thead>
							<tbody class="record-tbody">
								
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
	<script src="./Public/js/vip/viprecord.js"></script>
	</html>