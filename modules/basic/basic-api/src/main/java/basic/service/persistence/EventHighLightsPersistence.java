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

import basic.exception.NoSuchEventHighLightsException;

import basic.model.EventHighLights;

import com.liferay.portal.kernel.service.persistence.BasePersistence;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the event high lights service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EventHighLightsUtil
 * @generated
 */
@ProviderType
public interface EventHighLightsPersistence
	extends BasePersistence<EventHighLights> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link EventHighLightsUtil} to access the event high lights persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the event high lightses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching event high lightses
	 */
	public java.util.List<EventHighLights> findByUuid(String uuid);

	/**
	 * Returns a range of all the event high lightses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>EventHighLightsModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of event high lightses
	 * @param end the upper bound of the range of event high lightses (not inclusive)
	 * @return the range of matching event high lightses
	 */
	public java.util.List<EventHighLights> findByUuid(
		String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the event high lightses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>EventHighLightsModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findByUuid(String, int, int, OrderByComparator)}
	 * @param uuid the uuid
	 * @param start the lower bound of the range of event high lightses
	 * @param end the upper bound of the range of event high lightses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching event high lightses
	 */
	@Deprecated
	public java.util.List<EventHighLights> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<EventHighLights> orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns an ordered range of all the event high lightses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>EventHighLightsModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of event high lightses
	 * @param end the upper bound of the range of event high lightses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching event high lightses
	 */
	public java.util.List<EventHighLights> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<EventHighLights> orderByComparator);

	/**
	 * Returns the first event high lights in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching event high lights
	 * @throws NoSuchEventHighLightsException if a matching event high lights could not be found
	 */
	public EventHighLights findByUuid_First(
			String uuid, OrderByComparator<EventHighLights> orderByComparator)
		throws NoSuchEventHighLightsException;

	/**
	 * Returns the first event high lights in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching event high lights, or <code>null</code> if a matching event high lights could not be found
	 */
	public EventHighLights fetchByUuid_First(
		String uuid, OrderByComparator<EventHighLights> orderByComparator);

	/**
	 * Returns the last event high lights in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching event high lights
	 * @throws NoSuchEventHighLightsException if a matching event high lights could not be found
	 */
	public EventHighLights findByUuid_Last(
			String uuid, OrderByComparator<EventHighLights> orderByComparator)
		throws NoSuchEventHighLightsException;

	/**
	 * Returns the last event high lights in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching event high lights, or <code>null</code> if a matching event high lights could not be found
	 */
	public EventHighLights fetchByUuid_Last(
		String uuid, OrderByComparator<EventHighLights> orderByComparator);

	/**
	 * Returns the event high lightses before and after the current event high lights in the ordered set where uuid = &#63;.
	 *
	 * @param id the primary key of the current event high lights
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next event high lights
	 * @throws NoSuchEventHighLightsException if a event high lights with the primary key could not be found
	 */
	public EventHighLights[] findByUuid_PrevAndNext(
			long id, String uuid,
			OrderByComparator<EventHighLights> orderByComparator)
		throws NoSuchEventHighLightsException;

	/**
	 * Removes all the event high lightses where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of event high lightses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching event high lightses
	 */
	public int countByUuid(String uuid);

	/**
	 * Caches the event high lights in the entity cache if it is enabled.
	 *
	 * @param eventHighLights the event high lights
	 */
	public void cacheResult(EventHighLights eventHighLights);

	/**
	 * Caches the event high lightses in the entity cache if it is enabled.
	 *
	 * @param eventHighLightses the event high lightses
	 */
	public void cacheResult(java.util.List<EventHighLights> eventHighLightses);

	/**
	 * Creates a new event high lights with the primary key. Does not add the event high lights to the database.
	 *
	 * @param id the primary key for the new event high lights
	 * @return the new event high lights
	 */
	public EventHighLights create(long id);

	/**
	 * Removes the event high lights with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the event high lights
	 * @return the event high lights that was removed
	 * @throws NoSuchEventHighLightsException if a event high lights with the primary key could not be found
	 */
	public EventHighLights remove(long id)
		throws NoSuchEventHighLightsException;

	public EventHighLights updateImpl(EventHighLights eventHighLights);

	/**
	 * Returns the event high lights with the primary key or throws a <code>NoSuchEventHighLightsException</code> if it could not be found.
	 *
	 * @param id the primary key of the event high lights
	 * @return the event high lights
	 * @throws NoSuchEventHighLightsException if a event high lights with the primary key could not be found
	 */
	public EventHighLights findByPrimaryKey(long id)
		throws NoSuchEventHighLightsException;

	/**
	 * Returns the event high lights with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the event high lights
	 * @return the event high lights, or <code>null</code> if a event high lights with the primary key could not be found
	 */
	public EventHighLights fetchByPrimaryKey(long id);

	/**
	 * Returns all the event high lightses.
	 *
	 * @return the event high lightses
	 */
	public java.util.List<EventHighLights> findAll();

	/**
	 * Returns a range of all the event high lightses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>EventHighLightsModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of event high lightses
	 * @param end the upper bound of the range of event high lightses (not inclusive)
	 * @return the range of event high lightses
	 */
	public java.util.List<EventHighLights> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the event high lightses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>EventHighLightsModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findAll(int, int, OrderByComparator)}
	 * @param start the lower bound of the range of event high lightses
	 * @param end the upper bound of the range of event high lightses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of event high lightses
	 */
	@Deprecated
	public java.util.List<EventHighLights> findAll(
		int start, int end,
		OrderByComparator<EventHighLights> orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns an ordered range of all the event high lightses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>EventHighLightsModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of event high lightses
	 * @param end the upper bound of the range of event high lightses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of event high lightses
	 */
	public java.util.List<EventHighLights> findAll(
		int start, int end,
		OrderByComparator<EventHighLights> orderByComparator);

	/**
	 * Removes all the event high lightses from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of event high lightses.
	 *
	 * @return the number of event high lightses
	 */
	public int countAll();

}