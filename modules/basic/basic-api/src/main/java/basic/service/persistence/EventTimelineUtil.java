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

import basic.model.EventTimeline;

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
 * The persistence utility for the event timeline service. This utility wraps <code>basic.service.persistence.impl.EventTimelinePersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EventTimelinePersistence
 * @generated
 */
@ProviderType
public class EventTimelineUtil {

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
	public static void clearCache(EventTimeline eventTimeline) {
		getPersistence().clearCache(eventTimeline);
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
	public static Map<Serializable, EventTimeline> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<EventTimeline> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<EventTimeline> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<EventTimeline> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<EventTimeline> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static EventTimeline update(EventTimeline eventTimeline) {
		return getPersistence().update(eventTimeline);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static EventTimeline update(
		EventTimeline eventTimeline, ServiceContext serviceContext) {

		return getPersistence().update(eventTimeline, serviceContext);
	}

	/**
	 * Returns all the event timelines where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching event timelines
	 */
	public static List<EventTimeline> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the event timelines where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>EventTimelineModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of event timelines
	 * @param end the upper bound of the range of event timelines (not inclusive)
	 * @return the range of matching event timelines
	 */
	public static List<EventTimeline> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the event timelines where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>EventTimelineModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findByUuid(String, int, int, OrderByComparator)}
	 * @param uuid the uuid
	 * @param start the lower bound of the range of event timelines
	 * @param end the upper bound of the range of event timelines (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching event timelines
	 */
	@Deprecated
	public static List<EventTimeline> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<EventTimeline> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns an ordered range of all the event timelines where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>EventTimelineModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of event timelines
	 * @param end the upper bound of the range of event timelines (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching event timelines
	 */
	public static List<EventTimeline> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<EventTimeline> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns the first event timeline in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching event timeline
	 * @throws NoSuchEventTimelineException if a matching event timeline could not be found
	 */
	public static EventTimeline findByUuid_First(
			String uuid, OrderByComparator<EventTimeline> orderByComparator)
		throws basic.exception.NoSuchEventTimelineException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first event timeline in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching event timeline, or <code>null</code> if a matching event timeline could not be found
	 */
	public static EventTimeline fetchByUuid_First(
		String uuid, OrderByComparator<EventTimeline> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last event timeline in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching event timeline
	 * @throws NoSuchEventTimelineException if a matching event timeline could not be found
	 */
	public static EventTimeline findByUuid_Last(
			String uuid, OrderByComparator<EventTimeline> orderByComparator)
		throws basic.exception.NoSuchEventTimelineException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last event timeline in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching event timeline, or <code>null</code> if a matching event timeline could not be found
	 */
	public static EventTimeline fetchByUuid_Last(
		String uuid, OrderByComparator<EventTimeline> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the event timelines before and after the current event timeline in the ordered set where uuid = &#63;.
	 *
	 * @param id the primary key of the current event timeline
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next event timeline
	 * @throws NoSuchEventTimelineException if a event timeline with the primary key could not be found
	 */
	public static EventTimeline[] findByUuid_PrevAndNext(
			long id, String uuid,
			OrderByComparator<EventTimeline> orderByComparator)
		throws basic.exception.NoSuchEventTimelineException {

		return getPersistence().findByUuid_PrevAndNext(
			id, uuid, orderByComparator);
	}

	/**
	 * Removes all the event timelines where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of event timelines where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching event timelines
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Caches the event timeline in the entity cache if it is enabled.
	 *
	 * @param eventTimeline the event timeline
	 */
	public static void cacheResult(EventTimeline eventTimeline) {
		getPersistence().cacheResult(eventTimeline);
	}

	/**
	 * Caches the event timelines in the entity cache if it is enabled.
	 *
	 * @param eventTimelines the event timelines
	 */
	public static void cacheResult(List<EventTimeline> eventTimelines) {
		getPersistence().cacheResult(eventTimelines);
	}

	/**
	 * Creates a new event timeline with the primary key. Does not add the event timeline to the database.
	 *
	 * @param id the primary key for the new event timeline
	 * @return the new event timeline
	 */
	public static EventTimeline create(long id) {
		return getPersistence().create(id);
	}

	/**
	 * Removes the event timeline with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the event timeline
	 * @return the event timeline that was removed
	 * @throws NoSuchEventTimelineException if a event timeline with the primary key could not be found
	 */
	public static EventTimeline remove(long id)
		throws basic.exception.NoSuchEventTimelineException {

		return getPersistence().remove(id);
	}

	public static EventTimeline updateImpl(EventTimeline eventTimeline) {
		return getPersistence().updateImpl(eventTimeline);
	}

	/**
	 * Returns the event timeline with the primary key or throws a <code>NoSuchEventTimelineException</code> if it could not be found.
	 *
	 * @param id the primary key of the event timeline
	 * @return the event timeline
	 * @throws NoSuchEventTimelineException if a event timeline with the primary key could not be found
	 */
	public static EventTimeline findByPrimaryKey(long id)
		throws basic.exception.NoSuchEventTimelineException {

		return getPersistence().findByPrimaryKey(id);
	}

	/**
	 * Returns the event timeline with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the event timeline
	 * @return the event timeline, or <code>null</code> if a event timeline with the primary key could not be found
	 */
	public static EventTimeline fetchByPrimaryKey(long id) {
		return getPersistence().fetchByPrimaryKey(id);
	}

	/**
	 * Returns all the event timelines.
	 *
	 * @return the event timelines
	 */
	public static List<EventTimeline> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the event timelines.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>EventTimelineModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of event timelines
	 * @param end the upper bound of the range of event timelines (not inclusive)
	 * @return the range of event timelines
	 */
	public static List<EventTimeline> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the event timelines.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>EventTimelineModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findAll(int, int, OrderByComparator)}
	 * @param start the lower bound of the range of event timelines
	 * @param end the upper bound of the range of event timelines (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of event timelines
	 */
	@Deprecated
	public static List<EventTimeline> findAll(
		int start, int end, OrderByComparator<EventTimeline> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns an ordered range of all the event timelines.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>EventTimelineModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of event timelines
	 * @param end the upper bound of the range of event timelines (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of event timelines
	 */
	public static List<EventTimeline> findAll(
		int start, int end,
		OrderByComparator<EventTimeline> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Removes all the event timelines from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of event timelines.
	 *
	 * @return the number of event timelines
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static EventTimelinePersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<EventTimelinePersistence, EventTimelinePersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(EventTimelinePersistence.class);

		ServiceTracker<EventTimelinePersistence, EventTimelinePersistence>
			serviceTracker =
				new ServiceTracker
					<EventTimelinePersistence, EventTimelinePersistence>(
						bundle.getBundleContext(),
						EventTimelinePersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}