<%@ taglib prefix="s" uri="/struts-tags"%>
<div class="page-symbol" style="display:none;"><s:property value="page"/></div>
<s:iterator id="film" value="filmlist" status="st">
<th class="filmId"><s:property value="#film.filmId"/></th>
<th class="filmName"><s:property value="#film.name"/></th>
<th class="duration"><s:property value="#film.duration"/></th>
<th class="kind"><s:property value="#film.kind"/></th>
<th class="cost"><s:property value="#film.cost"/></th>
<th>
	<button class="btn btn-inverse table-button film-edit-button" data-toggle="modal" data-target="#modalEdit">
		<i class="fa fa-pencil-square-o"></i>
	</button>
</th>
<th>
	<button class="btn btn-inverse table-button film-release-button film-eye-button" target="releasefilm">
		<i class="fa fa-arrow-up"></i>
	</button>
</th>
</tr>
</s:iterator>