<%@ taglib prefix="s" uri="/struts-tags"%>
<div class="page-symbol" style="display:none;"><s:property value="page"/></div>
<s:iterator id="film" value="filmlist" status="st">
<s:if test="%{#film.status==0}">
<tr class="warning">
</s:if>
<s:if test="%{#film.status==1}">
<tr class="success">
</s:if>
<th class="filmId"><s:property value="#film.filmId"/></th>
<th class="filmName"><s:property value="#film.name"/></th>
<th class="duration"><s:property value="#film.duration"/></th>
<th class="kind"><s:property value="#film.kind"/></th>
<th class="releaseTime"><s:property value="#film.rtTime"/></th>
<th class="shelvesTime"><s:property value="#film.stTime"/></th>

<s:if test="%{#film.status==1}">
<th>
	<button class="btn btn-inverse table-button" disabled="disabled">
		<i class="fa fa-pencil-square-o"></i>
	</button>
</th>
<th>
	<button class="btn btn-inverse table-button film-unrelease-button film-eye-button" target="unreleasefilm">
		<i class="fa fa-eye"></i>
	</button>
</th>
<th>releasing</th>
</s:if>
<s:if test="%{#film.status==0}">
<th>
	<button class="btn btn-inverse table-button film-edit-button" data-toggle="modal" data-target="#modalEdit">
		<i class="fa fa-pencil-square-o"></i>
	</button>
</th>
<th>
	<button class="btn btn-inverse table-button film-release-button film-eye-button" target="releasefilm">
		<i class="fa fa-eye-slash"></i>
	</button>
</th>
<th>unreleased</th>
</s:if>
</tr>
</s:iterator>