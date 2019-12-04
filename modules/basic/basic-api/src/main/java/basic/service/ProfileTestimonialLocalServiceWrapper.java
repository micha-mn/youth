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
 * Provides a wrapper for {@link ProfileTestimonialLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see ProfileTestimonialLocalService
 * @generated
 */
@ProviderType
public class ProfileTestimonialLocalServiceWrapper
	implements ProfileTestimonialLocalService,
			   ServiceWrapper<ProfileTestimonialLocalService> {

	public ProfileTestimonialLocalServiceWrapper(
		ProfileTestimonialLocalService profileTestimonialLocalService) {

		_profileTestimonialLocalService = profileTestimonialLocalService;
	}

	/**
	 * Adds the profile testimonial to the database. Also notifies the appropriate model listeners.
	 *
	 * @param profileTestimonial the profile testimonial
	 * @return the profile testimonial that was added
	 */
	@Override
	public basic.model.ProfileTestimonial addProfileTestimonial(
		basic.model.ProfileTestimonial profileTestimonial) {

		return _profileTestimonialLocalService.addProfileTestimonial(
			profileTestimonial);
	}

	/**
	 * Creates a new profile testimonial with the primary key. Does not add the profile testimonial to the database.
	 *
	 * @param id the primary key for the new profile testimonial
	 * @return the new profile testimonial
	 */
	@Override
	public basic.model.ProfileTestimonial createProfileTestimonial(long id) {
		return _profileTestimonialLocalService.createProfileTestimonial(id);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _profileTestimonialLocalService.deletePersistedModel(
			persistedModel);
	}

	/**
	 * Deletes the profile testimonial with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the profile testimonial
	 * @return the profile testimonial that was removed
	 * @throws PortalException if a profile testimonial with the primary key could not be found
	 */
	@Override
	public basic.model.ProfileTestimonial deleteProfileTestimonial(long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _profileTestimonialLocalService.deleteProfileTestimonial(id);
	}

	/**
	 * Deletes the profile testimonial from the database. Also notifies the appropriate model listeners.
	 *
	 * @param profileTestimonial the profile testimonial
	 * @return the profile testimonial that was removed
	 */
	@Override
	public basic.model.ProfileTestimonial deleteProfileTestimonial(
		basic.model.ProfileTestimonial profileTestimonial) {

		return _profileTestimonialLocalService.deleteProfileTestimonial(
			profileTestimonial);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _profileTestimonialLocalService.dynamicQuery();
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

		return _profileTestimonialLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _profileTestimonialLocalService.dynamicQuery(
			dynamicQuery, start, end);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _profileTestimonialLocalService.dynamicQuery(
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

		return _profileTestimonialLocalService.dynamicQueryCount(dynamicQuery);
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

		return _profileTestimonialLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public basic.model.ProfileTestimonial fetchProfileTestimonial(long id) {
		return _profileTestimonialLocalService.fetchProfileTestimonial(id);
	}

	/**
	 * Returns the profile testimonial matching the UUID and group.
	 *
	 * @param uuid the profile testimonial's UUID
	 * @param groupId the primary key of the group
	 * @return the matching profile testimonial, or <code>null</code> if a matching profile testimonial could not be found
	 */
	@Override
	public basic.model.ProfileTestimonial
		fetchProfileTestimonialByUuidAndGroupId(String uuid, long groupId) {

		return _profileTestimonialLocalService.
			fetchProfileTestimonialByUuidAndGroupId(uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _profileTestimonialLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _profileTestimonialLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _profileTestimonialLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _profileTestimonialLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _profileTestimonialLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the profile testimonial with the primary key.
	 *
	 * @param id the primary key of the profile testimonial
	 * @return the profile testimonial
	 * @throws PortalException if a profile testimonial with the primary key could not be found
	 */
	@Override
	public basic.model.ProfileTestimonial getProfileTestimonial(long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _profileTestimonialLocalService.getProfileTestimonial(id);
	}

	/**
	 * Returns the profile testimonial matching the UUID and group.
	 *
	 * @param uuid the profile testimonial's UUID
	 * @param groupId the primary key of the group
	 * @return the matching profile testimonial
	 * @throws PortalException if a matching profile testimonial could not be found
	 */
	@Override
	public basic.model.ProfileTestimonial getProfileTestimonialByUuidAndGroupId(
			String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _profileTestimonialLocalService.
			getProfileTestimonialByUuidAndGroupId(uuid, groupId);
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
	@Override
	public java.util.List<basic.model.ProfileTestimonial>
		getProfileTestimonials(int start, int end) {

		return _profileTestimonialLocalService.getProfileTestimonials(
			start, end);
	}

	/**
	 * Returns all the profile testimonials matching the UUID and company.
	 *
	 * @param uuid the UUID of the profile testimonials
	 * @param companyId the primary key of the company
	 * @return the matching profile testimonials, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<basic.model.ProfileTestimonial>
		getProfileTestimonialsByUuidAndCompanyId(String uuid, long companyId) {

		return _profileTestimonialLocalService.
			getProfileTestimonialsByUuidAndCompanyId(uuid, companyId);
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
	@Override
	public java.util.List<basic.model.ProfileTestimonial>
		getProfileTestimonialsByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<basic.model.ProfileTestimonial> orderByComparator) {

		return _profileTestimonialLocalService.
			getProfileTestimonialsByUuidAndCompanyId(
				uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of profile testimonials.
	 *
	 * @return the number of profile testimonials
	 */
	@Override
	public int getProfileTestimonialsCount() {
		return _profileTestimonialLocalService.getProfileTestimonialsCount();
	}

	/**
	 * Updates the profile testimonial in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param profileTestimonial the profile testimonial
	 * @return the profile testimonial that was updated
	 */
	@Override
	public basic.model.ProfileTestimonial updateProfileTestimonial(
		basic.model.ProfileTestimonial profileTestimonial) {

		return _profileTestimonialLocalService.updateProfileTestimonial(
			profileTestimonial);
	}

	@Override
	public ProfileTestimonialLocalService getWrappedService() {
		return _profileTestimonialLocalService;
	}

	@Override
	public void setWrappedService(
		ProfileTestimonialLocalService profileTestimonialLocalService) {

		_profileTestimonialLocalService = profileTestimonialLocalService;
	}

	private ProfileTestimonialLocalService _profileTestimonialLocalService;

}