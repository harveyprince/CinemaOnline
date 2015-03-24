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
						<li><a href="manager"><i class="fa fa-pencil-square-o"></i>check Plan</a></li>
						<li class="active"><a href="#"><i class="fa fa-pencil-square-o"></i>statics</a></li>
					</ul>
				</div>
			</div>
		</div>
		<!-- left side bar//////////////////////////////////////////////////////////////////////////////// -->


		<!-- changable place -->

		<div class="bar-match-content">
			<div class="table-box">
				<div class="clearfix">

					<!-- /////////////////////////////////////////////////////// -->
					<div class="tab-page">
						<div class="time-choose">
							<div class="row-line">
								<div class="row-label">year:</div>
								<div class="span3 row-content">
									<select class="form-control select select-primary select-block mbl film-input" name="filmid">
										<option value="0">1994</option>
										<option value="1">1995</option>
										<option value="2">1996</option>
									</select>
								</div>
							</div>
							<div class="row-line">
								<div class="row-label">month:</div>
								<div class="span3 row-content">
									<select class="form-control select select-primary select-block mbl film-input" name="filmid">
										<option value="0">1994</option>
										<option value="1">1995</option>
										<option value="2">1996</option>
									</select>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>

		</div>
		<!-- changable place -->


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
	<script src="./Public/js/manager/statistic.js"></script>
	</html>