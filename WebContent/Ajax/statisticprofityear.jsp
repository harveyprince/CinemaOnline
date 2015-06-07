<%@ taglib prefix="s" uri="/struts-tags"%>
 [
 <s:iterator id="profit" value="yearprofitlist" status="st">
                ['<s:property value="#profit.year"/>',   <s:property value="#profit.profitsum"/>]
 <s:if test="%{!#st.last}">,</s:if>
</s:iterator>     
            ]