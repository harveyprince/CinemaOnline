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
	<link rel="stylesheet" type="text/css" href="./Public/css/vip/vipinfo.css">
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
						<li class="active"><a href="#"><i class="fa fa-user"></i>个人信息</a></li>
						<li><a href="vipcard"><i class="fa fa-credit-card"></i>会员卡</a></li>
						<li><a href="viprecord"><i class="fa fa-tasks"></i>收支记录</a></li>
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
				
				<div class="clearfix info-box">
					<form action="infoUpate" id="info-form" onSubmit="return false;">
					<div class="info-line">id:
						<span><s:property value="vipinfo.vipid"/></span>
					</div>
					<div class="info-line">姓名:
						<span><s:property value="vipinfo.name"/></span>
						<div class="form-group row-content">
							<input class="form-control name-input" type="text" placeholder="name" name="name" required="required"/>
						</div>
					</div>
					
					<div class="info-line">性别:
						<span value='<s:property value="vipinfo.sex"/>'><s:if test="%{vipinfo.sex}">boy</s:if><s:else>girl</s:else></span>
						<div class="span3 row-content">
									<select class="form-control select select-primary select-block mbl sex-input" name="sex">
										<option value="0">girl</option>
										<option value="1">boy</option>
									</select>
								</div>
					</div>
					<div class="info-line">出生日期:
						<span><s:property value="vipinfo.strbirthday"/></span>
						<div class="form-group row-content">
							<input class="form-control birthday-input" type="date" placeholder="birthday" required="required" name="birthday"/>
						</div>
					</div>
					<div class="info-line">地区:
						<span  value='<s:property value="vipinfo.locationid"/>'><s:property value="vipinfo.location"/></span>
						<div class="span3 row-content">
									<select class="form-control select select-primary select-block mbl location-input" name="location">
										<s:iterator id="location" value="locationlist" status="st">
										<option value='<s:property value="#location.locationId"/>'><s:property value="#location.strdescribe"/></option>
									</s:iterator>
									</select>
								</div>
					</div>
					<button class="btn btn-primary btn-save">保存修改</button>
				</form>
				<button class="btn btn-primary btn-modify">修改信息</button>
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
<script src="./Public/sco/js/sco.message.js"></script>
<script src="./Public/Flat-UI-master/dist/js/flat-ui.js"></script>
<script type="text/javascript">

</script>
<script src="./Public/js/common/form.js"></script>
<script src="./Public/js/vip/vipinfo.js"></script>
</html>