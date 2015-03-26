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
<th class="filmName" filmId='<s:property value="#plan.filmid"/>'><s:property value="#plan.filmName"/></th>
<th class="hallNo" hallId='<s:property value="#plan.hall.hallNo"/>'><s:property value="#plan.hall.name"/></th>
<th class="seatSum"><s:property value="#plan.seatSum"/></th>
<th class="beginTime" date-time='<s:property value="#plan.beginTtime"/>' data-toggle="tooltip" data-placement="top" title='<s:property value="#plan.beginTtime"/>'><s:property value="#plan.begindft"/></th>
<th class="endTime" date-time='<s:property value="#plan.endTtime"/>' data-toggle="tooltip" data-placement="top" title='<s:property value="#plan.endTtime"/>'><s:property value="#plan.enddft"/></th>
<th class="price"><s:property value="#plan.price"/></th>
<th>
	<button class="btn btn-inverse table-button plan-pass-button plan-judge-button" target="planpass">
		<i class="fa fa-check"></i>
	</button>
</th>
<th>
	<button class="btn btn-inverse table-button plan-unpass-button plan-judge-button" target="planunpass">
		<i class="fa fa-times"></i>
	</button>
</th>
</tr>
</s:iterator>