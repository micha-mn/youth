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

import basic.exception.NoSuchEventSpeakersException;

import basic.model.EventSpeakers;

import com.liferay.portal.kernel.service.persistence.BasePersistence;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the event speakers service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EventSpeakersUtil
 * @generated
 */
@ProviderType
public interface EventSpeakersPersistence
	extends BasePersistence<EventSpeakers> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link EventSpeakersUtil} to access the event speakers persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the event speakerses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching event speakerses
	 */
	public java.util.List<EventSpeakers> findByUuid(String uuid);

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
	public java.util.List<EventSpeakers> findByUuid(
		String uuid, int start, int end);

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
	public java.util.List<EventSpeakers> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<EventSpeakers> orderByComparator,
		boolean useFinderCache);

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
	public java.util.List<EventSpeakers> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<EventSpeakers> orderByComparator);

	/**
	 * Returns the first event speakers in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching event speakers
	 * @throws NoSuchEventSpeakersException if a matching event speakers could not be found
	 */
	public EventSpeakers findByUuid_First(
			String uuid, OrderByComparator<EventSpeakers> orderByComparator)
		throws NoSuchEventSpeakersException;

	/**
	 * Returns the first event speakers in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching event speakers, or <code>null</code> if a matching event speakers could not be found
	 */
	public EventSpeakers fetchByUuid_First(
		String uuid, OrderByComparator<EventSpeakers> orderByComparator);

	/**
	 * Returns the last event speakers in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching event speakers
	 * @throws NoSuchEventSpeakersException if a matching event speakers could not be found
	 */
	public EventSpeakers findByUuid_Last(
			String uuid, OrderByComparator<EventSpeakers> orderByComparator)
		throws NoSuchEventSpeakersException;

	/**
	 * Returns the last event speakers in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching event speakers, or <code>null</code> if a matching event speakers could not be found
	 */
	public EventSpeakers fetchByUuid_Last(
		String uuid, OrderByComparator<EventSpeakers> orderByComparator);

	/**
	 * Returns the event speakerses before and after the current event speakers in the ordered set where uuid = &#63;.
	 *
	 * @param id the primary key of the current event speakers
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next event speakers
	 * @throws NoSuchEventSpeakersException if a event speakers with the primary key could not be found
	 */
	public EventSpeakers[] findByUuid_PrevAndNext(
			long id, String uuid,
			OrderByComparator<EventSpeakers> orderByComparator)
		throws NoSuchEventSpeakersException;

	/**
	 * Removes all the event speakerses where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of event speakerses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching event speakerses
	 */
	public int countByUuid(String uuid);

	/**
	 * Caches the event speakers in the entity cache if it is enabled.
	 *
	 * @param eventSpeakers the event speakers
	 */
	public void cacheResult(EventSpeakers eventSpeakers);

	/**
	 * Caches the event speakerses in the entity cache if it is enabled.
	 *
	 * @param eventSpeakerses the event speakerses
	 */
	public void cacheResult(java.util.List<EventSpeakers> eventSpeakerses);

	/**
	 * Creates a new event speakers with the primary key. Does not add the event speakers to the database.
	 *
	 * @param id the primary key for the new event speakers
	 * @return the new event speakers
	 */
	public EventSpeakers create(long id);

	/**
	 * Removes the event speakers with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the event speakers
	 * @return the event speakers that was removed
	 * @throws NoSuchEventSpeakersException if a event speakers with the primary key could not be found
	 */
	public EventSpeakers remove(long id) throws NoSuchEventSpeakersException;

	public EventSpeakers updateImpl(EventSpeakers eventSpeakers);

	/**
	 * Returns the event speakers with the primary key or throws a <code>NoSuchEventSpeakersException</code> if it could not be found.
	 *
	 * @param id the primary key of the event speakers
	 * @return the event speakers
	 * @throws NoSuchEventSpeakersException if a event speakers with the primary key could not be found
	 */
	public EventSpeakers findByPrimaryKey(long id)
		throws NoSuchEventSpeakersException;

	/**
	 * Returns the event speakers with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the event speakers
	 * @return the event speakers, or <code>null</code> if a event speakers with the primary key could not be found
	 */
	public EventSpeakers fetchByPrimaryKey(long id);

	/**
	 * Returns all the event speakerses.
	 *
	 * @return the event speakerses
	 */
	public java.util.List<EventSpeakers> findAll();

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
	public java.util.List<EventSpeakers> findAll(int start, int end);

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
	public java.util.List<EventSpeakers> findAll(
		int start, int end, OrderByComparator<EventSpeakers> orderByComparator,
		boolean useFinderCache);

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
	public java.util.List<EventSpeakers> findAll(
		int start, int end, OrderByComparator<EventSpeakers> orderByComparator);

	/**
	 * Removes all the event speakerses from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of event speakerses.
	 *
	 * @return the number of event speakerses
	 */
	public int countAll();

}