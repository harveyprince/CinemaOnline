<%@ taglib prefix="s" uri="/struts-tags"%>
<div class="page-symbol" style="display:none;"><s:property value="page"/></div>
<s:iterator id="activity" value="ended_activitylist" status="st">
<tr class="active">
	<th class="activityId"><s:property value="#activity.activityId"/></th>
	<th class="activityName"><s:property value="#activity.title"/></th>
	<th>
		<button class="btn btn-inverse table-button participated-button" data-toggle="modal" data-target="#modalParticipated">
			<i class="fa fa-pencil-square-o"></i>
		</button>
	</th>
	<th class="activity-answers" style="display:none;">
		<s:iterator id="answer" value="#activity.answerlist" status="ast">
		<li value='<s:property value="#answer.answerId"/>'><s:property value="#answer.answerContent"/>[<s:property value="#answer.activityRecords.size()"/>]</li>
	</s:iterator>
</th>
</tr>
</s:iterator>