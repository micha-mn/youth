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

import org.osgi.annotation.versioning.ProviderType;
import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for profileLicensesCertifications. This utility wraps
 * <code>basic.service.impl.profileLicensesCertificationsLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see profileLicensesCertificationsLocalService
 * @generated
 */
@ProviderType
public class profileLicensesCertificationsLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>basic.service.impl.profileLicensesCertificationsLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the profile licenses certifications to the database. Also notifies the appropriate model listeners.
	 *
	 * @param profileLicensesCertifications the profile licenses certifications
	 * @return the profile licenses certifications that was added
	 */
	public static basic.model.profileLicensesCertifications
		addprofileLicensesCertifications(
			basic.model.profileLicensesCertifications
				profileLicensesCertifications) {

		return getService().addprofileLicensesCertifications(
			profileLicensesCertifications);
	}

	/**
	 * Creates a new profile licenses certifications with the primary key. Does not add the profile licenses certifications to the database.
	 *
	 * @param Id the primary key for the new profile licenses certifications
	 * @return the new profile licenses certifications
	 */
	public static basic.model.profileLicensesCertifications
		createprofileLicensesCertifications(long Id) {

		return getService().createprofileLicensesCertifications(Id);
	}

	/**
	 * @throws PortalException
	 */
	public static com.liferay.portal.kernel.model.PersistedModel
			deletePersistedModel(
				com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the profile licenses certifications with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param Id the primary key of the profile licenses certifications
	 * @return the profile licenses certifications that was removed
	 * @throws PortalException if a profile licenses certifications with the primary key could not be found
	 */
	public static basic.model.profileLicensesCertifications
			deleteprofileLicensesCertifications(long Id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteprofileLicensesCertifications(Id);
	}

	/**
	 * Deletes the profile licenses certifications from the database. Also notifies the appropriate model listeners.
	 *
	 * @param profileLicensesCertifications the profile licenses certifications
	 * @return the profile licenses certifications that was removed
	 */
	public static basic.model.profileLicensesCertifications
		deleteprofileLicensesCertifications(
			basic.model.profileLicensesCertifications
				profileLicensesCertifications) {

		return getService().deleteprofileLicensesCertifications(
			profileLicensesCertifications);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery
		dynamicQuery() {

		return getService().dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return getService().dynamicQuery(dynamicQuery);
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
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return getService().dynamicQuery(dynamicQuery, start, end);
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
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return getService().dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static basic.model.profileLicensesCertifications
		fetchprofileLicensesCertifications(long Id) {

		return getService().fetchprofileLicensesCertifications(Id);
	}

	/**
	 * Returns the profile licenses certifications matching the UUID and group.
	 *
	 * @param uuid the profile licenses certifications's UUID
	 * @param groupId the primary key of the group
	 * @return the matching profile licenses certifications, or <code>null</code> if a matching profile licenses certifications could not be found
	 */
	public static basic.model.profileLicensesCertifications
		fetchprofileLicensesCertificationsByUuidAndGroupId(
			String uuid, long groupId) {

		return getService().fetchprofileLicensesCertificationsByUuidAndGroupId(
			uuid, groupId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	public static com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return getService().getExportActionableDynamicQuery(portletDataContext);
	}

	public static
		com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
			getIndexableActionableDynamicQuery() {

		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static com.liferay.portal.kernel.model.PersistedModel
			getPersistedModel(java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the profile licenses certifications with the primary key.
	 *
	 * @param Id the primary key of the profile licenses certifications
	 * @return the profile licenses certifications
	 * @throws PortalException if a profile licenses certifications with the primary key could not be found
	 */
	public static basic.model.profileLicensesCertifications
			getprofileLicensesCertifications(long Id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getprofileLicensesCertifications(Id);
	}

	/**
	 * Returns the profile licenses certifications matching the UUID and group.
	 *
	 * @param uuid the profile licenses certifications's UUID
	 * @param groupId the primary key of the group
	 * @return the matching profile licenses certifications
	 * @throws PortalException if a matching profile licenses certifications could not be found
	 */
	public static basic.model.profileLicensesCertifications
			getprofileLicensesCertificationsByUuidAndGroupId(
				String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getprofileLicensesCertificationsByUuidAndGroupId(
			uuid, groupId);
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
	public static java.util.List<basic.model.profileLicensesCertifications>
		getprofileLicensesCertificationses(int start, int end) {

		return getService().getprofileLicensesCertificationses(start, end);
	}

	/**
	 * Returns all the profile licenses certificationses matching the UUID and company.
	 *
	 * @param uuid the UUID of the profile licenses certificationses
	 * @param companyId the primary key of the company
	 * @return the matching profile licenses certificationses, or an empty list if no matches were found
	 */
	public static java.util.List<basic.model.profileLicensesCertifications>
		getprofileLicensesCertificationsesByUuidAndCompanyId(
			String uuid, long companyId) {

		return getService().
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
	public static java.util.List<basic.model.profileLicensesCertifications>
		getprofileLicensesCertificationsesByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<basic.model.profileLicensesCertifications> orderByComparator) {

		return getService().
			getprofileLicensesCertificationsesByUuidAndCompanyId(
				uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of profile licenses certificationses.
	 *
	 * @return the number of profile licenses certificationses
	 */
	public static int getprofileLicensesCertificationsesCount() {
		return getService().getprofileLicensesCertificationsesCount();
	}

	/**
	 * Updates the profile licenses certifications in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param profileLicensesCertifications the profile licenses certifications
	 * @return the profile licenses certifications that was updated
	 */
	public static basic.model.profileLicensesCertifications
		updateprofileLicensesCertifications(
			basic.model.profileLicensesCertifications
				profileLicensesCertifications) {

		return getService().updateprofileLicensesCertifications(
			profileLicensesCertifications);
	}

	public static profileLicensesCertificationsLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<profileLicensesCertificationsLocalService,
		 profileLicensesCertificationsLocalService> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			profileLicensesCertificationsLocalService.class);

		ServiceTracker
			<profileLicensesCertificationsLocalService,
			 profileLicensesCertificationsLocalService> serviceTracker =
				new ServiceTracker
					<profileLicensesCertificationsLocalService,
					 profileLicensesCertificationsLocalService>(
						 bundle.getBundleContext(),
						 profileLicensesCertificationsLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}