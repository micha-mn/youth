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
 * Provides the local service utility for profileEducation. This utility wraps
 * <code>basic.service.impl.profileEducationLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see profileEducationLocalService
 * @generated
 */
@ProviderType
public class profileEducationLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>basic.service.impl.profileEducationLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the profile education to the database. Also notifies the appropriate model listeners.
	 *
	 * @param profileEducation the profile education
	 * @return the profile education that was added
	 */
	public static basic.model.profileEducation addprofileEducation(
		basic.model.profileEducation profileEducation) {

		return getService().addprofileEducation(profileEducation);
	}

	/**
	 * Creates a new profile education with the primary key. Does not add the profile education to the database.
	 *
	 * @param Id the primary key for the new profile education
	 * @return the new profile education
	 */
	public static basic.model.profileEducation createprofileEducation(long Id) {
		return getService().createprofileEducation(Id);
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
	 * Deletes the profile education with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param Id the primary key of the profile education
	 * @return the profile education that was removed
	 * @throws PortalException if a profile education with the primary key could not be found
	 */
	public static basic.model.profileEducation deleteprofileEducation(long Id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteprofileEducation(Id);
	}

	/**
	 * Deletes the profile education from the database. Also notifies the appropriate model listeners.
	 *
	 * @param profileEducation the profile education
	 * @return the profile education that was removed
	 */
	public static basic.model.profileEducation deleteprofileEducation(
		basic.model.profileEducation profileEducation) {

		return getService().deleteprofileEducation(profileEducation);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>basic.model.impl.profileEducationModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>basic.model.impl.profileEducationModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static basic.model.profileEducation fetchprofileEducation(long Id) {
		return getService().fetchprofileEducation(Id);
	}

	/**
	 * Returns the profile education matching the UUID and group.
	 *
	 * @param uuid the profile education's UUID
	 * @param groupId the primary key of the group
	 * @return the matching profile education, or <code>null</code> if a matching profile education could not be found
	 */
	public static basic.model.profileEducation
		fetchprofileEducationByUuidAndGroupId(String uuid, long groupId) {

		return getService().fetchprofileEducationByUuidAndGroupId(
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
	 * Returns the profile education with the primary key.
	 *
	 * @param Id the primary key of the profile education
	 * @return the profile education
	 * @throws PortalException if a profile education with the primary key could not be found
	 */
	public static basic.model.profileEducation getprofileEducation(long Id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getprofileEducation(Id);
	}

	/**
	 * Returns the profile education matching the UUID and group.
	 *
	 * @param uuid the profile education's UUID
	 * @param groupId the primary key of the group
	 * @return the matching profile education
	 * @throws PortalException if a matching profile education could not be found
	 */
	public static basic.model.profileEducation
			getprofileEducationByUuidAndGroupId(String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getprofileEducationByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Returns a range of all the profile educations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>basic.model.impl.profileEducationModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of profile educations
	 * @param end the upper bound of the range of profile educations (not inclusive)
	 * @return the range of profile educations
	 */
	public static java.util.List<basic.model.profileEducation>
		getprofileEducations(int start, int end) {

		return getService().getprofileEducations(start, end);
	}

	/**
	 * Returns all the profile educations matching the UUID and company.
	 *
	 * @param uuid the UUID of the profile educations
	 * @param companyId the primary key of the company
	 * @return the matching profile educations, or an empty list if no matches were found
	 */
	public static java.util.List<basic.model.profileEducation>
		getprofileEducationsByUuidAndCompanyId(String uuid, long companyId) {

		return getService().getprofileEducationsByUuidAndCompanyId(
			uuid, companyId);
	}

	/**
	 * Returns a range of profile educations matching the UUID and company.
	 *
	 * @param uuid the UUID of the profile educations
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of profile educations
	 * @param end the upper bound of the range of profile educations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching profile educations, or an empty list if no matches were found
	 */
	public static java.util.List<basic.model.profileEducation>
		getprofileEducationsByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<basic.model.profileEducation> orderByComparator) {

		return getService().getprofileEducationsByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of profile educations.
	 *
	 * @return the number of profile educations
	 */
	public static int getprofileEducationsCount() {
		return getService().getprofileEducationsCount();
	}

	/**
	 * Updates the profile education in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param profileEducation the profile education
	 * @return the profile education that was updated
	 */
	public static basic.model.profileEducation updateprofileEducation(
		basic.model.profileEducation profileEducation) {

		return getService().updateprofileEducation(profileEducation);
	}

	public static profileEducationLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<profileEducationLocalService, profileEducationLocalService>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			profileEducationLocalService.class);

		ServiceTracker
			<profileEducationLocalService, profileEducationLocalService>
				serviceTracker =
					new ServiceTracker
						<profileEducationLocalService,
						 profileEducationLocalService>(
							 bundle.getBundleContext(),
							 profileEducationLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}