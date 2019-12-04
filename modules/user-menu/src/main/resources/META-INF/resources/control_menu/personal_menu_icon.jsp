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

<%@ include file="/init.jsp" %>
<%@page import="com.liferay.portal.kernel.model.Role"%>
<%@page import="com.liferay.portal.kernel.service.UserLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.model.User"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.service.RoleLocalServiceUtil"%>
<style type="text/css">
/* .dropdown-menu-personal-menu ul li:not(a),
.dropdown-menu-personal-menu ul li :not(a[href^="/c/portal/logout"])  :not(last-child)  */
.dropdown-menu-personal-menu ul li a,
.dropdown-menu-personal-menu ul li.dropdown-divider {
	display: none;
}
<%
User userU = themeDisplay.getUser(); 
List<Role> l = userU.getRoles(); // jibit listit roles tab3oulou
for (Role lr : l)
{
System.out.println("---lr.getDescriptionCurrentValue()----: " + lr.getDescriptionCurrentValue());
System.out.println("---result----: " + lr.getDescriptionCurrentValue()!= null && (lr.getDescriptionCurrentValue().toLowerCase().contains("admin") || lr.getDescriptionCurrentValue().toLowerCase().contains("eventeditor")));

if(lr.getDescriptionCurrentValue()!= null && (lr.getDescriptionCurrentValue().toLowerCase().contains("admin") || lr.getDescriptionCurrentValue().toLowerCase().contains("eventeditor")) ) // iza fchhiem roale aaaaaamin rolet hiyi admin ma lezim ychuf landing iza logged infhmetaaa
{  %>
.dropdown-menu-personal-menu ul li > a[href*="/c/portal/logout"],
.dropdown-menu-personal-menu ul li a[href*="notifications"],
.dropdown-menu-personal-menu ul li a[href*="profile"] {
	display: list-item;
}

<%
continue;
} else{ %>
.dropdown-menu-personal-menu ul li > a[href*="/c/portal/logout"],
.dropdown-menu-personal-menu ul li a[href*="profile"] {
	display: list-item;
}
span.badge.badge-danger.panel-notifications-count {
    display: none;
}
<%}
}%>
	#impersonate-user-icon {
		color: #272833;
	}

	#impersonate-user-icon .lexicon-icon {
		margin-top: -.125rem;
	}

	#impersonate-user-sticker {
		bottom: -.4rem;
		font-size: .6rem;
		height: 1.2rem;
		right: -0.4rem;
		width: 1.2rem;
	}

	#personal-menu-icon-wrapper .lexicon-icon {
		margin-top: -.25rem;
	}
</style>

<li class="control-menu-nav-item">
	<span class="user-avatar-link">
		<liferay-util:buffer
			var="userAvatar"
		>
			<span class="sticker">
				<span class="inline-item" id="personal-menu-icon-wrapper">
					<liferay-ui:user-portrait
						user="<%=user %>"
					/>
				</span>

				<c:if test="<%=themeDisplay.isImpersonated() %>">
				<% 
				
				System.out.println("themeDisplay.isImpersonated() : " + themeDisplay.isImpersonated() );
				System.out.println("themeDisplay.user() : " );
				%>
					<span class="sticker sticker-bottom-right sticker-circle sticker-outside sticker-user-icon" id="impersonate-user-sticker">
						<aui:icon id="impersonate-user-icon" image="user" markupView="lexicon" />
					</span>
				</c:if>
			</span>
		</liferay-util:buffer>

		<liferay-product-navigation:personal-menu
			expanded="<%= true %>"
			label="<%=userAvatar %>"
		/>

		<%
		int notificationsCount = GetterUtil.getInteger(request.getAttribute(PersonalMenuWebKeys.NOTIFICATIONS_COUNT));
		%>

		<c:if test="<%= notificationsCount > 0 %>">

			<%
			String notificationsURL = PersonalApplicationURLUtil.getPersonalApplicationURL(request, PortletProviderUtil.getPortletId(UserNotificationEvent.class.getName(), PortletProvider.Action.VIEW));
			%>

			<aui:a href="<%= (notificationsURL != null) ? notificationsURL : null %>">
				<span class="badge badge-danger panel-notifications-count">
					<span class="badge-item badge-item-expand"><%= notificationsCount %></span>
				</span>
			</aui:a>
		</c:if>
	</span>
</li>
<script>
	$(document).ready(function (){
		$('.control-menu-nav-item .personal-menu-dropdown').on('click',(function(){
			$('.dropdown-menu-personal-menu ul li:not(.dropdown-divider):last-child').parent().append(
			'<a class=" dropdown-item" href="/web/guest/profile">'
			+$('#navbarSupportedContent ul li a[href*="/web/guest/profile"] span').html()
			+"</a>");
		}));
	});
</script>