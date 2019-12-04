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
 * Provides a wrapper for {@link EventHighLightsLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see EventHighLightsLocalService
 * @generated
 */
@ProviderType
public class EventHighLightsLocalServiceWrapper
	implements EventHighLightsLocalService,
			   ServiceWrapper<EventHighLightsLocalService> {

	public EventHighLightsLocalServiceWrapper(
		EventHighLightsLocalService eventHighLightsLocalService) {

		_eventHighLightsLocalService = eventHighLightsLocalService;
	}

	/**
	 * Adds the event high lights to the database. Also notifies the appropriate model listeners.
	 *
	 * @param eventHighLights the event high lights
	 * @return the event high lights that was added
	 */
	@Override
	public basic.model.EventHighLights addEventHighLights(
		basic.model.EventHighLights eventHighLights) {

		return _eventHighLightsLocalService.addEventHighLights(eventHighLights);
	}

	/**
	 * Creates a new event high lights with the primary key. Does not add the event high lights to the database.
	 *
	 * @param id the primary key for the new event high lights
	 * @return the new event high lights
	 */
	@Override
	public basic.model.EventHighLights createEventHighLights(long id) {
		return _eventHighLightsLocalService.createEventHighLights(id);
	}

	/**
	 * Deletes the event high lights from the database. Also notifies the appropriate model listeners.
	 *
	 * @param eventHighLights the event high lights
	 * @return the event high lights that was removed
	 */
	@Override
	public basic.model.EventHighLights deleteEventHighLights(
		basic.model.EventHighLights eventHighLights) {

		return _eventHighLightsLocalService.deleteEventHighLights(
			eventHighLights);
	}

	/**
	 * Deletes the event high lights with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the event high lights
	 * @return the event high lights that was removed
	 * @throws PortalException if a event high lights with the primary key could not be found
	 */
	@Override
	public basic.model.EventHighLights deleteEventHighLights(long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _eventHighLightsLocalService.deleteEventHighLights(id);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _eventHighLightsLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _eventHighLightsLocalService.dynamicQuery();
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

		return _eventHighLightsLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>basic.model.impl.EventHighLightsModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

		return _eventHighLightsLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>basic.model.impl.EventHighLightsModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

		return _eventHighLightsLocalService.dynamicQuery(
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

		return _eventHighLightsLocalService.dynamicQueryCount(dynamicQuery);
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

		return _eventHighLightsLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public basic.model.EventHighLights fetchEventHighLights(long id) {
		return _eventHighLightsLocalService.fetchEventHighLights(id);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _eventHighLightsLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the event high lights with the primary key.
	 *
	 * @param id the primary key of the event high lights
	 * @return the event high lights
	 * @throws PortalException if a event high lights with the primary key could not be found
	 */
	@Override
	public basic.model.EventHighLights getEventHighLights(long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _eventHighLightsLocalService.getEventHighLights(id);
	}

	/**
	 * Returns a range of all the event high lightses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>basic.model.impl.EventHighLightsModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of event high lightses
	 * @param end the upper bound of the range of event high lightses (not inclusive)
	 * @return the range of event high lightses
	 */
	@Override
	public java.util.List<basic.model.EventHighLights> getEventHighLightses(
		int start, int end) {

		return _eventHighLightsLocalService.getEventHighLightses(start, end);
	}

	/**
	 * Returns the number of event high lightses.
	 *
	 * @return the number of event high lightses
	 */
	@Override
	public int getEventHighLightsesCount() {
		return _eventHighLightsLocalService.getEventHighLightsesCount();
	}

	@Override
	public basic.model.EventHighLightsImageBlobModel getImageBlobModel(
		java.io.Serializable primaryKey) {

		return _eventHighLightsLocalService.getImageBlobModel(primaryKey);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _eventHighLightsLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _eventHighLightsLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _eventHighLightsLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the event high lights in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param eventHighLights the event high lights
	 * @return the event high lights that was updated
	 */
	@Override
	public basic.model.EventHighLights updateEventHighLights(
		basic.model.EventHighLights eventHighLights) {

		return _eventHighLightsLocalService.updateEventHighLights(
			eventHighLights);
	}

	@Override
	public EventHighLightsLocalService getWrappedService() {
		return _eventHighLightsLocalService;
	}

	@Override
	public void setWrappedService(
		EventHighLightsLocalService eventHighLightsLocalService) {

		_eventHighLightsLocalService = eventHighLightsLocalService;
	}

	private EventHighLightsLocalService _eventHighLightsLocalService;

}