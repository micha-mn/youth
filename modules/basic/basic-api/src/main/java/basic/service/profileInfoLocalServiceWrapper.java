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
 * Provides a wrapper for {@link profileInfoLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see profileInfoLocalService
 * @generated
 */
@ProviderType
public class profileInfoLocalServiceWrapper
	implements profileInfoLocalService,
			   ServiceWrapper<profileInfoLocalService> {

	public profileInfoLocalServiceWrapper(
		profileInfoLocalService profileInfoLocalService) {

		_profileInfoLocalService = profileInfoLocalService;
	}

	/**
	 * Adds the profile info to the database. Also notifies the appropriate model listeners.
	 *
	 * @param profileInfo the profile info
	 * @return the profile info that was added
	 */
	@Override
	public basic.model.profileInfo addprofileInfo(
		basic.model.profileInfo profileInfo) {

		return _profileInfoLocalService.addprofileInfo(profileInfo);
	}

	/**
	 * Creates a new profile info with the primary key. Does not add the profile info to the database.
	 *
	 * @param id the primary key for the new profile info
	 * @return the new profile info
	 */
	@Override
	public basic.model.profileInfo createprofileInfo(long id) {
		return _profileInfoLocalService.createprofileInfo(id);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _profileInfoLocalService.deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the profile info with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the profile info
	 * @return the profile info that was removed
	 * @throws PortalException if a profile info with the primary key could not be found
	 */
	@Override
	public basic.model.profileInfo deleteprofileInfo(long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _profileInfoLocalService.deleteprofileInfo(id);
	}

	/**
	 * Deletes the profile info from the database. Also notifies the appropriate model listeners.
	 *
	 * @param profileInfo the profile info
	 * @return the profile info that was removed
	 */
	@Override
	public basic.model.profileInfo deleteprofileInfo(
		basic.model.profileInfo profileInfo) {

		return _profileInfoLocalService.deleteprofileInfo(profileInfo);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _profileInfoLocalService.dynamicQuery();
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

		return _profileInfoLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>basic.model.impl.profileInfoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

		return _profileInfoLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>basic.model.impl.profileInfoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

		return _profileInfoLocalService.dynamicQuery(
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

		return _profileInfoLocalService.dynamicQueryCount(dynamicQuery);
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

		return _profileInfoLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public basic.model.profileInfo fetchprofileInfo(long id) {
		return _profileInfoLocalService.fetchprofileInfo(id);
	}

	/**
	 * Returns the profile info matching the UUID and group.
	 *
	 * @param uuid the profile info's UUID
	 * @param groupId the primary key of the group
	 * @return the matching profile info, or <code>null</code> if a matching profile info could not be found
	 */
	@Override
	public basic.model.profileInfo fetchprofileInfoByUuidAndGroupId(
		String uuid, long groupId) {

		return _profileInfoLocalService.fetchprofileInfoByUuidAndGroupId(
			uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _profileInfoLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _profileInfoLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _profileInfoLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _profileInfoLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _profileInfoLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the profile info with the primary key.
	 *
	 * @param id the primary key of the profile info
	 * @return the profile info
	 * @throws PortalException if a profile info with the primary key could not be found
	 */
	@Override
	public basic.model.profileInfo getprofileInfo(long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _profileInfoLocalService.getprofileInfo(id);
	}

	/**
	 * Returns the profile info matching the UUID and group.
	 *
	 * @param uuid the profile info's UUID
	 * @param groupId the primary key of the group
	 * @return the matching profile info
	 * @throws PortalException if a matching profile info could not be found
	 */
	@Override
	public basic.model.profileInfo getprofileInfoByUuidAndGroupId(
			String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _profileInfoLocalService.getprofileInfoByUuidAndGroupId(
			uuid, groupId);
	}

	/**
	 * Returns a range of all the profile infos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>basic.model.impl.profileInfoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of profile infos
	 * @param end the upper bound of the range of profile infos (not inclusive)
	 * @return the range of profile infos
	 */
	@Override
	public java.util.List<basic.model.profileInfo> getprofileInfos(
		int start, int end) {

		return _profileInfoLocalService.getprofileInfos(start, end);
	}

	/**
	 * Returns all the profile infos matching the UUID and company.
	 *
	 * @param uuid the UUID of the profile infos
	 * @param companyId the primary key of the company
	 * @return the matching profile infos, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<basic.model.profileInfo>
		getprofileInfosByUuidAndCompanyId(String uuid, long companyId) {

		return _profileInfoLocalService.getprofileInfosByUuidAndCompanyId(
			uuid, companyId);
	}

	/**
	 * Returns a range of profile infos matching the UUID and company.
	 *
	 * @param uuid the UUID of the profile infos
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of profile infos
	 * @param end the upper bound of the range of profile infos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching profile infos, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<basic.model.profileInfo>
		getprofileInfosByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<basic.model.profileInfo> orderByComparator) {

		return _profileInfoLocalService.getprofileInfosByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of profile infos.
	 *
	 * @return the number of profile infos
	 */
	@Override
	public int getprofileInfosCount() {
		return _profileInfoLocalService.getprofileInfosCount();
	}

	/**
	 * Updates the profile info in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param profileInfo the profile info
	 * @return the profile info that was updated
	 */
	@Override
	public basic.model.profileInfo updateprofileInfo(
		basic.model.profileInfo profileInfo) {

		return _profileInfoLocalService.updateprofileInfo(profileInfo);
	}

	@Override
	public profileInfoLocalService getWrappedService() {
		return _profileInfoLocalService;
	}

	@Override
	public void setWrappedService(
		profileInfoLocalService profileInfoLocalService) {

		_profileInfoLocalService = profileInfoLocalService;
	}

	private profileInfoLocalService _profileInfoLocalService;

}