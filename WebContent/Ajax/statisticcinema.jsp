<%@ taglib prefix="s" uri="/struts-tags"%>
 {
 	film_x:[
 	<s:iterator id="film" value="cinemaClient.filmAttendencelist" status="fst">
 	'<s:property value="#film.film.name"/>'
 	<s:if test="%{!#fst.last}">,</s:if>
	</s:iterator>
 	],
 	film_y:[
 	<s:iterator id="film" value="cinemaClient.filmAttendencelist" status="fst">
 	<s:property value="#film.attendence"/>
 	<s:if test="%{!#fst.last}">,</s:if>
	</s:iterator>
 	],
 	type_x:[
 	<s:iterator id="film" value="cinemaClient.typeAttendencelist" status="fst">
 	'<s:property value="#film.filmType.typename"/>'
 	<s:if test="%{!#fst.last}">,</s:if>
	</s:iterator>
 	],
 	type_y:[
 	<s:iterator id="film" value="cinemaClient.typeAttendencelist" status="fst">
 	<s:property value="#film.attendence"/>
 	<s:if test="%{!#fst.last}">,</s:if>
	</s:iterator>
 	],
 	hall_x:[
 	<s:iterator id="hall" value="cinemaClient.hallAttendencelist" status="fst">
 	'<s:property value="#hall.hall.name"/>'
 	<s:if test="%{!#fst.last}">,</s:if>
	</s:iterator>
 	],
 	hall_y:[
 	<s:iterator id="hall" value="cinemaClient.hallAttendencelist" status="fst">
 	<s:property value="#hall.attendence"/>
 	<s:if test="%{!#fst.last}">,</s:if>
	</s:iterator>
 	]

}