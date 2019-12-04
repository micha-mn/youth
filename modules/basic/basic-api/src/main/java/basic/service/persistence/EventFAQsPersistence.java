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

import basic.exception.NoSuchEventFAQsException;

import basic.model.EventFAQs;

import com.liferay.portal.kernel.service.persistence.BasePersistence;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the event fa qs service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EventFAQsUtil
 * @generated
 */
@ProviderType
public interface EventFAQsPersistence extends BasePersistence<EventFAQs> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link EventFAQsUtil} to access the event fa qs persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the event fa qses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching event fa qses
	 */
	public java.util.List<EventFAQs> findByUuid(String uuid);

	/**
	 * Returns a range of all the event fa qses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>EventFAQsModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of event fa qses
	 * @param end the upper bound of the range of event fa qses (not inclusive)
	 * @return the range of matching event fa qses
	 */
	public java.util.List<EventFAQs> findByUuid(
		String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the event fa qses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>EventFAQsModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findByUuid(String, int, int, OrderByComparator)}
	 * @param uuid the uuid
	 * @param start the lower bound of the range of event fa qses
	 * @param end the upper bound of the range of event fa qses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching event fa qses
	 */
	@Deprecated
	public java.util.List<EventFAQs> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<EventFAQs> orderByComparator, boolean useFinderCache);

	/**
	 * Returns an ordered range of all the event fa qses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>EventFAQsModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of event fa qses
	 * @param end the upper bound of the range of event fa qses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching event fa qses
	 */
	public java.util.List<EventFAQs> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<EventFAQs> orderByComparator);

	/**
	 * Returns the first event fa qs in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching event fa qs
	 * @throws NoSuchEventFAQsException if a matching event fa qs could not be found
	 */
	public EventFAQs findByUuid_First(
			String uuid, OrderByComparator<EventFAQs> orderByComparator)
		throws NoSuchEventFAQsException;

	/**
	 * Returns the first event fa qs in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching event fa qs, or <code>null</code> if a matching event fa qs could not be found
	 */
	public EventFAQs fetchByUuid_First(
		String uuid, OrderByComparator<EventFAQs> orderByComparator);

	/**
	 * Returns the last event fa qs in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching event fa qs
	 * @throws NoSuchEventFAQsException if a matching event fa qs could not be found
	 */
	public EventFAQs findByUuid_Last(
			String uuid, OrderByComparator<EventFAQs> orderByComparator)
		throws NoSuchEventFAQsException;

	/**
	 * Returns the last event fa qs in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching event fa qs, or <code>null</code> if a matching event fa qs could not be found
	 */
	public EventFAQs fetchByUuid_Last(
		String uuid, OrderByComparator<EventFAQs> orderByComparator);

	/**
	 * Returns the event fa qses before and after the current event fa qs in the ordered set where uuid = &#63;.
	 *
	 * @param id the primary key of the current event fa qs
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next event fa qs
	 * @throws NoSuchEventFAQsException if a event fa qs with the primary key could not be found
	 */
	public EventFAQs[] findByUuid_PrevAndNext(
			long id, String uuid,
			OrderByComparator<EventFAQs> orderByComparator)
		throws NoSuchEventFAQsException;

	/**
	 * Removes all the event fa qses where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of event fa qses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching event fa qses
	 */
	public int countByUuid(String uuid);

	/**
	 * Caches the event fa qs in the entity cache if it is enabled.
	 *
	 * @param eventFAQs the event fa qs
	 */
	public void cacheResult(EventFAQs eventFAQs);

	/**
	 * Caches the event fa qses in the entity cache if it is enabled.
	 *
	 * @param eventFAQses the event fa qses
	 */
	public void cacheResult(java.util.List<EventFAQs> eventFAQses);

	/**
	 * Creates a new event fa qs with the primary key. Does not add the event fa qs to the database.
	 *
	 * @param id the primary key for the new event fa qs
	 * @return the new event fa qs
	 */
	public EventFAQs create(long id);

	/**
	 * Removes the event fa qs with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the event fa qs
	 * @return the event fa qs that was removed
	 * @throws NoSuchEventFAQsException if a event fa qs with the primary key could not be found
	 */
	public EventFAQs remove(long id) throws NoSuchEventFAQsException;

	public EventFAQs updateImpl(EventFAQs eventFAQs);

	/**
	 * Returns the event fa qs with the primary key or throws a <code>NoSuchEventFAQsException</code> if it could not be found.
	 *
	 * @param id the primary key of the event fa qs
	 * @return the event fa qs
	 * @throws NoSuchEventFAQsException if a event fa qs with the primary key could not be found
	 */
	public EventFAQs findByPrimaryKey(long id) throws NoSuchEventFAQsException;

	/**
	 * Returns the event fa qs with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the event fa qs
	 * @return the event fa qs, or <code>null</code> if a event fa qs with the primary key could not be found
	 */
	public EventFAQs fetchByPrimaryKey(long id);

	/**
	 * Returns all the event fa qses.
	 *
	 * @return the event fa qses
	 */
	public java.util.List<EventFAQs> findAll();

	/**
	 * Returns a range of all the event fa qses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>EventFAQsModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of event fa qses
	 * @param end the upper bound of the range of event fa qses (not inclusive)
	 * @return the range of event fa qses
	 */
	public java.util.List<EventFAQs> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the event fa qses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>EventFAQsModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findAll(int, int, OrderByComparator)}
	 * @param start the lower bound of the range of event fa qses
	 * @param end the upper bound of the range of event fa qses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of event fa qses
	 */
	@Deprecated
	public java.util.List<EventFAQs> findAll(
		int start, int end, OrderByComparator<EventFAQs> orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns an ordered range of all the event fa qses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>EventFAQsModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of event fa qses
	 * @param end the upper bound of the range of event fa qses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of event fa qses
	 */
	public java.util.List<EventFAQs> findAll(
		int start, int end, OrderByComparator<EventFAQs> orderByComparator);

	/**
	 * Removes all the event fa qses from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of event fa qses.
	 *
	 * @return the number of event fa qses
	 */
	public int countAll();

}