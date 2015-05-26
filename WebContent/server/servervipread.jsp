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
	<link rel="stylesheet" type="text/css" href="./Public/css/server/ServerVipRead.css">
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
						<li><a href="serverfilm"><i class="fa fa-film"></i>电影</a></li>
						<li><a href="ticketsale"><i class="fa fa-usd"></i>售票</a></li>
						<li class="active"><a href="#"><i class="fa fa-user"></i> VIP</a></li>
					</ul>
				</div>
			</div>
			<div class="user-button"><a href="logout"><i class="fa fa-sign-out"></i>退出</a></div>
		</div>
		<!-- left side bar//////////////////////////////////////////////////////////////////////////////// -->


		<!-- changable place -->

		<div class="bar-match-content">
			<div class="vip-search">
					<div class="input-group input-group-hg input-group-rounded">
						<span class="input-group-btn">
							<button type="submit" class="btn"><span class="fui-search"></span></button>
						</span>
						<input type="text" class="form-control vip-search-input" placeholder="Search" id="search-query-2" target="viewVipDetail">
					</div>
				</div>
				<div class="collapse-box">
		<s:if test="%{vipclientinfo!=null}">
			<div class="info-box">
				<a href="#" data-trigger="collapse" data-parent=".collapse-box" class="active">
					<div class="info-line">
					个人信息
				</div>
				</a>
				<div class="collapsible">
					<div class="info-line">姓名:<s:property value="vipclientinfo.name"/></div>
					<div class="info-line">用户ID:<s:property value="vipclientinfo.vipid"/></div>
					<div class="info-line">性别:<s:if test="%{vipclientinfo.sex==0}">girl</s:if><s:else>boy</s:else></div>
					<div class="info-line">生日:<s:property value="vipclientinfo.strbirthday"/></div>
				<div class="info-line">地区:<s:property value="vipclientinfo.location"/></div>
				<s:if test="%{vipcardinfo!=null}">
					<div class="info-line">VIP等级:<s:property value="vipcardinfo.vipLevel.lvName"/></div>
					<div class="info-line">积分:<s:property value="vipcardinfo.score"/></div>
					<div class="info-line">余额:<s:property value="vipcardinfo.balance"/></div>
				</s:if>
					<div class="info-line">vipstatus:<s:property value="vipclientinfo.strstatus"/></div>
			</div>
			</div>
			<div class="vipid" style="display:none;"><s:property value="ajaxinfo"/></div>
			<a href="#" data-trigger="collapse" data-parent=".collapse-box">
				<div class="info-line">收支详情</div>
			</a>
			<div class="collapsible" style="display: none">
			<div class="table-box">
				<div class="clearfix">
					<div class="pagination pagination-success page-button">
							<a href="#" class="btn btn-success previous">上一页</a>
							<a href="#" class="btn btn-success next">下一页</a>
						</div>
					<div class="tab-page">
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
							</tr>
						</thead>
						<tbody class="record-tbody">
						</tbody>
					</table>
				</div>

			</div>
		</div>
	</div>
</s:if>
</div>
	</div>
	<!-- changable place -->

</body>
<script src="./Public/jquery/jquery.min.js"></script>
<script src="./Public/dist/js/bootstrap.min.js"></script>
<script src="./Public/sco/js/sco.panes.js"></script>
<script src="./Public/sco/js/sco.tab.js"></script>
<script src="./Public/sco/js/sco.collapse.js"></script>
<script src="./Public/Flat-UI-master/dist/js/flat-ui.js"></script>
<script type="text/javascript">

</script>
<script src="./Public/js/server/server.js"></script>
<script src="./Public/js/server/serverVipRead.js"></script>
</html>