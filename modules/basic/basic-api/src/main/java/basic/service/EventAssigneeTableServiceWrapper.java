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

package basic.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides a wrapper for {@link EventAssigneeTableService}.
 *
 * @author Brian Wing Shun Chan
 * @see EventAssigneeTableService
 * @generated
 */
@ProviderType
public class EventAssigneeTableServiceWrapper
	implements EventAssigneeTableService,
			   ServiceWrapper<EventAssigneeTableService> {

	public EventAssigneeTableServiceWrapper(
		EventAssigneeTableService eventAssigneeTableService) {

		_eventAssigneeTableService = eventAssigneeTableService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _eventAssigneeTableService.getOSGiServiceIdentifier();
	}

	@Override
	public EventAssigneeTableService getWrappedService() {
		return _eventAssigneeTableService;
	}

	@Override
	public void setWrappedService(
		EventAssigneeTableService eventAssigneeTableService) {

		_eventAssigneeTableService = eventAssigneeTableService;
	}

	private EventAssigneeTableService _eventAssigneeTableService;

}