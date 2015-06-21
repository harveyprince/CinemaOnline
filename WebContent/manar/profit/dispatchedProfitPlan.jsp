<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<div class="page-symbol" style="display:none;"><s:property value="page"/></div>
<s:iterator id="profitPlan" value="dispatchedProfitPlanlist" status="st">
<div class="well center-block">
	<div class="profit-block">
		<div class="profit-sum-block">
			<span>盈利计划总额：</span>
			<span><s:property value="#profitPlan.profitSum"/></span>
		</div>
		<div class="profit-film-block">
			<div>匹配影片：</div>
			<s:iterator id="filmProfitPlan" value="#profitPlan.filmProfitPlans" status="ft">
			<div class="block-film-item"><s:property value="#filmProfitPlan.film.name"/></div>
			</s:iterator>
			<a href="#right-panel" class="profit-dispatch-button right-panel-link-dispatch" planId='<s:property value="#profitPlan.profitPlanId"/>'>查看详细</a>
		</div>
	</div>
</div>
</s:iterator>