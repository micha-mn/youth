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

import basic.exception.NoSuchEventTimelineException;

import basic.model.EventTimeline;

import com.liferay.portal.kernel.service.persistence.BasePersistence;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the event timeline service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EventTimelineUtil
 * @generated
 */
@ProviderType
public interface EventTimelinePersistence
	extends BasePersistence<EventTimeline> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link EventTimelineUtil} to access the event timeline persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the event timelines where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching event timelines
	 */
	public java.util.List<EventTimeline> findByUuid(String uuid);

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
	public java.util.List<EventTimeline> findByUuid(
		String uuid, int start, int end);

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
	public java.util.List<EventTimeline> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<EventTimeline> orderByComparator,
		boolean useFinderCache);

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
	public java.util.List<EventTimeline> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<EventTimeline> orderByComparator);

	/**
	 * Returns the first event timeline in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching event timeline
	 * @throws NoSuchEventTimelineException if a matching event timeline could not be found
	 */
	public EventTimeline findByUuid_First(
			String uuid, OrderByComparator<EventTimeline> orderByComparator)
		throws NoSuchEventTimelineException;

	/**
	 * Returns the first event timeline in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching event timeline, or <code>null</code> if a matching event timeline could not be found
	 */
	public EventTimeline fetchByUuid_First(
		String uuid, OrderByComparator<EventTimeline> orderByComparator);

	/**
	 * Returns the last event timeline in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching event timeline
	 * @throws NoSuchEventTimelineException if a matching event timeline could not be found
	 */
	public EventTimeline findByUuid_Last(
			String uuid, OrderByComparator<EventTimeline> orderByComparator)
		throws NoSuchEventTimelineException;

	/**
	 * Returns the last event timeline in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching event timeline, or <code>null</code> if a matching event timeline could not be found
	 */
	public EventTimeline fetchByUuid_Last(
		String uuid, OrderByComparator<EventTimeline> orderByComparator);

	/**
	 * Returns the event timelines before and after the current event timeline in the ordered set where uuid = &#63;.
	 *
	 * @param id the primary key of the current event timeline
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next event timeline
	 * @throws NoSuchEventTimelineException if a event timeline with the primary key could not be found
	 */
	public EventTimeline[] findByUuid_PrevAndNext(
			long id, String uuid,
			OrderByComparator<EventTimeline> orderByComparator)
		throws NoSuchEventTimelineException;

	/**
	 * Removes all the event timelines where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of event timelines where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching event timelines
	 */
	public int countByUuid(String uuid);

	/**
	 * Caches the event timeline in the entity cache if it is enabled.
	 *
	 * @param eventTimeline the event timeline
	 */
	public void cacheResult(EventTimeline eventTimeline);

	/**
	 * Caches the event timelines in the entity cache if it is enabled.
	 *
	 * @param eventTimelines the event timelines
	 */
	public void cacheResult(java.util.List<EventTimeline> eventTimelines);

	/**
	 * Creates a new event timeline with the primary key. Does not add the event timeline to the database.
	 *
	 * @param id the primary key for the new event timeline
	 * @return the new event timeline
	 */
	public EventTimeline create(long id);

	/**
	 * Removes the event timeline with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the event timeline
	 * @return the event timeline that was removed
	 * @throws NoSuchEventTimelineException if a event timeline with the primary key could not be found
	 */
	public EventTimeline remove(long id) throws NoSuchEventTimelineException;

	public EventTimeline updateImpl(EventTimeline eventTimeline);

	/**
	 * Returns the event timeline with the primary key or throws a <code>NoSuchEventTimelineException</code> if it could not be found.
	 *
	 * @param id the primary key of the event timeline
	 * @return the event timeline
	 * @throws NoSuchEventTimelineException if a event timeline with the primary key could not be found
	 */
	public EventTimeline findByPrimaryKey(long id)
		throws NoSuchEventTimelineException;

	/**
	 * Returns the event timeline with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the event timeline
	 * @return the event timeline, or <code>null</code> if a event timeline with the primary key could not be found
	 */
	public EventTimeline fetchByPrimaryKey(long id);

	/**
	 * Returns all the event timelines.
	 *
	 * @return the event timelines
	 */
	public java.util.List<EventTimeline> findAll();

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
	public java.util.List<EventTimeline> findAll(int start, int end);

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
	public java.util.List<EventTimeline> findAll(
		int start, int end, OrderByComparator<EventTimeline> orderByComparator,
		boolean useFinderCache);

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
	public java.util.List<EventTimeline> findAll(
		int start, int end, OrderByComparator<EventTimeline> orderByComparator);

	/**
	 * Removes all the event timelines from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of event timelines.
	 *
	 * @return the number of event timelines
	 */
	public int countAll();

}