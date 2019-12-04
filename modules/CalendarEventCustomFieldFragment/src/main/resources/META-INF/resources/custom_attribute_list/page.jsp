<%--
/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */
--%>

<%@ include file="/custom_attribute_list/init.jsp" %>

<%
String className = (String)request.getAttribute("liferay-expando:custom-attribute-list:className");
long classPK = GetterUtil.getLong((String)request.getAttribute("liferay-expando:custom-attribute-list:classPK"));
boolean editable = GetterUtil.getBoolean((String)request.getAttribute("liferay-expando:custom-attribute-list:editable"));
String ignoreAttributeNames = GetterUtil.getString((String)request.getAttribute("liferay-expando:custom-attribute-list:ignoreAttributeNames"));
boolean label = GetterUtil.getBoolean((String)request.getAttribute("liferay-expando:custom-attribute-list:label"));

ExpandoBridge expandoBridge = ExpandoBridgeFactoryUtil.getExpandoBridge(company.getCompanyId(), className, classPK);

String modelResourceName = ResourceActionsUtil.getModelResource(request, className);

List<String> attributeNames = ListUtil.remove(Collections.list(expandoBridge.getAttributeNames()), ListUtil.fromString(ignoreAttributeNames, StringPool.COMMA));

//custom code for field order start
if("com.liferay.calendar.model.CalendarBooking".equals(className)){
	//remove the old order
	attributeNames.remove("Location link");
	attributeNames.remove("Event Types");
	attributeNames.remove("show on landing");
	//add the new ordering
	attributeNames.add("Location link");
	attributeNames.add("Event Types");
	attributeNames.add("show on landing");
}
//custom code for field order end
%>

<div class="taglib-custom-attributes-list">

	<%
	for (String attributeName : attributeNames) {
		System.out.println("custom field name: "+attributeName);
		System.out.println("className : "+className);
	%>

		<liferay-expando:custom-attribute
			className="<%= className %>"
			classPK="<%= classPK %>"
			editable="<%= editable %>"
			label="<%= label %>"
			name="<%= attributeName %>"
		/>

	<%
	}
	%>

	<c:if test="<%= attributeNames.isEmpty() %>">
		<span class="field">
			<span class="field-content">
				<label>
					<liferay-ui:message arguments="<%= modelResourceName %>" key="no-custom-fields-are-defined-for-x" translateArguments="<%= false %>" />
				</label>
			</span>
		</span>
	</c:if>
</div>