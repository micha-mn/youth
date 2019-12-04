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
 * Provides the local service utility for ProfileTestimonial. This utility wraps
 * <code>basic.service.impl.ProfileTestimonialLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see ProfileTestimonialLocalService
 * @generated
 */
@ProviderType
public class ProfileTestimonialLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>basic.service.impl.ProfileTestimonialLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the profile testimonial to the database. Also notifies the appropriate model listeners.
	 *
	 * @param profileTestimonial the profile testimonial
	 * @return the profile testimonial that was added
	 */
	public static basic.model.ProfileTestimonial addProfileTestimonial(
		basic.model.ProfileTestimonial profileTestimonial) {

		return getService().addProfileTestimonial(profileTestimonial);
	}

	/**
	 * Creates a new profile testimonial with the primary key. Does not add the profile testimonial to the database.
	 *
	 * @param id the primary key for the new profile testimonial
	 * @return the new profile testimonial
	 */
	public static basic.model.ProfileTestimonial createProfileTestimonial(
		long id) {

		return getService().createProfileTestimonial(id);
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
	 * Deletes the profile testimonial with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the profile testimonial
	 * @return the profile testimonial that was removed
	 * @throws PortalException if a profile testimonial with the primary key could not be found
	 */
	public static basic.model.ProfileTestimonial deleteProfileTestimonial(
			long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteProfileTestimonial(id);
	}

	/**
	 * Deletes the profile testimonial from the database. Also notifies the appropriate model listeners.
	 *
	 * @param profileTestimonial the profile testimonial
	 * @return the profile testimonial that was removed
	 */
	public static basic.model.ProfileTestimonial deleteProfileTestimonial(
		basic.model.ProfileTestimonial profileTestimonial) {

		return getService().deleteProfileTestimonial(profileTestimonial);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>basic.model.impl.ProfileTestimonialModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>basic.model.impl.ProfileTestimonialModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static basic.model.ProfileTestimonial fetchProfileTestimonial(
		long id) {

		return getService().fetchProfileTestimonial(id);
	}

	/**
	 * Returns the profile testimonial matching the UUID and group.
	 *
	 * @param uuid the profile testimonial's UUID
	 * @param groupId the primary key of the group
	 * @return the matching profile testimonial, or <code>null</code> if a matching profile testimonial could not be found
	 */
	public static basic.model.ProfileTestimonial
		fetchProfileTestimonialByUuidAndGroupId(String uuid, long groupId) {

		return getService().fetchProfileTestimonialByUuidAndGroupId(
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
	 * Returns the profile testimonial with the primary key.
	 *
	 * @param id the primary key of the profile testimonial
	 * @return the profile testimonial
	 * @throws PortalException if a profile testimonial with the primary key could not be found
	 */
	public static basic.model.ProfileTestimonial getProfileTestimonial(long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getProfileTestimonial(id);
	}

	/**
	 * Returns the profile testimonial matching the UUID and group.
	 *
	 * @param uuid the profile testimonial's UUID
	 * @param groupId the primary key of the group
	 * @return the matching profile testimonial
	 * @throws PortalException if a matching profile testimonial could not be found
	 */
	public static basic.model.ProfileTestimonial
			getProfileTestimonialByUuidAndGroupId(String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getProfileTestimonialByUuidAndGroupId(
			uuid, groupId);
	}

	/**
	 * Returns a range of all the profile testimonials.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>basic.model.impl.ProfileTestimonialModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of profile testimonials
	 * @param end the upper bound of the range of profile testimonials (not inclusive)
	 * @return the range of profile testimonials
	 */
	public static java.util.List<basic.model.ProfileTestimonial>
		getProfileTestimonials(int start, int end) {

		return getService().getProfileTestimonials(start, end);
	}

	/**
	 * Returns all the profile testimonials matching the UUID and company.
	 *
	 * @param uuid the UUID of the profile testimonials
	 * @param companyId the primary key of the company
	 * @return the matching profile testimonials, or an empty list if no matches were found
	 */
	public static java.util.List<basic.model.ProfileTestimonial>
		getProfileTestimonialsByUuidAndCompanyId(String uuid, long companyId) {

		return getService().getProfileTestimonialsByUuidAndCompanyId(
			uuid, companyId);
	}

	/**
	 * Returns a range of profile testimonials matching the UUID and company.
	 *
	 * @param uuid the UUID of the profile testimonials
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of profile testimonials
	 * @param end the upper bound of the range of profile testimonials (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching profile testimonials, or an empty list if no matches were found
	 */
	public static java.util.List<basic.model.ProfileTestimonial>
		getProfileTestimonialsByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<basic.model.ProfileTestimonial> orderByComparator) {

		return getService().getProfileTestimonialsByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of profile testimonials.
	 *
	 * @return the number of profile testimonials
	 */
	public static int getProfileTestimonialsCount() {
		return getService().getProfileTestimonialsCount();
	}

	/**
	 * Updates the profile testimonial in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param profileTestimonial the profile testimonial
	 * @return the profile testimonial that was updated
	 */
	public static basic.model.ProfileTestimonial updateProfileTestimonial(
		basic.model.ProfileTestimonial profileTestimonial) {

		return getService().updateProfileTestimonial(profileTestimonial);
	}

	public static ProfileTestimonialLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<ProfileTestimonialLocalService, ProfileTestimonialLocalService>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			ProfileTestimonialLocalService.class);

		ServiceTracker
			<ProfileTestimonialLocalService, ProfileTestimonialLocalService>
				serviceTracker =
					new ServiceTracker
						<ProfileTestimonialLocalService,
						 ProfileTestimonialLocalService>(
							 bundle.getBundleContext(),
							 ProfileTestimonialLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}