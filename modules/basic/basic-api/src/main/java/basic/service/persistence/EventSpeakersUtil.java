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

package basic.service.persistence;

import basic.model.EventSpeakers;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.osgi.annotation.versioning.ProviderType;
import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the event speakers service. This utility wraps <code>basic.service.persistence.impl.EventSpeakersPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EventSpeakersPersistence
 * @generated
 */
@ProviderType
public class EventSpeakersUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(EventSpeakers eventSpeakers) {
		getPersistence().clearCache(eventSpeakers);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#fetchByPrimaryKeys(Set)
	 */
	public static Map<Serializable, EventSpeakers> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<EventSpeakers> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<EventSpeakers> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<EventSpeakers> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<EventSpeakers> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static EventSpeakers update(EventSpeakers eventSpeakers) {
		return getPersistence().update(eventSpeakers);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static EventSpeakers update(
		EventSpeakers eventSpeakers, ServiceContext serviceContext) {

		return getPersistence().update(eventSpeakers, serviceContext);
	}

	/**
	 * Returns all the event speakerses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching event speakerses
	 */
	public static List<EventSpeakers> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the event speakerses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>EventSpeakersModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of event speakerses
	 * @param end the upper bound of the range of event speakerses (not inclusive)
	 * @return the range of matching event speakerses
	 */
	public static List<EventSpeakers> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the event speakerses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>EventSpeakersModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findByUuid(String, int, int, OrderByComparator)}
	 * @param uuid the uuid
	 * @param start the lower bound of the range of event speakerses
	 * @param end the upper bound of the range of event speakerses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching event speakerses
	 */
	@Deprecated
	public static List<EventSpeakers> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<EventSpeakers> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns an ordered range of all the event speakerses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>EventSpeakersModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of event speakerses
	 * @param end the upper bound of the range of event speakerses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching event speakerses
	 */
	public static List<EventSpeakers> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<EventSpeakers> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns the first event speakers in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching event speakers
	 * @throws NoSuchEventSpeakersException if a matching event speakers could not be found
	 */
	public static EventSpeakers findByUuid_First(
			String uuid, OrderByComparator<EventSpeakers> orderByComparator)
		throws basic.exception.NoSuchEventSpeakersException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first event speakers in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching event speakers, or <code>null</code> if a matching event speakers could not be found
	 */
	public static EventSpeakers fetchByUuid_First(
		String uuid, OrderByComparator<EventSpeakers> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last event speakers in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching event speakers
	 * @throws NoSuchEventSpeakersException if a matching event speakers could not be found
	 */
	public static EventSpeakers findByUuid_Last(
			String uuid, OrderByComparator<EventSpeakers> orderByComparator)
		throws basic.exception.NoSuchEventSpeakersException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last event speakers in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching event speakers, or <code>null</code> if a matching event speakers could not be found
	 */
	public static EventSpeakers fetchByUuid_Last(
		String uuid, OrderByComparator<EventSpeakers> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the event speakerses before and after the current event speakers in the ordered set where uuid = &#63;.
	 *
	 * @param id the primary key of the current event speakers
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next event speakers
	 * @throws NoSuchEventSpeakersException if a event speakers with the primary key could not be found
	 */
	public static EventSpeakers[] findByUuid_PrevAndNext(
			long id, String uuid,
			OrderByComparator<EventSpeakers> orderByComparator)
		throws basic.exception.NoSuchEventSpeakersException {

		return getPersistence().findByUuid_PrevAndNext(
			id, uuid, orderByComparator);
	}

	/**
	 * Removes all the event speakerses where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of event speakerses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching event speakerses
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Caches the event speakers in the entity cache if it is enabled.
	 *
	 * @param eventSpeakers the event speakers
	 */
	public static void cacheResult(EventSpeakers eventSpeakers) {
		getPersistence().cacheResult(eventSpeakers);
	}

	/**
	 * Caches the event speakerses in the entity cache if it is enabled.
	 *
	 * @param eventSpeakerses the event speakerses
	 */
	public static void cacheResult(List<EventSpeakers> eventSpeakerses) {
		getPersistence().cacheResult(eventSpeakerses);
	}

	/**
	 * Creates a new event speakers with the primary key. Does not add the event speakers to the database.
	 *
	 * @param id the primary key for the new event speakers
	 * @return the new event speakers
	 */
	public static EventSpeakers create(long id) {
		return getPersistence().create(id);
	}

	/**
	 * Removes the event speakers with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the event speakers
	 * @return the event speakers that was removed
	 * @throws NoSuchEventSpeakersException if a event speakers with the primary key could not be found
	 */
	public static EventSpeakers remove(long id)
		throws basic.exception.NoSuchEventSpeakersException {

		return getPersistence().remove(id);
	}

	public static EventSpeakers updateImpl(EventSpeakers eventSpeakers) {
		return getPersistence().updateImpl(eventSpeakers);
	}

	/**
	 * Returns the event speakers with the primary key or throws a <code>NoSuchEventSpeakersException</code> if it could not be found.
	 *
	 * @param id the primary key of the event speakers
	 * @return the event speakers
	 * @throws NoSuchEventSpeakersException if a event speakers with the primary key could not be found
	 */
	public static EventSpeakers findByPrimaryKey(long id)
		throws basic.exception.NoSuchEventSpeakersException {

		return getPersistence().findByPrimaryKey(id);
	}

	/**
	 * Returns the event speakers with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the event speakers
	 * @return the event speakers, or <code>null</code> if a event speakers with the primary key could not be found
	 */
	public static EventSpeakers fetchByPrimaryKey(long id) {
		return getPersistence().fetchByPrimaryKey(id);
	}

	/**
	 * Returns all the event speakerses.
	 *
	 * @return the event speakerses
	 */
	public static List<EventSpeakers> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the event speakerses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>EventSpeakersModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of event speakerses
	 * @param end the upper bound of the range of event speakerses (not inclusive)
	 * @return the range of event speakerses
	 */
	public static List<EventSpeakers> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the event speakerses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>EventSpeakersModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findAll(int, int, OrderByComparator)}
	 * @param start the lower bound of the range of event speakerses
	 * @param end the upper bound of the range of event speakerses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of event speakerses
	 */
	@Deprecated
	public static List<EventSpeakers> findAll(
		int start, int end, OrderByComparator<EventSpeakers> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns an ordered range of all the event speakerses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>EventSpeakersModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of event speakerses
	 * @param end the upper bound of the range of event speakerses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of event speakerses
	 */
	public static List<EventSpeakers> findAll(
		int start, int end,
		OrderByComparator<EventSpeakers> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Removes all the event speakerses from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of event speakerses.
	 *
	 * @return the number of event speakerses
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static EventSpeakersPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<EventSpeakersPersistence, EventSpeakersPersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(EventSpeakersPersistence.class);

		ServiceTracker<EventSpeakersPersistence, EventSpeakersPersistence>
			serviceTracker =
				new ServiceTracker
					<EventSpeakersPersistence, EventSpeakersPersistence>(
						bundle.getBundleContext(),
						EventSpeakersPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}