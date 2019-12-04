<%@ include file="/init.jsp" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>

<p>
	<b><liferay-ui:message key="he2.caption"/></b>
</p>

<input type="button" onclick="callServeResource()" />

<portlet:defineObjects />   
<liferay-portlet:resourceURL var="resourceUrl111" >
	<liferay-portlet:param name="param1" value="Value1"/>
</liferay-portlet:resourceURL>
<input type="button" onclick="callServeResource()" >
<script>

function callServeResource()
{
	//var userId = obj.getAttribute("userid");
	debugger;
    AUI().use('aui-io-request', function(A){
        A.io.request('${resourceUrl111}', {
               method: 'post',
               data: {
            		   <portlet:namespace />command: ""
                     },
               on: {
                   	 success: function() 
                   	 {
                     // alert(this.get('responseData'));
                     alert("registered SUccessfuly");
                   }
              }
        });
 
    });
}

</script>

