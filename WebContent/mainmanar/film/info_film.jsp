<%@ taglib prefix="s" uri="/struts-tags"%>
<div class="page-symbol" style="display:none;"><s:property value="page"/></div>
<s:iterator id="film" value="oldfilmlist" status="st">
<th class="filmId"><s:property value="#film.filmId"/></th>
<th class="filmName"><s:property value="#film.name"/></th>
<th class="duration"><s:property value="#film.duration"/></th>
<th class="kind" value='<s:property value="#film.kind.typeId"/>'><s:property value="#film.kind.typename"/></th>
<th class="cost"><s:property value="#film.cost"/></th>
</tr>
</s:iterator>