<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta charset="UTF-8">
	<title>regist page</title>
	<link rel="stylesheet" type="text/css" href="./Public/dist/css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="./Public/font-awesome-4.2.0/css/font-awesome.min.css">
	<link rel="stylesheet" type="text/css" href="./Public/css/welcome/regist.css">
	<link rel="stylesheet" type="text/css" href="./Public/sco/css/scojs.css">
	<link rel="stylesheet" type="text/css" href="./Public/sco/css/sco.message.css">
	<link rel="stylesheet" type="text/css" href="./Public/Flat-UI-master/dist/css/flat-ui.min.css">
</head>
<body>
	<div class="regist-pane">
		<ul class="nav nav-tabs" data-trigger="tab">
			<li><a href="#info-tab" class="info-tab">info page</a></li>
			<li><a href="#password-tab" class="password-tab">second step</a></li>
			<li><a href="#result-tab" class="result-tab">third step</a></li>
		</ul>
		<div class="pane-wrapper slide">
			<div class="tab-page">
			<form action="" id="info-form" onSubmit="return false;">
				<div class="page-row">
					<div class="row-label">name:</div>
					<div class="form-group row-content">
						<input class="form-control name-input" type="text" placeholder="name" name="name" required="required"/>
					</div>
				</div>
				<div class="page-row">
					<div class="row-label">sex:</div>
					<div class="span3 row-content">
									<select class="form-control select select-primary select-block mbl sex-input" name="sex">
										<option value="0">girl</option>
										<option value="1">boy</option>
									</select>
								</div>
				</div>
				<div class="page-row">
					<div class="row-label">birthday:</div>
					<div class="form-group row-content">
						<input class="form-control birthday-input" type="date" placeholder="birthday" name="birthday" required="required"/>
					</div>
				</div>
				<div class="page-row">
					<div class="row-label">location:</div>
					<div class="span3 row-content">
									<select class="form-control select select-primary select-block mbl location-input" name="location">
										<s:iterator id="location" value="locationlist" status="st">
										<option value='<s:property value="#location.locationId"/>'><s:property value="#location.strdescribe"/></option>
									</s:iterator>
									</select>
								</div>
				</div>
				<div class="page-row">
					<div class="form-group row-content">
						<button class="btn btn-primary info-regist-button">next step</button>
					</div>
				</div>
				</form>
			</div>
			<div class="tab-page">
			<form action="signupAjax" id="pass-form" onSubmit="return false;">
				<div class="page-row">
					<div class="row-label">email:</div>
					<div class="form-group row-content">
						<input class="form-control email-input" type="email" placeholder="email" name="email" required="required"/>
					</div>
				</div>
				<div class="page-row">
					<div class="row-label">password:</div>
					<div class="form-group row-content">
						<input class="form-control password-input" type="password" placeholder="password" name="password" required="required"/>
					</div>
				</div>
				<div class="page-row">
					<div class="row-label">repeat:</div>
					<div class="form-group row-content">
						<input class="form-control password-confirm-input" type="password" placeholder="repeat" name="password-repeat" required="required"/>
					</div>
				</div>
				<div class="page-row">
					<div class="form-group row-content">
						<button class="btn btn-primary password-regist-button">next step</button>
					</div>
				</div>
				</form>
			</div>
			<div class="tab-page">
				<div class="page-row">
					<div class="regist-result-label">success</div>
				</div>
				<div class="page-row">
					<div class="form-group row-content">
						<button class="btn btn-primary result-regist-button">go ahead</button>
					</div>
				</div>
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
</script>
<script src="./Public/js/common/form.js"></script>
<script src="./Public/js/welcome/regist.js"></script>
</html>