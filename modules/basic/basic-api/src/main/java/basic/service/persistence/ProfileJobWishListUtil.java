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

import basic.model.ProfileJobWishList;

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
 * The persistence utility for the profile job wish list service. This utility wraps <code>basic.service.persistence.impl.ProfileJobWishListPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ProfileJobWishListPersistence
 * @generated
 */
@ProviderType
public class ProfileJobWishListUtil {

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
	public static void clearCache(ProfileJobWishList profileJobWishList) {
		getPersistence().clearCache(profileJobWishList);
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
	public static Map<Serializable, ProfileJobWishList> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<ProfileJobWishList> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ProfileJobWishList> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ProfileJobWishList> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<ProfileJobWishList> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static ProfileJobWishList update(
		ProfileJobWishList profileJobWishList) {

		return getPersistence().update(profileJobWishList);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static ProfileJobWishList update(
		ProfileJobWishList profileJobWishList, ServiceContext serviceContext) {

		return getPersistence().update(profileJobWishList, serviceContext);
	}

	/**
	 * Returns all the profile job wish lists where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching profile job wish lists
	 */
	public static List<ProfileJobWishList> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

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
	public static List<ProfileJobWishList> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

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
	public static List<ProfileJobWishList> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<ProfileJobWishList> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

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
	public static List<ProfileJobWishList> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<ProfileJobWishList> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns the first profile job wish list in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching profile job wish list
	 * @throws NoSuchProfileJobWishListException if a matching profile job wish list could not be found
	 */
	public static ProfileJobWishList findByUuid_First(
			String uuid,
			OrderByComparator<ProfileJobWishList> orderByComparator)
		throws basic.exception.NoSuchProfileJobWishListException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first profile job wish list in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching profile job wish list, or <code>null</code> if a matching profile job wish list could not be found
	 */
	public static ProfileJobWishList fetchByUuid_First(
		String uuid, OrderByComparator<ProfileJobWishList> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last profile job wish list in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching profile job wish list
	 * @throws NoSuchProfileJobWishListException if a matching profile job wish list could not be found
	 */
	public static ProfileJobWishList findByUuid_Last(
			String uuid,
			OrderByComparator<ProfileJobWishList> orderByComparator)
		throws basic.exception.NoSuchProfileJobWishListException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last profile job wish list in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching profile job wish list, or <code>null</code> if a matching profile job wish list could not be found
	 */
	public static ProfileJobWishList fetchByUuid_Last(
		String uuid, OrderByComparator<ProfileJobWishList> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the profile job wish lists before and after the current profile job wish list in the ordered set where uuid = &#63;.
	 *
	 * @param Id the primary key of the current profile job wish list
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next profile job wish list
	 * @throws NoSuchProfileJobWishListException if a profile job wish list with the primary key could not be found
	 */
	public static ProfileJobWishList[] findByUuid_PrevAndNext(
			long Id, String uuid,
			OrderByComparator<ProfileJobWishList> orderByComparator)
		throws basic.exception.NoSuchProfileJobWishListException {

		return getPersistence().findByUuid_PrevAndNext(
			Id, uuid, orderByComparator);
	}

	/**
	 * Removes all the profile job wish lists where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of profile job wish lists where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching profile job wish lists
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the profile job wish list where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchProfileJobWishListException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching profile job wish list
	 * @throws NoSuchProfileJobWishListException if a matching profile job wish list could not be found
	 */
	public static ProfileJobWishList findByUUID_G(String uuid, long groupId)
		throws basic.exception.NoSuchProfileJobWishListException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

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
	public static ProfileJobWishList fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Returns the profile job wish list where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching profile job wish list, or <code>null</code> if a matching profile job wish list could not be found
	 */
	public static ProfileJobWishList fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Removes the profile job wish list where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the profile job wish list that was removed
	 */
	public static ProfileJobWishList removeByUUID_G(String uuid, long groupId)
		throws basic.exception.NoSuchProfileJobWishListException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of profile job wish lists where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching profile job wish lists
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the profile job wish lists where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching profile job wish lists
	 */
	public static List<ProfileJobWishList> findByUuid_C(
		String uuid, long companyId) {

		return getPersistence().findByUuid_C(uuid, companyId);
	}

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
	public static List<ProfileJobWishList> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

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
	public static List<ProfileJobWishList> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<ProfileJobWishList> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

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
	public static List<ProfileJobWishList> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<ProfileJobWishList> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the first profile job wish list in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching profile job wish list
	 * @throws NoSuchProfileJobWishListException if a matching profile job wish list could not be found
	 */
	public static ProfileJobWishList findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<ProfileJobWishList> orderByComparator)
		throws basic.exception.NoSuchProfileJobWishListException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first profile job wish list in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching profile job wish list, or <code>null</code> if a matching profile job wish list could not be found
	 */
	public static ProfileJobWishList fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<ProfileJobWishList> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last profile job wish list in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching profile job wish list
	 * @throws NoSuchProfileJobWishListException if a matching profile job wish list could not be found
	 */
	public static ProfileJobWishList findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<ProfileJobWishList> orderByComparator)
		throws basic.exception.NoSuchProfileJobWishListException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last profile job wish list in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching profile job wish list, or <code>null</code> if a matching profile job wish list could not be found
	 */
	public static ProfileJobWishList fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<ProfileJobWishList> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

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
	public static ProfileJobWishList[] findByUuid_C_PrevAndNext(
			long Id, String uuid, long companyId,
			OrderByComparator<ProfileJobWishList> orderByComparator)
		throws basic.exception.NoSuchProfileJobWishListException {

		return getPersistence().findByUuid_C_PrevAndNext(
			Id, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the profile job wish lists where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of profile job wish lists where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching profile job wish lists
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Caches the profile job wish list in the entity cache if it is enabled.
	 *
	 * @param profileJobWishList the profile job wish list
	 */
	public static void cacheResult(ProfileJobWishList profileJobWishList) {
		getPersistence().cacheResult(profileJobWishList);
	}

	/**
	 * Caches the profile job wish lists in the entity cache if it is enabled.
	 *
	 * @param profileJobWishLists the profile job wish lists
	 */
	public static void cacheResult(
		List<ProfileJobWishList> profileJobWishLists) {

		getPersistence().cacheResult(profileJobWishLists);
	}

	/**
	 * Creates a new profile job wish list with the primary key. Does not add the profile job wish list to the database.
	 *
	 * @param Id the primary key for the new profile job wish list
	 * @return the new profile job wish list
	 */
	public static ProfileJobWishList create(long Id) {
		return getPersistence().create(Id);
	}

	/**
	 * Removes the profile job wish list with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param Id the primary key of the profile job wish list
	 * @return the profile job wish list that was removed
	 * @throws NoSuchProfileJobWishListException if a profile job wish list with the primary key could not be found
	 */
	public static ProfileJobWishList remove(long Id)
		throws basic.exception.NoSuchProfileJobWishListException {

		return getPersistence().remove(Id);
	}

	public static ProfileJobWishList updateImpl(
		ProfileJobWishList profileJobWishList) {

		return getPersistence().updateImpl(profileJobWishList);
	}

	/**
	 * Returns the profile job wish list with the primary key or throws a <code>NoSuchProfileJobWishListException</code> if it could not be found.
	 *
	 * @param Id the primary key of the profile job wish list
	 * @return the profile job wish list
	 * @throws NoSuchProfileJobWishListException if a profile job wish list with the primary key could not be found
	 */
	public static ProfileJobWishList findByPrimaryKey(long Id)
		throws basic.exception.NoSuchProfileJobWishListException {

		return getPersistence().findByPrimaryKey(Id);
	}

	/**
	 * Returns the profile job wish list with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param Id the primary key of the profile job wish list
	 * @return the profile job wish list, or <code>null</code> if a profile job wish list with the primary key could not be found
	 */
	public static ProfileJobWishList fetchByPrimaryKey(long Id) {
		return getPersistence().fetchByPrimaryKey(Id);
	}

	/**
	 * Returns all the profile job wish lists.
	 *
	 * @return the profile job wish lists
	 */
	public static List<ProfileJobWishList> findAll() {
		return getPersistence().findAll();
	}

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
	public static List<ProfileJobWishList> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

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
	public static List<ProfileJobWishList> findAll(
		int start, int end,
		OrderByComparator<ProfileJobWishList> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

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
	public static List<ProfileJobWishList> findAll(
		int start, int end,
		OrderByComparator<ProfileJobWishList> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Removes all the profile job wish lists from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of profile job wish lists.
	 *
	 * @return the number of profile job wish lists
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static ProfileJobWishListPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<ProfileJobWishListPersistence, ProfileJobWishListPersistence>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			ProfileJobWishListPersistence.class);

		ServiceTracker
			<ProfileJobWishListPersistence, ProfileJobWishListPersistence>
				serviceTracker =
					new ServiceTracker
						<ProfileJobWishListPersistence,
						 ProfileJobWishListPersistence>(
							 bundle.getBundleContext(),
							 ProfileJobWishListPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}