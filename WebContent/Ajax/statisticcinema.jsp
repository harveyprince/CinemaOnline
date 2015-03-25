<%@ taglib prefix="s" uri="/struts-tags"%>
 {
 	personmonth:<s:property value="cinemaClient.cinemapersonsum_month"/>,
 	personday_y:[
 	<s:iterator id="day" value="cinemaClient.cinemapersonsum_daylist" status="dst">
 	<s:property value="#day.personsum"/>
 	<s:if test="%{!#dst.last}">,</s:if>
	</s:iterator>
 	],
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
 	],
 	payway: [
 <s:iterator id="payway" value="cinemaClient.paywaylist" status="fst">
                ['<s:property value="#payway.strpayway"/>',   <s:property value="#payway.sum"/>]
 <s:if test="%{!#fst.last}">,</s:if>
</s:iterator>     
            ]

}