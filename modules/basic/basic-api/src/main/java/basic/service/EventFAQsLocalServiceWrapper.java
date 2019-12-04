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
 * Provides a wrapper for {@link EventFAQsLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see EventFAQsLocalService
 * @generated
 */
@ProviderType
public class EventFAQsLocalServiceWrapper
	implements EventFAQsLocalService, ServiceWrapper<EventFAQsLocalService> {

	public EventFAQsLocalServiceWrapper(
		EventFAQsLocalService eventFAQsLocalService) {

		_eventFAQsLocalService = eventFAQsLocalService;
	}

	/**
	 * Adds the event fa qs to the database. Also notifies the appropriate model listeners.
	 *
	 * @param eventFAQs the event fa qs
	 * @return the event fa qs that was added
	 */
	@Override
	public basic.model.EventFAQs addEventFAQs(basic.model.EventFAQs eventFAQs) {
		return _eventFAQsLocalService.addEventFAQs(eventFAQs);
	}

	/**
	 * Creates a new event fa qs with the primary key. Does not add the event fa qs to the database.
	 *
	 * @param id the primary key for the new event fa qs
	 * @return the new event fa qs
	 */
	@Override
	public basic.model.EventFAQs createEventFAQs(long id) {
		return _eventFAQsLocalService.createEventFAQs(id);
	}

	/**
	 * Deletes the event fa qs from the database. Also notifies the appropriate model listeners.
	 *
	 * @param eventFAQs the event fa qs
	 * @return the event fa qs that was removed
	 */
	@Override
	public basic.model.EventFAQs deleteEventFAQs(
		basic.model.EventFAQs eventFAQs) {

		return _eventFAQsLocalService.deleteEventFAQs(eventFAQs);
	}

	/**
	 * Deletes the event fa qs with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the event fa qs
	 * @return the event fa qs that was removed
	 * @throws PortalException if a event fa qs with the primary key could not be found
	 */
	@Override
	public basic.model.EventFAQs deleteEventFAQs(long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _eventFAQsLocalService.deleteEventFAQs(id);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _eventFAQsLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _eventFAQsLocalService.dynamicQuery();
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

		return _eventFAQsLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>basic.model.impl.EventFAQsModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

		return _eventFAQsLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>basic.model.impl.EventFAQsModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

		return _eventFAQsLocalService.dynamicQuery(
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

		return _eventFAQsLocalService.dynamicQueryCount(dynamicQuery);
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

		return _eventFAQsLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public basic.model.EventFAQs fetchEventFAQs(long id) {
		return _eventFAQsLocalService.fetchEventFAQs(id);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _eventFAQsLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the event fa qs with the primary key.
	 *
	 * @param id the primary key of the event fa qs
	 * @return the event fa qs
	 * @throws PortalException if a event fa qs with the primary key could not be found
	 */
	@Override
	public basic.model.EventFAQs getEventFAQs(long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _eventFAQsLocalService.getEventFAQs(id);
	}

	/**
	 * Returns a range of all the event fa qses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>basic.model.impl.EventFAQsModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of event fa qses
	 * @param end the upper bound of the range of event fa qses (not inclusive)
	 * @return the range of event fa qses
	 */
	@Override
	public java.util.List<basic.model.EventFAQs> getEventFAQses(
		int start, int end) {

		return _eventFAQsLocalService.getEventFAQses(start, end);
	}

	/**
	 * Returns the number of event fa qses.
	 *
	 * @return the number of event fa qses
	 */
	@Override
	public int getEventFAQsesCount() {
		return _eventFAQsLocalService.getEventFAQsesCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _eventFAQsLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _eventFAQsLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _eventFAQsLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the event fa qs in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param eventFAQs the event fa qs
	 * @return the event fa qs that was updated
	 */
	@Override
	public basic.model.EventFAQs updateEventFAQs(
		basic.model.EventFAQs eventFAQs) {

		return _eventFAQsLocalService.updateEventFAQs(eventFAQs);
	}

	@Override
	public EventFAQsLocalService getWrappedService() {
		return _eventFAQsLocalService;
	}

	@Override
	public void setWrappedService(EventFAQsLocalService eventFAQsLocalService) {
		_eventFAQsLocalService = eventFAQsLocalService;
	}

	private EventFAQsLocalService _eventFAQsLocalService;

}