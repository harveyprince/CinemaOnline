<%@ taglib prefix="s" uri="/struts-tags"%>
<div class="page-symbol" style="display:none;"><s:property value="page"/></div>
<s:iterator id="plan" value="filmplanlist" status="st">
<s:if test="%{#plan.seatSum==0}">
<tr class="warning">
</s:if>
<s:else>
<tr class="success">
</s:else>
<th class="planId"><s:property value="#plan.planid"/></th>
<th class="filmName" filmId='<s:property value="#plan.filmid"/>'><s:property value="#plan.filmName"/></th>
<th class="hallNo" hallId='<s:property value="#plan.hall.hallNo"/>'><s:property value="#plan.hall.name"/></th>
<th class="seatLeft"><s:property value="#plan.seatSum"/></th>
<th class="beginTime" date-time='<s:property value="#plan.beginTtime"/>' data-toggle="tooltip" title='<s:property value="#plan.beginTtime"/>' data-placement="top"><s:property value="#plan.begindft"/></th>
<th class="endTime" date-time='<s:property value="#plan.endTtime"/>' data-toggle="tooltip" title='<s:property value="#plan.endTtime"/>' data-placement="top"><s:property value="#plan.enddft"/></th>
<th class="price"><s:property value="#plan.price"/></th>
<th>
	<button class="btn btn-inverse table-button ticket-sale-button" data-toggle="modal" data-target="#modalSale">
		<i class="fa fa-ticket"></i>
	</button>
</th>

</tr>
</s:iterator>