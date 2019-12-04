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

import basic.exception.NoSuchEventAssigneeTableException;

import basic.model.EventAssigneeTable;

import com.liferay.portal.kernel.service.persistence.BasePersistence;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the event assignee table service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EventAssigneeTableUtil
 * @generated
 */
@ProviderType
public interface EventAssigneeTablePersistence
	extends BasePersistence<EventAssigneeTable> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link EventAssigneeTableUtil} to access the event assignee table persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the event assignee tables where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching event assignee tables
	 */
	public java.util.List<EventAssigneeTable> findByUuid(String uuid);

	/**
	 * Returns a range of all the event assignee tables where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>EventAssigneeTableModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of event assignee tables
	 * @param end the upper bound of the range of event assignee tables (not inclusive)
	 * @return the range of matching event assignee tables
	 */
	public java.util.List<EventAssigneeTable> findByUuid(
		String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the event assignee tables where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>EventAssigneeTableModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findByUuid(String, int, int, OrderByComparator)}
	 * @param uuid the uuid
	 * @param start the lower bound of the range of event assignee tables
	 * @param end the upper bound of the range of event assignee tables (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching event assignee tables
	 */
	@Deprecated
	public java.util.List<EventAssigneeTable> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<EventAssigneeTable> orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns an ordered range of all the event assignee tables where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>EventAssigneeTableModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of event assignee tables
	 * @param end the upper bound of the range of event assignee tables (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching event assignee tables
	 */
	public java.util.List<EventAssigneeTable> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<EventAssigneeTable> orderByComparator);

	/**
	 * Returns the first event assignee table in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching event assignee table
	 * @throws NoSuchEventAssigneeTableException if a matching event assignee table could not be found
	 */
	public EventAssigneeTable findByUuid_First(
			String uuid,
			OrderByComparator<EventAssigneeTable> orderByComparator)
		throws NoSuchEventAssigneeTableException;

	/**
	 * Returns the first event assignee table in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching event assignee table, or <code>null</code> if a matching event assignee table could not be found
	 */
	public EventAssigneeTable fetchByUuid_First(
		String uuid, OrderByComparator<EventAssigneeTable> orderByComparator);

	/**
	 * Returns the last event assignee table in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching event assignee table
	 * @throws NoSuchEventAssigneeTableException if a matching event assignee table could not be found
	 */
	public EventAssigneeTable findByUuid_Last(
			String uuid,
			OrderByComparator<EventAssigneeTable> orderByComparator)
		throws NoSuchEventAssigneeTableException;

	/**
	 * Returns the last event assignee table in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching event assignee table, or <code>null</code> if a matching event assignee table could not be found
	 */
	public EventAssigneeTable fetchByUuid_Last(
		String uuid, OrderByComparator<EventAssigneeTable> orderByComparator);

	/**
	 * Returns the event assignee tables before and after the current event assignee table in the ordered set where uuid = &#63;.
	 *
	 * @param Id the primary key of the current event assignee table
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next event assignee table
	 * @throws NoSuchEventAssigneeTableException if a event assignee table with the primary key could not be found
	 */
	public EventAssigneeTable[] findByUuid_PrevAndNext(
			int Id, String uuid,
			OrderByComparator<EventAssigneeTable> orderByComparator)
		throws NoSuchEventAssigneeTableException;

	/**
	 * Removes all the event assignee tables where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of event assignee tables where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching event assignee tables
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the event assignee table where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchEventAssigneeTableException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching event assignee table
	 * @throws NoSuchEventAssigneeTableException if a matching event assignee table could not be found
	 */
	public EventAssigneeTable findByUUID_G(String uuid, long groupId)
		throws NoSuchEventAssigneeTableException;

	/**
	 * Returns the event assignee table where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #fetchByUUID_G(String,long)}
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching event assignee table, or <code>null</code> if a matching event assignee table could not be found
	 */
	@Deprecated
	public EventAssigneeTable fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Returns the event assignee table where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching event assignee table, or <code>null</code> if a matching event assignee table could not be found
	 */
	public EventAssigneeTable fetchByUUID_G(String uuid, long groupId);

	/**
	 * Removes the event assignee table where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the event assignee table that was removed
	 */
	public EventAssigneeTable removeByUUID_G(String uuid, long groupId)
		throws NoSuchEventAssigneeTableException;

	/**
	 * Returns the number of event assignee tables where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching event assignee tables
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the event assignee tables where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching event assignee tables
	 */
	public java.util.List<EventAssigneeTable> findByUuid_C(
		String uuid, long companyId);

	/**
	 * Returns a range of all the event assignee tables where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>EventAssigneeTableModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of event assignee tables
	 * @param end the upper bound of the range of event assignee tables (not inclusive)
	 * @return the range of matching event assignee tables
	 */
	public java.util.List<EventAssigneeTable> findByUuid_C(
		String uuid, long companyId, int start, int end);

	/**
	 * Returns an ordered range of all the event assignee tables where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>EventAssigneeTableModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findByUuid_C(String,long, int, int, OrderByComparator)}
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of event assignee tables
	 * @param end the upper bound of the range of event assignee tables (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching event assignee tables
	 */
	@Deprecated
	public java.util.List<EventAssigneeTable> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<EventAssigneeTable> orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns an ordered range of all the event assignee tables where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>EventAssigneeTableModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of event assignee tables
	 * @param end the upper bound of the range of event assignee tables (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching event assignee tables
	 */
	public java.util.List<EventAssigneeTable> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<EventAssigneeTable> orderByComparator);

	/**
	 * Returns the first event assignee table in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching event assignee table
	 * @throws NoSuchEventAssigneeTableException if a matching event assignee table could not be found
	 */
	public EventAssigneeTable findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<EventAssigneeTable> orderByComparator)
		throws NoSuchEventAssigneeTableException;

	/**
	 * Returns the first event assignee table in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching event assignee table, or <code>null</code> if a matching event assignee table could not be found
	 */
	public EventAssigneeTable fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<EventAssigneeTable> orderByComparator);

	/**
	 * Returns the last event assignee table in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching event assignee table
	 * @throws NoSuchEventAssigneeTableException if a matching event assignee table could not be found
	 */
	public EventAssigneeTable findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<EventAssigneeTable> orderByComparator)
		throws NoSuchEventAssigneeTableException;

	/**
	 * Returns the last event assignee table in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching event assignee table, or <code>null</code> if a matching event assignee table could not be found
	 */
	public EventAssigneeTable fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<EventAssigneeTable> orderByComparator);

	/**
	 * Returns the event assignee tables before and after the current event assignee table in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param Id the primary key of the current event assignee table
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next event assignee table
	 * @throws NoSuchEventAssigneeTableException if a event assignee table with the primary key could not be found
	 */
	public EventAssigneeTable[] findByUuid_C_PrevAndNext(
			int Id, String uuid, long companyId,
			OrderByComparator<EventAssigneeTable> orderByComparator)
		throws NoSuchEventAssigneeTableException;

	/**
	 * Removes all the event assignee tables where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of event assignee tables where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching event assignee tables
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Caches the event assignee table in the entity cache if it is enabled.
	 *
	 * @param eventAssigneeTable the event assignee table
	 */
	public void cacheResult(EventAssigneeTable eventAssigneeTable);

	/**
	 * Caches the event assignee tables in the entity cache if it is enabled.
	 *
	 * @param eventAssigneeTables the event assignee tables
	 */
	public void cacheResult(
		java.util.List<EventAssigneeTable> eventAssigneeTables);

	/**
	 * Creates a new event assignee table with the primary key. Does not add the event assignee table to the database.
	 *
	 * @param Id the primary key for the new event assignee table
	 * @return the new event assignee table
	 */
	public EventAssigneeTable create(int Id);

	/**
	 * Removes the event assignee table with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param Id the primary key of the event assignee table
	 * @return the event assignee table that was removed
	 * @throws NoSuchEventAssigneeTableException if a event assignee table with the primary key could not be found
	 */
	public EventAssigneeTable remove(int Id)
		throws NoSuchEventAssigneeTableException;

	public EventAssigneeTable updateImpl(EventAssigneeTable eventAssigneeTable);

	/**
	 * Returns the event assignee table with the primary key or throws a <code>NoSuchEventAssigneeTableException</code> if it could not be found.
	 *
	 * @param Id the primary key of the event assignee table
	 * @return the event assignee table
	 * @throws NoSuchEventAssigneeTableException if a event assignee table with the primary key could not be found
	 */
	public EventAssigneeTable findByPrimaryKey(int Id)
		throws NoSuchEventAssigneeTableException;

	/**
	 * Returns the event assignee table with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param Id the primary key of the event assignee table
	 * @return the event assignee table, or <code>null</code> if a event assignee table with the primary key could not be found
	 */
	public EventAssigneeTable fetchByPrimaryKey(int Id);

	/**
	 * Returns all the event assignee tables.
	 *
	 * @return the event assignee tables
	 */
	public java.util.List<EventAssigneeTable> findAll();

	/**
	 * Returns a range of all the event assignee tables.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>EventAssigneeTableModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of event assignee tables
	 * @param end the upper bound of the range of event assignee tables (not inclusive)
	 * @return the range of event assignee tables
	 */
	public java.util.List<EventAssigneeTable> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the event assignee tables.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>EventAssigneeTableModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findAll(int, int, OrderByComparator)}
	 * @param start the lower bound of the range of event assignee tables
	 * @param end the upper bound of the range of event assignee tables (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of event assignee tables
	 */
	@Deprecated
	public java.util.List<EventAssigneeTable> findAll(
		int start, int end,
		OrderByComparator<EventAssigneeTable> orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns an ordered range of all the event assignee tables.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>EventAssigneeTableModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of event assignee tables
	 * @param end the upper bound of the range of event assignee tables (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of event assignee tables
	 */
	public java.util.List<EventAssigneeTable> findAll(
		int start, int end,
		OrderByComparator<EventAssigneeTable> orderByComparator);

	/**
	 * Removes all the event assignee tables from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of event assignee tables.
	 *
	 * @return the number of event assignee tables
	 */
	public int countAll();

}