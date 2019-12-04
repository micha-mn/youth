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

import basic.exception.NoSuchprofileLicensesCertificationsException;

import basic.model.profileLicensesCertifications;

import com.liferay.portal.kernel.service.persistence.BasePersistence;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the profile licenses certifications service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see profileLicensesCertificationsUtil
 * @generated
 */
@ProviderType
public interface profileLicensesCertificationsPersistence
	extends BasePersistence<profileLicensesCertifications> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link profileLicensesCertificationsUtil} to access the profile licenses certifications persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the profile licenses certificationses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching profile licenses certificationses
	 */
	public java.util.List<profileLicensesCertifications> findByUuid(
		String uuid);

	/**
	 * Returns a range of all the profile licenses certificationses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>profileLicensesCertificationsModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of profile licenses certificationses
	 * @param end the upper bound of the range of profile licenses certificationses (not inclusive)
	 * @return the range of matching profile licenses certificationses
	 */
	public java.util.List<profileLicensesCertifications> findByUuid(
		String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the profile licenses certificationses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>profileLicensesCertificationsModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findByUuid(String, int, int, OrderByComparator)}
	 * @param uuid the uuid
	 * @param start the lower bound of the range of profile licenses certificationses
	 * @param end the upper bound of the range of profile licenses certificationses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching profile licenses certificationses
	 */
	@Deprecated
	public java.util.List<profileLicensesCertifications> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<profileLicensesCertifications> orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns an ordered range of all the profile licenses certificationses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>profileLicensesCertificationsModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of profile licenses certificationses
	 * @param end the upper bound of the range of profile licenses certificationses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching profile licenses certificationses
	 */
	public java.util.List<profileLicensesCertifications> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<profileLicensesCertifications> orderByComparator);

	/**
	 * Returns the first profile licenses certifications in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching profile licenses certifications
	 * @throws NoSuchprofileLicensesCertificationsException if a matching profile licenses certifications could not be found
	 */
	public profileLicensesCertifications findByUuid_First(
			String uuid,
			OrderByComparator<profileLicensesCertifications> orderByComparator)
		throws NoSuchprofileLicensesCertificationsException;

	/**
	 * Returns the first profile licenses certifications in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching profile licenses certifications, or <code>null</code> if a matching profile licenses certifications could not be found
	 */
	public profileLicensesCertifications fetchByUuid_First(
		String uuid,
		OrderByComparator<profileLicensesCertifications> orderByComparator);

	/**
	 * Returns the last profile licenses certifications in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching profile licenses certifications
	 * @throws NoSuchprofileLicensesCertificationsException if a matching profile licenses certifications could not be found
	 */
	public profileLicensesCertifications findByUuid_Last(
			String uuid,
			OrderByComparator<profileLicensesCertifications> orderByComparator)
		throws NoSuchprofileLicensesCertificationsException;

	/**
	 * Returns the last profile licenses certifications in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching profile licenses certifications, or <code>null</code> if a matching profile licenses certifications could not be found
	 */
	public profileLicensesCertifications fetchByUuid_Last(
		String uuid,
		OrderByComparator<profileLicensesCertifications> orderByComparator);

	/**
	 * Returns the profile licenses certificationses before and after the current profile licenses certifications in the ordered set where uuid = &#63;.
	 *
	 * @param Id the primary key of the current profile licenses certifications
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next profile licenses certifications
	 * @throws NoSuchprofileLicensesCertificationsException if a profile licenses certifications with the primary key could not be found
	 */
	public profileLicensesCertifications[] findByUuid_PrevAndNext(
			long Id, String uuid,
			OrderByComparator<profileLicensesCertifications> orderByComparator)
		throws NoSuchprofileLicensesCertificationsException;

	/**
	 * Removes all the profile licenses certificationses where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of profile licenses certificationses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching profile licenses certificationses
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the profile licenses certifications where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchprofileLicensesCertificationsException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching profile licenses certifications
	 * @throws NoSuchprofileLicensesCertificationsException if a matching profile licenses certifications could not be found
	 */
	public profileLicensesCertifications findByUUID_G(String uuid, long groupId)
		throws NoSuchprofileLicensesCertificationsException;

	/**
	 * Returns the profile licenses certifications where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #fetchByUUID_G(String,long)}
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching profile licenses certifications, or <code>null</code> if a matching profile licenses certifications could not be found
	 */
	@Deprecated
	public profileLicensesCertifications fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Returns the profile licenses certifications where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching profile licenses certifications, or <code>null</code> if a matching profile licenses certifications could not be found
	 */
	public profileLicensesCertifications fetchByUUID_G(
		String uuid, long groupId);

	/**
	 * Removes the profile licenses certifications where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the profile licenses certifications that was removed
	 */
	public profileLicensesCertifications removeByUUID_G(
			String uuid, long groupId)
		throws NoSuchprofileLicensesCertificationsException;

	/**
	 * Returns the number of profile licenses certificationses where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching profile licenses certificationses
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the profile licenses certificationses where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching profile licenses certificationses
	 */
	public java.util.List<profileLicensesCertifications> findByUuid_C(
		String uuid, long companyId);

	/**
	 * Returns a range of all the profile licenses certificationses where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>profileLicensesCertificationsModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of profile licenses certificationses
	 * @param end the upper bound of the range of profile licenses certificationses (not inclusive)
	 * @return the range of matching profile licenses certificationses
	 */
	public java.util.List<profileLicensesCertifications> findByUuid_C(
		String uuid, long companyId, int start, int end);

	/**
	 * Returns an ordered range of all the profile licenses certificationses where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>profileLicensesCertificationsModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findByUuid_C(String,long, int, int, OrderByComparator)}
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of profile licenses certificationses
	 * @param end the upper bound of the range of profile licenses certificationses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching profile licenses certificationses
	 */
	@Deprecated
	public java.util.List<profileLicensesCertifications> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<profileLicensesCertifications> orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns an ordered range of all the profile licenses certificationses where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>profileLicensesCertificationsModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of profile licenses certificationses
	 * @param end the upper bound of the range of profile licenses certificationses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching profile licenses certificationses
	 */
	public java.util.List<profileLicensesCertifications> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<profileLicensesCertifications> orderByComparator);

	/**
	 * Returns the first profile licenses certifications in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching profile licenses certifications
	 * @throws NoSuchprofileLicensesCertificationsException if a matching profile licenses certifications could not be found
	 */
	public profileLicensesCertifications findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<profileLicensesCertifications> orderByComparator)
		throws NoSuchprofileLicensesCertificationsException;

	/**
	 * Returns the first profile licenses certifications in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching profile licenses certifications, or <code>null</code> if a matching profile licenses certifications could not be found
	 */
	public profileLicensesCertifications fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<profileLicensesCertifications> orderByComparator);

	/**
	 * Returns the last profile licenses certifications in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching profile licenses certifications
	 * @throws NoSuchprofileLicensesCertificationsException if a matching profile licenses certifications could not be found
	 */
	public profileLicensesCertifications findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<profileLicensesCertifications> orderByComparator)
		throws NoSuchprofileLicensesCertificationsException;

	/**
	 * Returns the last profile licenses certifications in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching profile licenses certifications, or <code>null</code> if a matching profile licenses certifications could not be found
	 */
	public profileLicensesCertifications fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<profileLicensesCertifications> orderByComparator);

	/**
	 * Returns the profile licenses certificationses before and after the current profile licenses certifications in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param Id the primary key of the current profile licenses certifications
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next profile licenses certifications
	 * @throws NoSuchprofileLicensesCertificationsException if a profile licenses certifications with the primary key could not be found
	 */
	public profileLicensesCertifications[] findByUuid_C_PrevAndNext(
			long Id, String uuid, long companyId,
			OrderByComparator<profileLicensesCertifications> orderByComparator)
		throws NoSuchprofileLicensesCertificationsException;

	/**
	 * Removes all the profile licenses certificationses where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of profile licenses certificationses where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching profile licenses certificationses
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Caches the profile licenses certifications in the entity cache if it is enabled.
	 *
	 * @param profileLicensesCertifications the profile licenses certifications
	 */
	public void cacheResult(
		profileLicensesCertifications profileLicensesCertifications);

	/**
	 * Caches the profile licenses certificationses in the entity cache if it is enabled.
	 *
	 * @param profileLicensesCertificationses the profile licenses certificationses
	 */
	public void cacheResult(
		java.util.List<profileLicensesCertifications>
			profileLicensesCertificationses);

	/**
	 * Creates a new profile licenses certifications with the primary key. Does not add the profile licenses certifications to the database.
	 *
	 * @param Id the primary key for the new profile licenses certifications
	 * @return the new profile licenses certifications
	 */
	public profileLicensesCertifications create(long Id);

	/**
	 * Removes the profile licenses certifications with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param Id the primary key of the profile licenses certifications
	 * @return the profile licenses certifications that was removed
	 * @throws NoSuchprofileLicensesCertificationsException if a profile licenses certifications with the primary key could not be found
	 */
	public profileLicensesCertifications remove(long Id)
		throws NoSuchprofileLicensesCertificationsException;

	public profileLicensesCertifications updateImpl(
		profileLicensesCertifications profileLicensesCertifications);

	/**
	 * Returns the profile licenses certifications with the primary key or throws a <code>NoSuchprofileLicensesCertificationsException</code> if it could not be found.
	 *
	 * @param Id the primary key of the profile licenses certifications
	 * @return the profile licenses certifications
	 * @throws NoSuchprofileLicensesCertificationsException if a profile licenses certifications with the primary key could not be found
	 */
	public profileLicensesCertifications findByPrimaryKey(long Id)
		throws NoSuchprofileLicensesCertificationsException;

	/**
	 * Returns the profile licenses certifications with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param Id the primary key of the profile licenses certifications
	 * @return the profile licenses certifications, or <code>null</code> if a profile licenses certifications with the primary key could not be found
	 */
	public profileLicensesCertifications fetchByPrimaryKey(long Id);

	/**
	 * Returns all the profile licenses certificationses.
	 *
	 * @return the profile licenses certificationses
	 */
	public java.util.List<profileLicensesCertifications> findAll();

	/**
	 * Returns a range of all the profile licenses certificationses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>profileLicensesCertificationsModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of profile licenses certificationses
	 * @param end the upper bound of the range of profile licenses certificationses (not inclusive)
	 * @return the range of profile licenses certificationses
	 */
	public java.util.List<profileLicensesCertifications> findAll(
		int start, int end);

	/**
	 * Returns an ordered range of all the profile licenses certificationses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>profileLicensesCertificationsModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findAll(int, int, OrderByComparator)}
	 * @param start the lower bound of the range of profile licenses certificationses
	 * @param end the upper bound of the range of profile licenses certificationses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of profile licenses certificationses
	 */
	@Deprecated
	public java.util.List<profileLicensesCertifications> findAll(
		int start, int end,
		OrderByComparator<profileLicensesCertifications> orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns an ordered range of all the profile licenses certificationses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>profileLicensesCertificationsModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of profile licenses certificationses
	 * @param end the upper bound of the range of profile licenses certificationses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of profile licenses certificationses
	 */
	public java.util.List<profileLicensesCertifications> findAll(
		int start, int end,
		OrderByComparator<profileLicensesCertifications> orderByComparator);

	/**
	 * Removes all the profile licenses certificationses from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of profile licenses certificationses.
	 *
	 * @return the number of profile licenses certificationses
	 */
	public int countAll();

}