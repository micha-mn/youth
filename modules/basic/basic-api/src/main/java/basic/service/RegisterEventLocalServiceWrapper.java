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
 * Provides a wrapper for {@link RegisterEventLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see RegisterEventLocalService
 * @generated
 */
@ProviderType
public class RegisterEventLocalServiceWrapper
	implements RegisterEventLocalService,
			   ServiceWrapper<RegisterEventLocalService> {

	public RegisterEventLocalServiceWrapper(
		RegisterEventLocalService registerEventLocalService) {

		_registerEventLocalService = registerEventLocalService;
	}

	/**
	 * Adds the register event to the database. Also notifies the appropriate model listeners.
	 *
	 * @param registerEvent the register event
	 * @return the register event that was added
	 */
	@Override
	public basic.model.RegisterEvent addRegisterEvent(
		basic.model.RegisterEvent registerEvent) {

		return _registerEventLocalService.addRegisterEvent(registerEvent);
	}

	/**
	 * Creates a new register event with the primary key. Does not add the register event to the database.
	 *
	 * @param Id the primary key for the new register event
	 * @return the new register event
	 */
	@Override
	public basic.model.RegisterEvent createRegisterEvent(long Id) {
		return _registerEventLocalService.createRegisterEvent(Id);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _registerEventLocalService.deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the register event with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param Id the primary key of the register event
	 * @return the register event that was removed
	 * @throws PortalException if a register event with the primary key could not be found
	 */
	@Override
	public basic.model.RegisterEvent deleteRegisterEvent(long Id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _registerEventLocalService.deleteRegisterEvent(Id);
	}

	/**
	 * Deletes the register event from the database. Also notifies the appropriate model listeners.
	 *
	 * @param registerEvent the register event
	 * @return the register event that was removed
	 */
	@Override
	public basic.model.RegisterEvent deleteRegisterEvent(
		basic.model.RegisterEvent registerEvent) {

		return _registerEventLocalService.deleteRegisterEvent(registerEvent);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _registerEventLocalService.dynamicQuery();
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

		return _registerEventLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>basic.model.impl.RegisterEventModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

		return _registerEventLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>basic.model.impl.RegisterEventModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

		return _registerEventLocalService.dynamicQuery(
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

		return _registerEventLocalService.dynamicQueryCount(dynamicQuery);
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

		return _registerEventLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public basic.model.RegisterEvent fetchRegisterEvent(long Id) {
		return _registerEventLocalService.fetchRegisterEvent(Id);
	}

	/**
	 * Returns the register event matching the UUID and group.
	 *
	 * @param uuid the register event's UUID
	 * @param groupId the primary key of the group
	 * @return the matching register event, or <code>null</code> if a matching register event could not be found
	 */
	@Override
	public basic.model.RegisterEvent fetchRegisterEventByUuidAndGroupId(
		String uuid, long groupId) {

		return _registerEventLocalService.fetchRegisterEventByUuidAndGroupId(
			uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _registerEventLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _registerEventLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _registerEventLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _registerEventLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _registerEventLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the register event with the primary key.
	 *
	 * @param Id the primary key of the register event
	 * @return the register event
	 * @throws PortalException if a register event with the primary key could not be found
	 */
	@Override
	public basic.model.RegisterEvent getRegisterEvent(long Id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _registerEventLocalService.getRegisterEvent(Id);
	}

	/**
	 * Returns the register event matching the UUID and group.
	 *
	 * @param uuid the register event's UUID
	 * @param groupId the primary key of the group
	 * @return the matching register event
	 * @throws PortalException if a matching register event could not be found
	 */
	@Override
	public basic.model.RegisterEvent getRegisterEventByUuidAndGroupId(
			String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _registerEventLocalService.getRegisterEventByUuidAndGroupId(
			uuid, groupId);
	}

	/**
	 * Returns a range of all the register events.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>basic.model.impl.RegisterEventModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of register events
	 * @param end the upper bound of the range of register events (not inclusive)
	 * @return the range of register events
	 */
	@Override
	public java.util.List<basic.model.RegisterEvent> getRegisterEvents(
		int start, int end) {

		return _registerEventLocalService.getRegisterEvents(start, end);
	}

	/**
	 * Returns all the register events matching the UUID and company.
	 *
	 * @param uuid the UUID of the register events
	 * @param companyId the primary key of the company
	 * @return the matching register events, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<basic.model.RegisterEvent>
		getRegisterEventsByUuidAndCompanyId(String uuid, long companyId) {

		return _registerEventLocalService.getRegisterEventsByUuidAndCompanyId(
			uuid, companyId);
	}

	/**
	 * Returns a range of register events matching the UUID and company.
	 *
	 * @param uuid the UUID of the register events
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of register events
	 * @param end the upper bound of the range of register events (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching register events, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<basic.model.RegisterEvent>
		getRegisterEventsByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<basic.model.RegisterEvent> orderByComparator) {

		return _registerEventLocalService.getRegisterEventsByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of register events.
	 *
	 * @return the number of register events
	 */
	@Override
	public int getRegisterEventsCount() {
		return _registerEventLocalService.getRegisterEventsCount();
	}

	/**
	 * Updates the register event in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param registerEvent the register event
	 * @return the register event that was updated
	 */
	@Override
	public basic.model.RegisterEvent updateRegisterEvent(
		basic.model.RegisterEvent registerEvent) {

		return _registerEventLocalService.updateRegisterEvent(registerEvent);
	}

	@Override
	public RegisterEventLocalService getWrappedService() {
		return _registerEventLocalService;
	}

	@Override
	public void setWrappedService(
		RegisterEventLocalService registerEventLocalService) {

		_registerEventLocalService = registerEventLocalService;
	}

	private RegisterEventLocalService _registerEventLocalService;

}