<%@ taglib prefix="s" uri="/struts-tags"%>
{
	card:[
                ['normal',   <s:property value="cardClient.status_1_sum"/>],
                ['stop',       <s:property value="cardClient.status_4_sum"/>],
                ['pause',    <s:property value="cardClient.status_2_sum"/>],
                ['cancelw',     <s:property value="cardClient.status_5_sum"/>],
            ],
	consume:<s:property value="cardClient.consume_sum"/>,
	activity:<s:property value="cardClient.activity_participate_sum"/>
}
 