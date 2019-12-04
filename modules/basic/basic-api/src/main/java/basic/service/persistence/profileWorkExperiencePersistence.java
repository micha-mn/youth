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

import basic.exception.NoSuchprofileWorkExperienceException;

import basic.model.profileWorkExperience;

import com.liferay.portal.kernel.service.persistence.BasePersistence;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the profile work experience service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see profileWorkExperienceUtil
 * @generated
 */
@ProviderType
public interface profileWorkExperiencePersistence
	extends BasePersistence<profileWorkExperience> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link profileWorkExperienceUtil} to access the profile work experience persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the profile work experiences where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching profile work experiences
	 */
	public java.util.List<profileWorkExperience> findByUuid(String uuid);

	/**
	 * Returns a range of all the profile work experiences where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>profileWorkExperienceModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of profile work experiences
	 * @param end the upper bound of the range of profile work experiences (not inclusive)
	 * @return the range of matching profile work experiences
	 */
	public java.util.List<profileWorkExperience> findByUuid(
		String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the profile work experiences where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>profileWorkExperienceModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findByUuid(String, int, int, OrderByComparator)}
	 * @param uuid the uuid
	 * @param start the lower bound of the range of profile work experiences
	 * @param end the upper bound of the range of profile work experiences (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching profile work experiences
	 */
	@Deprecated
	public java.util.List<profileWorkExperience> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<profileWorkExperience> orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns an ordered range of all the profile work experiences where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>profileWorkExperienceModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of profile work experiences
	 * @param end the upper bound of the range of profile work experiences (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching profile work experiences
	 */
	public java.util.List<profileWorkExperience> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<profileWorkExperience> orderByComparator);

	/**
	 * Returns the first profile work experience in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching profile work experience
	 * @throws NoSuchprofileWorkExperienceException if a matching profile work experience could not be found
	 */
	public profileWorkExperience findByUuid_First(
			String uuid,
			OrderByComparator<profileWorkExperience> orderByComparator)
		throws NoSuchprofileWorkExperienceException;

	/**
	 * Returns the first profile work experience in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching profile work experience, or <code>null</code> if a matching profile work experience could not be found
	 */
	public profileWorkExperience fetchByUuid_First(
		String uuid,
		OrderByComparator<profileWorkExperience> orderByComparator);

	/**
	 * Returns the last profile work experience in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching profile work experience
	 * @throws NoSuchprofileWorkExperienceException if a matching profile work experience could not be found
	 */
	public profileWorkExperience findByUuid_Last(
			String uuid,
			OrderByComparator<profileWorkExperience> orderByComparator)
		throws NoSuchprofileWorkExperienceException;

	/**
	 * Returns the last profile work experience in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching profile work experience, or <code>null</code> if a matching profile work experience could not be found
	 */
	public profileWorkExperience fetchByUuid_Last(
		String uuid,
		OrderByComparator<profileWorkExperience> orderByComparator);

	/**
	 * Returns the profile work experiences before and after the current profile work experience in the ordered set where uuid = &#63;.
	 *
	 * @param Id the primary key of the current profile work experience
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next profile work experience
	 * @throws NoSuchprofileWorkExperienceException if a profile work experience with the primary key could not be found
	 */
	public profileWorkExperience[] findByUuid_PrevAndNext(
			long Id, String uuid,
			OrderByComparator<profileWorkExperience> orderByComparator)
		throws NoSuchprofileWorkExperienceException;

	/**
	 * Removes all the profile work experiences where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of profile work experiences where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching profile work experiences
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the profile work experience where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchprofileWorkExperienceException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching profile work experience
	 * @throws NoSuchprofileWorkExperienceException if a matching profile work experience could not be found
	 */
	public profileWorkExperience findByUUID_G(String uuid, long groupId)
		throws NoSuchprofileWorkExperienceException;

	/**
	 * Returns the profile work experience where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #fetchByUUID_G(String,long)}
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching profile work experience, or <code>null</code> if a matching profile work experience could not be found
	 */
	@Deprecated
	public profileWorkExperience fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Returns the profile work experience where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching profile work experience, or <code>null</code> if a matching profile work experience could not be found
	 */
	public profileWorkExperience fetchByUUID_G(String uuid, long groupId);

	/**
	 * Removes the profile work experience where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the profile work experience that was removed
	 */
	public profileWorkExperience removeByUUID_G(String uuid, long groupId)
		throws NoSuchprofileWorkExperienceException;

	/**
	 * Returns the number of profile work experiences where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching profile work experiences
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the profile work experiences where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching profile work experiences
	 */
	public java.util.List<profileWorkExperience> findByUuid_C(
		String uuid, long companyId);

	/**
	 * Returns a range of all the profile work experiences where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>profileWorkExperienceModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of profile work experiences
	 * @param end the upper bound of the range of profile work experiences (not inclusive)
	 * @return the range of matching profile work experiences
	 */
	public java.util.List<profileWorkExperience> findByUuid_C(
		String uuid, long companyId, int start, int end);

	/**
	 * Returns an ordered range of all the profile work experiences where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>profileWorkExperienceModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findByUuid_C(String,long, int, int, OrderByComparator)}
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of profile work experiences
	 * @param end the upper bound of the range of profile work experiences (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching profile work experiences
	 */
	@Deprecated
	public java.util.List<profileWorkExperience> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<profileWorkExperience> orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns an ordered range of all the profile work experiences where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>profileWorkExperienceModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of profile work experiences
	 * @param end the upper bound of the range of profile work experiences (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching profile work experiences
	 */
	public java.util.List<profileWorkExperience> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<profileWorkExperience> orderByComparator);

	/**
	 * Returns the first profile work experience in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching profile work experience
	 * @throws NoSuchprofileWorkExperienceException if a matching profile work experience could not be found
	 */
	public profileWorkExperience findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<profileWorkExperience> orderByComparator)
		throws NoSuchprofileWorkExperienceException;

	/**
	 * Returns the first profile work experience in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching profile work experience, or <code>null</code> if a matching profile work experience could not be found
	 */
	public profileWorkExperience fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<profileWorkExperience> orderByComparator);

	/**
	 * Returns the last profile work experience in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching profile work experience
	 * @throws NoSuchprofileWorkExperienceException if a matching profile work experience could not be found
	 */
	public profileWorkExperience findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<profileWorkExperience> orderByComparator)
		throws NoSuchprofileWorkExperienceException;

	/**
	 * Returns the last profile work experience in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching profile work experience, or <code>null</code> if a matching profile work experience could not be found
	 */
	public profileWorkExperience fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<profileWorkExperience> orderByComparator);

	/**
	 * Returns the profile work experiences before and after the current profile work experience in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param Id the primary key of the current profile work experience
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next profile work experience
	 * @throws NoSuchprofileWorkExperienceException if a profile work experience with the primary key could not be found
	 */
	public profileWorkExperience[] findByUuid_C_PrevAndNext(
			long Id, String uuid, long companyId,
			OrderByComparator<profileWorkExperience> orderByComparator)
		throws NoSuchprofileWorkExperienceException;

	/**
	 * Removes all the profile work experiences where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of profile work experiences where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching profile work experiences
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Caches the profile work experience in the entity cache if it is enabled.
	 *
	 * @param profileWorkExperience the profile work experience
	 */
	public void cacheResult(profileWorkExperience profileWorkExperience);

	/**
	 * Caches the profile work experiences in the entity cache if it is enabled.
	 *
	 * @param profileWorkExperiences the profile work experiences
	 */
	public void cacheResult(
		java.util.List<profileWorkExperience> profileWorkExperiences);

	/**
	 * Creates a new profile work experience with the primary key. Does not add the profile work experience to the database.
	 *
	 * @param Id the primary key for the new profile work experience
	 * @return the new profile work experience
	 */
	public profileWorkExperience create(long Id);

	/**
	 * Removes the profile work experience with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param Id the primary key of the profile work experience
	 * @return the profile work experience that was removed
	 * @throws NoSuchprofileWorkExperienceException if a profile work experience with the primary key could not be found
	 */
	public profileWorkExperience remove(long Id)
		throws NoSuchprofileWorkExperienceException;

	public profileWorkExperience updateImpl(
		profileWorkExperience profileWorkExperience);

	/**
	 * Returns the profile work experience with the primary key or throws a <code>NoSuchprofileWorkExperienceException</code> if it could not be found.
	 *
	 * @param Id the primary key of the profile work experience
	 * @return the profile work experience
	 * @throws NoSuchprofileWorkExperienceException if a profile work experience with the primary key could not be found
	 */
	public profileWorkExperience findByPrimaryKey(long Id)
		throws NoSuchprofileWorkExperienceException;

	/**
	 * Returns the profile work experience with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param Id the primary key of the profile work experience
	 * @return the profile work experience, or <code>null</code> if a profile work experience with the primary key could not be found
	 */
	public profileWorkExperience fetchByPrimaryKey(long Id);

	/**
	 * Returns all the profile work experiences.
	 *
	 * @return the profile work experiences
	 */
	public java.util.List<profileWorkExperience> findAll();

	/**
	 * Returns a range of all the profile work experiences.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>profileWorkExperienceModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of profile work experiences
	 * @param end the upper bound of the range of profile work experiences (not inclusive)
	 * @return the range of profile work experiences
	 */
	public java.util.List<profileWorkExperience> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the profile work experiences.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>profileWorkExperienceModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findAll(int, int, OrderByComparator)}
	 * @param start the lower bound of the range of profile work experiences
	 * @param end the upper bound of the range of profile work experiences (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of profile work experiences
	 */
	@Deprecated
	public java.util.List<profileWorkExperience> findAll(
		int start, int end,
		OrderByComparator<profileWorkExperience> orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns an ordered range of all the profile work experiences.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>profileWorkExperienceModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of profile work experiences
	 * @param end the upper bound of the range of profile work experiences (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of profile work experiences
	 */
	public java.util.List<profileWorkExperience> findAll(
		int start, int end,
		OrderByComparator<profileWorkExperience> orderByComparator);

	/**
	 * Removes all the profile work experiences from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of profile work experiences.
	 *
	 * @return the number of profile work experiences
	 */
	public int countAll();

}