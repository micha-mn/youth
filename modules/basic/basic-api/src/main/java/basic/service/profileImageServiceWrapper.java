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
 * Provides a wrapper for {@link profileImageService}.
 *
 * @author Brian Wing Shun Chan
 * @see profileImageService
 * @generated
 */
@ProviderType
public class profileImageServiceWrapper
	implements profileImageService, ServiceWrapper<profileImageService> {

	public profileImageServiceWrapper(profileImageService profileImageService) {
		_profileImageService = profileImageService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _profileImageService.getOSGiServiceIdentifier();
	}

	@Override
	public profileImageService getWrappedService() {
		return _profileImageService;
	}

	@Override
	public void setWrappedService(profileImageService profileImageService) {
		_profileImageService = profileImageService;
	}

	private profileImageService _profileImageService;

}