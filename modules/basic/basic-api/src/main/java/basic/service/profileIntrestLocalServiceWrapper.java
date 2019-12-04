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
 * Provides a wrapper for {@link profileIntrestLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see profileIntrestLocalService
 * @generated
 */
@ProviderType
public class profileIntrestLocalServiceWrapper
	implements profileIntrestLocalService,
			   ServiceWrapper<profileIntrestLocalService> {

	public profileIntrestLocalServiceWrapper(
		profileIntrestLocalService profileIntrestLocalService) {

		_profileIntrestLocalService = profileIntrestLocalService;
	}

	/**
	 * Adds the profile intrest to the database. Also notifies the appropriate model listeners.
	 *
	 * @param profileIntrest the profile intrest
	 * @return the profile intrest that was added
	 */
	@Override
	public basic.model.profileIntrest addprofileIntrest(
		basic.model.profileIntrest profileIntrest) {

		return _profileIntrestLocalService.addprofileIntrest(profileIntrest);
	}

	/**
	 * Creates a new profile intrest with the primary key. Does not add the profile intrest to the database.
	 *
	 * @param Id the primary key for the new profile intrest
	 * @return the new profile intrest
	 */
	@Override
	public basic.model.profileIntrest createprofileIntrest(long Id) {
		return _profileIntrestLocalService.createprofileIntrest(Id);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _profileIntrestLocalService.deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the profile intrest with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param Id the primary key of the profile intrest
	 * @return the profile intrest that was removed
	 * @throws PortalException if a profile intrest with the primary key could not be found
	 */
	@Override
	public basic.model.profileIntrest deleteprofileIntrest(long Id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _profileIntrestLocalService.deleteprofileIntrest(Id);
	}

	/**
	 * Deletes the profile intrest from the database. Also notifies the appropriate model listeners.
	 *
	 * @param profileIntrest the profile intrest
	 * @return the profile intrest that was removed
	 */
	@Override
	public basic.model.profileIntrest deleteprofileIntrest(
		basic.model.profileIntrest profileIntrest) {

		return _profileIntrestLocalService.deleteprofileIntrest(profileIntrest);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _profileIntrestLocalService.dynamicQuery();
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

		return _profileIntrestLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>basic.model.impl.profileIntrestModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

		return _profileIntrestLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>basic.model.impl.profileIntrestModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

		return _profileIntrestLocalService.dynamicQuery(
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

		return _profileIntrestLocalService.dynamicQueryCount(dynamicQuery);
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

		return _profileIntrestLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public basic.model.profileIntrest fetchprofileIntrest(long Id) {
		return _profileIntrestLocalService.fetchprofileIntrest(Id);
	}

	/**
	 * Returns the profile intrest matching the UUID and group.
	 *
	 * @param uuid the profile intrest's UUID
	 * @param groupId the primary key of the group
	 * @return the matching profile intrest, or <code>null</code> if a matching profile intrest could not be found
	 */
	@Override
	public basic.model.profileIntrest fetchprofileIntrestByUuidAndGroupId(
		String uuid, long groupId) {

		return _profileIntrestLocalService.fetchprofileIntrestByUuidAndGroupId(
			uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _profileIntrestLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _profileIntrestLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _profileIntrestLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _profileIntrestLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _profileIntrestLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the profile intrest with the primary key.
	 *
	 * @param Id the primary key of the profile intrest
	 * @return the profile intrest
	 * @throws PortalException if a profile intrest with the primary key could not be found
	 */
	@Override
	public basic.model.profileIntrest getprofileIntrest(long Id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _profileIntrestLocalService.getprofileIntrest(Id);
	}

	/**
	 * Returns the profile intrest matching the UUID and group.
	 *
	 * @param uuid the profile intrest's UUID
	 * @param groupId the primary key of the group
	 * @return the matching profile intrest
	 * @throws PortalException if a matching profile intrest could not be found
	 */
	@Override
	public basic.model.profileIntrest getprofileIntrestByUuidAndGroupId(
			String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _profileIntrestLocalService.getprofileIntrestByUuidAndGroupId(
			uuid, groupId);
	}

	/**
	 * Returns a range of all the profile intrests.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>basic.model.impl.profileIntrestModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of profile intrests
	 * @param end the upper bound of the range of profile intrests (not inclusive)
	 * @return the range of profile intrests
	 */
	@Override
	public java.util.List<basic.model.profileIntrest> getprofileIntrests(
		int start, int end) {

		return _profileIntrestLocalService.getprofileIntrests(start, end);
	}

	/**
	 * Returns all the profile intrests matching the UUID and company.
	 *
	 * @param uuid the UUID of the profile intrests
	 * @param companyId the primary key of the company
	 * @return the matching profile intrests, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<basic.model.profileIntrest>
		getprofileIntrestsByUuidAndCompanyId(String uuid, long companyId) {

		return _profileIntrestLocalService.getprofileIntrestsByUuidAndCompanyId(
			uuid, companyId);
	}

	/**
	 * Returns a range of profile intrests matching the UUID and company.
	 *
	 * @param uuid the UUID of the profile intrests
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of profile intrests
	 * @param end the upper bound of the range of profile intrests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching profile intrests, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<basic.model.profileIntrest>
		getprofileIntrestsByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<basic.model.profileIntrest> orderByComparator) {

		return _profileIntrestLocalService.getprofileIntrestsByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of profile intrests.
	 *
	 * @return the number of profile intrests
	 */
	@Override
	public int getprofileIntrestsCount() {
		return _profileIntrestLocalService.getprofileIntrestsCount();
	}

	/**
	 * Updates the profile intrest in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param profileIntrest the profile intrest
	 * @return the profile intrest that was updated
	 */
	@Override
	public basic.model.profileIntrest updateprofileIntrest(
		basic.model.profileIntrest profileIntrest) {

		return _profileIntrestLocalService.updateprofileIntrest(profileIntrest);
	}

	@Override
	public profileIntrestLocalService getWrappedService() {
		return _profileIntrestLocalService;
	}

	@Override
	public void setWrappedService(
		profileIntrestLocalService profileIntrestLocalService) {

		_profileIntrestLocalService = profileIntrestLocalService;
	}

	private profileIntrestLocalService _profileIntrestLocalService;

}