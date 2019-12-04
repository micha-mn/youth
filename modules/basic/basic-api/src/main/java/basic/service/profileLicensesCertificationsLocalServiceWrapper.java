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
 * Provides a wrapper for {@link profileLicensesCertificationsLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see profileLicensesCertificationsLocalService
 * @generated
 */
@ProviderType
public class profileLicensesCertificationsLocalServiceWrapper
	implements profileLicensesCertificationsLocalService,
			   ServiceWrapper<profileLicensesCertificationsLocalService> {

	public profileLicensesCertificationsLocalServiceWrapper(
		profileLicensesCertificationsLocalService
			profileLicensesCertificationsLocalService) {

		_profileLicensesCertificationsLocalService =
			profileLicensesCertificationsLocalService;
	}

	/**
	 * Adds the profile licenses certifications to the database. Also notifies the appropriate model listeners.
	 *
	 * @param profileLicensesCertifications the profile licenses certifications
	 * @return the profile licenses certifications that was added
	 */
	@Override
	public basic.model.profileLicensesCertifications
		addprofileLicensesCertifications(
			basic.model.profileLicensesCertifications
				profileLicensesCertifications) {

		return _profileLicensesCertificationsLocalService.
			addprofileLicensesCertifications(profileLicensesCertifications);
	}

	/**
	 * Creates a new profile licenses certifications with the primary key. Does not add the profile licenses certifications to the database.
	 *
	 * @param Id the primary key for the new profile licenses certifications
	 * @return the new profile licenses certifications
	 */
	@Override
	public basic.model.profileLicensesCertifications
		createprofileLicensesCertifications(long Id) {

		return _profileLicensesCertificationsLocalService.
			createprofileLicensesCertifications(Id);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _profileLicensesCertificationsLocalService.deletePersistedModel(
			persistedModel);
	}

	/**
	 * Deletes the profile licenses certifications with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param Id the primary key of the profile licenses certifications
	 * @return the profile licenses certifications that was removed
	 * @throws PortalException if a profile licenses certifications with the primary key could not be found
	 */
	@Override
	public basic.model.profileLicensesCertifications
			deleteprofileLicensesCertifications(long Id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _profileLicensesCertificationsLocalService.
			deleteprofileLicensesCertifications(Id);
	}

	/**
	 * Deletes the profile licenses certifications from the database. Also notifies the appropriate model listeners.
	 *
	 * @param profileLicensesCertifications the profile licenses certifications
	 * @return the profile licenses certifications that was removed
	 */
	@Override
	public basic.model.profileLicensesCertifications
		deleteprofileLicensesCertifications(
			basic.model.profileLicensesCertifications
				profileLicensesCertifications) {

		return _profileLicensesCertificationsLocalService.
			deleteprofileLicensesCertifications(profileLicensesCertifications);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _profileLicensesCertificationsLocalService.dynamicQuery();
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

		return _profileLicensesCertificationsLocalService.dynamicQuery(
			dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>basic.model.impl.profileLicensesCertificationsModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

		return _profileLicensesCertificationsLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>basic.model.impl.profileLicensesCertificationsModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

		return _profileLicensesCertificationsLocalService.dynamicQuery(
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

		return _profileLicensesCertificationsLocalService.dynamicQueryCount(
			dynamicQuery);
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

		return _profileLicensesCertificationsLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public basic.model.profileLicensesCertifications
		fetchprofileLicensesCertifications(long Id) {

		return _profileLicensesCertificationsLocalService.
			fetchprofileLicensesCertifications(Id);
	}

	/**
	 * Returns the profile licenses certifications matching the UUID and group.
	 *
	 * @param uuid the profile licenses certifications's UUID
	 * @param groupId the primary key of the group
	 * @return the matching profile licenses certifications, or <code>null</code> if a matching profile licenses certifications could not be found
	 */
	@Override
	public basic.model.profileLicensesCertifications
		fetchprofileLicensesCertificationsByUuidAndGroupId(
			String uuid, long groupId) {

		return _profileLicensesCertificationsLocalService.
			fetchprofileLicensesCertificationsByUuidAndGroupId(uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _profileLicensesCertificationsLocalService.
			getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _profileLicensesCertificationsLocalService.
			getExportActionableDynamicQuery(portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _profileLicensesCertificationsLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _profileLicensesCertificationsLocalService.
			getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _profileLicensesCertificationsLocalService.getPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Returns the profile licenses certifications with the primary key.
	 *
	 * @param Id the primary key of the profile licenses certifications
	 * @return the profile licenses certifications
	 * @throws PortalException if a profile licenses certifications with the primary key could not be found
	 */
	@Override
	public basic.model.profileLicensesCertifications
			getprofileLicensesCertifications(long Id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _profileLicensesCertificationsLocalService.
			getprofileLicensesCertifications(Id);
	}

	/**
	 * Returns the profile licenses certifications matching the UUID and group.
	 *
	 * @param uuid the profile licenses certifications's UUID
	 * @param groupId the primary key of the group
	 * @return the matching profile licenses certifications
	 * @throws PortalException if a matching profile licenses certifications could not be found
	 */
	@Override
	public basic.model.profileLicensesCertifications
			getprofileLicensesCertificationsByUuidAndGroupId(
				String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _profileLicensesCertificationsLocalService.
			getprofileLicensesCertificationsByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Returns a range of all the profile licenses certificationses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>basic.model.impl.profileLicensesCertificationsModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of profile licenses certificationses
	 * @param end the upper bound of the range of profile licenses certificationses (not inclusive)
	 * @return the range of profile licenses certificationses
	 */
	@Override
	public java.util.List<basic.model.profileLicensesCertifications>
		getprofileLicensesCertificationses(int start, int end) {

		return _profileLicensesCertificationsLocalService.
			getprofileLicensesCertificationses(start, end);
	}

	/**
	 * Returns all the profile licenses certificationses matching the UUID and company.
	 *
	 * @param uuid the UUID of the profile licenses certificationses
	 * @param companyId the primary key of the company
	 * @return the matching profile licenses certificationses, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<basic.model.profileLicensesCertifications>
		getprofileLicensesCertificationsesByUuidAndCompanyId(
			String uuid, long companyId) {

		return _profileLicensesCertificationsLocalService.
			getprofileLicensesCertificationsesByUuidAndCompanyId(
				uuid, companyId);
	}

	/**
	 * Returns a range of profile licenses certificationses matching the UUID and company.
	 *
	 * @param uuid the UUID of the profile licenses certificationses
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of profile licenses certificationses
	 * @param end the upper bound of the range of profile licenses certificationses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching profile licenses certificationses, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<basic.model.profileLicensesCertifications>
		getprofileLicensesCertificationsesByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<basic.model.profileLicensesCertifications> orderByComparator) {

		return _profileLicensesCertificationsLocalService.
			getprofileLicensesCertificationsesByUuidAndCompanyId(
				uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of profile licenses certificationses.
	 *
	 * @return the number of profile licenses certificationses
	 */
	@Override
	public int getprofileLicensesCertificationsesCount() {
		return _profileLicensesCertificationsLocalService.
			getprofileLicensesCertificationsesCount();
	}

	/**
	 * Updates the profile licenses certifications in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param profileLicensesCertifications the profile licenses certifications
	 * @return the profile licenses certifications that was updated
	 */
	@Override
	public basic.model.profileLicensesCertifications
		updateprofileLicensesCertifications(
			basic.model.profileLicensesCertifications
				profileLicensesCertifications) {

		return _profileLicensesCertificationsLocalService.
			updateprofileLicensesCertifications(profileLicensesCertifications);
	}

	@Override
	public profileLicensesCertificationsLocalService getWrappedService() {
		return _profileLicensesCertificationsLocalService;
	}

	@Override
	public void setWrappedService(
		profileLicensesCertificationsLocalService
			profileLicensesCertificationsLocalService) {

		_profileLicensesCertificationsLocalService =
			profileLicensesCertificationsLocalService;
	}

	private profileLicensesCertificationsLocalService
		_profileLicensesCertificationsLocalService;

}