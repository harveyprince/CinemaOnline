<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
{
	data:[
<s:iterator id="filmProfitPlan" value="profitDispatchlist" status="st">
["<s:property value="#filmProfitPlan.film.name"/>",<s:property value="#filmProfitPlan.profitPercent"/>]
,
</s:iterator>
],
	film:[
<s:iterator id="filmProfitPlan" value="profitDispatchlist" status="st">
["<s:property value="#filmProfitPlan.film.name"/>",<s:property value="#filmProfitPlan.film.filmId"/>]
,
</s:iterator>
]
}

