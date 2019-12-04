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
 * Provides a wrapper for {@link profileImageLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see profileImageLocalService
 * @generated
 */
@ProviderType
public class profileImageLocalServiceWrapper
	implements profileImageLocalService,
			   ServiceWrapper<profileImageLocalService> {

	public profileImageLocalServiceWrapper(
		profileImageLocalService profileImageLocalService) {

		_profileImageLocalService = profileImageLocalService;
	}

	/**
	 * Adds the profile image to the database. Also notifies the appropriate model listeners.
	 *
	 * @param profileImage the profile image
	 * @return the profile image that was added
	 */
	@Override
	public basic.model.profileImage addprofileImage(
		basic.model.profileImage profileImage) {

		return _profileImageLocalService.addprofileImage(profileImage);
	}

	/**
	 * Creates a new profile image with the primary key. Does not add the profile image to the database.
	 *
	 * @param id the primary key for the new profile image
	 * @return the new profile image
	 */
	@Override
	public basic.model.profileImage createprofileImage(long id) {
		return _profileImageLocalService.createprofileImage(id);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _profileImageLocalService.deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the profile image with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the profile image
	 * @return the profile image that was removed
	 * @throws PortalException if a profile image with the primary key could not be found
	 */
	@Override
	public basic.model.profileImage deleteprofileImage(long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _profileImageLocalService.deleteprofileImage(id);
	}

	/**
	 * Deletes the profile image from the database. Also notifies the appropriate model listeners.
	 *
	 * @param profileImage the profile image
	 * @return the profile image that was removed
	 */
	@Override
	public basic.model.profileImage deleteprofileImage(
		basic.model.profileImage profileImage) {

		return _profileImageLocalService.deleteprofileImage(profileImage);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _profileImageLocalService.dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _profileImageLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>basic.model.impl.profileImageModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _profileImageLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>basic.model.impl.profileImageModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _profileImageLocalService.dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _profileImageLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return _profileImageLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public basic.model.profileImage fetchprofileImage(long id) {
		return _profileImageLocalService.fetchprofileImage(id);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _profileImageLocalService.getActionableDynamicQuery();
	}

	@Override
	public basic.model.profileImageImageBlobModel getImageBlobModel(
		java.io.Serializable primaryKey) {

		return _profileImageLocalService.getImageBlobModel(primaryKey);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _profileImageLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _profileImageLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _profileImageLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the profile image with the primary key.
	 *
	 * @param id the primary key of the profile image
	 * @return the profile image
	 * @throws PortalException if a profile image with the primary key could not be found
	 */
	@Override
	public basic.model.profileImage getprofileImage(long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _profileImageLocalService.getprofileImage(id);
	}

	/**
	 * Returns a range of all the profile images.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>basic.model.impl.profileImageModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of profile images
	 * @param end the upper bound of the range of profile images (not inclusive)
	 * @return the range of profile images
	 */
	@Override
	public java.util.List<basic.model.profileImage> getprofileImages(
		int start, int end) {

		return _profileImageLocalService.getprofileImages(start, end);
	}

	/**
	 * Returns the number of profile images.
	 *
	 * @return the number of profile images
	 */
	@Override
	public int getprofileImagesCount() {
		return _profileImageLocalService.getprofileImagesCount();
	}

	/**
	 * Updates the profile image in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param profileImage the profile image
	 * @return the profile image that was updated
	 */
	@Override
	public basic.model.profileImage updateprofileImage(
		basic.model.profileImage profileImage) {

		return _profileImageLocalService.updateprofileImage(profileImage);
	}

	@Override
	public profileImageLocalService getWrappedService() {
		return _profileImageLocalService;
	}

	@Override
	public void setWrappedService(
		profileImageLocalService profileImageLocalService) {

		_profileImageLocalService = profileImageLocalService;
	}

	private profileImageLocalService _profileImageLocalService;

}