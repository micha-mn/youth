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

import basic.exception.NoSuchRegisterEventException;

import basic.model.RegisterEvent;

import com.liferay.portal.kernel.service.persistence.BasePersistence;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the register event service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see RegisterEventUtil
 * @generated
 */
@ProviderType
public interface RegisterEventPersistence
	extends BasePersistence<RegisterEvent> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link RegisterEventUtil} to access the register event persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the register events where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching register events
	 */
	public java.util.List<RegisterEvent> findByUuid(String uuid);

	/**
	 * Returns a range of all the register events where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RegisterEventModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of register events
	 * @param end the upper bound of the range of register events (not inclusive)
	 * @return the range of matching register events
	 */
	public java.util.List<RegisterEvent> findByUuid(
		String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the register events where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RegisterEventModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findByUuid(String, int, int, OrderByComparator)}
	 * @param uuid the uuid
	 * @param start the lower bound of the range of register events
	 * @param end the upper bound of the range of register events (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching register events
	 */
	@Deprecated
	public java.util.List<RegisterEvent> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<RegisterEvent> orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns an ordered range of all the register events where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RegisterEventModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of register events
	 * @param end the upper bound of the range of register events (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching register events
	 */
	public java.util.List<RegisterEvent> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<RegisterEvent> orderByComparator);

	/**
	 * Returns the first register event in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching register event
	 * @throws NoSuchRegisterEventException if a matching register event could not be found
	 */
	public RegisterEvent findByUuid_First(
			String uuid, OrderByComparator<RegisterEvent> orderByComparator)
		throws NoSuchRegisterEventException;

	/**
	 * Returns the first register event in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching register event, or <code>null</code> if a matching register event could not be found
	 */
	public RegisterEvent fetchByUuid_First(
		String uuid, OrderByComparator<RegisterEvent> orderByComparator);

	/**
	 * Returns the last register event in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching register event
	 * @throws NoSuchRegisterEventException if a matching register event could not be found
	 */
	public RegisterEvent findByUuid_Last(
			String uuid, OrderByComparator<RegisterEvent> orderByComparator)
		throws NoSuchRegisterEventException;

	/**
	 * Returns the last register event in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching register event, or <code>null</code> if a matching register event could not be found
	 */
	public RegisterEvent fetchByUuid_Last(
		String uuid, OrderByComparator<RegisterEvent> orderByComparator);

	/**
	 * Returns the register events before and after the current register event in the ordered set where uuid = &#63;.
	 *
	 * @param Id the primary key of the current register event
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next register event
	 * @throws NoSuchRegisterEventException if a register event with the primary key could not be found
	 */
	public RegisterEvent[] findByUuid_PrevAndNext(
			long Id, String uuid,
			OrderByComparator<RegisterEvent> orderByComparator)
		throws NoSuchRegisterEventException;

	/**
	 * Removes all the register events where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of register events where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching register events
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the register event where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchRegisterEventException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching register event
	 * @throws NoSuchRegisterEventException if a matching register event could not be found
	 */
	public RegisterEvent findByUUID_G(String uuid, long groupId)
		throws NoSuchRegisterEventException;

	/**
	 * Returns the register event where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #fetchByUUID_G(String,long)}
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching register event, or <code>null</code> if a matching register event could not be found
	 */
	@Deprecated
	public RegisterEvent fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Returns the register event where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching register event, or <code>null</code> if a matching register event could not be found
	 */
	public RegisterEvent fetchByUUID_G(String uuid, long groupId);

	/**
	 * Removes the register event where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the register event that was removed
	 */
	public RegisterEvent removeByUUID_G(String uuid, long groupId)
		throws NoSuchRegisterEventException;

	/**
	 * Returns the number of register events where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching register events
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the register events where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching register events
	 */
	public java.util.List<RegisterEvent> findByUuid_C(
		String uuid, long companyId);

	/**
	 * Returns a range of all the register events where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RegisterEventModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of register events
	 * @param end the upper bound of the range of register events (not inclusive)
	 * @return the range of matching register events
	 */
	public java.util.List<RegisterEvent> findByUuid_C(
		String uuid, long companyId, int start, int end);

	/**
	 * Returns an ordered range of all the register events where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RegisterEventModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findByUuid_C(String,long, int, int, OrderByComparator)}
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of register events
	 * @param end the upper bound of the range of register events (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching register events
	 */
	@Deprecated
	public java.util.List<RegisterEvent> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<RegisterEvent> orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns an ordered range of all the register events where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RegisterEventModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of register events
	 * @param end the upper bound of the range of register events (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching register events
	 */
	public java.util.List<RegisterEvent> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<RegisterEvent> orderByComparator);

	/**
	 * Returns the first register event in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching register event
	 * @throws NoSuchRegisterEventException if a matching register event could not be found
	 */
	public RegisterEvent findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<RegisterEvent> orderByComparator)
		throws NoSuchRegisterEventException;

	/**
	 * Returns the first register event in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching register event, or <code>null</code> if a matching register event could not be found
	 */
	public RegisterEvent fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<RegisterEvent> orderByComparator);

	/**
	 * Returns the last register event in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching register event
	 * @throws NoSuchRegisterEventException if a matching register event could not be found
	 */
	public RegisterEvent findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<RegisterEvent> orderByComparator)
		throws NoSuchRegisterEventException;

	/**
	 * Returns the last register event in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching register event, or <code>null</code> if a matching register event could not be found
	 */
	public RegisterEvent fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<RegisterEvent> orderByComparator);

	/**
	 * Returns the register events before and after the current register event in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param Id the primary key of the current register event
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next register event
	 * @throws NoSuchRegisterEventException if a register event with the primary key could not be found
	 */
	public RegisterEvent[] findByUuid_C_PrevAndNext(
			long Id, String uuid, long companyId,
			OrderByComparator<RegisterEvent> orderByComparator)
		throws NoSuchRegisterEventException;

	/**
	 * Removes all the register events where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of register events where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching register events
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Caches the register event in the entity cache if it is enabled.
	 *
	 * @param registerEvent the register event
	 */
	public void cacheResult(RegisterEvent registerEvent);

	/**
	 * Caches the register events in the entity cache if it is enabled.
	 *
	 * @param registerEvents the register events
	 */
	public void cacheResult(java.util.List<RegisterEvent> registerEvents);

	/**
	 * Creates a new register event with the primary key. Does not add the register event to the database.
	 *
	 * @param Id the primary key for the new register event
	 * @return the new register event
	 */
	public RegisterEvent create(long Id);

	/**
	 * Removes the register event with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param Id the primary key of the register event
	 * @return the register event that was removed
	 * @throws NoSuchRegisterEventException if a register event with the primary key could not be found
	 */
	public RegisterEvent remove(long Id) throws NoSuchRegisterEventException;

	public RegisterEvent updateImpl(RegisterEvent registerEvent);

	/**
	 * Returns the register event with the primary key or throws a <code>NoSuchRegisterEventException</code> if it could not be found.
	 *
	 * @param Id the primary key of the register event
	 * @return the register event
	 * @throws NoSuchRegisterEventException if a register event with the primary key could not be found
	 */
	public RegisterEvent findByPrimaryKey(long Id)
		throws NoSuchRegisterEventException;

	/**
	 * Returns the register event with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param Id the primary key of the register event
	 * @return the register event, or <code>null</code> if a register event with the primary key could not be found
	 */
	public RegisterEvent fetchByPrimaryKey(long Id);

	/**
	 * Returns all the register events.
	 *
	 * @return the register events
	 */
	public java.util.List<RegisterEvent> findAll();

	/**
	 * Returns a range of all the register events.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RegisterEventModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of register events
	 * @param end the upper bound of the range of register events (not inclusive)
	 * @return the range of register events
	 */
	public java.util.List<RegisterEvent> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the register events.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RegisterEventModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findAll(int, int, OrderByComparator)}
	 * @param start the lower bound of the range of register events
	 * @param end the upper bound of the range of register events (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of register events
	 */
	@Deprecated
	public java.util.List<RegisterEvent> findAll(
		int start, int end, OrderByComparator<RegisterEvent> orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns an ordered range of all the register events.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RegisterEventModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of register events
	 * @param end the upper bound of the range of register events (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of register events
	 */
	public java.util.List<RegisterEvent> findAll(
		int start, int end, OrderByComparator<RegisterEvent> orderByComparator);

	/**
	 * Removes all the register events from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of register events.
	 *
	 * @return the number of register events
	 */
	public int countAll();

}