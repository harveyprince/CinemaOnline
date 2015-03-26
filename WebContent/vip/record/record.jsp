<%@ taglib prefix="s" uri="/struts-tags"%>
<div class="page-symbol" style="display:none;"><s:property value="page"/></div>
<s:iterator id="record" value="recordlist" status="st">
<s:if test="%{#record.result==0}">
<tr class="danger">
</s:if>
<s:if test="%{#record.result==1}">
<s:if test="%{#record.recordNumber>0}">
<tr class="success">
</s:if>
<s:else>
<tr class="warning">
</s:else>
</s:if>
<th class="recordId"><s:property value="#record.recordId"/></th>
<th class="recordTime"><s:property value="#record.strrecordTime"/></th>
<th class="operanum"><s:property value="#record.recordNumber"/></th>
<th class="purpose"><s:property value="#record.purpose"/></th>
<th class="result"><s:property value="#record.strresult"/></th>
<th class="comment"><s:property value="#record.comment"/></th>
</tr>
</s:iterator>