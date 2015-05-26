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
						<li><a href="vipinfo"><i class="fa fa-user"></i>vip info</a></li>
						<li class="active"><a href="#"><i class="fa fa-credit-card"></i>vip card</a></li>
						<li><a href="viprecord"><i class="fa fa-tasks"></i>vip record</a></li>
						<li><a href="vipticket"><i class="fa fa-trophy"></i>buy ticket</a></li>
					</ul>
				</div>
			</div>
			<div class="user-button"><a href="logout"><i class="fa fa-sign-out"></i>logout</a></div>
		</div>
		<!-- left side bar//////////////////////////////////////////////////////////////////////////////// -->


		<!-- changable place -->

		<div class="bar-match-content">
			<div class="table-box">
				
				<div class="clearfix info-box">
					<div class="info-line">cardID:
						<span><s:property value="cardinfo.vipid"/></span>
					</div>
					<div class="info-line">level:
						<span><s:property value="cardinfo.vipLevel.lvName"/></span>
					</div>
					<div class="info-line">status:
						<span><s:property value="vipinfo.strstatus"/></span>
					</div>
					<s:if test="%{vipinfo.status<4}">
					<div class="info-line">score:
						<span><s:property value="cardinfo.score"/></span>
					</div>
					<div class="info-line">balance:
						<span><s:property value="cardinfo.balance"/></span>
					</div>
				<button class="btn btn-primary btn-moneyin" data-toggle="modal" data-target="#modalMoney">money in</button>
				<button class="btn btn-primary btn-scoretrans" data-toggle="modal" data-target="#modalScoreTrans" style="margin-right:5px;">score trans</button>
				<button class="btn btn-danger btn-disactiveVip" data-toggle="modal" data-target="#modalDisactivate" style="margin-right:5px;">Disactive</button>
			</s:if>
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
				<form action="cardrecharge" id="pay-form" onSubmit="return false;">
				<div class="row-line">
					<div class="row-label">sum($):</div>
					<div class="form-group has-success row-content">
						<input class="form-control money-input" type="number" placeholder="sum" min="0" value="0" name="num"/>
					</div>
				</div>
				<div class="row-line">
					<div class="row-label">bankNo:</div>
					<div class="span3 row-content">
						<input class="form-control bank-no-input" type="text" placeholder="bankid" onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')" required="required" name="bankid"/>
					</div>
				</div> 
				<div class="row-line">
					<div class="row-label">bankPassword:</div>
					<div class="span3 row-content">
						<input class="form-control bank-password-input" type="password" placeholder="bankpassword" name="bankps"/>
					</div>
				</div> 
				<div class="row-line line-fix">
					<div class="span3 row-content">
						<button class="btn btn-primary pay-button">pay</button>
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

	<div id="modalScoreTrans" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="modalScoreTransLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
				<h5 id="myModalLabel">Score Translate[balance=score/100]</h5>
			</div>
			<div class="modal-body">
				<div class="row-line">
					<div class="row-label">score:</div>
					<div class="form-group has-success row-content">
						<input class="form-control score-input" type="number" placeholder="sum" min="100" value="100" name="score"/>
					</div>
				</div>
				<div class="row-line line-fix">
					<div class="span3 row-content">
						<button class="btn btn-primary scoretrans-button" target="scoreTranslate">translate</button>
					</div>
				</div> 
			</div>
			<div class="modal-footer">
				<button class="btn" data-dismiss="modal" aria-hidden="true">关闭</button>
			</div>
		</div>
	</div>

	<div id="modalDisactivate" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="modalDisactivateLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
				<h5 id="myModalLabel">Dangerous Operation</h5>
			</div>
			<div class="modal-body">
				<div class="row-line line-fix">
					<div class="span3 row-content" style="float:none;">
						<div class="row-label" style="font-size:20px;">Do you really want to disactivate your card?</div>
					</div>
				</div> 
			</div>
			<div class="modal-footer">
				<button class="btn" data-dismiss="modal" aria-hidden="true">关闭</button>
				<button class="btn btn-danger save-button" target="disactivateCard">Sure</button>
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

</script>
<script src="./Public/js/common/form.js"></script>
<script src="./Public/js/server/server.js"></script>
<script src="./Public/js/vip/vipcard.js"></script>
</html>