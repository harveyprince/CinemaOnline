<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset='utf-8' />
<link href='./Public/fullcalendar-2.3.1/fullcalendar.css' rel='stylesheet' />
<link href='./Public/fullcalendar-2.3.1/fullcalendar.print.css' rel='stylesheet' media='print' />
<link rel="stylesheet" type="text/css" href="./Public/dist/css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="./Public/font-awesome-4.2.0/css/font-awesome.min.css">
	<link rel="stylesheet" type="text/css" href="./Public/Flat-UI-master/dist/css/flat-ui.min.css">
	<link rel="stylesheet" type="text/css" href="./Public/css/common/user-sidebar.css">
	<link rel="stylesheet" type="text/css" href="./Public/css/server/ServerPage.css">
	<link rel="stylesheet" type="text/css" href="./Public/sco/css/scojs.css">
	<link rel="stylesheet" type="text/css" href="./Public/sco/css/sco.message.css">
<link href='./Public/css/server/ServerCalender.css' rel='stylesheet'/>
<style>

	body {
		margin-top: 40px;
		text-align: center;
		font-size: 14px;
		font-family: "Lucida Grande",Helvetica,Arial,Verdana,sans-serif;
	}
		
	#wrap {
		width: 1100px;
		margin: 0 auto;
	}
		
	#external-events {
		float: left;
		width: 150px;
		padding: 0 10px;
		border: 1px solid #ccc;
		background: #eee;
		text-align: left;
	}
		
	#external-events h4 {
		font-size: 16px;
		margin-top: 0;
		padding-top: 1em;
	}
		
	#external-events .fc-event {
		margin: 10px 0;
		cursor: pointer;
	}
		
	#external-events p {
		margin: 1.5em 0;
		font-size: 11px;
		color: #666;
	}
		
	#external-events p input {
		margin: 0;
		vertical-align: middle;
	}

	#calendar {
		float: right;
		width: 900px;
	}

</style>
</head>
<body>
	<div id='wrap'>

		<div id='external-events'>
			<div class="submit-panel">
				<button class="btn btn-primary click">提交安排</button>
			</div>
			<h4>待安排</h4>
			<div class="event-block">
				<s:iterator id="event" value="calenderlist" status="st">
				<div class='fc-event'><s:property value="#event.film.filmId"/>:<s:property value="#event.film.name"/></div>
				</s:iterator>
			</div>
		</div>
		

		<div id='calendar'></div>

		<div style='clear:both'></div>

	</div>
</body>
<script src='./Public/fullcalendar-2.3.1/lib/moment.min.js'></script>
<script src='./Public/fullcalendar-2.3.1/lib/jquery.min.js'></script>
<script src='./Public/fullcalendar-2.3.1/lib/jquery-ui.custom.min.js'></script>
<script src='./Public/fullcalendar-2.3.1/fullcalendar.min.js'></script>
<script src='./Public/fullcalendar-2.3.1//lang-all.js'></script>
<script src="./Public/dist/js/bootstrap.min.js"></script>
<script src="./Public/sco/js/sco.panes.js"></script>
<script src="./Public/sco/js/sco.tab.js"></script>
<script src="./Public/sco/js/sco.message.js"></script>
<script src="./Public/Flat-UI-master/dist/js/flat-ui.js"></script>
<script src="./Public/js/common/date.js"></script>
<script src="./Public/js/common/form.js"></script>
<script src="./Public/js/server/server.js"></script>
<script>
	datenow = ${date};
	hallNo = ${hid};
	$(document).ready(function() {


		/* initialize the external events
		-----------------------------------------------------------------*/

		$('#external-events .fc-event').each(function() {

			// store data so the calendar knows to render an event upon drop
			$(this).data('event', {
				title: $.trim($(this).text()), // use the element's text as the event title
				stick: true // maintain when user navigates (see docs on the renderEvent method)
			});

			// make the event draggable using jQuery UI
			$(this).draggable({
				zIndex: 999,
				revert: true,      // will cause the event to go back to its
				revertDuration: 0  //  original position after the drag
			});

		});


		/* initialize the calendar
		-----------------------------------------------------------------*/

		cal = $('#calendar').fullCalendar({
			header: false,
			defaultDate: '<s:property value="%{formatDate(date)}"/>',
			lang: "zh-cn",
			editable: true,
			droppable: true, // this allows things to be dropped onto the calendar
			defaultView:'agendaDay',
			drop: function() {
				// is the "remove after drop" checkbox checked?
					// if so, remove the element from the "Draggable Events" list
					$(this).remove();
				
			}
		});
		$(".click").click(function(){
			// start end
			if($.trim($(".event-block").html())==""){
				var data = new FormData();
				var eventlist = $('#calendar').fullCalendar("clientEvents");
				for(var idx in eventlist){
					var temp = eventlist[idx];
					var evenstart = temp.start;
					var title = temp.title;
					var titlearray = title.split(":");
					var filmId = titlearray[0];
					data.append("calenderClientlist["+idx+"].filmId",filmId);
					data.append("calenderClientlist["+idx+"].start",datenow+evenstart.time().asMilliseconds());
					data.append("calenderClientlist["+idx+"].hallNo",hallNo);
				}
				var action = "calenderEventSubmit";
				$.ajax({
					data: data,
					type: "POST",
					url: action,
					cache: false,
					contentType: false,
					processData: false,
					success: function(data) {
						if(data=="success"){
							$.scojs_message('提交成功', $.scojs_message.TYPE_OK);
						}else{
							$.scojs_message(data, $.scojs_message.TYPE_ERROR);
						}
					},
					error:function(){
						$.scojs_message('error occured!', $.scojs_message.TYPE_ERROR);
					}
				});
			}else{
				$.scojs_message('没有进行完全分配!', $.scojs_message.TYPE_ERROR);
			}

		});
		


	});

</script>
</html>
