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
 * Provides a wrapper for {@link profileEducationService}.
 *
 * @author Brian Wing Shun Chan
 * @see profileEducationService
 * @generated
 */
@ProviderType
public class profileEducationServiceWrapper
	implements profileEducationService,
			   ServiceWrapper<profileEducationService> {

	public profileEducationServiceWrapper(
		profileEducationService profileEducationService) {

		_profileEducationService = profileEducationService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _profileEducationService.getOSGiServiceIdentifier();
	}

	@Override
	public profileEducationService getWrappedService() {
		return _profileEducationService;
	}

	@Override
	public void setWrappedService(
		profileEducationService profileEducationService) {

		_profileEducationService = profileEducationService;
	}

	private profileEducationService _profileEducationService;

}