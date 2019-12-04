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

import basic.exception.NoSuchprofileInfoException;

import basic.model.profileInfo;

import com.liferay.portal.kernel.service.persistence.BasePersistence;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the profile info service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see profileInfoUtil
 * @generated
 */
@ProviderType
public interface profileInfoPersistence extends BasePersistence<profileInfo> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link profileInfoUtil} to access the profile info persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the profile infos where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching profile infos
	 */
	public java.util.List<profileInfo> findByUuid(String uuid);

	/**
	 * Returns a range of all the profile infos where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>profileInfoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of profile infos
	 * @param end the upper bound of the range of profile infos (not inclusive)
	 * @return the range of matching profile infos
	 */
	public java.util.List<profileInfo> findByUuid(
		String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the profile infos where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>profileInfoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findByUuid(String, int, int, OrderByComparator)}
	 * @param uuid the uuid
	 * @param start the lower bound of the range of profile infos
	 * @param end the upper bound of the range of profile infos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching profile infos
	 */
	@Deprecated
	public java.util.List<profileInfo> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<profileInfo> orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns an ordered range of all the profile infos where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>profileInfoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of profile infos
	 * @param end the upper bound of the range of profile infos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching profile infos
	 */
	public java.util.List<profileInfo> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<profileInfo> orderByComparator);

	/**
	 * Returns the first profile info in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching profile info
	 * @throws NoSuchprofileInfoException if a matching profile info could not be found
	 */
	public profileInfo findByUuid_First(
			String uuid, OrderByComparator<profileInfo> orderByComparator)
		throws NoSuchprofileInfoException;

	/**
	 * Returns the first profile info in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching profile info, or <code>null</code> if a matching profile info could not be found
	 */
	public profileInfo fetchByUuid_First(
		String uuid, OrderByComparator<profileInfo> orderByComparator);

	/**
	 * Returns the last profile info in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching profile info
	 * @throws NoSuchprofileInfoException if a matching profile info could not be found
	 */
	public profileInfo findByUuid_Last(
			String uuid, OrderByComparator<profileInfo> orderByComparator)
		throws NoSuchprofileInfoException;

	/**
	 * Returns the last profile info in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching profile info, or <code>null</code> if a matching profile info could not be found
	 */
	public profileInfo fetchByUuid_Last(
		String uuid, OrderByComparator<profileInfo> orderByComparator);

	/**
	 * Returns the profile infos before and after the current profile info in the ordered set where uuid = &#63;.
	 *
	 * @param id the primary key of the current profile info
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next profile info
	 * @throws NoSuchprofileInfoException if a profile info with the primary key could not be found
	 */
	public profileInfo[] findByUuid_PrevAndNext(
			long id, String uuid,
			OrderByComparator<profileInfo> orderByComparator)
		throws NoSuchprofileInfoException;

	/**
	 * Removes all the profile infos where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of profile infos where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching profile infos
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the profile info where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchprofileInfoException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching profile info
	 * @throws NoSuchprofileInfoException if a matching profile info could not be found
	 */
	public profileInfo findByUUID_G(String uuid, long groupId)
		throws NoSuchprofileInfoException;

	/**
	 * Returns the profile info where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #fetchByUUID_G(String,long)}
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching profile info, or <code>null</code> if a matching profile info could not be found
	 */
	@Deprecated
	public profileInfo fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Returns the profile info where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching profile info, or <code>null</code> if a matching profile info could not be found
	 */
	public profileInfo fetchByUUID_G(String uuid, long groupId);

	/**
	 * Removes the profile info where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the profile info that was removed
	 */
	public profileInfo removeByUUID_G(String uuid, long groupId)
		throws NoSuchprofileInfoException;

	/**
	 * Returns the number of profile infos where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching profile infos
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the profile infos where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching profile infos
	 */
	public java.util.List<profileInfo> findByUuid_C(
		String uuid, long companyId);

	/**
	 * Returns a range of all the profile infos where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>profileInfoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of profile infos
	 * @param end the upper bound of the range of profile infos (not inclusive)
	 * @return the range of matching profile infos
	 */
	public java.util.List<profileInfo> findByUuid_C(
		String uuid, long companyId, int start, int end);

	/**
	 * Returns an ordered range of all the profile infos where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>profileInfoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findByUuid_C(String,long, int, int, OrderByComparator)}
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of profile infos
	 * @param end the upper bound of the range of profile infos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching profile infos
	 */
	@Deprecated
	public java.util.List<profileInfo> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<profileInfo> orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns an ordered range of all the profile infos where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>profileInfoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of profile infos
	 * @param end the upper bound of the range of profile infos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching profile infos
	 */
	public java.util.List<profileInfo> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<profileInfo> orderByComparator);

	/**
	 * Returns the first profile info in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching profile info
	 * @throws NoSuchprofileInfoException if a matching profile info could not be found
	 */
	public profileInfo findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<profileInfo> orderByComparator)
		throws NoSuchprofileInfoException;

	/**
	 * Returns the first profile info in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching profile info, or <code>null</code> if a matching profile info could not be found
	 */
	public profileInfo fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<profileInfo> orderByComparator);

	/**
	 * Returns the last profile info in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching profile info
	 * @throws NoSuchprofileInfoException if a matching profile info could not be found
	 */
	public profileInfo findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<profileInfo> orderByComparator)
		throws NoSuchprofileInfoException;

	/**
	 * Returns the last profile info in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching profile info, or <code>null</code> if a matching profile info could not be found
	 */
	public profileInfo fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<profileInfo> orderByComparator);

	/**
	 * Returns the profile infos before and after the current profile info in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param id the primary key of the current profile info
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next profile info
	 * @throws NoSuchprofileInfoException if a profile info with the primary key could not be found
	 */
	public profileInfo[] findByUuid_C_PrevAndNext(
			long id, String uuid, long companyId,
			OrderByComparator<profileInfo> orderByComparator)
		throws NoSuchprofileInfoException;

	/**
	 * Removes all the profile infos where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of profile infos where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching profile infos
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Caches the profile info in the entity cache if it is enabled.
	 *
	 * @param profileInfo the profile info
	 */
	public void cacheResult(profileInfo profileInfo);

	/**
	 * Caches the profile infos in the entity cache if it is enabled.
	 *
	 * @param profileInfos the profile infos
	 */
	public void cacheResult(java.util.List<profileInfo> profileInfos);

	/**
	 * Creates a new profile info with the primary key. Does not add the profile info to the database.
	 *
	 * @param id the primary key for the new profile info
	 * @return the new profile info
	 */
	public profileInfo create(long id);

	/**
	 * Removes the profile info with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the profile info
	 * @return the profile info that was removed
	 * @throws NoSuchprofileInfoException if a profile info with the primary key could not be found
	 */
	public profileInfo remove(long id) throws NoSuchprofileInfoException;

	public profileInfo updateImpl(profileInfo profileInfo);

	/**
	 * Returns the profile info with the primary key or throws a <code>NoSuchprofileInfoException</code> if it could not be found.
	 *
	 * @param id the primary key of the profile info
	 * @return the profile info
	 * @throws NoSuchprofileInfoException if a profile info with the primary key could not be found
	 */
	public profileInfo findByPrimaryKey(long id)
		throws NoSuchprofileInfoException;

	/**
	 * Returns the profile info with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the profile info
	 * @return the profile info, or <code>null</code> if a profile info with the primary key could not be found
	 */
	public profileInfo fetchByPrimaryKey(long id);

	/**
	 * Returns all the profile infos.
	 *
	 * @return the profile infos
	 */
	public java.util.List<profileInfo> findAll();

	/**
	 * Returns a range of all the profile infos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>profileInfoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of profile infos
	 * @param end the upper bound of the range of profile infos (not inclusive)
	 * @return the range of profile infos
	 */
	public java.util.List<profileInfo> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the profile infos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>profileInfoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findAll(int, int, OrderByComparator)}
	 * @param start the lower bound of the range of profile infos
	 * @param end the upper bound of the range of profile infos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of profile infos
	 */
	@Deprecated
	public java.util.List<profileInfo> findAll(
		int start, int end, OrderByComparator<profileInfo> orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns an ordered range of all the profile infos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>profileInfoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of profile infos
	 * @param end the upper bound of the range of profile infos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of profile infos
	 */
	public java.util.List<profileInfo> findAll(
		int start, int end, OrderByComparator<profileInfo> orderByComparator);

	/**
	 * Removes all the profile infos from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of profile infos.
	 *
	 * @return the number of profile infos
	 */
	public int countAll();

}