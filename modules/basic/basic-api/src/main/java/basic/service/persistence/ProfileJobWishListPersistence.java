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

import basic.exception.NoSuchProfileJobWishListException;

import basic.model.ProfileJobWishList;

import com.liferay.portal.kernel.service.persistence.BasePersistence;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the profile job wish list service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ProfileJobWishListUtil
 * @generated
 */
@ProviderType
public interface ProfileJobWishListPersistence
	extends BasePersistence<ProfileJobWishList> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ProfileJobWishListUtil} to access the profile job wish list persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the profile job wish lists where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching profile job wish lists
	 */
	public java.util.List<ProfileJobWishList> findByUuid(String uuid);

	/**
	 * Returns a range of all the profile job wish lists where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ProfileJobWishListModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of profile job wish lists
	 * @param end the upper bound of the range of profile job wish lists (not inclusive)
	 * @return the range of matching profile job wish lists
	 */
	public java.util.List<ProfileJobWishList> findByUuid(
		String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the profile job wish lists where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ProfileJobWishListModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findByUuid(String, int, int, OrderByComparator)}
	 * @param uuid the uuid
	 * @param start the lower bound of the range of profile job wish lists
	 * @param end the upper bound of the range of profile job wish lists (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching profile job wish lists
	 */
	@Deprecated
	public java.util.List<ProfileJobWishList> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<ProfileJobWishList> orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns an ordered range of all the profile job wish lists where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ProfileJobWishListModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of profile job wish lists
	 * @param end the upper bound of the range of profile job wish lists (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching profile job wish lists
	 */
	public java.util.List<ProfileJobWishList> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<ProfileJobWishList> orderByComparator);

	/**
	 * Returns the first profile job wish list in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching profile job wish list
	 * @throws NoSuchProfileJobWishListException if a matching profile job wish list could not be found
	 */
	public ProfileJobWishList findByUuid_First(
			String uuid,
			OrderByComparator<ProfileJobWishList> orderByComparator)
		throws NoSuchProfileJobWishListException;

	/**
	 * Returns the first profile job wish list in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching profile job wish list, or <code>null</code> if a matching profile job wish list could not be found
	 */
	public ProfileJobWishList fetchByUuid_First(
		String uuid, OrderByComparator<ProfileJobWishList> orderByComparator);

	/**
	 * Returns the last profile job wish list in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching profile job wish list
	 * @throws NoSuchProfileJobWishListException if a matching profile job wish list could not be found
	 */
	public ProfileJobWishList findByUuid_Last(
			String uuid,
			OrderByComparator<ProfileJobWishList> orderByComparator)
		throws NoSuchProfileJobWishListException;

	/**
	 * Returns the last profile job wish list in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching profile job wish list, or <code>null</code> if a matching profile job wish list could not be found
	 */
	public ProfileJobWishList fetchByUuid_Last(
		String uuid, OrderByComparator<ProfileJobWishList> orderByComparator);

	/**
	 * Returns the profile job wish lists before and after the current profile job wish list in the ordered set where uuid = &#63;.
	 *
	 * @param Id the primary key of the current profile job wish list
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next profile job wish list
	 * @throws NoSuchProfileJobWishListException if a profile job wish list with the primary key could not be found
	 */
	public ProfileJobWishList[] findByUuid_PrevAndNext(
			long Id, String uuid,
			OrderByComparator<ProfileJobWishList> orderByComparator)
		throws NoSuchProfileJobWishListException;

	/**
	 * Removes all the profile job wish lists where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of profile job wish lists where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching profile job wish lists
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the profile job wish list where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchProfileJobWishListException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching profile job wish list
	 * @throws NoSuchProfileJobWishListException if a matching profile job wish list could not be found
	 */
	public ProfileJobWishList findByUUID_G(String uuid, long groupId)
		throws NoSuchProfileJobWishListException;

	/**
	 * Returns the profile job wish list where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #fetchByUUID_G(String,long)}
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching profile job wish list, or <code>null</code> if a matching profile job wish list could not be found
	 */
	@Deprecated
	public ProfileJobWishList fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Returns the profile job wish list where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching profile job wish list, or <code>null</code> if a matching profile job wish list could not be found
	 */
	public ProfileJobWishList fetchByUUID_G(String uuid, long groupId);

	/**
	 * Removes the profile job wish list where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the profile job wish list that was removed
	 */
	public ProfileJobWishList removeByUUID_G(String uuid, long groupId)
		throws NoSuchProfileJobWishListException;

	/**
	 * Returns the number of profile job wish lists where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching profile job wish lists
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the profile job wish lists where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching profile job wish lists
	 */
	public java.util.List<ProfileJobWishList> findByUuid_C(
		String uuid, long companyId);

	/**
	 * Returns a range of all the profile job wish lists where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ProfileJobWishListModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of profile job wish lists
	 * @param end the upper bound of the range of profile job wish lists (not inclusive)
	 * @return the range of matching profile job wish lists
	 */
	public java.util.List<ProfileJobWishList> findByUuid_C(
		String uuid, long companyId, int start, int end);

	/**
	 * Returns an ordered range of all the profile job wish lists where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ProfileJobWishListModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findByUuid_C(String,long, int, int, OrderByComparator)}
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of profile job wish lists
	 * @param end the upper bound of the range of profile job wish lists (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching profile job wish lists
	 */
	@Deprecated
	public java.util.List<ProfileJobWishList> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<ProfileJobWishList> orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns an ordered range of all the profile job wish lists where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ProfileJobWishListModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of profile job wish lists
	 * @param end the upper bound of the range of profile job wish lists (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching profile job wish lists
	 */
	public java.util.List<ProfileJobWishList> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<ProfileJobWishList> orderByComparator);

	/**
	 * Returns the first profile job wish list in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching profile job wish list
	 * @throws NoSuchProfileJobWishListException if a matching profile job wish list could not be found
	 */
	public ProfileJobWishList findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<ProfileJobWishList> orderByComparator)
		throws NoSuchProfileJobWishListException;

	/**
	 * Returns the first profile job wish list in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching profile job wish list, or <code>null</code> if a matching profile job wish list could not be found
	 */
	public ProfileJobWishList fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<ProfileJobWishList> orderByComparator);

	/**
	 * Returns the last profile job wish list in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching profile job wish list
	 * @throws NoSuchProfileJobWishListException if a matching profile job wish list could not be found
	 */
	public ProfileJobWishList findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<ProfileJobWishList> orderByComparator)
		throws NoSuchProfileJobWishListException;

	/**
	 * Returns the last profile job wish list in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching profile job wish list, or <code>null</code> if a matching profile job wish list could not be found
	 */
	public ProfileJobWishList fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<ProfileJobWishList> orderByComparator);

	/**
	 * Returns the profile job wish lists before and after the current profile job wish list in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param Id the primary key of the current profile job wish list
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next profile job wish list
	 * @throws NoSuchProfileJobWishListException if a profile job wish list with the primary key could not be found
	 */
	public ProfileJobWishList[] findByUuid_C_PrevAndNext(
			long Id, String uuid, long companyId,
			OrderByComparator<ProfileJobWishList> orderByComparator)
		throws NoSuchProfileJobWishListException;

	/**
	 * Removes all the profile job wish lists where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of profile job wish lists where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching profile job wish lists
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Caches the profile job wish list in the entity cache if it is enabled.
	 *
	 * @param profileJobWishList the profile job wish list
	 */
	public void cacheResult(ProfileJobWishList profileJobWishList);

	/**
	 * Caches the profile job wish lists in the entity cache if it is enabled.
	 *
	 * @param profileJobWishLists the profile job wish lists
	 */
	public void cacheResult(
		java.util.List<ProfileJobWishList> profileJobWishLists);

	/**
	 * Creates a new profile job wish list with the primary key. Does not add the profile job wish list to the database.
	 *
	 * @param Id the primary key for the new profile job wish list
	 * @return the new profile job wish list
	 */
	public ProfileJobWishList create(long Id);

	/**
	 * Removes the profile job wish list with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param Id the primary key of the profile job wish list
	 * @return the profile job wish list that was removed
	 * @throws NoSuchProfileJobWishListException if a profile job wish list with the primary key could not be found
	 */
	public ProfileJobWishList remove(long Id)
		throws NoSuchProfileJobWishListException;

	public ProfileJobWishList updateImpl(ProfileJobWishList profileJobWishList);

	/**
	 * Returns the profile job wish list with the primary key or throws a <code>NoSuchProfileJobWishListException</code> if it could not be found.
	 *
	 * @param Id the primary key of the profile job wish list
	 * @return the profile job wish list
	 * @throws NoSuchProfileJobWishListException if a profile job wish list with the primary key could not be found
	 */
	public ProfileJobWishList findByPrimaryKey(long Id)
		throws NoSuchProfileJobWishListException;

	/**
	 * Returns the profile job wish list with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param Id the primary key of the profile job wish list
	 * @return the profile job wish list, or <code>null</code> if a profile job wish list with the primary key could not be found
	 */
	public ProfileJobWishList fetchByPrimaryKey(long Id);

	/**
	 * Returns all the profile job wish lists.
	 *
	 * @return the profile job wish lists
	 */
	public java.util.List<ProfileJobWishList> findAll();

	/**
	 * Returns a range of all the profile job wish lists.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ProfileJobWishListModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of profile job wish lists
	 * @param end the upper bound of the range of profile job wish lists (not inclusive)
	 * @return the range of profile job wish lists
	 */
	public java.util.List<ProfileJobWishList> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the profile job wish lists.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ProfileJobWishListModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findAll(int, int, OrderByComparator)}
	 * @param start the lower bound of the range of profile job wish lists
	 * @param end the upper bound of the range of profile job wish lists (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of profile job wish lists
	 */
	@Deprecated
	public java.util.List<ProfileJobWishList> findAll(
		int start, int end,
		OrderByComparator<ProfileJobWishList> orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns an ordered range of all the profile job wish lists.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ProfileJobWishListModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of profile job wish lists
	 * @param end the upper bound of the range of profile job wish lists (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of profile job wish lists
	 */
	public java.util.List<ProfileJobWishList> findAll(
		int start, int end,
		OrderByComparator<ProfileJobWishList> orderByComparator);

	/**
	 * Removes all the profile job wish lists from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of profile job wish lists.
	 *
	 * @return the number of profile job wish lists
	 */
	public int countAll();

}