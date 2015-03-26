<%@ taglib prefix="s" uri="/struts-tags"%>
<div class="page-symbol" style="display:none;"><s:property value="page"/></div>
<s:iterator id="plan" value="filmplanlist" status="st">
<s:if test="%{#plan.status==0}">
<tr class="warning">
</s:if>
<s:if test="%{#plan.status==1}">
<tr class="active">
</s:if>
<s:if test="%{#plan.status==2}">
<tr class="success">
</s:if>
<s:if test="%{#plan.status==3}">
<tr class="danger">
</s:if>
<th class="planId"><s:property value="#plan.planid"/></th>
<th class="filmName" filmId='<s:property value="#plan.filmid"/>' filmDuration='<s:property value="#plan.film.duration"/>'><s:property value="#plan.filmName"/></th>
<th class="hallNo" hallId='<s:property value="#plan.hall.hallNo"/>'><s:property value="#plan.hall.name"/></th>
<th class="seatSum"><s:property value="#plan.seatSum"/></th>
<th class="beginTime" date-time='<s:property value="#plan.beginTtime"/>' data-toggle="tooltip" data-placement="top" title='<s:property value="#plan.beginTtime"/>'><s:property value="#plan.begindft"/></th>
<th class="endTime" date-time='<s:property value="#plan.endTtime"/>' data-toggle="tooltip" data-placement="top" title='<s:property value="#plan.endTtime"/>'><s:property value="#plan.enddft"/></th>
<th class="price"><s:property value="#plan.price"/></th>
<th>
	<s:if test="%{#plan.status==1||#plan.status==2}">
	<button class="btn btn-inverse table-button" disabled="disabled">
		<i class="fa fa-pencil-square-o"></i>
	</button>
</s:if>
<s:else>
<button class="btn btn-inverse table-button film-edit-button" data-toggle="modal" data-target="#modalEdit">
	<i class="fa fa-pencil-square-o"></i>
</button>
</s:else>
</th>
<th>
	<s:if test="%{#plan.status==1||#plan.status==2}">
	<button class="btn btn-inverse table-button" disabled="disabled">
		<i class="fa fa-arrow-up"></i>
	</button>
</s:if>
<s:else>
<button class="btn btn-inverse table-button submitforcheck-button" target="plansubmit">
	<i class="fa fa-arrow-up"></i>
</button>
</s:else>
</th>
<th><s:property value="#plan.strstatus"/></th>
</tr>
</s:iterator>