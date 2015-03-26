<%@ taglib prefix="s" uri="/struts-tags"%>
<div class="page-symbol" style="display:none;"><s:property value="page"/></div>
<s:iterator id="activity" value="activitylist" status="st">
<s:if test="%{#activity.status==0}">
<tr class="info">
</s:if>
<s:if test="%{#activity.status==1}">
<tr class="active">
</s:if>
<th class="activityId"><s:property value="#activity.activityId"/></th>
<th class="activityName"><s:property value="#activity.title"/></th>
<s:if test="%{#activity.status==0}">
<th>
	<button class="btn btn-inverse table-button film-edit-button" data-toggle="modal" data-target="#modalEdit">
		<i class="fa fa-pencil-square-o"></i>
	</button>
</th>
<th>
	<button class="btn btn-inverse table-button act-publish-button" target="actpublish">
		<i class="fa fa-arrow-up"></i>
	</button>
</th>
</s:if>
<s:if test="%{#activity.status==1}">
<th>
	<button class="btn btn-inverse table-button" disabled="disabled">
		<i class="fa fa-pencil-square-o"></i>
	</button>
</th>
<th>
	<button class="btn btn-inverse table-button" disabled="disabled">
		<i class="fa fa-arrow-up"></i>
	</button>
</th>
</s:if>
<th>
	<button class="btn btn-inverse table-button participated-button" data-toggle="modal" data-target="#modalParticipated">
		<i class="fa fa-pencil-square-o"></i>
	</button>
</th>
<th class="activity-answers" style="display:none;">
	<s:if test="%{#activity.status==1}">
	<s:iterator id="answer" value="#activity.answerlist" status="ast">
	<li value='<s:property value="#answer.answerId"/>'><s:property value="#answer.answerContent"/>[<s:property value="#answer.activityRecords.size()"/>]</li>
</s:iterator>
</s:if>
<s:else>
<s:iterator id="answer" value="#activity.answerlist" status="sti">
<li value='<s:property value="#answer.answerId"/>'><s:property value="#answer.answerContent"/></li>
</s:iterator>
</s:else>
</th>
<th class="activity-plans" style="display:none;">
	<s:iterator id="plan" value="#activity.plans" status="stp">
	<li value='<s:property value="#plan.planId"/>'><s:property value="#plan.planId"/></li>
</s:iterator>
</th>
<s:if test="%{#activity.status==0}">
<th>unsubmited</th>
</s:if>
<s:if test="%{#activity.status==1}">
<th>submited</th>
</s:if>
</tr>
</s:iterator>