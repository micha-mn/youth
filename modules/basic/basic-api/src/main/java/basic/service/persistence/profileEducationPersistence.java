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

import basic.exception.NoSuchprofileEducationException;

import basic.model.profileEducation;

import com.liferay.portal.kernel.service.persistence.BasePersistence;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the profile education service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see profileEducationUtil
 * @generated
 */
@ProviderType
public interface profileEducationPersistence
	extends BasePersistence<profileEducation> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link profileEducationUtil} to access the profile education persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the profile educations where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching profile educations
	 */
	public java.util.List<profileEducation> findByUuid(String uuid);

	/**
	 * Returns a range of all the profile educations where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>profileEducationModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of profile educations
	 * @param end the upper bound of the range of profile educations (not inclusive)
	 * @return the range of matching profile educations
	 */
	public java.util.List<profileEducation> findByUuid(
		String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the profile educations where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>profileEducationModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findByUuid(String, int, int, OrderByComparator)}
	 * @param uuid the uuid
	 * @param start the lower bound of the range of profile educations
	 * @param end the upper bound of the range of profile educations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching profile educations
	 */
	@Deprecated
	public java.util.List<profileEducation> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<profileEducation> orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns an ordered range of all the profile educations where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>profileEducationModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of profile educations
	 * @param end the upper bound of the range of profile educations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching profile educations
	 */
	public java.util.List<profileEducation> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<profileEducation> orderByComparator);

	/**
	 * Returns the first profile education in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching profile education
	 * @throws NoSuchprofileEducationException if a matching profile education could not be found
	 */
	public profileEducation findByUuid_First(
			String uuid, OrderByComparator<profileEducation> orderByComparator)
		throws NoSuchprofileEducationException;

	/**
	 * Returns the first profile education in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching profile education, or <code>null</code> if a matching profile education could not be found
	 */
	public profileEducation fetchByUuid_First(
		String uuid, OrderByComparator<profileEducation> orderByComparator);

	/**
	 * Returns the last profile education in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching profile education
	 * @throws NoSuchprofileEducationException if a matching profile education could not be found
	 */
	public profileEducation findByUuid_Last(
			String uuid, OrderByComparator<profileEducation> orderByComparator)
		throws NoSuchprofileEducationException;

	/**
	 * Returns the last profile education in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching profile education, or <code>null</code> if a matching profile education could not be found
	 */
	public profileEducation fetchByUuid_Last(
		String uuid, OrderByComparator<profileEducation> orderByComparator);

	/**
	 * Returns the profile educations before and after the current profile education in the ordered set where uuid = &#63;.
	 *
	 * @param Id the primary key of the current profile education
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next profile education
	 * @throws NoSuchprofileEducationException if a profile education with the primary key could not be found
	 */
	public profileEducation[] findByUuid_PrevAndNext(
			long Id, String uuid,
			OrderByComparator<profileEducation> orderByComparator)
		throws NoSuchprofileEducationException;

	/**
	 * Removes all the profile educations where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of profile educations where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching profile educations
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the profile education where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchprofileEducationException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching profile education
	 * @throws NoSuchprofileEducationException if a matching profile education could not be found
	 */
	public profileEducation findByUUID_G(String uuid, long groupId)
		throws NoSuchprofileEducationException;

	/**
	 * Returns the profile education where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #fetchByUUID_G(String,long)}
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching profile education, or <code>null</code> if a matching profile education could not be found
	 */
	@Deprecated
	public profileEducation fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Returns the profile education where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching profile education, or <code>null</code> if a matching profile education could not be found
	 */
	public profileEducation fetchByUUID_G(String uuid, long groupId);

	/**
	 * Removes the profile education where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the profile education that was removed
	 */
	public profileEducation removeByUUID_G(String uuid, long groupId)
		throws NoSuchprofileEducationException;

	/**
	 * Returns the number of profile educations where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching profile educations
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the profile educations where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching profile educations
	 */
	public java.util.List<profileEducation> findByUuid_C(
		String uuid, long companyId);

	/**
	 * Returns a range of all the profile educations where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>profileEducationModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of profile educations
	 * @param end the upper bound of the range of profile educations (not inclusive)
	 * @return the range of matching profile educations
	 */
	public java.util.List<profileEducation> findByUuid_C(
		String uuid, long companyId, int start, int end);

	/**
	 * Returns an ordered range of all the profile educations where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>profileEducationModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findByUuid_C(String,long, int, int, OrderByComparator)}
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of profile educations
	 * @param end the upper bound of the range of profile educations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching profile educations
	 */
	@Deprecated
	public java.util.List<profileEducation> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<profileEducation> orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns an ordered range of all the profile educations where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>profileEducationModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of profile educations
	 * @param end the upper bound of the range of profile educations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching profile educations
	 */
	public java.util.List<profileEducation> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<profileEducation> orderByComparator);

	/**
	 * Returns the first profile education in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching profile education
	 * @throws NoSuchprofileEducationException if a matching profile education could not be found
	 */
	public profileEducation findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<profileEducation> orderByComparator)
		throws NoSuchprofileEducationException;

	/**
	 * Returns the first profile education in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching profile education, or <code>null</code> if a matching profile education could not be found
	 */
	public profileEducation fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<profileEducation> orderByComparator);

	/**
	 * Returns the last profile education in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching profile education
	 * @throws NoSuchprofileEducationException if a matching profile education could not be found
	 */
	public profileEducation findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<profileEducation> orderByComparator)
		throws NoSuchprofileEducationException;

	/**
	 * Returns the last profile education in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching profile education, or <code>null</code> if a matching profile education could not be found
	 */
	public profileEducation fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<profileEducation> orderByComparator);

	/**
	 * Returns the profile educations before and after the current profile education in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param Id the primary key of the current profile education
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next profile education
	 * @throws NoSuchprofileEducationException if a profile education with the primary key could not be found
	 */
	public profileEducation[] findByUuid_C_PrevAndNext(
			long Id, String uuid, long companyId,
			OrderByComparator<profileEducation> orderByComparator)
		throws NoSuchprofileEducationException;

	/**
	 * Removes all the profile educations where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of profile educations where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching profile educations
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Caches the profile education in the entity cache if it is enabled.
	 *
	 * @param profileEducation the profile education
	 */
	public void cacheResult(profileEducation profileEducation);

	/**
	 * Caches the profile educations in the entity cache if it is enabled.
	 *
	 * @param profileEducations the profile educations
	 */
	public void cacheResult(java.util.List<profileEducation> profileEducations);

	/**
	 * Creates a new profile education with the primary key. Does not add the profile education to the database.
	 *
	 * @param Id the primary key for the new profile education
	 * @return the new profile education
	 */
	public profileEducation create(long Id);

	/**
	 * Removes the profile education with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param Id the primary key of the profile education
	 * @return the profile education that was removed
	 * @throws NoSuchprofileEducationException if a profile education with the primary key could not be found
	 */
	public profileEducation remove(long Id)
		throws NoSuchprofileEducationException;

	public profileEducation updateImpl(profileEducation profileEducation);

	/**
	 * Returns the profile education with the primary key or throws a <code>NoSuchprofileEducationException</code> if it could not be found.
	 *
	 * @param Id the primary key of the profile education
	 * @return the profile education
	 * @throws NoSuchprofileEducationException if a profile education with the primary key could not be found
	 */
	public profileEducation findByPrimaryKey(long Id)
		throws NoSuchprofileEducationException;

	/**
	 * Returns the profile education with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param Id the primary key of the profile education
	 * @return the profile education, or <code>null</code> if a profile education with the primary key could not be found
	 */
	public profileEducation fetchByPrimaryKey(long Id);

	/**
	 * Returns all the profile educations.
	 *
	 * @return the profile educations
	 */
	public java.util.List<profileEducation> findAll();

	/**
	 * Returns a range of all the profile educations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>profileEducationModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of profile educations
	 * @param end the upper bound of the range of profile educations (not inclusive)
	 * @return the range of profile educations
	 */
	public java.util.List<profileEducation> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the profile educations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>profileEducationModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findAll(int, int, OrderByComparator)}
	 * @param start the lower bound of the range of profile educations
	 * @param end the upper bound of the range of profile educations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of profile educations
	 */
	@Deprecated
	public java.util.List<profileEducation> findAll(
		int start, int end,
		OrderByComparator<profileEducation> orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns an ordered range of all the profile educations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>profileEducationModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of profile educations
	 * @param end the upper bound of the range of profile educations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of profile educations
	 */
	public java.util.List<profileEducation> findAll(
		int start, int end,
		OrderByComparator<profileEducation> orderByComparator);

	/**
	 * Removes all the profile educations from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of profile educations.
	 *
	 * @return the number of profile educations
	 */
	public int countAll();

}