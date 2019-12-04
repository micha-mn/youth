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

import basic.exception.NoSuchprofileIntrestException;

import basic.model.profileIntrest;

import com.liferay.portal.kernel.service.persistence.BasePersistence;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the profile intrest service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see profileIntrestUtil
 * @generated
 */
@ProviderType
public interface profileIntrestPersistence
	extends BasePersistence<profileIntrest> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link profileIntrestUtil} to access the profile intrest persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the profile intrests where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching profile intrests
	 */
	public java.util.List<profileIntrest> findByUuid(String uuid);

	/**
	 * Returns a range of all the profile intrests where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>profileIntrestModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of profile intrests
	 * @param end the upper bound of the range of profile intrests (not inclusive)
	 * @return the range of matching profile intrests
	 */
	public java.util.List<profileIntrest> findByUuid(
		String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the profile intrests where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>profileIntrestModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findByUuid(String, int, int, OrderByComparator)}
	 * @param uuid the uuid
	 * @param start the lower bound of the range of profile intrests
	 * @param end the upper bound of the range of profile intrests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching profile intrests
	 */
	@Deprecated
	public java.util.List<profileIntrest> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<profileIntrest> orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns an ordered range of all the profile intrests where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>profileIntrestModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of profile intrests
	 * @param end the upper bound of the range of profile intrests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching profile intrests
	 */
	public java.util.List<profileIntrest> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<profileIntrest> orderByComparator);

	/**
	 * Returns the first profile intrest in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching profile intrest
	 * @throws NoSuchprofileIntrestException if a matching profile intrest could not be found
	 */
	public profileIntrest findByUuid_First(
			String uuid, OrderByComparator<profileIntrest> orderByComparator)
		throws NoSuchprofileIntrestException;

	/**
	 * Returns the first profile intrest in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching profile intrest, or <code>null</code> if a matching profile intrest could not be found
	 */
	public profileIntrest fetchByUuid_First(
		String uuid, OrderByComparator<profileIntrest> orderByComparator);

	/**
	 * Returns the last profile intrest in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching profile intrest
	 * @throws NoSuchprofileIntrestException if a matching profile intrest could not be found
	 */
	public profileIntrest findByUuid_Last(
			String uuid, OrderByComparator<profileIntrest> orderByComparator)
		throws NoSuchprofileIntrestException;

	/**
	 * Returns the last profile intrest in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching profile intrest, or <code>null</code> if a matching profile intrest could not be found
	 */
	public profileIntrest fetchByUuid_Last(
		String uuid, OrderByComparator<profileIntrest> orderByComparator);

	/**
	 * Returns the profile intrests before and after the current profile intrest in the ordered set where uuid = &#63;.
	 *
	 * @param Id the primary key of the current profile intrest
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next profile intrest
	 * @throws NoSuchprofileIntrestException if a profile intrest with the primary key could not be found
	 */
	public profileIntrest[] findByUuid_PrevAndNext(
			long Id, String uuid,
			OrderByComparator<profileIntrest> orderByComparator)
		throws NoSuchprofileIntrestException;

	/**
	 * Removes all the profile intrests where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of profile intrests where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching profile intrests
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the profile intrest where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchprofileIntrestException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching profile intrest
	 * @throws NoSuchprofileIntrestException if a matching profile intrest could not be found
	 */
	public profileIntrest findByUUID_G(String uuid, long groupId)
		throws NoSuchprofileIntrestException;

	/**
	 * Returns the profile intrest where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #fetchByUUID_G(String,long)}
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching profile intrest, or <code>null</code> if a matching profile intrest could not be found
	 */
	@Deprecated
	public profileIntrest fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Returns the profile intrest where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching profile intrest, or <code>null</code> if a matching profile intrest could not be found
	 */
	public profileIntrest fetchByUUID_G(String uuid, long groupId);

	/**
	 * Removes the profile intrest where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the profile intrest that was removed
	 */
	public profileIntrest removeByUUID_G(String uuid, long groupId)
		throws NoSuchprofileIntrestException;

	/**
	 * Returns the number of profile intrests where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching profile intrests
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the profile intrests where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching profile intrests
	 */
	public java.util.List<profileIntrest> findByUuid_C(
		String uuid, long companyId);

	/**
	 * Returns a range of all the profile intrests where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>profileIntrestModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of profile intrests
	 * @param end the upper bound of the range of profile intrests (not inclusive)
	 * @return the range of matching profile intrests
	 */
	public java.util.List<profileIntrest> findByUuid_C(
		String uuid, long companyId, int start, int end);

	/**
	 * Returns an ordered range of all the profile intrests where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>profileIntrestModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findByUuid_C(String,long, int, int, OrderByComparator)}
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of profile intrests
	 * @param end the upper bound of the range of profile intrests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching profile intrests
	 */
	@Deprecated
	public java.util.List<profileIntrest> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<profileIntrest> orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns an ordered range of all the profile intrests where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>profileIntrestModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of profile intrests
	 * @param end the upper bound of the range of profile intrests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching profile intrests
	 */
	public java.util.List<profileIntrest> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<profileIntrest> orderByComparator);

	/**
	 * Returns the first profile intrest in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching profile intrest
	 * @throws NoSuchprofileIntrestException if a matching profile intrest could not be found
	 */
	public profileIntrest findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<profileIntrest> orderByComparator)
		throws NoSuchprofileIntrestException;

	/**
	 * Returns the first profile intrest in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching profile intrest, or <code>null</code> if a matching profile intrest could not be found
	 */
	public profileIntrest fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<profileIntrest> orderByComparator);

	/**
	 * Returns the last profile intrest in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching profile intrest
	 * @throws NoSuchprofileIntrestException if a matching profile intrest could not be found
	 */
	public profileIntrest findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<profileIntrest> orderByComparator)
		throws NoSuchprofileIntrestException;

	/**
	 * Returns the last profile intrest in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching profile intrest, or <code>null</code> if a matching profile intrest could not be found
	 */
	public profileIntrest fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<profileIntrest> orderByComparator);

	/**
	 * Returns the profile intrests before and after the current profile intrest in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param Id the primary key of the current profile intrest
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next profile intrest
	 * @throws NoSuchprofileIntrestException if a profile intrest with the primary key could not be found
	 */
	public profileIntrest[] findByUuid_C_PrevAndNext(
			long Id, String uuid, long companyId,
			OrderByComparator<profileIntrest> orderByComparator)
		throws NoSuchprofileIntrestException;

	/**
	 * Removes all the profile intrests where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of profile intrests where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching profile intrests
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Caches the profile intrest in the entity cache if it is enabled.
	 *
	 * @param profileIntrest the profile intrest
	 */
	public void cacheResult(profileIntrest profileIntrest);

	/**
	 * Caches the profile intrests in the entity cache if it is enabled.
	 *
	 * @param profileIntrests the profile intrests
	 */
	public void cacheResult(java.util.List<profileIntrest> profileIntrests);

	/**
	 * Creates a new profile intrest with the primary key. Does not add the profile intrest to the database.
	 *
	 * @param Id the primary key for the new profile intrest
	 * @return the new profile intrest
	 */
	public profileIntrest create(long Id);

	/**
	 * Removes the profile intrest with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param Id the primary key of the profile intrest
	 * @return the profile intrest that was removed
	 * @throws NoSuchprofileIntrestException if a profile intrest with the primary key could not be found
	 */
	public profileIntrest remove(long Id) throws NoSuchprofileIntrestException;

	public profileIntrest updateImpl(profileIntrest profileIntrest);

	/**
	 * Returns the profile intrest with the primary key or throws a <code>NoSuchprofileIntrestException</code> if it could not be found.
	 *
	 * @param Id the primary key of the profile intrest
	 * @return the profile intrest
	 * @throws NoSuchprofileIntrestException if a profile intrest with the primary key could not be found
	 */
	public profileIntrest findByPrimaryKey(long Id)
		throws NoSuchprofileIntrestException;

	/**
	 * Returns the profile intrest with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param Id the primary key of the profile intrest
	 * @return the profile intrest, or <code>null</code> if a profile intrest with the primary key could not be found
	 */
	public profileIntrest fetchByPrimaryKey(long Id);

	/**
	 * Returns all the profile intrests.
	 *
	 * @return the profile intrests
	 */
	public java.util.List<profileIntrest> findAll();

	/**
	 * Returns a range of all the profile intrests.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>profileIntrestModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of profile intrests
	 * @param end the upper bound of the range of profile intrests (not inclusive)
	 * @return the range of profile intrests
	 */
	public java.util.List<profileIntrest> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the profile intrests.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>profileIntrestModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findAll(int, int, OrderByComparator)}
	 * @param start the lower bound of the range of profile intrests
	 * @param end the upper bound of the range of profile intrests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of profile intrests
	 */
	@Deprecated
	public java.util.List<profileIntrest> findAll(
		int start, int end, OrderByComparator<profileIntrest> orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns an ordered range of all the profile intrests.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>profileIntrestModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of profile intrests
	 * @param end the upper bound of the range of profile intrests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of profile intrests
	 */
	public java.util.List<profileIntrest> findAll(
		int start, int end,
		OrderByComparator<profileIntrest> orderByComparator);

	/**
	 * Removes all the profile intrests from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of profile intrests.
	 *
	 * @return the number of profile intrests
	 */
	public int countAll();

}