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

import basic.exception.NoSuchprofileSkillsException;

import basic.model.profileSkills;

import com.liferay.portal.kernel.service.persistence.BasePersistence;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the profile skills service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see profileSkillsUtil
 * @generated
 */
@ProviderType
public interface profileSkillsPersistence
	extends BasePersistence<profileSkills> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link profileSkillsUtil} to access the profile skills persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the profile skillses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching profile skillses
	 */
	public java.util.List<profileSkills> findByUuid(String uuid);

	/**
	 * Returns a range of all the profile skillses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>profileSkillsModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of profile skillses
	 * @param end the upper bound of the range of profile skillses (not inclusive)
	 * @return the range of matching profile skillses
	 */
	public java.util.List<profileSkills> findByUuid(
		String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the profile skillses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>profileSkillsModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findByUuid(String, int, int, OrderByComparator)}
	 * @param uuid the uuid
	 * @param start the lower bound of the range of profile skillses
	 * @param end the upper bound of the range of profile skillses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching profile skillses
	 */
	@Deprecated
	public java.util.List<profileSkills> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<profileSkills> orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns an ordered range of all the profile skillses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>profileSkillsModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of profile skillses
	 * @param end the upper bound of the range of profile skillses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching profile skillses
	 */
	public java.util.List<profileSkills> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<profileSkills> orderByComparator);

	/**
	 * Returns the first profile skills in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching profile skills
	 * @throws NoSuchprofileSkillsException if a matching profile skills could not be found
	 */
	public profileSkills findByUuid_First(
			String uuid, OrderByComparator<profileSkills> orderByComparator)
		throws NoSuchprofileSkillsException;

	/**
	 * Returns the first profile skills in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching profile skills, or <code>null</code> if a matching profile skills could not be found
	 */
	public profileSkills fetchByUuid_First(
		String uuid, OrderByComparator<profileSkills> orderByComparator);

	/**
	 * Returns the last profile skills in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching profile skills
	 * @throws NoSuchprofileSkillsException if a matching profile skills could not be found
	 */
	public profileSkills findByUuid_Last(
			String uuid, OrderByComparator<profileSkills> orderByComparator)
		throws NoSuchprofileSkillsException;

	/**
	 * Returns the last profile skills in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching profile skills, or <code>null</code> if a matching profile skills could not be found
	 */
	public profileSkills fetchByUuid_Last(
		String uuid, OrderByComparator<profileSkills> orderByComparator);

	/**
	 * Returns the profile skillses before and after the current profile skills in the ordered set where uuid = &#63;.
	 *
	 * @param Id the primary key of the current profile skills
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next profile skills
	 * @throws NoSuchprofileSkillsException if a profile skills with the primary key could not be found
	 */
	public profileSkills[] findByUuid_PrevAndNext(
			long Id, String uuid,
			OrderByComparator<profileSkills> orderByComparator)
		throws NoSuchprofileSkillsException;

	/**
	 * Removes all the profile skillses where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of profile skillses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching profile skillses
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the profile skills where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchprofileSkillsException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching profile skills
	 * @throws NoSuchprofileSkillsException if a matching profile skills could not be found
	 */
	public profileSkills findByUUID_G(String uuid, long groupId)
		throws NoSuchprofileSkillsException;

	/**
	 * Returns the profile skills where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #fetchByUUID_G(String,long)}
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching profile skills, or <code>null</code> if a matching profile skills could not be found
	 */
	@Deprecated
	public profileSkills fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Returns the profile skills where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching profile skills, or <code>null</code> if a matching profile skills could not be found
	 */
	public profileSkills fetchByUUID_G(String uuid, long groupId);

	/**
	 * Removes the profile skills where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the profile skills that was removed
	 */
	public profileSkills removeByUUID_G(String uuid, long groupId)
		throws NoSuchprofileSkillsException;

	/**
	 * Returns the number of profile skillses where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching profile skillses
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the profile skillses where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching profile skillses
	 */
	public java.util.List<profileSkills> findByUuid_C(
		String uuid, long companyId);

	/**
	 * Returns a range of all the profile skillses where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>profileSkillsModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of profile skillses
	 * @param end the upper bound of the range of profile skillses (not inclusive)
	 * @return the range of matching profile skillses
	 */
	public java.util.List<profileSkills> findByUuid_C(
		String uuid, long companyId, int start, int end);

	/**
	 * Returns an ordered range of all the profile skillses where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>profileSkillsModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findByUuid_C(String,long, int, int, OrderByComparator)}
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of profile skillses
	 * @param end the upper bound of the range of profile skillses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching profile skillses
	 */
	@Deprecated
	public java.util.List<profileSkills> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<profileSkills> orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns an ordered range of all the profile skillses where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>profileSkillsModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of profile skillses
	 * @param end the upper bound of the range of profile skillses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching profile skillses
	 */
	public java.util.List<profileSkills> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<profileSkills> orderByComparator);

	/**
	 * Returns the first profile skills in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching profile skills
	 * @throws NoSuchprofileSkillsException if a matching profile skills could not be found
	 */
	public profileSkills findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<profileSkills> orderByComparator)
		throws NoSuchprofileSkillsException;

	/**
	 * Returns the first profile skills in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching profile skills, or <code>null</code> if a matching profile skills could not be found
	 */
	public profileSkills fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<profileSkills> orderByComparator);

	/**
	 * Returns the last profile skills in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching profile skills
	 * @throws NoSuchprofileSkillsException if a matching profile skills could not be found
	 */
	public profileSkills findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<profileSkills> orderByComparator)
		throws NoSuchprofileSkillsException;

	/**
	 * Returns the last profile skills in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching profile skills, or <code>null</code> if a matching profile skills could not be found
	 */
	public profileSkills fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<profileSkills> orderByComparator);

	/**
	 * Returns the profile skillses before and after the current profile skills in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param Id the primary key of the current profile skills
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next profile skills
	 * @throws NoSuchprofileSkillsException if a profile skills with the primary key could not be found
	 */
	public profileSkills[] findByUuid_C_PrevAndNext(
			long Id, String uuid, long companyId,
			OrderByComparator<profileSkills> orderByComparator)
		throws NoSuchprofileSkillsException;

	/**
	 * Removes all the profile skillses where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of profile skillses where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching profile skillses
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Caches the profile skills in the entity cache if it is enabled.
	 *
	 * @param profileSkills the profile skills
	 */
	public void cacheResult(profileSkills profileSkills);

	/**
	 * Caches the profile skillses in the entity cache if it is enabled.
	 *
	 * @param profileSkillses the profile skillses
	 */
	public void cacheResult(java.util.List<profileSkills> profileSkillses);

	/**
	 * Creates a new profile skills with the primary key. Does not add the profile skills to the database.
	 *
	 * @param Id the primary key for the new profile skills
	 * @return the new profile skills
	 */
	public profileSkills create(long Id);

	/**
	 * Removes the profile skills with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param Id the primary key of the profile skills
	 * @return the profile skills that was removed
	 * @throws NoSuchprofileSkillsException if a profile skills with the primary key could not be found
	 */
	public profileSkills remove(long Id) throws NoSuchprofileSkillsException;

	public profileSkills updateImpl(profileSkills profileSkills);

	/**
	 * Returns the profile skills with the primary key or throws a <code>NoSuchprofileSkillsException</code> if it could not be found.
	 *
	 * @param Id the primary key of the profile skills
	 * @return the profile skills
	 * @throws NoSuchprofileSkillsException if a profile skills with the primary key could not be found
	 */
	public profileSkills findByPrimaryKey(long Id)
		throws NoSuchprofileSkillsException;

	/**
	 * Returns the profile skills with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param Id the primary key of the profile skills
	 * @return the profile skills, or <code>null</code> if a profile skills with the primary key could not be found
	 */
	public profileSkills fetchByPrimaryKey(long Id);

	/**
	 * Returns all the profile skillses.
	 *
	 * @return the profile skillses
	 */
	public java.util.List<profileSkills> findAll();

	/**
	 * Returns a range of all the profile skillses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>profileSkillsModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of profile skillses
	 * @param end the upper bound of the range of profile skillses (not inclusive)
	 * @return the range of profile skillses
	 */
	public java.util.List<profileSkills> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the profile skillses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>profileSkillsModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findAll(int, int, OrderByComparator)}
	 * @param start the lower bound of the range of profile skillses
	 * @param end the upper bound of the range of profile skillses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of profile skillses
	 */
	@Deprecated
	public java.util.List<profileSkills> findAll(
		int start, int end, OrderByComparator<profileSkills> orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns an ordered range of all the profile skillses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>profileSkillsModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of profile skillses
	 * @param end the upper bound of the range of profile skillses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of profile skillses
	 */
	public java.util.List<profileSkills> findAll(
		int start, int end, OrderByComparator<profileSkills> orderByComparator);

	/**
	 * Removes all the profile skillses from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of profile skillses.
	 *
	 * @return the number of profile skillses
	 */
	public int countAll();

}