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
						<li><a href="#"><i class="fa fa-pencil-square-o"></i>vip info</a></li>
						<li class="active"><a href="#"><i class="fa fa-film"></i>vip card</a></li>
						<li><a href="#"><i class="fa fa-dribbble"></i> vip record</a></li>
						<li><a href="#"><i class="fa fa-user"></i> vip activity</a></li>
					</ul>
				</div>
			</div>
		</div>
		<!-- left side bar//////////////////////////////////////////////////////////////////////////////// -->


		<!-- changable place -->

		<div class="bar-match-content">
			<div class="table-box">
				
				<div class="clearfix info-box">
					<div class="info-line" style="text-align: center;float:none;">your card is not activated
					</div>
				<button class="btn btn-primary btn-moneyin" data-toggle="modal" data-target="#modalMoney">activate</button>
				</div>

				


				<!-- /////////////////////////////////////////////////////// -->
				
			</div>
		</div>

	</div>
	<!-- changable place -->
	<!-- Modal -->
	<div id="modalMoney" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="modalMoneyLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
				<h5 id="myModalLabel">Money In</h5>
			</div>
			<div class="modal-body">
				<div class="row-line">
					<div class="row-label">sum($):</div>
					<div class="form-group has-success row-content">
						<input class="form-control money-input" type="number" placeholder="sum" min="200" value="200"/>
					</div>
				</div>
				<div class="row-line line-fix">
					<div class="span3 row-content">
						<button class="btn btn-primary moneyin-button">go ahead</button>
					</div>
				</div> 
				
					 
			</div>
			<div class="modal-footer">
				<button class="btn" data-dismiss="modal" aria-hidden="true">关闭</button>
				<button class="btn btn-primary save-button">Save changes</button>
			</div>
		</div>
	</div>
</div>
</body>
<script src="./Public/jquery/jquery.min.js"></script>
<script src="./Public/dist/js/bootstrap.min.js"></script>
<script src="./Public/sco/js/sco.panes.js"></script>
<script src="./Public/sco/js/sco.message.js"></script>
<script src="./Public/Flat-UI-master/dist/js/flat-ui.js"></script>
<script type="text/javascript">
$(".money-input").blur(function(){
	if(Number($(this).val())){
		if(Number($(this).val())>=200){
			//
		}else{
			$(this).val(200);
		}
	}else{
		$(this).val(200);
	}
});
</script>
<script src="./Public/js/common/form.js"></script>
<script src="./Public/js/vip/vipcard.js"></script>
</html>