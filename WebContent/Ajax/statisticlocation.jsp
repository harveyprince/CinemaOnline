<%@ taglib prefix="s" uri="/struts-tags"%>
 [
 <s:iterator id="location" value="locationlistClient" status="st">
                ['<s:property value="#location.location.strdescribe"/>',   <s:property value="#location.personsum"/>]
 <s:if test="%{!#st.last}">,</s:if>
</s:iterator>     
            ]