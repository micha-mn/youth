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
 * Provides a wrapper for {@link profileWorkExperienceLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see profileWorkExperienceLocalService
 * @generated
 */
@ProviderType
public class profileWorkExperienceLocalServiceWrapper
	implements profileWorkExperienceLocalService,
			   ServiceWrapper<profileWorkExperienceLocalService> {

	public profileWorkExperienceLocalServiceWrapper(
		profileWorkExperienceLocalService profileWorkExperienceLocalService) {

		_profileWorkExperienceLocalService = profileWorkExperienceLocalService;
	}

	/**
	 * Adds the profile work experience to the database. Also notifies the appropriate model listeners.
	 *
	 * @param profileWorkExperience the profile work experience
	 * @return the profile work experience that was added
	 */
	@Override
	public basic.model.profileWorkExperience addprofileWorkExperience(
		basic.model.profileWorkExperience profileWorkExperience) {

		return _profileWorkExperienceLocalService.addprofileWorkExperience(
			profileWorkExperience);
	}

	/**
	 * Creates a new profile work experience with the primary key. Does not add the profile work experience to the database.
	 *
	 * @param Id the primary key for the new profile work experience
	 * @return the new profile work experience
	 */
	@Override
	public basic.model.profileWorkExperience createprofileWorkExperience(
		long Id) {

		return _profileWorkExperienceLocalService.createprofileWorkExperience(
			Id);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _profileWorkExperienceLocalService.deletePersistedModel(
			persistedModel);
	}

	/**
	 * Deletes the profile work experience with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param Id the primary key of the profile work experience
	 * @return the profile work experience that was removed
	 * @throws PortalException if a profile work experience with the primary key could not be found
	 */
	@Override
	public basic.model.profileWorkExperience deleteprofileWorkExperience(
			long Id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _profileWorkExperienceLocalService.deleteprofileWorkExperience(
			Id);
	}

	/**
	 * Deletes the profile work experience from the database. Also notifies the appropriate model listeners.
	 *
	 * @param profileWorkExperience the profile work experience
	 * @return the profile work experience that was removed
	 */
	@Override
	public basic.model.profileWorkExperience deleteprofileWorkExperience(
		basic.model.profileWorkExperience profileWorkExperience) {

		return _profileWorkExperienceLocalService.deleteprofileWorkExperience(
			profileWorkExperience);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _profileWorkExperienceLocalService.dynamicQuery();
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

		return _profileWorkExperienceLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>basic.model.impl.profileWorkExperienceModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

		return _profileWorkExperienceLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>basic.model.impl.profileWorkExperienceModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

		return _profileWorkExperienceLocalService.dynamicQuery(
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

		return _profileWorkExperienceLocalService.dynamicQueryCount(
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

		return _profileWorkExperienceLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public basic.model.profileWorkExperience fetchprofileWorkExperience(
		long Id) {

		return _profileWorkExperienceLocalService.fetchprofileWorkExperience(
			Id);
	}

	/**
	 * Returns the profile work experience matching the UUID and group.
	 *
	 * @param uuid the profile work experience's UUID
	 * @param groupId the primary key of the group
	 * @return the matching profile work experience, or <code>null</code> if a matching profile work experience could not be found
	 */
	@Override
	public basic.model.profileWorkExperience
		fetchprofileWorkExperienceByUuidAndGroupId(String uuid, long groupId) {

		return _profileWorkExperienceLocalService.
			fetchprofileWorkExperienceByUuidAndGroupId(uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _profileWorkExperienceLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _profileWorkExperienceLocalService.
			getExportActionableDynamicQuery(portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _profileWorkExperienceLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _profileWorkExperienceLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _profileWorkExperienceLocalService.getPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Returns the profile work experience with the primary key.
	 *
	 * @param Id the primary key of the profile work experience
	 * @return the profile work experience
	 * @throws PortalException if a profile work experience with the primary key could not be found
	 */
	@Override
	public basic.model.profileWorkExperience getprofileWorkExperience(long Id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _profileWorkExperienceLocalService.getprofileWorkExperience(Id);
	}

	/**
	 * Returns the profile work experience matching the UUID and group.
	 *
	 * @param uuid the profile work experience's UUID
	 * @param groupId the primary key of the group
	 * @return the matching profile work experience
	 * @throws PortalException if a matching profile work experience could not be found
	 */
	@Override
	public basic.model.profileWorkExperience
			getprofileWorkExperienceByUuidAndGroupId(String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _profileWorkExperienceLocalService.
			getprofileWorkExperienceByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Returns a range of all the profile work experiences.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>basic.model.impl.profileWorkExperienceModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of profile work experiences
	 * @param end the upper bound of the range of profile work experiences (not inclusive)
	 * @return the range of profile work experiences
	 */
	@Override
	public java.util.List<basic.model.profileWorkExperience>
		getprofileWorkExperiences(int start, int end) {

		return _profileWorkExperienceLocalService.getprofileWorkExperiences(
			start, end);
	}

	/**
	 * Returns all the profile work experiences matching the UUID and company.
	 *
	 * @param uuid the UUID of the profile work experiences
	 * @param companyId the primary key of the company
	 * @return the matching profile work experiences, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<basic.model.profileWorkExperience>
		getprofileWorkExperiencesByUuidAndCompanyId(
			String uuid, long companyId) {

		return _profileWorkExperienceLocalService.
			getprofileWorkExperiencesByUuidAndCompanyId(uuid, companyId);
	}

	/**
	 * Returns a range of profile work experiences matching the UUID and company.
	 *
	 * @param uuid the UUID of the profile work experiences
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of profile work experiences
	 * @param end the upper bound of the range of profile work experiences (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching profile work experiences, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<basic.model.profileWorkExperience>
		getprofileWorkExperiencesByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<basic.model.profileWorkExperience> orderByComparator) {

		return _profileWorkExperienceLocalService.
			getprofileWorkExperiencesByUuidAndCompanyId(
				uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of profile work experiences.
	 *
	 * @return the number of profile work experiences
	 */
	@Override
	public int getprofileWorkExperiencesCount() {
		return _profileWorkExperienceLocalService.
			getprofileWorkExperiencesCount();
	}

	/**
	 * Updates the profile work experience in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param profileWorkExperience the profile work experience
	 * @return the profile work experience that was updated
	 */
	@Override
	public basic.model.profileWorkExperience updateprofileWorkExperience(
		basic.model.profileWorkExperience profileWorkExperience) {

		return _profileWorkExperienceLocalService.updateprofileWorkExperience(
			profileWorkExperience);
	}

	@Override
	public profileWorkExperienceLocalService getWrappedService() {
		return _profileWorkExperienceLocalService;
	}

	@Override
	public void setWrappedService(
		profileWorkExperienceLocalService profileWorkExperienceLocalService) {

		_profileWorkExperienceLocalService = profileWorkExperienceLocalService;
	}

	private profileWorkExperienceLocalService
		_profileWorkExperienceLocalService;

}