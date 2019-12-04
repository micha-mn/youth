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
 * Provides a wrapper for {@link profileWorkExperienceService}.
 *
 * @author Brian Wing Shun Chan
 * @see profileWorkExperienceService
 * @generated
 */
@ProviderType
public class profileWorkExperienceServiceWrapper
	implements profileWorkExperienceService,
			   ServiceWrapper<profileWorkExperienceService> {

	public profileWorkExperienceServiceWrapper(
		profileWorkExperienceService profileWorkExperienceService) {

		_profileWorkExperienceService = profileWorkExperienceService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _profileWorkExperienceService.getOSGiServiceIdentifier();
	}

	@Override
	public profileWorkExperienceService getWrappedService() {
		return _profileWorkExperienceService;
	}

	@Override
	public void setWrappedService(
		profileWorkExperienceService profileWorkExperienceService) {

		_profileWorkExperienceService = profileWorkExperienceService;
	}

	private profileWorkExperienceService _profileWorkExperienceService;

}