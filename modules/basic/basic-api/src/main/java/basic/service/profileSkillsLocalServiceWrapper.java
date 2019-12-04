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
 * Provides a wrapper for {@link profileSkillsLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see profileSkillsLocalService
 * @generated
 */
@ProviderType
public class profileSkillsLocalServiceWrapper
	implements profileSkillsLocalService,
			   ServiceWrapper<profileSkillsLocalService> {

	public profileSkillsLocalServiceWrapper(
		profileSkillsLocalService profileSkillsLocalService) {

		_profileSkillsLocalService = profileSkillsLocalService;
	}

	/**
	 * Adds the profile skills to the database. Also notifies the appropriate model listeners.
	 *
	 * @param profileSkills the profile skills
	 * @return the profile skills that was added
	 */
	@Override
	public basic.model.profileSkills addprofileSkills(
		basic.model.profileSkills profileSkills) {

		return _profileSkillsLocalService.addprofileSkills(profileSkills);
	}

	/**
	 * Creates a new profile skills with the primary key. Does not add the profile skills to the database.
	 *
	 * @param Id the primary key for the new profile skills
	 * @return the new profile skills
	 */
	@Override
	public basic.model.profileSkills createprofileSkills(long Id) {
		return _profileSkillsLocalService.createprofileSkills(Id);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _profileSkillsLocalService.deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the profile skills with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param Id the primary key of the profile skills
	 * @return the profile skills that was removed
	 * @throws PortalException if a profile skills with the primary key could not be found
	 */
	@Override
	public basic.model.profileSkills deleteprofileSkills(long Id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _profileSkillsLocalService.deleteprofileSkills(Id);
	}

	/**
	 * Deletes the profile skills from the database. Also notifies the appropriate model listeners.
	 *
	 * @param profileSkills the profile skills
	 * @return the profile skills that was removed
	 */
	@Override
	public basic.model.profileSkills deleteprofileSkills(
		basic.model.profileSkills profileSkills) {

		return _profileSkillsLocalService.deleteprofileSkills(profileSkills);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _profileSkillsLocalService.dynamicQuery();
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

		return _profileSkillsLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>basic.model.impl.profileSkillsModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

		return _profileSkillsLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>basic.model.impl.profileSkillsModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

		return _profileSkillsLocalService.dynamicQuery(
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

		return _profileSkillsLocalService.dynamicQueryCount(dynamicQuery);
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

		return _profileSkillsLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public basic.model.profileSkills fetchprofileSkills(long Id) {
		return _profileSkillsLocalService.fetchprofileSkills(Id);
	}

	/**
	 * Returns the profile skills matching the UUID and group.
	 *
	 * @param uuid the profile skills's UUID
	 * @param groupId the primary key of the group
	 * @return the matching profile skills, or <code>null</code> if a matching profile skills could not be found
	 */
	@Override
	public basic.model.profileSkills fetchprofileSkillsByUuidAndGroupId(
		String uuid, long groupId) {

		return _profileSkillsLocalService.fetchprofileSkillsByUuidAndGroupId(
			uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _profileSkillsLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _profileSkillsLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _profileSkillsLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _profileSkillsLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _profileSkillsLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the profile skills with the primary key.
	 *
	 * @param Id the primary key of the profile skills
	 * @return the profile skills
	 * @throws PortalException if a profile skills with the primary key could not be found
	 */
	@Override
	public basic.model.profileSkills getprofileSkills(long Id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _profileSkillsLocalService.getprofileSkills(Id);
	}

	/**
	 * Returns the profile skills matching the UUID and group.
	 *
	 * @param uuid the profile skills's UUID
	 * @param groupId the primary key of the group
	 * @return the matching profile skills
	 * @throws PortalException if a matching profile skills could not be found
	 */
	@Override
	public basic.model.profileSkills getprofileSkillsByUuidAndGroupId(
			String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _profileSkillsLocalService.getprofileSkillsByUuidAndGroupId(
			uuid, groupId);
	}

	/**
	 * Returns a range of all the profile skillses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>basic.model.impl.profileSkillsModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of profile skillses
	 * @param end the upper bound of the range of profile skillses (not inclusive)
	 * @return the range of profile skillses
	 */
	@Override
	public java.util.List<basic.model.profileSkills> getprofileSkillses(
		int start, int end) {

		return _profileSkillsLocalService.getprofileSkillses(start, end);
	}

	/**
	 * Returns all the profile skillses matching the UUID and company.
	 *
	 * @param uuid the UUID of the profile skillses
	 * @param companyId the primary key of the company
	 * @return the matching profile skillses, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<basic.model.profileSkills>
		getprofileSkillsesByUuidAndCompanyId(String uuid, long companyId) {

		return _profileSkillsLocalService.getprofileSkillsesByUuidAndCompanyId(
			uuid, companyId);
	}

	/**
	 * Returns a range of profile skillses matching the UUID and company.
	 *
	 * @param uuid the UUID of the profile skillses
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of profile skillses
	 * @param end the upper bound of the range of profile skillses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching profile skillses, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<basic.model.profileSkills>
		getprofileSkillsesByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<basic.model.profileSkills> orderByComparator) {

		return _profileSkillsLocalService.getprofileSkillsesByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of profile skillses.
	 *
	 * @return the number of profile skillses
	 */
	@Override
	public int getprofileSkillsesCount() {
		return _profileSkillsLocalService.getprofileSkillsesCount();
	}

	/**
	 * Updates the profile skills in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param profileSkills the profile skills
	 * @return the profile skills that was updated
	 */
	@Override
	public basic.model.profileSkills updateprofileSkills(
		basic.model.profileSkills profileSkills) {

		return _profileSkillsLocalService.updateprofileSkills(profileSkills);
	}

	@Override
	public profileSkillsLocalService getWrappedService() {
		return _profileSkillsLocalService;
	}

	@Override
	public void setWrappedService(
		profileSkillsLocalService profileSkillsLocalService) {

		_profileSkillsLocalService = profileSkillsLocalService;
	}

	private profileSkillsLocalService _profileSkillsLocalService;

}