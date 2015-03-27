<%@ taglib prefix="s" uri="/struts-tags"%>
<div class="page-symbol" style="display:none;"><s:property value="page"/></div>
<s:iterator id="activity" value="activitylist" status="st">
<s:if test="%{#activity.status=1}">
<tr class="success">
</s:if>
<s:if test="%{#activity.status=2}">
<tr class="active">
</s:if>
<th class="activityId"><s:property value="#activity.activityId"/></th>
<th class="activityName"><s:property value="#activity.title"/></th>
<th>
	<button class="btn btn-inverse table-button participated-button" data-toggle="modal" data-target="#modalParticipated">
		<i class="fa fa-eye"></i>
	</button>
</th>
<th class="activity-answers" style="display:none;">
	<s:iterator id="answer" value="#activity.answerlist" status="ast">
	<s:if test="%{#answer.answerId==activityrecordlist[#st.index].activityAnswer.answerId}">
	<li value='<s:property value="#answer.answerId"/>' choosen="choosen"><s:property value="#answer.answerContent"/>[<s:property value="#answer.activityRecords.size()"/>]</li>
</s:if>
<s:else>
<li value='<s:property value="#answer.answerId"/>'><s:property value="#answer.answerContent"/>[<s:property value="#answer.activityRecords.size()"/>]</li>
</s:else>
</s:iterator>
</th>
<s:if test="%{#activity.status=1}">
<th>participated</th>
</s:if>
<s:if test="%{#activity.status=2}">
<th>ended</th>
</s:if>
</tr>
</s:iterator>