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
 * Provides a wrapper for {@link EventAttributesService}.
 *
 * @author Brian Wing Shun Chan
 * @see EventAttributesService
 * @generated
 */
@ProviderType
public class EventAttributesServiceWrapper
	implements EventAttributesService, ServiceWrapper<EventAttributesService> {

	public EventAttributesServiceWrapper(
		EventAttributesService eventAttributesService) {

		_eventAttributesService = eventAttributesService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _eventAttributesService.getOSGiServiceIdentifier();
	}

	@Override
	public EventAttributesService getWrappedService() {
		return _eventAttributesService;
	}

	@Override
	public void setWrappedService(
		EventAttributesService eventAttributesService) {

		_eventAttributesService = eventAttributesService;
	}

	private EventAttributesService _eventAttributesService;

}