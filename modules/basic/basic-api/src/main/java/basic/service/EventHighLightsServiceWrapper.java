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
 * Provides a wrapper for {@link EventHighLightsService}.
 *
 * @author Brian Wing Shun Chan
 * @see EventHighLightsService
 * @generated
 */
@ProviderType
public class EventHighLightsServiceWrapper
	implements EventHighLightsService, ServiceWrapper<EventHighLightsService> {

	public EventHighLightsServiceWrapper(
		EventHighLightsService eventHighLightsService) {

		_eventHighLightsService = eventHighLightsService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _eventHighLightsService.getOSGiServiceIdentifier();
	}

	@Override
	public EventHighLightsService getWrappedService() {
		return _eventHighLightsService;
	}

	@Override
	public void setWrappedService(
		EventHighLightsService eventHighLightsService) {

		_eventHighLightsService = eventHighLightsService;
	}

	private EventHighLightsService _eventHighLightsService;

}