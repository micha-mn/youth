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
 * Provides a wrapper for {@link EventSpeakersLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see EventSpeakersLocalService
 * @generated
 */
@ProviderType
public class EventSpeakersLocalServiceWrapper
	implements EventSpeakersLocalService,
			   ServiceWrapper<EventSpeakersLocalService> {

	public EventSpeakersLocalServiceWrapper(
		EventSpeakersLocalService eventSpeakersLocalService) {

		_eventSpeakersLocalService = eventSpeakersLocalService;
	}

	/**
	 * Adds the event speakers to the database. Also notifies the appropriate model listeners.
	 *
	 * @param eventSpeakers the event speakers
	 * @return the event speakers that was added
	 */
	@Override
	public basic.model.EventSpeakers addEventSpeakers(
		basic.model.EventSpeakers eventSpeakers) {

		return _eventSpeakersLocalService.addEventSpeakers(eventSpeakers);
	}

	/**
	 * Creates a new event speakers with the primary key. Does not add the event speakers to the database.
	 *
	 * @param id the primary key for the new event speakers
	 * @return the new event speakers
	 */
	@Override
	public basic.model.EventSpeakers createEventSpeakers(long id) {
		return _eventSpeakersLocalService.createEventSpeakers(id);
	}

	/**
	 * Deletes the event speakers from the database. Also notifies the appropriate model listeners.
	 *
	 * @param eventSpeakers the event speakers
	 * @return the event speakers that was removed
	 */
	@Override
	public basic.model.EventSpeakers deleteEventSpeakers(
		basic.model.EventSpeakers eventSpeakers) {

		return _eventSpeakersLocalService.deleteEventSpeakers(eventSpeakers);
	}

	/**
	 * Deletes the event speakers with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the event speakers
	 * @return the event speakers that was removed
	 * @throws PortalException if a event speakers with the primary key could not be found
	 */
	@Override
	public basic.model.EventSpeakers deleteEventSpeakers(long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _eventSpeakersLocalService.deleteEventSpeakers(id);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _eventSpeakersLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _eventSpeakersLocalService.dynamicQuery();
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

		return _eventSpeakersLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>basic.model.impl.EventSpeakersModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

		return _eventSpeakersLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>basic.model.impl.EventSpeakersModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

		return _eventSpeakersLocalService.dynamicQuery(
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

		return _eventSpeakersLocalService.dynamicQueryCount(dynamicQuery);
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

		return _eventSpeakersLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public basic.model.EventSpeakers fetchEventSpeakers(long id) {
		return _eventSpeakersLocalService.fetchEventSpeakers(id);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _eventSpeakersLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the event speakers with the primary key.
	 *
	 * @param id the primary key of the event speakers
	 * @return the event speakers
	 * @throws PortalException if a event speakers with the primary key could not be found
	 */
	@Override
	public basic.model.EventSpeakers getEventSpeakers(long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _eventSpeakersLocalService.getEventSpeakers(id);
	}

	/**
	 * Returns a range of all the event speakerses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>basic.model.impl.EventSpeakersModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of event speakerses
	 * @param end the upper bound of the range of event speakerses (not inclusive)
	 * @return the range of event speakerses
	 */
	@Override
	public java.util.List<basic.model.EventSpeakers> getEventSpeakerses(
		int start, int end) {

		return _eventSpeakersLocalService.getEventSpeakerses(start, end);
	}

	/**
	 * Returns the number of event speakerses.
	 *
	 * @return the number of event speakerses
	 */
	@Override
	public int getEventSpeakersesCount() {
		return _eventSpeakersLocalService.getEventSpeakersesCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _eventSpeakersLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _eventSpeakersLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _eventSpeakersLocalService.getPersistedModel(primaryKeyObj);
	}

	@Override
	public basic.model.EventSpeakersSpeakerImageBlobModel
		getSpeakerImageBlobModel(java.io.Serializable primaryKey) {

		return _eventSpeakersLocalService.getSpeakerImageBlobModel(primaryKey);
	}

	/**
	 * Updates the event speakers in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param eventSpeakers the event speakers
	 * @return the event speakers that was updated
	 */
	@Override
	public basic.model.EventSpeakers updateEventSpeakers(
		basic.model.EventSpeakers eventSpeakers) {

		return _eventSpeakersLocalService.updateEventSpeakers(eventSpeakers);
	}

	@Override
	public EventSpeakersLocalService getWrappedService() {
		return _eventSpeakersLocalService;
	}

	@Override
	public void setWrappedService(
		EventSpeakersLocalService eventSpeakersLocalService) {

		_eventSpeakersLocalService = eventSpeakersLocalService;
	}

	private EventSpeakersLocalService _eventSpeakersLocalService;

}